package ru.yoomoney.sdk.auth.loading.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.loading.AuthLoadingFragment;
import ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractor;
import ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl;
import ru.yoomoney.sdk.auth.loading.impl.AuthLoadingViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007JL\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0012H\u0007¨\u0006#"}, d2 = {"Lru/yoomoney/sdk/auth/loading/di/AuthLoadingModule;", "", "()V", "authAuthLoadingInteractor", "Lru/yoomoney/sdk/auth/loading/impl/AuthLoadingInteractor;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "context", "Landroid/content/Context;", "providesAuthLoadingFragment", "Landroidx/fragment/app/Fragment;", "interactor", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "lazyRemoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthLoadingModule {
    public final AuthLoadingInteractor authAuthLoadingInteractor(EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, LoginRepository loginRepository, MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository, YooProfiler profiler, Lazy<Config> lazyConfig, ResultData resultData, Context context) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(context, "context");
        return new AuthLoadingInteractorImpl(enrollmentRepository, registrationV2Repository, loginRepository, migrationRepository, serverTimeRepository, profiler, lazyConfig.getValue(), context, resultData);
    }

    public final Fragment providesAuthLoadingFragment(AuthLoadingInteractor interactor, ResultData resultData, Lazy<Config> lazyConfig, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<RemoteConfig> lazyRemoteConfig) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(lazyRemoteConfig, "lazyRemoteConfig");
        return new AuthLoadingFragment(new AuthLoadingViewModelFactory(interactor, lazyConfig.getValue()), lazyConfig.getValue(), resultData, lazyRemoteConfig.getValue(), router, processMapper, resourceMapper);
    }
}
