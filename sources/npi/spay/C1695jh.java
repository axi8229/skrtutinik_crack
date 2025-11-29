package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: npi.spay.jh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1695jh extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ C1720kh b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1695jh(C1720kh c1720kh, Continuation continuation) {
        super(continuation);
        this.b = c1720kh;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.a(this);
    }
}
