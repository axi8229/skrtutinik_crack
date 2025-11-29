package ru.yoomoney.sdk.auth;

import android.content.Context;
import android.content.Intent;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.google.android.gms.common.Scopes;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.account.AccountRepositoryProvider;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepository;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepositoryProvider;
import ru.yoomoney.sdk.auth.api.core.CoreApiRepository;
import ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryProvider;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepository;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryProvider;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.oauth.OauthV2Repository;
import ru.yoomoney.sdk.auth.api.oauth.OauthV2RepositoryProvider;
import ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepository;
import ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryProvider;
import ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepository;
import ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryProvider;
import ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueActivity;
import ru.yoomoney.sdk.auth.events.BusinessLogicEventSubscriber;
import ru.yoomoney.sdk.auth.events.BusinessLogicEventSubscriberImpl;
import ru.yoomoney.sdk.auth.logout.LogoutWorker;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthActivity;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.transferData.TransferDataRepository;
import ru.yoomoney.sdk.auth.transferData.TransferDataRepositoryImpl;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&JZ\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040*2\u0006\u0010+\u001a\u00020\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0017J(\u00105\u001a\u0002032\u0006\u0010#\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u000200J;\u00106\u001a\b\u0012\u0004\u0012\u000203072\u0006\u0010#\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u000200ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109J\"\u0010:\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<J,\u0010=\u001a\u00020>2\u0006\u0010#\u001a\u00020$2\u0006\u0010?\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004J,\u0010@\u001a\u00020A2\u0006\u0010#\u001a\u00020$2\u0006\u0010?\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004J,\u0010B\u001a\u00020C2\u0006\u0010#\u001a\u00020$2\u0006\u0010?\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004J4\u0010D\u001a\u00020E2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004J0\u0010F\u001a\u00020G2\u0006\u0010#\u001a\u00020$2\u0006\u0010?\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u0002002\u000e\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040IJ4\u0010J\u001a\u00020K2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004J4\u0010L\u001a\u00020M2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004J,\u0010N\u001a\u00020O2\u0006\u0010#\u001a\u00020$2\u0006\u0010?\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004J\u001e\u0010P\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010Q\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006R"}, d2 = {"Lru/yoomoney/sdk/auth/YooMoneyAuth;", "", "()V", "KEY_ACCESS_TOKEN", "", "KEY_AUX_TOKEN", "KEY_CRYPTOGRAM", "KEY_FAILURE", "KEY_IDENTIFICATION_ACCESSIBLE", "KEY_MARKETING_NEWS_LETTER_BY_EMAIL_ACCEPTED", "KEY_MARKETING_NEWS_LETTER_BY_PHONE_ACCEPTED", "KEY_OAUTH_RESULT", "KEY_TMX_SESSION_ID", "KEY_USER_ACCOUNT", "KEY_USER_HAS_MIGRATED", "REQUEST_MONEY_AUTHORIZATION", "", "REQUEST_MSDK_AUTHORIZATION", "REQUEST_PROFILE_CHANGE", "REQUEST_QR_AUTHORIZATION", "RESPONSE_CODE_PASSWORD_CHANGE", "RESPONSE_CODE_RETRY_SCAN", "<set-?>", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "analyticsLogger", "getAnalyticsLogger$auth_release", "()Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "businessLogicEventSubscriber", "Lru/yoomoney/sdk/auth/events/BusinessLogicEventSubscriber;", "getBusinessLogicEventSubscriber", "()Lru/yoomoney/sdk/auth/events/BusinessLogicEventSubscriber;", "businessLogicEventSubscriber$delegate", "Lkotlin/Lazy;", "auth", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "config", "Lru/yoomoney/sdk/auth/Config;", YooMoneyAuth.KEY_AUX_TOKEN, "token", "scopes", "", "authCenterClientId", "themeScheme", "Lru/yoomoney/sdk/auth/ThemeScheme;", "baseUrl", "isDebugMode", "", QrAuthDeclineWorkerKt.KEY_APPLICATION_USER_AGENT, "initAnalyticsLogger", "", "eventListener", "logout", "logoutAllDevices", "Lkotlin/Result;", "logoutAllDevices-BWLJW6A", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;", Scopes.PROFILE, "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "provideAccountRepository", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "apiHost", "provideAuxAuthorizationRepository", "Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationRepository;", "provideCoreApiRepository", "Lru/yoomoney/sdk/auth/api/core/CoreApiRepository;", "provideCryptogramAuthRepository", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/CryptogramAuthRepository;", "provideOauthV2Repository", "Lru/yoomoney/sdk/auth/api/oauth/OauthV2Repository;", "getToken", "Lkotlin/Function0;", "provideSessionTicketRepository", "Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketRepository;", "provideTransferDataRepository", "Lru/yoomoney/sdk/auth/transferData/TransferDataRepository;", "provideWebAuthorizationRepository", "Lru/yoomoney/sdk/auth/api/webAuthorization/WebAuthorizationRepository;", "qrAuth", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class YooMoneyAuth {
    public static final String KEY_ACCESS_TOKEN = "accessToken";
    public static final String KEY_AUX_TOKEN = "auxToken";
    public static final String KEY_CRYPTOGRAM = "cryptogram";
    public static final String KEY_FAILURE = "failure";
    public static final String KEY_IDENTIFICATION_ACCESSIBLE = "identificationAccessible";
    public static final String KEY_MARKETING_NEWS_LETTER_BY_EMAIL_ACCEPTED = "marketingNewsletterByEmailAccepted";
    public static final String KEY_MARKETING_NEWS_LETTER_BY_PHONE_ACCEPTED = "marketingNewsletterByPhoneAccepted";
    public static final String KEY_OAUTH_RESULT = "oauthResult";
    public static final String KEY_TMX_SESSION_ID = "tmxSessionId";
    public static final String KEY_USER_ACCOUNT = "userAccount";
    public static final String KEY_USER_HAS_MIGRATED = "userHasMigrated";
    public static final int REQUEST_MONEY_AUTHORIZATION = 1;
    public static final int REQUEST_MSDK_AUTHORIZATION = 4;
    public static final int REQUEST_PROFILE_CHANGE = 2;
    public static final int REQUEST_QR_AUTHORIZATION = 3;
    public static final int RESPONSE_CODE_PASSWORD_CHANGE = 100;
    public static final int RESPONSE_CODE_RETRY_SCAN = 200;
    private static AnalyticsLogger analyticsLogger;
    public static final YooMoneyAuth INSTANCE = new YooMoneyAuth();

    /* renamed from: businessLogicEventSubscriber$delegate, reason: from kotlin metadata */
    private static final Lazy businessLogicEventSubscriber = LazyKt.lazy(a.a);

    public static final class a extends Lambda implements Function0<BusinessLogicEventSubscriberImpl> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final BusinessLogicEventSubscriberImpl invoke() {
            return new BusinessLogicEventSubscriberImpl();
        }
    }

    private YooMoneyAuth() {
    }

    public static /* synthetic */ void logout$default(YooMoneyAuth yooMoneyAuth, Context context, String str, String str2, boolean z, int i, Object obj) throws Throwable {
        if ((i & 8) != 0) {
            z = false;
        }
        yooMoneyAuth.logout(context, str, str2, z);
    }

    /* renamed from: logoutAllDevices-BWLJW6A$default, reason: not valid java name */
    public static /* synthetic */ Object m3206logoutAllDevicesBWLJW6A$default(YooMoneyAuth yooMoneyAuth, Context context, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return yooMoneyAuth.m3207logoutAllDevicesBWLJW6A(context, str, str2, z);
    }

    public static /* synthetic */ Intent profile$default(YooMoneyAuth yooMoneyAuth, Context context, Config config, UserAccount userAccount, int i, Object obj) {
        if ((i & 4) != 0) {
            userAccount = null;
        }
        return yooMoneyAuth.profile(context, config, userAccount);
    }

    public static /* synthetic */ AccountRepository provideAccountRepository$default(YooMoneyAuth yooMoneyAuth, Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return yooMoneyAuth.provideAccountRepository(context, str, z, str2);
    }

    public static /* synthetic */ AuxAuthorizationRepository provideAuxAuthorizationRepository$default(YooMoneyAuth yooMoneyAuth, Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return yooMoneyAuth.provideAuxAuthorizationRepository(context, str, z, str2);
    }

    public static /* synthetic */ CoreApiRepository provideCoreApiRepository$default(YooMoneyAuth yooMoneyAuth, Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return yooMoneyAuth.provideCoreApiRepository(context, str, z, str2);
    }

    public static /* synthetic */ CryptogramAuthRepository provideCryptogramAuthRepository$default(YooMoneyAuth yooMoneyAuth, Context context, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str3 = null;
        }
        return yooMoneyAuth.provideCryptogramAuthRepository(context, str, str2, z2, str3);
    }

    public static /* synthetic */ OauthV2Repository provideOauthV2Repository$default(YooMoneyAuth yooMoneyAuth, Context context, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return yooMoneyAuth.provideOauthV2Repository(context, str, z, function0);
    }

    public static /* synthetic */ SessionTicketRepository provideSessionTicketRepository$default(YooMoneyAuth yooMoneyAuth, Context context, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str3 = null;
        }
        return yooMoneyAuth.provideSessionTicketRepository(context, str, str2, z2, str3);
    }

    public static /* synthetic */ TransferDataRepository provideTransferDataRepository$default(YooMoneyAuth yooMoneyAuth, Context context, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str3 = null;
        }
        return yooMoneyAuth.provideTransferDataRepository(context, str, str2, z2, str3);
    }

    public static /* synthetic */ WebAuthorizationRepository provideWebAuthorizationRepository$default(YooMoneyAuth yooMoneyAuth, Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return yooMoneyAuth.provideWebAuthorizationRepository(context, str, z, str2);
    }

    public final Intent auth(Context context, Config config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        return AuthEntryActivity.INSTANCE.createIntent(context, config);
    }

    public final Intent auxToken(Context context, String token, List<String> scopes, String authCenterClientId, ThemeScheme themeScheme, String baseUrl, boolean isDebugMode, String applicationUserAgent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(authCenterClientId, "authCenterClientId");
        return AuxTokenIssueActivity.INSTANCE.create(context, token, scopes, authCenterClientId, themeScheme, baseUrl, isDebugMode, applicationUserAgent);
    }

    public final AnalyticsLogger getAnalyticsLogger$auth_release() {
        return analyticsLogger;
    }

    public final BusinessLogicEventSubscriber getBusinessLogicEventSubscriber() {
        return (BusinessLogicEventSubscriber) businessLogicEventSubscriber.getValue();
    }

    public final void initAnalyticsLogger(AnalyticsLogger eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        analyticsLogger = eventListener;
    }

    public final void logout(Context context, String token, String baseUrl, boolean isDebugMode) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Pair[] pairArr = {TuplesKt.to("logoutToken", token), TuplesKt.to("logoutBaseURL", baseUrl), TuplesKt.to("isDebugMode", Boolean.valueOf(isDebugMode))};
        Data.Builder builder = new Data.Builder();
        int i = 0;
        while (i < 3) {
            Pair pair = pairArr[i];
            i++;
            builder.put((String) pair.getFirst(), pair.getSecond());
        }
        Data dataBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(dataBuild, "dataBuilder.build()");
        OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(LogoutWorker.class).setInputData(dataBuild).build();
        Intrinsics.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "build(...)");
        WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuild);
    }

    /* renamed from: logoutAllDevices-BWLJW6A, reason: not valid java name */
    public final Object m3207logoutAllDevicesBWLJW6A(Context context, String token, String baseUrl, boolean isDebugMode) {
        Object objCreateFailure;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Object objMo3213revokeAllIoAF18A = provideAccountRepository$default(this, context, baseUrl, isDebugMode, null, 8, null).mo3213revokeAllIoAF18A(token);
        Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(objMo3213revokeAllIoAF18A);
        if (thM2631exceptionOrNullimpl == null) {
            objCreateFailure = (Unit) objMo3213revokeAllIoAF18A;
        } else {
            Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
            objCreateFailure = ResultKt.createFailure((Failure) thM2631exceptionOrNullimpl);
        }
        return Result.m2628constructorimpl(objCreateFailure);
    }

    public final Intent profile(Context context, Config config, UserAccount account) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        return AccountActivity.INSTANCE.createIntent(context, config, account);
    }

    public final AccountRepository provideAccountRepository(Context context, String apiHost, boolean isDebugMode, String applicationUserAgent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        return AccountRepositoryProvider.INSTANCE.create(context, apiHost, isDebugMode, applicationUserAgent);
    }

    public final AuxAuthorizationRepository provideAuxAuthorizationRepository(Context context, String apiHost, boolean isDebugMode, String applicationUserAgent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        return AuxAuthorizationRepositoryProvider.INSTANCE.create(context, apiHost, isDebugMode, applicationUserAgent);
    }

    public final CoreApiRepository provideCoreApiRepository(Context context, String apiHost, boolean isDebugMode, String applicationUserAgent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        return CoreApiRepositoryProvider.INSTANCE.create(context, apiHost, isDebugMode, applicationUserAgent);
    }

    public final CryptogramAuthRepository provideCryptogramAuthRepository(Context context, String authCenterClientId, String apiHost, boolean isDebugMode, String applicationUserAgent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authCenterClientId, "authCenterClientId");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        return CryptogramAuthRepositoryProvider.INSTANCE.create(context, new ClientAppParams(authCenterClientId, null, 2, null), apiHost, isDebugMode, applicationUserAgent);
    }

    public final OauthV2Repository provideOauthV2Repository(Context context, String apiHost, boolean isDebugMode, Function0<String> getToken) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        Intrinsics.checkNotNullParameter(getToken, "getToken");
        return OauthV2RepositoryProvider.INSTANCE.create(context, apiHost, isDebugMode, getToken);
    }

    public final SessionTicketRepository provideSessionTicketRepository(Context context, String authCenterClientId, String apiHost, boolean isDebugMode, String applicationUserAgent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authCenterClientId, "authCenterClientId");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        return SessionTicketRepositoryProvider.INSTANCE.create(context, new ClientAppParams(authCenterClientId, null, 2, null), apiHost, isDebugMode, applicationUserAgent);
    }

    public final TransferDataRepository provideTransferDataRepository(Context context, String authCenterClientId, String apiHost, boolean isDebugMode, String applicationUserAgent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authCenterClientId, "authCenterClientId");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        return new TransferDataRepositoryImpl(provideSessionTicketRepository(context, authCenterClientId, apiHost, isDebugMode, applicationUserAgent));
    }

    public final WebAuthorizationRepository provideWebAuthorizationRepository(Context context, String apiHost, boolean isDebugMode, String applicationUserAgent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        return WebAuthorizationRepositoryProvider.INSTANCE.create(context, apiHost, isDebugMode, applicationUserAgent);
    }

    public final Intent qrAuth(Context context, Config config, String processId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(processId, "processId");
        return QrAuthActivity.INSTANCE.createIntent(context, config, processId);
    }
}
