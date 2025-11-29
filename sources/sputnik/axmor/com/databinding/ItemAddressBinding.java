package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.addresses.UserAddress;

/* loaded from: classes5.dex */
public abstract class ItemAddressBinding extends ViewDataBinding {
    public final ImageView btnUnbind;
    public final ImageView ivChecked;
    public final ImageView ivStatus;
    public final ConstraintLayout layoutItem;
    protected UserAddress mItem;
    public final ConstraintLayout relativeLayout3;
    public final TextView tvAddress;

    protected ItemAddressBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView) {
        super(obj, view, i);
        this.btnUnbind = imageView;
        this.ivChecked = imageView2;
        this.ivStatus = imageView3;
        this.layoutItem = constraintLayout;
        this.relativeLayout3 = constraintLayout2;
        this.tvAddress = textView;
    }
}
