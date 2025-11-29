package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class CallHistoryPromoBinding extends ViewDataBinding {
    public final AppCompatButton btnSubscribe;
    public final ImageView imageView16;
    public final ImageView imageView17;
    public final ImageView imageView18;
    public final ImageView imageView19;
    public final ImageView imageView20;
    public final ImageView imageView21;
    public final TextView tvPromo1;
    public final TextView tvPromo2;
    public final TextView tvVisitsInfo;

    protected CallHistoryPromoBinding(Object obj, View view, int i, AppCompatButton appCompatButton, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.btnSubscribe = appCompatButton;
        this.imageView16 = imageView;
        this.imageView17 = imageView2;
        this.imageView18 = imageView3;
        this.imageView19 = imageView4;
        this.imageView20 = imageView5;
        this.imageView21 = imageView6;
        this.tvPromo1 = textView;
        this.tvPromo2 = textView2;
        this.tvVisitsInfo = textView3;
    }

    public static CallHistoryPromoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CallHistoryPromoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CallHistoryPromoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.call_history_promo, viewGroup, z, obj);
    }
}
