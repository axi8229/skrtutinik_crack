package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
public final class FragmentVisitsBinding implements ViewBinding {
    public final AppCompatButton btnPromo;
    public final AppCompatButton btnSubsGetAccess;
    public final TextView btnWantMore;
    public final TextView btnWantMore2;
    public final ScrollView emptyLayoutVisits;
    public final LinearLayout lInfoArchives;
    public final ConstraintLayout layoutLocked;
    public final ConstraintLayout layoutLocked2;
    public final ConstraintLayout layoutPromo;
    public final ConstraintLayout layoutPromo2;
    public final ConstraintLayout layoutToBlur;
    public final ConstraintLayout layoutToBlur2;
    public final LinearLayout loader;
    public final NestedScrollView nestedScrollView;
    public final ConstraintLayout relativeLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvVisits;
    public final Toolbar toolbar;
    public final TextView tvArchiveInfo;
    public final TextView tvDatePromo;
    public final TextView tvDatePromo2;
    public final TextView tvHistoryCalls;
    public final TextView tvInfo;
    public final TextView tvInfo2;
    public final TextView tvNoCalls;

    private FragmentVisitsBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, TextView textView, TextView textView2, ScrollView scrollView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, LinearLayout linearLayout2, NestedScrollView nestedScrollView, ConstraintLayout constraintLayout8, RecyclerView recyclerView, Toolbar toolbar, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.btnPromo = appCompatButton;
        this.btnSubsGetAccess = appCompatButton2;
        this.btnWantMore = textView;
        this.btnWantMore2 = textView2;
        this.emptyLayoutVisits = scrollView;
        this.lInfoArchives = linearLayout;
        this.layoutLocked = constraintLayout2;
        this.layoutLocked2 = constraintLayout3;
        this.layoutPromo = constraintLayout4;
        this.layoutPromo2 = constraintLayout5;
        this.layoutToBlur = constraintLayout6;
        this.layoutToBlur2 = constraintLayout7;
        this.loader = linearLayout2;
        this.nestedScrollView = nestedScrollView;
        this.relativeLayout = constraintLayout8;
        this.rvVisits = recyclerView;
        this.toolbar = toolbar;
        this.tvArchiveInfo = textView3;
        this.tvDatePromo = textView4;
        this.tvDatePromo2 = textView5;
        this.tvHistoryCalls = textView6;
        this.tvInfo = textView7;
        this.tvInfo2 = textView8;
        this.tvNoCalls = textView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVisitsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_visits, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentVisitsBinding bind(View view) {
        int i = R.id.btn_promo;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_promo);
        if (appCompatButton != null) {
            i = R.id.btnSubsGetAccess;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnSubsGetAccess);
            if (appCompatButton2 != null) {
                i = R.id.btn_want_more;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.btn_want_more);
                if (textView != null) {
                    i = R.id.btn_want_more_2;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.btn_want_more_2);
                    if (textView2 != null) {
                        i = R.id.empty_layout_visits;
                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.empty_layout_visits);
                        if (scrollView != null) {
                            i = R.id.l_info_archives;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.l_info_archives);
                            if (linearLayout != null) {
                                i = R.id.layout_locked;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_locked);
                                if (constraintLayout != null) {
                                    i = R.id.layout_locked_2;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_locked_2);
                                    if (constraintLayout2 != null) {
                                        i = R.id.layout_promo;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_promo);
                                        if (constraintLayout3 != null) {
                                            i = R.id.layout_promo_2;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_promo_2);
                                            if (constraintLayout4 != null) {
                                                i = R.id.layout_to_blur;
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_to_blur);
                                                if (constraintLayout5 != null) {
                                                    i = R.id.layout_to_blur_2;
                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_to_blur_2);
                                                    if (constraintLayout6 != null) {
                                                        i = R.id.loader;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.loader);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.nestedScrollView;
                                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nestedScrollView);
                                                            if (nestedScrollView != null) {
                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) view;
                                                                i = R.id.rv_visits;
                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_visits);
                                                                if (recyclerView != null) {
                                                                    i = R.id.toolbar;
                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                    if (toolbar != null) {
                                                                        i = R.id.tvArchiveInfo;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tvArchiveInfo);
                                                                        if (textView3 != null) {
                                                                            i = R.id.tv_date_promo;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_date_promo);
                                                                            if (textView4 != null) {
                                                                                i = R.id.tv_date_promo_2;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_date_promo_2);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.tv_history_calls;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_history_calls);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.tv_info;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_info);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.tv_info_2;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_info_2);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.tv_no_calls;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_calls);
                                                                                                if (textView9 != null) {
                                                                                                    return new FragmentVisitsBinding(constraintLayout7, appCompatButton, appCompatButton2, textView, textView2, scrollView, linearLayout, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, linearLayout2, nestedScrollView, constraintLayout7, recyclerView, toolbar, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
