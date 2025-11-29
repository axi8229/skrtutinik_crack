package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: npi.spay.hj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1648hj extends ContinuationImpl {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Uk e;
    public C1697jj f;
    public /* synthetic */ Object g;
    public final /* synthetic */ C1697jj h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1648hj(C1697jj c1697jj, Continuation continuation) {
        super(continuation);
        this.h = c1697jj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.h.a(null, null, this);
    }
}
