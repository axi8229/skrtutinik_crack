package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.market.items.MarketItem;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class ItemMarketElementBinding extends ViewDataBinding {
    public final ConstraintLayout cardRoot;
    public final ImageView imageView23;
    protected MarketItem mItem;
    public final TextView tvOpenCatalog;
    public final TextView tvTitle;

    protected ItemMarketElementBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cardRoot = constraintLayout;
        this.imageView23 = imageView;
        this.tvOpenCatalog = textView;
        this.tvTitle = textView2;
    }

    public static ItemMarketElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMarketElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMarketElementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_market_element, viewGroup, z, obj);
    }
}
