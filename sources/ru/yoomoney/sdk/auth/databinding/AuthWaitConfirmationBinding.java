package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthWaitConfirmationBinding implements ViewBinding {
    public final PrimaryButtonView confirmation;
    public final TextTitle1View header;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final TextBodyView text;
    public final TextBodyView timer;

    private AuthWaitConfirmationBinding(FrameLayout frameLayout, PrimaryButtonView primaryButtonView, TextTitle1View textTitle1View, FrameLayout frameLayout2, TextBodyView textBodyView, TextBodyView textBodyView2) {
        this.rootView = frameLayout;
        this.confirmation = primaryButtonView;
        this.header = textTitle1View;
        this.root = frameLayout2;
        this.text = textBodyView;
        this.timer = textBodyView2;
    }

    public static AuthWaitConfirmationBinding bind(View view) {
        int i = R.id.confirmation;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.header;
            TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
            if (textTitle1View != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                i = R.id.text;
                TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                if (textBodyView != null) {
                    i = R.id.timer;
                    TextBodyView textBodyView2 = (TextBodyView) ViewBindings.findChildViewById(view, i);
                    if (textBodyView2 != null) {
                        return new AuthWaitConfirmationBinding(frameLayout, primaryButtonView, textTitle1View, frameLayout, textBodyView, textBodyView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthWaitConfirmationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthWaitConfirmationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_wait_confirmation, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
