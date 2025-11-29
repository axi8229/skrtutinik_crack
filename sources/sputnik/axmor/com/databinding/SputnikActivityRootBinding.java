package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class SputnikActivityRootBinding implements ViewBinding {
    public final FrameLayout noInternet;
    public final FragmentContainerView rootNavHostFragment;
    private final FrameLayout rootView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private SputnikActivityRootBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FragmentContainerView fragmentContainerView, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.noInternet = frameLayout2;
        this.rootNavHostFragment = fragmentContainerView;
        this.tvSubtitle = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static SputnikActivityRootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SputnikActivityRootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.sputnik_activity_root, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SputnikActivityRootBinding bind(View view) {
        int i = R.id.no_internet;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.no_internet);
        if (frameLayout != null) {
            i = R.id.root_nav_host_fragment;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, R.id.root_nav_host_fragment);
            if (fragmentContainerView != null) {
                i = R.id.tv_subtitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                if (textView != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                    if (textView2 != null) {
                        return new SputnikActivityRootBinding((FrameLayout) view, frameLayout, fragmentContainerView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
