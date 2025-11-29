package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DefaultDashChunkSource implements DashChunkSource {
    private final int[] adaptationSetIndices;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    private IOException fatalError;
    private long liveEdgeTimeUs;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int maxSegmentsPerLoad;
    private boolean missingLastSegment;
    private int periodIndex;
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
    protected final RepresentationHolder[] representationHolders;
    private TrackSelection trackSelection;
    private final int trackType;

    public static final class Factory implements DashChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;
        private final int maxSegmentsPerLoad;

        public Factory(DataSource.Factory dataSourceFactory) {
            this(dataSourceFactory, 1);
        }

        public Factory(DataSource.Factory dataSourceFactory, int maxSegmentsPerLoad) {
            this.dataSourceFactory = dataSourceFactory;
            this.maxSegmentsPerLoad = maxSegmentsPerLoad;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashChunkSource.Factory
        public DashChunkSource createDashChunkSource(LoaderErrorThrower manifestLoaderErrorThrower, DashManifest manifest, int periodIndex, int[] adaptationSetIndices, TrackSelection trackSelection, int trackType, long elapsedRealtimeOffsetMs, boolean enableEventMessageTrack, List<Format> closedCaptionFormats, PlayerEmsgHandler.PlayerTrackEmsgHandler playerEmsgHandler, TransferListener transferListener) {
            DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener != null) {
                dataSourceCreateDataSource.addTransferListener(transferListener);
            }
            return new DefaultDashChunkSource(manifestLoaderErrorThrower, manifest, periodIndex, adaptationSetIndices, trackSelection, trackType, dataSourceCreateDataSource, elapsedRealtimeOffsetMs, this.maxSegmentsPerLoad, enableEventMessageTrack, closedCaptionFormats, playerEmsgHandler);
        }
    }

    public DefaultDashChunkSource(LoaderErrorThrower manifestLoaderErrorThrower, DashManifest manifest, int periodIndex, int[] adaptationSetIndices, TrackSelection trackSelection, int trackType, DataSource dataSource, long elapsedRealtimeOffsetMs, int maxSegmentsPerLoad, boolean enableEventMessageTrack, List<Format> closedCaptionFormats, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler) {
        this.manifestLoaderErrorThrower = manifestLoaderErrorThrower;
        this.manifest = manifest;
        this.adaptationSetIndices = adaptationSetIndices;
        this.trackSelection = trackSelection;
        this.trackType = trackType;
        this.dataSource = dataSource;
        this.periodIndex = periodIndex;
        this.elapsedRealtimeOffsetMs = elapsedRealtimeOffsetMs;
        this.maxSegmentsPerLoad = maxSegmentsPerLoad;
        this.playerTrackEmsgHandler = playerTrackEmsgHandler;
        long periodDurationBySegmentsUs = manifest.getPeriodDurationBySegmentsUs(periodIndex);
        this.liveEdgeTimeUs = -9223372036854775807L;
        ArrayList<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[trackSelection.length()];
        for (int i = 0; i < this.representationHolders.length; i++) {
            this.representationHolders[i] = new RepresentationHolder(periodDurationBySegmentsUs, trackType, representations.get(trackSelection.getIndexInTrackGroup(i)), enableEventMessageTrack, closedCaptionFormats, playerTrackEmsgHandler);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long positionUs, SeekParameters seekParameters) {
        for (RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentNum = representationHolder.getSegmentNum(positionUs);
                long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                return seekParameters.resolveSeekPositionUs(positionUs, segmentStartTimeUs, (segmentStartTimeUs >= positionUs || segmentNum >= ((long) (representationHolder.getSegmentCount() + (-1)))) ? segmentStartTimeUs : representationHolder.getSegmentStartTimeUs(segmentNum + 1));
            }
        }
        return positionUs;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateManifest(DashManifest newManifest, int newPeriodIndex) {
        try {
            this.manifest = newManifest;
            this.periodIndex = newPeriodIndex;
            long periodDurationBySegmentsUs = newManifest.getPeriodDurationBySegmentsUs(newPeriodIndex);
            ArrayList<Representation> representations = getRepresentations();
            for (int i = 0; i < this.representationHolders.length; i++) {
                Representation representation = representations.get(this.trackSelection.getIndexInTrackGroup(i));
                RepresentationHolder[] representationHolderArr = this.representationHolders;
                representationHolderArr[i] = representationHolderArr[i].copyWithNewRepresentation(periodDurationBySegmentsUs, representation);
            }
        } catch (BehindLiveWindowException e) {
            this.fatalError = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateTrackSelection(TrackSelection trackSelection) {
        this.trackSelection = trackSelection;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long playbackPositionUs, List<? extends MediaChunk> queue) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return queue.size();
        }
        return this.trackSelection.evaluateQueueSize(playbackPositionUs, queue);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void getNextChunk(long playbackPositionUs, long loadPositionUs, List<? extends MediaChunk> queue, ChunkHolder out) {
        int i;
        int i2;
        MediaChunkIterator[] mediaChunkIteratorArr;
        boolean z;
        long j;
        if (this.fatalError != null) {
            return;
        }
        long j2 = loadPositionUs - playbackPositionUs;
        long jResolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(playbackPositionUs);
        long jMsToUs = C.msToUs(this.manifest.availabilityStartTimeMs) + C.msToUs(this.manifest.getPeriod(this.periodIndex).startMs) + loadPositionUs;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler == null || !playerTrackEmsgHandler.maybeRefreshManifestBeforeLoadingNextChunk(jMsToUs)) {
            long jMsToUs2 = C.msToUs(Util.getNowUnixTimeMs(this.elapsedRealtimeOffsetMs));
            boolean z2 = true;
            MediaChunk mediaChunk = queue.isEmpty() ? null : queue.get(queue.size() - 1);
            int length = this.trackSelection.length();
            MediaChunkIterator[] mediaChunkIteratorArr2 = new MediaChunkIterator[length];
            int i3 = 0;
            while (i3 < length) {
                RepresentationHolder representationHolder = this.representationHolders[i3];
                if (representationHolder.segmentIndex == null) {
                    mediaChunkIteratorArr2[i3] = MediaChunkIterator.EMPTY;
                    i = i3;
                    i2 = length;
                    mediaChunkIteratorArr = mediaChunkIteratorArr2;
                    z = z2;
                    j = jMsToUs2;
                } else {
                    long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(this.manifest, this.periodIndex, jMsToUs2);
                    long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(this.manifest, this.periodIndex, jMsToUs2);
                    i = i3;
                    i2 = length;
                    mediaChunkIteratorArr = mediaChunkIteratorArr2;
                    z = true;
                    j = jMsToUs2;
                    long segmentNum = getSegmentNum(representationHolder, mediaChunk, loadPositionUs, firstAvailableSegmentNum, lastAvailableSegmentNum);
                    if (segmentNum < firstAvailableSegmentNum) {
                        mediaChunkIteratorArr[i] = MediaChunkIterator.EMPTY;
                    } else {
                        mediaChunkIteratorArr[i] = new RepresentationSegmentIterator(representationHolder, segmentNum, lastAvailableSegmentNum);
                    }
                }
                i3 = i + 1;
                z2 = z;
                length = i2;
                mediaChunkIteratorArr2 = mediaChunkIteratorArr;
                jMsToUs2 = j;
            }
            boolean z3 = z2;
            long j3 = jMsToUs2;
            this.trackSelection.updateSelectedTrack(playbackPositionUs, j2, jResolveTimeToLiveEdgeUs, queue, mediaChunkIteratorArr2);
            RepresentationHolder representationHolder2 = this.representationHolders[this.trackSelection.getSelectedIndex()];
            ChunkExtractorWrapper chunkExtractorWrapper = representationHolder2.extractorWrapper;
            if (chunkExtractorWrapper != null) {
                Representation representation = representationHolder2.representation;
                RangedUri initializationUri = chunkExtractorWrapper.getSampleFormats() == null ? representation.getInitializationUri() : null;
                RangedUri indexUri = representationHolder2.segmentIndex == null ? representation.getIndexUri() : null;
                if (initializationUri != null || indexUri != null) {
                    out.chunk = newInitializationChunk(representationHolder2, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), initializationUri, indexUri);
                    return;
                }
            }
            long j4 = representationHolder2.periodDurationUs;
            boolean z4 = j4 != -9223372036854775807L ? z3 : false;
            if (representationHolder2.getSegmentCount() == 0) {
                out.endOfStream = z4;
                return;
            }
            long firstAvailableSegmentNum2 = representationHolder2.getFirstAvailableSegmentNum(this.manifest, this.periodIndex, j3);
            long lastAvailableSegmentNum2 = representationHolder2.getLastAvailableSegmentNum(this.manifest, this.periodIndex, j3);
            updateLiveEdgeTimeUs(representationHolder2, lastAvailableSegmentNum2);
            boolean z5 = z4;
            long segmentNum2 = getSegmentNum(representationHolder2, mediaChunk, loadPositionUs, firstAvailableSegmentNum2, lastAvailableSegmentNum2);
            if (segmentNum2 < firstAvailableSegmentNum2) {
                this.fatalError = new BehindLiveWindowException();
                return;
            }
            if (segmentNum2 > lastAvailableSegmentNum2 || (this.missingLastSegment && segmentNum2 >= lastAvailableSegmentNum2)) {
                out.endOfStream = z5;
                return;
            }
            if (z5 && representationHolder2.getSegmentStartTimeUs(segmentNum2) >= j4) {
                out.endOfStream = true;
                return;
            }
            int iMin = (int) Math.min(this.maxSegmentsPerLoad, (lastAvailableSegmentNum2 - segmentNum2) + 1);
            if (j4 != -9223372036854775807L) {
                while (iMin > 1 && representationHolder2.getSegmentStartTimeUs((iMin + segmentNum2) - 1) >= j4) {
                    iMin--;
                }
            }
            out.chunk = newMediaChunk(representationHolder2, this.dataSource, this.trackType, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), segmentNum2, iMin, queue.isEmpty() ? loadPositionUs : -9223372036854775807L);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
        SeekMap seekMap;
        if (chunk instanceof InitializationChunk) {
            int iIndexOf = this.trackSelection.indexOf(((InitializationChunk) chunk).trackFormat);
            RepresentationHolder representationHolder = this.representationHolders[iIndexOf];
            if (representationHolder.segmentIndex == null && (seekMap = representationHolder.extractorWrapper.getSeekMap()) != null) {
                this.representationHolders[iIndexOf] = representationHolder.copyWithNewSegmentIndex(new DashWrappingSegmentIndex((ChunkIndex) seekMap, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler != null) {
            playerTrackEmsgHandler.onChunkLoadCompleted(chunk);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean cancelable, Exception e, long blacklistDurationMs) {
        RepresentationHolder representationHolder;
        int segmentCount;
        if (!cancelable) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler != null && playerTrackEmsgHandler.maybeRefreshManifestOnLoadingError(chunk)) {
            return true;
        }
        if (!this.manifest.dynamic && (chunk instanceof MediaChunk) && (e instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) e).responseCode == 404 && (segmentCount = (representationHolder = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                this.missingLastSegment = true;
                return true;
            }
        }
        if (blacklistDurationMs == -9223372036854775807L) {
            return false;
        }
        TrackSelection trackSelection = this.trackSelection;
        return trackSelection.blacklist(trackSelection.indexOf(chunk.trackFormat), blacklistDurationMs);
    }

    private long getSegmentNum(RepresentationHolder representationHolder, MediaChunk previousChunk, long loadPositionUs, long firstAvailableSegmentNum, long lastAvailableSegmentNum) {
        if (previousChunk != null) {
            return previousChunk.getNextChunkIndex();
        }
        return Util.constrainValue(representationHolder.getSegmentNum(loadPositionUs), firstAvailableSegmentNum, lastAvailableSegmentNum);
    }

    private ArrayList<Representation> getRepresentations() {
        List<AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i : this.adaptationSetIndices) {
            arrayList.addAll(list.get(i).representations);
        }
        return arrayList;
    }

    private void updateLiveEdgeTimeUs(RepresentationHolder representationHolder, long lastAvailableSegmentNum) {
        this.liveEdgeTimeUs = this.manifest.dynamic ? representationHolder.getSegmentEndTimeUs(lastAvailableSegmentNum) : -9223372036854775807L;
    }

    private long resolveTimeToLiveEdgeUs(long playbackPositionUs) {
        if (!this.manifest.dynamic) {
            return -9223372036854775807L;
        }
        long j = this.liveEdgeTimeUs;
        if (j != -9223372036854775807L) {
            return j - playbackPositionUs;
        }
        return -9223372036854775807L;
    }

    protected Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource, Format trackFormat, int trackSelectionReason, Object trackSelectionData, RangedUri initializationUri, RangedUri indexUri) {
        Representation representation = representationHolder.representation;
        if (initializationUri == null || (indexUri = initializationUri.attemptMerge(indexUri, representation.baseUrl)) != null) {
            initializationUri = indexUri;
        }
        return new InitializationChunk(dataSource, DashUtil.buildDataSpec(representation, initializationUri), trackFormat, trackSelectionReason, trackSelectionData, representationHolder.extractorWrapper);
    }

    protected Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long firstSegmentNum, int maxSegmentCount, long seekTimeUs) {
        Representation representation = representationHolder.representation;
        long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(firstSegmentNum);
        RangedUri segmentUrl = representationHolder.getSegmentUrl(firstSegmentNum);
        String str = representation.baseUrl;
        if (representationHolder.extractorWrapper == null) {
            return new SingleSampleMediaChunk(dataSource, DashUtil.buildDataSpec(representation, segmentUrl), trackFormat, trackSelectionReason, trackSelectionData, segmentStartTimeUs, representationHolder.getSegmentEndTimeUs(firstSegmentNum), firstSegmentNum, trackType, trackFormat);
        }
        int i = 1;
        int i2 = 1;
        while (i < maxSegmentCount) {
            RangedUri rangedUriAttemptMerge = segmentUrl.attemptMerge(representationHolder.getSegmentUrl(i + firstSegmentNum), str);
            if (rangedUriAttemptMerge == null) {
                break;
            }
            i2++;
            i++;
            segmentUrl = rangedUriAttemptMerge;
        }
        long segmentEndTimeUs = representationHolder.getSegmentEndTimeUs((i2 + firstSegmentNum) - 1);
        long j = representationHolder.periodDurationUs;
        return new ContainerMediaChunk(dataSource, DashUtil.buildDataSpec(representation, segmentUrl), trackFormat, trackSelectionReason, trackSelectionData, segmentStartTimeUs, segmentEndTimeUs, seekTimeUs, (j == -9223372036854775807L || j > segmentEndTimeUs) ? -9223372036854775807L : j, firstSegmentNum, i2, -representation.presentationTimeOffsetUs, representationHolder.extractorWrapper);
    }

    protected static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {
        private final RepresentationHolder representationHolder;

        public RepresentationSegmentIterator(RepresentationHolder representation, long firstAvailableSegmentNum, long lastAvailableSegmentNum) {
            super(firstAvailableSegmentNum, lastAvailableSegmentNum);
            this.representationHolder = representation;
        }
    }

    protected static final class RepresentationHolder {
        final ChunkExtractorWrapper extractorWrapper;
        private final long periodDurationUs;
        public final Representation representation;
        public final DashSegmentIndex segmentIndex;
        private final long segmentNumShift;

        RepresentationHolder(long periodDurationUs, int trackType, Representation representation, boolean enableEventMessageTrack, List<Format> closedCaptionFormats, TrackOutput playerEmsgTrackOutput) {
            this(periodDurationUs, representation, createExtractorWrapper(trackType, representation, enableEventMessageTrack, closedCaptionFormats, playerEmsgTrackOutput), 0L, representation.getIndex());
        }

        private RepresentationHolder(long periodDurationUs, Representation representation, ChunkExtractorWrapper extractorWrapper, long segmentNumShift, DashSegmentIndex segmentIndex) {
            this.periodDurationUs = periodDurationUs;
            this.representation = representation;
            this.segmentNumShift = segmentNumShift;
            this.extractorWrapper = extractorWrapper;
            this.segmentIndex = segmentIndex;
        }

        RepresentationHolder copyWithNewRepresentation(long newPeriodDurationUs, Representation newRepresentation) throws BehindLiveWindowException {
            long segmentNum;
            long j;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = newRepresentation.getIndex();
            if (index == null) {
                return new RepresentationHolder(newPeriodDurationUs, newRepresentation, this.extractorWrapper, this.segmentNumShift, index);
            }
            if (!index.isExplicit()) {
                return new RepresentationHolder(newPeriodDurationUs, newRepresentation, this.extractorWrapper, this.segmentNumShift, index2);
            }
            int segmentCount = index.getSegmentCount(newPeriodDurationUs);
            if (segmentCount == 0) {
                return new RepresentationHolder(newPeriodDurationUs, newRepresentation, this.extractorWrapper, this.segmentNumShift, index2);
            }
            long firstSegmentNum = index.getFirstSegmentNum();
            long timeUs = index.getTimeUs(firstSegmentNum);
            long j2 = segmentCount + firstSegmentNum;
            long j3 = j2 - 1;
            long timeUs2 = index.getTimeUs(j3) + index.getDurationUs(j3, newPeriodDurationUs);
            long firstSegmentNum2 = index2.getFirstSegmentNum();
            long timeUs3 = index2.getTimeUs(firstSegmentNum2);
            long j4 = this.segmentNumShift;
            if (timeUs2 == timeUs3) {
                j = j4 + (j2 - firstSegmentNum2);
            } else {
                if (timeUs2 < timeUs3) {
                    throw new BehindLiveWindowException();
                }
                if (timeUs3 < timeUs) {
                    segmentNum = j4 - (index2.getSegmentNum(timeUs, newPeriodDurationUs) - firstSegmentNum);
                } else {
                    segmentNum = (index.getSegmentNum(timeUs3, newPeriodDurationUs) - firstSegmentNum2) + j4;
                }
                j = segmentNum;
            }
            return new RepresentationHolder(newPeriodDurationUs, newRepresentation, this.extractorWrapper, j, index2);
        }

        RepresentationHolder copyWithNewSegmentIndex(DashSegmentIndex segmentIndex) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, this.extractorWrapper, this.segmentNumShift, segmentIndex);
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public int getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.periodDurationUs);
        }

        public long getSegmentStartTimeUs(long segmentNum) {
            return this.segmentIndex.getTimeUs(segmentNum - this.segmentNumShift);
        }

        public long getSegmentEndTimeUs(long segmentNum) {
            return getSegmentStartTimeUs(segmentNum) + this.segmentIndex.getDurationUs(segmentNum - this.segmentNumShift, this.periodDurationUs);
        }

        public long getSegmentNum(long positionUs) {
            return this.segmentIndex.getSegmentNum(positionUs, this.periodDurationUs) + this.segmentNumShift;
        }

        public RangedUri getSegmentUrl(long segmentNum) {
            return this.segmentIndex.getSegmentUrl(segmentNum - this.segmentNumShift);
        }

        public long getFirstAvailableSegmentNum(DashManifest manifest, int periodIndex, long nowUnixTimeUs) {
            if (getSegmentCount() == -1 && manifest.timeShiftBufferDepthMs != -9223372036854775807L) {
                return Math.max(getFirstSegmentNum(), getSegmentNum(((nowUnixTimeUs - C.msToUs(manifest.availabilityStartTimeMs)) - C.msToUs(manifest.getPeriod(periodIndex).startMs)) - C.msToUs(manifest.timeShiftBufferDepthMs)));
            }
            return getFirstSegmentNum();
        }

        public long getLastAvailableSegmentNum(DashManifest manifest, int periodIndex, long nowUnixTimeUs) {
            long firstSegmentNum;
            int segmentCount = getSegmentCount();
            if (segmentCount == -1) {
                firstSegmentNum = getSegmentNum((nowUnixTimeUs - C.msToUs(manifest.availabilityStartTimeMs)) - C.msToUs(manifest.getPeriod(periodIndex).startMs));
            } else {
                firstSegmentNum = getFirstSegmentNum() + segmentCount;
            }
            return firstSegmentNum - 1;
        }

        private static boolean mimeTypeIsWebm(String mimeType) {
            return mimeType.startsWith("video/webm") || mimeType.startsWith("audio/webm") || mimeType.startsWith("application/webm");
        }

        private static ChunkExtractorWrapper createExtractorWrapper(int trackType, Representation representation, boolean enableEventMessageTrack, List<Format> closedCaptionFormats, TrackOutput playerEmsgTrackOutput) {
            Extractor fragmentedMp4Extractor;
            String str = representation.format.containerMimeType;
            if (MimeTypes.isText(str)) {
                if (!"application/x-rawcc".equals(str)) {
                    return null;
                }
                fragmentedMp4Extractor = new RawCcExtractor(representation.format);
            } else if (mimeTypeIsWebm(str)) {
                fragmentedMp4Extractor = new MatroskaExtractor(1);
            } else {
                fragmentedMp4Extractor = new FragmentedMp4Extractor(enableEventMessageTrack ? 4 : 0, null, null, closedCaptionFormats, playerEmsgTrackOutput);
            }
            return new ChunkExtractorWrapper(fragmentedMp4Extractor, trackType, representation.format);
        }
    }
}
