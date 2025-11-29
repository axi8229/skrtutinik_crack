package com.huawei.location.crowdsourcing.upload.http;

import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import com.huawei.location.lite.common.log.LogLocation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes3.dex */
public abstract class Vw {
    private final SortedMap<String, String> FB = new TreeMap();
    private final SortedMap<String, String> LW = new TreeMap();
    private final String Vw;
    private final yn dC;
    private final String yn;

    public enum yn {
        POST("POST"),
        PUT("PUT");

        private final String LW;

        yn(String str) {
            this.LW = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Method{value='" + this.LW + "'}";
        }

        String yn() {
            return this.LW;
        }
    }

    public Vw(yn ynVar, String str) {
        this.dC = ynVar;
        if (str.contains("@") || str.contains("\\.") || str.contains("\\\\.") || str.contains("\\")) {
            this.yn = "";
            this.Vw = "";
            LogLocation.e("HttpsRequest", "url is not correct");
            return;
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.toLowerCase(Locale.ENGLISH).equals("https")) {
            this.yn = "";
            this.Vw = "";
            LogLocation.e("HttpsRequest", "not https");
            return;
        }
        String authority = uri.getAuthority();
        String host = uri.getHost();
        String path = uri.getPath();
        if (host == null) {
            LogLocation.e("HttpsRequest", "uri host is undefined");
        }
        authority = authority == null ? "" : authority;
        String str2 = path != null ? path : "";
        this.yn = authority;
        this.Vw = str2;
        yn(uri);
    }

    public Vw(yn ynVar, String str, String str2) {
        this.dC = ynVar;
        this.yn = str;
        this.Vw = str2;
    }

    private boolean Vw(HttpsURLConnection httpsURLConnection) throws IOException {
        String str;
        boolean z;
        InputStream inputStreamLW = LW();
        try {
        } catch (ProtocolException unused) {
            str = "protocol error, method:" + httpsURLConnection.getRequestMethod();
        } catch (IOException unused2) {
            LogLocation.e("HttpsRequest", "IO or close failed");
        }
        if (inputStreamLW == null) {
            str = "get body error";
            LogLocation.e("HttpsRequest", str);
            return false;
        }
        try {
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            try {
                byte[] bArr = new byte[1024];
                int i = 0;
                while (true) {
                    int i2 = inputStreamLW.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, i2);
                    i += i2;
                }
                LogLocation.d("HttpsRequest", "request body length:" + i);
                z = true;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                inputStreamLW.close();
                return z;
            } finally {
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    static String yn(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            LogLocation.e("HttpsRequest", "not support UTF-8");
            return "";
        }
    }

    protected static String yn(SortedMap<String, String> sortedMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(entry.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private String yn(HttpsURLConnection httpsURLConnection) throws IOException {
        String str;
        InputStream inputStream;
        String string = null;
        try {
            httpsURLConnection.setRequestMethod(this.dC.yn());
            for (Map.Entry<String, String> entry : this.FB.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setReadTimeout(ActivityRecognitionConstants.DEFAULT_DETECTION_INTERVAL_MILLIS);
            httpsURLConnection.setConnectTimeout(ActivityRecognitionConstants.DEFAULT_DETECTION_INTERVAL_MILLIS);
            if (!Vw(httpsURLConnection)) {
                LogLocation.e("HttpsRequest", "write all failed");
                return null;
            }
            try {
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    LogLocation.e("HttpsRequest", "http code error" + responseCode);
                    return null;
                }
                LogLocation.d("HttpsRequest", "http code:" + responseCode);
                try {
                    inputStream = httpsURLConnection.getInputStream();
                } catch (FileNotFoundException unused) {
                    str = "path not exist. url:" + httpsURLConnection.getURL();
                    LogLocation.e("HttpsRequest", str);
                    return string;
                } catch (IOException unused2) {
                    str = "read all error";
                    LogLocation.e("HttpsRequest", str);
                    return string;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, i, StandardCharsets.UTF_8));
                    }
                    string = sb.toString();
                    inputStream.close();
                    return string;
                } finally {
                }
            } catch (IOException unused3) {
                LogLocation.e("HttpsRequest", "get response code error, io exception.");
                return null;
            }
        } catch (ProtocolException unused4) {
            LogLocation.e("HttpsRequest", "protocol not support." + this.dC);
            LogLocation.e("HttpsRequest", "fill connection failed");
            return null;
        }
    }

    private void yn(Uri uri) {
        try {
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str);
                if (queryParameter == null) {
                    LogLocation.e("HttpsRequest", "arg value null.");
                    LogLocation.d("HttpsRequest", "arg value null. arg name:" + str);
                } else {
                    Vw(str, queryParameter);
                }
            }
        } catch (UnsupportedOperationException unused) {
            LogLocation.e("HttpsRequest", "url not support");
        }
    }

    protected String FB() {
        return this.Vw;
    }

    protected abstract InputStream LW();

    public Vw Vw(String str, String str2) {
        String strYn = yn(str);
        String strYn2 = yn(str2);
        if (!strYn.isEmpty() && !strYn2.isEmpty()) {
            this.LW.put(strYn, strYn2);
        }
        return this;
    }

    protected String Vw() {
        return this.dC.yn();
    }

    protected boolean dC() {
        String str;
        if (this.yn.isEmpty()) {
            str = "domain empty";
        } else {
            if (!this.Vw.isEmpty()) {
                return true;
            }
            str = "path empty";
        }
        LogLocation.e("HttpsRequest", str);
        LogLocation.e("HttpsRequest", "valid failed");
        return false;
    }

    public Vw yn(String str, String str2) {
        if (str.isEmpty()) {
            return this;
        }
        this.FB.put(str, str2);
        return this;
    }

    protected String yn() {
        return yn(this.LW);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
    
        if (r3 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009d, code lost:
    
        if (r3 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a4, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011e  */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <R extends com.huawei.location.crowdsourcing.upload.http.yn> R yn(java.lang.Class<? extends R> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.http.Vw.yn(java.lang.Class):com.huawei.location.crowdsourcing.upload.http.yn");
    }
}
