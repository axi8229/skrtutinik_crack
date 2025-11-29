package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes5.dex */
public abstract class ItemPaymentHistoryBinding extends ViewDataBinding {
    public final View dividerHorizontal;
    public final TextView paymentIntercom;
    public final TextView pricePayment;
    public final TextView tvAccountBill;
    public final TextView tvAccountNumber;

    protected ItemPaymentHistoryBinding(Object obj, View view, int i, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.dividerHorizontal = view2;
        this.paymentIntercom = textView;
        this.pricePayment = textView2;
        this.tvAccountBill = textView3;
        this.tvAccountNumber = textView4;
    }
}
