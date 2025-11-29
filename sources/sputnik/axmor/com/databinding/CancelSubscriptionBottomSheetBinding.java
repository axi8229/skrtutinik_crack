package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class CancelSubscriptionBottomSheetBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final View divider;
    public final LinearLayout llRefund;
    private final ConstraintLayout rootView;
    public final RecyclerView rvSubscriptionServices;
    public final AppCompatButton subsStopButton;
    public final TextView tvCancelTitle;
    public final TextView tvRefund;
    public final TextView tvRefundValue;
    public final TextView tvSubtitle;
    public final View vSecondDivider;

    private CancelSubscriptionBottomSheetBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, View view, LinearLayout linearLayout, RecyclerView recyclerView, AppCompatButton appCompatButton2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        this.rootView = constraintLayout;
        this.btnApply = appCompatButton;
        this.divider = view;
        this.llRefund = linearLayout;
        this.rvSubscriptionServices = recyclerView;
        this.subsStopButton = appCompatButton2;
        this.tvCancelTitle = textView;
        this.tvRefund = textView2;
        this.tvRefundValue = textView3;
        this.tvSubtitle = textView4;
        this.vSecondDivider = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CancelSubscriptionBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.cancel_subscription_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CancelSubscriptionBottomSheetBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.divider;
            View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.divider);
            if (viewFindChildViewById != null) {
                i = R.id.ll_refund;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_refund);
                if (linearLayout != null) {
                    i = R.id.rv_subscription_services;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_subscription_services);
                    if (recyclerView != null) {
                        i = R.id.subsStopButton;
                        AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.subsStopButton);
                        if (appCompatButton2 != null) {
                            i = R.id.tv_cancel_title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel_title);
                            if (textView != null) {
                                i = R.id.tv_refund;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_refund);
                                if (textView2 != null) {
                                    i = R.id.tv_refund_value;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_refund_value);
                                    if (textView3 != null) {
                                        i = R.id.tv_subtitle;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                                        if (textView4 != null) {
                                            i = R.id.v_second_divider;
                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.v_second_divider);
                                            if (viewFindChildViewById2 != null) {
                                                return new CancelSubscriptionBottomSheetBinding((ConstraintLayout) view, appCompatButton, viewFindChildViewById, linearLayout, recyclerView, appCompatButton2, textView, textView2, textView3, textView4, viewFindChildViewById2);
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
