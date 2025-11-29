package ru.yoomoney.sdk.auth.password.enter.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ConfigKt;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment;
import ru.yoomoney.sdk.auth.password.enter.impl.AccountPasswordEnterInteractor;
import ru.yoomoney.sdk.auth.password.enter.impl.AccountPasswordEnterInteractorImpl;
import ru.yoomoney.sdk.auth.password.enter.impl.PasswordEnterAnalyticsLogger;
import ru.yoomoney.sdk.auth.password.enter.impl.PasswordEnterViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007JH\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/password/enter/di/AccountPasswordEnterModule;", "", "()V", "accountPasswordEnterInteractor", "Lru/yoomoney/sdk/auth/password/enter/impl/AccountPasswordEnterInteractor;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "emailChangeRepository", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "passwordChangeRepository", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "providePasswordEnterFragment", "Landroidx/fragment/app/Fragment;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "interactor", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountPasswordEnterModule {
    public final AccountPasswordEnterInteractor accountPasswordEnterInteractor(PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository, EmailChangeRepository emailChangeRepository, PasswordChangeRepository passwordChangeRepository, YooProfiler profiler, Lazy<Config> lazyConfig) {
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(emailChangeRepository, "emailChangeRepository");
        Intrinsics.checkNotNullParameter(passwordChangeRepository, "passwordChangeRepository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        return new AccountPasswordEnterInteractorImpl(emailChangeRepository, passwordChangeRepository, passwordRecoveryRepository, serverTimeRepository, ConfigKt.toApiOrigin(lazyConfig.getValue().getOrigin()), profiler);
    }

    public final Fragment providePasswordEnterFragment(Router router, ProcessMapper processMapper, Lazy<Config> lazyConfig, ResultData resultData, AccountPasswordEnterInteractor interactor, ResourceMapper resourceMapper, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        return new PasswordEnterFragment(new PasswordEnterViewModelFactory(interactor, analyticsLogger != null ? new PasswordEnterAnalyticsLogger(analyticsLogger) : null), lazyConfig.getValue(), resultData, router, processMapper, resourceMapper);
    }
}
