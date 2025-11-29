package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.fragment.app.Fragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.ui.MainDialogFragment;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2377h extends Lambda implements Function0 {
    public final /* synthetic */ C2382m a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2377h(C2382m c2382m) {
        super(0);
        this.a = c2382m;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Fragment parentFragment = this.a.getParentFragment();
        MainDialogFragment mainDialogFragment = parentFragment instanceof MainDialogFragment ? (MainDialogFragment) parentFragment : null;
        if (mainDialogFragment != null) {
            mainDialogFragment.dismiss();
        }
        return Unit.INSTANCE;
    }
}
