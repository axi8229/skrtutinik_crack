package com.yandex.metrica.impl.ob;

import android.os.Process;

/* loaded from: classes3.dex */
class C7 {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final C1167p7 d;

    C7(String str, boolean z, C1167p7 c1167p7) {
        this(str, z, c1167p7, A2.a(23) && Process.is64Bit());
    }

    C7(String str, boolean z, C1167p7 c1167p7, boolean z2) {
        this.a = str;
        this.c = z;
        this.d = c1167p7;
        this.b = z2;
    }
}
