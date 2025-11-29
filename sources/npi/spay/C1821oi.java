package npi.spay;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.oi, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1821oi extends Dk {
    public C1821oi() {
        super(C1796ni.a);
    }

    @Override // npi.spay.Dk
    public final void a(ViewBinding viewBinding, Object obj) {
        K3 k3 = (K3) viewBinding;
        N4 item = (N4) obj;
        Intrinsics.checkNotNullParameter(k3, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Context context = k3.d.getContext();
        AppCompatTextView appCompatTextView = k3.b;
        C2097zk c2097zk = item.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        appCompatTextView.setText(AbstractC1550dl.a(c2097zk, context));
        k3.c.setText(AbstractC1550dl.a(item.b, context));
    }

    @Override // npi.spay.Dk
    public final boolean b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof N4;
    }

    @Override // npi.spay.Dk
    public final Integer a(Object obj) {
        N4 n4 = (N4) obj;
        Intrinsics.checkNotNullParameter(n4, "<this>");
        return Integer.valueOf(n4.hashCode());
    }
}
