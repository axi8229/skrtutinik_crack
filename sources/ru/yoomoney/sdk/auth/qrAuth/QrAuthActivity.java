package ru.yoomoney.sdk.auth.qrAuth;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
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
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.Style;
import ru.yoomoney.sdk.auth.ThemeScheme;
import ru.yoomoney.sdk.auth.api.ApiClient;
import ru.yoomoney.sdk.auth.api.ApiClientUtilsKt;
import ru.yoomoney.sdk.auth.qrAuth.di.DaggerQrAuthActivityComponent;
import ru.yoomoney.sdk.auth.qrAuth.di.QrAuthActivityComponent;
import ru.yoomoney.sdk.auth.ui.ColorScheme;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/QrAuthActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "config", "Lru/yoomoney/sdk/auth/Config;", "getConfig", "()Lru/yoomoney/sdk/auth/Config;", "config$delegate", "Lkotlin/Lazy;", "initDaggerComponents", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthActivity extends AppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_CONFIG = "ru.yoomoney.sdk.auth.qrAuth.CONFIG";
    private static final String KEY_PROCESS_ID = "ru.yoomoney.sdk.auth.qrAuth.PROCESS_ID";

    /* renamed from: config$delegate, reason: from kotlin metadata */
    private final Lazy config = LazyKt.lazy(new a());

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/QrAuthActivity$Companion;", "", "()V", "KEY_CONFIG", "", "KEY_PROCESS_ID", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "config", "Lru/yoomoney/sdk/auth/Config;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent createIntent(Context context, Config config, String processId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(processId, "processId");
            Intent intent = new Intent(context, (Class<?>) QrAuthActivity.class);
            intent.putExtra(QrAuthActivity.KEY_CONFIG, config);
            intent.putExtra(QrAuthActivity.KEY_PROCESS_ID, processId);
            return intent;
        }
    }

    public static final class a extends Lambda implements Function0<Config> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Config invoke() {
            Parcelable parcelableExtra = QrAuthActivity.this.getIntent().getParcelableExtra(QrAuthActivity.KEY_CONFIG);
            if (parcelableExtra != null) {
                return (Config) parcelableExtra;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    private final Config getConfig() {
        return (Config) this.config.getValue();
    }

    private final void initDaggerComponents() {
        ApiClient apiClientCreateApiClient = ApiClientUtilsKt.createApiClient(this, getConfig().getApiHost(), getConfig().isDebugMode(), getConfig().getApplicationUserAgent());
        QrAuthActivityComponent.Builder builderContext = DaggerQrAuthActivityComponent.builder().context(this);
        String accessToken = getConfig().getAccessToken();
        if (accessToken == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        getSupportFragmentManager().setFragmentFactory(builderContext.accountToken(accessToken).signInApi(apiClientCreateApiClient.getSignInApi()).build().factory());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        ThemeScheme themeScheme;
        ThemeScheme themeScheme2;
        ThemeScheme themeScheme3;
        ThemeScheme themeScheme4;
        Integer themeRes;
        initDaggerComponents();
        Style style = getConfig().getStyle();
        setTheme((style == null || (themeScheme4 = style.getThemeScheme()) == null || (themeRes = themeScheme4.getThemeRes()) == null) ? R.style.Theme_Yoo : themeRes.intValue());
        super.onCreate(savedInstanceState);
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        Style style2 = getConfig().getStyle();
        Integer thirdAccentColor = null;
        Integer accentColor = (style2 == null || (themeScheme3 = style2.getThemeScheme()) == null) ? null : themeScheme3.getAccentColor();
        Style style3 = getConfig().getStyle();
        Integer secondaryAccentColor = (style3 == null || (themeScheme2 = style3.getThemeScheme()) == null) ? null : themeScheme2.getSecondaryAccentColor();
        Style style4 = getConfig().getStyle();
        if (style4 != null && (themeScheme = style4.getThemeScheme()) != null) {
            thirdAccentColor = themeScheme.getThirdAccentColor();
        }
        colorScheme.setAccentColor(accentColor, secondaryAccentColor, thirdAccentColor);
        setContentView(R.layout.activity_qr_auth);
        NavController navControllerFindNavController = ActivityKt.findNavController(this, R.id.nav_host_fragment);
        Bundle bundle = new Bundle();
        bundle.putString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, getIntent().getStringExtra(KEY_PROCESS_ID));
        bundle.putParcelable("config", getConfig());
        navControllerFindNavController.setGraph(R.navigation.qr_auth_nav_graph, bundle);
    }
}
