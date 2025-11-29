package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: npi.spay.sa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1912sa extends SuspendLambda implements Function2 {
    public final /* synthetic */ C1937ta a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1912sa(C1937ta c1937ta, Continuation continuation) {
        super(2, continuation);
        this.a = c1937ta;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1912sa(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C1912sa(this.a, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return String.valueOf(((Di) this.a.a).n);
    }
}
