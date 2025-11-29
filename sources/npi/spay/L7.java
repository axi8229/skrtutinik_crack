package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes4.dex */
public final class L7 extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ spay.sdk.a b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L7(spay.sdk.a aVar, Continuation continuation) {
        super(continuation);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return spay.sdk.a.b(this.b, this);
    }
}
