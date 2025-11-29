package ru.yoomoney.sdk.kassa.payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;

/* loaded from: classes5.dex */
public final class j implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final i c;

    public j(FrameLayout frameLayout, ImageView imageView, i iVar) {
        this.a = frameLayout;
        this.b = imageView;
        this.c = iVar;
    }

    public static j a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewFindChildViewById;
        View viewInflate = layoutInflater.inflate(R$layout.ym_item_payment_option, viewGroup, false);
        viewGroup.addView(viewInflate);
        int i = R$id.delete;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, i);
        if (imageView == null || (viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, (i = R$id.item))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        return new j((FrameLayout) viewInflate, imageView, i.a(viewFindChildViewById));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
