package com.sputnik.common.viewmodels;

import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SettingsProfileViewModel_Factory_AssistFactory_Impl implements SettingsProfileViewModel.Factory.AssistFactory {
    private final SettingsProfileViewModel_Factory_Factory delegateFactory;

    SettingsProfileViewModel_Factory_AssistFactory_Impl(SettingsProfileViewModel_Factory_Factory settingsProfileViewModel_Factory_Factory) {
        this.delegateFactory = settingsProfileViewModel_Factory_Factory;
    }

    @Override // com.sputnik.common.viewmodels.SettingsProfileViewModel.Factory.AssistFactory
    public SettingsProfileViewModel.Factory create(String str, String str2, String str3) {
        return this.delegateFactory.get(str, str2, str3);
    }

    public static Provider<SettingsProfileViewModel.Factory.AssistFactory> create(SettingsProfileViewModel_Factory_Factory settingsProfileViewModel_Factory_Factory) {
        return InstanceFactory.create(new SettingsProfileViewModel_Factory_AssistFactory_Impl(settingsProfileViewModel_Factory_Factory));
    }
}
