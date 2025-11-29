package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2390v extends Lambda implements Function0 {
    public final /* synthetic */ RuntimeViewModel a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2390v(RuntimeViewModel runtimeViewModel) {
        super(0);
        this.a = runtimeViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.handleAction(ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.d.a);
        return Unit.INSTANCE;
    }
}
