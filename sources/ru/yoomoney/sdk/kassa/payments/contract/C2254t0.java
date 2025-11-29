package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.t0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2254t0 extends Lambda implements Function0 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2254t0(C2264y0 c2264y0) {
        super(0);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C2264y0.a(this.a).handleAction(C2220c.a);
        return Unit.INSTANCE;
    }
}
