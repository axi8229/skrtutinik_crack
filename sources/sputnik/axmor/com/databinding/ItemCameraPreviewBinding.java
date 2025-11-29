package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.entities.camera.Camera;

/* loaded from: classes5.dex */
public abstract class ItemCameraPreviewBinding extends ViewDataBinding {
    public final ImageView ivCameraImage;
    public final ImageView ivLocked;
    public final ImageView ivNoImage;
    public final LinearLayout layoutError;
    public final LinearLayout linearLayout10;
    protected Camera mItem;
    public final TextView tvCameraName;
    public final View viewDim;

    protected ItemCameraPreviewBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, View view2) {
        super(obj, view, i);
        this.ivCameraImage = imageView;
        this.ivLocked = imageView2;
        this.ivNoImage = imageView3;
        this.layoutError = linearLayout;
        this.linearLayout10 = linearLayout2;
        this.tvCameraName = textView;
        this.viewDim = view2;
    }
}
