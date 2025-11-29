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
public abstract class ItemMarketKeyBinding extends ViewDataBinding {
    public final ConstraintLayout cardRoot;
    public final ImageView imageView23;
    protected MarketItem mItem;
    public final TextView tvOpenCatalog;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    protected ItemMarketKeyBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.cardRoot = constraintLayout;
        this.imageView23 = imageView;
        this.tvOpenCatalog = textView;
        this.tvSubtitle = textView2;
        this.tvTitle = textView3;
    }

    public static ItemMarketKeyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMarketKeyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMarketKeyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_market_key, viewGroup, z, obj);
    }
}
