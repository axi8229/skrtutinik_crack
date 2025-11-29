package npi.spay;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class K3 implements ViewBinding {
    public final LinearLayoutCompat a;
    public final AppCompatTextView b;
    public final TextView c;
    public final LinearLayoutCompat d;

    public K3(LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, TextView textView, LinearLayoutCompat linearLayoutCompat2) {
        this.a = linearLayoutCompat;
        this.b = appCompatTextView;
        this.c = textView;
        this.d = linearLayoutCompat2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
