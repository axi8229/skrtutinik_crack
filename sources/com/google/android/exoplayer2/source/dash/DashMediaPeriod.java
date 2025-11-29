package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {
    private static final Pattern CEA608_SERVICE_DESCRIPTOR_REGEX = Pattern.compile("CC([1-4])=(.+)");
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    private final DashChunkSource.Factory chunkSourceFactory;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionManager drmSessionManager;
    private final long elapsedRealtimeOffsetMs;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private List<EventStream> eventStreams;
    final int id;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private boolean notifiedReadingStarted;
    private int periodIndex;
    private final PlayerEmsgHandler playerEmsgHandler;
    private final TrackGroupInfo[] trackGroupInfos;
    private final TrackGroupArray trackGroups;
    private final TransferListener transferListener;
    private ChunkSampleStream<DashChunkSource>[] sampleStreams = newSampleStreamArray(0);
    private EventSampleStream[] eventSampleStreams = new EventSampleStream[0];
    private final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler> trackEmsgHandlerBySampleStream = new IdentityHashMap<>();

    public DashMediaPeriod(int id, DashManifest manifest, int periodIndex, DashChunkSource.Factory chunkSourceFactory, TransferListener transferListener, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, long elapsedRealtimeOffsetMs, LoaderErrorThrower manifestLoaderErrorThrower, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback) {
        this.id = id;
        this.manifest = manifest;
        this.periodIndex = periodIndex;
        this.chunkSourceFactory = chunkSourceFactory;
        this.transferListener = transferListener;
        this.drmSessionManager = drmSessionManager;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = eventDispatcher;
        this.elapsedRealtimeOffsetMs = elapsedRealtimeOffsetMs;
        this.manifestLoaderErrorThrower = manifestLoaderErrorThrower;
        this.allocator = allocator;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.playerEmsgHandler = new PlayerEmsgHandler(manifest, playerEmsgCallback, allocator);
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.sampleStreams);
        Period period = manifest.getPeriod(periodIndex);
        List<EventStream> list = period.eventStreams;
        this.eventStreams = list;
        Pair<TrackGroupArray, TrackGroupInfo[]> pairBuildTrackGroups = buildTrackGroups(drmSessionManager, period.adaptationSets, list);
        this.trackGroups = (TrackGroupArray) pairBuildTrackGroups.first;
        this.trackGroupInfos = (TrackGroupInfo[]) pairBuildTrackGroups.second;
        eventDispatcher.mediaPeriodCreated();
    }

    public void updateManifest(DashManifest manifest, int periodIndex) {
        this.manifest = manifest;
        this.periodIndex = periodIndex;
        this.playerEmsgHandler.updateManifest(manifest);
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.sampleStreams;
        if (chunkSampleStreamArr != null) {
            for (ChunkSampleStream<DashChunkSource> chunkSampleStream : chunkSampleStreamArr) {
                ((DashChunkSource) chunkSampleStream.getChunkSource()).updateManifest(manifest, periodIndex);
            }
            this.callback.onContinueLoadingRequested(this);
        }
        this.eventStreams = manifest.getPeriod(periodIndex).eventStreams;
        for (EventSampleStream eventSampleStream : this.eventSampleStreams) {
            Iterator<EventStream> it = this.eventStreams.iterator();
            while (true) {
                if (it.hasNext()) {
                    EventStream next = it.next();
                    if (next.id().equals(eventSampleStream.eventStreamId())) {
                        eventSampleStream.updateEventStream(next, manifest.dynamic && periodIndex == manifest.getPeriodCount() - 1);
                    }
                }
            }
        }
    }

    public void release() {
        this.playerEmsgHandler.release();
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.release(this);
        }
        this.callback = null;
        this.eventDispatcher.mediaPeriodReleased();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback
    public synchronized void onSampleStreamReleased(ChunkSampleStream<DashChunkSource> stream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandlerRemove = this.trackEmsgHandlerBySampleStream.remove(stream);
        if (playerTrackEmsgHandlerRemove != null) {
            playerTrackEmsgHandlerRemove.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long positionUs) {
        this.callback = callback;
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] selections, boolean[] mayRetainStreamFlags, SampleStream[] streams, boolean[] streamResetFlags, long positionUs) {
        int[] streamIndexToTrackGroupIndex = getStreamIndexToTrackGroupIndex(selections);
        releaseDisabledStreams(selections, mayRetainStreamFlags, streams);
        releaseOrphanEmbeddedStreams(selections, streams, streamIndexToTrackGroupIndex);
        selectNewStreams(selections, streams, streamResetFlags, positionUs, streamIndexToTrackGroupIndex);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SampleStream sampleStream : streams) {
            if (sampleStream instanceof ChunkSampleStream) {
                arrayList.add((ChunkSampleStream) sampleStream);
            } else if (sampleStream instanceof EventSampleStream) {
                arrayList2.add((EventSampleStream) sampleStream);
            }
        }
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArrNewSampleStreamArray = newSampleStreamArray(arrayList.size());
        this.sampleStreams = chunkSampleStreamArrNewSampleStreamArray;
        arrayList.toArray(chunkSampleStreamArrNewSampleStreamArray);
        EventSampleStream[] eventSampleStreamArr = new EventSampleStream[arrayList2.size()];
        this.eventSampleStreams = eventSampleStreamArr;
        arrayList2.toArray(eventSampleStreamArr);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.sampleStreams);
        return positionUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long positionUs, boolean toKeyframe) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.discardBuffer(positionUs, toKeyframe);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long positionUs) {
        this.compositeSequenceableLoader.reevaluateBuffer(positionUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long positionUs) {
        return this.compositeSequenceableLoader.continueLoading(positionUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (this.notifiedReadingStarted) {
            return -9223372036854775807L;
        }
        this.eventDispatcher.readingStarted();
        this.notifiedReadingStarted = true;
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long positionUs) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.seekToUs(positionUs);
        }
        for (EventSampleStream eventSampleStream : this.eventSampleStreams) {
            eventSampleStream.seekToUs(positionUs);
        }
        return positionUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long positionUs, SeekParameters seekParameters) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(positionUs, seekParameters);
            }
        }
        return positionUs;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(ChunkSampleStream<DashChunkSource> sampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }

    private int[] getStreamIndexToTrackGroupIndex(TrackSelection[] selections) {
        int[] iArr = new int[selections.length];
        for (int i = 0; i < selections.length; i++) {
            TrackSelection trackSelection = selections[i];
            if (trackSelection != null) {
                iArr[i] = this.trackGroups.indexOf(trackSelection.getTrackGroup());
            } else {
                iArr[i] = -1;
            }
        }
        return iArr;
    }

    private void releaseDisabledStreams(TrackSelection[] selections, boolean[] mayRetainStreamFlags, SampleStream[] streams) {
        for (int i = 0; i < selections.length; i++) {
            if (selections[i] == null || !mayRetainStreamFlags[i]) {
                SampleStream sampleStream = streams[i];
                if (sampleStream instanceof ChunkSampleStream) {
                    ((ChunkSampleStream) sampleStream).release(this);
                } else if (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ((ChunkSampleStream.EmbeddedSampleStream) sampleStream).release();
                }
                streams[i] = null;
            }
        }
    }

    private void releaseOrphanEmbeddedStreams(TrackSelection[] selections, SampleStream[] streams, int[] streamIndexToTrackGroupIndex) {
        boolean z;
        for (int i = 0; i < selections.length; i++) {
            SampleStream sampleStream = streams[i];
            if ((sampleStream instanceof EmptySampleStream) || (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int primaryStreamIndex = getPrimaryStreamIndex(i, streamIndexToTrackGroupIndex);
                if (primaryStreamIndex == -1) {
                    z = streams[i] instanceof EmptySampleStream;
                } else {
                    SampleStream sampleStream2 = streams[i];
                    z = (sampleStream2 instanceof ChunkSampleStream.EmbeddedSampleStream) && ((ChunkSampleStream.EmbeddedSampleStream) sampleStream2).parent == streams[primaryStreamIndex];
                }
                if (!z) {
                    SampleStream sampleStream3 = streams[i];
                    if (sampleStream3 instanceof ChunkSampleStream.EmbeddedSampleStream) {
                        ((ChunkSampleStream.EmbeddedSampleStream) sampleStream3).release();
                    }
                    streams[i] = null;
                }
            }
        }
    }

    private void selectNewStreams(TrackSelection[] selections, SampleStream[] streams, boolean[] streamResetFlags, long positionUs, int[] streamIndexToTrackGroupIndex) {
        for (int i = 0; i < selections.length; i++) {
            TrackSelection trackSelection = selections[i];
            if (trackSelection != null) {
                SampleStream sampleStream = streams[i];
                if (sampleStream == null) {
                    streamResetFlags[i] = true;
                    TrackGroupInfo trackGroupInfo = this.trackGroupInfos[streamIndexToTrackGroupIndex[i]];
                    int i2 = trackGroupInfo.trackGroupCategory;
                    if (i2 == 0) {
                        streams[i] = buildSampleStream(trackGroupInfo, trackSelection, positionUs);
                    } else if (i2 == 2) {
                        streams[i] = new EventSampleStream(this.eventStreams.get(trackGroupInfo.eventStreamGroupIndex), trackSelection.getTrackGroup().getFormat(0), this.manifest.dynamic);
                    }
                } else if (sampleStream instanceof ChunkSampleStream) {
                    ((DashChunkSource) ((ChunkSampleStream) sampleStream).getChunkSource()).updateTrackSelection(trackSelection);
                }
            }
        }
        for (int i3 = 0; i3 < selections.length; i3++) {
            if (streams[i3] == null && selections[i3] != null) {
                TrackGroupInfo trackGroupInfo2 = this.trackGroupInfos[streamIndexToTrackGroupIndex[i3]];
                if (trackGroupInfo2.trackGroupCategory == 1) {
                    int primaryStreamIndex = getPrimaryStreamIndex(i3, streamIndexToTrackGroupIndex);
                    if (primaryStreamIndex == -1) {
                        streams[i3] = new EmptySampleStream();
                    } else {
                        streams[i3] = ((ChunkSampleStream) streams[primaryStreamIndex]).selectEmbeddedTrack(positionUs, trackGroupInfo2.trackType);
                    }
                }
            }
        }
    }

    private int getPrimaryStreamIndex(int embeddedStreamIndex, int[] streamIndexToTrackGroupIndex) {
        int i = streamIndexToTrackGroupIndex[embeddedStreamIndex];
        if (i == -1) {
            return -1;
        }
        int i2 = this.trackGroupInfos[i].primaryTrackGroupIndex;
        for (int i3 = 0; i3 < streamIndexToTrackGroupIndex.length; i3++) {
            int i4 = streamIndexToTrackGroupIndex[i3];
            if (i4 == i2 && this.trackGroupInfos[i4].trackGroupCategory == 0) {
                return i3;
            }
        }
        return -1;
    }

    private static Pair<TrackGroupArray, TrackGroupInfo[]> buildTrackGroups(DrmSessionManager drmSessionManager, List<AdaptationSet> adaptationSets, List<EventStream> eventStreams) {
        int[][] groupedAdaptationSetIndices = getGroupedAdaptationSetIndices(adaptationSets);
        int length = groupedAdaptationSetIndices.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int iIdentifyEmbeddedTracks = identifyEmbeddedTracks(length, adaptationSets, groupedAdaptationSetIndices, zArr, formatArr) + length + eventStreams.size();
        TrackGroup[] trackGroupArr = new TrackGroup[iIdentifyEmbeddedTracks];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[iIdentifyEmbeddedTracks];
        buildManifestEventTrackGroupInfos(eventStreams, trackGroupArr, trackGroupInfoArr, buildPrimaryAndEmbeddedTrackGroupInfos(drmSessionManager, adaptationSets, groupedAdaptationSetIndices, length, zArr, formatArr, trackGroupArr, trackGroupInfoArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
    }

    private static int[][] getGroupedAdaptationSetIndices(List<AdaptationSet> adaptationSets) {
        int size = adaptationSets.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(adaptationSets.get(i2).id, i2);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (!zArr[i3]) {
                zArr[i3] = true;
                Descriptor descriptorFindAdaptationSetSwitchingProperty = findAdaptationSetSwitchingProperty(adaptationSets.get(i3).supplementalProperties);
                if (descriptorFindAdaptationSetSwitchingProperty == null) {
                    iArr[i4] = new int[]{i3};
                    i4++;
                } else {
                    String[] strArrSplit = Util.split(descriptorFindAdaptationSetSwitchingProperty.value, ",");
                    int length = strArrSplit.length + 1;
                    int[] iArrCopyOf = new int[length];
                    iArrCopyOf[i] = i3;
                    int length2 = strArrSplit.length;
                    int i5 = 1;
                    for (int i6 = i; i6 < length2; i6++) {
                        int i7 = sparseIntArray.get(Integer.parseInt(strArrSplit[i6]), -1);
                        if (i7 != -1) {
                            zArr[i7] = true;
                            iArrCopyOf[i5] = i7;
                            i5++;
                        }
                    }
                    if (i5 < length) {
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i5);
                    }
                    iArr[i4] = iArrCopyOf;
                    i4++;
                }
            }
            i3++;
            i = 0;
        }
        return i4 < size ? (int[][]) Arrays.copyOf(iArr, i4) : iArr;
    }

    private static int identifyEmbeddedTracks(int primaryGroupCount, List<AdaptationSet> adaptationSets, int[][] groupedAdaptationSetIndices, boolean[] primaryGroupHasEventMessageTrackFlags, Format[][] primaryGroupCea608TrackFormats) {
        int i = 0;
        for (int i2 = 0; i2 < primaryGroupCount; i2++) {
            if (hasEventMessageTrack(adaptationSets, groupedAdaptationSetIndices[i2])) {
                primaryGroupHasEventMessageTrackFlags[i2] = true;
                i++;
            }
            Format[] cea608TrackFormats = getCea608TrackFormats(adaptationSets, groupedAdaptationSetIndices[i2]);
            primaryGroupCea608TrackFormats[i2] = cea608TrackFormats;
            if (cea608TrackFormats.length != 0) {
                i++;
            }
        }
        return i;
    }

    private static int buildPrimaryAndEmbeddedTrackGroupInfos(DrmSessionManager drmSessionManager, List<AdaptationSet> adaptationSets, int[][] groupedAdaptationSetIndices, int primaryGroupCount, boolean[] primaryGroupHasEventMessageTrackFlags, Format[][] primaryGroupCea608TrackFormats, TrackGroup[] trackGroups, TrackGroupInfo[] trackGroupInfos) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (i3 < primaryGroupCount) {
            int[] iArr = groupedAdaptationSetIndices[i3];
            ArrayList arrayList = new ArrayList();
            for (int i5 : iArr) {
                arrayList.addAll(adaptationSets.get(i5).representations);
            }
            int size = arrayList.size();
            Format[] formatArr = new Format[size];
            for (int i6 = 0; i6 < size; i6++) {
                Format formatCopyWithExoMediaCryptoType = ((Representation) arrayList.get(i6)).format;
                DrmInitData drmInitData = formatCopyWithExoMediaCryptoType.drmInitData;
                if (drmInitData != null) {
                    formatCopyWithExoMediaCryptoType = formatCopyWithExoMediaCryptoType.copyWithExoMediaCryptoType(drmSessionManager.getExoMediaCryptoType(drmInitData));
                }
                formatArr[i6] = formatCopyWithExoMediaCryptoType;
            }
            AdaptationSet adaptationSet = adaptationSets.get(iArr[0]);
            int i7 = i4 + 1;
            if (primaryGroupHasEventMessageTrackFlags[i3]) {
                i = i4 + 2;
            } else {
                i = i7;
                i7 = -1;
            }
            if (primaryGroupCea608TrackFormats[i3].length != 0) {
                i2 = i + 1;
            } else {
                i2 = i;
                i = -1;
            }
            trackGroups[i4] = new TrackGroup(formatArr);
            trackGroupInfos[i4] = TrackGroupInfo.primaryTrack(adaptationSet.type, iArr, i4, i7, i);
            if (i7 != -1) {
                trackGroups[i7] = new TrackGroup(new Format.Builder().setId(adaptationSet.id + ":emsg").setSampleMimeType("application/x-emsg").build());
                trackGroupInfos[i7] = TrackGroupInfo.embeddedEmsgTrack(iArr, i4);
            }
            if (i != -1) {
                trackGroups[i] = new TrackGroup(primaryGroupCea608TrackFormats[i3]);
                trackGroupInfos[i] = TrackGroupInfo.embeddedCea608Track(iArr, i4);
            }
            i3++;
            i4 = i2;
        }
        return i4;
    }

    private static void buildManifestEventTrackGroupInfos(List<EventStream> eventStreams, TrackGroup[] trackGroups, TrackGroupInfo[] trackGroupInfos, int existingTrackGroupCount) {
        int i = 0;
        while (i < eventStreams.size()) {
            trackGroups[existingTrackGroupCount] = new TrackGroup(new Format.Builder().setId(eventStreams.get(i).id()).setSampleMimeType("application/x-emsg").build());
            trackGroupInfos[existingTrackGroupCount] = TrackGroupInfo.mpdEventTrack(i);
            i++;
            existingTrackGroupCount++;
        }
    }

    private ChunkSampleStream<DashChunkSource> buildSampleStream(TrackGroupInfo trackGroupInfo, TrackSelection selection, long positionUs) {
        int i;
        TrackGroup trackGroup;
        TrackGroup trackGroup2;
        int i2;
        int i3 = trackGroupInfo.embeddedEventMessageTrackGroupIndex;
        boolean z = i3 != -1;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandlerNewPlayerTrackEmsgHandler = null;
        if (z) {
            trackGroup = this.trackGroups.get(i3);
            i = 1;
        } else {
            i = 0;
            trackGroup = null;
        }
        int i4 = trackGroupInfo.embeddedCea608TrackGroupIndex;
        boolean z2 = i4 != -1;
        if (z2) {
            trackGroup2 = this.trackGroups.get(i4);
            i += trackGroup2.length;
        } else {
            trackGroup2 = null;
        }
        Format[] formatArr = new Format[i];
        int[] iArr = new int[i];
        if (z) {
            formatArr[0] = trackGroup.getFormat(0);
            iArr[0] = 4;
            i2 = 1;
        } else {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            for (int i5 = 0; i5 < trackGroup2.length; i5++) {
                Format format = trackGroup2.getFormat(i5);
                formatArr[i2] = format;
                iArr[i2] = 3;
                arrayList.add(format);
                i2++;
            }
        }
        if (this.manifest.dynamic && z) {
            playerTrackEmsgHandlerNewPlayerTrackEmsgHandler = this.playerEmsgHandler.newPlayerTrackEmsgHandler();
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = playerTrackEmsgHandlerNewPlayerTrackEmsgHandler;
        ChunkSampleStream<DashChunkSource> chunkSampleStream = new ChunkSampleStream<>(trackGroupInfo.trackType, iArr, formatArr, this.chunkSourceFactory.createDashChunkSource(this.manifestLoaderErrorThrower, this.manifest, this.periodIndex, trackGroupInfo.adaptationSetIndices, selection, trackGroupInfo.trackType, this.elapsedRealtimeOffsetMs, z, arrayList, playerTrackEmsgHandler, this.transferListener), this, this.allocator, positionUs, this.drmSessionManager, this.loadErrorHandlingPolicy, this.eventDispatcher);
        synchronized (this) {
            this.trackEmsgHandlerBySampleStream.put(chunkSampleStream, playerTrackEmsgHandler);
        }
        return chunkSampleStream;
    }

    private static Descriptor findAdaptationSetSwitchingProperty(List<Descriptor> descriptors) {
        for (int i = 0; i < descriptors.size(); i++) {
            Descriptor descriptor = descriptors.get(i);
            if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(descriptor.schemeIdUri)) {
                return descriptor;
            }
        }
        return null;
    }

    private static boolean hasEventMessageTrack(List<AdaptationSet> adaptationSets, int[] adaptationSetIndices) {
        for (int i : adaptationSetIndices) {
            List<Representation> list = adaptationSets.get(i).representations;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (!list.get(i2).inbandEventStreams.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Format[] getCea608TrackFormats(List<AdaptationSet> adaptationSets, int[] adaptationSetIndices) {
        for (int i : adaptationSetIndices) {
            AdaptationSet adaptationSet = adaptationSets.get(i);
            List<Descriptor> list = adaptationSets.get(i).accessibilityDescriptors;
            for (int i2 = 0; i2 < list.size(); i2++) {
                Descriptor descriptor = list.get(i2);
                if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri)) {
                    String str = descriptor.value;
                    if (str == null) {
                        return new Format[]{buildCea608TrackFormat(adaptationSet.id)};
                    }
                    String[] strArrSplit = Util.split(str, ";");
                    Format[] formatArr = new Format[strArrSplit.length];
                    for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                        Matcher matcher = CEA608_SERVICE_DESCRIPTOR_REGEX.matcher(strArrSplit[i3]);
                        if (!matcher.matches()) {
                            return new Format[]{buildCea608TrackFormat(adaptationSet.id)};
                        }
                        formatArr[i3] = buildCea608TrackFormat(adaptationSet.id, matcher.group(2), Integer.parseInt(matcher.group(1)));
                    }
                    return formatArr;
                }
            }
        }
        return new Format[0];
    }

    private static Format buildCea608TrackFormat(int adaptationSetId) {
        return buildCea608TrackFormat(adaptationSetId, null, -1);
    }

    private static Format buildCea608TrackFormat(int adaptationSetId, String language, int accessibilityChannel) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(adaptationSetId);
        sb.append(":cea608");
        if (accessibilityChannel != -1) {
            str = ":" + accessibilityChannel;
        } else {
            str = "";
        }
        sb.append(str);
        return new Format.Builder().setId(sb.toString()).setSampleMimeType("application/cea-608").setLanguage(language).setAccessibilityChannel(accessibilityChannel).build();
    }

    private static ChunkSampleStream<DashChunkSource>[] newSampleStreamArray(int length) {
        return new ChunkSampleStream[length];
    }

    private static final class TrackGroupInfo {
        public final int[] adaptationSetIndices;
        public final int embeddedCea608TrackGroupIndex;
        public final int embeddedEventMessageTrackGroupIndex;
        public final int eventStreamGroupIndex;
        public final int primaryTrackGroupIndex;
        public final int trackGroupCategory;
        public final int trackType;

        public static TrackGroupInfo primaryTrack(int trackType, int[] adaptationSetIndices, int primaryTrackGroupIndex, int embeddedEventMessageTrackGroupIndex, int embeddedCea608TrackGroupIndex) {
            return new TrackGroupInfo(trackType, 0, adaptationSetIndices, primaryTrackGroupIndex, embeddedEventMessageTrackGroupIndex, embeddedCea608TrackGroupIndex, -1);
        }

        public static TrackGroupInfo embeddedEmsgTrack(int[] adaptationSetIndices, int primaryTrackGroupIndex) {
            return new TrackGroupInfo(4, 1, adaptationSetIndices, primaryTrackGroupIndex, -1, -1, -1);
        }

        public static TrackGroupInfo embeddedCea608Track(int[] adaptationSetIndices, int primaryTrackGroupIndex) {
            return new TrackGroupInfo(3, 1, adaptationSetIndices, primaryTrackGroupIndex, -1, -1, -1);
        }

        public static TrackGroupInfo mpdEventTrack(int eventStreamIndex) {
            return new TrackGroupInfo(4, 2, new int[0], -1, -1, -1, eventStreamIndex);
        }

        private TrackGroupInfo(int trackType, int trackGroupCategory, int[] adaptationSetIndices, int primaryTrackGroupIndex, int embeddedEventMessageTrackGroupIndex, int embeddedCea608TrackGroupIndex, int eventStreamGroupIndex) {
            this.trackType = trackType;
            this.adaptationSetIndices = adaptationSetIndices;
            this.trackGroupCategory = trackGroupCategory;
            this.primaryTrackGroupIndex = primaryTrackGroupIndex;
            this.embeddedEventMessageTrackGroupIndex = embeddedEventMessageTrackGroupIndex;
            this.embeddedCea608TrackGroupIndex = embeddedCea608TrackGroupIndex;
            this.eventStreamGroupIndex = eventStreamGroupIndex;
        }
    }
}
