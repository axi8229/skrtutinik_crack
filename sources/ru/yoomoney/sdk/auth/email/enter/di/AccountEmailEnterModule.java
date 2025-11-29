package ru.yoomoney.sdk.auth.email.enter.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment;
import ru.yoomoney.sdk.auth.email.enter.impl.AccountEmailEnterInteractor;
import ru.yoomoney.sdk.auth.email.enter.impl.AccountEmailEnterInteractorImpl;
import ru.yoomoney.sdk.auth.email.enter.impl.EmailEnterViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007JL\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015H\u0007¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/di/AccountEmailEnterModule;", "", "()V", "accountEmailEnterInteractor", "Lru/yoomoney/sdk/auth/email/enter/impl/AccountEmailEnterInteractor;", "emailChangeRepository", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "provideEnterEmailFragment", "Landroidx/fragment/app/Fragment;", "interactor", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "lazyRemoteConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/RemoteConfig;", "lazyConfig", "Lru/yoomoney/sdk/auth/Config;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountEmailEnterModule {
    public final AccountEmailEnterInteractor accountEmailEnterInteractor(EmailChangeRepository emailChangeRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(emailChangeRepository, "emailChangeRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new AccountEmailEnterInteractorImpl(emailChangeRepository, serverTimeRepository);
    }

    public final Fragment provideEnterEmailFragment(AccountEmailEnterInteractor interactor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, Lazy<RemoteConfig> lazyRemoteConfig, Lazy<Config> lazyConfig) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(lazyRemoteConfig, "lazyRemoteConfig");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        return new EmailEnterFragment(new EmailEnterViewModelFactory(interactor, null), resultData, lazyRemoteConfig.getValue(), lazyConfig.getValue(), router, processMapper, resourceMapper);
    }
}
