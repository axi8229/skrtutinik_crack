package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes4.dex */
public final class Ed implements ViewBinding {
    public final NestedScrollView a;
    public final AppCompatTextView b;
    public final MaterialButton c;
    public final MaterialButton d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final AppCompatCheckBox h;
    public final RecyclerView i;

    public Ed(NestedScrollView nestedScrollView, AppCompatTextView appCompatTextView, MaterialButton materialButton, MaterialButton materialButton2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatCheckBox appCompatCheckBox, RecyclerView recyclerView) {
        this.a = nestedScrollView;
        this.b = appCompatTextView;
        this.c = materialButton;
        this.d = materialButton2;
        this.e = appCompatTextView2;
        this.f = appCompatTextView3;
        this.g = appCompatTextView4;
        this.h = appCompatCheckBox;
        this.i = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
