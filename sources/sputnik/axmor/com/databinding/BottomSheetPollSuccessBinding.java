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
public final class BottomSheetPollSuccessBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    private BottomSheetPollSuccessBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, TextView textView) {
        this.rootView = linearLayout;
        this.btnApply = appCompatButton;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetPollSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_poll_success, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetPollSuccessBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
            if (textView != null) {
                return new BottomSheetPollSuccessBinding((LinearLayout) view, appCompatButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
