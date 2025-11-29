package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes4.dex */
public final class G9 extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ C1987va b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G9(C1987va c1987va, Continuation continuation) {
        super(continuation);
        this.b = c1987va;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return C1987va.a(this.b, null, null, this);
    }
}
