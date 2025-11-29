package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class oo implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final RecyclerView c;

    public oo(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, RecyclerView recyclerView) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
