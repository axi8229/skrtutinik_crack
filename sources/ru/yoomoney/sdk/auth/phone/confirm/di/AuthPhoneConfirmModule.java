package ru.yoomoney.sdk.auth.phone.confirm.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment;
import ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractor;
import ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractorImpl;
import ru.yoomoney.sdk.auth.phone.confirm.impl.PhoneConfirmAnalyticsLogger;
import ru.yoomoney.sdk.auth.phone.confirm.impl.PhoneConfirmViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007JP\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/di/AuthPhoneConfirmModule;", "", "()V", "authPhoneConfirmInteractor", "Lru/yoomoney/sdk/auth/phone/confirm/impl/AuthPhoneConfirmInteractor;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "providePhoneConfirmFragment", "Landroidx/fragment/app/Fragment;", "interactor", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthPhoneConfirmModule {
    public final AuthPhoneConfirmInteractor authPhoneConfirmInteractor(EnrollmentRepository enrollmentRepository, LoginRepository loginRepository, MigrationRepository migrationRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new AuthPhoneConfirmInteractorImpl(enrollmentRepository, loginRepository, migrationRepository, passwordRecoveryRepository, serverTimeRepository);
    }

    public final Fragment providePhoneConfirmFragment(AuthPhoneConfirmInteractor interactor, Lazy<Config> lazyConfig, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, ServerTimeRepository serverTimeRepository, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new PhoneConfirmFragment(new PhoneConfirmViewModelFactory(interactor, analyticsLogger != null ? new PhoneConfirmAnalyticsLogger(analyticsLogger) : null), lazyConfig, resultData, router, processMapper, resourceMapper, serverTimeRepository);
    }
}
