package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class InsuranceServiceItemBinding extends ViewDataBinding {
    public final ConstraintLayout cardRoot;
    public final ImageView ivPartner;
    public final LinearLayout lAddition;
    public final TextView serviceAction;
    public final TextView serviceDescription;
    public final TextView serviceExpire;
    public final TextView serviceName;
    public final TextView tvLabel;
    public final TextView tvPartnerLabel;

    protected InsuranceServiceItemBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.cardRoot = constraintLayout;
        this.ivPartner = imageView;
        this.lAddition = linearLayout;
        this.serviceAction = textView;
        this.serviceDescription = textView2;
        this.serviceExpire = textView3;
        this.serviceName = textView4;
        this.tvLabel = textView5;
        this.tvPartnerLabel = textView6;
    }

    public static InsuranceServiceItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static InsuranceServiceItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (InsuranceServiceItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.insurance_service_item, viewGroup, z, obj);
    }
}
