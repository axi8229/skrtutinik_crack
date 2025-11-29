package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.market.service.Service;

/* loaded from: classes5.dex */
public abstract class ServiceItemBinding extends ViewDataBinding {
    public final ImageView ivIcon;
    protected Service mItem;
    public final TextView originImage;
    public final TextView serviceImageSub;
    public final TextView serviceTitle;

    protected ServiceItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.ivIcon = imageView;
        this.originImage = textView;
        this.serviceImageSub = textView2;
        this.serviceTitle = textView3;
    }
}
