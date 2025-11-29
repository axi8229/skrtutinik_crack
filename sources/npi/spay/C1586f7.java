package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import spay.sdk.view.SpayUserDataCompositeView;

/* renamed from: npi.spay.f7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1586f7 implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final MaterialButton d;
    public final RecyclerView e;
    public final RecyclerView f;
    public final SpayUserDataCompositeView g;

    public C1586f7(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, MaterialButton materialButton, RecyclerView recyclerView, RecyclerView recyclerView2, SpayUserDataCompositeView spayUserDataCompositeView) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = materialButton;
        this.e = recyclerView;
        this.f = recyclerView2;
        this.g = spayUserDataCompositeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
