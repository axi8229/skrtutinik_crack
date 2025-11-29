package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: npi.spay.wh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2019wh extends ContinuationImpl {
    public /* synthetic */ Object a;
    public int b;
    public final /* synthetic */ C2044xh c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2019wh(C2044xh c2044xh, Continuation continuation) {
        super(continuation);
        this.c = c2044xh;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.emit(null, this);
    }
}
