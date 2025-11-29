package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.databinding.LayoutEditTextWithTitleBinding;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentSendInstallSputnikRequestBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final LayoutEditTextWithTitleBinding layoutCity;
    public final LayoutEditTextWithTitleBinding layoutHouse;
    public final LinearLayout layoutPhone;
    public final LayoutEditTextWithTitleBinding layoutStreet;
    public final LinearLayout linearLayout2;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollView;
    public final Toolbar toolbar;
    public final TextView tvAttention;
    public final TextView tvPhone;
    public final TextView tvPhoneTitle;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private FragmentSendInstallSputnikRequestBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, LayoutEditTextWithTitleBinding layoutEditTextWithTitleBinding, LayoutEditTextWithTitleBinding layoutEditTextWithTitleBinding2, LinearLayout linearLayout, LayoutEditTextWithTitleBinding layoutEditTextWithTitleBinding3, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, NestedScrollView nestedScrollView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.btnApply = appCompatButton;
        this.layoutCity = layoutEditTextWithTitleBinding;
        this.layoutHouse = layoutEditTextWithTitleBinding2;
        this.layoutPhone = linearLayout;
        this.layoutStreet = layoutEditTextWithTitleBinding3;
        this.linearLayout2 = linearLayout2;
        this.root = constraintLayout2;
        this.scrollView = nestedScrollView;
        this.toolbar = toolbar;
        this.tvAttention = textView;
        this.tvPhone = textView2;
        this.tvPhoneTitle = textView3;
        this.tvSubtitle = textView4;
        this.tvTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSendInstallSputnikRequestBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.layout_city;
            View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.layout_city);
            if (viewFindChildViewById != null) {
                LayoutEditTextWithTitleBinding layoutEditTextWithTitleBindingBind = LayoutEditTextWithTitleBinding.bind(viewFindChildViewById);
                i = R.id.layout_house;
                View viewFindChildViewById2 = ViewBindings.findChildViewById(view, R.id.layout_house);
                if (viewFindChildViewById2 != null) {
                    LayoutEditTextWithTitleBinding layoutEditTextWithTitleBindingBind2 = LayoutEditTextWithTitleBinding.bind(viewFindChildViewById2);
                    i = R.id.layout_phone;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_phone);
                    if (linearLayout != null) {
                        i = R.id.layout_street;
                        View viewFindChildViewById3 = ViewBindings.findChildViewById(view, R.id.layout_street);
                        if (viewFindChildViewById3 != null) {
                            LayoutEditTextWithTitleBinding layoutEditTextWithTitleBindingBind3 = LayoutEditTextWithTitleBinding.bind(viewFindChildViewById3);
                            i = R.id.linearLayout2;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout2);
                            if (linearLayout2 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                i = R.id.scroll_view;
                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                                if (nestedScrollView != null) {
                                    i = R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (toolbar != null) {
                                        i = R.id.tv_attention;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_attention);
                                        if (textView != null) {
                                            i = R.id.tv_phone;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_phone);
                                            if (textView2 != null) {
                                                i = R.id.tv_phone_title;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_phone_title);
                                                if (textView3 != null) {
                                                    i = R.id.tv_subtitle;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_title;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                                        if (textView5 != null) {
                                                            return new FragmentSendInstallSputnikRequestBinding(constraintLayout, appCompatButton, layoutEditTextWithTitleBindingBind, layoutEditTextWithTitleBindingBind2, linearLayout, layoutEditTextWithTitleBindingBind3, linearLayout2, constraintLayout, nestedScrollView, toolbar, textView, textView2, textView3, textView4, textView5);
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
