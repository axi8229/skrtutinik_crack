package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentSelectGorservCategoryBinding implements ViewBinding {
    public final ImageView btnAbout;
    public final ImageView btnBack;
    public final ImageView ivClose;
    public final LinearLayout layoutEmpty;
    public final ConstraintLayout layoutHowItWorks;
    public final LinearLayout layoutLoader;
    public final ConstraintLayout layoutMain;
    public final NestedScrollView nestedScrollView2;
    private final ConstraintLayout rootView;
    public final RecyclerView rvCategories;
    public final ConstraintLayout toolbar;
    public final TextView tvCallHint;
    public final TextView tvEmptySubtitle;
    public final TextView tvEmptyTitle;
    public final TextView tvGorservTitle;
    public final TextView tvHowItWorksSubtitle;
    public final TextView tvHowItWorksTitle;
    public final TextView tvPhone;
    public final TextView tvToolbarTitle;
    public final TextView tvUserPhone;

    private FragmentSelectGorservCategoryBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, ConstraintLayout constraintLayout3, NestedScrollView nestedScrollView, RecyclerView recyclerView, ConstraintLayout constraintLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.btnAbout = imageView;
        this.btnBack = imageView2;
        this.ivClose = imageView3;
        this.layoutEmpty = linearLayout;
        this.layoutHowItWorks = constraintLayout2;
        this.layoutLoader = linearLayout2;
        this.layoutMain = constraintLayout3;
        this.nestedScrollView2 = nestedScrollView;
        this.rvCategories = recyclerView;
        this.toolbar = constraintLayout4;
        this.tvCallHint = textView;
        this.tvEmptySubtitle = textView2;
        this.tvEmptyTitle = textView3;
        this.tvGorservTitle = textView4;
        this.tvHowItWorksSubtitle = textView5;
        this.tvHowItWorksTitle = textView6;
        this.tvPhone = textView7;
        this.tvToolbarTitle = textView8;
        this.tvUserPhone = textView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSelectGorservCategoryBinding bind(View view) {
        int i = R.id.btn_about;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_about);
        if (imageView != null) {
            i = R.id.btn_back;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_back);
            if (imageView2 != null) {
                i = R.id.iv_close;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close);
                if (imageView3 != null) {
                    i = R.id.layout_empty;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_empty);
                    if (linearLayout != null) {
                        i = R.id.layout_how_it_works;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_how_it_works);
                        if (constraintLayout != null) {
                            i = R.id.layout_loader;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_loader);
                            if (linearLayout2 != null) {
                                i = R.id.layout_main;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_main);
                                if (constraintLayout2 != null) {
                                    i = R.id.nestedScrollView2;
                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nestedScrollView2);
                                    if (nestedScrollView != null) {
                                        i = R.id.rv_categories;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_categories);
                                        if (recyclerView != null) {
                                            i = R.id.toolbar;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.toolbar);
                                            if (constraintLayout3 != null) {
                                                i = R.id.tv_call_hint;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_call_hint);
                                                if (textView != null) {
                                                    i = R.id.tv_empty_subtitle;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_empty_subtitle);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_empty_title;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_empty_title);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_gorserv_title;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_gorserv_title);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_how_it_works_subtitle;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_how_it_works_subtitle);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_how_it_works_title;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_how_it_works_title);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_phone;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_phone);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tv_toolbar_title;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title);
                                                                            if (textView8 != null) {
                                                                                i = R.id.tv_user_phone;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_user_phone);
                                                                                if (textView9 != null) {
                                                                                    return new FragmentSelectGorservCategoryBinding((ConstraintLayout) view, imageView, imageView2, imageView3, linearLayout, constraintLayout, linearLayout2, constraintLayout2, nestedScrollView, recyclerView, constraintLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
