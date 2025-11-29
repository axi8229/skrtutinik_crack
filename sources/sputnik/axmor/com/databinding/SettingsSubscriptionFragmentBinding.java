package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
public final class SettingsSubscriptionFragmentBinding implements ViewBinding {
    public final WaitingCancelBinding cancelScreen;
    public final ConstraintLayout cardRoot;
    public final LinearLayout itemInactive;
    public final LinearLayout lAddition;
    public final LinearLayout lInfoPrice;
    private final RelativeLayout rootView;
    public final RecyclerView rvSubServices;
    public final NestedScrollView scrollView;
    public final AppCompatButton subsStopButton;
    public final Toolbar toolbar;
    public final TextView tvDateService;
    public final TextView tvInfoCompany;
    public final TextView tvInfoSubTitle;
    public final TextView tvPriceService;
    public final TextView tvSubscriptionPayedUntil;
    public final TextView tvSubscriptionPrice;
    public final TextView tvSubscriptionTitle;
    public final TextView tvTitleItemPaid;

    private SettingsSubscriptionFragmentBinding(RelativeLayout relativeLayout, WaitingCancelBinding waitingCancelBinding, ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, NestedScrollView nestedScrollView, AppCompatButton appCompatButton, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = relativeLayout;
        this.cancelScreen = waitingCancelBinding;
        this.cardRoot = constraintLayout;
        this.itemInactive = linearLayout;
        this.lAddition = linearLayout2;
        this.lInfoPrice = linearLayout3;
        this.rvSubServices = recyclerView;
        this.scrollView = nestedScrollView;
        this.subsStopButton = appCompatButton;
        this.toolbar = toolbar;
        this.tvDateService = textView;
        this.tvInfoCompany = textView2;
        this.tvInfoSubTitle = textView3;
        this.tvPriceService = textView4;
        this.tvSubscriptionPayedUntil = textView5;
        this.tvSubscriptionPrice = textView6;
        this.tvSubscriptionTitle = textView7;
        this.tvTitleItemPaid = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SettingsSubscriptionFragmentBinding bind(View view) {
        int i = R.id.cancel_screen;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.cancel_screen);
        if (viewFindChildViewById != null) {
            WaitingCancelBinding waitingCancelBindingBind = WaitingCancelBinding.bind(viewFindChildViewById);
            i = R.id.card_root;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.card_root);
            if (constraintLayout != null) {
                i = R.id.item_inactive;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.item_inactive);
                if (linearLayout != null) {
                    i = R.id.l_addition;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.l_addition);
                    if (linearLayout2 != null) {
                        i = R.id.l_info_price;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.l_info_price);
                        if (linearLayout3 != null) {
                            i = R.id.rv_sub_services;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_sub_services);
                            if (recyclerView != null) {
                                i = R.id.scroll_view;
                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                                if (nestedScrollView != null) {
                                    i = R.id.subsStopButton;
                                    AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.subsStopButton);
                                    if (appCompatButton != null) {
                                        i = R.id.toolbar;
                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                        if (toolbar != null) {
                                            i = R.id.tvDateService;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tvDateService);
                                            if (textView != null) {
                                                i = R.id.tvInfoCompany;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvInfoCompany);
                                                if (textView2 != null) {
                                                    i = R.id.tv_info_sub_title;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_info_sub_title);
                                                    if (textView3 != null) {
                                                        i = R.id.tvPriceService;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tvPriceService);
                                                        if (textView4 != null) {
                                                            i = R.id.tv_subscription_payed_until;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subscription_payed_until);
                                                            if (textView5 != null) {
                                                                i = R.id.tv_subscription_price;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subscription_price);
                                                                if (textView6 != null) {
                                                                    i = R.id.tv_subscription_title;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subscription_title);
                                                                    if (textView7 != null) {
                                                                        i = R.id.tv_title_item_paid;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_item_paid);
                                                                        if (textView8 != null) {
                                                                            return new SettingsSubscriptionFragmentBinding((RelativeLayout) view, waitingCancelBindingBind, constraintLayout, linearLayout, linearLayout2, linearLayout3, recyclerView, nestedScrollView, appCompatButton, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
