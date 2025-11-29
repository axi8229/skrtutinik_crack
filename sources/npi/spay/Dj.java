package npi.spay;

import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes4.dex */
public final class Dj extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public Dj(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Dj dj = new Dj(continuation);
        dj.a = obj;
        return dj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Dj dj = new Dj((Continuation) obj2);
        dj.a = (List) obj;
        return dj.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        List list = (List) this.a;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((Jd) it.next()).b;
        }
        return Boxing.boxLong(j);
    }
}
