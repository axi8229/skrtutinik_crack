package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: npi.spay.a7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1461a7 extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ spay.sdk.a b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1461a7(spay.sdk.a aVar, Continuation continuation) {
        super(continuation);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return spay.sdk.a.a(this.b, this);
    }
}
