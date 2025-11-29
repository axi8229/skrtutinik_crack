package com.sputnik.service_payments.ui.blocking;

import android.view.View;
import com.sputnik.service_payments.databinding.FragmentPaymentDebtBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlockingPaymentFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class BlockingPaymentFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentPaymentDebtBinding> {
    public static final BlockingPaymentFragment$binding$2 INSTANCE = new BlockingPaymentFragment$binding$2();

    BlockingPaymentFragment$binding$2() {
        super(1, FragmentPaymentDebtBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/service_payments/databinding/FragmentPaymentDebtBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentPaymentDebtBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentPaymentDebtBinding.bind(p0);
    }
}
