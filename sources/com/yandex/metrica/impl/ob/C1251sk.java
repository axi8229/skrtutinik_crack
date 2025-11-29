package com.yandex.metrica.impl.ob;

import android.util.SparseIntArray;

/* renamed from: com.yandex.metrica.impl.ob.sk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1251sk implements Qk {
    private final SparseIntArray a = new SparseIntArray();
    private final int b;

    public C1251sk(int i) {
        this.b = i;
    }

    @Override // com.yandex.metrica.impl.ob.Qk
    public void a(C1228rl c1228rl) {
        SparseIntArray sparseIntArray = this.a;
        int i = c1228rl.d;
        sparseIntArray.put(i, sparseIntArray.get(i) + 1);
    }

    public int a(int i) {
        return this.b - Integer.valueOf(this.a.get(i)).intValue();
    }
}
