package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegEnterCodeSmsBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterSmsCodeFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class EnterSmsCodeFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegEnterCodeSmsBinding> {
    public static final EnterSmsCodeFragment$binding$2 INSTANCE = new EnterSmsCodeFragment$binding$2();

    EnterSmsCodeFragment$binding$2() {
        super(1, FragmentRegEnterCodeSmsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegEnterCodeSmsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegEnterCodeSmsBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegEnterCodeSmsBinding.bind(p0);
    }
}
