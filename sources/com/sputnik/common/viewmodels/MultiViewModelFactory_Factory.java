package com.sputnik.common.viewmodels;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MultiViewModelFactory_Factory implements Factory<MultiViewModelFactory> {
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelFactoriesProvider;

    public MultiViewModelFactory_Factory(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        this.viewModelFactoriesProvider = provider;
    }

    @Override // javax.inject.Provider
    public MultiViewModelFactory get() {
        return newInstance(this.viewModelFactoriesProvider.get());
    }

    public static MultiViewModelFactory_Factory create(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        return new MultiViewModelFactory_Factory(provider);
    }

    public static MultiViewModelFactory newInstance(Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        return new MultiViewModelFactory(map);
    }
}
