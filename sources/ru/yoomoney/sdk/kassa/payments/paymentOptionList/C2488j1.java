package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.j1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2488j1 extends Lambda implements Function1 {
    public final /* synthetic */ E1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2488j1(E1 e1) {
        super(1);
        this.a = e1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new C2482h1(this.a, null));
        CoreKt.input(invoke, new C2485i1(this.a, null));
        return Unit.INSTANCE;
    }
}
