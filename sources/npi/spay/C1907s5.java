package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* renamed from: npi.spay.s5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1907s5 implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;

    public C1907s5(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
