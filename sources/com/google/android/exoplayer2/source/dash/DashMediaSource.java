package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* loaded from: classes2.dex */
public final class DashMediaSource extends BaseMediaSource {
    private final DashChunkSource.Factory chunkSourceFactory;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private DataSource dataSource;
    private final DrmSessionManager drmSessionManager;
    private long elapsedRealtimeOffsetMs;
    private long expiredManifestPublishTimeUs;
    private int firstPeriodId;
    private Handler handler;
    private Uri initialManifestUri;
    private final long livePresentationDelayMs;
    private final boolean livePresentationDelayOverridesManifest;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private Loader loader;
    private DashManifest manifest;
    private final ManifestCallback manifestCallback;
    private final DataSource.Factory manifestDataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher manifestEventDispatcher;
    private IOException manifestFatalError;
    private long manifestLoadEndTimestampMs;
    private final LoaderErrorThrower manifestLoadErrorThrower;
    private boolean manifestLoadPending;
    private long manifestLoadStartTimestampMs;
    private final ParsingLoadable.Parser<? extends DashManifest> manifestParser;
    private Uri manifestUri;
    private final Object manifestUriLock;
    private TransferListener mediaTransferListener;
    private final SparseArray<DashMediaPeriod> periodsById;
    private final PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback;
    private final Runnable refreshManifestRunnable;
    private final boolean sideloadedManifest;
    private final Runnable simulateManifestRefreshRunnable;
    private int staleManifestReloadAttempt;
    private final Object tag;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    public static final class Factory implements MediaSourceFactory {
        private final DashChunkSource.Factory chunkSourceFactory;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManager drmSessionManager;
        private long livePresentationDelayMs;
        private boolean livePresentationDelayOverridesManifest;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private final DataSource.Factory manifestDataSourceFactory;
        private ParsingLoadable.Parser<? extends DashManifest> manifestParser;
        private List<StreamKey> streamKeys;
        private Object tag;

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public /* bridge */ /* synthetic */ MediaSourceFactory setStreamKeys(List streamKeys) {
            return setStreamKeys((List<StreamKey>) streamKeys);
        }

        public Factory(DataSource.Factory dataSourceFactory) {
            this(new DefaultDashChunkSource.Factory(dataSourceFactory), dataSourceFactory);
        }

        public Factory(DashChunkSource.Factory chunkSourceFactory, DataSource.Factory manifestDataSourceFactory) {
            this.chunkSourceFactory = (DashChunkSource.Factory) Assertions.checkNotNull(chunkSourceFactory);
            this.manifestDataSourceFactory = manifestDataSourceFactory;
            this.drmSessionManager = DrmSessionManager.getDummyDrmSessionManager();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.livePresentationDelayMs = UtilsKt.UPDATE_INTERVAL;
            this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
            this.streamKeys = Collections.emptyList();
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public Factory setStreamKeys(List<StreamKey> streamKeys) {
            if (streamKeys == null) {
                streamKeys = Collections.emptyList();
            }
            this.streamKeys = streamKeys;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
            if (drmSessionManager == null) {
                drmSessionManager = DrmSessionManager.getDummyDrmSessionManager();
            }
            this.drmSessionManager = drmSessionManager;
            return this;
        }

        public Factory setManifestParser(ParsingLoadable.Parser<? extends DashManifest> manifestParser) {
            this.manifestParser = manifestParser;
            return this;
        }

        @Deprecated
        public DashMediaSource createMediaSource(Uri uri) {
            return createMediaSource(MediaItem.fromUri(uri));
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public DashMediaSource createMediaSource(MediaItem mediaItem) {
            Assertions.checkNotNull(mediaItem.playbackProperties);
            ParsingLoadable.Parser dashManifestParser = this.manifestParser;
            if (dashManifestParser == null) {
                dashManifestParser = new DashManifestParser();
            }
            List<StreamKey> list = !mediaItem.playbackProperties.streamKeys.isEmpty() ? mediaItem.playbackProperties.streamKeys : this.streamKeys;
            ParsingLoadable.Parser filteringManifestParser = !list.isEmpty() ? new FilteringManifestParser(dashManifestParser, list) : dashManifestParser;
            MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            Uri uri = playbackProperties.sourceUri;
            DataSource.Factory factory = this.manifestDataSourceFactory;
            DashChunkSource.Factory factory2 = this.chunkSourceFactory;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.compositeSequenceableLoaderFactory;
            DrmSessionManager drmSessionManager = this.drmSessionManager;
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
            long j = this.livePresentationDelayMs;
            boolean z = this.livePresentationDelayOverridesManifest;
            Object obj = playbackProperties.tag;
            if (obj == null) {
                obj = this.tag;
            }
            return new DashMediaSource(null, uri, factory, filteringManifestParser, factory2, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, j, z, obj);
        }
    }

    private DashMediaSource(DashManifest manifest, Uri manifestUri, DataSource.Factory manifestDataSourceFactory, ParsingLoadable.Parser<? extends DashManifest> manifestParser, DashChunkSource.Factory chunkSourceFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long livePresentationDelayMs, boolean livePresentationDelayOverridesManifest, Object tag) {
        this.initialManifestUri = manifestUri;
        this.manifest = manifest;
        this.manifestUri = manifestUri;
        this.manifestDataSourceFactory = manifestDataSourceFactory;
        this.manifestParser = manifestParser;
        this.chunkSourceFactory = chunkSourceFactory;
        this.drmSessionManager = drmSessionManager;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.livePresentationDelayMs = livePresentationDelayMs;
        this.livePresentationDelayOverridesManifest = livePresentationDelayOverridesManifest;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.tag = tag;
        boolean z = manifest != null;
        this.sideloadedManifest = z;
        this.manifestEventDispatcher = createEventDispatcher(null);
        this.manifestUriLock = new Object();
        this.periodsById = new SparseArray<>();
        this.playerEmsgCallback = new DefaultPlayerEmsgCallback();
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        this.elapsedRealtimeOffsetMs = -9223372036854775807L;
        if (z) {
            Assertions.checkState(!manifest.dynamic);
            this.manifestCallback = null;
            this.refreshManifestRunnable = null;
            this.simulateManifestRefreshRunnable = null;
            this.manifestLoadErrorThrower = new LoaderErrorThrower.Dummy();
            return;
        }
        this.manifestCallback = new ManifestCallback();
        this.manifestLoadErrorThrower = new ManifestLoadErrorThrower();
        this.refreshManifestRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.DashMediaSource$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.startLoadingManifest();
            }
        };
        this.simulateManifestRefreshRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.DashMediaSource$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        processManifest(false);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.tag;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void prepareSourceInternal(TransferListener mediaTransferListener) {
        this.mediaTransferListener = mediaTransferListener;
        this.drmSessionManager.prepare();
        if (this.sideloadedManifest) {
            processManifest(false);
            return;
        }
        this.dataSource = this.manifestDataSourceFactory.createDataSource();
        this.loader = new Loader("Loader:DashMediaSource");
        this.handler = Util.createHandler();
        startLoadingManifest();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.manifestLoadErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId periodId, Allocator allocator, long startPositionUs) {
        int iIntValue = ((Integer) periodId.periodUid).intValue() - this.firstPeriodId;
        DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(this.firstPeriodId + iIntValue, this.manifest, iIntValue, this.chunkSourceFactory, this.mediaTransferListener, this.drmSessionManager, this.loadErrorHandlingPolicy, createEventDispatcher(periodId, this.manifest.getPeriod(iIntValue).startMs), this.elapsedRealtimeOffsetMs, this.manifestLoadErrorThrower, allocator, this.compositeSequenceableLoaderFactory, this.playerEmsgCallback);
        this.periodsById.put(dashMediaPeriod.id, dashMediaPeriod);
        return dashMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.release();
        this.periodsById.remove(dashMediaPeriod.id);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void releaseSourceInternal() {
        this.manifestLoadPending = false;
        this.dataSource = null;
        Loader loader = this.loader;
        if (loader != null) {
            loader.release();
            this.loader = null;
        }
        this.manifestLoadStartTimestampMs = 0L;
        this.manifestLoadEndTimestampMs = 0L;
        this.manifest = this.sideloadedManifest ? this.manifest : null;
        this.manifestUri = this.initialManifestUri;
        this.manifestFatalError = null;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.elapsedRealtimeOffsetMs = -9223372036854775807L;
        this.staleManifestReloadAttempt = 0;
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        this.firstPeriodId = 0;
        this.periodsById.clear();
        this.drmSessionManager.release();
    }

    public DashManifest getManifest() {
        return this.manifest;
    }

    void onDashManifestRefreshRequested() {
        this.handler.removeCallbacks(this.simulateManifestRefreshRunnable);
        startLoadingManifest();
    }

    void onDashManifestPublishTimeExpired(long expiredManifestPublishTimeUs) {
        long j = this.expiredManifestPublishTimeUs;
        if (j == -9223372036854775807L || j < expiredManifestPublishTimeUs) {
            this.expiredManifestPublishTimeUs = expiredManifestPublishTimeUs;
        }
    }

    void onManifestLoadCompleted(ParsingLoadable<DashManifest> loadable, long elapsedRealtimeMs, long loadDurationMs) {
        this.manifestEventDispatcher.loadCompleted(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
        DashManifest result = loadable.getResult();
        DashManifest dashManifest = this.manifest;
        int periodCount = dashManifest == null ? 0 : dashManifest.getPeriodCount();
        long j = result.getPeriod(0).startMs;
        int i = 0;
        while (i < periodCount && this.manifest.getPeriod(i).startMs < j) {
            i++;
        }
        if (result.dynamic) {
            if (periodCount - i > result.getPeriodCount()) {
                Log.w("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j2 = this.expiredManifestPublishTimeUs;
                if (j2 != -9223372036854775807L && result.publishTimeMs * 1000 <= j2) {
                    Log.w("DashMediaSource", "Loaded stale dynamic manifest: " + result.publishTimeMs + ", " + this.expiredManifestPublishTimeUs);
                } else {
                    this.staleManifestReloadAttempt = 0;
                }
            }
            int i2 = this.staleManifestReloadAttempt;
            this.staleManifestReloadAttempt = i2 + 1;
            if (i2 < this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(loadable.type)) {
                scheduleManifestRefresh(getManifestLoadRetryDelayMillis());
                return;
            } else {
                this.manifestFatalError = new DashManifestStaleException();
                return;
            }
        }
        this.manifest = result;
        this.manifestLoadPending = result.dynamic & this.manifestLoadPending;
        this.manifestLoadStartTimestampMs = elapsedRealtimeMs - loadDurationMs;
        this.manifestLoadEndTimestampMs = elapsedRealtimeMs;
        synchronized (this.manifestUriLock) {
            try {
                if (loadable.dataSpec.uri == this.manifestUri) {
                    Uri uri = this.manifest.location;
                    if (uri == null) {
                        uri = loadable.getUri();
                    }
                    this.manifestUri = uri;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (periodCount == 0) {
            DashManifest dashManifest2 = this.manifest;
            if (dashManifest2.dynamic) {
                UtcTimingElement utcTimingElement = dashManifest2.utcTiming;
                if (utcTimingElement != null) {
                    resolveUtcTimingElement(utcTimingElement);
                    return;
                } else {
                    loadNtpTimeOffset();
                    return;
                }
            }
            processManifest(true);
            return;
        }
        this.firstPeriodId += i;
        processManifest(true);
    }

    Loader.LoadErrorAction onManifestLoadError(ParsingLoadable<DashManifest> loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
        Loader.LoadErrorAction loadErrorActionCreateRetryAction;
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(4, loadDurationMs, error, errorCount);
        if (retryDelayMsFor == -9223372036854775807L) {
            loadErrorActionCreateRetryAction = Loader.DONT_RETRY_FATAL;
        } else {
            loadErrorActionCreateRetryAction = Loader.createRetryAction(false, retryDelayMsFor);
        }
        this.manifestEventDispatcher.loadError(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded(), error, !loadErrorActionCreateRetryAction.isRetry());
        return loadErrorActionCreateRetryAction;
    }

    void onUtcTimestampLoadCompleted(ParsingLoadable<Long> loadable, long elapsedRealtimeMs, long loadDurationMs) {
        this.manifestEventDispatcher.loadCompleted(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
        onUtcTimestampResolved(loadable.getResult().longValue() - elapsedRealtimeMs);
    }

    Loader.LoadErrorAction onUtcTimestampLoadError(ParsingLoadable<Long> loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error) {
        this.manifestEventDispatcher.loadError(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded(), error, true);
        onUtcTimestampResolutionError(error);
        return Loader.DONT_RETRY;
    }

    void onLoadCanceled(ParsingLoadable<?> loadable, long elapsedRealtimeMs, long loadDurationMs) {
        this.manifestEventDispatcher.loadCanceled(loadable.dataSpec, loadable.getUri(), loadable.getResponseHeaders(), loadable.type, elapsedRealtimeMs, loadDurationMs, loadable.bytesLoaded());
    }

    private void resolveUtcTimingElement(UtcTimingElement timingElement) {
        String str = timingElement.schemeIdUri;
        if (Util.areEqual(str, "urn:mpeg:dash:utc:direct:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:direct:2012")) {
            resolveUtcTimingElementDirect(timingElement);
            return;
        }
        if (Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            resolveUtcTimingElementHttp(timingElement, new Iso8601Parser());
            return;
        }
        if (Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            resolveUtcTimingElementHttp(timingElement, new XsDateTimeParser());
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:ntp:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:ntp:2012")) {
            loadNtpTimeOffset();
        } else {
            onUtcTimestampResolutionError(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void resolveUtcTimingElementDirect(UtcTimingElement timingElement) {
        try {
            onUtcTimestampResolved(Util.parseXsDateTime(timingElement.value) - this.manifestLoadEndTimestampMs);
        } catch (ParserException e) {
            onUtcTimestampResolutionError(e);
        }
    }

    private void resolveUtcTimingElementHttp(UtcTimingElement timingElement, ParsingLoadable.Parser<Long> parser) {
        startLoading(new ParsingLoadable(this.dataSource, Uri.parse(timingElement.value), 5, parser), new UtcTimestampCallback(), 1);
    }

    private void loadNtpTimeOffset() {
        SntpClient.initialize(this.loader, new SntpClient.InitializationCallback() { // from class: com.google.android.exoplayer2.source.dash.DashMediaSource.1
            @Override // com.google.android.exoplayer2.util.SntpClient.InitializationCallback
            public void onInitialized() {
                DashMediaSource.this.onUtcTimestampResolved(SntpClient.getElapsedRealtimeOffsetMs());
            }

            @Override // com.google.android.exoplayer2.util.SntpClient.InitializationCallback
            public void onInitializationFailed(IOException error) {
                DashMediaSource.this.onUtcTimestampResolutionError(error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUtcTimestampResolved(long elapsedRealtimeOffsetMs) {
        this.elapsedRealtimeOffsetMs = elapsedRealtimeOffsetMs;
        processManifest(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUtcTimestampResolutionError(IOException error) {
        Log.e("DashMediaSource", "Failed to resolve time offset.", error);
        processManifest(true);
    }

    private void processManifest(boolean scheduleRefresh) {
        boolean z;
        long j;
        for (int i = 0; i < this.periodsById.size(); i++) {
            int iKeyAt = this.periodsById.keyAt(i);
            if (iKeyAt >= this.firstPeriodId) {
                this.periodsById.valueAt(i).updateManifest(this.manifest, iKeyAt - this.firstPeriodId);
            }
        }
        int periodCount = this.manifest.getPeriodCount() - 1;
        PeriodSeekInfo periodSeekInfoCreatePeriodSeekInfo = PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(0), this.manifest.getPeriodDurationBySegmentsUs(0));
        PeriodSeekInfo periodSeekInfoCreatePeriodSeekInfo2 = PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(periodCount), this.manifest.getPeriodDurationBySegmentsUs(periodCount));
        long periodDurationBySegmentsUs = periodSeekInfoCreatePeriodSeekInfo.availableStartTimeUs;
        long jMin = periodSeekInfoCreatePeriodSeekInfo2.availableEndTimeUs;
        if (!this.manifest.dynamic || periodSeekInfoCreatePeriodSeekInfo2.isIndexExplicit) {
            z = false;
        } else {
            jMin = Math.min((C.msToUs(Util.getNowUnixTimeMs(this.elapsedRealtimeOffsetMs)) - C.msToUs(this.manifest.availabilityStartTimeMs)) - C.msToUs(this.manifest.getPeriod(periodCount).startMs), jMin);
            long j2 = this.manifest.timeShiftBufferDepthMs;
            if (j2 != -9223372036854775807L) {
                long jMsToUs = jMin - C.msToUs(j2);
                while (jMsToUs < 0 && periodCount > 0) {
                    periodCount--;
                    jMsToUs += this.manifest.getPeriodDurationBySegmentsUs(periodCount);
                }
                if (periodCount == 0) {
                    periodDurationBySegmentsUs = Math.max(periodDurationBySegmentsUs, jMsToUs);
                } else {
                    periodDurationBySegmentsUs = this.manifest.getPeriodDurationBySegmentsUs(0);
                }
            }
            z = true;
        }
        long j3 = periodDurationBySegmentsUs;
        long periodDurationUs = jMin - j3;
        for (int i2 = 0; i2 < this.manifest.getPeriodCount() - 1; i2++) {
            periodDurationUs += this.manifest.getPeriodDurationUs(i2);
        }
        DashManifest dashManifest = this.manifest;
        if (dashManifest.dynamic) {
            long j4 = this.livePresentationDelayMs;
            if (!this.livePresentationDelayOverridesManifest) {
                long j5 = dashManifest.suggestedPresentationDelayMs;
                if (j5 != -9223372036854775807L) {
                    j4 = j5;
                }
            }
            long jMsToUs2 = periodDurationUs - C.msToUs(j4);
            if (jMsToUs2 < 5000000) {
                jMsToUs2 = Math.min(5000000L, periodDurationUs / 2);
            }
            j = jMsToUs2;
        } else {
            j = 0;
        }
        DashManifest dashManifest2 = this.manifest;
        long j6 = dashManifest2.availabilityStartTimeMs;
        long jUsToMs = j6 != -9223372036854775807L ? j6 + dashManifest2.getPeriod(0).startMs + C.usToMs(j3) : -9223372036854775807L;
        DashManifest dashManifest3 = this.manifest;
        refreshSourceInfo(new DashTimeline(dashManifest3.availabilityStartTimeMs, jUsToMs, this.elapsedRealtimeOffsetMs, this.firstPeriodId, j3, periodDurationUs, j, dashManifest3, this.tag));
        if (this.sideloadedManifest) {
            return;
        }
        this.handler.removeCallbacks(this.simulateManifestRefreshRunnable);
        long j7 = DeviceOrientationRequest.OUTPUT_PERIOD_FAST;
        if (z) {
            this.handler.postDelayed(this.simulateManifestRefreshRunnable, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
        }
        if (this.manifestLoadPending) {
            startLoadingManifest();
            return;
        }
        if (scheduleRefresh) {
            DashManifest dashManifest4 = this.manifest;
            if (dashManifest4.dynamic) {
                long j8 = dashManifest4.minUpdatePeriodMs;
                if (j8 != -9223372036854775807L) {
                    if (j8 != 0) {
                        j7 = j8;
                    }
                    scheduleManifestRefresh(Math.max(0L, (this.manifestLoadStartTimestampMs + j7) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    private void scheduleManifestRefresh(long delayUntilNextLoadMs) {
        this.handler.postDelayed(this.refreshManifestRunnable, delayUntilNextLoadMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingManifest() {
        Uri uri;
        this.handler.removeCallbacks(this.refreshManifestRunnable);
        if (this.loader.hasFatalError()) {
            return;
        }
        if (this.loader.isLoading()) {
            this.manifestLoadPending = true;
            return;
        }
        synchronized (this.manifestUriLock) {
            uri = this.manifestUri;
        }
        this.manifestLoadPending = false;
        startLoading(new ParsingLoadable(this.dataSource, uri, 4, this.manifestParser), this.manifestCallback, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(4));
    }

    private long getManifestLoadRetryDelayMillis() {
        return Math.min((this.staleManifestReloadAttempt - 1) * 1000, 5000);
    }

    private <T> void startLoading(ParsingLoadable<T> loadable, Loader.Callback<ParsingLoadable<T>> callback, int minRetryCount) {
        this.manifestEventDispatcher.loadStarted(loadable.dataSpec, loadable.type, this.loader.startLoading(loadable, callback, minRetryCount));
    }

    private static final class PeriodSeekInfo {
        public final long availableEndTimeUs;
        public final long availableStartTimeUs;
        public final boolean isIndexExplicit;

        /* JADX WARN: Removed duplicated region for block: B:19:0x0040 A[PHI: r12
  0x0040: PHI (r12v4 boolean) = (r12v2 boolean), (r12v1 boolean) binds: [B:27:0x0071, B:18:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo createPeriodSeekInfo(com.google.android.exoplayer2.source.dash.manifest.Period r20, long r21) {
            /*
                r0 = r20
                r4 = r21
                java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> r1 = r0.adaptationSets
                int r1 = r1.size()
                r2 = 0
                r3 = r2
            Lc:
                r6 = 1
                if (r3 >= r1) goto L24
                java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> r7 = r0.adaptationSets
                java.lang.Object r7 = r7.get(r3)
                com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r7 = (com.google.android.exoplayer2.source.dash.manifest.AdaptationSet) r7
                int r7 = r7.type
                if (r7 == r6) goto L22
                r8 = 2
                if (r7 != r8) goto L1f
                goto L22
            L1f:
                int r3 = r3 + 1
                goto Lc
            L22:
                r3 = r6
                goto L25
            L24:
                r3 = r2
            L25:
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r11 = r2
                r12 = r11
                r15 = r12
                r13 = 0
            L2f:
                if (r11 >= r1) goto La5
                java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> r6 = r0.adaptationSets
                java.lang.Object r6 = r6.get(r11)
                com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r6 = (com.google.android.exoplayer2.source.dash.manifest.AdaptationSet) r6
                if (r3 == 0) goto L44
                int r7 = r6.type
                r8 = 3
                if (r7 != r8) goto L44
            L40:
                r17 = r3
                r2 = r9
                goto L9d
            L44:
                java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> r6 = r6.representations
                java.lang.Object r6 = r6.get(r2)
                com.google.android.exoplayer2.source.dash.manifest.Representation r6 = (com.google.android.exoplayer2.source.dash.manifest.Representation) r6
                com.google.android.exoplayer2.source.dash.DashSegmentIndex r6 = r6.getIndex()
                if (r6 != 0) goto L5e
                com.google.android.exoplayer2.source.dash.DashMediaSource$PeriodSeekInfo r6 = new com.google.android.exoplayer2.source.dash.DashMediaSource$PeriodSeekInfo
                r1 = 1
                r2 = 0
                r0 = r6
                r4 = r21
                r0.<init>(r1, r2, r4)
                return r6
            L5e:
                boolean r7 = r6.isExplicit()
                r12 = r12 | r7
                int r7 = r6.getSegmentCount(r4)
                if (r7 != 0) goto L71
                r17 = r3
                r2 = 0
                r13 = 0
                r15 = 1
                goto L9d
            L71:
                if (r15 != 0) goto L40
                r17 = r3
                long r2 = r6.getFirstSegmentNum()
                r18 = r9
                long r8 = r6.getTimeUs(r2)
                long r13 = java.lang.Math.max(r13, r8)
                r8 = -1
                if (r7 == r8) goto L9b
                long r7 = (long) r7
                long r2 = r2 + r7
                r7 = 1
                long r2 = r2 - r7
                long r7 = r6.getTimeUs(r2)
                long r2 = r6.getDurationUs(r2, r4)
                long r7 = r7 + r2
                r2 = r18
                long r2 = java.lang.Math.min(r2, r7)
                goto L9d
            L9b:
                r2 = r18
            L9d:
                int r11 = r11 + 1
                r9 = r2
                r3 = r17
                r2 = 0
                r6 = 1
                goto L2f
            La5:
                r2 = r9
                com.google.android.exoplayer2.source.dash.DashMediaSource$PeriodSeekInfo r0 = new com.google.android.exoplayer2.source.dash.DashMediaSource$PeriodSeekInfo
                r11 = r0
                r15 = r2
                r11.<init>(r12, r13, r15)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo.createPeriodSeekInfo(com.google.android.exoplayer2.source.dash.manifest.Period, long):com.google.android.exoplayer2.source.dash.DashMediaSource$PeriodSeekInfo");
        }

        private PeriodSeekInfo(boolean isIndexExplicit, long availableStartTimeUs, long availableEndTimeUs) {
            this.isIndexExplicit = isIndexExplicit;
            this.availableStartTimeUs = availableStartTimeUs;
            this.availableEndTimeUs = availableEndTimeUs;
        }
    }

    private static final class DashTimeline extends Timeline {
        private final long elapsedRealtimeEpochOffsetMs;
        private final int firstPeriodId;
        private final DashManifest manifest;
        private final long offsetInFirstPeriodUs;
        private final long presentationStartTimeMs;
        private final long windowDefaultStartPositionUs;
        private final long windowDurationUs;
        private final long windowStartTimeMs;
        private final Object windowTag;

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }

        public DashTimeline(long presentationStartTimeMs, long windowStartTimeMs, long elapsedRealtimeEpochOffsetMs, int firstPeriodId, long offsetInFirstPeriodUs, long windowDurationUs, long windowDefaultStartPositionUs, DashManifest manifest, Object windowTag) {
            this.presentationStartTimeMs = presentationStartTimeMs;
            this.windowStartTimeMs = windowStartTimeMs;
            this.elapsedRealtimeEpochOffsetMs = elapsedRealtimeEpochOffsetMs;
            this.firstPeriodId = firstPeriodId;
            this.offsetInFirstPeriodUs = offsetInFirstPeriodUs;
            this.windowDurationUs = windowDurationUs;
            this.windowDefaultStartPositionUs = windowDefaultStartPositionUs;
            this.manifest = manifest;
            this.windowTag = windowTag;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.manifest.getPeriodCount();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int periodIndex, Timeline.Period period, boolean setIdentifiers) {
            Assertions.checkIndex(periodIndex, 0, getPeriodCount());
            return period.set(setIdentifiers ? this.manifest.getPeriod(periodIndex).id : null, setIdentifiers ? Integer.valueOf(this.firstPeriodId + periodIndex) : null, 0, this.manifest.getPeriodDurationBySegmentsUs(periodIndex), C.msToUs(this.manifest.getPeriod(periodIndex).startMs - this.manifest.getPeriod(0).startMs) - this.offsetInFirstPeriodUs);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int windowIndex, Timeline.Window window, long defaultPositionProjectionUs) {
            Assertions.checkIndex(windowIndex, 0, 1);
            long adjustedWindowDefaultStartPositionUs = getAdjustedWindowDefaultStartPositionUs(defaultPositionProjectionUs);
            Object obj = Timeline.Window.SINGLE_WINDOW_UID;
            Object obj2 = this.windowTag;
            DashManifest dashManifest = this.manifest;
            return window.set(obj, obj2, dashManifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.elapsedRealtimeEpochOffsetMs, true, isMovingLiveWindow(dashManifest), this.manifest.dynamic, adjustedWindowDefaultStartPositionUs, this.windowDurationUs, 0, getPeriodCount() - 1, this.offsetInFirstPeriodUs);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object uid) {
            int iIntValue;
            if ((uid instanceof Integer) && (iIntValue = ((Integer) uid).intValue() - this.firstPeriodId) >= 0 && iIntValue < getPeriodCount()) {
                return iIntValue;
            }
            return -1;
        }

        private long getAdjustedWindowDefaultStartPositionUs(long defaultPositionProjectionUs) {
            DashSegmentIndex index;
            long j = this.windowDefaultStartPositionUs;
            if (!isMovingLiveWindow(this.manifest)) {
                return j;
            }
            if (defaultPositionProjectionUs > 0) {
                j += defaultPositionProjectionUs;
                if (j > this.windowDurationUs) {
                    return -9223372036854775807L;
                }
            }
            long j2 = this.offsetInFirstPeriodUs + j;
            long periodDurationBySegmentsUs = this.manifest.getPeriodDurationBySegmentsUs(0);
            int i = 0;
            while (i < this.manifest.getPeriodCount() - 1 && j2 >= periodDurationBySegmentsUs) {
                j2 -= periodDurationBySegmentsUs;
                i++;
                periodDurationBySegmentsUs = this.manifest.getPeriodDurationBySegmentsUs(i);
            }
            Period period = this.manifest.getPeriod(i);
            int adaptationSetIndex = period.getAdaptationSetIndex(2);
            return (adaptationSetIndex == -1 || (index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex()) == null || index.getSegmentCount(periodDurationBySegmentsUs) == 0) ? j : (j + index.getTimeUs(index.getSegmentNum(j2, periodDurationBySegmentsUs))) - j2;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int periodIndex) {
            Assertions.checkIndex(periodIndex, 0, getPeriodCount());
            return Integer.valueOf(this.firstPeriodId + periodIndex);
        }

        private static boolean isMovingLiveWindow(DashManifest manifest) {
            return manifest.dynamic && manifest.minUpdatePeriodMs != -9223372036854775807L && manifest.durationMs == -9223372036854775807L;
        }
    }

    private final class DefaultPlayerEmsgCallback implements PlayerEmsgHandler.PlayerEmsgCallback {
        private DefaultPlayerEmsgCallback() {
        }

        @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
        public void onDashManifestRefreshRequested() {
            DashMediaSource.this.onDashManifestRefreshRequested();
        }

        @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
        public void onDashManifestPublishTimeExpired(long expiredManifestPublishTimeUs) {
            DashMediaSource.this.onDashManifestPublishTimeExpired(expiredManifestPublishTimeUs);
        }
    }

    private final class ManifestCallback implements Loader.Callback<ParsingLoadable<DashManifest>> {
        private ManifestCallback() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<DashManifest> loadable, long elapsedRealtimeMs, long loadDurationMs) {
            DashMediaSource.this.onManifestLoadCompleted(loadable, elapsedRealtimeMs, loadDurationMs);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<DashManifest> loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released) {
            DashMediaSource.this.onLoadCanceled(loadable, elapsedRealtimeMs, loadDurationMs);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public Loader.LoadErrorAction onLoadError(ParsingLoadable<DashManifest> loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
            return DashMediaSource.this.onManifestLoadError(loadable, elapsedRealtimeMs, loadDurationMs, error, errorCount);
        }
    }

    private final class UtcTimestampCallback implements Loader.Callback<ParsingLoadable<Long>> {
        private UtcTimestampCallback() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<Long> loadable, long elapsedRealtimeMs, long loadDurationMs) {
            DashMediaSource.this.onUtcTimestampLoadCompleted(loadable, elapsedRealtimeMs, loadDurationMs);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<Long> loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released) {
            DashMediaSource.this.onLoadCanceled(loadable, elapsedRealtimeMs, loadDurationMs);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public Loader.LoadErrorAction onLoadError(ParsingLoadable<Long> loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
            return DashMediaSource.this.onUtcTimestampLoadError(loadable, elapsedRealtimeMs, loadDurationMs, error);
        }
    }

    private static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        private XsDateTimeParser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(Util.parseXsDateTime(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {
        private static final Pattern TIMESTAMP_WITH_TIMEZONE_PATTERN = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        Iso8601Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public Long parse(Uri uri, InputStream inputStream) throws IOException, NumberFormatException {
            String line = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8"))).readLine();
            try {
                Matcher matcher = TIMESTAMP_WITH_TIMEZONE_PATTERN.matcher(line);
                if (!matcher.matches()) {
                    throw new ParserException("Couldn't parse timestamp: " + line);
                }
                String strGroup = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(strGroup).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long j2 = Long.parseLong(matcher.group(5));
                    String strGroup2 = matcher.group(7);
                    time -= j * (((j2 * 60) + (TextUtils.isEmpty(strGroup2) ? 0L : Long.parseLong(strGroup2))) * 60000);
                }
                return Long.valueOf(time);
            } catch (ParseException e) {
                throw new ParserException(e);
            }
        }
    }

    final class ManifestLoadErrorThrower implements LoaderErrorThrower {
        ManifestLoadErrorThrower() {
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() throws IOException {
            DashMediaSource.this.loader.maybeThrowError();
            maybeThrowManifestError();
        }

        private void maybeThrowManifestError() throws IOException {
            if (DashMediaSource.this.manifestFatalError != null) {
                throw DashMediaSource.this.manifestFatalError;
            }
        }
    }
}
