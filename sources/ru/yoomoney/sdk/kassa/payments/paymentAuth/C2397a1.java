package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.a1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2397a1 extends Lambda implements Function1 {
    public final /* synthetic */ RuntimeViewModel a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2397a1(RuntimeViewModel runtimeViewModel) {
        super(1);
        this.a = runtimeViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.a.handleAction(new C2451w(it));
        return Unit.INSTANCE;
    }
}
