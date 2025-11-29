package com.yandex.metrica.impl.ob;

import android.util.Base64;

/* renamed from: com.yandex.metrica.impl.ob.xm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1373xm implements Cm {
    private final C1349wm a;

    C1373xm() {
        this(new C1325vm(F0.g().e()));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @Override // com.yandex.metrica.impl.ob.Cm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.yandex.metrica.impl.ob.Bm a(com.yandex.metrica.impl.ob.C0836c0 r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.q()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L1e
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r0.getBytes(r1)     // Catch: java.lang.Throwable -> L1e
            com.yandex.metrica.impl.ob.wm r1 = r2.a     // Catch: java.lang.Throwable -> L1e
            byte[] r0 = r1.a(r0)     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L1e
            r1 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r0 = 0
        L1f:
            com.yandex.metrica.impl.ob.Bm r1 = new com.yandex.metrica.impl.ob.Bm
            com.yandex.metrica.impl.ob.c0 r3 = r3.f(r0)
            com.yandex.metrica.impl.ob.Em r0 = com.yandex.metrica.impl.ob.Em.AES_VALUE_ENCRYPTION
            r1.<init>(r3, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C1373xm.a(com.yandex.metrica.impl.ob.c0):com.yandex.metrica.impl.ob.Bm");
    }

    C1373xm(C1325vm c1325vm) {
        this(new C1349wm("AES/CBC/PKCS5Padding", c1325vm.b(), c1325vm.a()));
    }

    C1373xm(C1349wm c1349wm) {
        this.a = c1349wm;
    }

    @Override // com.yandex.metrica.impl.ob.Cm
    public byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || bArr.length <= 0) {
            return bArr2;
        }
        try {
            byte[] bArrDecode = Base64.decode(bArr, 0);
            C1349wm c1349wm = this.a;
            c1349wm.getClass();
            return c1349wm.a(bArrDecode, 0, bArrDecode.length);
        } catch (Throwable unused) {
            return bArr2;
        }
    }
}
