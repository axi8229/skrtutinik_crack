package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public class DefaultDrmSessionManager implements DrmSessionManager {
    private final MediaDrmCallback callback;
    private ExoMediaDrm exoMediaDrm;
    private final ExoMediaDrm.Provider exoMediaDrmProvider;
    private final HashMap<String, String> keyRequestParameters;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    volatile MediaDrmHandler mediaDrmHandler;
    private int mode;
    private final boolean multiSession;
    private DefaultDrmSession noMultiSessionDrmSession;
    private byte[] offlineLicenseKeySetId;
    private DefaultDrmSession placeholderDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private Looper playbackLooper;
    private int prepareCallsCount;
    private final ProvisioningManagerImpl provisioningManagerImpl;
    private final List<DefaultDrmSession> provisioningSessions;
    private final List<DefaultDrmSession> sessions;
    private final int[] useDrmSessionsForClearContentTrackTypes;
    private final UUID uuid;

    public static final class Builder {
        private boolean multiSession;
        private boolean playClearSamplesWithoutKeys;
        private final HashMap<String, String> keyRequestParameters = new HashMap<>();
        private UUID uuid = C.WIDEVINE_UUID;
        private ExoMediaDrm.Provider exoMediaDrmProvider = FrameworkMediaDrm.DEFAULT_PROVIDER;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        private int[] useDrmSessionsForClearContentTrackTypes = new int[0];

        public Builder setUuidAndExoMediaDrmProvider(UUID uuid, ExoMediaDrm.Provider exoMediaDrmProvider) {
            this.uuid = (UUID) Assertions.checkNotNull(uuid);
            this.exoMediaDrmProvider = (ExoMediaDrm.Provider) Assertions.checkNotNull(exoMediaDrmProvider);
            return this;
        }

        public Builder setMultiSession(boolean multiSession) {
            this.multiSession = multiSession;
            return this;
        }

        public Builder setUseDrmSessionsForClearContent(int... useDrmSessionsForClearContentTrackTypes) {
            for (int i : useDrmSessionsForClearContentTrackTypes) {
                boolean z = true;
                if (i != 2 && i != 1) {
                    z = false;
                }
                Assertions.checkArgument(z);
            }
            this.useDrmSessionsForClearContentTrackTypes = (int[]) useDrmSessionsForClearContentTrackTypes.clone();
            return this;
        }

        public Builder setPlayClearSamplesWithoutKeys(boolean playClearSamplesWithoutKeys) {
            this.playClearSamplesWithoutKeys = playClearSamplesWithoutKeys;
            return this;
        }

        public DefaultDrmSessionManager build(MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.uuid, this.exoMediaDrmProvider, mediaDrmCallback, this.keyRequestParameters, this.multiSession, this.useDrmSessionsForClearContentTrackTypes, this.playClearSamplesWithoutKeys, this.loadErrorHandlingPolicy);
        }
    }

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    private DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.Provider exoMediaDrmProvider, MediaDrmCallback callback, HashMap<String, String> keyRequestParameters, boolean multiSession, int[] useDrmSessionsForClearContentTrackTypes, boolean playClearSamplesWithoutKeys, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        Assertions.checkNotNull(uuid);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.uuid = uuid;
        this.exoMediaDrmProvider = exoMediaDrmProvider;
        this.callback = callback;
        this.keyRequestParameters = keyRequestParameters;
        this.multiSession = multiSession;
        this.useDrmSessionsForClearContentTrackTypes = useDrmSessionsForClearContentTrackTypes;
        this.playClearSamplesWithoutKeys = playClearSamplesWithoutKeys;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.provisioningManagerImpl = new ProvisioningManagerImpl();
        this.mode = 0;
        this.sessions = new ArrayList();
        this.provisioningSessions = new ArrayList();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void prepare() {
        int i = this.prepareCallsCount;
        this.prepareCallsCount = i + 1;
        if (i == 0) {
            Assertions.checkState(this.exoMediaDrm == null);
            ExoMediaDrm exoMediaDrmAcquireExoMediaDrm = this.exoMediaDrmProvider.acquireExoMediaDrm(this.uuid);
            this.exoMediaDrm = exoMediaDrmAcquireExoMediaDrm;
            exoMediaDrmAcquireExoMediaDrm.setOnEventListener(new MediaDrmEventListener());
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void release() {
        int i = this.prepareCallsCount - 1;
        this.prepareCallsCount = i;
        if (i == 0) {
            ((ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm)).release();
            this.exoMediaDrm = null;
        }
    }

    public boolean canAcquireSession(DrmInitData drmInitData) {
        if (this.offlineLicenseKeySetId != null) {
            return true;
        }
        if (getSchemeDatas(drmInitData, this.uuid, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(C.COMMON_PSSH_UUID)) {
                return false;
            }
            Log.w("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.uuid);
        }
        String str = drmInitData.schemeType;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return !("cbc1".equals(str) || "cbcs".equals(str) || "cens".equals(str)) || Util.SDK_INT >= 25;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSession acquirePlaceholderSession(Looper playbackLooper, int trackType) {
        assertExpectedPlaybackLooper(playbackLooper);
        ExoMediaDrm exoMediaDrm = (ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm);
        if ((FrameworkMediaCrypto.class.equals(exoMediaDrm.getExoMediaCryptoType()) && FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) || Util.linearSearch(this.useDrmSessionsForClearContentTrackTypes, trackType) == -1 || exoMediaDrm.getExoMediaCryptoType() == null) {
            return null;
        }
        maybeCreateMediaDrmHandler(playbackLooper);
        if (this.placeholderDrmSession == null) {
            DefaultDrmSession defaultDrmSessionCreateNewDefaultSession = createNewDefaultSession(Collections.emptyList(), true);
            this.sessions.add(defaultDrmSessionCreateNewDefaultSession);
            this.placeholderDrmSession = defaultDrmSessionCreateNewDefaultSession;
        }
        this.placeholderDrmSession.acquire(null);
        return this.placeholderDrmSession;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSession acquireSession(Looper looper, MediaSourceEventDispatcher mediaSourceEventDispatcher, DrmInitData drmInitData) {
        List<DrmInitData.SchemeData> schemeDatas;
        assertExpectedPlaybackLooper(looper);
        maybeCreateMediaDrmHandler(looper);
        DefaultDrmSession defaultDrmSessionCreateNewDefaultSession = null;
        byte b = 0;
        if (this.offlineLicenseKeySetId == null) {
            schemeDatas = getSchemeDatas(drmInitData, this.uuid, false);
            if (schemeDatas.isEmpty()) {
                final MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.uuid);
                if (mediaSourceEventDispatcher != null) {
                    mediaSourceEventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$$ExternalSyntheticLambda1
                        @Override // com.google.android.exoplayer2.util.MediaSourceEventDispatcher.EventWithPeriodId
                        public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                            ((DrmSessionEventListener) obj).onDrmSessionManagerError(missingSchemeDataException);
                        }
                    }, DrmSessionEventListener.class);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
        } else {
            schemeDatas = null;
        }
        if (!this.multiSession) {
            defaultDrmSessionCreateNewDefaultSession = this.noMultiSessionDrmSession;
        } else {
            Iterator<DefaultDrmSession> it = this.sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (Util.areEqual(next.schemeDatas, schemeDatas)) {
                    defaultDrmSessionCreateNewDefaultSession = next;
                    break;
                }
            }
        }
        if (defaultDrmSessionCreateNewDefaultSession == null) {
            defaultDrmSessionCreateNewDefaultSession = createNewDefaultSession(schemeDatas, false);
            if (!this.multiSession) {
                this.noMultiSessionDrmSession = defaultDrmSessionCreateNewDefaultSession;
            }
            this.sessions.add(defaultDrmSessionCreateNewDefaultSession);
        }
        defaultDrmSessionCreateNewDefaultSession.acquire(mediaSourceEventDispatcher);
        return defaultDrmSessionCreateNewDefaultSession;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public Class<? extends ExoMediaCrypto> getExoMediaCryptoType(DrmInitData drmInitData) {
        if (canAcquireSession(drmInitData)) {
            return ((ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm)).getExoMediaCryptoType();
        }
        return null;
    }

    private void assertExpectedPlaybackLooper(Looper playbackLooper) {
        Looper looper = this.playbackLooper;
        Assertions.checkState(looper == null || looper == playbackLooper);
        this.playbackLooper = playbackLooper;
    }

    private void maybeCreateMediaDrmHandler(Looper playbackLooper) {
        if (this.mediaDrmHandler == null) {
            this.mediaDrmHandler = new MediaDrmHandler(playbackLooper);
        }
    }

    private DefaultDrmSession createNewDefaultSession(List<DrmInitData.SchemeData> schemeDatas, boolean isPlaceholderSession) {
        Assertions.checkNotNull(this.exoMediaDrm);
        return new DefaultDrmSession(this.uuid, this.exoMediaDrm, this.provisioningManagerImpl, new DefaultDrmSession.ReleaseCallback() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$$ExternalSyntheticLambda0
            @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ReleaseCallback
            public final void onSessionReleased(DefaultDrmSession defaultDrmSession) {
                this.f$0.onSessionReleased(defaultDrmSession);
            }
        }, schemeDatas, this.mode, this.playClearSamplesWithoutKeys | isPlaceholderSession, isPlaceholderSession, this.offlineLicenseKeySetId, this.keyRequestParameters, this.callback, (Looper) Assertions.checkNotNull(this.playbackLooper), this.loadErrorHandlingPolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSessionReleased(DefaultDrmSession drmSession) {
        this.sessions.remove(drmSession);
        if (this.placeholderDrmSession == drmSession) {
            this.placeholderDrmSession = null;
        }
        if (this.noMultiSessionDrmSession == drmSession) {
            this.noMultiSessionDrmSession = null;
        }
        if (this.provisioningSessions.size() > 1 && this.provisioningSessions.get(0) == drmSession) {
            this.provisioningSessions.get(1).provision();
        }
        this.provisioningSessions.remove(drmSession);
    }

    private static List<DrmInitData.SchemeData> getSchemeDatas(DrmInitData drmInitData, UUID uuid, boolean allowMissingData) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i);
            if ((schemeData.matches(uuid) || (C.CLEARKEY_UUID.equals(uuid) && schemeData.matches(C.COMMON_PSSH_UUID))) && (schemeData.data != null || allowMissingData)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @SuppressLint({"HandlerLeak"})
    private class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            byte[] bArr = (byte[]) msg.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.sessions) {
                if (defaultDrmSession.hasSessionId(bArr)) {
                    defaultDrmSession.onMediaDrmEvent(msg.what);
                    return;
                }
            }
        }
    }

    private class ProvisioningManagerImpl implements DefaultDrmSession.ProvisioningManager {
        private ProvisioningManagerImpl() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void provisionRequired(DefaultDrmSession session) {
            if (DefaultDrmSessionManager.this.provisioningSessions.contains(session)) {
                return;
            }
            DefaultDrmSessionManager.this.provisioningSessions.add(session);
            if (DefaultDrmSessionManager.this.provisioningSessions.size() == 1) {
                session.provision();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void onProvisionCompleted() {
            Iterator it = DefaultDrmSessionManager.this.provisioningSessions.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).onProvisionCompleted();
            }
            DefaultDrmSessionManager.this.provisioningSessions.clear();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void onProvisionError(Exception error) {
            Iterator it = DefaultDrmSessionManager.this.provisioningSessions.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).onProvisionError(error);
            }
            DefaultDrmSessionManager.this.provisioningSessions.clear();
        }
    }

    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener {
        private MediaDrmEventListener() {
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
        public void onEvent(ExoMediaDrm md, byte[] sessionId, int event, int extra, byte[] data) {
            ((MediaDrmHandler) Assertions.checkNotNull(DefaultDrmSessionManager.this.mediaDrmHandler)).obtainMessage(event, sessionId).sendToTarget();
        }
    }
}
