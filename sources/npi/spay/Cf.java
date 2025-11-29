package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import spay.sdk.domain.model.response.OrderScreenDataResponse;

/* loaded from: classes4.dex */
public final class Cf extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public Cf(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Cf cf = new Cf(continuation);
        cf.a = obj;
        return cf;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Cf cf = new Cf((Continuation) obj2);
        cf.a = (OrderScreenDataResponse) obj;
        return cf.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        OrderScreenDataResponse orderScreenDataResponse = (OrderScreenDataResponse) this.a;
        if (orderScreenDataResponse != null) {
            return orderScreenDataResponse.getPaymentPlanBnplResponseBody();
        }
        return null;
    }
}
