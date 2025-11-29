package ru.yoomoney.sdk.auth.api.di;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.TokenUtils;
import ru.yoomoney.sdk.auth.api.account.AccountApi;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl;
import ru.yoomoney.sdk.auth.api.crypt.ApiKeyProviderImpl;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentApi;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepositoryImpl;
import ru.yoomoney.sdk.auth.api.login.LoginApi;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepositoryImpl;
import ru.yoomoney.sdk.auth.api.migration.MigrationApi;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepositoryImpl;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryApi;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepositoryImpl;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2RepositoryImpl;
import ru.yoomoney.sdk.auth.api.registrationV2.api.RegistrationV2Api;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J0\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J0\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/api/di/AccountApiModule;", "", "()V", "accountRepository", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "api", "Lru/yoomoney/sdk/auth/api/account/AccountApi;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentApi;", "clientAppParams", "Lru/yoomoney/sdk/auth/api/ClientAppParams;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "isDebugMode", "", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "Lru/yoomoney/sdk/auth/api/login/LoginApi;", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "Lru/yoomoney/sdk/auth/api/migration/MigrationApi;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryApi;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/RegistrationV2Api;", "config", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountApiModule {

    public static final class a extends Lambda implements Function0<String> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ClientAppParams b;
        public final /* synthetic */ ServerTimeRepository c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository) {
            super(0);
            this.a = z;
            this.b = clientAppParams;
            this.c = serverTimeRepository;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return TokenUtils.INSTANCE.generateTokenHeader(new ApiKeyProviderImpl(this.a), this.b, this.c);
        }
    }

    public static final class b extends Lambda implements Function0<String> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ClientAppParams b;
        public final /* synthetic */ ServerTimeRepository c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository) {
            super(0);
            this.a = z;
            this.b = clientAppParams;
            this.c = serverTimeRepository;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return TokenUtils.INSTANCE.generateTokenHeader(new ApiKeyProviderImpl(this.a), this.b, this.c);
        }
    }

    public static final class c extends Lambda implements Function0<String> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ClientAppParams b;
        public final /* synthetic */ ServerTimeRepository c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository) {
            super(0);
            this.a = z;
            this.b = clientAppParams;
            this.c = serverTimeRepository;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return TokenUtils.INSTANCE.generateTokenHeader(new ApiKeyProviderImpl(this.a), this.b, this.c);
        }
    }

    public static final class d extends Lambda implements Function0<String> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ClientAppParams b;
        public final /* synthetic */ ServerTimeRepository c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(boolean z, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository) {
            super(0);
            this.a = z;
            this.b = clientAppParams;
            this.c = serverTimeRepository;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return TokenUtils.INSTANCE.generateTokenHeader(new ApiKeyProviderImpl(this.a), this.b, this.c);
        }
    }

    public final AccountRepository accountRepository(AccountApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        return new AccountRepositoryImpl(api);
    }

    public final EnrollmentRepository enrollmentRepository(EnrollmentApi api, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository, boolean isDebugMode) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(clientAppParams, "clientAppParams");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new EnrollmentRepositoryImpl(api, new a(isDebugMode, clientAppParams, serverTimeRepository));
    }

    public final LoginRepository loginRepository(LoginApi api, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository, boolean isDebugMode, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(clientAppParams, "clientAppParams");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        return new LoginRepositoryImpl(api, new b(isDebugMode, clientAppParams, serverTimeRepository), locationHeaderManager);
    }

    public final MigrationRepository migrationRepository(MigrationApi api, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository, boolean isDebugMode, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(clientAppParams, "clientAppParams");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        return new MigrationRepositoryImpl(api, new c(isDebugMode, clientAppParams, serverTimeRepository), locationHeaderManager);
    }

    public final PasswordRecoveryRepository passwordRecoveryRepository(PasswordRecoveryApi api, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository, boolean isDebugMode, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(clientAppParams, "clientAppParams");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        return new PasswordRecoveryRepositoryImpl(api, new d(isDebugMode, clientAppParams, serverTimeRepository), locationHeaderManager);
    }

    public final RegistrationV2Repository registrationV2Repository(RegistrationV2Api api, Lazy<Config> config, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        String applicationUserAgent = config.getValue().getApplicationUserAgent();
        if (applicationUserAgent == null) {
            applicationUserAgent = "";
        }
        return new RegistrationV2RepositoryImpl(api, applicationUserAgent, locationHeaderManager);
    }
}
