package ru.yoomoney.sdk.kassa.payments.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;

/* loaded from: classes5.dex */
public final class k extends ClickableSpan {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ URLSpan b;

    public k(Function1 function1, URLSpan uRLSpan) {
        this.a = function1;
        this.b = uRLSpan;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Function1 function1 = this.a;
        String url = this.b.getURL();
        Intrinsics.checkNotNullExpressionValue(url, "getURL(...)");
        function1.invoke(url);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        super.updateDrawState(textPaint);
        textPaint.setColor(InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor());
        textPaint.setUnderlineText(false);
    }
}
