package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class LayoutOurHomeDetailsBinding implements ViewBinding {
    public final View btnAnchor;
    public final ConstraintLayout constraintLayout4;
    public final ConstraintLayout constraintLayout5;
    public final ImageView imageView6;
    public final ImageView imageView7;
    public final ScrollView layoutContent;
    public final LinearLayout linearLayout5;
    public final LinearLayout linearLayout7;
    private final ScrollView rootView;
    public final TextView tvDescription;
    public final TextView tvOurHomeTitle;
    public final TextView tvService1;
    public final TextView tvService2;
    public final TextView tvService3;
    public final TextView tvSputnikTitle;
    public final TextView tvText1;
    public final TextView tvText2;

    private LayoutOurHomeDetailsBinding(ScrollView scrollView, View view, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ScrollView scrollView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = scrollView;
        this.btnAnchor = view;
        this.constraintLayout4 = constraintLayout;
        this.constraintLayout5 = constraintLayout2;
        this.imageView6 = imageView;
        this.imageView7 = imageView2;
        this.layoutContent = scrollView2;
        this.linearLayout5 = linearLayout;
        this.linearLayout7 = linearLayout2;
        this.tvDescription = textView;
        this.tvOurHomeTitle = textView2;
        this.tvService1 = textView3;
        this.tvService2 = textView4;
        this.tvService3 = textView5;
        this.tvSputnikTitle = textView6;
        this.tvText1 = textView7;
        this.tvText2 = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static LayoutOurHomeDetailsBinding bind(View view) {
        int i = R.id.btn_anchor;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.btn_anchor);
        if (viewFindChildViewById != null) {
            i = R.id.constraintLayout4;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout4);
            if (constraintLayout != null) {
                i = R.id.constraintLayout5;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout5);
                if (constraintLayout2 != null) {
                    i = R.id.imageView6;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView6);
                    if (imageView != null) {
                        i = R.id.imageView7;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView7);
                        if (imageView2 != null) {
                            ScrollView scrollView = (ScrollView) view;
                            i = R.id.linearLayout5;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout5);
                            if (linearLayout != null) {
                                i = R.id.linearLayout7;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout7);
                                if (linearLayout2 != null) {
                                    i = R.id.tv_description;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description);
                                    if (textView != null) {
                                        i = R.id.tv_our_home_title;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_our_home_title);
                                        if (textView2 != null) {
                                            i = R.id.tv_service_1;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_service_1);
                                            if (textView3 != null) {
                                                i = R.id.tv_service_2;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_service_2);
                                                if (textView4 != null) {
                                                    i = R.id.tv_service_3;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_service_3);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_sputnik_title;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_sputnik_title);
                                                        if (textView6 != null) {
                                                            i = R.id.tv_text_1;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_text_1);
                                                            if (textView7 != null) {
                                                                i = R.id.tv_text_2;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_text_2);
                                                                if (textView8 != null) {
                                                                    return new LayoutOurHomeDetailsBinding(scrollView, viewFindChildViewById, constraintLayout, constraintLayout2, imageView, imageView2, scrollView, linearLayout, linearLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
