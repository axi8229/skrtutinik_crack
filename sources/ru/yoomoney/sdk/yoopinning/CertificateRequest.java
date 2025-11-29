package ru.yoomoney.sdk.yoopinning;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
import ru.yoomoney.sdk.yoopinning.PinningException;

/* compiled from: CertificateRequest.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/yoopinning/CertificateRequest;", "", "eTagRepository", "Lru/yoomoney/sdk/yoopinning/ETagRepository;", "(Lru/yoomoney/sdk/yoopinning/ETagRepository;)V", "connect", "Ljava/net/HttpURLConnection;", "context", "Landroid/content/Context;", "lastEtag", "", "host", "getCertificates", "getUrl", "Ljava/net/URL;", "isTablet", "", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CertificateRequest {
    private final ETagRepository eTagRepository;

    public CertificateRequest(ETagRepository eTagRepository) {
        Intrinsics.checkNotNullParameter(eTagRepository, "eTagRepository");
        this.eTagRepository = eTagRepository;
    }

    public final String getCertificates(Context context, String host) throws PinningException.CertificateNotModified, IOException {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(host, "host");
        HttpURLConnection httpURLConnectionConnect = connect(context, this.eTagRepository.getLastETag(), host);
        int responseCode = httpURLConnectionConnect.getResponseCode();
        if (responseCode == 200) {
            ETagRepository eTagRepository = this.eTagRepository;
            String headerField = httpURLConnectionConnect.getHeaderField("ETag");
            Intrinsics.checkNotNullExpressionValue(headerField, "getHeaderField(...)");
            eTagRepository.saveETag(headerField);
            InputStream inputStream = httpURLConnectionConnect.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), 8192);
            try {
                String string = new JSONObject(TextStreamsKt.readText(bufferedReader2)).getString("token");
                CloseableKt.closeFinally(bufferedReader2, null);
                Intrinsics.checkNotNullExpressionValue(string, "with(...)");
                return string;
            } finally {
            }
        } else {
            if (responseCode == 304) {
                throw PinningException.CertificateNotModified.INSTANCE;
            }
            InputStream errorStream = httpURLConnectionConnect.getErrorStream();
            if (errorStream != null) {
                Intrinsics.checkNotNull(errorStream);
                bufferedReader = new BufferedReader(new InputStreamReader(errorStream, Charsets.UTF_8), 8192);
            } else {
                bufferedReader = null;
            }
            try {
                throw new PinningException.GetCertificateRequestError(bufferedReader != null ? TextStreamsKt.readText(bufferedReader) : null);
            } finally {
            }
        }
    }

    private final HttpURLConnection connect(Context context, String lastEtag, String host) throws IOException {
        URLConnection uRLConnectionOpenConnection = getUrl(host).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("If-None-Match", lastEtag);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        httpURLConnection.setRequestProperty("User-Agent", new UserAgent(isTablet(applicationContext), null, null, 6, null).getName());
        httpURLConnection.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(30L));
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private final URL getUrl(String host) {
        return new URL("http://certs." + host + "/api/fingerprint-config/v1/fingerprints");
    }

    private final boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.pinning_is_tablet);
    }
}
