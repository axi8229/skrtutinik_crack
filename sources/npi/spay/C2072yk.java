package npi.spay;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

/* renamed from: npi.spay.yk, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2072yk implements ViewBinding {
    public final ConstraintLayout a;
    public final MaterialButton b;
    public final MaterialButton c;
    public final ShapeableImageView d;
    public final TextView e;
    public final TextView f;

    public C2072yk(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2, ShapeableImageView shapeableImageView, TextView textView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = materialButton;
        this.c = materialButton2;
        this.d = shapeableImageView;
        this.e = textView2;
        this.f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
