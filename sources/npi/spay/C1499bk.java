package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: npi.spay.bk, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1499bk extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public C1499bk(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1499bk c1499bk = new C1499bk(continuation);
        c1499bk.a = obj;
        return c1499bk;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C1499bk c1499bk = new C1499bk((Continuation) obj2);
        c1499bk.a = (C1604g0) obj;
        return c1499bk.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        AbstractC1855q2 abstractC1855q2 = ((C1604g0) this.a).a;
        boolean z = abstractC1855q2 instanceof C1656i2;
        if (z) {
            AbstractC1687j9 abstractC1687j9 = ((C1656i2) abstractC1855q2).a;
            if (abstractC1687j9 instanceof V8) {
                return ((V8) abstractC1687j9).b;
            }
        }
        if (z) {
            AbstractC1687j9 abstractC1687j92 = ((C1656i2) abstractC1855q2).a;
            if (abstractC1687j92 instanceof C1488b9) {
                return ((C1488b9) abstractC1687j92).b;
            }
        }
        return null;
    }
}
