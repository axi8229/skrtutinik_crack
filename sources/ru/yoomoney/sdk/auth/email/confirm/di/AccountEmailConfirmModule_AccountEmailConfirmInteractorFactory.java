package ru.yoomoney.sdk.auth.email.confirm.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractor;

/* loaded from: classes4.dex */
public final class AccountEmailConfirmModule_AccountEmailConfirmInteractorFactory implements Factory<AccountEmailConfirmInteractor> {
    private final Provider<EmailChangeRepository> emailChangeRepositoryProvider;
    private final AccountEmailConfirmModule module;
    private final Provider<PasswordChangeRepository> passwordChangeRepositoryProvider;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountEmailConfirmModule_AccountEmailConfirmInteractorFactory(AccountEmailConfirmModule accountEmailConfirmModule, Provider<EmailChangeRepository> provider, Provider<PasswordChangeRepository> provider2, Provider<PasswordRecoveryRepository> provider3, Provider<ServerTimeRepository> provider4) {
        this.module = accountEmailConfirmModule;
        this.emailChangeRepositoryProvider = provider;
        this.passwordChangeRepositoryProvider = provider2;
        this.passwordRecoveryRepositoryProvider = provider3;
        this.serverTimeRepositoryProvider = provider4;
    }

    public static AccountEmailConfirmInteractor accountEmailConfirmInteractor(AccountEmailConfirmModule accountEmailConfirmModule, EmailChangeRepository emailChangeRepository, PasswordChangeRepository passwordChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        return (AccountEmailConfirmInteractor) Preconditions.checkNotNullFromProvides(accountEmailConfirmModule.accountEmailConfirmInteractor(emailChangeRepository, passwordChangeRepository, passwordRecoveryRepository, serverTimeRepository));
    }

    public static AccountEmailConfirmModule_AccountEmailConfirmInteractorFactory create(AccountEmailConfirmModule accountEmailConfirmModule, Provider<EmailChangeRepository> provider, Provider<PasswordChangeRepository> provider2, Provider<PasswordRecoveryRepository> provider3, Provider<ServerTimeRepository> provider4) {
        return new AccountEmailConfirmModule_AccountEmailConfirmInteractorFactory(accountEmailConfirmModule, provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public AccountEmailConfirmInteractor get() {
        return accountEmailConfirmInteractor(this.module, this.emailChangeRepositoryProvider.get(), this.passwordChangeRepositoryProvider.get(), this.passwordRecoveryRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
