package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* renamed from: npi.spay.p0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1828p0 implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final ConstraintLayout e;

    public C1828p0(AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
