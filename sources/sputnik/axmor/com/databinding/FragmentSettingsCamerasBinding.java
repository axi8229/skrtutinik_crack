package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentSettingsCamerasBinding implements ViewBinding {
    public final AppCompatButton btnSave;
    public final EditText etName;
    public final ImageView ivMainCamera;
    public final LinearLayout lMainWidget;
    public final LinearLayout layoutName;
    public final ScrollView root;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final TextView tvAddressTitle;
    public final TextView tvDoorTitle;
    public final LinearLayout viewWait;

    private FragmentSettingsCamerasBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, EditText editText, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, ScrollView scrollView, Toolbar toolbar, TextView textView, TextView textView2, LinearLayout linearLayout4) {
        this.rootView = linearLayout;
        this.btnSave = appCompatButton;
        this.etName = editText;
        this.ivMainCamera = imageView;
        this.lMainWidget = linearLayout2;
        this.layoutName = linearLayout3;
        this.root = scrollView;
        this.toolbar = toolbar;
        this.tvAddressTitle = textView;
        this.tvDoorTitle = textView2;
        this.viewWait = linearLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSettingsCamerasBinding bind(View view) {
        int i = R.id.btnSave;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnSave);
        if (appCompatButton != null) {
            i = R.id.etName;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.etName);
            if (editText != null) {
                i = R.id.iv_main_camera;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_main_camera);
                if (imageView != null) {
                    i = R.id.l_main_widget;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.l_main_widget);
                    if (linearLayout != null) {
                        i = R.id.layoutName;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layoutName);
                        if (linearLayout2 != null) {
                            i = R.id.root;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.root);
                            if (scrollView != null) {
                                i = R.id.toolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                if (toolbar != null) {
                                    i = R.id.tvAddressTitle;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tvAddressTitle);
                                    if (textView != null) {
                                        i = R.id.tv_door_title;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_door_title);
                                        if (textView2 != null) {
                                            i = R.id.viewWait;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.viewWait);
                                            if (linearLayout3 != null) {
                                                return new FragmentSettingsCamerasBinding((LinearLayout) view, appCompatButton, editText, imageView, linearLayout, linearLayout2, scrollView, toolbar, textView, textView2, linearLayout3);
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
