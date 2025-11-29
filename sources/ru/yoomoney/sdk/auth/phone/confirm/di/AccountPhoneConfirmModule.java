package ru.yoomoney.sdk.auth.phone.confirm.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment;
import ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractor;
import ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractorImpl;
import ru.yoomoney.sdk.auth.phone.confirm.impl.PhoneConfirmViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007JF\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/di/AccountPhoneConfirmModule;", "", "()V", "accountPhoneConfirmInteractor", "Lru/yoomoney/sdk/auth/phone/confirm/impl/AccountPhoneConfirmInteractor;", "emailChangeRepository", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "phoneChangeRepository", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;", "passwordChangeRepository", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "providePhoneConfirmFragment", "Landroidx/fragment/app/Fragment;", "interactor", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountPhoneConfirmModule {
    public final AccountPhoneConfirmInteractor accountPhoneConfirmInteractor(EmailChangeRepository emailChangeRepository, PhoneChangeRepository phoneChangeRepository, PasswordChangeRepository passwordChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(emailChangeRepository, "emailChangeRepository");
        Intrinsics.checkNotNullParameter(phoneChangeRepository, "phoneChangeRepository");
        Intrinsics.checkNotNullParameter(passwordChangeRepository, "passwordChangeRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new AccountPhoneConfirmInteractorImpl(emailChangeRepository, phoneChangeRepository, passwordChangeRepository, passwordRecoveryRepository, serverTimeRepository);
    }

    public final Fragment providePhoneConfirmFragment(AccountPhoneConfirmInteractor interactor, Lazy<Config> lazyConfig, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new PhoneConfirmFragment(new PhoneConfirmViewModelFactory(interactor, null), lazyConfig, resultData, router, processMapper, resourceMapper, serverTimeRepository);
    }
}
