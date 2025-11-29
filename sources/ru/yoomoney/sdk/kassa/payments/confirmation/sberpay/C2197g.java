package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2197g extends Lambda implements Function1 {
    public final /* synthetic */ C2200j a;
    public final /* synthetic */ AbstractC2205o b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2197g(C2200j c2200j, AbstractC2205o abstractC2205o) {
        super(1);
        this.a = c2200j;
        this.b = abstractC2205o;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, this.a.c);
        CoreKt.output(invoke, new C2196f(this.a, this.b, null));
        return Unit.INSTANCE;
    }
}
