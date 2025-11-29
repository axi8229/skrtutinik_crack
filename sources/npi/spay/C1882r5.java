package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* renamed from: npi.spay.r5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1882r5 implements ViewBinding {
    public final LinearLayoutCompat a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final MaterialButton e;
    public final MaterialButton f;

    public C1882r5(LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, MaterialButton materialButton, MaterialButton materialButton2) {
        this.a = linearLayoutCompat;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = appCompatTextView3;
        this.e = materialButton;
        this.f = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
