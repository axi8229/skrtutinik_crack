package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.gorserv.GorservCatalog;

/* loaded from: classes5.dex */
public abstract class ItemGorservCategoryBinding extends ViewDataBinding {
    public final ImageView imageView13;
    public final ImageView ivIcon;
    public final ConstraintLayout layoutContent;
    protected GorservCatalog mItem;
    public final TextView tvSelectedCategoryTitle;

    protected ItemGorservCategoryBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.imageView13 = imageView;
        this.ivIcon = imageView2;
        this.layoutContent = constraintLayout;
        this.tvSelectedCategoryTitle = textView;
    }
}
