package sputnik.axmor.com.sputnik.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.SputnikApp;

/* compiled from: SpanUtils.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/SpanUtils;", "", "()V", "urlPattern", "Ljava/util/regex/Pattern;", "clickableLink", "", "Landroid/widget/TextView;", "longText", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpanUtils {
    public static final SpanUtils INSTANCE = new SpanUtils();
    private static final Pattern urlPattern;

    private SpanUtils() {
    }

    static {
        Pattern patternCompile = Pattern.compile("(http|https)?(://)?(www.)?[a-zA-Z-а-яА-Я]+\\.[a-яА-Яa-zA-Z]+", 42);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        urlPattern = patternCompile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v11, types: [T, java.lang.String] */
    public final void clickableLink(TextView textView, String longText) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(longText, "longText");
        try {
            SpannableString spannableString = new SpannableString(longText);
            Matcher matcher = urlPattern.matcher(longText);
            while (matcher.find()) {
                int iStart = matcher.start(0);
                int iEnd = matcher.end();
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ?? Substring = longText.substring(iStart, iEnd);
                Intrinsics.checkNotNullExpressionValue(Substring, "substring(...)");
                ref$ObjectRef.element = Substring;
                if (!StringsKt.startsWith$default((String) Substring, "www", false, 2, (Object) null)) {
                    ref$ObjectRef.element = "www." + ref$ObjectRef.element;
                }
                if (!StringsKt.startsWith$default((String) ref$ObjectRef.element, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default((String) ref$ObjectRef.element, "https://", false, 2, (Object) null)) {
                    ref$ObjectRef.element = "http://" + ref$ObjectRef.element;
                }
                Log.e("url", (String) ref$ObjectRef.element);
                spannableString.setSpan(new ClickableSpan() { // from class: sputnik.axmor.com.sputnik.utils.SpanUtils$clickableLink$clickableSpan$1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View widget) {
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(ref$ObjectRef.element));
                        intent.addFlags(268435456);
                        SputnikApp.INSTANCE.applicationContext().startActivity(intent);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint ds) {
                        Intrinsics.checkNotNullParameter(ds, "ds");
                        super.updateDrawState(ds);
                        ds.setUnderlineText(false);
                        ds.setColor(ContextCompat.getColor(SputnikApp.INSTANCE.applicationContext(), R.color.sputnik_blue));
                    }
                }, iStart, iEnd, 33);
            }
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setHighlightColor(ContextCompat.getColor(SputnikApp.INSTANCE.applicationContext(), R.color.track_gray));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
