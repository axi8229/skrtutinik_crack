package npi.spay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;

/* loaded from: classes4.dex */
public final class Ug implements ViewBinding {
    public final LinearLayoutCompat a;
    public final RecyclerView b;

    public Ug(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView) {
        this.a = linearLayoutCompat;
        this.b = recyclerView;
    }

    public static Ug a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R$layout.spay_composite_layout_bnpl_order_view, viewGroup, false);
        viewGroup.addView(viewInflate);
        int i = R$id.spay_sclbov_graph;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, i);
        if (recyclerView != null) {
            return new Ug((LinearLayoutCompat) viewInflate, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
