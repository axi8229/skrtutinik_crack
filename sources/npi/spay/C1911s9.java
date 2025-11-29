package npi.spay;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* renamed from: npi.spay.s9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1911s9 implements ViewBinding {
    public final ConstraintLayout a;
    public final MaterialButton b;
    public final MaterialButton c;

    public C1911s9(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2) {
        this.a = constraintLayout;
        this.b = materialButton;
        this.c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
