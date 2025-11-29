package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.StateFlipViewGroup;

/* loaded from: classes4.dex */
public final class ActivityVkIdBinding implements ViewBinding {
    public final ProgressBar progressContainer;
    private final LinearLayout rootView;
    public final StateFlipViewGroup stateFlipper;
    public final TopBarDefault topBar;

    private ActivityVkIdBinding(LinearLayout linearLayout, ProgressBar progressBar, StateFlipViewGroup stateFlipViewGroup, TopBarDefault topBarDefault) {
        this.rootView = linearLayout;
        this.progressContainer = progressBar;
        this.stateFlipper = stateFlipViewGroup;
        this.topBar = topBarDefault;
    }

    public static ActivityVkIdBinding bind(View view) {
        int i = R.id.progress_container;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
        if (progressBar != null) {
            i = R.id.state_flipper;
            StateFlipViewGroup stateFlipViewGroup = (StateFlipViewGroup) ViewBindings.findChildViewById(view, i);
            if (stateFlipViewGroup != null) {
                i = R.id.top_bar;
                TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
                if (topBarDefault != null) {
                    return new ActivityVkIdBinding((LinearLayout) view, progressBar, stateFlipViewGroup, topBarDefault);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityVkIdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityVkIdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_vk_id, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
