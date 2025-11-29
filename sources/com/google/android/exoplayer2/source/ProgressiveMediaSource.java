package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {
    private final int continueLoadingCheckIntervalBytes;
    private final String customCacheKey;
    private final DataSource.Factory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final ExtractorsFactory extractorsFactory;
    private final LoadErrorHandlingPolicy loadableLoadErrorHandlingPolicy;
    private final Object tag;
    private boolean timelineIsLive;
    private boolean timelineIsSeekable;
    private TransferListener transferListener;
    private final Uri uri;
    private boolean timelineIsPlaceholder = true;
    private long timelineDurationUs = -9223372036854775807L;

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    public static final class Factory implements MediaSourceFactory {
        private int continueLoadingCheckIntervalBytes;
        private String customCacheKey;
        private final DataSource.Factory dataSourceFactory;
        private DrmSessionManager drmSessionManager;
        private ExtractorsFactory extractorsFactory;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private Object tag;

        public Factory(DataSource.Factory dataSourceFactory) {
            this(dataSourceFactory, new DefaultExtractorsFactory());
        }

        public Factory(DataSource.Factory dataSourceFactory, ExtractorsFactory extractorsFactory) {
            this.dataSourceFactory = dataSourceFactory;
            this.extractorsFactory = extractorsFactory;
            this.drmSessionManager = DrmSessionManager.getDummyDrmSessionManager();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.continueLoadingCheckIntervalBytes = 1048576;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
            if (drmSessionManager == null) {
                drmSessionManager = DrmSessionManager.getDummyDrmSessionManager();
            }
            this.drmSessionManager = drmSessionManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public ProgressiveMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.playbackProperties);
            MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            Uri uri = playbackProperties.sourceUri;
            DataSource.Factory factory = this.dataSourceFactory;
            ExtractorsFactory extractorsFactory = this.extractorsFactory;
            DrmSessionManager drmSessionManager = this.drmSessionManager;
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
            String str = playbackProperties.customCacheKey;
            if (str == null) {
                str = this.customCacheKey;
            }
            String str2 = str;
            int i = this.continueLoadingCheckIntervalBytes;
            Object obj = playbackProperties.tag;
            if (obj == null) {
                obj = this.tag;
            }
            return new ProgressiveMediaSource(uri, factory, extractorsFactory, drmSessionManager, loadErrorHandlingPolicy, str2, i, obj);
        }
    }

    ProgressiveMediaSource(Uri uri, DataSource.Factory dataSourceFactory, ExtractorsFactory extractorsFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadableLoadErrorHandlingPolicy, String customCacheKey, int continueLoadingCheckIntervalBytes, Object tag) {
        this.uri = uri;
        this.dataSourceFactory = dataSourceFactory;
        this.extractorsFactory = extractorsFactory;
        this.drmSessionManager = drmSessionManager;
        this.loadableLoadErrorHandlingPolicy = loadableLoadErrorHandlingPolicy;
        this.customCacheKey = customCacheKey;
        this.continueLoadingCheckIntervalBytes = continueLoadingCheckIntervalBytes;
        this.tag = tag;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.tag;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void prepareSourceInternal(TransferListener mediaTransferListener) {
        this.transferListener = mediaTransferListener;
        this.drmSessionManager.prepare();
        notifySourceInfoRefreshed();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId id, Allocator allocator, long startPositionUs) {
        DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
        TransferListener transferListener = this.transferListener;
        if (transferListener != null) {
            dataSourceCreateDataSource.addTransferListener(transferListener);
        }
        return new ProgressiveMediaPeriod(this.uri, dataSourceCreateDataSource, this.extractorsFactory.createExtractors(), this.drmSessionManager, this.loadableLoadErrorHandlingPolicy, createEventDispatcher(id), this, allocator, this.customCacheKey, this.continueLoadingCheckIntervalBytes);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void releaseSourceInternal() {
        this.drmSessionManager.release();
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaPeriod.Listener
    public void onSourceInfoRefreshed(long durationUs, boolean isSeekable, boolean isLive) {
        if (durationUs == -9223372036854775807L) {
            durationUs = this.timelineDurationUs;
        }
        if (!this.timelineIsPlaceholder && this.timelineDurationUs == durationUs && this.timelineIsSeekable == isSeekable && this.timelineIsLive == isLive) {
            return;
        }
        this.timelineDurationUs = durationUs;
        this.timelineIsSeekable = isSeekable;
        this.timelineIsLive = isLive;
        this.timelineIsPlaceholder = false;
        notifySourceInfoRefreshed();
    }

    private void notifySourceInfoRefreshed() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false, this.timelineIsLive, null, this.tag);
        if (this.timelineIsPlaceholder) {
            singlePeriodTimeline = new ForwardingTimeline(singlePeriodTimeline) { // from class: com.google.android.exoplayer2.source.ProgressiveMediaSource.1
                @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
                public Timeline.Window getWindow(int windowIndex, Timeline.Window window, long defaultPositionProjectionUs) {
                    super.getWindow(windowIndex, window, defaultPositionProjectionUs);
                    window.isPlaceholder = true;
                    return window;
                }
            };
        }
        refreshSourceInfo(singlePeriodTimeline);
    }
}
