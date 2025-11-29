package com.group_ib.sdk;

import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class h1 implements d1 {
    public static final String[] c = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};
    public static final String[] d = {"/system", "/system/bin", "/system/sbin", "/system/xbin", "/vendor/bin", "/sbin", "/etc"};
    public final MobileSdkService a;
    public JSONObject b = null;

    public h1(MobileSdkService mobileSdkService) {
        this.a = mobileSdkService;
    }

    @Override // com.group_ib.sdk.d1
    public final void a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e1, code lost:
    
        r16.b.put(r11, "rw");
        com.group_ib.sdk.c1.a(4, 4, "RootProvider", r11 + " is writable");
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0185 A[ORIG_RETURN, RETURN] */
    @Override // com.group_ib.sdk.d1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r17) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.h1.a(int):void");
    }

    @Override // com.group_ib.sdk.d1
    public final void run() {
    }

    public final void a(String[] strArr, String str) throws JSONException {
        try {
            for (String str2 : strArr) {
                if (new File(str2 + str).exists()) {
                    c1.a(4, 4, "RootProvider", str2 + str + " exists");
                    this.b.put(str2 + str, true);
                    return;
                }
            }
        } catch (Exception e) {
            c1.b("RootProvider", "failed to check file existance", e);
        }
    }
}
