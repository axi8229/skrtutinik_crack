package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentSurveyCloseBinding implements ViewBinding {
    public final TextView bottomTitle;
    public final AppCompatButton btnClose;
    public final ConstraintLayout rootView;
    private final ConstraintLayout rootView_;
    public final LinearLayout topView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private FragmentSurveyCloseBinding(ConstraintLayout constraintLayout, TextView textView, AppCompatButton appCompatButton, ConstraintLayout constraintLayout2, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        this.rootView_ = constraintLayout;
        this.bottomTitle = textView;
        this.btnClose = appCompatButton;
        this.rootView = constraintLayout2;
        this.topView = linearLayout;
        this.tvSubtitle = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView_;
    }

    public static FragmentSurveyCloseBinding bind(View view) {
        int i = R.id.bottom_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bottom_title);
        if (textView != null) {
            i = R.id.btnClose;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnClose);
            if (appCompatButton != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.top_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.top_view);
                if (linearLayout != null) {
                    i = R.id.tv_subtitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                    if (textView2 != null) {
                        i = R.id.tv_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                        if (textView3 != null) {
                            return new FragmentSurveyCloseBinding(constraintLayout, textView, appCompatButton, constraintLayout, linearLayout, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
