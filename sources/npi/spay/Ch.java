package npi.spay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;

/* loaded from: classes4.dex */
public final class Ch extends L4 {
    public final Function1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ch(C1568ee hintsItemDiffUtilCallback, Function1 hintCloseActionListener) {
        super(hintCloseActionListener, hintsItemDiffUtilCallback);
        Intrinsics.checkNotNullParameter(hintsItemDiffUtilCallback, "hintsItemDiffUtilCallback");
        Intrinsics.checkNotNullParameter(hintCloseActionListener, "hintCloseActionListener");
        this.b = hintCloseActionListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.spay_rv_item_hint_helper, parent, false);
        int i2 = R$id.spay_srihh_aciv_dismiss_hint;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewInflate, i2);
        if (appCompatImageView != null) {
            i2 = R$id.spay_srihh_actv_dash;
            if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i2)) != null) {
                i2 = R$id.spay_srihh_actv_hint;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i2);
                if (appCompatTextView != null) {
                    C1907s5 c1907s5 = new C1907s5((ConstraintLayout) viewInflate, appCompatImageView, appCompatTextView);
                    Intrinsics.checkNotNullExpressionValue(c1907s5, "inflate(LayoutInflater.f….context), parent, false)");
                    return new Hc(c1907s5, this.b);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}
