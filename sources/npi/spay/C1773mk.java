package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: npi.spay.mk, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1773mk extends ContinuationImpl {
    public C1972uk a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C1972uk c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1773mk(C1972uk c1972uk, Continuation continuation) {
        super(continuation);
        this.c = c1972uk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.b(null, null, this);
    }
}
