package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C2343b;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class B extends Lambda implements Function0 {
    public final /* synthetic */ RuntimeViewModel a;
    public final /* synthetic */ SoftwareKeyboardController b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(RuntimeViewModel runtimeViewModel, SoftwareKeyboardController softwareKeyboardController) {
        super(0);
        this.a = runtimeViewModel;
        this.b = softwareKeyboardController;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.handleAction(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.m(""));
        SoftwareKeyboardController softwareKeyboardController = this.b;
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        this.a.handleAction(C2343b.a);
        return Unit.INSTANCE;
    }
}
