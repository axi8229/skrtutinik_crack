package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentExperimentalBinding implements ViewBinding {
    public final ImageView btnBack;
    private final ConstraintLayout rootView;
    public final SwitchCompat switchWebrtc;
    public final Toolbar toolbar;

    private FragmentExperimentalBinding(ConstraintLayout constraintLayout, ImageView imageView, SwitchCompat switchCompat, Toolbar toolbar) {
        this.rootView = constraintLayout;
        this.btnBack = imageView;
        this.switchWebrtc = switchCompat;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentExperimentalBinding bind(View view) {
        int i = R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_back);
        if (imageView != null) {
            i = R.id.switch_webrtc;
            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.switch_webrtc);
            if (switchCompat != null) {
                i = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                if (toolbar != null) {
                    return new FragmentExperimentalBinding((ConstraintLayout) view, imageView, switchCompat, toolbar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
