package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes4.dex */
public final class T9 implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final MaterialButton d;
    public final MaterialButton e;

    public T9(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, MaterialButton materialButton, MaterialButton materialButton2) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
        this.d = materialButton;
        this.e = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
