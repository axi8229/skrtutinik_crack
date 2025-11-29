package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class NewSubscriptionItemBinding extends ViewDataBinding {
    public final LinearLayout featuresLayout;
    public final TextView tvHeader;
    public final TextView tvLabel;
    public final TextView tvPrice;

    protected NewSubscriptionItemBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.featuresLayout = linearLayout;
        this.tvHeader = textView;
        this.tvLabel = textView2;
        this.tvPrice = textView3;
    }

    public static NewSubscriptionItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewSubscriptionItemBinding bind(View view, Object obj) {
        return (NewSubscriptionItemBinding) ViewDataBinding.bind(obj, view, R.layout.new_subscription_item);
    }
}
