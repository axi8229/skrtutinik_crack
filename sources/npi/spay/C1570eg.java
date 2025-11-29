package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* renamed from: npi.spay.eg, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1570eg implements ViewBinding {
    public final NestedScrollView a;
    public final MaterialButton b;
    public final CardView c;
    public final AppCompatTextView d;
    public final MaterialButton e;
    public final RecyclerView f;
    public final C1500bl g;
    public final Bl h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final AppCompatCheckBox l;

    public C1570eg(NestedScrollView nestedScrollView, MaterialButton materialButton, CardView cardView, AppCompatTextView appCompatTextView, MaterialButton materialButton2, RecyclerView recyclerView, C1500bl c1500bl, Bl bl, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatCheckBox appCompatCheckBox) {
        this.a = nestedScrollView;
        this.b = materialButton;
        this.c = cardView;
        this.d = appCompatTextView;
        this.e = materialButton2;
        this.f = recyclerView;
        this.g = c1500bl;
        this.h = bl;
        this.i = appCompatTextView2;
        this.j = appCompatTextView3;
        this.k = appCompatTextView4;
        this.l = appCompatCheckBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
