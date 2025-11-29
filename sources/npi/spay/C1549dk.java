package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.dk, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1549dk extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ C1697jj b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1549dk(C1697jj c1697jj, Continuation continuation) {
        super(2, continuation);
        this.b = c1697jj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1549dk c1549dk = new C1549dk(this.b, continuation);
        c1549dk.a = obj;
        return c1549dk;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C1549dk c1549dk = new C1549dk(this.b, (Continuation) obj2);
        c1549dk.a = (C1604g0) obj;
        return c1549dk.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        C1604g0 income = (C1604g0) this.a;
        C1822oj c1822oj = (C1822oj) this.b.e;
        c1822oj.getClass();
        Intrinsics.checkNotNullParameter(income, "income");
        c1822oj.a.setValue(income);
        return Unit.INSTANCE;
    }
}
