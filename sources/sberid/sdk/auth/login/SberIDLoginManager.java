package sberid.sdk.auth.login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sberid.sdk.auth.R$string;
import sberid.sdk.auth.di.ComponentHolder;
import sberid.sdk.auth.model.SberIDResultModel;
import sberid.sdk.auth.model.StandName;
import sberid.sdk.auth.utils.DataUtilsKt;
import sberid.sdk.auth.utils.SberIDBrowserUtilsKt;
import sberid.sdk.auth.utils.UriUtilsKt;
import sberid.sdk.auth.view.activity.WebViewActivity;

/* compiled from: SberIDLoginManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\fJ\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u0005¨\u0006&"}, d2 = {"Lsberid/sdk/auth/login/SberIDLoginManager;", "", "Lsberid/sdk/auth/model/StandName;", "standName", "<init>", "(Lsberid/sdk/auth/model/StandName;)V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "runWebAuth", "(Landroid/content/Context;Landroid/net/Uri;)Z", "checkUri", "(Landroid/net/Uri;Landroid/content/Context;)Landroid/net/Uri;", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "isSuccess", "(Landroid/content/Intent;)Z", "", "state", "checkState", "(Ljava/lang/String;)Z", RemoteMessageConst.DATA, "getErrorText", "(Landroid/net/Uri;)Ljava/lang/String;", "loginWithSberbankID", "Lsberid/sdk/auth/model/SberIDResultModel;", "getSberIDAuthResult", "(Landroid/content/Intent;)Lsberid/sdk/auth/model/SberIDResultModel;", "stateApp", "Ljava/lang/String;", "nonceApp", "Lsberid/sdk/auth/model/StandName;", "getStandName", "()Lsberid/sdk/auth/model/StandName;", "setStandName", "Companion", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class SberIDLoginManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String nonceApp;
    private StandName standName;
    private String stateApp;

    public SberIDLoginManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public SberIDLoginManager(StandName standName) {
        Intrinsics.checkNotNullParameter(standName, "standName");
        this.standName = standName;
    }

    public /* synthetic */ SberIDLoginManager(StandName standName, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StandName.PROM : standName);
    }

    public final boolean loginWithSberbankID(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.stateApp = uri.getQueryParameter("state");
        this.nonceApp = uri.getQueryParameter("nonce");
        Uri uriCheckUri = checkUri(uri, context);
        if (DataUtilsKt.checkSbolIsNotInstalled(context)) {
            runWebAuth(context, uriCheckUri);
        } else {
            context.startActivity(new Intent("android.intent.action.VIEW", uriCheckUri));
        }
        Log.d("SberIDLoginManager", "Sber ID start login with uri: " + uriCheckUri);
        ComponentHolder.INSTANCE.getComponentHolder();
        return true;
    }

    public final SberIDResultModel getSberIDAuthResult(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        SberIDResultModel sberIDResultModel = new SberIDResultModel(null, null, null, null, null, null, 63, null);
        if (intent.getData() == null) {
            return sberIDResultModel;
        }
        Uri data = intent.getData();
        Intrinsics.checkNotNull(data);
        String queryParameter = data.getQueryParameter("state");
        sberIDResultModel.setSuccess(Boolean.valueOf(isSuccess(intent) && checkState(queryParameter)));
        Boolean isSuccess = sberIDResultModel.getIsSuccess();
        Intrinsics.checkNotNull(isSuccess);
        if (isSuccess.booleanValue()) {
            sberIDResultModel.setState(queryParameter);
            sberIDResultModel.setNonce(this.nonceApp);
            Uri data2 = intent.getData();
            Intrinsics.checkNotNull(data2);
            sberIDResultModel.setAuthCode(data2.getQueryParameter("code"));
            ComponentHolder.INSTANCE.getComponentHolder();
        } else {
            Uri data3 = intent.getData();
            Intrinsics.checkNotNull(data3);
            Intrinsics.checkNotNullExpressionValue(data3, "intent.data!!");
            sberIDResultModel.setErrorDescription(getErrorText(data3));
            Uri data4 = intent.getData();
            Intrinsics.checkNotNull(data4);
            sberIDResultModel.setErrorCode(data4.getQueryParameter("error_code"));
            ComponentHolder.INSTANCE.getComponentHolder();
        }
        this.stateApp = null;
        this.nonceApp = null;
        return sberIDResultModel;
    }

    private final boolean runWebAuth(Context context, Uri uri) {
        Log.d("SberIDLoginManager", "Sber ID start OIDC with uri: " + uri);
        ComponentHolder.INSTANCE.getComponentHolder();
        if (SberIDBrowserUtilsKt.launchCustomTabs(context, uri)) {
            return true;
        }
        if (UriUtilsKt.isHostWhiteList(uri)) {
            context.startActivity(WebViewActivity.INSTANCE.newIntent(uri, context));
            return true;
        }
        if (SberIDBrowserUtilsKt.launchBrowser(context, uri)) {
            return true;
        }
        Toast.makeText(context, context.getText(R$string.browser_not_found_toast), 0).show();
        return false;
    }

    private final Uri checkUri(Uri uri, Context context) {
        if (DataUtilsKt.checkSbolIsNotInstalled(context)) {
            Uri.Builder builderBuildUpon = uri.buildUpon();
            Uri uriBuild = INSTANCE.buildWebUrl(this.standName).build();
            builderBuildUpon.scheme(uriBuild.getScheme());
            builderBuildUpon.encodedAuthority(uriBuild.getAuthority());
            builderBuildUpon.encodedPath(uriBuild.getPath());
            Uri.Builder builderAppendQueryParameter = builderBuildUpon.appendQueryParameter("response_type", "code").appendQueryParameter("authApp", AuthApp.NONE.getKeyApp()).appendQueryParameter("auth_type", "app2web");
            ComponentHolder.Companion companion = ComponentHolder.INSTANCE;
            companion.getComponentHolder();
            Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter("channel", "");
            companion.getComponentHolder();
            Uri uriBuild2 = builderAppendQueryParameter2.appendQueryParameter("personalization", String.valueOf(false)).build();
            Intrinsics.checkNotNullExpressionValue(uriBuild2, "uri.buildUpon().apply {\n…\n                .build()");
            return uriBuild2;
        }
        Uri uriBuild3 = uri.buildUpon().scheme("sberbankidlogin").authority("sberbankid").path(null).appendQueryParameter("auth_type", "app2app").build();
        Intrinsics.checkNotNullExpressionValue(uriBuild3, "uri.buildUpon()\n        …\n                .build()");
        return uriBuild3;
    }

    private final boolean isSuccess(Intent intent) {
        if (intent.getData() != null) {
            Uri data = intent.getData();
            Intrinsics.checkNotNull(data);
            if (data.getQueryParameter("code") != null) {
                return true;
            }
        }
        return false;
    }

    private final boolean checkState(String state) {
        return StringsKt.equals$default(this.stateApp, state, false, 2, null);
    }

    private final String getErrorText(Uri data) {
        if (!Intrinsics.areEqual(data.getQueryParameter("error"), "null")) {
            return data.getQueryParameter("error");
        }
        if (checkState(data.getQueryParameter("state"))) {
            return "invalid_state";
        }
        return "internal_error";
    }

    /* compiled from: SberIDLoginManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lsberid/sdk/auth/login/SberIDLoginManager$Companion;", "", "()V", "AUTH_APP_KEY", "", "AUTH_CODE", "AUTH_TYPE", "BASE_ERROR", "CHANNEL", "CLIENT_ID", "CODE_CHALLENGE", "CODE_CHALLENGE_METHOD", "CUSTOM_TABS_REDIRECT_URI_KEY", "ERROR_CODE", "ERROR_DESCRIPTION", "HOST_MP", "LOGIN_HINT", "LOG_UID", "NONCE", "PERSONALIZATION", "REDIRECT_URI", "RESPONSE_TYPE", "RESPONSE_TYPE_VALUE", "SBER_ID_SSO_REDIRECT_KEY", "SCHEME_MP", "SCOPE", "STATE", "STATE_ERROR", "TAG", "buildWebUrl", "Landroid/net/Uri$Builder;", "standName", "Lsberid/sdk/auth/model/StandName;", "sberIDBuilder", "Lsberid/sdk/auth/login/SberIDLoginManager$Companion$SberIDBuilder;", "SberIDBuilder", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SberIDBuilder sberIDBuilder() {
            return new SberIDBuilder();
        }

        /* compiled from: SberIDLoginManager.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0006J\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lsberid/sdk/auth/login/SberIDLoginManager$Companion$SberIDBuilder;", "", "<init>", "()V", "", "clientID", "(Ljava/lang/String;)Lsberid/sdk/auth/login/SberIDLoginManager$Companion$SberIDBuilder;", "scope", "state", "nonce", "redirectUri", "codeChallenge", "codeChallengeMethod", "Landroid/net/Uri;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Landroid/net/Uri;", "Ljava/lang/String;", "customTabRedirectUri", "authApp", "customUriScheme", "loginHint", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
        public static final class SberIDBuilder {
            private String authApp;
            private String clientID;
            private String codeChallenge;
            private String codeChallengeMethod;
            private String customTabRedirectUri;
            private String customUriScheme;
            private String loginHint;
            private String nonce;
            private String redirectUri;
            private String scope;
            private String state;

            public final SberIDBuilder clientID(String clientID) {
                Intrinsics.checkNotNullParameter(clientID, "clientID");
                this.clientID = clientID;
                return this;
            }

            public final SberIDBuilder scope(String scope) {
                Intrinsics.checkNotNullParameter(scope, "scope");
                this.scope = scope;
                return this;
            }

            public final SberIDBuilder state(String state) {
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
                return this;
            }

            public final SberIDBuilder nonce(String nonce) {
                Intrinsics.checkNotNullParameter(nonce, "nonce");
                this.nonce = nonce;
                return this;
            }

            public final SberIDBuilder redirectUri(String redirectUri) {
                Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
                this.redirectUri = redirectUri;
                return this;
            }

            public final SberIDBuilder codeChallenge(String codeChallenge) {
                Intrinsics.checkNotNullParameter(codeChallenge, "codeChallenge");
                this.codeChallenge = codeChallenge;
                return this;
            }

            public final SberIDBuilder codeChallengeMethod(String codeChallengeMethod) {
                Intrinsics.checkNotNullParameter(codeChallengeMethod, "codeChallengeMethod");
                this.codeChallengeMethod = codeChallengeMethod;
                return this;
            }

            public final Uri build() {
                Uri uriBuild;
                String str = this.customUriScheme;
                if (str != null) {
                    uriBuild = Uri.parse(str);
                } else if (this.customTabRedirectUri != null) {
                    Uri.Builder builderAppendQueryParameter = Companion.buildWebUrl$default(SberIDLoginManager.INSTANCE, null, 1, null).appendQueryParameter("response_type", "code").appendQueryParameter("app_redirect_uri", this.customTabRedirectUri);
                    ComponentHolder.Companion companion = ComponentHolder.INSTANCE;
                    companion.getComponentHolder();
                    Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter("channel", "");
                    companion.getComponentHolder();
                    uriBuild = builderAppendQueryParameter2.appendQueryParameter("personalization", String.valueOf(false)).appendQueryParameter("authApp", this.authApp).appendQueryParameter("auth_type", "oidc2app").build();
                } else {
                    uriBuild = new Uri.Builder().scheme("sberbankidlogin").authority("sberbankid").build();
                }
                Uri.Builder builderBuildUpon = uriBuild.buildUpon();
                String str2 = this.loginHint;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    builderBuildUpon.appendQueryParameter("login_hint", this.loginHint);
                }
                String str3 = this.codeChallenge;
                if (str3 != null && this.codeChallengeMethod != null) {
                    builderBuildUpon.appendQueryParameter("code_challenge", str3);
                    builderBuildUpon.appendQueryParameter("code_challenge_method", this.codeChallengeMethod);
                }
                ComponentHolder.Companion companion2 = ComponentHolder.INSTANCE;
                companion2.getComponentHolder();
                String str4 = this.clientID;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clientID");
                }
                builderBuildUpon.appendQueryParameter("client_id", str4);
                String str5 = this.scope;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scope");
                }
                builderBuildUpon.appendQueryParameter("scope", str5);
                String str6 = this.state;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("state");
                }
                builderBuildUpon.appendQueryParameter("state", str6);
                String str7 = this.nonce;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nonce");
                }
                builderBuildUpon.appendQueryParameter("nonce", str7);
                String str8 = this.redirectUri;
                if (str8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("redirectUri");
                }
                builderBuildUpon.appendQueryParameter("redirect_uri", str8);
                companion2.getComponentHolder();
                builderBuildUpon.appendQueryParameter("logUid", "");
                Uri uriBuild2 = builderBuildUpon.build();
                Intrinsics.checkNotNullExpressionValue(uriBuild2, "uri.buildUpon().apply {\n…                }.build()");
                return uriBuild2;
            }
        }

        static /* synthetic */ Uri.Builder buildWebUrl$default(Companion companion, StandName standName, int i, Object obj) {
            if ((i & 1) != 0) {
                standName = StandName.PROM;
            }
            return companion.buildWebUrl(standName);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Uri.Builder buildWebUrl(StandName standName) {
            ComponentHolder.INSTANCE.getComponentHolder();
            Uri.Builder builderBuildUpon = Uri.parse(standName.getUrl()).buildUpon();
            Intrinsics.checkNotNullExpressionValue(builderBuildUpon, "Uri.parse(componentHolde…tandName.url).buildUpon()");
            return builderBuildUpon;
        }
    }
}
