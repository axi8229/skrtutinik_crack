package ru.yoomoney.sdk.kassa.payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;

/* loaded from: classes5.dex */
public final class a implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ConstraintLayout c;
    public final ImageView d;
    public final TextView e;

    public a(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = constraintLayout2;
        this.d = imageView2;
        this.e = textView;
    }

    public static a a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R$layout.ym_dialog_top_bar, viewGroup, false);
        viewGroup.addView(viewInflate);
        int i = R$id.backButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
            i = R$id.logo;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, i);
            if (imageView2 != null) {
                i = R$id.paymentTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i);
                if (textView != null) {
                    return new a(constraintLayout, imageView, constraintLayout, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
