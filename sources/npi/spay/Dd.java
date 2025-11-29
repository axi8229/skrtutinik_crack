package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class Dd implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;

    public Dd(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
