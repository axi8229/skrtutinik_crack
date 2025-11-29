package npi.spay;

import android.os.CountDownTimer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.d8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class CountDownTimerC1537d8 extends CountDownTimer {
    public final Function1 a;
    public final Function0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTimerC1537d8(long j, long j2, Function1 function1, Function0 onFinishTimerAction) {
        super(j, j2);
        Intrinsics.checkNotNullParameter(onFinishTimerAction, "onFinishTimerAction");
        this.a = function1;
        this.b = onFinishTimerAction;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        this.b.invoke();
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        Function1 function1 = this.a;
        if (function1 != null) {
            function1.invoke(Long.valueOf(j));
        }
    }
}
