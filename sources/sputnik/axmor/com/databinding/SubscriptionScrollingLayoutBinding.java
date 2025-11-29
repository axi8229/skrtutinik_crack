package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class SubscriptionScrollingLayoutBinding implements ViewBinding {
    public final View btnAnchor;
    private final NestedScrollView rootView;
    public final RecyclerView rvFeatures;
    public final RecyclerView rvServices;
    public final RecyclerView rvTariffs;
    public final TextView tvAgreement;
    public final TextView tvHeader;
    public final TextView tvIncluded;
    public final TextView tvTariffs;

    private SubscriptionScrollingLayoutBinding(NestedScrollView nestedScrollView, View view, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = nestedScrollView;
        this.btnAnchor = view;
        this.rvFeatures = recyclerView;
        this.rvServices = recyclerView2;
        this.rvTariffs = recyclerView3;
        this.tvAgreement = textView;
        this.tvHeader = textView2;
        this.tvIncluded = textView3;
        this.tvTariffs = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static SubscriptionScrollingLayoutBinding bind(View view) {
        int i = R.id.btn_anchor;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.btn_anchor);
        if (viewFindChildViewById != null) {
            i = R.id.rv_features;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_features);
            if (recyclerView != null) {
                i = R.id.rv_services;
                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_services);
                if (recyclerView2 != null) {
                    i = R.id.rv_tariffs;
                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_tariffs);
                    if (recyclerView3 != null) {
                        i = R.id.tv_agreement;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_agreement);
                        if (textView != null) {
                            i = R.id.tv_header;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_header);
                            if (textView2 != null) {
                                i = R.id.tv_included;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_included);
                                if (textView3 != null) {
                                    i = R.id.tv_tariffs;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_tariffs);
                                    if (textView4 != null) {
                                        return new SubscriptionScrollingLayoutBinding((NestedScrollView) view, viewFindChildViewById, recyclerView, recyclerView2, recyclerView3, textView, textView2, textView3, textView4);
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
