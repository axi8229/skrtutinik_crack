package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentNotificationsBinding implements ViewBinding {
    public final LinearLayout layoutEmpty;
    public final LinearLayout layoutLoader;
    private final ConstraintLayout rootView;
    public final RecyclerView rvNotifications;
    public final Toolbar toolbar;
    public final TextView tvNotificationsEmpty;
    public final TextView tvNotificationsEmptyDetails;

    private FragmentNotificationsBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.layoutEmpty = linearLayout;
        this.layoutLoader = linearLayout2;
        this.rvNotifications = recyclerView;
        this.toolbar = toolbar;
        this.tvNotificationsEmpty = textView;
        this.tvNotificationsEmptyDetails = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNotificationsBinding bind(View view) {
        int i = R.id.layout_empty;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_empty);
        if (linearLayout != null) {
            i = R.id.layout_loader;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_loader);
            if (linearLayout2 != null) {
                i = R.id.rv_notifications;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_notifications);
                if (recyclerView != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (toolbar != null) {
                        i = R.id.tv_notifications_empty;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_notifications_empty);
                        if (textView != null) {
                            i = R.id.tv_notifications_empty_details;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_notifications_empty_details);
                            if (textView2 != null) {
                                return new FragmentNotificationsBinding((ConstraintLayout) view, linearLayout, linearLayout2, recyclerView, toolbar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
