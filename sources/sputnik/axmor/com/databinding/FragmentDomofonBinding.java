package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentDomofonBinding implements ViewBinding {
    public final ConstraintLayout domofonCallsContainer;
    public final TextView domofonCallsHint;
    public final SwitchCompat domofonCallsValueView;
    public final TextView domofonCallsView;
    public final LinearLayout layoutAddresses;
    public final LinearLayout layoutLoader;
    private final ConstraintLayout rootView;
    public final SwitchCompat switchVideo;
    public final Toolbar toolbar;
    public final TextView tvCalls;
    public final TextView tvCallsSubtitle;
    public final TextView tvVideo;
    public final TextView tvVideoHeader;
    public final TextView tvVideoSubtitle;
    public final ScrollView viewMain;

    private FragmentDomofonBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, SwitchCompat switchCompat, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, SwitchCompat switchCompat2, Toolbar toolbar, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ScrollView scrollView) {
        this.rootView = constraintLayout;
        this.domofonCallsContainer = constraintLayout2;
        this.domofonCallsHint = textView;
        this.domofonCallsValueView = switchCompat;
        this.domofonCallsView = textView2;
        this.layoutAddresses = linearLayout;
        this.layoutLoader = linearLayout2;
        this.switchVideo = switchCompat2;
        this.toolbar = toolbar;
        this.tvCalls = textView3;
        this.tvCallsSubtitle = textView4;
        this.tvVideo = textView5;
        this.tvVideoHeader = textView6;
        this.tvVideoSubtitle = textView7;
        this.viewMain = scrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDomofonBinding bind(View view) {
        int i = R.id.domofon_calls_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.domofon_calls_container);
        if (constraintLayout != null) {
            i = R.id.domofon_calls_hint;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.domofon_calls_hint);
            if (textView != null) {
                i = R.id.domofon_calls_value_view;
                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.domofon_calls_value_view);
                if (switchCompat != null) {
                    i = R.id.domofon_calls_view;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.domofon_calls_view);
                    if (textView2 != null) {
                        i = R.id.layout_addresses;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_addresses);
                        if (linearLayout != null) {
                            i = R.id.layout_loader;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_loader);
                            if (linearLayout2 != null) {
                                i = R.id.switch_video;
                                SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.switch_video);
                                if (switchCompat2 != null) {
                                    i = R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (toolbar != null) {
                                        i = R.id.tv_calls;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_calls);
                                        if (textView3 != null) {
                                            i = R.id.tv_calls_subtitle;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_calls_subtitle);
                                            if (textView4 != null) {
                                                i = R.id.tv_video;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_video);
                                                if (textView5 != null) {
                                                    i = R.id.tv_video_header;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_video_header);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_video_subtitle;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_video_subtitle);
                                                        if (textView7 != null) {
                                                            i = R.id.viewMain;
                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.viewMain);
                                                            if (scrollView != null) {
                                                                return new FragmentDomofonBinding((ConstraintLayout) view, constraintLayout, textView, switchCompat, textView2, linearLayout, linearLayout2, switchCompat2, toolbar, textView3, textView4, textView5, textView6, textView7, scrollView);
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
