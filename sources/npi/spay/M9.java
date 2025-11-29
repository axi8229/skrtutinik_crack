package npi.spay;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class M9 extends Dk {
    public M9() {
        super(L9.a);
    }

    @Override // npi.spay.Dk
    public final void a(ViewBinding viewBinding, Object obj) {
        C1834p6 c1834p6 = (C1834p6) viewBinding;
        C1811o8 item = (C1811o8) obj;
        Intrinsics.checkNotNullParameter(c1834p6, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        AppCompatTextView appCompatTextView = c1834p6.b;
        Bk bk = item.a;
        Context context = c1834p6.a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        appCompatTextView.setText(AbstractC1550dl.a(bk, context));
    }

    @Override // npi.spay.Dk
    public final boolean b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof C1811o8;
    }

    @Override // npi.spay.Dk
    public final Integer a(Object obj) {
        C1811o8 c1811o8 = (C1811o8) obj;
        Intrinsics.checkNotNullParameter(c1811o8, "<this>");
        return Integer.valueOf(c1811o8.hashCode());
    }
}
