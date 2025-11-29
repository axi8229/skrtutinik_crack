package ru.yoomoney.sdk.auth.oauth.notFound.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ConfigKt;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFoundFragment;
import ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractor;
import ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundInteractorImpl;
import ru.yoomoney.sdk.auth.oauth.notFound.impl.OauthNotFoundViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0007JF\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0007¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/oauth/notFound/di/OauthNotFoundModule;", "", "()V", "provideOauthNotFoundFragment", "Landroidx/fragment/app/Fragment;", "interactor", "Lru/yoomoney/sdk/auth/oauth/notFound/impl/OauthNotFoundInteractor;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "lazyRemoteConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/RemoteConfig;", "lazyConfig", "Lru/yoomoney/sdk/auth/Config;", "provideOauthNotFoundInteractor", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthNotFoundModule {
    public final Fragment provideOauthNotFoundFragment(OauthNotFoundInteractor interactor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<RemoteConfig> lazyRemoteConfig, Lazy<Config> lazyConfig) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(lazyRemoteConfig, "lazyRemoteConfig");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        return new OauthNotFoundFragment(lazyRemoteConfig.getValue(), new OauthNotFoundViewModelFactory(interactor, lazyConfig.getValue()), router, processMapper, resourceMapper);
    }

    public final OauthNotFoundInteractor provideOauthNotFoundInteractor(EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, LoginRepository loginRepository, ServerTimeRepository serverTimeRepository, YooProfiler profiler, ResultData resultData, Lazy<Config> lazyConfig) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        return new OauthNotFoundInteractorImpl(enrollmentRepository, registrationV2Repository, loginRepository, serverTimeRepository, profiler, resultData, ConfigKt.toApiOrigin(lazyConfig.getValue().getOrigin()));
    }
}
