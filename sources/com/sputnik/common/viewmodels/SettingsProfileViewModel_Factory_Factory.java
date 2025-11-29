package com.sputnik.common.viewmodels;

import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import com.sputnik.domain.usecases.profile.UpdateUseNameUseCase;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SettingsProfileViewModel_Factory_Factory {
    private final Provider<UpdateUseNameUseCase> updateUseNameUseCaseProvider;

    public SettingsProfileViewModel_Factory_Factory(Provider<UpdateUseNameUseCase> provider) {
        this.updateUseNameUseCaseProvider = provider;
    }

    public SettingsProfileViewModel.Factory get(String str, String str2, String str3) {
        return newInstance(str, str2, str3, this.updateUseNameUseCaseProvider.get());
    }

    public static SettingsProfileViewModel_Factory_Factory create(Provider<UpdateUseNameUseCase> provider) {
        return new SettingsProfileViewModel_Factory_Factory(provider);
    }

    public static SettingsProfileViewModel.Factory newInstance(String str, String str2, String str3, UpdateUseNameUseCase updateUseNameUseCase) {
        return new SettingsProfileViewModel.Factory(str, str2, str3, updateUseNameUseCase);
    }
}
