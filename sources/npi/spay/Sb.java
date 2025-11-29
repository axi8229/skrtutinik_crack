package npi.spay;

import android.os.SystemClock;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

/* loaded from: classes4.dex */
public final class Sb implements View.OnClickListener {
    public final /* synthetic */ Ref$LongRef a;
    public final /* synthetic */ Hc b;
    public final /* synthetic */ C2012wa c;

    public Sb(Ref$LongRef ref$LongRef, Hc hc, C2012wa c2012wa) {
        this.a = ref$LongRef;
        this.b = hc;
        this.c = c2012wa;
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
        this.b.c.invoke(this.c);
    }
}
