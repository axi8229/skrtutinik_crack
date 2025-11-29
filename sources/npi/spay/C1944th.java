package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: npi.spay.th, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1944th extends ContinuationImpl {
    public /* synthetic */ Object a;
    public int b;
    public final /* synthetic */ C1969uh c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1944th(C1969uh c1969uh, Continuation continuation) {
        super(continuation);
        this.c = c1969uh;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.emit(null, this);
    }
}
