package com.google.android.exoplayer2.drm;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {
    private final HttpDataSource.Factory dataSourceFactory;
    private final String defaultLicenseUrl;
    private final boolean forceDefaultLicenseUrl;
    private final Map<String, String> keyRequestProperties;

    public HttpMediaDrmCallback(String defaultLicenseUrl, HttpDataSource.Factory dataSourceFactory) {
        this(defaultLicenseUrl, false, dataSourceFactory);
    }

    public HttpMediaDrmCallback(String defaultLicenseUrl, boolean forceDefaultLicenseUrl, HttpDataSource.Factory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
        this.defaultLicenseUrl = defaultLicenseUrl;
        this.forceDefaultLicenseUrl = forceDefaultLicenseUrl;
        this.keyRequestProperties = new HashMap();
    }

    public void setKeyRequestProperty(String name, String value) {
        Assertions.checkNotNull(name);
        Assertions.checkNotNull(value);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.put(name, value);
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest request) throws IOException {
        return executePost(this.dataSourceFactory, request.getDefaultUrl() + "&signedRequest=" + Util.fromUtf8Bytes(request.getData()), null, null);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest request) throws Exception {
        String str;
        String licenseServerUrl = request.getLicenseServerUrl();
        if (this.forceDefaultLicenseUrl || TextUtils.isEmpty(licenseServerUrl)) {
            licenseServerUrl = this.defaultLicenseUrl;
        }
        HashMap map = new HashMap();
        UUID uuid2 = C.PLAYREADY_UUID;
        if (uuid2.equals(uuid)) {
            str = "text/xml";
        } else {
            str = C.CLEARKEY_UUID.equals(uuid) ? "application/json" : "application/octet-stream";
        }
        map.put("Content-Type", str);
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.keyRequestProperties) {
            map.putAll(this.keyRequestProperties);
        }
        return executePost(this.dataSourceFactory, licenseServerUrl, request.getData(), map);
    }

    private static byte[] executePost(HttpDataSource.Factory dataSourceFactory, String url, byte[] httpBody, Map<String, String> requestProperties) throws IOException {
        HttpDataSource httpDataSourceCreateDataSource = dataSourceFactory.createDataSource();
        if (requestProperties != null) {
            for (Map.Entry<String, String> entry : requestProperties.entrySet()) {
                httpDataSourceCreateDataSource.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        int i = 0;
        while (true) {
            boolean z = true;
            DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(httpDataSourceCreateDataSource, new DataSpec.Builder().setUri(url).setHttpMethod(2).setHttpBody(httpBody).setFlags(1).build());
            try {
                return Util.toByteArray(dataSourceInputStream);
            } catch (HttpDataSource.InvalidResponseCodeException e) {
                try {
                    if (e.responseCode == 307 || e.responseCode == 308) {
                        int i2 = i + 1;
                        if (i < 5) {
                            i = i2;
                        } else {
                            i = i2;
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    String redirectUrl = z ? getRedirectUrl(e) : null;
                    if (redirectUrl == null) {
                        throw e;
                    }
                    Util.closeQuietly(dataSourceInputStream);
                    url = redirectUrl;
                } finally {
                    Util.closeQuietly(dataSourceInputStream);
                }
            }
        }
    }

    private static String getRedirectUrl(HttpDataSource.InvalidResponseCodeException exception) {
        List<String> list;
        Map<String, List<String>> map = exception.headerFields;
        if (map == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
