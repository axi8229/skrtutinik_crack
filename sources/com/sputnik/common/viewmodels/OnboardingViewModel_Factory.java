package com.sputnik.common.viewmodels;

import android.app.Application;
import com.sputnik.data.local.PrefManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class OnboardingViewModel_Factory implements Factory<OnboardingViewModel> {
    private final Provider<Application> applicationProvider;
    private final Provider<PrefManager> prefManagerProvider;

    public OnboardingViewModel_Factory(Provider<PrefManager> provider, Provider<Application> provider2) {
        this.prefManagerProvider = provider;
        this.applicationProvider = provider2;
    }

    @Override // javax.inject.Provider
    public OnboardingViewModel get() {
        return newInstance(this.prefManagerProvider.get(), this.applicationProvider.get());
    }

    public static OnboardingViewModel_Factory create(Provider<PrefManager> provider, Provider<Application> provider2) {
        return new OnboardingViewModel_Factory(provider, provider2);
    }

    public static OnboardingViewModel newInstance(PrefManager prefManager, Application application) {
        return new OnboardingViewModel(prefManager, application);
    }
}
