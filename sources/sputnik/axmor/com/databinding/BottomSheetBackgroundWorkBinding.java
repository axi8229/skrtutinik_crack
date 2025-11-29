package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class BottomSheetBackgroundWorkBinding implements ViewBinding {
    public final ImageView ivClose;
    public final LinearLayout layoutManufacturers;
    private final LinearLayout rootView;
    public final View view5;

    private BottomSheetBackgroundWorkBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, View view) {
        this.rootView = linearLayout;
        this.ivClose = imageView;
        this.layoutManufacturers = linearLayout2;
        this.view5 = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetBackgroundWorkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_background_work, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetBackgroundWorkBinding bind(View view) {
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close);
        if (imageView != null) {
            i = R.id.layout_manufacturers;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_manufacturers);
            if (linearLayout != null) {
                i = R.id.view5;
                View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.view5);
                if (viewFindChildViewById != null) {
                    return new BottomSheetBackgroundWorkBinding((LinearLayout) view, imageView, linearLayout, viewFindChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
