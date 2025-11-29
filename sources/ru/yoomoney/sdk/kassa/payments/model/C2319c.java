package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.model.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C2319c extends o0 {
    public final C2337v a;

    /* JADX WARN: Illegal instructions before constructor call */
    public C2319c() {
        EnumC2338w errorCode = EnumC2338w.a;
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this(new C2337v(errorCode));
    }

    public C2337v a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.model.ApiMethodException");
        return Intrinsics.areEqual(a(), ((C2319c) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public C2319c(C2337v error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = error;
    }
}
