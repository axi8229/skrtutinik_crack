package com.sputnik.common.extensions;

import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.View;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Spans.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a1\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a-\u0010\u0011\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u0005*\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroid/text/SpannableString;", "", "link", "addr", "Lkotlin/Function0;", "", "trackListener", "addLink", "(Landroid/text/SpannableString;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "text", "", RemoteMessageConst.Notification.COLOR, "addColorSpan", "(Landroid/text/SpannableString;Ljava/lang/String;I)V", "Lkotlin/Function1;", "Landroid/view/View;", "onClick", "addClickableSpan", "(Landroid/text/SpannableString;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "addBoldSpan", "(Landroid/text/SpannableString;Ljava/lang/String;)V", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpansKt {
    public static /* synthetic */ void addLink$default(SpannableString spannableString, String str, String str2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.sputnik.common.extensions.SpansKt.addLink.1
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
        addLink(spannableString, str, str2, function0);
    }

    public static final void addLink(SpannableString spannableString, String link, final String addr, final Function0<Unit> trackListener) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(addr, "addr");
        Intrinsics.checkNotNullParameter(trackListener, "trackListener");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, link, 0, false, 6, (Object) null);
        spannableString.setSpan(new URLSpan(addr) { // from class: com.sputnik.common.extensions.SpansKt$addLink$span$1
            @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                super.onClick(widget);
                trackListener.invoke();
            }
        }, iIndexOf$default, link.length() + iIndexOf$default, 33);
    }

    public static final void addColorSpan(SpannableString spannableString, String text, int i) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, text, 0, false, 6, (Object) null);
        spannableString.setSpan(new ForegroundColorSpan(i), iIndexOf$default, text.length() + iIndexOf$default, 33);
    }

    public static final void addClickableSpan(SpannableString spannableString, String text, final Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, text, 0, false, 6, (Object) null);
        spannableString.setSpan(new ClickableSpan() { // from class: com.sputnik.common.extensions.SpansKt.addClickableSpan.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                onClick.invoke(widget);
            }
        }, iIndexOf$default, text.length() + iIndexOf$default, 33);
    }

    public static final void addBoldSpan(SpannableString spannableString, String str) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        if (str != null) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, str, 0, false, 6, (Object) null);
            spannableString.setSpan(new StyleSpan(1), iIndexOf$default, str.length() + iIndexOf$default, 33);
        }
    }
}
