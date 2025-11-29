package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.StateFlipViewGroup;

/* loaded from: classes4.dex */
public final class ActivitySberIdBinding implements ViewBinding {
    public final FrameLayout contentContainer;
    public final View emptyContainer;
    private final StateFlipViewGroup rootView;
    public final StateFlipViewGroup stateFlipper;
    public final TopBarDefault topBar;
    public final EmptyStateLargeView waiting;

    private ActivitySberIdBinding(StateFlipViewGroup stateFlipViewGroup, FrameLayout frameLayout, View view, StateFlipViewGroup stateFlipViewGroup2, TopBarDefault topBarDefault, EmptyStateLargeView emptyStateLargeView) {
        this.rootView = stateFlipViewGroup;
        this.contentContainer = frameLayout;
        this.emptyContainer = view;
        this.stateFlipper = stateFlipViewGroup2;
        this.topBar = topBarDefault;
        this.waiting = emptyStateLargeView;
    }

    public static ActivitySberIdBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.content_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.empty_container))) != null) {
            StateFlipViewGroup stateFlipViewGroup = (StateFlipViewGroup) view;
            i = R.id.top_bar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null) {
                i = R.id.waiting;
                EmptyStateLargeView emptyStateLargeView = (EmptyStateLargeView) ViewBindings.findChildViewById(view, i);
                if (emptyStateLargeView != null) {
                    return new ActivitySberIdBinding(stateFlipViewGroup, frameLayout, viewFindChildViewById, stateFlipViewGroup, topBarDefault, emptyStateLargeView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivitySberIdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySberIdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_sber_id, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public StateFlipViewGroup getRoot() {
        return this.rootView;
    }
}
