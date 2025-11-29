package com.yandex.metrica.impl.ob;

import java.util.Arrays;

/* renamed from: com.yandex.metrica.impl.ob.v9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1312v9 {
    private final a a;
    private final Ql b;

    /* renamed from: com.yandex.metrica.impl.ob.v9$a */
    public static class a {
    }

    public C1312v9() {
        this(new a(), new Ql());
    }

    public byte[] a(byte[] bArr, String str) {
        try {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            a aVar = this.a;
            byte[] bytes = str.getBytes();
            aVar.getClass();
            C1349wm c1349wm = new C1349wm("AES/CBC/PKCS5Padding", bytes, bArrCopyOfRange);
            if (A2.a(bArr)) {
                return null;
            }
            return this.b.uncompress(c1349wm.a(bArr, 16, bArr.length - 16));
        } catch (Throwable unused) {
            return null;
        }
    }

    public C1312v9(a aVar, Ql ql) {
        this.a = aVar;
        this.b = ql;
    }
}
