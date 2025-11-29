package ru.yoomoney.sdk.kassa.payments.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.yoomoney.sdk.kassa.payments.R$id;

/* loaded from: classes5.dex */
public final class i implements ViewBinding {
    public final ConstraintLayout a;
    public final b b;
    public final ImageView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;

    public i(ConstraintLayout constraintLayout, b bVar, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = bVar;
        this.c = imageView;
        this.d = imageView2;
        this.e = textView;
        this.f = textView2;
    }

    public static i a(View view) {
        int i = R$id.divider;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            b bVar = new b(viewFindChildViewById);
            i = R$id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R$id.options;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R$id.primaryText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R$id.secondaryText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new i((ConstraintLayout) view, bVar, imageView, imageView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
