package npi.spay;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$color;

/* renamed from: npi.spay.tc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1939tc extends ClickableSpan {
    public final /* synthetic */ C1888rb a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public C1939tc(C1888rb c1888rb, int i, String str) {
        this.a = c1888rb;
        this.b = i;
        this.c = str;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        ((Td) this.a.b()).a(new C1614ga(this.b, this.c));
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        C1888rb c1888rb = this.a;
        int i = R$color.spay_main_bank_green_color;
        Intrinsics.checkNotNullParameter(c1888rb, "<this>");
        ds.setColor(ResourcesCompat.getColor(c1888rb.getResources(), i, null));
        ds.setUnderlineText(false);
    }
}
