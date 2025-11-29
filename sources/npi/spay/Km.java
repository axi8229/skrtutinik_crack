package npi.spay;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class Km implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final ConstraintLayout c;
    public final TextView d;
    public final CardView e;
    public final WebView f;

    public Km(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, TextView textView, CardView cardView, WebView webView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = constraintLayout2;
        this.d = textView;
        this.e = cardView;
        this.f = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
