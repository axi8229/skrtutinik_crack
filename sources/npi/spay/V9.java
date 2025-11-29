package npi.spay;

import android.os.SystemClock;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

/* loaded from: classes4.dex */
public final class V9 implements View.OnClickListener {
    public final /* synthetic */ Ref$LongRef a;
    public final /* synthetic */ C1464aa b;

    public V9(Ref$LongRef ref$LongRef, C1464aa c1464aa) {
        this.a = ref$LongRef;
        this.b = c1464aa;
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
        ((C1889rc) this.b.b()).a(Qa.a);
    }
}
