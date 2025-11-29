package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* renamed from: npi.spay.e4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1558e4 extends SuspendLambda implements Function3 {
    public /* synthetic */ AbstractC1535d6 a;
    public /* synthetic */ AbstractC1535d6 b;

    public C1558e4(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C1558e4 c1558e4 = new C1558e4((Continuation) obj3);
        c1558e4.a = (AbstractC1535d6) obj;
        c1558e4.b = (AbstractC1535d6) obj2;
        return c1558e4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Bk bkA;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        AbstractC1535d6 abstractC1535d6 = this.a;
        AbstractC1535d6 abstractC1535d62 = this.b;
        return (abstractC1535d62 == null || (bkA = abstractC1535d62.a()) == null) ? abstractC1535d6.a() : bkA;
    }
}
