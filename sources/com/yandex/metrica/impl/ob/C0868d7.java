package com.yandex.metrica.impl.ob;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.d7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0868d7 {
    private final byte[] a;
    private final C0843c7 b;

    public C0868d7(byte[] bArr, C0843c7 c0843c7) {
        this.a = bArr;
        this.b = c0843c7;
    }

    public final byte[] a() {
        return this.a;
    }

    public final C0843c7 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0868d7)) {
            return false;
        }
        C0868d7 c0868d7 = (C0868d7) obj;
        return Intrinsics.areEqual(this.a, c0868d7.a) && Intrinsics.areEqual(this.b, c0868d7.b);
    }

    public int hashCode() {
        byte[] bArr = this.a;
        int iHashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        C0843c7 c0843c7 = this.b;
        return iHashCode + (c0843c7 != null ? c0843c7.hashCode() : 0);
    }

    public String toString() {
        return "NativeCrashModel(data=" + Arrays.toString(this.a) + ", handlerDescription=" + this.b + ")";
    }
}
