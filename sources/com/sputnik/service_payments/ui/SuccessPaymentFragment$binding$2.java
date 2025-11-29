package com.sputnik.service_payments.ui;

import android.view.View;
import com.sputnik.service_payments.databinding.FragmentSuccessPaymentBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuccessPaymentFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class SuccessPaymentFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentSuccessPaymentBinding> {
    public static final SuccessPaymentFragment$binding$2 INSTANCE = new SuccessPaymentFragment$binding$2();

    SuccessPaymentFragment$binding$2() {
        super(1, FragmentSuccessPaymentBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/service_payments/databinding/FragmentSuccessPaymentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentSuccessPaymentBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentSuccessPaymentBinding.bind(p0);
    }
}
