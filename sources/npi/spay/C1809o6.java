package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* renamed from: npi.spay.o6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1809o6 implements ViewBinding {
    public final LinearLayoutCompat a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final MaterialButton d;
    public final MaterialButton e;

    public C1809o6(LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, MaterialButton materialButton, MaterialButton materialButton2) {
        this.a = linearLayoutCompat;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = materialButton;
        this.e = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
