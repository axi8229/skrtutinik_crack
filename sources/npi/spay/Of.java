package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes4.dex */
public final class Of extends ContinuationImpl {
    public /* synthetic */ Object a;
    public int b;
    public final /* synthetic */ Pf c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Of(Pf pf, Continuation continuation) {
        super(continuation);
        this.c = pf;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.emit(null, this);
    }
}
