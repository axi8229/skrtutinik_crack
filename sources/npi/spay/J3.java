package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes4.dex */
public final class J3 implements ViewBinding {
    public final LinearLayoutCompat a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final MaterialButton d;

    public J3(LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, MaterialButton materialButton) {
        this.a = linearLayoutCompat;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
