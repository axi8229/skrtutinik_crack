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
import spay.sdk.domain.model.request.CreateOtpSdkRequestBody;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.ErrorEntity;
import spay.sdk.domain.model.response.otp.CreateOtpSdkResponseBody;

/* loaded from: classes4.dex */
public final class Fb extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ C2014wc b;
    public final /* synthetic */ Xd c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fb(C2014wc c2014wc, Xd xd, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.b = c2014wc;
        this.c = xd;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Fb(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((Fb) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        co in;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((Jh) this.b.b).a(new C1900rn(new C1460a6(new C2097zk(R$string.spay_wait_a_second, CollectionsKt.emptyList()))));
            InterfaceC2073yl interfaceC2073yl = this.b.a;
            Xd xd = this.c;
            String str = xd.a;
            CreateOtpSdkRequestBody createOtpSdkRequestBody = xd.b;
            this.a = 1;
            obj = ((Hm) interfaceC2073yl).a(str, createOtpSdkRequestBody, this);
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
            in = error instanceof ErrorEntity.ApiError ? new Gn(failure.getError()) : Intrinsics.areEqual(error, ErrorEntity.NoInternet.INSTANCE) ? new Mn(new C1581f2(new Eb(this.b, this.c, this.d, null))) : Intrinsics.areEqual(error, ErrorEntity.TimeOut.INSTANCE) ? new Mn(new V1()) : Intrinsics.areEqual(error, ErrorEntity.Unknown.INSTANCE) ? new Mn(new S1("Системная или внутренняя ошибка")) : new Mn(new S1("Некорректный формат запроса или ответа"));
        } else {
            if (!(contentResponse instanceof ContentResponse.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            Object data = ((ContentResponse.Success) contentResponse).getData();
            Intrinsics.checkNotNull(data);
            AbstractC1687j9 oneTimePasswordStatus = ((CreateOtpSdkResponseBody) data).toOneTimePasswordStatus();
            this.c.getClass();
            in = new In(oneTimePasswordStatus);
        }
        ((Jh) this.b.b).a(in);
        return Unit.INSTANCE;
    }
}
