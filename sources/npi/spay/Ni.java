package npi.spay;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$color;

/* loaded from: classes4.dex */
public final class Ni extends ClickableSpan {
    public final /* synthetic */ C1771mi a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public Ni(C1771mi c1771mi, int i, String str) {
        this.a = c1771mi;
        this.b = i;
        this.c = str;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        ((Jj) this.a.b()).a(new C1659i5(this.b, this.c));
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        C1771mi c1771mi = this.a;
        int i = R$color.spay_main_bank_green_color;
        Intrinsics.checkNotNullParameter(c1771mi, "<this>");
        ds.setColor(ResourcesCompat.getColor(c1771mi.getResources(), i, null));
        ds.setUnderlineText(false);
    }
}
