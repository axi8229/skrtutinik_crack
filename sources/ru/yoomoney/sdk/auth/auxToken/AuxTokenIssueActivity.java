package ru.yoomoney.sdk.auth.auxToken;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ThemeScheme;
import ru.yoomoney.sdk.auth.api.ApiClient;
import ru.yoomoney.sdk.auth.api.ApiClientUtilsKt;
import ru.yoomoney.sdk.auth.auxToken.di.DaggerAuxTokenIssueActivityComponent;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.ui.ColorScheme;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssueActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "initDaggerComponents", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuxTokenIssueActivity extends AppCompatActivity {
    private static final String APPLICATION_USER_AGENT_KEY = "ru.yoomoney.sdk.auth.auxToken.APPLICATION_USER_AGENT";
    private static final String AUTH_CENTER_CLIENT_ID_KEY = "ru.yoomoney.sdk.auth.auxToken.AUTH_CENTER_CLIENT_ID";
    private static final String BASE_IS_DEBUG_MODE = "ru.yoomoney.sdk.auth.auxToken.IS_DEBUG_MODE";
    private static final String BASE_URL_KEY = "ru.yoomoney.sdk.auth.auxToken.BASE_URL";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SCOPES_KEY = "ru.yoomoney.sdk.auth.auxToken.SCOPES";
    private static final String THEME_SCHEME_KEY = "ru.yoomoney.sdk.auth.auxToken.THEME_SCHEME";
    private static final String TOKEN_KEY = "ru.yoomoney.sdk.auth.auxToken.TOKEN";

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JZ\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssueActivity$Companion;", "", "()V", "APPLICATION_USER_AGENT_KEY", "", "AUTH_CENTER_CLIENT_ID_KEY", "BASE_IS_DEBUG_MODE", "BASE_URL_KEY", "SCOPES_KEY", "THEME_SCHEME_KEY", "TOKEN_KEY", "create", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "token", "scopes", "", "authCenterClientId", "themeScheme", "Lru/yoomoney/sdk/auth/ThemeScheme;", "baseUrl", "isDebugMode", "", QrAuthDeclineWorkerKt.KEY_APPLICATION_USER_AGENT, "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent create(Context context, String token, List<String> scopes, String authCenterClientId, ThemeScheme themeScheme, String baseUrl, boolean isDebugMode, String applicationUserAgent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            Intrinsics.checkNotNullParameter(authCenterClientId, "authCenterClientId");
            Intent intent = new Intent(context, (Class<?>) AuxTokenIssueActivity.class);
            intent.putExtra(AuxTokenIssueActivity.TOKEN_KEY, token);
            intent.putExtra(AuxTokenIssueActivity.SCOPES_KEY, (String[]) scopes.toArray(new String[0]));
            intent.putExtra(AuxTokenIssueActivity.AUTH_CENTER_CLIENT_ID_KEY, authCenterClientId);
            intent.putExtra(AuxTokenIssueActivity.THEME_SCHEME_KEY, themeScheme);
            intent.putExtra(AuxTokenIssueActivity.BASE_URL_KEY, baseUrl);
            intent.putExtra(AuxTokenIssueActivity.BASE_IS_DEBUG_MODE, isDebugMode);
            intent.putExtra(AuxTokenIssueActivity.APPLICATION_USER_AGENT_KEY, applicationUserAgent);
            return intent;
        }
    }

    private final void initDaggerComponents() {
        String stringExtra = getIntent().getStringExtra(BASE_URL_KEY);
        if (stringExtra == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "requireNotNull(...)");
        ApiClient apiClientCreateApiClient = ApiClientUtilsKt.createApiClient(this, stringExtra, getIntent().getBooleanExtra(BASE_IS_DEBUG_MODE, false), getIntent().getStringExtra(APPLICATION_USER_AGENT_KEY));
        getSupportFragmentManager().setFragmentFactory(DaggerAuxTokenIssueActivityComponent.builder().context(this).auxAuthorizationApi(apiClientCreateApiClient.getAuxAuthorizationApi()).accountApi(apiClientCreateApiClient.getAccountApi()).build().factory());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        Integer themeRes;
        initDaggerComponents();
        ThemeScheme themeScheme = (ThemeScheme) getIntent().getParcelableExtra(THEME_SCHEME_KEY);
        setTheme((themeScheme == null || (themeRes = themeScheme.getThemeRes()) == null) ? R.style.Theme_Yoo : themeRes.intValue());
        super.onCreate(savedInstanceState);
        ColorScheme.INSTANCE.setAccentColor(themeScheme != null ? themeScheme.getAccentColor() : null, themeScheme != null ? themeScheme.getSecondaryAccentColor() : null, themeScheme != null ? themeScheme.getThirdAccentColor() : null);
        setContentView(R.layout.activity_aux_token_issue);
        String stringExtra = getIntent().getStringExtra(TOKEN_KEY);
        if (stringExtra == null) {
            finish();
            return;
        }
        NavController navControllerFindNavController = ActivityKt.findNavController(this, R.id.nav_host_fragment);
        Bundle bundle = new Bundle();
        bundle.putString("token", stringExtra);
        bundle.putStringArray("scopes", getIntent().getStringArrayExtra(SCOPES_KEY));
        bundle.putString("authCenterClientId", getIntent().getStringExtra(AUTH_CENTER_CLIENT_ID_KEY));
        navControllerFindNavController.setGraph(R.navigation.aux_token_nav_graph, bundle);
    }
}
