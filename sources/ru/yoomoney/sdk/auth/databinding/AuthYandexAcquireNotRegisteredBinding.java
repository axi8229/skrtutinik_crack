package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;
import ru.yoomoney.sdk.gui.widgetV2.list.item_action.ItemActionView;

/* loaded from: classes4.dex */
public final class AuthYandexAcquireNotRegisteredBinding implements ViewBinding {
    public final PrimaryButtonView actionButton;
    public final TopBarDefault appBar;
    public final ItemActionView contacts;
    public final ItemActionView faq;
    public final ConstraintLayout parent;
    private final ConstraintLayout rootView;
    public final TextBodyView text;
    public final TextTitle1View title;

    private AuthYandexAcquireNotRegisteredBinding(ConstraintLayout constraintLayout, PrimaryButtonView primaryButtonView, TopBarDefault topBarDefault, ItemActionView itemActionView, ItemActionView itemActionView2, ConstraintLayout constraintLayout2, TextBodyView textBodyView, TextTitle1View textTitle1View) {
        this.rootView = constraintLayout;
        this.actionButton = primaryButtonView;
        this.appBar = topBarDefault;
        this.contacts = itemActionView;
        this.faq = itemActionView2;
        this.parent = constraintLayout2;
        this.text = textBodyView;
        this.title = textTitle1View;
    }

    public static AuthYandexAcquireNotRegisteredBinding bind(View view) {
        int i = R.id.actionButton;
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) ViewBindings.findChildViewById(view, i);
        if (primaryButtonView != null) {
            i = R.id.appBar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null) {
                i = R.id.contacts;
                ItemActionView itemActionView = (ItemActionView) ViewBindings.findChildViewById(view, i);
                if (itemActionView != null) {
                    i = R.id.faq;
                    ItemActionView itemActionView2 = (ItemActionView) ViewBindings.findChildViewById(view, i);
                    if (itemActionView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.text;
                        TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                        if (textBodyView != null) {
                            i = R.id.title;
                            TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                            if (textTitle1View != null) {
                                return new AuthYandexAcquireNotRegisteredBinding(constraintLayout, primaryButtonView, topBarDefault, itemActionView, itemActionView2, constraintLayout, textBodyView, textTitle1View);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthYandexAcquireNotRegisteredBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthYandexAcquireNotRegisteredBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_yandex_acquire_not_registered, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
