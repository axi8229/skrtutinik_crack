package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes4.dex */
public final class Q0 implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final MaterialButton e;

    public Q0(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, MaterialButton materialButton) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = appCompatTextView3;
        this.e = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
