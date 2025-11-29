package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.z, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C2215z extends FunctionReferenceImpl implements Function1 {
    public C2215z(Object obj) {
        super(1, obj, H.class, "handleFail", "handleFail(Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Throwable p0 = (Throwable) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        H.a((H) this.receiver, p0);
        return Unit.INSTANCE;
    }
}
