package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class BottomSheetSubscriptionNeededForCallsBinding implements ViewBinding {
    public final Button btnSubscribe;
    public final LinearLayout llSubscriptionNeeded;
    private final LinearLayout rootView;
    public final TextView tvTitle;
    public final View view5;

    private BottomSheetSubscriptionNeededForCallsBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, TextView textView, View view) {
        this.rootView = linearLayout;
        this.btnSubscribe = button;
        this.llSubscriptionNeeded = linearLayout2;
        this.tvTitle = textView;
        this.view5 = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetSubscriptionNeededForCallsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_subscription_needed_for_calls, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetSubscriptionNeededForCallsBinding bind(View view) {
        int i = R.id.btn_subscribe;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.btn_subscribe);
        if (button != null) {
            i = R.id.ll_subscription_needed;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_subscription_needed);
            if (linearLayout != null) {
                i = R.id.tv_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                if (textView != null) {
                    i = R.id.view5;
                    View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.view5);
                    if (viewFindChildViewById != null) {
                        return new BottomSheetSubscriptionNeededForCallsBinding((LinearLayout) view, button, linearLayout, textView, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
