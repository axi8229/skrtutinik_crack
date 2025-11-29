package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* loaded from: classes4.dex */
public final class Ld extends SuspendLambda implements Function3 {
    public /* synthetic */ B4 a;
    public /* synthetic */ B4 b;

    public Ld(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Ld ld = new Ld((Continuation) obj3);
        ld.a = (B4) obj;
        ld.b = (B4) obj2;
        return ld.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        B4 b4 = this.a;
        return b4 == null ? this.b : b4;
    }
}
