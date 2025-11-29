package ru.yoomoney.sdk.kassa.payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.ui.ItemSwitchView;

/* loaded from: classes5.dex */
public final class n implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final ItemSwitchView c;

    public n(LinearLayout linearLayout, TextView textView, ItemSwitchView itemSwitchView) {
        this.a = linearLayout;
        this.b = textView;
        this.c = itemSwitchView;
    }

    public static n a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R$layout.ym_switch_with_description_view, viewGroup, false);
        viewGroup.addView(viewInflate);
        int i = R$id.descriptionView;
        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i);
        if (textView != null) {
            i = R$id.switchView;
            ItemSwitchView itemSwitchView = (ItemSwitchView) ViewBindings.findChildViewById(viewInflate, i);
            if (itemSwitchView != null) {
                return new n((LinearLayout) viewInflate, textView, itemSwitchView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
