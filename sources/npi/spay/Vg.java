package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes4.dex */
public final class Vg implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final MaterialButton c;

    public Vg(AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, MaterialButton materialButton) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
