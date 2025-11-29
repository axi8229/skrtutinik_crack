package com.sputnik.common.viewmodels;

import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.usecases.auth.ConfirmCodeUseCase;
import com.sputnik.domain.usecases.auth.ConfirmRegistrationUseCase;
import com.sputnik.domain.usecases.auth.GetRequestUseCase;
import com.sputnik.domain.usecases.auth.RegisterUserByPhoneUseCase;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CallCodeViewModel_Factory_Factory {
    private final Provider<IConfig> configProvider;
    private final Provider<ConfirmCodeUseCase> confirmCodeUseCaseProvider;
    private final Provider<ConfirmRegistrationUseCase> confirmRegistrationUseCaseProvider;
    private final Provider<GetRequestUseCase> getRequestUseCaseProvider;
    private final Provider<PrefManager> prefManagerProvider;
    private final Provider<RegisterUserByPhoneUseCase> registerUserUserCaseProvider;

    public CallCodeViewModel_Factory_Factory(Provider<ConfirmCodeUseCase> provider, Provider<RegisterUserByPhoneUseCase> provider2, Provider<ConfirmRegistrationUseCase> provider3, Provider<GetRequestUseCase> provider4, Provider<PrefManager> provider5, Provider<IConfig> provider6) {
        this.confirmCodeUseCaseProvider = provider;
        this.registerUserUserCaseProvider = provider2;
        this.confirmRegistrationUseCaseProvider = provider3;
        this.getRequestUseCaseProvider = provider4;
        this.prefManagerProvider = provider5;
        this.configProvider = provider6;
    }

    public CallCodeViewModel.Factory get(String str) {
        return newInstance(str, this.confirmCodeUseCaseProvider.get(), this.registerUserUserCaseProvider.get(), this.confirmRegistrationUseCaseProvider.get(), this.getRequestUseCaseProvider.get(), this.prefManagerProvider.get(), this.configProvider.get());
    }

    public static CallCodeViewModel_Factory_Factory create(Provider<ConfirmCodeUseCase> provider, Provider<RegisterUserByPhoneUseCase> provider2, Provider<ConfirmRegistrationUseCase> provider3, Provider<GetRequestUseCase> provider4, Provider<PrefManager> provider5, Provider<IConfig> provider6) {
        return new CallCodeViewModel_Factory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CallCodeViewModel.Factory newInstance(String str, ConfirmCodeUseCase confirmCodeUseCase, RegisterUserByPhoneUseCase registerUserByPhoneUseCase, ConfirmRegistrationUseCase confirmRegistrationUseCase, GetRequestUseCase getRequestUseCase, PrefManager prefManager, IConfig iConfig) {
        return new CallCodeViewModel.Factory(str, confirmCodeUseCase, registerUserByPhoneUseCase, confirmRegistrationUseCase, getRequestUseCase, prefManager, iConfig);
    }
}
