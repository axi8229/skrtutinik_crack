package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class BottomSheetPermissionBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final LinearLayout layoutOptions;
    private final LinearLayout rootView;
    public final TextView tvAttention;
    public final TextView tvTitle;

    private BottomSheetPermissionBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnApply = appCompatButton;
        this.layoutOptions = linearLayout2;
        this.tvAttention = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetPermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_permission, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetPermissionBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.layout_options;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_options);
            if (linearLayout != null) {
                i = R.id.tv_attention;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_attention);
                if (textView != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                    if (textView2 != null) {
                        return new BottomSheetPermissionBinding((LinearLayout) view, appCompatButton, linearLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
