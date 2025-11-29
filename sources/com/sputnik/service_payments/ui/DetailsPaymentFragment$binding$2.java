package com.sputnik.service_payments.ui;

import android.view.View;
import com.sputnik.service_payments.databinding.FragmentDetailsPaymentBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetailsPaymentFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class DetailsPaymentFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentDetailsPaymentBinding> {
    public static final DetailsPaymentFragment$binding$2 INSTANCE = new DetailsPaymentFragment$binding$2();

    DetailsPaymentFragment$binding$2() {
        super(1, FragmentDetailsPaymentBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/service_payments/databinding/FragmentDetailsPaymentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentDetailsPaymentBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentDetailsPaymentBinding.bind(p0);
    }
}
