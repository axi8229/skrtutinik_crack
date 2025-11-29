package npi.spay;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ea extends Dk {
    public Ea() {
        super(Da.a);
    }

    @Override // npi.spay.Dk
    public final void a(ViewBinding viewBinding, Object obj) {
        R0 r0 = (R0) viewBinding;
        Tm item = (Tm) obj;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Context context = r0.a.getContext();
        AppCompatTextView appCompatTextView = r0.b;
        C2097zk c2097zk = item.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        appCompatTextView.setText(AbstractC1550dl.a(c2097zk, context));
        C2097zk c2097zk2 = item.b;
        if (c2097zk2 != null) {
            r0.c.setText(AbstractC1550dl.a(c2097zk2, context));
        }
    }

    @Override // npi.spay.Dk
    public final boolean b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof Tm;
    }

    @Override // npi.spay.Dk
    public final Integer a(Object obj) {
        Tm tm = (Tm) obj;
        Intrinsics.checkNotNullParameter(tm, "<this>");
        return Integer.valueOf(tm.hashCode());
    }
}
