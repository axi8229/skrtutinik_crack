package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.c0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2466c0 extends Lambda implements Function0 {
    public final /* synthetic */ C2487j0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2466c0(C2487j0 c2487j0) {
        super(0);
        this.a = c2487j0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((RuntimeViewModel) this.a.e.getValue()).handleAction(C2505q.a);
        return Unit.INSTANCE;
    }
}
