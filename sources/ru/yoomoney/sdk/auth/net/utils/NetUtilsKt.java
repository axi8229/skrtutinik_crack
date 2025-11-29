package ru.yoomoney.sdk.auth.net.utils;

import android.os.LocaleList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"acceptLanguage", "", "getAcceptLanguage", "()Ljava/lang/String;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetUtilsKt {
    private static final String acceptLanguage;

    static {
        String languageTags = LocaleList.getDefault().toLanguageTags();
        Intrinsics.checkNotNull(languageTags);
        acceptLanguage = languageTags;
    }

    public static final String getAcceptLanguage() {
        return acceptLanguage;
    }
}
