package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentFaqBinding implements ViewBinding {
    public final LinearLayout layoutEmpty;
    public final LinearLayout layoutLoader;
    private final NestedScrollView rootView;
    public final RecyclerView rvNotifications;
    public final Toolbar toolbar;
    public final TextView tvEmptySubtitle;
    public final TextView tvEmptyTitle;
    public final TextView tvTitle;

    private FragmentFaqBinding(NestedScrollView nestedScrollView, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = nestedScrollView;
        this.layoutEmpty = linearLayout;
        this.layoutLoader = linearLayout2;
        this.rvNotifications = recyclerView;
        this.toolbar = toolbar;
        this.tvEmptySubtitle = textView;
        this.tvEmptyTitle = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentFaqBinding bind(View view) {
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
                        i = R.id.tv_empty_subtitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_empty_subtitle);
                        if (textView != null) {
                            i = R.id.tv_empty_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_empty_title);
                            if (textView2 != null) {
                                i = R.id.tv_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                if (textView3 != null) {
                                    return new FragmentFaqBinding((NestedScrollView) view, linearLayout, linearLayout2, recyclerView, toolbar, textView, textView2, textView3);
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
