package npi.spay;

import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

/* renamed from: npi.spay.b0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewOnClickListenerC1479b0 implements View.OnClickListener {
    public final /* synthetic */ Ref$LongRef a;
    public final /* synthetic */ C1579f0 b;

    public ViewOnClickListenerC1479b0(Ref$LongRef ref$LongRef, C1579f0 c1579f0) {
        this.a = ref$LongRef;
        this.b = c1579f0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View it) throws NoSuchAlgorithmException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Ref$LongRef ref$LongRef = this.a;
        if (jElapsedRealtime - ref$LongRef.element < 400) {
            return;
        }
        ref$LongRef.element = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        FragmentActivity fragmentActivityRequireActivity = this.b.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Intrinsics.checkNotNullParameter(fragmentActivityRequireActivity, "<this>");
        View currentFocus = fragmentActivityRequireActivity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(fragmentActivityRequireActivity);
        }
        AbstractC1977v0.a(fragmentActivityRequireActivity, currentFocus);
        ((C2081z4) this.b.b()).a(C1627gn.a);
    }
}
