package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: npi.spay.k7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1710k7 extends ContinuationImpl {
    public /* synthetic */ Object a;
    public int b;
    public final /* synthetic */ C1735l7 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1710k7(C1735l7 c1735l7, Continuation continuation) {
        super(continuation);
        this.c = c1735l7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.emit(null, this);
    }
}
