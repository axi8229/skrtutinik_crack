package com.sputnik.oboarding.ui.onboarding;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentOnboardingBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBoardingFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class OnBoardingFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentOnboardingBinding> {
    public static final OnBoardingFragment$binding$2 INSTANCE = new OnBoardingFragment$binding$2();

    OnBoardingFragment$binding$2() {
        super(1, FragmentOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentOnboardingBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentOnboardingBinding.bind(p0);
    }
}
