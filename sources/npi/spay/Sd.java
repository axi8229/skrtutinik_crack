package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* loaded from: classes4.dex */
public final class Sd extends SuspendLambda implements Function3 {
    public /* synthetic */ Long a;
    public /* synthetic */ String b;

    public Sd(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Sd sd = new Sd((Continuation) obj3);
        sd.a = (Long) obj;
        sd.b = (String) obj2;
        return sd.invokeSuspend(Unit.INSTANCE);
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
