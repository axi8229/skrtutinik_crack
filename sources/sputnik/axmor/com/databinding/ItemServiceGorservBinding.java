package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class ItemServiceGorservBinding implements ViewBinding {
    public final ConstraintLayout cardRoot;
    private final ConstraintLayout rootView;
    public final TextView serviceName;
    public final TabLayout tabs;
    public final TextView tvChooseService;
    public final TextView tvLabel;
    public final TextView tvPartnerLabel;
    public final ViewPager2 viewpager2;

    private ItemServiceGorservBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TabLayout tabLayout, TextView textView2, TextView textView3, TextView textView4, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.cardRoot = constraintLayout2;
        this.serviceName = textView;
        this.tabs = tabLayout;
        this.tvChooseService = textView2;
        this.tvLabel = textView3;
        this.tvPartnerLabel = textView4;
        this.viewpager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemServiceGorservBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_service_gorserv, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemServiceGorservBinding bind(View view) {
        int i = R.id.card_root;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.card_root);
        if (constraintLayout != null) {
            i = R.id.serviceName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.serviceName);
            if (textView != null) {
                i = R.id.tabs;
                TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.tabs);
                if (tabLayout != null) {
                    i = R.id.tv_choose_service;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_choose_service);
                    if (textView2 != null) {
                        i = R.id.tv_label;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_label);
                        if (textView3 != null) {
                            i = R.id.tv_partner_label;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_partner_label);
                            if (textView4 != null) {
                                i = R.id.viewpager2;
                                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.viewpager2);
                                if (viewPager2 != null) {
                                    return new ItemServiceGorservBinding((ConstraintLayout) view, constraintLayout, textView, tabLayout, textView2, textView3, textView4, viewPager2);
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
