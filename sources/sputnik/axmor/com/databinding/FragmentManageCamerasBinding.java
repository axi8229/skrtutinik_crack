package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentManageCamerasBinding implements ViewBinding {
    public final Button btnCameras;
    public final Button btnCamerasInWidget;
    public final AppCompatButton btnSave;
    public final ImageButton btnSettings;
    public final LinearLayout layoutTabs;
    public final ConstraintLayout root;
    private final LinearLayout rootView;
    public final RecyclerView rvCameras;
    public final RecyclerView rvCamerasInWidget;
    public final NestedScrollView scrollView;
    public final LinearLayout serviceLoader;
    public final TextView textView3;
    public final Toolbar toolbar;

    private FragmentManageCamerasBinding(LinearLayout linearLayout, Button button, Button button2, AppCompatButton appCompatButton, ImageButton imageButton, LinearLayout linearLayout2, ConstraintLayout constraintLayout, RecyclerView recyclerView, RecyclerView recyclerView2, NestedScrollView nestedScrollView, LinearLayout linearLayout3, TextView textView, Toolbar toolbar) {
        this.rootView = linearLayout;
        this.btnCameras = button;
        this.btnCamerasInWidget = button2;
        this.btnSave = appCompatButton;
        this.btnSettings = imageButton;
        this.layoutTabs = linearLayout2;
        this.root = constraintLayout;
        this.rvCameras = recyclerView;
        this.rvCamerasInWidget = recyclerView2;
        this.scrollView = nestedScrollView;
        this.serviceLoader = linearLayout3;
        this.textView3 = textView;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentManageCamerasBinding bind(View view) {
        int i = R.id.btn_cameras;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.btn_cameras);
        if (button != null) {
            i = R.id.btn_cameras_in_widget;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.btn_cameras_in_widget);
            if (button2 != null) {
                i = R.id.btn_save;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_save);
                if (appCompatButton != null) {
                    i = R.id.btn_settings;
                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.btn_settings);
                    if (imageButton != null) {
                        i = R.id.layout_tabs;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_tabs);
                        if (linearLayout != null) {
                            i = R.id.root;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.root);
                            if (constraintLayout != null) {
                                i = R.id.rv_cameras;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_cameras);
                                if (recyclerView != null) {
                                    i = R.id.rv_cameras_in_widget;
                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_cameras_in_widget);
                                    if (recyclerView2 != null) {
                                        i = R.id.scroll_view;
                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                                        if (nestedScrollView != null) {
                                            i = R.id.serviceLoader;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.serviceLoader);
                                            if (linearLayout2 != null) {
                                                i = R.id.textView3;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView3);
                                                if (textView != null) {
                                                    i = R.id.toolbar;
                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                    if (toolbar != null) {
                                                        return new FragmentManageCamerasBinding((LinearLayout) view, button, button2, appCompatButton, imageButton, linearLayout, constraintLayout, recyclerView, recyclerView2, nestedScrollView, linearLayout2, textView, toolbar);
                                                    }
                                                }
                                            }
                                        }
                                    }
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
