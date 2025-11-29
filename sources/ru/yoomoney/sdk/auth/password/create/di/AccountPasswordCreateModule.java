package ru.yoomoney.sdk.auth.password.create.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment;
import ru.yoomoney.sdk.auth.password.create.impl.AccountPasswordCreateInteractor;
import ru.yoomoney.sdk.auth.password.create.impl.AccountPasswordCreateInteractorImpl;
import ru.yoomoney.sdk.auth.password.create.impl.PasswordCreateAnalyticsLogger;
import ru.yoomoney.sdk.auth.password.create.impl.PasswordCreateViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007JN\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/di/AccountPasswordCreateModule;", "", "()V", "accountPasswordCreateInteractor", "Lru/yoomoney/sdk/auth/password/create/impl/AccountPasswordCreateInteractor;", "passwordChangeRepository", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "providePasswordCreateFragment", "Landroidx/fragment/app/Fragment;", "interactor", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "lazyRemoteConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/RemoteConfig;", "lazyConfig", "Lru/yoomoney/sdk/auth/Config;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountPasswordCreateModule {
    public final AccountPasswordCreateInteractor accountPasswordCreateInteractor(PasswordChangeRepository passwordChangeRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(passwordChangeRepository, "passwordChangeRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new AccountPasswordCreateInteractorImpl(passwordChangeRepository, passwordRecoveryRepository, serverTimeRepository);
    }

    public final Fragment providePasswordCreateFragment(AccountPasswordCreateInteractor interactor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<RemoteConfig> lazyRemoteConfig, Lazy<Config> lazyConfig, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(lazyRemoteConfig, "lazyRemoteConfig");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        return new PasswordCreateFragment(lazyRemoteConfig.getValue(), new PasswordCreateViewModelFactory(interactor, analyticsLogger != null ? new PasswordCreateAnalyticsLogger(analyticsLogger, Reflection.getOrCreateKotlinClass(router.getClass())) : null), lazyConfig.getValue(), router, processMapper, resourceMapper);
    }
}
