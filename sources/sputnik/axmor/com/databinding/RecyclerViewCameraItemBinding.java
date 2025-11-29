package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.camera.Camera;

/* loaded from: classes5.dex */
public abstract class RecyclerViewCameraItemBinding extends ViewDataBinding {
    public final View dividerH;
    public final ImageView ivCameraImage;
    public final ImageView ivHamburger;
    public final ImageView ivLocked;
    protected Camera mItem;
    public final TextView tvCameraAddress;
    public final TextView tvCameraName;
    public final TextView tvOrderNumber;

    protected RecyclerViewCameraItemBinding(Object obj, View view, int i, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.dividerH = view2;
        this.ivCameraImage = imageView;
        this.ivHamburger = imageView2;
        this.ivLocked = imageView3;
        this.tvCameraAddress = textView;
        this.tvCameraName = textView2;
        this.tvOrderNumber = textView3;
    }
}
