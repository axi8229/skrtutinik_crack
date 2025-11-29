package com.sputnik.oboarding.ui.onboarding;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentBaseOnboardingBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class StoryFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentBaseOnboardingBinding> {
    public static final StoryFragment$binding$2 INSTANCE = new StoryFragment$binding$2();

    StoryFragment$binding$2() {
        super(1, FragmentBaseOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentBaseOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentBaseOnboardingBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentBaseOnboardingBinding.bind(p0);
    }
}
