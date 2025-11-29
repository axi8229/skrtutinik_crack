package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import androidx.fragment.app.Fragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.MainDialogFragment;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C2214y extends FunctionReferenceImpl implements Function1 {
    public C2214y(Object obj) {
        super(1, obj, H.class, "handleEffect", "handleEffect(Lru/yoomoney/sdk/kassa/payments/confirmation/sberpay/SberPayConfirmationContract$Effect;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        r p0 = (r) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        H h = (H) this.receiver;
        int i = H.$r8$clinit;
        h.getClass();
        if (p0 instanceof C2207q) {
            C2207q c2207q = (C2207q) p0;
            h.a(c2207q.a, c2207q.b, c2207q.c, c2207q.d);
        } else if (p0 instanceof C2206p) {
            Fragment parentFragment = h.getParentFragment();
            MainDialogFragment mainDialogFragment = parentFragment instanceof MainDialogFragment ? (MainDialogFragment) parentFragment : null;
            if (mainDialogFragment != null) {
                mainDialogFragment.dismiss();
            }
        }
        return Unit.INSTANCE;
    }
}
