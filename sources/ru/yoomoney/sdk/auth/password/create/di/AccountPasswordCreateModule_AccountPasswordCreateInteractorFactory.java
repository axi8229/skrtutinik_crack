package ru.yoomoney.sdk.auth.password.create.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.create.impl.AccountPasswordCreateInteractor;

/* loaded from: classes4.dex */
public final class AccountPasswordCreateModule_AccountPasswordCreateInteractorFactory implements Factory<AccountPasswordCreateInteractor> {
    private final AccountPasswordCreateModule module;
    private final Provider<PasswordChangeRepository> passwordChangeRepositoryProvider;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountPasswordCreateModule_AccountPasswordCreateInteractorFactory(AccountPasswordCreateModule accountPasswordCreateModule, Provider<PasswordChangeRepository> provider, Provider<PasswordRecoveryRepository> provider2, Provider<ServerTimeRepository> provider3) {
        this.module = accountPasswordCreateModule;
        this.passwordChangeRepositoryProvider = provider;
        this.passwordRecoveryRepositoryProvider = provider2;
        this.serverTimeRepositoryProvider = provider3;
    }

    public static AccountPasswordCreateInteractor accountPasswordCreateInteractor(AccountPasswordCreateModule accountPasswordCreateModule, PasswordChangeRepository passwordChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        return (AccountPasswordCreateInteractor) Preconditions.checkNotNullFromProvides(accountPasswordCreateModule.accountPasswordCreateInteractor(passwordChangeRepository, passwordRecoveryRepository, serverTimeRepository));
    }

    public static AccountPasswordCreateModule_AccountPasswordCreateInteractorFactory create(AccountPasswordCreateModule accountPasswordCreateModule, Provider<PasswordChangeRepository> provider, Provider<PasswordRecoveryRepository> provider2, Provider<ServerTimeRepository> provider3) {
        return new AccountPasswordCreateModule_AccountPasswordCreateInteractorFactory(accountPasswordCreateModule, provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public AccountPasswordCreateInteractor get() {
        return accountPasswordCreateInteractor(this.module, this.passwordChangeRepositoryProvider.get(), this.passwordRecoveryRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
