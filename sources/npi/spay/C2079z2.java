package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: npi.spay.z2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2079z2 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public C2079z2(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C2079z2 c2079z2 = new C2079z2(continuation);
        c2079z2.a = obj;
        return c2079z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C2079z2 c2079z2 = new C2079z2((Continuation) obj2);
        c2079z2.a = (C1604g0) obj;
        return c2079z2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        AbstractC1855q2 abstractC1855q2 = ((C1604g0) this.a).a;
        return Boxing.boxBoolean(((abstractC1855q2 instanceof E1) || ((abstractC1855q2 instanceof C1531d2) && (((C1531d2) abstractC1855q2).a instanceof C1510c6))) ? false : true);
    }
}
