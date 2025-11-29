package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.drm.HttpMediaDrmCallback;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private final DataSource.Factory dataSourceFactory;
    private HttpDataSource.Factory drmHttpDataSourceFactory;
    private DrmSessionManager drmSessionManager = DrmSessionManager.getDummyDrmSessionManager();
    private final SparseArray<MediaSourceFactory> mediaSourceFactories;
    private List<StreamKey> streamKeys;
    private final int[] supportedTypes;
    private final String userAgent;

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    @Deprecated
    public /* bridge */ /* synthetic */ MediaSourceFactory setStreamKeys(List streamKeys) {
        return setStreamKeys((List<StreamKey>) streamKeys);
    }

    public static DefaultMediaSourceFactory newInstance(Context context) {
        return newInstance(context, new DefaultDataSourceFactory(context, Util.getUserAgent(context, "ExoPlayerLib/2.11.4")));
    }

    public static DefaultMediaSourceFactory newInstance(Context context, DataSource.Factory dataSourceFactory) {
        return new DefaultMediaSourceFactory(context, dataSourceFactory);
    }

    private DefaultMediaSourceFactory(Context context, DataSource.Factory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
        String userAgent = Util.getUserAgent(context, "ExoPlayerLib/2.11.4");
        this.userAgent = userAgent;
        this.drmHttpDataSourceFactory = new DefaultHttpDataSourceFactory(userAgent);
        SparseArray<MediaSourceFactory> sparseArrayLoadDelegates = loadDelegates(dataSourceFactory);
        this.mediaSourceFactories = sparseArrayLoadDelegates;
        this.supportedTypes = new int[sparseArrayLoadDelegates.size()];
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.supportedTypes[i] = this.mediaSourceFactories.keyAt(i);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public DefaultMediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager) {
        if (drmSessionManager == null) {
            drmSessionManager = DrmSessionManager.getDummyDrmSessionManager();
        }
        this.drmSessionManager = drmSessionManager;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    @Deprecated
    public DefaultMediaSourceFactory setStreamKeys(List<StreamKey> streamKeys) {
        if (streamKeys == null || streamKeys.isEmpty()) {
            streamKeys = null;
        }
        this.streamKeys = streamKeys;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceFactory
    public MediaSource createMediaSource(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.playbackProperties);
        MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
        int iInferContentType = inferContentType(playbackProperties.sourceUri, playbackProperties.mimeType);
        MediaSourceFactory mediaSourceFactory = this.mediaSourceFactories.get(iInferContentType);
        Assertions.checkNotNull(mediaSourceFactory, "No suitable media source factory found for content type: " + iInferContentType);
        mediaSourceFactory.setDrmSessionManager(createDrmSessionManager(mediaItem));
        mediaSourceFactory.setStreamKeys(!mediaItem.playbackProperties.streamKeys.isEmpty() ? mediaItem.playbackProperties.streamKeys : this.streamKeys);
        MediaSource mediaSourceCreateMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
        List<MediaItem.Subtitle> list = mediaItem.playbackProperties.subtitles;
        if (list.isEmpty()) {
            return maybeClipMediaSource(mediaItem, mediaSourceCreateMediaSource);
        }
        MediaSource[] mediaSourceArr = new MediaSource[list.size() + 1];
        int i = 0;
        mediaSourceArr[0] = mediaSourceCreateMediaSource;
        SingleSampleMediaSource.Factory factory = new SingleSampleMediaSource.Factory(this.dataSourceFactory);
        while (i < list.size()) {
            MediaItem.Subtitle subtitle = list.get(i);
            i++;
            mediaSourceArr[i] = factory.createMediaSource(subtitle.uri, new Format.Builder().setSampleMimeType(subtitle.mimeType).setLanguage(subtitle.language).setSelectionFlags(subtitle.selectionFlags).build(), -9223372036854775807L);
        }
        return maybeClipMediaSource(mediaItem, new MergingMediaSource(mediaSourceArr));
    }

    private DrmSessionManager createDrmSessionManager(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.playbackProperties);
        MediaItem.DrmConfiguration drmConfiguration = mediaItem.playbackProperties.drmConfiguration;
        if (drmConfiguration == null || drmConfiguration.licenseUri == null || Util.SDK_INT < 18) {
            return this.drmSessionManager;
        }
        return new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(mediaItem.playbackProperties.drmConfiguration.uuid, FrameworkMediaDrm.DEFAULT_PROVIDER).setMultiSession(mediaItem.playbackProperties.drmConfiguration.multiSession).setPlayClearSamplesWithoutKeys(mediaItem.playbackProperties.drmConfiguration.playClearContentWithoutKey).setUseDrmSessionsForClearContent(Util.toArray(mediaItem.playbackProperties.drmConfiguration.sessionForClearTypes)).build(createHttpMediaDrmCallback(mediaItem.playbackProperties.drmConfiguration));
    }

    private MediaDrmCallback createHttpMediaDrmCallback(MediaItem.DrmConfiguration drmConfiguration) {
        Assertions.checkNotNull(drmConfiguration.licenseUri);
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(drmConfiguration.licenseUri.toString(), this.drmHttpDataSourceFactory);
        for (Map.Entry<String, String> entry : drmConfiguration.requestHeaders.entrySet()) {
            httpMediaDrmCallback.setKeyRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpMediaDrmCallback;
    }

    private static MediaSource maybeClipMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        MediaItem.ClippingProperties clippingProperties = mediaItem.clippingProperties;
        long j = clippingProperties.startPositionMs;
        if (j == 0 && clippingProperties.endPositionMs == Long.MIN_VALUE && !clippingProperties.relativeToDefaultPosition) {
            return mediaSource;
        }
        long jMsToUs = C.msToUs(j);
        long jMsToUs2 = C.msToUs(mediaItem.clippingProperties.endPositionMs);
        MediaItem.ClippingProperties clippingProperties2 = mediaItem.clippingProperties;
        return new ClippingMediaSource(mediaSource, jMsToUs, jMsToUs2, !clippingProperties2.startsAtKeyFrame, clippingProperties2.relativeToLiveWindow, clippingProperties2.relativeToDefaultPosition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static SparseArray<MediaSourceFactory> loadDelegates(DataSource.Factory dataSourceFactory) {
        SparseArray<MediaSourceFactory> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, DashMediaSource.Factory.class.asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(dataSourceFactory));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, Class.forName("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(dataSourceFactory));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(DataSource.Factory.class).newInstance(dataSourceFactory));
        } catch (Exception unused3) {
        }
        sparseArray.put(3, new ProgressiveMediaSource.Factory(dataSourceFactory));
        return sparseArray;
    }

    private static int inferContentType(Uri sourceUri, String mimeType) {
        if (mimeType == null) {
            return Util.inferContentType(sourceUri);
        }
        switch (mimeType) {
        }
        return Util.inferContentType(sourceUri);
    }
}
