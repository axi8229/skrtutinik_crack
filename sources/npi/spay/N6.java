package npi.spay;

import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.ErrorEntity;
import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;
import spay.sdk.domain.model.response.paymentToken.successResponse.PaymentTokenResponseBody;

/* loaded from: classes4.dex */
public final class N6 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ E7 b;
    public final /* synthetic */ C1686j8 c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N6(E7 e7, C1686j8 c1686j8, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.b = e7;
        this.c = c1686j8;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new N6(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((N6) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        co pn;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((Jh) this.b.b).a(new C1900rn(new C1510c6(new C2097zk(R$string.spay_pay_loading_text, CollectionsKt.emptyList()))));
            InterfaceC2073yl interfaceC2073yl = this.b.a;
            C1686j8 c1686j8 = this.c;
            String str = c1686j8.a;
            PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody = c1686j8.b;
            this.a = 1;
            obj = ((Hm) interfaceC2073yl).a(str, paymentTokenWithOrderIdRequestBody, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ContentResponse contentResponse = (ContentResponse) obj;
        if (contentResponse instanceof ContentResponse.Failure) {
            E7 e7 = this.b;
            C1686j8 c1686j82 = this.c;
            CoroutineDispatcher coroutineDispatcher = this.d;
            e7.getClass();
            Intrinsics.checkNotNull(contentResponse, "null cannot be cast to non-null type spay.sdk.domain.model.response.ContentResponse.Failure<spay.sdk.domain.model.response.paymentToken.successResponse.PaymentTokenResponseBody>");
            ContentResponse.Failure failure = (ContentResponse.Failure) contentResponse;
            ErrorEntity error = failure.getError();
            if (error instanceof ErrorEntity.ApiError) {
                pn = c1686j82.b.isBnplEnabled() ? new Pn(new C2066ye(failure.getError())) : new Pn(new C2041xe(failure.getError()));
            } else if (error instanceof ErrorEntity.BadRequest) {
                C1612g8 c1612g8 = e7.c;
                FraudMonCheckResult fraudMonCheckResult = ((ErrorEntity.BadRequest) error).getFraudMonCheckResult();
                c1612g8.getClass();
                Zi ziA = C1612g8.a(fraudMonCheckResult);
                if ((ziA instanceof Ui) || (ziA instanceof Vi) || (ziA instanceof Xi) || (ziA instanceof Yi)) {
                    pn = new Nn(ziA);
                } else {
                    if (!Intrinsics.areEqual(ziA, Wi.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    pn = new Mn(new S1("Системная или внутренняя ошибка"));
                }
            } else {
                pn = Intrinsics.areEqual(error, ErrorEntity.NoInternet.INSTANCE) ? new Mn(new C1581f2(new W5(e7, c1686j82, coroutineDispatcher, null))) : Intrinsics.areEqual(error, ErrorEntity.TimeOut.INSTANCE) ? new Mn(new V1()) : Intrinsics.areEqual(error, ErrorEntity.Unknown.INSTANCE) ? new Mn(new S1("Системная или внутренняя ошибка")) : new Mn(new S1("Некорректный формат запроса или ответа"));
            }
        } else {
            if (!(contentResponse instanceof ContentResponse.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            Object data = ((ContentResponse.Success) contentResponse).getData();
            Intrinsics.checkNotNull(data);
            pn = new Pn(new C2091ze((PaymentTokenResponseBody) data));
        }
        ((Jh) this.b.b).a(pn);
        return Unit.INSTANCE;
    }
}
