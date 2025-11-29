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
public final class BottomSheetMultiAddressAnnounceBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnSupport;
    public final LinearLayout layoutManufacturers;
    private final LinearLayout rootView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;
    public final View view5;

    private BottomSheetMultiAddressAnnounceBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, LinearLayout linearLayout2, TextView textView, TextView textView2, View view) {
        this.rootView = linearLayout;
        this.btnApply = appCompatButton;
        this.btnSupport = appCompatButton2;
        this.layoutManufacturers = linearLayout2;
        this.tvSubtitle = textView;
        this.tvTitle = textView2;
        this.view5 = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetMultiAddressAnnounceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_multi_address_announce, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetMultiAddressAnnounceBinding bind(View view) {
        int i = R.id.btn_apply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_apply);
        if (appCompatButton != null) {
            i = R.id.btn_support;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_support);
            if (appCompatButton2 != null) {
                i = R.id.layout_manufacturers;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_manufacturers);
                if (linearLayout != null) {
                    i = R.id.tv_subtitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                    if (textView != null) {
                        i = R.id.tv_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                        if (textView2 != null) {
                            i = R.id.view5;
                            View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.view5);
                            if (viewFindChildViewById != null) {
                                return new BottomSheetMultiAddressAnnounceBinding((LinearLayout) view, appCompatButton, appCompatButton2, linearLayout, textView, textView2, viewFindChildViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
