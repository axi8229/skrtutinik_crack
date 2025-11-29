package com.group_ib.sdk;

import android.provider.Settings;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.m0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0610m0 implements d1 {
    public final MobileSdkService a;
    public final String b = X.b(11);

    public C0610m0(MobileSdkService mobileSdkService) {
        this.a = mobileSdkService;
    }

    @Override // com.group_ib.sdk.d1
    public final void a() {
    }

    @Override // com.group_ib.sdk.d1
    public final void a(int i) throws Throwable {
        C0602i0 c0602i0;
        int i2;
        if (i != 64) {
            return;
        }
        synchronized (T.class) {
            c0602i0 = T.f;
        }
        if (c0602i0 != null) {
            c0602i0.a();
            this.a.a(c0602i0);
        }
        E0 e0 = this.a.l;
        JSONObject jSONObject = null;
        HashMap mapA = e0 != null ? e0.a() : null;
        if (mapA != null) {
            String str = (String) mapA.get("gssc" + T.a);
            if (str == null || str.isEmpty()) {
                return;
            }
            String str2 = c0602i0 != null ? c0602i0.c : null;
            if (str2 != null) {
                try {
                    File file = new File(str2);
                    long length = file.length();
                    String string = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
                    long jAbs = 0;
                    if (length > 32) {
                        for (int i3 = 0; i3 < str.length(); i3++) {
                            String str3 = this.b;
                            jAbs = ((((jAbs >>> 57) | (jAbs << 7)) ^ str.charAt(X.a(i3))) ^ str3.charAt(i3 % str3.length())) ^ string.charAt(i3 % string.length());
                        }
                        i2 = 16;
                        jAbs = Math.abs(jAbs % (length - 16));
                    } else {
                        i2 = (int) length;
                    }
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (fileInputStream.skip(jAbs) == jAbs) {
                        byte[] bArr = new byte[i2];
                        int i4 = fileInputStream.read(bArr);
                        fileInputStream.close();
                        if (i4 > 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("pkg_name", c0602i0.a);
                            if (c0602i0.m == null) {
                                c0602i0.a();
                            }
                            jSONObject2.put("apk_hash", c0602i0.m);
                            jSONObject2.put("gssc", str);
                            jSONObject2.put("block", AbstractC0604j0.a(bArr));
                            jSONObject = jSONObject2;
                        }
                    }
                } catch (Exception e) {
                    c1.b("ApkIntegrityProvider", "failed to evaluate apk partial hash", e);
                }
            }
            if (jSONObject != null) {
                c1.a(4, 4, "ApkIntegrityProvider", "Apk integrity data has changed");
                this.a.a(jSONObject);
            }
        }
    }

    @Override // com.group_ib.sdk.d1
    public final void run() {
    }
}
