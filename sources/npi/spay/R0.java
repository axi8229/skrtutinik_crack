package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class R0 implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;

    public R0(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
