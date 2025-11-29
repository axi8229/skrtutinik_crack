package ru.yoomoney.sdk.auth.net.utils;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"securedFields", "", "maskSecuredFields", "json", "prepareSecureLog", CrashHianalyticsData.MESSAGE, "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SecuredLogUtilsKt {
    private static final String securedFields = "token|accessToken|authCryptogram|salt|hash|Authorization|code|secureCode|landingUrl|pan|pin|client_secret|signature";

    private static final String maskSecuredFields(String str) {
        return new Regex("(?<=\"(?:token|accessToken|authCryptogram|salt|hash|Authorization|code|secureCode|landingUrl|pan|pin|client_secret|signature)\"\\s?:\\s?\"[^\"]{0,255})[^\"]").replace(str, "*");
    }

    public static final String prepareSecureLog(String message) {
        String strMaskSecuredFields;
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            if (StringsKt.startsWith$default(message, "Authorization", false, 2, (Object) null)) {
                strMaskSecuredFields = "Authorization " + StringsKt.repeat("*", message.length() - 13);
            } else {
                strMaskSecuredFields = maskSecuredFields(message);
            }
            return strMaskSecuredFields;
        } catch (Exception e) {
            return "Error occurred while preparing secure log: " + e.getMessage();
        }
    }
}
