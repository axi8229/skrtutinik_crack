package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.b0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2463b0 implements YmAlertDialog.DialogListener {
    public final /* synthetic */ C2487j0 a;

    public C2463b0(C2487j0 c2487j0) {
        this.a = c2487j0;
    }

    @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
    public final void onDismiss() {
        YmAlertDialog.DialogListener.DefaultImpls.onDismiss(this);
    }

    @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
    public final void onNegativeClick() {
        YmAlertDialog.DialogListener.DefaultImpls.onNegativeClick(this);
    }

    @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
    public final void onPositiveClick() {
        ((RuntimeViewModel) this.a.e.getValue()).handleAction(C2510t.a);
    }
}
