package ru.yoomoney.sdk.auth.finishing.success.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccessFragment;
import ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingAnalyticsLogger;
import ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractor;
import ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractorImpl;
import ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J2\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/di/AuthFinishingSuccessModule;", "", "()V", "authFinishingSuccessInteractor", "Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingSuccessInteractor;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "accountRepository", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "config", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "providesAuthLoadingFragment", "Landroidx/fragment/app/Fragment;", "interactor", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthFinishingSuccessModule {
    public final AuthFinishingSuccessInteractor authFinishingSuccessInteractor(EnrollmentRepository enrollmentRepository, LoginRepository loginRepository, RegistrationV2Repository registrationV2Repository, MigrationRepository migrationRepository, AccountRepository accountRepository, Lazy<Config> config, ResultData resultData) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(accountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        return new AuthFinishingSuccessInteractorImpl(enrollmentRepository, loginRepository, registrationV2Repository, migrationRepository, accountRepository, config.getValue(), resultData);
    }

    public final Fragment providesAuthLoadingFragment(AuthFinishingSuccessInteractor interactor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        return new AuthFinishingSuccessFragment(new AuthFinishingSuccessViewModelFactory(interactor, analyticsLogger != null ? new AuthFinishingAnalyticsLogger(analyticsLogger) : null), router, processMapper, resourceMapper);
    }
}
