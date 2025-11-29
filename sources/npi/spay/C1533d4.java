package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: npi.spay.d4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1533d4 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public C1533d4(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1533d4 c1533d4 = new C1533d4(continuation);
        c1533d4.a = obj;
        return c1533d4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C1533d4 c1533d4 = new C1533d4((Continuation) obj2);
        c1533d4.a = (C1531d2) obj;
        return c1533d4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return ((C1531d2) this.a).a;
    }
}
