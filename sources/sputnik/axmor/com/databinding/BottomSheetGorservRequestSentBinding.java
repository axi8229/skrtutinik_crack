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
public final class BottomSheetGorservRequestSentBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    private final LinearLayout rootView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private BottomSheetGorservRequestSentBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnApply = appCompatButton;
        this.tvSubtitle = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetGorservRequestSentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_gorserv_request_sent, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetGorservRequestSentBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.tv_subtitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
            if (textView != null) {
                i = R.id.tv_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                if (textView2 != null) {
                    return new BottomSheetGorservRequestSentBinding((LinearLayout) view, appCompatButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
