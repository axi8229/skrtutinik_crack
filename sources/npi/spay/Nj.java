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
import spay.sdk.domain.model.request.ConfirmOtpRequestBody;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.ErrorEntity;
import spay.sdk.domain.model.response.otp.ConfirmOtpResponseBody;

/* loaded from: classes4.dex */
public final class Nj extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ Hk b;
    public final /* synthetic */ C1674il c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Nj(Hk hk, C1674il c1674il, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.b = hk;
        this.c = c1674il;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Nj(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((Nj) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        co en;
        Mn mn;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((Jh) this.b.b).a(new C1900rn(new C1510c6(new C2097zk(R$string.spay_pay_loading_text, CollectionsKt.emptyList()))));
            InterfaceC2073yl interfaceC2073yl = this.b.a;
            C1674il c1674il = this.c;
            String str = c1674il.a;
            ConfirmOtpRequestBody confirmOtpRequestBody = c1674il.b;
            this.a = 1;
            obj = ((Hm) interfaceC2073yl).a(str, confirmOtpRequestBody, this);
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
            ContentResponse.Failure failure = (ContentResponse.Failure) contentResponse;
            ErrorEntity error = failure.getError();
            if (error instanceof ErrorEntity.ApiError) {
                en = new Cn(failure.getError());
            } else if (Intrinsics.areEqual(error, ErrorEntity.NoInternet.INSTANCE)) {
                en = new Mn(new C1581f2(new Mj(this.b, this.c, this.d, null)));
            } else if (Intrinsics.areEqual(error, ErrorEntity.NotFound.INSTANCE) || Intrinsics.areEqual(error, ErrorEntity.ServiceUnavailable.INSTANCE)) {
                en = new Mn(new S1("Некорректный формат запроса или ответа"));
            } else if (Intrinsics.areEqual(error, ErrorEntity.TimeOut.INSTANCE)) {
                en = mn;
                mn = new Mn(new V1());
            } else {
                en = mn;
                mn = new Mn(new S1("Системная или внутренняя ошибка"));
            }
        } else {
            if (!(contentResponse instanceof ContentResponse.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            Object data = ((ContentResponse.Success) contentResponse).getData();
            Intrinsics.checkNotNull(data);
            en = new En(((ConfirmOtpResponseBody) data).toOneTimePasswordStatus(this.c.c), this.c.d);
        }
        ((Jh) this.b.b).a(en);
        return Unit.INSTANCE;
    }
}
