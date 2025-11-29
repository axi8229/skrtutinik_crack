package ru.yoomoney.sdk.auth.password.enter.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ConfigKt;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment;
import ru.yoomoney.sdk.auth.password.enter.impl.AuthPasswordEnterInteractor;
import ru.yoomoney.sdk.auth.password.enter.impl.AuthPasswordEnterInteractorImpl;
import ru.yoomoney.sdk.auth.password.enter.impl.PasswordEnterAnalyticsLogger;
import ru.yoomoney.sdk.auth.password.enter.impl.PasswordEnterViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007JH\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/password/enter/di/AuthPasswordEnterModule;", "", "()V", "authPasswordEnterInteractor", "Lru/yoomoney/sdk/auth/password/enter/impl/AuthPasswordEnterInteractor;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "providePasswordEnterFragment", "Landroidx/fragment/app/Fragment;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "interactor", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthPasswordEnterModule {
    public final AuthPasswordEnterInteractor authPasswordEnterInteractor(LoginRepository loginRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository, YooProfiler profiler, Lazy<Config> lazyConfig) {
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        return new AuthPasswordEnterInteractorImpl(loginRepository, passwordRecoveryRepository, serverTimeRepository, ConfigKt.toApiOrigin(lazyConfig.getValue().getOrigin()), profiler);
    }

    public final Fragment providePasswordEnterFragment(Router router, ProcessMapper processMapper, Lazy<Config> lazyConfig, ResultData resultData, AuthPasswordEnterInteractor interactor, ResourceMapper resourceMapper, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        return new PasswordEnterFragment(new PasswordEnterViewModelFactory(interactor, analyticsLogger != null ? new PasswordEnterAnalyticsLogger(analyticsLogger) : null), lazyConfig.getValue(), resultData, router, processMapper, resourceMapper);
    }
}
