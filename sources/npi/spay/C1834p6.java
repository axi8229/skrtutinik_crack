package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* renamed from: npi.spay.p6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1834p6 implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;

    public C1834p6(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
