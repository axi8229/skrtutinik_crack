package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import spay.sdk.view.BnplButtonCompositeView;
import spay.sdk.view.SpayBnplGraphCompositeView;
import spay.sdk.view.SpayBonusOverallCompositeView;
import spay.sdk.view.SpayUserDataCompositeView;

/* renamed from: npi.spay.nc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1790nc implements ViewBinding {
    public final NestedScrollView a;
    public final AppCompatButton b;
    public final BnplButtonCompositeView c;
    public final CardView d;
    public final C1500bl e;
    public final Bl f;
    public final MaterialButton g;
    public final RecyclerView h;
    public final RecyclerView i;
    public final SpayBnplGraphCompositeView j;
    public final SpayBonusOverallCompositeView k;
    public final SpayUserDataCompositeView l;
    public final AppCompatTextView m;

    public C1790nc(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, BnplButtonCompositeView bnplButtonCompositeView, CardView cardView, C1500bl c1500bl, Bl bl, MaterialButton materialButton, RecyclerView recyclerView, RecyclerView recyclerView2, SpayBnplGraphCompositeView spayBnplGraphCompositeView, SpayBonusOverallCompositeView spayBonusOverallCompositeView, SpayUserDataCompositeView spayUserDataCompositeView, AppCompatTextView appCompatTextView) {
        this.a = nestedScrollView;
        this.b = appCompatButton;
        this.c = bnplButtonCompositeView;
        this.d = cardView;
        this.e = c1500bl;
        this.f = bl;
        this.g = materialButton;
        this.h = recyclerView;
        this.i = recyclerView2;
        this.j = spayBnplGraphCompositeView;
        this.k = spayBonusOverallCompositeView;
        this.l = spayUserDataCompositeView;
        this.m = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
