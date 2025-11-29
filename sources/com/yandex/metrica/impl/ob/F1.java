package com.yandex.metrica.impl.ob;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public class F1 {
    private final int a;
    private final int b;
    private final int c;

    public F1(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final int a(Boolean bool) {
        if (bool == null) {
            return this.a;
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            return this.b;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return this.c;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Boolean a(int i) {
        if (i == this.b) {
            return Boolean.FALSE;
        }
        if (i == this.c) {
            return Boolean.TRUE;
        }
        return null;
    }
}
