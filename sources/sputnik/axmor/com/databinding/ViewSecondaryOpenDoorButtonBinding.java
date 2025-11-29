package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public abstract class ViewSecondaryOpenDoorButtonBinding extends ViewDataBinding {
    public final ImageView buttonBackground;
    public final ImageView mainBackground;

    protected ViewSecondaryOpenDoorButtonBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.buttonBackground = imageView;
        this.mainBackground = imageView2;
    }

    public static ViewSecondaryOpenDoorButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewSecondaryOpenDoorButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewSecondaryOpenDoorButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_secondary_open_door_button, viewGroup, z, obj);
    }
}
