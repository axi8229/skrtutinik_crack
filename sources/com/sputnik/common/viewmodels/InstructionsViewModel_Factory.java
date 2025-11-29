package com.sputnik.common.viewmodels;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InstructionsViewModel_Factory implements Factory<InstructionsViewModel> {
    private final Provider<Application> applicationProvider;

    public InstructionsViewModel_Factory(Provider<Application> provider) {
        this.applicationProvider = provider;
    }

    @Override // javax.inject.Provider
    public InstructionsViewModel get() {
        return newInstance(this.applicationProvider.get());
    }

    public static InstructionsViewModel_Factory create(Provider<Application> provider) {
        return new InstructionsViewModel_Factory(provider);
    }

    public static InstructionsViewModel newInstance(Application application) {
        return new InstructionsViewModel(application);
    }
}
