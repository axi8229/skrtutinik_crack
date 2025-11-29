package ru.yoomoney.sdk.auth.api.login.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.login.LoginEnterFragment;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.login.impl.LoginEnterAnalyticsLogger;
import ru.yoomoney.sdk.auth.api.login.impl.LoginEnterInteractor;
import ru.yoomoney.sdk.auth.api.login.impl.LoginEnterInteractorImpl;
import ru.yoomoney.sdk.auth.api.login.impl.LoginEnterViewModelFactory;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007JH\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/di/LoginEnterModule;", "", "()V", "loginEnterInteractor", "Lru/yoomoney/sdk/auth/api/login/impl/LoginEnterInteractor;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "provideLoginEnterFragment", "Landroidx/fragment/app/Fragment;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoginEnterModule {
    public final LoginEnterInteractor loginEnterInteractor(LoginRepository loginRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new LoginEnterInteractorImpl(loginRepository, serverTimeRepository);
    }

    public final Fragment provideLoginEnterFragment(Lazy<Config> lazyConfig, LoginEnterInteractor loginEnterInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(loginEnterInteractor, "loginEnterInteractor");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        return new LoginEnterFragment(new LoginEnterViewModelFactory(loginEnterInteractor, analyticsLogger != null ? new LoginEnterAnalyticsLogger(analyticsLogger) : null), lazyConfig.getValue(), resultData, router, processMapper, resourceMapper);
    }
}
