package ru.yoomoney.sdk.kassa.payments.contract;

import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.b0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2219b0 implements YmAlertDialog.DialogListener {
    public final /* synthetic */ C2264y0 a;

    public C2219b0(C2264y0 c2264y0) {
        this.a = c2264y0;
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
        C2264y0.a(this.a).handleAction(C2226f.a);
    }
}
