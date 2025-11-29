package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;

/* loaded from: classes4.dex */
public final class V7 implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final Group c;
    public final LottieAnimationView d;
    public final AppCompatTextView e;

    public V7(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, Group group, LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = appCompatTextView;
        this.c = group;
        this.d = lottieAnimationView;
        this.e = appCompatTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
