package ru.yoomoney.sdk.kassa.payments.metrics;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class E {
    public E() {
    }

    public /* synthetic */ E(int i) {
        this();
    }

    public abstract String a();

    public abstract String b();

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof E) {
                E e = (E) obj;
                if (Intrinsics.areEqual(a(), e.a()) && Intrinsics.areEqual(b(), e.b())) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return b().hashCode() + (a().hashCode() * 31);
    }

    public final String toString() {
        return getClass().getSimpleName() + "[name=" + a() + ";value=" + b() + "]";
    }
}
