package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.n0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2243n0 extends Lambda implements Function1 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2243n0(C2264y0 c2264y0) {
        super(1);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C2264y0.a(this.a).handleAction(new C2216a(((Boolean) obj).booleanValue()));
        return Unit.INSTANCE;
    }
}
