package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetArchiveDoesntExistsBinding implements ViewBinding {
    public final Button btnSubscribe;
    public final ImageView imageView4;
    public final CoordinatorLayout layoutSnackbar;
    public final LinearLayout linearLayout2;
    private final ScrollView rootView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private BottomSheetArchiveDoesntExistsBinding(ScrollView scrollView, Button button, ImageView imageView, CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.btnSubscribe = button;
        this.imageView4 = imageView;
        this.layoutSnackbar = coordinatorLayout;
        this.linearLayout2 = linearLayout;
        this.tvSubtitle = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetArchiveDoesntExistsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_archive_doesnt_exists, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetArchiveDoesntExistsBinding bind(View view) {
        int i = R$id.btn_subscribe;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R$id.imageView4;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R$id.layout_snackbar;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, i);
                if (coordinatorLayout != null) {
                    i = R$id.linearLayout2;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R$id.tv_subtitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R$id.tv_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new BottomSheetArchiveDoesntExistsBinding((ScrollView) view, button, imageView, coordinatorLayout, linearLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
