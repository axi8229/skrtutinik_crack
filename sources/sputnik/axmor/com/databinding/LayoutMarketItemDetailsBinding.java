package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class LayoutMarketItemDetailsBinding implements ViewBinding {
    public final View btnAnchor;
    public final ConstraintLayout constraintLayout;
    public final ConstraintLayout constraintLayout3;
    public final ImageView imageView;
    public final ImageView imageView2;
    public final ImageView ivMain;
    public final LinearLayout layout1;
    public final ConstraintLayout layoutAttention;
    public final LinearLayout layoutFeatures;
    public final LinearLayout layoutFeaturesSecond;
    public final ConstraintLayout linearLayout;
    private final NestedScrollView rootView;
    public final TextView tvAttention;
    public final TextView tvTitle1;
    public final TextView tvTitleSub;
    public final NestedScrollView viewMain;

    private LayoutMarketItemDetailsBinding(NestedScrollView nestedScrollView, View view, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, ConstraintLayout constraintLayout3, LinearLayout linearLayout2, LinearLayout linearLayout3, ConstraintLayout constraintLayout4, TextView textView, TextView textView2, TextView textView3, NestedScrollView nestedScrollView2) {
        this.rootView = nestedScrollView;
        this.btnAnchor = view;
        this.constraintLayout = constraintLayout;
        this.constraintLayout3 = constraintLayout2;
        this.imageView = imageView;
        this.imageView2 = imageView2;
        this.ivMain = imageView3;
        this.layout1 = linearLayout;
        this.layoutAttention = constraintLayout3;
        this.layoutFeatures = linearLayout2;
        this.layoutFeaturesSecond = linearLayout3;
        this.linearLayout = constraintLayout4;
        this.tvAttention = textView;
        this.tvTitle1 = textView2;
        this.tvTitleSub = textView3;
        this.viewMain = nestedScrollView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static LayoutMarketItemDetailsBinding bind(View view) {
        int i = R.id.btn_anchor;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.btn_anchor);
        if (viewFindChildViewById != null) {
            i = R.id.constraintLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout);
            if (constraintLayout != null) {
                i = R.id.constraintLayout3;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout3);
                if (constraintLayout2 != null) {
                    i = R.id.imageView;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView);
                    if (imageView != null) {
                        i = R.id.imageView2;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView2);
                        if (imageView2 != null) {
                            i = R.id.iv_main;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_main);
                            if (imageView3 != null) {
                                i = R.id.layout_1;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_1);
                                if (linearLayout != null) {
                                    i = R.id.layout_attention;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_attention);
                                    if (constraintLayout3 != null) {
                                        i = R.id.layout_features;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_features);
                                        if (linearLayout2 != null) {
                                            i = R.id.layout_features_second;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_features_second);
                                            if (linearLayout3 != null) {
                                                i = R.id.linearLayout;
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.linearLayout);
                                                if (constraintLayout4 != null) {
                                                    i = R.id.tv_attention;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_attention);
                                                    if (textView != null) {
                                                        i = R.id.tv_title1;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title1);
                                                        if (textView2 != null) {
                                                            i = R.id.tv_title_sub;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_sub);
                                                            if (textView3 != null) {
                                                                NestedScrollView nestedScrollView = (NestedScrollView) view;
                                                                return new LayoutMarketItemDetailsBinding(nestedScrollView, viewFindChildViewById, constraintLayout, constraintLayout2, imageView, imageView2, imageView3, linearLayout, constraintLayout3, linearLayout2, linearLayout3, constraintLayout4, textView, textView2, textView3, nestedScrollView);
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
