package ru.yoomoney.sdk.kassa.payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.ui.view.YmProgressBar;

/* loaded from: classes5.dex */
public final class o implements ViewBinding {
    public final LinearLayout a;
    public final TextBodyView b;

    public o(LinearLayout linearLayout, TextBodyView textBodyView) {
        this.a = linearLayout;
        this.b = textBodyView;
    }

    public static o a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R$layout.ym_view_loading, viewGroup, false);
        viewGroup.addView(viewInflate);
        int i = R$id.progressBar;
        if (((YmProgressBar) ViewBindings.findChildViewById(viewInflate, i)) != null) {
            i = R$id.textView;
            TextBodyView textBodyView = (TextBodyView) ViewBindings.findChildViewById(viewInflate, i);
            if (textBodyView != null) {
                return new o((LinearLayout) viewInflate, textBodyView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
