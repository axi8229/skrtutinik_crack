package ru.yoomoney.sdk.auth;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.OauthResult;
import ru.yoomoney.sdk.auth.api.ApiClient;
import ru.yoomoney.sdk.auth.api.ApiClientUtilsKt;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl;
import ru.yoomoney.sdk.auth.api.crypt.ApiKeyProviderImpl;
import ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent;
import ru.yoomoney.sdk.auth.api.di.auth.DaggerAuthEntryActivityComponent;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepositoryImpl;
import ru.yoomoney.sdk.auth.date.DateTimeChangedBroadcastReceiver;
import ru.yoomoney.sdk.auth.location.di.LocationComponent;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;
import ru.yoomoney.sdk.auth.net.interceptor.AuthorizationInterceptor;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.yooprofiler.YooProfilerHelper;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\u0012\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u0018H\u0014J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0014J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020$H\u0014J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lru/yoomoney/sdk/auth/AuthEntryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", AuthEntryActivity.KEY_CONFIG, "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "dateTimeChangedBroadcastReceiver", "Lru/yoomoney/sdk/auth/date/DateTimeChangedBroadcastReceiver;", "getDateTimeChangedBroadcastReceiver", "()Lru/yoomoney/sdk/auth/date/DateTimeChangedBroadcastReceiver;", "dateTimeChangedBroadcastReceiver$delegate", "Lkotlin/Lazy;", "defaultRemoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "getDefaultRemoteConfig", "()Lru/yoomoney/sdk/auth/RemoteConfig;", "defaultRemoteConfig$delegate", AuthEntryActivity.KEY_RESULT_DATA, "Lru/yoomoney/sdk/auth/ResultData;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "serviceLocationIntent", "Landroid/content/Intent;", "finishWithResult", "", YooMoneyAuth.KEY_ACCESS_TOKEN, "", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", YooMoneyAuth.KEY_USER_HAS_MIGRATED, "", "finishWithResult$auth_release", "initDaggerComponents", "initDefaultFragmentData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRestoreInstanceState", "onSaveInstanceState", "outState", "prepareOathResult", "Lru/yoomoney/sdk/auth/OauthResult;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthEntryActivity extends AppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_CONFIG = "config";
    private static final String KEY_RESULT_DATA = "resultData";
    private ServerTimeRepository serverTimeRepository;
    private Intent serviceLocationIntent;

    /* renamed from: dateTimeChangedBroadcastReceiver$delegate, reason: from kotlin metadata */
    private final Lazy dateTimeChangedBroadcastReceiver = LazyKt.lazy(new b());
    private ResultData resultData = new ResultData(null, false, false, null, false, false, null, null, null, null, 1023, null);

    /* renamed from: defaultRemoteConfig$delegate, reason: from kotlin metadata */
    private final Lazy defaultRemoteConfig = LazyKt.lazy(new c());
    private final Lazy<Config> config = LazyKt.lazy(new a());

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/AuthEntryActivity$Companion;", "", "()V", "KEY_CONFIG", "", "KEY_RESULT_DATA", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", AuthEntryActivity.KEY_CONFIG, "Lru/yoomoney/sdk/auth/Config;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent createIntent(Context context, Config config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intent intentPutExtra = new Intent(context, (Class<?>) AuthEntryActivity.class).putExtra(AuthEntryActivity.KEY_CONFIG, config);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
            return intentPutExtra;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Config.ProcessType.values().length];
            try {
                iArr[Config.ProcessType.LOGIN_SBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Config.ProcessType.LOGIN_VK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Config.ProcessType.LOGIN_ESIA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final class a extends Lambda implements Function0<Config> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Config invoke() {
            Parcelable parcelableExtra = AuthEntryActivity.this.getIntent().getParcelableExtra(AuthEntryActivity.KEY_CONFIG);
            if (parcelableExtra != null) {
                return (Config) parcelableExtra;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public static final class b extends Lambda implements Function0<DateTimeChangedBroadcastReceiver> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final DateTimeChangedBroadcastReceiver invoke() {
            ServerTimeRepository serverTimeRepository = AuthEntryActivity.this.serverTimeRepository;
            if (serverTimeRepository == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverTimeRepository");
                serverTimeRepository = null;
            }
            return new DateTimeChangedBroadcastReceiver(serverTimeRepository);
        }
    }

    public static final class c extends Lambda implements Function0<RemoteConfig> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final RemoteConfig invoke() {
            String string = AuthEntryActivity.this.getString(R.string.auth_remote_config_offer_no_email, ConfigKt.getBaseHost());
            String string2 = AuthEntryActivity.this.getString(R.string.auth_remote_config_offer_has_email, ConfigKt.getBaseHost());
            String string3 = AuthEntryActivity.this.getString(R.string.auth_soft_migration_title);
            String string4 = AuthEntryActivity.this.getString(R.string.auth_soft_migration_subtitle);
            String string5 = AuthEntryActivity.this.getString(R.string.auth_soft_migration_action_subtitle, ConfigKt.getBaseHost());
            String string6 = AuthEntryActivity.this.getString(R.string.auth_hard_migration_title);
            String string7 = AuthEntryActivity.this.getString(R.string.auth_hard_migration_subtitle);
            String string8 = AuthEntryActivity.this.getString(R.string.auth_hard_migration_action_subtitle, ConfigKt.getBaseHost());
            String string9 = AuthEntryActivity.this.getString(R.string.auth_email_enter_legal_terms, ConfigKt.getBaseHost());
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(string2);
            return new RemoteConfig(true, string, string2, true, string9, null, string3, string4, string5, string6, string7, string8, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4064, 15, null);
        }
    }

    public static final class d extends Lambda implements Function0<RemoteConfig> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final RemoteConfig invoke() {
            RemoteConfig remoteConfig = ((Config) AuthEntryActivity.this.config.getValue()).getRemoteConfig();
            return remoteConfig == null ? AuthEntryActivity.this.getDefaultRemoteConfig() : remoteConfig;
        }
    }

    public static /* synthetic */ void finishWithResult$auth_release$default(AuthEntryActivity authEntryActivity, String str, UserAccount userAccount, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        authEntryActivity.finishWithResult$auth_release(str, userAccount, z);
    }

    private final DateTimeChangedBroadcastReceiver getDateTimeChangedBroadcastReceiver() {
        return (DateTimeChangedBroadcastReceiver) this.dateTimeChangedBroadcastReceiver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RemoteConfig getDefaultRemoteConfig() {
        return (RemoteConfig) this.defaultRemoteConfig.getValue();
    }

    private final void initDaggerComponents() {
        ApiClient apiClientCreateApiClient = ApiClientUtilsKt.createApiClient(this, this.config.getValue().getApiHost(), this.config.getValue().isDebugMode(), this.config.getValue().getApplicationUserAgent());
        this.serverTimeRepository = new ServerTimeRepositoryImpl(new CoreApiRepositoryImpl(apiClientCreateApiClient.getCoreApi()));
        ClientAppParams clientAppParams = new ClientAppParams(this.config.getValue().getAuthCenterClientId(), this.config.getValue().getAuthCenterClientSecret());
        String apiHost = this.config.getValue().getApiHost();
        boolean zIsDebugMode = this.config.getValue().isDebugMode();
        ApiKeyProviderImpl apiKeyProviderImpl = new ApiKeyProviderImpl(this.config.getValue().isDebugMode());
        ServerTimeRepository serverTimeRepository = this.serverTimeRepository;
        ServerTimeRepository serverTimeRepository2 = null;
        if (serverTimeRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverTimeRepository");
            serverTimeRepository = null;
        }
        AuthEntryActivityComponent.Builder builderPasswordRecoveryApi = DaggerAuthEntryActivityComponent.builder().context(this).config(this.config).resultData(this.resultData).remoteConfig(LazyKt.lazy(new d())).enrollmentApi(apiClientCreateApiClient.getEnrollmentApi()).registrationV2Api(ApiClientUtilsKt.createApiV2Client(this, apiHost, zIsDebugMode, new AuthorizationInterceptor(apiKeyProviderImpl, clientAppParams, serverTimeRepository)).getRegistrationV2Api()).oauthV2Api(ApiClientUtilsKt.createOauthV2ApiClient(this, this.config.getValue().getApiHost(), this.config.getValue().isDebugMode()).getOauthV2Api()).loginApi(apiClientCreateApiClient.getLoginApi()).migrationApi(apiClientCreateApiClient.getMigrationApi()).accountApi(apiClientCreateApiClient.getAccountApi()).passwordRecoveryApi(apiClientCreateApiClient.getPasswordRecoveryApi());
        YooMoneyAuth yooMoneyAuth = YooMoneyAuth.INSTANCE;
        AuthEntryActivityComponent.Builder builderClientIdContainer = builderPasswordRecoveryApi.businessLogicEventSubscriber(yooMoneyAuth.getBusinessLogicEventSubscriber()).clientIdContainer(clientAppParams);
        YooProfilerHelper yooProfilerHelper = YooProfilerHelper.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        AuthEntryActivityComponent.Builder builderProfiler = builderClientIdContainer.profiler(yooProfilerHelper.create(applicationContext));
        ServerTimeRepository serverTimeRepository3 = this.serverTimeRepository;
        if (serverTimeRepository3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverTimeRepository");
        } else {
            serverTimeRepository2 = serverTimeRepository3;
        }
        getSupportFragmentManager().setFragmentFactory(builderProfiler.serverTimeRepository(serverTimeRepository2).analyticsLogger(yooMoneyAuth.getAnalyticsLogger$auth_release()).isDebugMode(this.config.getValue().isDebugMode()).locationHeaderManager(LocationComponent.INSTANCE.initAndGet(this).locationHeaderManager()).build().factory());
    }

    private final void initDefaultFragmentData() throws Resources.NotFoundException {
        NavController navControllerFindNavController = ActivityKt.findNavController(this, R.id.nav_host_fragment);
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_CONFIG, this.config.getValue());
        navControllerFindNavController.setGraph(R.navigation.auth_nav_graph, bundle);
    }

    private final OauthResult prepareOathResult() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.config.getValue().getProcessType().ordinal()];
        OauthServiceProvider oauthServiceProvider = i != 1 ? i != 2 ? i != 3 ? null : OauthServiceProvider.ESIA : OauthServiceProvider.VK : OauthServiceProvider.SBER;
        if (oauthServiceProvider == null || this.resultData.getOauthLinkStatus() == null) {
            return null;
        }
        OauthResult.OauthLinkStatus oauthLinkStatus = this.resultData.getOauthLinkStatus();
        if (oauthLinkStatus != null) {
            return new OauthResult(oauthServiceProvider, oauthLinkStatus);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final void finishWithResult$auth_release(String accessToken, UserAccount account, boolean userHasMigrated) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(account, "account");
        setResult(-1, new Intent().putExtra(YooMoneyAuth.KEY_ACCESS_TOKEN, accessToken).putExtra(YooMoneyAuth.KEY_USER_ACCOUNT, account).putExtra(YooMoneyAuth.KEY_TMX_SESSION_ID, this.resultData.getTmxSessionId()).putExtra(YooMoneyAuth.KEY_MARKETING_NEWS_LETTER_BY_EMAIL_ACCEPTED, this.resultData.getMarketingNewsLetterByEmailAccepted()).putExtra(YooMoneyAuth.KEY_MARKETING_NEWS_LETTER_BY_PHONE_ACCEPTED, this.resultData.getMarketingNewsLetterByPhoneAccepted()).putExtra(YooMoneyAuth.KEY_USER_HAS_MIGRATED, userHasMigrated).putExtra(YooMoneyAuth.KEY_OAUTH_RESULT, prepareOathResult()).putExtra(YooMoneyAuth.KEY_IDENTIFICATION_ACCESSIBLE, this.resultData.getIdentificationAccessible()));
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        ThemeScheme themeScheme;
        ThemeScheme themeScheme2;
        ThemeScheme themeScheme3;
        ThemeScheme themeScheme4;
        Integer themeRes;
        initDaggerComponents();
        Style style = this.config.getValue().getStyle();
        setTheme((style == null || (themeScheme4 = style.getThemeScheme()) == null || (themeRes = themeScheme4.getThemeRes()) == null) ? R.style.Theme_Yoo : themeRes.intValue());
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        Style style2 = this.config.getValue().getStyle();
        Integer thirdAccentColor = null;
        Integer accentColor = (style2 == null || (themeScheme3 = style2.getThemeScheme()) == null) ? null : themeScheme3.getAccentColor();
        Style style3 = this.config.getValue().getStyle();
        Integer secondaryAccentColor = (style3 == null || (themeScheme2 = style3.getThemeScheme()) == null) ? null : themeScheme2.getSecondaryAccentColor();
        Style style4 = this.config.getValue().getStyle();
        if (style4 != null && (themeScheme = style4.getThemeScheme()) != null) {
            thirdAccentColor = themeScheme.getThirdAccentColor();
        }
        colorScheme.setAccentColor(accentColor, secondaryAccentColor, thirdAccentColor);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_entry);
        initDefaultFragmentData();
        ContextCompat.registerReceiver(getBaseContext(), getDateTimeChangedBroadcastReceiver(), DateTimeChangedBroadcastReceiver.INSTANCE.createIntentFilter(), 2);
        if (this.config.getValue().getProductType() == Config.ProductType.DEFAULT) {
            this.serviceLocationIntent = UtilsKt.startLocationService(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        unregisterReceiver(getDateTimeChangedBroadcastReceiver());
        Intent intent = this.serviceLocationIntent;
        if (intent != null) {
            stopService(intent);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        ResultData resultData = (ResultData) savedInstanceState.getParcelable(KEY_RESULT_DATA);
        if (resultData == null) {
            resultData = new ResultData(null, false, false, null, false, false, null, null, null, null, 1023, null);
        }
        this.resultData = resultData;
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_RESULT_DATA, this.resultData);
    }
}
