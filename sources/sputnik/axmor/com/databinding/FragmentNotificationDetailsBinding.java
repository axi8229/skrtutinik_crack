package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentNotificationDetailsBinding implements ViewBinding {
    public final LinearLayout layoutButtons;
    public final LinearLayout layoutEmpty;
    private final ConstraintLayout rootView;
    public final Toolbar toolbar;
    public final TextView tvNotificationMessage;
    public final TextView tvNotificationTitle;

    private FragmentNotificationDetailsBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, Toolbar toolbar, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.layoutButtons = linearLayout;
        this.layoutEmpty = linearLayout2;
        this.toolbar = toolbar;
        this.tvNotificationMessage = textView;
        this.tvNotificationTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNotificationDetailsBinding bind(View view) {
        int i = R.id.layout_buttons;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_buttons);
        if (linearLayout != null) {
            i = R.id.layout_empty;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_empty);
            if (linearLayout2 != null) {
                i = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                if (toolbar != null) {
                    i = R.id.tv_notification_message;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_notification_message);
                    if (textView != null) {
                        i = R.id.tv_notification_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_notification_title);
                        if (textView2 != null) {
                            return new FragmentNotificationDetailsBinding((ConstraintLayout) view, linearLayout, linearLayout2, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
