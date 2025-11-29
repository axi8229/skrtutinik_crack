package ru.yoomoney.sdk.kassa.payments.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.contract.S;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;

/* loaded from: classes5.dex */
public final class j extends ClickableSpan {
    public final /* synthetic */ Function0 a;

    public j(S s) {
        this.a = s;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.a.invoke();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        super.updateDrawState(ds);
        ds.setColor(InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor());
        ds.setUnderlineText(false);
    }
}
