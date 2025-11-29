package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class BottomSheetRatePollBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnCancel;
    public final ImageButton btnStar1;
    public final ImageButton btnStar2;
    public final ImageButton btnStar3;
    public final ImageButton btnStar4;
    public final ImageButton btnStar5;
    public final LinearLayout constraintLayout4;
    public final LinearLayout constraintLayout5;
    public final EditText etComment;
    public final ImageView imageView10;
    public final ConstraintLayout layoutAttention;
    public final ConstraintLayout layoutComment;
    public final ScrollView layoutContent;
    public final LinearLayout layoutProgress;
    public final LinearLayout layoutStars;
    public final NestedScrollView layoutTroubles;
    public final ProgressBar pbLoader;
    private final LinearLayout rootView;
    public final RecyclerView rvReasons;
    public final TextView tvComment;
    public final TextView tvCounter;
    public final TextView tvHint;
    public final TextView tvRateApp;
    public final TextView tvTellUs;
    public final TextView tvTitle;
    public final View viewLine;

    private BottomSheetRatePollBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, LinearLayout linearLayout2, LinearLayout linearLayout3, EditText editText, ImageView imageView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ScrollView scrollView, LinearLayout linearLayout4, LinearLayout linearLayout5, NestedScrollView nestedScrollView, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view) {
        this.rootView = linearLayout;
        this.btnApply = appCompatButton;
        this.btnCancel = appCompatButton2;
        this.btnStar1 = imageButton;
        this.btnStar2 = imageButton2;
        this.btnStar3 = imageButton3;
        this.btnStar4 = imageButton4;
        this.btnStar5 = imageButton5;
        this.constraintLayout4 = linearLayout2;
        this.constraintLayout5 = linearLayout3;
        this.etComment = editText;
        this.imageView10 = imageView;
        this.layoutAttention = constraintLayout;
        this.layoutComment = constraintLayout2;
        this.layoutContent = scrollView;
        this.layoutProgress = linearLayout4;
        this.layoutStars = linearLayout5;
        this.layoutTroubles = nestedScrollView;
        this.pbLoader = progressBar;
        this.rvReasons = recyclerView;
        this.tvComment = textView;
        this.tvCounter = textView2;
        this.tvHint = textView3;
        this.tvRateApp = textView4;
        this.tvTellUs = textView5;
        this.tvTitle = textView6;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetRatePollBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_rate_poll, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetRatePollBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.btn_cancel;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_cancel);
            if (appCompatButton2 != null) {
                i = R.id.btn_star_1;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.btn_star_1);
                if (imageButton != null) {
                    i = R.id.btn_star_2;
                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.btn_star_2);
                    if (imageButton2 != null) {
                        i = R.id.btn_star_3;
                        ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.btn_star_3);
                        if (imageButton3 != null) {
                            i = R.id.btn_star_4;
                            ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, R.id.btn_star_4);
                            if (imageButton4 != null) {
                                i = R.id.btn_star_5;
                                ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(view, R.id.btn_star_5);
                                if (imageButton5 != null) {
                                    i = R.id.constraintLayout4;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout4);
                                    if (linearLayout != null) {
                                        i = R.id.constraintLayout5;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout5);
                                        if (linearLayout2 != null) {
                                            i = R.id.et_comment;
                                            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_comment);
                                            if (editText != null) {
                                                i = R.id.imageView10;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView10);
                                                if (imageView != null) {
                                                    i = R.id.layout_attention;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_attention);
                                                    if (constraintLayout != null) {
                                                        i = R.id.layout_comment;
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_comment);
                                                        if (constraintLayout2 != null) {
                                                            i = R.id.layout_content;
                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.layout_content);
                                                            if (scrollView != null) {
                                                                i = R.id.layout_progress;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_progress);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.layout_stars;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_stars);
                                                                    if (linearLayout4 != null) {
                                                                        i = R.id.layout_troubles;
                                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.layout_troubles);
                                                                        if (nestedScrollView != null) {
                                                                            i = R.id.pb_loader;
                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_loader);
                                                                            if (progressBar != null) {
                                                                                i = R.id.rv_reasons;
                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_reasons);
                                                                                if (recyclerView != null) {
                                                                                    i = R.id.tv_comment;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_comment);
                                                                                    if (textView != null) {
                                                                                        i = R.id.tv_counter;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_counter);
                                                                                        if (textView2 != null) {
                                                                                            i = R.id.tv_hint;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_hint);
                                                                                            if (textView3 != null) {
                                                                                                i = R.id.tv_rate_app;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_rate_app);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.tv_tell_us;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_tell_us);
                                                                                                    if (textView5 != null) {
                                                                                                        i = R.id.tv_title;
                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                                                                                        if (textView6 != null) {
                                                                                                            i = R.id.view_line;
                                                                                                            View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.view_line);
                                                                                                            if (viewFindChildViewById != null) {
                                                                                                                return new BottomSheetRatePollBinding((LinearLayout) view, appCompatButton, appCompatButton2, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, linearLayout, linearLayout2, editText, imageView, constraintLayout, constraintLayout2, scrollView, linearLayout3, linearLayout4, nestedScrollView, progressBar, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, viewFindChildViewById);
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
