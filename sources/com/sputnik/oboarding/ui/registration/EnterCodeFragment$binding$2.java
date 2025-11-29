package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegEnterCodeBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterCodeFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class EnterCodeFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegEnterCodeBinding> {
    public static final EnterCodeFragment$binding$2 INSTANCE = new EnterCodeFragment$binding$2();

    EnterCodeFragment$binding$2() {
        super(1, FragmentRegEnterCodeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegEnterCodeBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegEnterCodeBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegEnterCodeBinding.bind(p0);
    }
}
