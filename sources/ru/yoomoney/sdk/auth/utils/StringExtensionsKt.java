package ru.yoomoney.sdk.auth.utils;

import android.text.Spanned;
import androidx.core.text.HtmlCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"parseHtml", "Landroid/text/Spanned;", "", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StringExtensionsKt {
    public static final Spanned parseHtml(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, 63);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
        return spannedFromHtml;
    }
}
