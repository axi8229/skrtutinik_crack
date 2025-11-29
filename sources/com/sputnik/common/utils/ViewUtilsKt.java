package com.sputnik.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.TextAppearanceSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$style;
import com.sputnik.common.entities.view.HighlightedText;
import com.sputnik.common.extensions.SpansKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* compiled from: ViewUtils.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a'\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a9\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u000b\u001a-\u0010\u0006\u001a\u00020\u0010*\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0004\b\u0006\u0010\u0011\u001a5\u0010\u0016\u001a\u00020\u0010*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u001b\u001a\u00020\u0010*\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a-\u0010\u001e\u001a\u00020\u0010*\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"", "text", "textForHighlight", "", RemoteMessageConst.Notification.COLOR, "Landroid/text/SpannableString;", "highlightText", "(Ljava/lang/String;Ljava/lang/String;I)Landroid/text/SpannableString;", "Landroid/content/Context;", "context", "style", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;I)Landroid/text/SpannableString;", "Landroid/widget/TextView;", "", "Lcom/sputnik/common/entities/view/HighlightedText;", "params", "", "(Landroid/widget/TextView;Ljava/lang/String;[Lcom/sputnik/common/entities/view/HighlightedText;)V", "textToLink", "linkColor", "Lkotlin/Function0;", "onClickListener", "addCustomLink", "(Landroid/text/SpannableString;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "Landroid/widget/EditText;", "drawableType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDrawableListener", "(Landroid/widget/EditText;ILkotlin/jvm/functions/Function0;)V", "strikeThrough", "strikeThrouth", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewUtilsKt {
    public static final SpannableString highlightText(String text, String textForHighlight, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textForHighlight, "textForHighlight");
        if (StringsKt.isBlank(text) || StringsKt.isBlank(textForHighlight)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(String.format(text, textForHighlight));
        SpansKt.addColorSpan(spannableString, textForHighlight, i);
        return spannableString;
    }

    public static /* synthetic */ SpannableString highlightText$default(String str, String str2, int i, Context context, int i2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            i2 = R$style.TextView_Body2_Highlighted;
        }
        return highlightText(str, str2, i, context, i2);
    }

    public static final SpannableString highlightText(String text, String textForHighlight, int i, Context context, int i2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textForHighlight, "textForHighlight");
        Intrinsics.checkNotNullParameter(context, "context");
        SpannableString spannableString = new SpannableString(String.format(text, textForHighlight));
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, textForHighlight, 0, false, 6, (Object) null);
        int length = textForHighlight.length() + iIndexOf$default;
        spannableString.setSpan(new TextAppearanceSpan(context, i2), iIndexOf$default, length, 33);
        spannableString.setSpan(new RelativeSizeSpan(1.1f), iIndexOf$default, length, 33);
        SpansKt.addColorSpan(spannableString, textForHighlight, i);
        return spannableString;
    }

    public static final void highlightText(TextView textView, String text, HighlightedText... params) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            int length = params.length;
            String[] strArr = new String[length];
            int length2 = params.length;
            int i = 0;
            int i2 = 0;
            while (i < length2) {
                strArr[i2] = params[i].getParam();
                i++;
                i2++;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArrCopyOf = Arrays.copyOf(strArr, length);
            String str = String.format(text, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            SpannableString spannableString = new SpannableString(str);
            for (HighlightedText highlightedText : params) {
                String param = highlightedText.getParam();
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, param, 0, false, 6, (Object) null);
                if (iIndexOf$default != -1) {
                    int length3 = param.length() + iIndexOf$default;
                    Integer numValueOf = Integer.valueOf(highlightedText.getTextStyle());
                    if (numValueOf.intValue() == -1) {
                        numValueOf = null;
                    }
                    if (numValueOf != null) {
                        spannableString.setSpan(new TextAppearanceSpan(textView.getContext(), numValueOf.intValue()), iIndexOf$default, length3, 33);
                    }
                    String address = highlightedText.getAddress();
                    if (address != null) {
                        String string = address.toString();
                        Function0<Unit> onClickListener = highlightedText.getOnClickListener();
                        if (onClickListener == null) {
                            onClickListener = new Function0<Unit>() { // from class: com.sputnik.common.utils.ViewUtilsKt$highlightText$1$2$3$1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        SpansKt.addLink(spannableString, param, string, onClickListener);
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                    Function0<Unit> onClickListener2 = highlightedText.getOnClickListener();
                    if (onClickListener2 != null) {
                        addCustomLink(spannableString, param, highlightedText.getColor(), onClickListener2);
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                    spannableString.setSpan(new ForegroundColorSpan(highlightedText.getColor()), iIndexOf$default, length3, 33);
                }
            }
            textView.setText(spannableString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void addCustomLink(SpannableString spannableString, String textToLink, final int i, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        Intrinsics.checkNotNullParameter(textToLink, "textToLink");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, textToLink, 0, false, 6, (Object) null);
        if (iIndexOf$default != -1) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.sputnik.common.utils.ViewUtilsKt$addCustomLink$clickableSpan$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                    int i2 = i;
                    if (i2 != -1) {
                        ds.setColor(i2);
                    }
                }
            }, iIndexOf$default, textToLink.length() + iIndexOf$default, 33);
        }
    }

    public static /* synthetic */ void setDrawableListener$default(EditText editText, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        setDrawableListener(editText, i, function0);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public static final void setDrawableListener(final EditText editText, final int i, final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        editText.setOnTouchListener(new View.OnTouchListener() { // from class: com.sputnik.common.utils.ViewUtilsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ViewUtilsKt.setDrawableListener$lambda$8(editText, i, listener, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setDrawableListener$lambda$8(EditText this_setDrawableListener, int i, Function0 listener, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this_setDrawableListener, "$this_setDrawableListener");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (motionEvent.getAction() != 1 || motionEvent.getRawX() < this_setDrawableListener.getRight() - this_setDrawableListener.getCompoundDrawables()[i].getBounds().width()) {
            return false;
        }
        listener.invoke();
        return true;
    }

    public static final void strikeThrouth(TextView textView, String text, String strikeThrough, Integer num) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(strikeThrough, "strikeThrough");
        try {
            if (StringsKt.contains$default((CharSequence) text, (CharSequence) strikeThrough, false, 2, (Object) null)) {
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) text, strikeThrough, 0, false, 6, (Object) null);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
                spannableStringBuilder.setSpan(new StrikethroughSpan(), iIndexOf$default, strikeThrough.length() + iIndexOf$default, 33);
                if (num != null) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), iIndexOf$default, strikeThrough.length() + iIndexOf$default, 18);
                }
                textView.setText(spannableStringBuilder);
                return;
            }
            textView.setText(text);
        } catch (Exception unused) {
            textView.setText(text);
        }
    }
}
