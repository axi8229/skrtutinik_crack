package ru.yoomoney.sdk.auth.api;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.yoomoney.sdk.auth.api.account.AccountApi;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeApi;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeApi;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeApi;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountApi;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationApi;
import ru.yoomoney.sdk.auth.api.core.CoreApi;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthApi;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentApi;
import ru.yoomoney.sdk.auth.api.login.LoginApi;
import ru.yoomoney.sdk.auth.api.migration.MigrationApi;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryApi;
import ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketApi;
import ru.yoomoney.sdk.auth.api.signIn.SignInApi;
import ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationApi;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020)R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lru/yoomoney/sdk/auth/api/ApiClient;", "", "httpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "", "gson", "Lcom/google/gson/Gson;", "(Lokhttp3/OkHttpClient;Ljava/lang/String;Lcom/google/gson/Gson;)V", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getAccountApi", "Lru/yoomoney/sdk/auth/api/account/AccountApi;", "getAuxAuthorizationApi", "Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationApi;", "getCoreApi", "Lru/yoomoney/sdk/auth/api/core/CoreApi;", "getCryptogramAuthApi", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/CryptogramAuthApi;", "getEmailChangeApi", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeApi;", "getEnrollmentApi", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentApi;", "getLoginApi", "Lru/yoomoney/sdk/auth/api/login/LoginApi;", "getMigrationApi", "Lru/yoomoney/sdk/auth/api/migration/MigrationApi;", "getPasswordChangeApi", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeApi;", "getPasswordRecoveryApi", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryApi;", "getPhoneChangeApi", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeApi;", "getSessionTicketApi", "Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketApi;", "getSignInApi", "Lru/yoomoney/sdk/auth/api/signIn/SignInApi;", "getSocialAccountApi", "Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountApi;", "getWebAuthorizationApi", "Lru/yoomoney/sdk/auth/api/webAuthorization/WebAuthorizationApi;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApiClient {
    private final Retrofit retrofit;

    public ApiClient(OkHttpClient httpClient, String baseUrl, Gson gson) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.retrofit = new Retrofit.Builder().baseUrl(baseUrl + "/api/yooid/v1/").addConverterFactory(GsonConverterFactory.create(gson)).addConverterFactory(new EnumRetrofitConverterFactory()).client(httpClient).build();
    }

    public final AccountApi getAccountApi() throws SecurityException {
        Object objCreate = this.retrofit.create(AccountApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (AccountApi) objCreate;
    }

    public final AuxAuthorizationApi getAuxAuthorizationApi() throws SecurityException {
        Object objCreate = this.retrofit.create(AuxAuthorizationApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (AuxAuthorizationApi) objCreate;
    }

    public final CoreApi getCoreApi() throws SecurityException {
        Object objCreate = this.retrofit.create(CoreApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (CoreApi) objCreate;
    }

    public final CryptogramAuthApi getCryptogramAuthApi() throws SecurityException {
        Object objCreate = this.retrofit.create(CryptogramAuthApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (CryptogramAuthApi) objCreate;
    }

    public final EmailChangeApi getEmailChangeApi() throws SecurityException {
        Object objCreate = this.retrofit.create(EmailChangeApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (EmailChangeApi) objCreate;
    }

    public final EnrollmentApi getEnrollmentApi() throws SecurityException {
        Object objCreate = this.retrofit.create(EnrollmentApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (EnrollmentApi) objCreate;
    }

    public final LoginApi getLoginApi() throws SecurityException {
        Object objCreate = this.retrofit.create(LoginApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (LoginApi) objCreate;
    }

    public final MigrationApi getMigrationApi() throws SecurityException {
        Object objCreate = this.retrofit.create(MigrationApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (MigrationApi) objCreate;
    }

    public final PasswordChangeApi getPasswordChangeApi() throws SecurityException {
        Object objCreate = this.retrofit.create(PasswordChangeApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (PasswordChangeApi) objCreate;
    }

    public final PasswordRecoveryApi getPasswordRecoveryApi() throws SecurityException {
        Object objCreate = this.retrofit.create(PasswordRecoveryApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (PasswordRecoveryApi) objCreate;
    }

    public final PhoneChangeApi getPhoneChangeApi() throws SecurityException {
        Object objCreate = this.retrofit.create(PhoneChangeApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (PhoneChangeApi) objCreate;
    }

    public final SessionTicketApi getSessionTicketApi() throws SecurityException {
        Object objCreate = this.retrofit.create(SessionTicketApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (SessionTicketApi) objCreate;
    }

    public final SignInApi getSignInApi() throws SecurityException {
        Object objCreate = this.retrofit.create(SignInApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (SignInApi) objCreate;
    }

    public final SocialAccountApi getSocialAccountApi() throws SecurityException {
        Object objCreate = this.retrofit.create(SocialAccountApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (SocialAccountApi) objCreate;
    }

    public final WebAuthorizationApi getWebAuthorizationApi() throws SecurityException {
        Object objCreate = this.retrofit.create(WebAuthorizationApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (WebAuthorizationApi) objCreate;
    }
}
