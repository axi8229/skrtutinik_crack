package npi.spay;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes4.dex */
public final class Ge implements ViewBinding {
    public final ConstraintLayout a;
    public final MaterialButton b;

    public Ge(ConstraintLayout constraintLayout, MaterialButton materialButton) {
        this.a = constraintLayout;
        this.b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
