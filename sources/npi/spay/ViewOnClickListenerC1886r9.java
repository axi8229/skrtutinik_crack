package npi.spay;

import android.os.SystemClock;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

/* renamed from: npi.spay.r9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewOnClickListenerC1886r9 implements View.OnClickListener {
    public final /* synthetic */ Ref$LongRef a;
    public final /* synthetic */ S9 b;
    public final /* synthetic */ Ma c;

    public ViewOnClickListenerC1886r9(Ref$LongRef ref$LongRef, S9 s9, Ma ma) {
        this.a = ref$LongRef;
        this.b = s9;
        this.c = ma;
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
