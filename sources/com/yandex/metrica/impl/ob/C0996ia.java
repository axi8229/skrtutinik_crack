package com.yandex.metrica.impl.ob;

import android.content.Context;

/* renamed from: com.yandex.metrica.impl.ob.ia, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0996ia implements R7 {
    private final R7 a;

    C0996ia(Context context, W7 w7, R7 r7) {
        this.a = r7;
    }

    @Override // com.yandex.metrica.impl.ob.R7
    public void a(String str, byte[] bArr) {
        this.a.a(str, bArr);
    }

    @Override // com.yandex.metrica.impl.ob.R7
    public void b(String str) {
        this.a.b(str);
    }

    @Override // com.yandex.metrica.impl.ob.R7
    public byte[] a(String str) {
        return this.a.a(str);
    }
}
