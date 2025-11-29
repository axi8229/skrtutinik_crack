package com.sputnik.oboarding.di;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* compiled from: OnBoardingComponent.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/oboarding/di/OnBoardingComponentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "onBoardingComponent", "Lcom/sputnik/oboarding/di/OnBoardingComponent;", "getOnBoardingComponent", "()Lcom/sputnik/oboarding/di/OnBoardingComponent;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OnBoardingComponentViewModel extends ViewModel {
    private final OnBoardingComponent onBoardingComponent = DaggerOnBoardingComponent.builder().deps(OnBoardingDepsProvider.INSTANCE.getDeps()).build();

    public final OnBoardingComponent getOnBoardingComponent() {
        return this.onBoardingComponent;
    }
}
