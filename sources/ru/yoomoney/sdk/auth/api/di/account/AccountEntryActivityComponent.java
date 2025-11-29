package ru.yoomoney.sdk.auth.api.di.account;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Lazy;
import kotlin.Metadata;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.account.AccountApi;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeApi;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeApi;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeApi;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountApi;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentApi;
import ru.yoomoney.sdk.auth.api.login.LoginApi;
import ru.yoomoney.sdk.auth.api.migration.MigrationApi;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryApi;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.events.BusinessLogicEventSubscriber;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/di/account/AccountEntryActivityComponent;", "", "factory", "Lru/yoomoney/sdk/auth/api/di/ActivityFragmentFactory;", "Builder", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AccountEntryActivityComponent {

    @Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H'J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0012\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bH'J\b\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH'J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0016\u0010\u0011\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H'J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H'J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0018H'J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u001aH'J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cH'J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eH'J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020 H'J\u0010\u0010!\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\"H'J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020$H'J\u0010\u0010%\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020&H'J\u0010\u0010'\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020(H'J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H'J\u0016\u0010+\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020,0\u0013H'J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.H'J\u0010\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u000201H'J\u0010\u00102\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u000203H'¨\u00064"}, d2 = {"Lru/yoomoney/sdk/auth/api/di/account/AccountEntryActivityComponent$Builder;", "", "accountApi", "api", "Lru/yoomoney/sdk/auth/api/account/AccountApi;", "accountToken", "", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lru/yoomoney/sdk/auth/api/di/account/AccountEntryActivityComponent;", "businessLogicEventSubscriber", "eventSender", "Lru/yoomoney/sdk/auth/events/BusinessLogicEventSubscriber;", "clientIdContainer", "clientAppParams", "Lru/yoomoney/sdk/auth/api/ClientAppParams;", "config", "params", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "context", "Landroid/content/Context;", "emailChangeApi", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeApi;", "enrollmentApi", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentApi;", "isDebugMode", "", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "loginApi", "Lru/yoomoney/sdk/auth/api/login/LoginApi;", "migrationApi", "Lru/yoomoney/sdk/auth/api/migration/MigrationApi;", "passwordChangeApi", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeApi;", "passwordRecoveryApi", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryApi;", "phoneChangeApi", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeApi;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "serverTimeRepository", "repository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "socialAccountApi", "Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountApi;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        Builder accountApi(AccountApi api);

        Builder accountToken(String accountToken);

        Builder analyticsLogger(AnalyticsLogger analyticsLogger);

        AccountEntryActivityComponent build();

        Builder businessLogicEventSubscriber(BusinessLogicEventSubscriber eventSender);

        Builder clientIdContainer(ClientAppParams clientAppParams);

        Builder config(Lazy<Config> params);

        Builder context(Context context);

        Builder emailChangeApi(EmailChangeApi api);

        Builder enrollmentApi(EnrollmentApi api);

        Builder isDebugMode(boolean isDebugMode);

        Builder locationHeaderManager(LocationHeaderManager locationHeaderManager);

        Builder loginApi(LoginApi api);

        Builder migrationApi(MigrationApi api);

        Builder passwordChangeApi(PasswordChangeApi api);

        Builder passwordRecoveryApi(PasswordRecoveryApi api);

        Builder phoneChangeApi(PhoneChangeApi api);

        Builder profiler(YooProfiler profiler);

        Builder remoteConfig(Lazy<RemoteConfig> params);

        Builder resultData(ResultData resultData);

        Builder serverTimeRepository(ServerTimeRepository repository);

        Builder socialAccountApi(SocialAccountApi api);
    }

    ActivityFragmentFactory factory();
}
