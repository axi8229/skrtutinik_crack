package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: npi.spay.g3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1607g3 extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ C1632h3 b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1607g3(C1632h3 c1632h3, Continuation continuation) {
        super(continuation);
        this.b = c1632h3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.a(this);
    }
}
