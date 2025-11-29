package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public interface ExoMediaDrm {

    public interface OnEventListener {
        void onEvent(ExoMediaDrm mediaDrm, byte[] sessionId, int event, int extra, byte[] data);
    }

    public interface Provider {
        ExoMediaDrm acquireExoMediaDrm(UUID uuid);
    }

    void closeSession(byte[] sessionId);

    ExoMediaCrypto createMediaCrypto(byte[] sessionId) throws MediaCryptoException;

    Class<? extends ExoMediaCrypto> getExoMediaCryptoType();

    KeyRequest getKeyRequest(byte[] scope, List<DrmInitData.SchemeData> schemeDatas, int keyType, HashMap<String, String> optionalParameters) throws NotProvisionedException;

    ProvisionRequest getProvisionRequest();

    byte[] openSession() throws MediaDrmException;

    byte[] provideKeyResponse(byte[] scope, byte[] response) throws DeniedByServerException, NotProvisionedException;

    void provideProvisionResponse(byte[] response) throws DeniedByServerException;

    Map<String, String> queryKeyStatus(byte[] sessionId);

    void release();

    void restoreKeys(byte[] sessionId, byte[] keySetId);

    void setOnEventListener(OnEventListener listener);

    public static final class KeyRequest {
        private final byte[] data;
        private final String licenseServerUrl;

        public KeyRequest(byte[] data, String licenseServerUrl) {
            this.data = data;
            this.licenseServerUrl = licenseServerUrl;
        }

        public byte[] getData() {
            return this.data;
        }

        public String getLicenseServerUrl() {
            return this.licenseServerUrl;
        }
    }

    public static final class ProvisionRequest {
        private final byte[] data;
        private final String defaultUrl;

        public ProvisionRequest(byte[] data, String defaultUrl) {
            this.data = data;
            this.defaultUrl = defaultUrl;
        }

        public byte[] getData() {
            return this.data;
        }

        public String getDefaultUrl() {
            return this.defaultUrl;
        }
    }
}
