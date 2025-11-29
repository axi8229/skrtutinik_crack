package ru.yoomoney.sdk.auth.phone.confirm.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractor;

/* loaded from: classes4.dex */
public final class AccountPhoneConfirmModule_AccountPhoneConfirmInteractorFactory implements Factory<AccountPhoneConfirmInteractor> {
    private final Provider<EmailChangeRepository> emailChangeRepositoryProvider;
    private final AccountPhoneConfirmModule module;
    private final Provider<PasswordChangeRepository> passwordChangeRepositoryProvider;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<PhoneChangeRepository> phoneChangeRepositoryProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountPhoneConfirmModule_AccountPhoneConfirmInteractorFactory(AccountPhoneConfirmModule accountPhoneConfirmModule, Provider<EmailChangeRepository> provider, Provider<PhoneChangeRepository> provider2, Provider<PasswordChangeRepository> provider3, Provider<PasswordRecoveryRepository> provider4, Provider<ServerTimeRepository> provider5) {
        this.module = accountPhoneConfirmModule;
        this.emailChangeRepositoryProvider = provider;
        this.phoneChangeRepositoryProvider = provider2;
        this.passwordChangeRepositoryProvider = provider3;
        this.passwordRecoveryRepositoryProvider = provider4;
        this.serverTimeRepositoryProvider = provider5;
    }

    public static AccountPhoneConfirmInteractor accountPhoneConfirmInteractor(AccountPhoneConfirmModule accountPhoneConfirmModule, EmailChangeRepository emailChangeRepository, PhoneChangeRepository phoneChangeRepository, PasswordChangeRepository passwordChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        return (AccountPhoneConfirmInteractor) Preconditions.checkNotNullFromProvides(accountPhoneConfirmModule.accountPhoneConfirmInteractor(emailChangeRepository, phoneChangeRepository, passwordChangeRepository, passwordRecoveryRepository, serverTimeRepository));
    }

    public static AccountPhoneConfirmModule_AccountPhoneConfirmInteractorFactory create(AccountPhoneConfirmModule accountPhoneConfirmModule, Provider<EmailChangeRepository> provider, Provider<PhoneChangeRepository> provider2, Provider<PasswordChangeRepository> provider3, Provider<PasswordRecoveryRepository> provider4, Provider<ServerTimeRepository> provider5) {
        return new AccountPhoneConfirmModule_AccountPhoneConfirmInteractorFactory(accountPhoneConfirmModule, provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public AccountPhoneConfirmInteractor get() {
        return accountPhoneConfirmInteractor(this.module, this.emailChangeRepositoryProvider.get(), this.phoneChangeRepositoryProvider.get(), this.passwordChangeRepositoryProvider.get(), this.passwordRecoveryRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
