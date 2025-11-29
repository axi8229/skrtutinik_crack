package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import spay.sdk.view.SpayBonusOverallCompositeView;

/* renamed from: npi.spay.rj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1896rj implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final SpayBonusOverallCompositeView e;
    public final CardView f;

    public C1896rj(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, SpayBonusOverallCompositeView spayBonusOverallCompositeView, CardView cardView) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = appCompatTextView3;
        this.e = spayBonusOverallCompositeView;
        this.f = cardView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
