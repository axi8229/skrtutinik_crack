package com.sputnik.service_payments.ui.payment_info_list;

import android.view.View;
import com.sputnik.service_payments.databinding.FragmentIntercomPaymentBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntercomPaymentFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class IntercomPaymentFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentIntercomPaymentBinding> {
    public static final IntercomPaymentFragment$binding$2 INSTANCE = new IntercomPaymentFragment$binding$2();

    IntercomPaymentFragment$binding$2() {
        super(1, FragmentIntercomPaymentBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/service_payments/databinding/FragmentIntercomPaymentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentIntercomPaymentBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentIntercomPaymentBinding.bind(p0);
    }
}
