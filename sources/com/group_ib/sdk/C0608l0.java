package com.group_ib.sdk;

import android.util.Base64;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.l0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0608l0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public HashSet f = null;

    public C0608l0(C0608l0 c0608l0) {
        this.a = c0608l0.a;
        this.b = c0608l0.b;
        this.c = c0608l0.c;
        this.d = c0608l0.d;
        this.e = c0608l0.e;
    }

    public static String a(byte[] bArr) {
        char[] cArr = AbstractC0604j0.a;
        return Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(bArr), 2);
    }

    public C0608l0(byte[] bArr, String str) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
        this.d = str == null ? a(bArr) : str;
        X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
        this.a = x509Certificate.getIssuerDN().getName();
        String name = x509Certificate.getSubjectDN().getName();
        this.b = name;
        this.c = x509Certificate.getSerialNumber().toString();
        this.e = name.toLowerCase().contains("debug");
    }

    public final void a(C0602i0 c0602i0) {
        if (this.f == null) {
            this.f = new HashSet();
        }
        this.f.add(c0602i0.a);
    }

    public final JSONObject a() {
        String str = this.b;
        return new JSONObject().put("sn", this.c).put("subject", (str == null || !str.equals(this.a)) ? this.b : "").put("issuer", this.a).put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, this.d);
    }
}
