package npi.spay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBindings;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;

/* renamed from: npi.spay.ni, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1796ni extends FunctionReferenceImpl implements Function3 {
    public static final C1796ni a = new C1796ni();

    public C1796ni() {
        super(3, K3.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lspay/sdk/databinding/SpayRvItemCardSelectionHeaderBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        LayoutInflater p0 = (LayoutInflater) obj;
        ViewGroup viewGroup = (ViewGroup) obj2;
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        Intrinsics.checkNotNullParameter(p0, "p0");
        View viewInflate = p0.inflate(R$layout.spay_rv_item_card_selection_header, viewGroup, false);
        if (zBooleanValue) {
            viewGroup.addView(viewInflate);
        }
        int i = R$id.spay_sricsh_actv_header_not_enough_money;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_sricsh_actv_header_not_enough_money_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i);
            if (textView != null) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate;
                return new K3(linearLayoutCompat, appCompatTextView, textView, linearLayoutCompat);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
