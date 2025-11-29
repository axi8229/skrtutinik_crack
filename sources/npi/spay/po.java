package npi.spay;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class po implements ViewBinding {
    public final FrameLayout a;
    public final AppCompatImageView b;

    public po(FrameLayout frameLayout, AppCompatImageView appCompatImageView) {
        this.a = frameLayout;
        this.b = appCompatImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
