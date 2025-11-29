package npi.spay;

import android.os.SystemClock;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

/* renamed from: npi.spay.tl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewOnClickListenerC1948tl implements View.OnClickListener {
    public final /* synthetic */ Ref$LongRef a;
    public final /* synthetic */ C1700jm b;
    public final /* synthetic */ Zj c;

    public ViewOnClickListenerC1948tl(Ref$LongRef ref$LongRef, C1700jm c1700jm, Zj zj) {
        this.a = ref$LongRef;
        this.b = c1700jm;
        this.c = zj;
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
