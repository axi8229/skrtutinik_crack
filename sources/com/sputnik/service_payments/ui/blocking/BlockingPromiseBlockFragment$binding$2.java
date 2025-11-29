package com.sputnik.service_payments.ui.blocking;

import android.view.View;
import com.sputnik.service_payments.databinding.FragmentPromiseBlockBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlockingPromiseBlockFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class BlockingPromiseBlockFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentPromiseBlockBinding> {
    public static final BlockingPromiseBlockFragment$binding$2 INSTANCE = new BlockingPromiseBlockFragment$binding$2();

    BlockingPromiseBlockFragment$binding$2() {
        super(1, FragmentPromiseBlockBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/service_payments/databinding/FragmentPromiseBlockBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentPromiseBlockBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentPromiseBlockBinding.bind(p0);
    }
}
