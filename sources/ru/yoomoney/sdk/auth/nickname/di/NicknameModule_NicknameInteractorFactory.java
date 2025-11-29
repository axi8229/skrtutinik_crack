package ru.yoomoney.sdk.auth.nickname.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractor;

/* loaded from: classes4.dex */
public final class NicknameModule_NicknameInteractorFactory implements Factory<NicknameInteractor> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final NicknameModule module;

    public NicknameModule_NicknameInteractorFactory(NicknameModule nicknameModule, Provider<AccountRepository> provider) {
        this.module = nicknameModule;
        this.accountRepositoryProvider = provider;
    }

    public static NicknameModule_NicknameInteractorFactory create(NicknameModule nicknameModule, Provider<AccountRepository> provider) {
        return new NicknameModule_NicknameInteractorFactory(nicknameModule, provider);
    }

    public static NicknameInteractor nicknameInteractor(NicknameModule nicknameModule, AccountRepository accountRepository) {
        return (NicknameInteractor) Preconditions.checkNotNullFromProvides(nicknameModule.nicknameInteractor(accountRepository));
    }

    @Override // javax.inject.Provider
    public NicknameInteractor get() {
        return nicknameInteractor(this.module, this.accountRepositoryProvider.get());
    }
}
