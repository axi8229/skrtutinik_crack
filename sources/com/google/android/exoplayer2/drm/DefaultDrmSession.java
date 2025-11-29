package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
class DefaultDrmSession implements DrmSession {
    final MediaDrmCallback callback;
    private ExoMediaDrm.KeyRequest currentKeyRequest;
    private ExoMediaDrm.ProvisionRequest currentProvisionRequest;
    private final CopyOnWriteMultiset<MediaSourceEventDispatcher> eventDispatchers;
    private final boolean isPlaceholderSession;
    private final HashMap<String, String> keyRequestParameters;
    private DrmSession.DrmSessionException lastException;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private ExoMediaCrypto mediaCrypto;
    private final ExoMediaDrm mediaDrm;
    private final int mode;
    private byte[] offlineLicenseKeySetId;
    private final boolean playClearSamplesWithoutKeys;
    private final ProvisioningManager provisioningManager;
    private int referenceCount;
    private final ReleaseCallback releaseCallback;
    private RequestHandler requestHandler;
    private HandlerThread requestHandlerThread;
    final ResponseHandler responseHandler;
    public final List<DrmInitData.SchemeData> schemeDatas;
    private byte[] sessionId;
    private int state;
    final UUID uuid;

    public interface ProvisioningManager {
        void onProvisionCompleted();

        void onProvisionError(Exception error);

        void provisionRequired(DefaultDrmSession session);
    }

    public interface ReleaseCallback {
        void onSessionReleased(DefaultDrmSession session);
    }

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(Throwable cause) {
            super("Unexpected " + cause.getClass().getSimpleName() + ": " + cause.getMessage(), cause);
        }
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm mediaDrm, ProvisioningManager provisioningManager, ReleaseCallback releaseCallback, List<DrmInitData.SchemeData> schemeDatas, int mode, boolean playClearSamplesWithoutKeys, boolean isPlaceholderSession, byte[] offlineLicenseKeySetId, HashMap<String, String> keyRequestParameters, MediaDrmCallback callback, Looper playbackLooper, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (mode == 1 || mode == 3) {
            Assertions.checkNotNull(offlineLicenseKeySetId);
        }
        this.uuid = uuid;
        this.provisioningManager = provisioningManager;
        this.releaseCallback = releaseCallback;
        this.mediaDrm = mediaDrm;
        this.mode = mode;
        this.playClearSamplesWithoutKeys = playClearSamplesWithoutKeys;
        this.isPlaceholderSession = isPlaceholderSession;
        if (offlineLicenseKeySetId != null) {
            this.offlineLicenseKeySetId = offlineLicenseKeySetId;
            this.schemeDatas = null;
        } else {
            this.schemeDatas = Collections.unmodifiableList((List) Assertions.checkNotNull(schemeDatas));
        }
        this.keyRequestParameters = keyRequestParameters;
        this.callback = callback;
        this.eventDispatchers = new CopyOnWriteMultiset<>();
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.state = 2;
        this.responseHandler = new ResponseHandler(playbackLooper);
    }

    public boolean hasSessionId(byte[] sessionId) {
        return Arrays.equals(this.sessionId, sessionId);
    }

    public void onMediaDrmEvent(int what) {
        if (what != 2) {
            return;
        }
        onKeysRequired();
    }

    public void provision() {
        this.currentProvisionRequest = this.mediaDrm.getProvisionRequest();
        ((RequestHandler) Util.castNonNull(this.requestHandler)).post(0, Assertions.checkNotNull(this.currentProvisionRequest), true);
    }

    public void onProvisionCompleted() {
        if (openInternal(false)) {
            doLicense(true);
        }
    }

    public void onProvisionError(Exception error) {
        onError(error);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return this.playClearSamplesWithoutKeys;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        if (this.state == 1) {
            return this.lastException;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final ExoMediaCrypto getMediaCrypto() {
        return this.mediaCrypto;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.sessionId;
        if (bArr == null) {
            return null;
        }
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void acquire(MediaSourceEventDispatcher eventDispatcher) {
        Assertions.checkState(this.referenceCount >= 0);
        if (eventDispatcher != null) {
            this.eventDispatchers.add(eventDispatcher);
        }
        int i = this.referenceCount + 1;
        this.referenceCount = i;
        if (i != 1) {
            if (eventDispatcher != null) {
                eventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession$$ExternalSyntheticLambda0
                    @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                    public final void sendTo(Object obj, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
                        ((DrmSessionEventListener) obj).onDrmSessionAcquired();
                    }
                }, DrmSessionEventListener.class);
                return;
            }
            return;
        }
        Assertions.checkState(this.state == 2);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
        this.requestHandlerThread = handlerThread;
        handlerThread.start();
        this.requestHandler = new RequestHandler(this.requestHandlerThread.getLooper());
        if (openInternal(true)) {
            doLicense(true);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void release(MediaSourceEventDispatcher eventDispatcher) {
        int i = this.referenceCount - 1;
        this.referenceCount = i;
        if (i == 0) {
            this.state = 0;
            ((ResponseHandler) Util.castNonNull(this.responseHandler)).removeCallbacksAndMessages(null);
            ((RequestHandler) Util.castNonNull(this.requestHandler)).removeCallbacksAndMessages(null);
            this.requestHandler = null;
            ((HandlerThread) Util.castNonNull(this.requestHandlerThread)).quit();
            this.requestHandlerThread = null;
            this.mediaCrypto = null;
            this.lastException = null;
            this.currentKeyRequest = null;
            this.currentProvisionRequest = null;
            byte[] bArr = this.sessionId;
            if (bArr != null) {
                this.mediaDrm.closeSession(bArr);
                this.sessionId = null;
            }
            this.releaseCallback.onSessionReleased(this);
        }
        dispatchEvent(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession$$ExternalSyntheticLambda1
            @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
            public final void sendTo(Object obj, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
                ((DrmSessionEventListener) obj).onDrmSessionReleased();
            }
        });
        if (eventDispatcher != null) {
            this.eventDispatchers.remove(eventDispatcher);
        }
    }

    private boolean openInternal(boolean allowProvisioning) {
        if (isOpen()) {
            return true;
        }
        try {
            byte[] bArrOpenSession = this.mediaDrm.openSession();
            this.sessionId = bArrOpenSession;
            this.mediaCrypto = this.mediaDrm.createMediaCrypto(bArrOpenSession);
            dispatchEvent(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession$$ExternalSyntheticLambda3
                @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                    ((DrmSessionEventListener) obj).onDrmSessionAcquired();
                }
            });
            this.state = 3;
            Assertions.checkNotNull(this.sessionId);
            return true;
        } catch (NotProvisionedException e) {
            if (allowProvisioning) {
                this.provisioningManager.provisionRequired(this);
                return false;
            }
            onError(e);
            return false;
        } catch (Exception e2) {
            onError(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProvisionResponse(Object request, Object response) {
        if (request == this.currentProvisionRequest) {
            if (this.state == 2 || isOpen()) {
                this.currentProvisionRequest = null;
                if (response instanceof Exception) {
                    this.provisioningManager.onProvisionError((Exception) response);
                    return;
                }
                try {
                    this.mediaDrm.provideProvisionResponse((byte[]) response);
                    this.provisioningManager.onProvisionCompleted();
                } catch (Exception e) {
                    this.provisioningManager.onProvisionError(e);
                }
            }
        }
    }

    private void doLicense(boolean allowRetry) {
        if (this.isPlaceholderSession) {
            return;
        }
        byte[] bArr = (byte[]) Util.castNonNull(this.sessionId);
        int i = this.mode;
        if (i != 0 && i != 1) {
            if (i == 2) {
                if (this.offlineLicenseKeySetId == null || restoreKeys()) {
                    postKeyRequest(bArr, 2, allowRetry);
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
            Assertions.checkNotNull(this.offlineLicenseKeySetId);
            Assertions.checkNotNull(this.sessionId);
            if (restoreKeys()) {
                postKeyRequest(this.offlineLicenseKeySetId, 3, allowRetry);
                return;
            }
            return;
        }
        if (this.offlineLicenseKeySetId == null) {
            postKeyRequest(bArr, 1, allowRetry);
            return;
        }
        if (this.state == 4 || restoreKeys()) {
            long licenseDurationRemainingSec = getLicenseDurationRemainingSec();
            if (this.mode != 0 || licenseDurationRemainingSec > 60) {
                if (licenseDurationRemainingSec <= 0) {
                    onError(new KeysExpiredException());
                    return;
                } else {
                    this.state = 4;
                    dispatchEvent(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession$$ExternalSyntheticLambda2
                        @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                        public final void sendTo(Object obj, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
                            ((DrmSessionEventListener) obj).onDrmKeysRestored();
                        }
                    });
                    return;
                }
            }
            Log.d("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + licenseDurationRemainingSec);
            postKeyRequest(bArr, 2, allowRetry);
        }
    }

    private boolean restoreKeys() {
        try {
            this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
            return true;
        } catch (Exception e) {
            Log.e("DefaultDrmSession", "Error trying to restore keys.", e);
            onError(e);
            return false;
        }
    }

    private long getLicenseDurationRemainingSec() {
        if (!C.WIDEVINE_UUID.equals(this.uuid)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private void postKeyRequest(byte[] scope, int type, boolean allowRetry) {
        try {
            this.currentKeyRequest = this.mediaDrm.getKeyRequest(scope, this.schemeDatas, type, this.keyRequestParameters);
            ((RequestHandler) Util.castNonNull(this.requestHandler)).post(1, Assertions.checkNotNull(this.currentKeyRequest), allowRetry);
        } catch (Exception e) {
            onKeysError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyResponse(Object request, Object response) {
        if (request == this.currentKeyRequest && isOpen()) {
            this.currentKeyRequest = null;
            if (response instanceof Exception) {
                onKeysError((Exception) response);
                return;
            }
            try {
                byte[] bArr = (byte[]) response;
                if (this.mode == 3) {
                    this.mediaDrm.provideKeyResponse((byte[]) Util.castNonNull(this.offlineLicenseKeySetId), bArr);
                    dispatchEvent(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession$$ExternalSyntheticLambda5
                        @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                        public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                            ((DrmSessionEventListener) obj).onDrmKeysRestored();
                        }
                    });
                    return;
                }
                byte[] bArrProvideKeyResponse = this.mediaDrm.provideKeyResponse(this.sessionId, bArr);
                int i = this.mode;
                if ((i == 2 || (i == 0 && this.offlineLicenseKeySetId != null)) && bArrProvideKeyResponse != null && bArrProvideKeyResponse.length != 0) {
                    this.offlineLicenseKeySetId = bArrProvideKeyResponse;
                }
                this.state = 4;
                dispatchEvent(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession$$ExternalSyntheticLambda6
                    @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                    public final void sendTo(Object obj, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
                        ((DrmSessionEventListener) obj).onDrmKeysLoaded();
                    }
                });
            } catch (Exception e) {
                onKeysError(e);
            }
        }
    }

    private void onKeysRequired() {
        if (this.mode == 0 && this.state == 4) {
            Util.castNonNull(this.sessionId);
            doLicense(false);
        }
    }

    private void onKeysError(Exception e) {
        if (e instanceof NotProvisionedException) {
            this.provisioningManager.provisionRequired(this);
        } else {
            onError(e);
        }
    }

    private void onError(final Exception e) {
        this.lastException = new DrmSession.DrmSessionException(e);
        dispatchEvent(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession$$ExternalSyntheticLambda4
            @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
            public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                ((DrmSessionEventListener) obj).onDrmSessionManagerError(e);
            }
        });
        if (this.state != 4) {
            this.state = 1;
        }
    }

    private boolean isOpen() {
        int i = this.state;
        return i == 3 || i == 4;
    }

    private void dispatchEvent(MediaSourceEventDispatcher.EventWithPeriodId<DrmSessionEventListener> event) {
        Iterator<MediaSourceEventDispatcher> it = this.eventDispatchers.elementSet().iterator();
        while (it.hasNext()) {
            it.next().dispatch(event, DrmSessionEventListener.class);
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class ResponseHandler extends Handler {
        public ResponseHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Pair pair = (Pair) msg.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = msg.what;
            if (i == 0) {
                DefaultDrmSession.this.onProvisionResponse(obj, obj2);
            } else {
                if (i != 1) {
                    return;
                }
                DefaultDrmSession.this.onKeyResponse(obj, obj2);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class RequestHandler extends Handler {
        public RequestHandler(Looper backgroundLooper) {
            super(backgroundLooper);
        }

        void post(int what, Object request, boolean allowRetry) {
            obtainMessage(what, new RequestTask(allowRetry, SystemClock.elapsedRealtime(), request)).sendToTarget();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Exception excExecuteProvisionRequest;
            RequestTask requestTask = (RequestTask) message.obj;
            try {
                int i = message.what;
                if (i == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    excExecuteProvisionRequest = defaultDrmSession.callback.executeProvisionRequest(defaultDrmSession.uuid, (ExoMediaDrm.ProvisionRequest) requestTask.request);
                } else if (i == 1) {
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    excExecuteProvisionRequest = defaultDrmSession2.callback.executeKeyRequest(defaultDrmSession2.uuid, (ExoMediaDrm.KeyRequest) requestTask.request);
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                boolean zMaybeRetryRequest = maybeRetryRequest(message, e);
                excExecuteProvisionRequest = e;
                if (zMaybeRetryRequest) {
                    return;
                }
            }
            DefaultDrmSession.this.responseHandler.obtainMessage(message.what, Pair.create(requestTask.request, excExecuteProvisionRequest)).sendToTarget();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v3, types: [java.io.IOException] */
        private boolean maybeRetryRequest(Message originalMsg, Exception e) {
            RequestTask requestTask = (RequestTask) originalMsg.obj;
            if (!requestTask.allowRetry) {
                return false;
            }
            int i = requestTask.errorCount + 1;
            requestTask.errorCount = i;
            if (i > DefaultDrmSession.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(3)) {
                return false;
            }
            long retryDelayMsFor = DefaultDrmSession.this.loadErrorHandlingPolicy.getRetryDelayMsFor(3, SystemClock.elapsedRealtime() - requestTask.startTimeMs, e instanceof IOException ? (IOException) e : new UnexpectedDrmSessionException(e), requestTask.errorCount);
            if (retryDelayMsFor == -9223372036854775807L) {
                return false;
            }
            sendMessageDelayed(Message.obtain(originalMsg), retryDelayMsFor);
            return true;
        }
    }

    private static final class RequestTask {
        public final boolean allowRetry;
        public int errorCount;
        public final Object request;
        public final long startTimeMs;

        public RequestTask(boolean allowRetry, long startTimeMs, Object request) {
            this.allowRetry = allowRetry;
            this.startTimeMs = startTimeMs;
            this.request = request;
        }
    }
}
