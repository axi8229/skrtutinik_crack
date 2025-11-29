package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.yandex.varioqub.config.model.ConfigValue;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import ru.yoomoney.sdk.yooprofiler.YooProfilerImpl;

/* loaded from: classes2.dex */
public class AdaptiveTrackSelection extends BaseTrackSelection {
    private final BandwidthProvider bandwidthProvider;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private final long minTimeBetweenBufferReevaluationMs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    private interface BandwidthProvider {
        long getAllocatedBandwidth();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public Object getSelectionData() {
        return null;
    }

    public static class Factory implements TrackSelection.Factory {
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;
        private final long minTimeBetweenBufferReevaluationMs;

        public Factory() {
            this(10000, 25000, 25000, 0.7f, 0.75f, YooProfilerImpl.TIMER_LIMIT, Clock.DEFAULT);
        }

        public Factory(int minDurationForQualityIncreaseMs, int maxDurationForQualityDecreaseMs, int minDurationToRetainAfterDiscardMs, float bandwidthFraction, float bufferedFractionToLiveEdgeForQualityIncrease, long minTimeBetweenBufferReevaluationMs, Clock clock) {
            this(null, minDurationForQualityIncreaseMs, maxDurationForQualityDecreaseMs, minDurationToRetainAfterDiscardMs, bandwidthFraction, bufferedFractionToLiveEdgeForQualityIncrease, minTimeBetweenBufferReevaluationMs, clock);
        }

        @Deprecated
        public Factory(BandwidthMeter bandwidthMeter, int minDurationForQualityIncreaseMs, int maxDurationForQualityDecreaseMs, int minDurationToRetainAfterDiscardMs, float bandwidthFraction, float bufferedFractionToLiveEdgeForQualityIncrease, long minTimeBetweenBufferReevaluationMs, Clock clock) {
            this.bandwidthMeter = bandwidthMeter;
            this.minDurationForQualityIncreaseMs = minDurationForQualityIncreaseMs;
            this.maxDurationForQualityDecreaseMs = maxDurationForQualityDecreaseMs;
            this.minDurationToRetainAfterDiscardMs = minDurationToRetainAfterDiscardMs;
            this.bandwidthFraction = bandwidthFraction;
            this.bufferedFractionToLiveEdgeForQualityIncrease = bufferedFractionToLiveEdgeForQualityIncrease;
            this.minTimeBetweenBufferReevaluationMs = minTimeBetweenBufferReevaluationMs;
            this.clock = clock;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public final TrackSelection[] createTrackSelections(TrackSelection.Definition[] definitions, BandwidthMeter bandwidthMeter) {
            BandwidthMeter bandwidthMeter2 = this.bandwidthMeter;
            if (bandwidthMeter2 != null) {
                bandwidthMeter = bandwidthMeter2;
            }
            TrackSelection[] trackSelectionArr = new TrackSelection[definitions.length];
            int i = 0;
            for (int i2 = 0; i2 < definitions.length; i2++) {
                TrackSelection.Definition definition = definitions[i2];
                if (definition != null) {
                    int[] iArr = definition.tracks;
                    if (iArr.length == 1) {
                        trackSelectionArr[i2] = new FixedTrackSelection(definition.group, iArr[0], definition.reason, definition.data);
                        int i3 = definition.group.getFormat(definition.tracks[0]).bitrate;
                        if (i3 != -1) {
                            i += i3;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < definitions.length; i4++) {
                TrackSelection.Definition definition2 = definitions[i4];
                if (definition2 != null) {
                    int[] iArr2 = definition2.tracks;
                    if (iArr2.length > 1) {
                        AdaptiveTrackSelection adaptiveTrackSelectionCreateAdaptiveTrackSelection = createAdaptiveTrackSelection(definition2.group, bandwidthMeter, iArr2, i);
                        arrayList.add(adaptiveTrackSelectionCreateAdaptiveTrackSelection);
                        trackSelectionArr[i4] = adaptiveTrackSelectionCreateAdaptiveTrackSelection;
                    }
                }
            }
            if (arrayList.size() > 1) {
                long[][] jArr = new long[arrayList.size()][];
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    AdaptiveTrackSelection adaptiveTrackSelection = (AdaptiveTrackSelection) arrayList.get(i5);
                    jArr[i5] = new long[adaptiveTrackSelection.length()];
                    for (int i6 = 0; i6 < adaptiveTrackSelection.length(); i6++) {
                        jArr[i5][i6] = adaptiveTrackSelection.getFormat((adaptiveTrackSelection.length() - i6) - 1).bitrate;
                    }
                }
                long[][][] allocationCheckpoints = AdaptiveTrackSelection.getAllocationCheckpoints(jArr);
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    ((AdaptiveTrackSelection) arrayList.get(i7)).experimental_setBandwidthAllocationCheckpoints(allocationCheckpoints[i7]);
                }
            }
            return trackSelectionArr;
        }

        protected AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup group, BandwidthMeter bandwidthMeter, int[] tracks, int totalFixedTrackBandwidth) {
            return new AdaptiveTrackSelection(group, tracks, new DefaultBandwidthProvider(bandwidthMeter, this.bandwidthFraction, totalFixedTrackBandwidth), this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.bufferedFractionToLiveEdgeForQualityIncrease, this.minTimeBetweenBufferReevaluationMs, this.clock);
        }
    }

    private AdaptiveTrackSelection(TrackGroup group, int[] tracks, BandwidthProvider bandwidthProvider, long minDurationForQualityIncreaseMs, long maxDurationForQualityDecreaseMs, long minDurationToRetainAfterDiscardMs, float bufferedFractionToLiveEdgeForQualityIncrease, long minTimeBetweenBufferReevaluationMs, Clock clock) {
        super(group, tracks);
        this.bandwidthProvider = bandwidthProvider;
        this.minDurationForQualityIncreaseUs = minDurationForQualityIncreaseMs * 1000;
        this.maxDurationForQualityDecreaseUs = maxDurationForQualityDecreaseMs * 1000;
        this.minDurationToRetainAfterDiscardUs = minDurationToRetainAfterDiscardMs * 1000;
        this.bufferedFractionToLiveEdgeForQualityIncrease = bufferedFractionToLiveEdgeForQualityIncrease;
        this.minTimeBetweenBufferReevaluationMs = minTimeBetweenBufferReevaluationMs;
        this.clock = clock;
        this.playbackSpeed = 1.0f;
        this.reason = 0;
        this.lastBufferEvaluationMs = -9223372036854775807L;
    }

    public void experimental_setBandwidthAllocationCheckpoints(long[][] allocationCheckpoints) {
        ((DefaultBandwidthProvider) this.bandwidthProvider).experimental_setBandwidthAllocationCheckpoints(allocationCheckpoints);
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public void enable() {
        this.lastBufferEvaluationMs = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public void onPlaybackSpeed(float playbackSpeed) {
        this.playbackSpeed = playbackSpeed;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long playbackPositionUs, long bufferedDurationUs, long availableDurationUs, List<? extends MediaChunk> queue, MediaChunkIterator[] mediaChunkIterators) {
        long jElapsedRealtime = this.clock.elapsedRealtime();
        if (this.reason == 0) {
            this.reason = 1;
            this.selectedIndex = determineIdealSelectedIndex(jElapsedRealtime);
            return;
        }
        int i = this.selectedIndex;
        int iDetermineIdealSelectedIndex = determineIdealSelectedIndex(jElapsedRealtime);
        this.selectedIndex = iDetermineIdealSelectedIndex;
        if (iDetermineIdealSelectedIndex == i) {
            return;
        }
        if (!isBlacklisted(i, jElapsedRealtime)) {
            Format format = getFormat(i);
            Format format2 = getFormat(this.selectedIndex);
            if (format2.bitrate > format.bitrate && bufferedDurationUs < minDurationForQualityIncreaseUs(availableDurationUs)) {
                this.selectedIndex = i;
            } else if (format2.bitrate < format.bitrate && bufferedDurationUs >= this.maxDurationForQualityDecreaseUs) {
                this.selectedIndex = i;
            }
        }
        if (this.selectedIndex != i) {
            this.reason = 3;
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long playbackPositionUs, List<? extends MediaChunk> queue) {
        int i;
        int i2;
        long jElapsedRealtime = this.clock.elapsedRealtime();
        if (!shouldEvaluateQueueSize(jElapsedRealtime)) {
            return queue.size();
        }
        this.lastBufferEvaluationMs = jElapsedRealtime;
        if (queue.isEmpty()) {
            return 0;
        }
        int size = queue.size();
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(queue.get(size - 1).startTimeUs - playbackPositionUs, this.playbackSpeed);
        long minDurationToRetainAfterDiscardUs = getMinDurationToRetainAfterDiscardUs();
        if (playoutDurationForMediaDuration < minDurationToRetainAfterDiscardUs) {
            return size;
        }
        Format format = getFormat(determineIdealSelectedIndex(jElapsedRealtime));
        for (int i3 = 0; i3 < size; i3++) {
            MediaChunk mediaChunk = queue.get(i3);
            Format format2 = mediaChunk.trackFormat;
            if (Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - playbackPositionUs, this.playbackSpeed) >= minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i = format2.height) != -1 && i < 720 && (i2 = format2.width) != -1 && i2 < 1280 && i < format.height) {
                return i3;
            }
        }
        return size;
    }

    protected boolean canSelectFormat(Format format, int trackBitrate, float playbackSpeed, long effectiveBitrate) {
        return ((long) Math.round(((float) trackBitrate) * playbackSpeed)) <= effectiveBitrate;
    }

    protected boolean shouldEvaluateQueueSize(long nowMs) {
        long j = this.lastBufferEvaluationMs;
        return j == -9223372036854775807L || nowMs - j >= this.minTimeBetweenBufferReevaluationMs;
    }

    protected long getMinDurationToRetainAfterDiscardUs() {
        return this.minDurationToRetainAfterDiscardUs;
    }

    private int determineIdealSelectedIndex(long nowMs) {
        long allocatedBandwidth = this.bandwidthProvider.getAllocatedBandwidth();
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (nowMs == Long.MIN_VALUE || !isBlacklisted(i2, nowMs)) {
                Format format = getFormat(i2);
                if (canSelectFormat(format, format.bitrate, this.playbackSpeed, allocatedBandwidth)) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long minDurationForQualityIncreaseUs(long availableDurationUs) {
        return (availableDurationUs == -9223372036854775807L || availableDurationUs > this.minDurationForQualityIncreaseUs) ? this.minDurationForQualityIncreaseUs : (long) (availableDurationUs * this.bufferedFractionToLiveEdgeForQualityIncrease);
    }

    private static final class DefaultBandwidthProvider implements BandwidthProvider {
        private long[][] allocationCheckpoints;
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final long reservedBandwidth;

        DefaultBandwidthProvider(BandwidthMeter bandwidthMeter, float bandwidthFraction, long reservedBandwidth) {
            this.bandwidthMeter = bandwidthMeter;
            this.bandwidthFraction = bandwidthFraction;
            this.reservedBandwidth = reservedBandwidth;
        }

        @Override // com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.BandwidthProvider
        public long getAllocatedBandwidth() {
            long[][] jArr;
            long jMax = Math.max(0L, ((long) (this.bandwidthMeter.getBitrateEstimate() * this.bandwidthFraction)) - this.reservedBandwidth);
            if (this.allocationCheckpoints == null) {
                return jMax;
            }
            int i = 1;
            while (true) {
                jArr = this.allocationCheckpoints;
                if (i >= jArr.length - 1 || jArr[i][0] >= jMax) {
                    break;
                }
                i++;
            }
            long[] jArr2 = jArr[i - 1];
            long[] jArr3 = jArr[i];
            long j = jArr2[0];
            float f = (jMax - j) / (jArr3[0] - j);
            return jArr2[1] + ((long) (f * (jArr3[1] - r4)));
        }

        void experimental_setBandwidthAllocationCheckpoints(long[][] allocationCheckpoints) {
            Assertions.checkArgument(allocationCheckpoints.length >= 2);
            this.allocationCheckpoints = allocationCheckpoints;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long[][][] getAllocationCheckpoints(long[][] trackBitrates) {
        int i;
        double[][] logArrayValues = getLogArrayValues(trackBitrates);
        double[][] switchPoints = getSwitchPoints(logArrayValues);
        int iCountArrayElements = countArrayElements(switchPoints);
        int i2 = 2;
        long[][][] jArr = (long[][][]) Array.newInstance((Class<?>) Long.TYPE, logArrayValues.length, iCountArrayElements + 3, 2);
        int[] iArr = new int[logArrayValues.length];
        setCheckpointValues(jArr, 1, trackBitrates, iArr);
        while (true) {
            i = iCountArrayElements + 2;
            if (i2 >= i) {
                break;
            }
            double d = Double.MAX_VALUE;
            int i3 = 0;
            for (int i4 = 0; i4 < logArrayValues.length; i4++) {
                int i5 = iArr[i4];
                if (i5 + 1 != logArrayValues[i4].length) {
                    double d2 = switchPoints[i4][i5];
                    if (d2 < d) {
                        i3 = i4;
                        d = d2;
                    }
                }
            }
            iArr[i3] = iArr[i3] + 1;
            setCheckpointValues(jArr, i2, trackBitrates, iArr);
            i2++;
        }
        for (long[][] jArr2 : jArr) {
            long[] jArr3 = jArr2[i];
            long[] jArr4 = jArr2[iCountArrayElements + 1];
            jArr3[0] = jArr4[0] * 2;
            jArr3[1] = jArr4[1] * 2;
        }
        return jArr;
    }

    private static double[][] getLogArrayValues(long[][] values) {
        double[][] dArr = new double[values.length][];
        for (int i = 0; i < values.length; i++) {
            dArr[i] = new double[values[i].length];
            int i2 = 0;
            while (true) {
                long[] jArr = values[i];
                if (i2 < jArr.length) {
                    double[] dArr2 = dArr[i];
                    long j = jArr[i2];
                    dArr2[i2] = j == -1 ? ConfigValue.DOUBLE_DEFAULT_VALUE : Math.log(j);
                    i2++;
                }
            }
        }
        return dArr;
    }

    private static double[][] getSwitchPoints(double[][] logBitrates) {
        double[][] dArr = new double[logBitrates.length][];
        for (int i = 0; i < logBitrates.length; i++) {
            double[] dArr2 = new double[logBitrates[i].length - 1];
            dArr[i] = dArr2;
            if (dArr2.length != 0) {
                double[] dArr3 = logBitrates[i];
                double d = dArr3[dArr3.length - 1] - dArr3[0];
                int i2 = 0;
                while (true) {
                    double[] dArr4 = logBitrates[i];
                    if (i2 < dArr4.length - 1) {
                        int i3 = i2 + 1;
                        dArr[i][i2] = d == ConfigValue.DOUBLE_DEFAULT_VALUE ? 1.0d : (((dArr4[i2] + dArr4[i3]) * 0.5d) - dArr4[0]) / d;
                        i2 = i3;
                    }
                }
            }
        }
        return dArr;
    }

    private static int countArrayElements(double[][] array) {
        int length = 0;
        for (double[] dArr : array) {
            length += dArr.length;
        }
        return length;
    }

    private static void setCheckpointValues(long[][][] checkpoints, int checkpointIndex, long[][] trackBitrates, int[] selectedTracks) {
        long j = 0;
        for (int i = 0; i < checkpoints.length; i++) {
            long[] jArr = checkpoints[i][checkpointIndex];
            long j2 = trackBitrates[i][selectedTracks[i]];
            jArr[1] = j2;
            j += j2;
        }
        for (long[][] jArr2 : checkpoints) {
            jArr2[checkpointIndex][0] = j;
        }
    }
}
