package npi.spay;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class C2 implements ViewBinding {
    public final LinearLayoutCompat a;

    public C2(LinearLayoutCompat linearLayoutCompat) {
        this.a = linearLayoutCompat;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
