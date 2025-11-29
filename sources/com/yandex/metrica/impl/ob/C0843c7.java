package com.yandex.metrica.impl.ob;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.c7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0843c7 {
    private final EnumC0943g7 a;
    private final String b;

    public C0843c7() {
        this(null, 0 == true ? 1 : 0, 3);
    }

    public C0843c7(EnumC0943g7 enumC0943g7, String str) {
        this.a = enumC0943g7;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final EnumC0943g7 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0843c7)) {
            return false;
        }
        C0843c7 c0843c7 = (C0843c7) obj;
        return Intrinsics.areEqual(this.a, c0843c7.a) && Intrinsics.areEqual(this.b, c0843c7.b);
    }

    public int hashCode() {
        EnumC0943g7 enumC0943g7 = this.a;
        int iHashCode = (enumC0943g7 != null ? enumC0943g7.hashCode() : 0) * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "NativeCrashHandlerDescription(source=" + this.a + ", handlerVersion=" + this.b + ")";
    }

    public /* synthetic */ C0843c7(EnumC0943g7 enumC0943g7, String str, int i) {
        this((i & 1) != 0 ? EnumC0943g7.UNKNOWN : null, null);
    }
}
