package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* loaded from: classes3.dex */
public class m1 {
    private static m1 b = new m1();
    private a a = new a();

    class a {
        String a;
        String b;
        long c = 0;

        a() {
        }

        void a(long j) {
            m1.this.a.c = j;
        }

        void a(String str) {
            m1.this.a.b = str;
        }

        void b(String str) {
            m1.this.a.a = str;
        }
    }

    public static m1 d() {
        return b;
    }

    public String a() {
        return this.a.b;
    }

    public void a(String str, String str2) {
        long jB = b();
        String strC = w0.c(str, str2);
        if (strC == null || strC.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (jB == 0) {
            jB = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - jB <= 43200000) {
            return;
        }
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String strA = h0.a(strC, strGenerateSecureRandomStr);
        this.a.a(jB);
        this.a.b(strGenerateSecureRandomStr);
        this.a.a(strA);
    }

    public long b() {
        return this.a.c;
    }

    public String c() {
        return this.a.a;
    }
}
