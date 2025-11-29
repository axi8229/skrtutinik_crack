package npi.spay;

import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class Hi implements ViewBinding {
    public final FrameLayout a;
    public final CardView b;

    public Hi(FrameLayout frameLayout, CardView cardView) {
        this.a = frameLayout;
        this.b = cardView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
