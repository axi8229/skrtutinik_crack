package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentCamerasPreviewBinding implements ViewBinding {
    public final ImageButton btnSettings;
    public final LinearLayout layoutLoader;
    public final ConstraintLayout root;
    private final LinearLayout rootView;
    public final RecyclerView rvCameras;
    public final NestedScrollView scrollView;
    public final TextView textView3;
    public final Toolbar toolbar;

    private FragmentCamerasPreviewBinding(LinearLayout linearLayout, ImageButton imageButton, LinearLayout linearLayout2, ConstraintLayout constraintLayout, RecyclerView recyclerView, NestedScrollView nestedScrollView, TextView textView, Toolbar toolbar) {
        this.rootView = linearLayout;
        this.btnSettings = imageButton;
        this.layoutLoader = linearLayout2;
        this.root = constraintLayout;
        this.rvCameras = recyclerView;
        this.scrollView = nestedScrollView;
        this.textView3 = textView;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCamerasPreviewBinding bind(View view) {
        int i = R.id.btn_settings;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.btn_settings);
        if (imageButton != null) {
            i = R.id.layout_loader;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_loader);
            if (linearLayout != null) {
                i = R.id.root;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.root);
                if (constraintLayout != null) {
                    i = R.id.rv_cameras;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_cameras);
                    if (recyclerView != null) {
                        i = R.id.scroll_view;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                        if (nestedScrollView != null) {
                            i = R.id.textView3;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView3);
                            if (textView != null) {
                                i = R.id.toolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                if (toolbar != null) {
                                    return new FragmentCamerasPreviewBinding((LinearLayout) view, imageButton, linearLayout, constraintLayout, recyclerView, nestedScrollView, textView, toolbar);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
