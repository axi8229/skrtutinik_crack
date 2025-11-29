package npi.spay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;

/* renamed from: npi.spay.p7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1835p7 extends L4 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1835p7(C2060y8 diffUtilCallback) {
        super(null, diffUtilCallback);
        Intrinsics.checkNotNullParameter(diffUtilCallback, "diffUtilCallback");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.spay_rv_item_bnpl_graph_section, parent, false);
        int i2 = R$id.spay_sribgs_section;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewInflate, i2);
        if (appCompatImageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }
        po poVar = new po((FrameLayout) viewInflate, appCompatImageView);
        Intrinsics.checkNotNullExpressionValue(poVar, "inflate(\n            Lay…          false\n        )");
        return new C2011w9(poVar);
    }
}
