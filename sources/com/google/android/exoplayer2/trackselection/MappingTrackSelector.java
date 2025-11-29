package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class MappingTrackSelector extends TrackSelector {
    private MappedTrackInfo currentMappedTrackInfo;

    protected abstract Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] rendererFormatSupports, int[] rendererMixedMimeTypeAdaptationSupport) throws ExoPlaybackException;

    public static final class MappedTrackInfo {

        @Deprecated
        public final int length;
        private final int rendererCount;
        private final int[][][] rendererFormatSupports;
        private final int[] rendererMixedMimeTypeAdaptiveSupports;
        private final String[] rendererNames;
        private final TrackGroupArray[] rendererTrackGroups;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray unmappedTrackGroups;

        MappedTrackInfo(String[] rendererNames, int[] rendererTrackTypes, TrackGroupArray[] rendererTrackGroups, int[] rendererMixedMimeTypeAdaptiveSupports, int[][][] rendererFormatSupports, TrackGroupArray unmappedTrackGroups) {
            this.rendererNames = rendererNames;
            this.rendererTrackTypes = rendererTrackTypes;
            this.rendererTrackGroups = rendererTrackGroups;
            this.rendererFormatSupports = rendererFormatSupports;
            this.rendererMixedMimeTypeAdaptiveSupports = rendererMixedMimeTypeAdaptiveSupports;
            this.unmappedTrackGroups = unmappedTrackGroups;
            int length = rendererTrackTypes.length;
            this.rendererCount = length;
            this.length = length;
        }

        public int getRendererCount() {
            return this.rendererCount;
        }

        public int getRendererType(int rendererIndex) {
            return this.rendererTrackTypes[rendererIndex];
        }

        public TrackGroupArray getTrackGroups(int rendererIndex) {
            return this.rendererTrackGroups[rendererIndex];
        }

        public int getTrackSupport(int rendererIndex, int groupIndex, int trackIndex) {
            return RendererCapabilities.getFormatSupport(this.rendererFormatSupports[rendererIndex][groupIndex][trackIndex]);
        }

        public int getAdaptiveSupport(int rendererIndex, int groupIndex, boolean includeCapabilitiesExceededTracks) {
            int i = this.rendererTrackGroups[rendererIndex].get(groupIndex).length;
            int[] iArr = new int[i];
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                int trackSupport = getTrackSupport(rendererIndex, groupIndex, i3);
                if (trackSupport == 4 || (includeCapabilitiesExceededTracks && trackSupport == 3)) {
                    iArr[i2] = i3;
                    i2++;
                }
            }
            return getAdaptiveSupport(rendererIndex, groupIndex, Arrays.copyOf(iArr, i2));
        }

        public int getAdaptiveSupport(int rendererIndex, int groupIndex, int[] trackIndices) {
            int i = 0;
            int iMin = 16;
            String str = null;
            boolean z = false;
            int i2 = 0;
            while (i < trackIndices.length) {
                String str2 = this.rendererTrackGroups[rendererIndex].get(groupIndex).getFormat(trackIndices[i]).sampleMimeType;
                int i3 = i2 + 1;
                if (i2 == 0) {
                    str = str2;
                } else {
                    z |= !Util.areEqual(str, str2);
                }
                iMin = Math.min(iMin, RendererCapabilities.getAdaptiveSupport(this.rendererFormatSupports[rendererIndex][groupIndex][i]));
                i++;
                i2 = i3;
            }
            return z ? Math.min(iMin, this.rendererMixedMimeTypeAdaptiveSupports[rendererIndex]) : iMin;
        }
    }

    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void onSelectionActivated(Object info) {
        this.currentMappedTrackInfo = (MappedTrackInfo) info;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilities, TrackGroupArray trackGroups, MediaSource.MediaPeriodId periodId, Timeline timeline) throws ExoPlaybackException {
        int[] iArr = new int[rendererCapabilities.length + 1];
        int length = rendererCapabilities.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr2 = new int[rendererCapabilities.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = trackGroups.length;
            trackGroupArr[i] = new TrackGroup[i2];
            iArr2[i] = new int[i2][];
        }
        int[] mixedMimeTypeAdaptationSupports = getMixedMimeTypeAdaptationSupports(rendererCapabilities);
        for (int i3 = 0; i3 < trackGroups.length; i3++) {
            TrackGroup trackGroup = trackGroups.get(i3);
            int iFindRenderer = findRenderer(rendererCapabilities, trackGroup, iArr, MimeTypes.getTrackType(trackGroup.getFormat(0).sampleMimeType) == 4);
            int[] formatSupport = iFindRenderer == rendererCapabilities.length ? new int[trackGroup.length] : getFormatSupport(rendererCapabilities[iFindRenderer], trackGroup);
            int i4 = iArr[iFindRenderer];
            trackGroupArr[iFindRenderer][i4] = trackGroup;
            iArr2[iFindRenderer][i4] = formatSupport;
            iArr[iFindRenderer] = i4 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilities.length];
        String[] strArr = new String[rendererCapabilities.length];
        int[] iArr3 = new int[rendererCapabilities.length];
        for (int i5 = 0; i5 < rendererCapabilities.length; i5++) {
            int i6 = iArr[i5];
            trackGroupArrayArr[i5] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[i5], i6));
            iArr2[i5] = (int[][]) Util.nullSafeArrayCopy(iArr2[i5], i6);
            strArr[i5] = rendererCapabilities[i5].getName();
            iArr3[i5] = rendererCapabilities[i5].getTrackType();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(strArr, iArr3, trackGroupArrayArr, mixedMimeTypeAdaptationSupports, iArr2, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilities.length], iArr[rendererCapabilities.length])));
        Pair<RendererConfiguration[], TrackSelection[]> pairSelectTracks = selectTracks(mappedTrackInfo, iArr2, mixedMimeTypeAdaptationSupports);
        return new TrackSelectorResult((RendererConfiguration[]) pairSelectTracks.first, (TrackSelection[]) pairSelectTracks.second, mappedTrackInfo);
    }

    private static int findRenderer(RendererCapabilities[] rendererCapabilities, TrackGroup group, int[] rendererTrackGroupCounts, boolean preferUnassociatedRenderer) throws ExoPlaybackException {
        int length = rendererCapabilities.length;
        int i = 0;
        boolean z = true;
        for (int i2 = 0; i2 < rendererCapabilities.length; i2++) {
            RendererCapabilities rendererCapabilities2 = rendererCapabilities[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < group.length; i4++) {
                Format format = group.getFormat(i4);
                int iSupportsFormat = rendererCapabilities2.supportsFormat(format);
                int formatSupport = RendererCapabilities.getFormatSupport(iSupportsFormat);
                i3 += formatSupport;
                if (i3 > i) {
                    Log.d(MappingTrackSelector.class.getName(), String.format("formatSupportLevel > bestFormatSupportLevel: \n mimeType %s \n supportsFormat %s \n SupportLevel %s \n rendererIndex %d", format.sampleMimeType, Integer.valueOf(iSupportsFormat), Integer.valueOf(formatSupport), Integer.valueOf(i2)));
                }
            }
            boolean z2 = rendererTrackGroupCounts[i2] == 0;
            if (i3 > i || (i3 == i && preferUnassociatedRenderer && !z && z2)) {
                Log.d(MappingTrackSelector.class.getName(), String.format(" bestRendererIndex changed %d", Integer.valueOf(i2)));
                length = i2;
                z = z2;
                i = i3;
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup group) throws ExoPlaybackException {
        int[] iArr = new int[group.length];
        for (int i = 0; i < group.length; i++) {
            iArr[i] = rendererCapabilities.supportsFormat(group.getFormat(i));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(RendererCapabilities[] rendererCapabilities) throws ExoPlaybackException {
        int length = rendererCapabilities.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = rendererCapabilities[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }
}
