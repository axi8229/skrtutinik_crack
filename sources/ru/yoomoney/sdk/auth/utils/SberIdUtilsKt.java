package ru.yoomoney.sdk.auth.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.SberOauthCodeParameters;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\fH\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"PARAMS_CLIENT_ID", "", "PARAMS_NONCE", "PARAMS_REDIRECT_URI", "PARAMS_RESPONSE_TYPE", "PARAMS_SCOPE", "PARAMS_STATE", "SBOL_HOST", "SBOL_SCHEME", "SBOL_WEB_HOST", "SBOL_WEB_SCHEME", "getSberIdReturnUrl", "Landroid/content/Context;", "isSbolDeeplinkCanBeHandled", "", "Landroid/app/Activity;", "openSbol", "", "parameters", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/SberOauthCodeParameters;", "redirectUrl", "transformToDeeplink", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SberIdUtilsKt {
    private static final String PARAMS_CLIENT_ID = "client_id";
    private static final String PARAMS_NONCE = "nonce";
    private static final String PARAMS_REDIRECT_URI = "redirect_uri";
    private static final String PARAMS_RESPONSE_TYPE = "response_type";
    private static final String PARAMS_SCOPE = "scope";
    private static final String PARAMS_STATE = "state";
    private static final String SBOL_HOST = "sberbankid";
    private static final String SBOL_SCHEME = "sberbankidlogin";
    private static final String SBOL_WEB_HOST = "online.sberbank.ru";
    private static final String SBOL_WEB_SCHEME = "https";

    public static final String getSberIdReturnUrl(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String string = context.getString(R.string.auth_sber_id_scheme);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(R.string.auth_sber_id_host);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (StringsKt.isBlank(string) || StringsKt.isBlank(string2)) {
            return null;
        }
        return string + "://" + string2;
    }

    private static final boolean isSbolDeeplinkCanBeHandled(Activity activity) {
        return new Intent("android.intent.action.VIEW", new Uri.Builder().scheme(SBOL_SCHEME).authority(SBOL_HOST).build()).resolveActivity(activity.getPackageManager()) != null;
    }

    public static final void openSbol(Activity activity, SberOauthCodeParameters parameters, String redirectUrl) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        boolean zIsSbolDeeplinkCanBeHandled = isSbolDeeplinkCanBeHandled(activity);
        Uri uriTransformToDeeplink = transformToDeeplink(parameters, redirectUrl);
        if (!zIsSbolDeeplinkCanBeHandled) {
            uriTransformToDeeplink = uriTransformToDeeplink.buildUpon().scheme(SBOL_WEB_SCHEME).authority(SBOL_WEB_HOST).appendEncodedPath("CSAFront/oidc/authorize.do").appendQueryParameter(PARAMS_RESPONSE_TYPE, "code").build();
        }
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", uriTransformToDeeplink));
        } catch (ActivityNotFoundException unused) {
            View viewFindViewById = activity.findViewById(android.R.id.content);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            String string = activity.getString(R.string.auth_error_no_browser);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(viewFindViewById, string);
        }
    }

    private static final Uri transformToDeeplink(SberOauthCodeParameters sberOauthCodeParameters, String str) {
        return new Uri.Builder().scheme(SBOL_SCHEME).authority(SBOL_HOST).appendQueryParameter(PARAMS_CLIENT_ID, sberOauthCodeParameters.getClientId()).appendQueryParameter(PARAMS_STATE, sberOauthCodeParameters.getState()).appendQueryParameter(PARAMS_NONCE, sberOauthCodeParameters.getNonce()).appendQueryParameter(PARAMS_SCOPE, sberOauthCodeParameters.getScope()).appendQueryParameter(PARAMS_REDIRECT_URI, str).build();
    }
}
