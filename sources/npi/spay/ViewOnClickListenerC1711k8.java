package npi.spay;

import android.os.SystemClock;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

/* renamed from: npi.spay.k8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewOnClickListenerC1711k8 implements View.OnClickListener {
    public final /* synthetic */ Ref$LongRef a;
    public final /* synthetic */ Q8 b;
    public final /* synthetic */ C1651hm c;

    public ViewOnClickListenerC1711k8(Ref$LongRef ref$LongRef, Q8 q8, C1651hm c1651hm) {
        this.a = ref$LongRef;
        this.b = q8;
        this.c = c1651hm;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View it) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Ref$LongRef ref$LongRef = this.a;
        if (jElapsedRealtime - ref$LongRef.element < 400) {
            return;
        }
        ref$LongRef.element = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this.b.b.invoke(this.c);
    }
}
