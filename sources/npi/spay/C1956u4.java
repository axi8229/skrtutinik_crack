package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import spay.sdk.domain.model.response.OrderScreenDataResponse;

/* renamed from: npi.spay.u4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1956u4 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public C1956u4(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1956u4 c1956u4 = new C1956u4(continuation);
        c1956u4.a = obj;
        return c1956u4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C1956u4 c1956u4 = new C1956u4((Continuation) obj2);
        c1956u4.a = (OrderScreenDataResponse) obj;
        return c1956u4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        OrderScreenDataResponse orderScreenDataResponse = (OrderScreenDataResponse) this.a;
        if (orderScreenDataResponse != null) {
            return orderScreenDataResponse.getListOfCardsResponseBody();
        }
        return null;
    }
}
