package ru.yoomoney.sdk.kassa.payments.utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
import androidx.core.text.HtmlCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.contract.S;

/* loaded from: classes5.dex */
public abstract class l {
    public static final SpannableStringBuilder a(String htmlText, Function1 action) {
        Intrinsics.checkNotNullParameter(htmlText, "htmlText");
        Intrinsics.checkNotNullParameter(action, "action");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(htmlText, 0);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class);
        Intrinsics.checkNotNull(uRLSpanArr);
        for (URLSpan span : uRLSpanArr) {
            Intrinsics.checkNotNull(span);
            Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
            Intrinsics.checkNotNullParameter(span, "span");
            Intrinsics.checkNotNullParameter(action, "action");
            spannableStringBuilder.setSpan(new k(action, span), spannableStringBuilder.getSpanStart(span), spannableStringBuilder.getSpanEnd(span), spannableStringBuilder.getSpanFlags(span));
            spannableStringBuilder.removeSpan(span);
        }
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder a(CharSequence firstMessagePart, CharSequence secondMessagePart, S action) {
        Intrinsics.checkNotNullParameter(firstMessagePart, "firstMessagePart");
        Intrinsics.checkNotNullParameter(secondMessagePart, "secondMessagePart");
        Intrinsics.checkNotNullParameter(action, "action");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((Object) firstMessagePart) + " " + ((Object) secondMessagePart));
        spannableStringBuilder.setSpan(new j(action), spannableStringBuilder.length() - secondMessagePart.length(), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }
}
