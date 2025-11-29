package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* loaded from: classes4.dex */
public final class Ij extends SuspendLambda implements Function3 {
    public /* synthetic */ Long a;
    public /* synthetic */ String b;

    public Ij(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Ij ij = new Ij((Continuation) obj3);
        ij.a = (Long) obj;
        ij.b = (String) obj2;
        return ij.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Long l = this.a;
        String str = this.b;
        if (l != null) {
            return new Kd(l.longValue(), str);
        }
        return null;
    }
}
