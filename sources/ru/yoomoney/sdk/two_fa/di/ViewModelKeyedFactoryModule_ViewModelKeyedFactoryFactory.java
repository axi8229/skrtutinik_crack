package ru.yoomoney.sdk.two_fa.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ViewModelKeyedFactoryModule_ViewModelKeyedFactoryFactory implements Factory<ViewModelProvider.Factory> {
    private final Provider<Map<String, Provider<ViewModel>>> creatorsProvider;
    private final ViewModelKeyedFactoryModule module;

    public ViewModelKeyedFactoryModule_ViewModelKeyedFactoryFactory(ViewModelKeyedFactoryModule viewModelKeyedFactoryModule, Provider<Map<String, Provider<ViewModel>>> provider) {
        this.module = viewModelKeyedFactoryModule;
        this.creatorsProvider = provider;
    }

    @Override // javax.inject.Provider
    public ViewModelProvider.Factory get() {
        return viewModelKeyedFactory(this.module, this.creatorsProvider.get());
    }

    public static ViewModelKeyedFactoryModule_ViewModelKeyedFactoryFactory create(ViewModelKeyedFactoryModule viewModelKeyedFactoryModule, Provider<Map<String, Provider<ViewModel>>> provider) {
        return new ViewModelKeyedFactoryModule_ViewModelKeyedFactoryFactory(viewModelKeyedFactoryModule, provider);
    }

    public static ViewModelProvider.Factory viewModelKeyedFactory(ViewModelKeyedFactoryModule viewModelKeyedFactoryModule, Map<String, Provider<ViewModel>> map) {
        return (ViewModelProvider.Factory) Preconditions.checkNotNullFromProvides(viewModelKeyedFactoryModule.viewModelKeyedFactory(map));
    }
}
