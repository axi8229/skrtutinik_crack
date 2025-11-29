package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* renamed from: npi.spay.u8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1960u8 implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final MaterialButton c;

    public C1960u8(AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, MaterialButton materialButton) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
