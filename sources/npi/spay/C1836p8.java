package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import spay.sdk.data.dto.MerchantDataWithOrderId;
import spay.sdk.domain.model.request.PayOnlineRequestBody;
import spay.sdk.domain.model.response.SessionIdResponseBody;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.p8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1836p8 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ spay.sdk.a b;
    public final /* synthetic */ ListOfCardsResponseBody.PaymentToolInfo.Tool c;
    public final /* synthetic */ boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1836p8(spay.sdk.a aVar, ListOfCardsResponseBody.PaymentToolInfo.Tool tool, boolean z, Continuation continuation) {
        super(2, continuation);
        this.b = aVar;
        this.c = tool;
        this.d = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1836p8(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1836p8) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            spay.sdk.a aVar = this.b;
            Nk nk = aVar.f;
            String strP = ((Di) aVar.b).p();
            String sessionId = ((SessionIdResponseBody) FlowKt.asStateFlow(this.b.w).getValue()).getSessionId();
            String str = ((Di) this.b.b).C;
            int paymentId = this.c.getPaymentId();
            MerchantDataWithOrderId merchantDataWithOrderId = ((Di) this.b.b).i;
            String orderId = merchantDataWithOrderId != null ? merchantDataWithOrderId.getOrderId() : null;
            Intrinsics.checkNotNull(orderId);
            MerchantDataWithOrderId merchantDataWithOrderId2 = ((Di) this.b.b).i;
            String merchantLogin = merchantDataWithOrderId2 != null ? merchantDataWithOrderId2.getMerchantLogin() : null;
            Intrinsics.checkNotNull(merchantLogin);
            C1849pl c1849pl = new C1849pl(strP, new PayOnlineRequestBody(null, sessionId, merchantLogin, str, paymentId, null, orderId, this.d, ((Di) this.b.b).q, 33, null));
            this.a = 1;
            if (nk.a(c1849pl, Dispatchers.getIO(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
