package ru.yoomoney.sdk.auth.email.enter.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment;
import ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractor;
import ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractorImpl;
import ru.yoomoney.sdk.auth.email.enter.impl.EmailEnterAnalyticsLogger;
import ru.yoomoney.sdk.auth.email.enter.impl.EmailEnterViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007JV\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019H\u0007¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/di/AuthEmailEnterModule;", "", "()V", "authEmailEnterInteractor", "Lru/yoomoney/sdk/auth/email/enter/impl/AuthEmailEnterInteractor;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "provideEnterEmailFragment", "Landroidx/fragment/app/Fragment;", "interactor", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "lazyRemoteConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/RemoteConfig;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "lazyConfig", "Lru/yoomoney/sdk/auth/Config;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthEmailEnterModule {
    public final AuthEmailEnterInteractor authEmailEnterInteractor(EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new AuthEmailEnterInteractorImpl(enrollmentRepository, registrationV2Repository, migrationRepository, serverTimeRepository);
    }

    public final Fragment provideEnterEmailFragment(AuthEmailEnterInteractor interactor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, Lazy<RemoteConfig> lazyRemoteConfig, AnalyticsLogger analyticsLogger, Lazy<Config> lazyConfig) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(lazyRemoteConfig, "lazyRemoteConfig");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        return new EmailEnterFragment(new EmailEnterViewModelFactory(interactor, analyticsLogger != null ? new EmailEnterAnalyticsLogger(analyticsLogger) : null), resultData, lazyRemoteConfig.getValue(), lazyConfig.getValue(), router, processMapper, resourceMapper);
    }
}
