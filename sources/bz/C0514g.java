package bz;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.Serializable;

/* renamed from: bz.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0514g extends AbstractC0538n1 {
    public static final String h = AbstractC0569y0.a(new byte[]{-7, 98, -91, -56, -108, 40, 34, -51, -24, -105, 40, 19, 119, -33, 19, 107, 14, 49, 49, -24, -100, 22, 70, 7, 81, -13, -47, 13, -111, -104, -24, -18});
    public static final String i = AbstractC0569y0.a(new byte[]{113, 86, 78, -84, 76, 122, 97, -90, 24, 92, -77, 54, 123, -80, 44, 118, -114, -18, -55, -50, 57, 99, -4, 120, 21, -57, 97, 75, 49, -49, -78, ByteSourceJsonBootstrapper.UTF8_BOM_2});
    public static final String j = AbstractC0569y0.a(new byte[]{-112, -126, -34, 42, -92, -10, -60, 54, -18, 19, 107, -73, -14, 30, 112, -98});
    public final Context c;
    public final FingerprintManager d;
    public final BiometricManager e;
    public final KeyguardManager f;
    public int g;

    public C0514g(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.AuthenticationInfo);
        this.c = context;
        int i2 = Build.VERSION.SDK_INT;
        this.f = (KeyguardManager) context.getSystemService("keyguard");
        this.d = (FingerprintManager) context.getSystemService(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT);
        if (i2 >= 29) {
            this.e = g$$ExternalSyntheticApiModelOutline1.m(context.getSystemService("biometric"));
        }
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return new zone.bi.mobile.fingerprint.api.serialize.model.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // bz.AbstractC0538n1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable i() throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.KeyStoreException, java.security.cert.CertificateException, java.security.NoSuchProviderException, java.security.InvalidAlgorithmParameterException {
        /*
            r10 = this;
            r0 = 16
            r1 = 28
            int r2 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = "android.permission.USE_BIOMETRIC"
            r4 = 29
            if (r2 < r4) goto L20
            android.hardware.biometrics.BiometricManager r5 = r10.e
            if (r5 == 0) goto L20
            android.content.Context r5 = r10.c
            boolean r5 = bz.K0.a(r5, r3)
            if (r5 == 0) goto L20
            android.hardware.biometrics.BiometricManager r5 = r10.e
            int r5 = bz.g$$ExternalSyntheticApiModelOutline0.m(r5)
            r10.g = r5
        L20:
            java.io.Serializable r5 = super.i()
            zone.bi.mobile.fingerprint.api.serialize.model.a r5 = (zone.bi.mobile.fingerprint.api.serialize.model.a) r5
            if (r5 == 0) goto Le5
            android.app.KeyguardManager r6 = r10.f
            r7 = 0
            r8 = 1
            if (r6 == 0) goto L34
            boolean r6 = r6.isDeviceLocked()
            r6 = r6 ^ r8
            goto L35
        L34:
            r6 = r7
        L35:
            java.lang.String r9 = bz.C0514g.h
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r5.put(r9, r6)
            if (r2 > r1) goto L55
            android.hardware.fingerprint.FingerprintManager r6 = r10.d
            if (r6 == 0) goto L6d
            android.content.Context r6 = r10.c
            java.lang.String r9 = "android.permission.USE_FINGERPRINT"
            boolean r6 = bz.K0.a(r6, r9)
            if (r6 == 0) goto L6d
            android.hardware.fingerprint.FingerprintManager r6 = r10.d
            boolean r6 = r6.isHardwareDetected()
            goto L6e
        L55:
            if (r2 < r4) goto L6d
            android.hardware.biometrics.BiometricManager r6 = r10.e
            if (r6 == 0) goto L6d
            android.content.Context r6 = r10.c
            boolean r6 = bz.K0.a(r6, r3)
            if (r6 == 0) goto L6d
            int r6 = r10.g
            r9 = 12
            if (r6 == r9) goto L6d
            if (r6 == r8) goto L6d
            r6 = r8
            goto L6e
        L6d:
            r6 = r7
        L6e:
            java.lang.String r9 = bz.C0514g.i
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r5.put(r9, r6)
            if (r2 > r1) goto Lcd
            byte[] r1 = new byte[r0]     // Catch: java.lang.Exception -> Ldc
            r1 = {x00e6: FILL_ARRAY_DATA , data: [34, -28, -26, 28, 117, 114, -104, -99, 122, 6, 103, 18, -52, -123, 30, -19} // fill-array     // Catch: java.lang.Exception -> Ldc
            java.lang.String r1 = bz.AbstractC0569y0.a(r1)     // Catch: java.lang.Exception -> Ldc
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch: java.lang.Exception -> Ldc
            java.lang.String r2 = "AES"
            byte[] r3 = new byte[r0]     // Catch: java.lang.Exception -> Ldc
            r3 = {x00f2: FILL_ARRAY_DATA , data: [34, -28, -26, 28, 117, 114, -104, -99, 122, 6, 103, 18, -52, -123, 30, -19} // fill-array     // Catch: java.lang.Exception -> Ldc
            java.lang.String r3 = bz.AbstractC0569y0.a(r3)     // Catch: java.lang.Exception -> Ldc
            javax.crypto.KeyGenerator r2 = javax.crypto.KeyGenerator.getInstance(r2, r3)     // Catch: java.lang.Exception -> Ldc
            if (r2 == 0) goto Ldc
            if (r1 != 0) goto L9a
            goto Ldc
        L9a:
            r3 = 0
            r1.load(r3)     // Catch: java.lang.Exception -> Ldc
            android.security.keystore.KeyGenParameterSpec$Builder r1 = new android.security.keystore.KeyGenParameterSpec$Builder     // Catch: java.lang.Exception -> Ldc
            byte[] r0 = new byte[r0]     // Catch: java.lang.Exception -> Ldc
            r0 = {x00fe: FILL_ARRAY_DATA , data: [6, -51, 49, -58, 5, -46, -23, 56, -7, -13, -125, 101, -47, -20, -23, -22} // fill-array     // Catch: java.lang.Exception -> Ldc
            java.lang.String r0 = bz.AbstractC0569y0.a(r0)     // Catch: java.lang.Exception -> Ldc
            r3 = 3
            r1.<init>(r0, r3)     // Catch: java.lang.Exception -> Ldc
            java.lang.String r0 = "CBC"
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch: java.lang.Exception -> Ldc
            android.security.keystore.KeyGenParameterSpec$Builder r0 = r1.setBlockModes(r0)     // Catch: java.lang.Exception -> Ldc
            android.security.keystore.KeyGenParameterSpec$Builder r0 = r0.setUserAuthenticationRequired(r8)     // Catch: java.lang.Exception -> Ldc
            java.lang.String r1 = "PKCS7Padding"
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch: java.lang.Exception -> Ldc
            android.security.keystore.KeyGenParameterSpec$Builder r0 = r0.setEncryptionPaddings(r1)     // Catch: java.lang.Exception -> Ldc
            android.security.keystore.KeyGenParameterSpec r0 = r0.build()     // Catch: java.lang.Exception -> Ldc
            r2.init(r0)     // Catch: java.lang.Exception -> Ldc
            goto Ldb
        Lcd:
            if (r2 < r4) goto Ldc
            android.content.Context r0 = r10.c
            boolean r0 = bz.K0.a(r0, r3)
            if (r0 == 0) goto Ldc
            int r0 = r10.g
            if (r0 != 0) goto Ldc
        Ldb:
            r7 = r8
        Ldc:
            java.lang.String r0 = bz.C0514g.j
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)
            r5.put(r0, r1)
        Le5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bz.C0514g.i():java.io.Serializable");
    }
}
