package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import spay.sdk.domain.model.response.OrderScreenDataResponse;

/* renamed from: npi.spay.sh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1919sh extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public C1919sh(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1919sh c1919sh = new C1919sh(continuation);
        c1919sh.a = obj;
        return c1919sh;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C1919sh c1919sh = new C1919sh((Continuation) obj2);
        c1919sh.a = (OrderScreenDataResponse) obj;
        return c1919sh.invokeSuspend(Unit.INSTANCE);
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
