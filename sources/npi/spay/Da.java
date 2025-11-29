package npi.spay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;

/* loaded from: classes4.dex */
public final /* synthetic */ class Da extends FunctionReferenceImpl implements Function3 {
    public static final Da a = new Da();

    public Da() {
        super(3, R0.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lspay/sdk/databinding/SpayRvItemBnplPaymentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        LayoutInflater p0 = (LayoutInflater) obj;
        ViewGroup viewGroup = (ViewGroup) obj2;
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        Intrinsics.checkNotNullParameter(p0, "p0");
        View viewInflate = p0.inflate(R$layout.spay_rv_item_bnpl_payment, viewGroup, false);
        if (zBooleanValue) {
            viewGroup.addView(viewInflate);
        }
        int i = R$id.spay_slo_tv_amount;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_slo_tv_amount_bnpl_total;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatTextView2 != null) {
                return new R0((ConstraintLayout) viewInflate, appCompatTextView, appCompatTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
