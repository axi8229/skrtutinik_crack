package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;

/* loaded from: classes4.dex */
public final class AuthBannerActionBinding implements ViewBinding {
    public final AppCompatImageView bannerImage;
    public final Guideline guideline;
    public final TextBodyView informerAction;
    public final TextBodyView message;
    public final CardView messageCard;
    private final CardView rootView;

    private AuthBannerActionBinding(CardView cardView, AppCompatImageView appCompatImageView, Guideline guideline, TextBodyView textBodyView, TextBodyView textBodyView2, CardView cardView2) {
        this.rootView = cardView;
        this.bannerImage = appCompatImageView;
        this.guideline = guideline;
        this.informerAction = textBodyView;
        this.message = textBodyView2;
        this.messageCard = cardView2;
    }

    public static AuthBannerActionBinding bind(View view) {
        int i = R.id.banner_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.guideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.informer_action;
                TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                if (textBodyView != null) {
                    i = R.id.message;
                    TextBodyView textBodyView2 = (TextBodyView) ViewBindings.findChildViewById(view, i);
                    if (textBodyView2 != null) {
                        CardView cardView = (CardView) view;
                        return new AuthBannerActionBinding(cardView, appCompatImageView, guideline, textBodyView, textBodyView2, cardView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthBannerActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthBannerActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_banner_action, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }
}
