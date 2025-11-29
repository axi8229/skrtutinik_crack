package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.keys.PhysicalKey;

/* loaded from: classes5.dex */
public abstract class ItemKeyBinding extends ViewDataBinding {
    public final ImageView ivStatus;
    protected PhysicalKey mItem;
    public final ConstraintLayout relativeLayout3;
    public final TextView tvAddress;
    public final TextView tvKeyHex;

    protected ItemKeyBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivStatus = imageView;
        this.relativeLayout3 = constraintLayout;
        this.tvAddress = textView;
        this.tvKeyHex = textView2;
    }
}
