package ru.yoomoney.sdk.auth.phone.enter.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.enter.impl.AccountPhoneEnterInteractor;

/* loaded from: classes4.dex */
public final class AccountPhoneEnterModule_AccountPasswordEnterInteractorFactory implements Factory<AccountPhoneEnterInteractor> {
    private final AccountPhoneEnterModule module;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<PhoneChangeRepository> phoneChangeRepositoryProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountPhoneEnterModule_AccountPasswordEnterInteractorFactory(AccountPhoneEnterModule accountPhoneEnterModule, Provider<PhoneChangeRepository> provider, Provider<PasswordRecoveryRepository> provider2, Provider<ServerTimeRepository> provider3) {
        this.module = accountPhoneEnterModule;
        this.phoneChangeRepositoryProvider = provider;
        this.passwordRecoveryRepositoryProvider = provider2;
        this.serverTimeRepositoryProvider = provider3;
    }

    public static AccountPhoneEnterInteractor accountPasswordEnterInteractor(AccountPhoneEnterModule accountPhoneEnterModule, PhoneChangeRepository phoneChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        return (AccountPhoneEnterInteractor) Preconditions.checkNotNullFromProvides(accountPhoneEnterModule.accountPasswordEnterInteractor(phoneChangeRepository, passwordRecoveryRepository, serverTimeRepository));
    }

    public static AccountPhoneEnterModule_AccountPasswordEnterInteractorFactory create(AccountPhoneEnterModule accountPhoneEnterModule, Provider<PhoneChangeRepository> provider, Provider<PasswordRecoveryRepository> provider2, Provider<ServerTimeRepository> provider3) {
        return new AccountPhoneEnterModule_AccountPasswordEnterInteractorFactory(accountPhoneEnterModule, provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public AccountPhoneEnterInteractor get() {
        return accountPasswordEnterInteractor(this.module, this.phoneChangeRepositoryProvider.get(), this.passwordRecoveryRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
