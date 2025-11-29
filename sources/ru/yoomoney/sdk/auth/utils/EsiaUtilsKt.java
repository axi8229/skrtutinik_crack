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
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.EsiaOauthCodeParameters;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\rH\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"ESIA_WEB_HOST", "", "ESIA_WEB_PATH", "ESIA_WEB_SCHEME", "PARAMS_ACCESS_TYPE", "PARAMS_CLIENT_ID", "PARAMS_CLIENT_SECRET", "PARAMS_REDIRECT_URI", "PARAMS_RESPONSE_TYPE", "PARAMS_SCOPE", "PARAMS_STATE", "PARAMS_TIMESTAMP", "getEsiaReturnUrl", "Landroid/content/Context;", "openEsia", "", "Landroid/app/Activity;", "parameters", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/EsiaOauthCodeParameters;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EsiaUtilsKt {
    private static final String ESIA_WEB_HOST = "esia.gosuslugi.ru";
    private static final String ESIA_WEB_PATH = "aas/oauth2/ac";
    private static final String ESIA_WEB_SCHEME = "https";
    private static final String PARAMS_ACCESS_TYPE = "access_type";
    private static final String PARAMS_CLIENT_ID = "client_id";
    private static final String PARAMS_CLIENT_SECRET = "client_secret";
    private static final String PARAMS_REDIRECT_URI = "redirect_uri";
    private static final String PARAMS_RESPONSE_TYPE = "response_type";
    private static final String PARAMS_SCOPE = "scope";
    private static final String PARAMS_STATE = "state";
    private static final String PARAMS_TIMESTAMP = "timestamp";

    public static final String getEsiaReturnUrl(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String string = context.getString(R.string.auth_esia_scheme);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(R.string.auth_esia_host);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (StringsKt.isBlank(string) || StringsKt.isBlank(string2)) {
            return null;
        }
        return string + "://" + string2;
    }

    public static final void openEsia(Activity activity, EsiaOauthCodeParameters parameters) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", new Uri.Builder().scheme(ESIA_WEB_SCHEME).authority(ESIA_WEB_HOST).appendEncodedPath(ESIA_WEB_PATH).appendQueryParameter(PARAMS_CLIENT_SECRET, parameters.getClientSecret()).appendQueryParameter(PARAMS_CLIENT_ID, parameters.getClientId()).appendQueryParameter(PARAMS_SCOPE, parameters.getScope()).appendQueryParameter(PARAMS_TIMESTAMP, parameters.getTimestamp()).appendQueryParameter(PARAMS_STATE, parameters.getState()).appendQueryParameter(PARAMS_REDIRECT_URI, parameters.getRedirectUri()).appendQueryParameter(PARAMS_RESPONSE_TYPE, parameters.getResponseType()).appendQueryParameter(PARAMS_ACCESS_TYPE, parameters.getAccessType()).build()));
        } catch (ActivityNotFoundException unused) {
            View viewFindViewById = activity.findViewById(R.id.content);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            String string = activity.getString(R.string.auth_error_no_browser);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(viewFindViewById, string);
        }
    }
}
