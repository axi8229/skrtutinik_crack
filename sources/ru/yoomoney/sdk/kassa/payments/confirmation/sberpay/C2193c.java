package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2193c extends Lambda implements Function1 {
    public final /* synthetic */ C2200j a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2193c(C2200j c2200j) {
        super(1);
        this.a = c2200j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new C2191a(this.a, invoke, null));
        CoreKt.input(invoke, new C2192b(this.a, null));
        return Unit.INSTANCE;
    }
}
