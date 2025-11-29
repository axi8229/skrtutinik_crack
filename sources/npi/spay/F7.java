package npi.spay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.view.CardLogoCompositeView;

/* loaded from: classes4.dex */
public final /* synthetic */ class F7 extends FunctionReferenceImpl implements Function3 {
    public static final F7 a = new F7();

    public F7() {
        super(3, J4.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lspay/sdk/databinding/SpayRvItemHelperBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        LayoutInflater p0 = (LayoutInflater) obj;
        ViewGroup viewGroup = (ViewGroup) obj2;
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        Intrinsics.checkNotNullParameter(p0, "p0");
        View viewInflate = p0.inflate(R$layout.spay_rv_item_helper, viewGroup, false);
        if (zBooleanValue) {
            viewGroup.addView(viewInflate);
        }
        int i = R$id.spay_srih_aciv_helper_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatImageView != null) {
            i = R$id.spay_srih_actv_helper_content;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatTextView != null) {
                i = R$id.spay_srih_actv_helper_header;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                if (appCompatTextView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                    i = R$id.spay_srih_clcv_helper_icon;
                    if (((CardLogoCompositeView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                        return new J4(appCompatImageView, appCompatTextView, appCompatTextView2, constraintLayout, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
