package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentInstructionBinding implements ViewBinding {
    public final LinearLayout layoutBottomButtons2;
    public final LinearLayout layoutViews;
    private final ConstraintLayout rootView;
    public final TextView tvToolbar;

    private FragmentInstructionBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.layoutBottomButtons2 = linearLayout;
        this.layoutViews = linearLayout2;
        this.tvToolbar = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentInstructionBinding bind(View view) {
        int i = R.id.layout_bottom_buttons2;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_bottom_buttons2);
        if (linearLayout != null) {
            i = R.id.layout_views;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_views);
            if (linearLayout2 != null) {
                i = R.id.tv_toolbar;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar);
                if (textView != null) {
                    return new FragmentInstructionBinding((ConstraintLayout) view, linearLayout, linearLayout2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
