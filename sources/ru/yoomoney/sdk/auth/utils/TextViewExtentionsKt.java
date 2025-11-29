package ru.yoomoney.sdk.auth.utils;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"removeLinkUnderline", "", "Landroid/widget/TextView;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TextViewExtentionsKt {
    public static final void removeLinkUnderline(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        SpannableString spannableString = new SpannableString(textView.getText());
        Object[] spans = spannableString.getSpans(0, spannableString.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        for (URLSpan uRLSpan : (URLSpan[]) spans) {
            spannableString.setSpan(new URLSpan(uRLSpan.getURL()) { // from class: ru.yoomoney.sdk.auth.utils.TextViewExtentionsKt.removeLinkUnderline.1
                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                }
            }, spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 0);
        }
        textView.setText(spannableString);
    }
}
