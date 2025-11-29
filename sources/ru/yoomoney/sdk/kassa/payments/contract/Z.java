package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class Z extends Lambda implements Function1 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(C2264y0 c2264y0) {
        super(1);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Throwable it = (Throwable) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C2264y0 c2264y0 = this.a;
        Y y = new Y(c2264y0);
        int i = C2264y0.$r8$clinit;
        c2264y0.a(it, y);
        return Unit.INSTANCE;
    }
}
