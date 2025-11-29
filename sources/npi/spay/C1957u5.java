package npi.spay;

import android.os.HandlerThread;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.u5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1957u5 extends Lambda implements Function0 {
    public static final C1957u5 a = new C1957u5();

    public C1957u5() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Lazy lazy = V5.a;
        HandlerThread handlerThread = new HandlerThread("Timer thread");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "timerThread.looper");
        return new L3(looper);
    }
}
