package ru.yoomoney.sdk.auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;

/* loaded from: classes4.dex */
public final class AuthSelectAccountBinding implements ViewBinding {
    public final TextCaption1View agreement;
    public final TopBarDefault appBar;
    public final RecyclerView list;
    public final ConstraintLayout parent;
    private final ConstraintLayout rootView;
    public final TextBodyView subtitle;
    public final TextTitle1View title;

    private AuthSelectAccountBinding(ConstraintLayout constraintLayout, TextCaption1View textCaption1View, TopBarDefault topBarDefault, RecyclerView recyclerView, ConstraintLayout constraintLayout2, TextBodyView textBodyView, TextTitle1View textTitle1View) {
        this.rootView = constraintLayout;
        this.agreement = textCaption1View;
        this.appBar = topBarDefault;
        this.list = recyclerView;
        this.parent = constraintLayout2;
        this.subtitle = textBodyView;
        this.title = textTitle1View;
    }

    public static AuthSelectAccountBinding bind(View view) {
        int i = R.id.agreement;
        TextCaption1View textCaption1View = (TextCaption1View) ViewBindings.findChildViewById(view, i);
        if (textCaption1View != null) {
            i = R.id.appBar;
            TopBarDefault topBarDefault = (TopBarDefault) ViewBindings.findChildViewById(view, i);
            if (topBarDefault != null) {
                i = R.id.list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.subtitle;
                    TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(view, i);
                    if (textBodyView != null) {
                        i = R.id.title;
                        TextTitle1View textTitle1View = (TextTitle1View) ViewBindings.findChildViewById(view, i);
                        if (textTitle1View != null) {
                            return new AuthSelectAccountBinding(constraintLayout, textCaption1View, topBarDefault, recyclerView, constraintLayout, textBodyView, textTitle1View);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AuthSelectAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuthSelectAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auth_select_account, viewGroup, false);
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
