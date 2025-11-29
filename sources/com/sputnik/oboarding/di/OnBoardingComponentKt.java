package com.sputnik.oboarding.di;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBoardingComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"onBoardingComponent", "Lcom/sputnik/oboarding/di/OnBoardingComponent;", "Landroidx/fragment/app/Fragment;", "onboarding_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OnBoardingComponentKt {
    public static final OnBoardingComponent onBoardingComponent(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        return ((OnBoardingComponentViewModel) new ViewModelProvider(fragmentActivityRequireActivity).get(OnBoardingComponentViewModel.class)).getOnBoardingComponent();
    }
}
