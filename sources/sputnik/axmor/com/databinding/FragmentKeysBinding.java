package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentKeysBinding implements ViewBinding {
    public final AppCompatButton btnRegisterKey;
    public final ImageView imageView22;
    public final ConstraintLayout layoutKeyPromo;
    public final ConstraintLayout layoutRegisterKey;
    public final LinearLayout layoutViews;
    public final ProgressBar pb;
    public final ConstraintLayout rootView;
    private final ConstraintLayout rootView_;
    public final RecyclerView rvKeys;
    public final Toolbar toolbar;
    public final TextView tvEmptyTitle;
    public final TextView tvKeySubtitle;
    public final TextView tvKeyTitle;
    public final TextView tvRegisterKey;
    public final TextView tvTitle;

    private FragmentKeysBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout, ProgressBar progressBar, ConstraintLayout constraintLayout4, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView_ = constraintLayout;
        this.btnRegisterKey = appCompatButton;
        this.imageView22 = imageView;
        this.layoutKeyPromo = constraintLayout2;
        this.layoutRegisterKey = constraintLayout3;
        this.layoutViews = linearLayout;
        this.pb = progressBar;
        this.rootView = constraintLayout4;
        this.rvKeys = recyclerView;
        this.toolbar = toolbar;
        this.tvEmptyTitle = textView;
        this.tvKeySubtitle = textView2;
        this.tvKeyTitle = textView3;
        this.tvRegisterKey = textView4;
        this.tvTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView_;
    }

    public static FragmentKeysBinding bind(View view) {
        int i = R.id.btn_register_key;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_register_key);
        if (appCompatButton != null) {
            i = R.id.imageView22;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView22);
            if (imageView != null) {
                i = R.id.layout_key_promo;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_key_promo);
                if (constraintLayout != null) {
                    i = R.id.layout_register_key;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_register_key);
                    if (constraintLayout2 != null) {
                        i = R.id.layout_views;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_views);
                        if (linearLayout != null) {
                            i = R.id.pb;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb);
                            if (progressBar != null) {
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                                i = R.id.rv_keys;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_keys);
                                if (recyclerView != null) {
                                    i = R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (toolbar != null) {
                                        i = R.id.tv_empty_title;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_empty_title);
                                        if (textView != null) {
                                            i = R.id.tv_key_subtitle;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_key_subtitle);
                                            if (textView2 != null) {
                                                i = R.id.tv_key_title;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_key_title);
                                                if (textView3 != null) {
                                                    i = R.id.tv_register_key;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_register_key);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_title;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                                        if (textView5 != null) {
                                                            return new FragmentKeysBinding(constraintLayout3, appCompatButton, imageView, constraintLayout, constraintLayout2, linearLayout, progressBar, constraintLayout3, recyclerView, toolbar, textView, textView2, textView3, textView4, textView5);
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
