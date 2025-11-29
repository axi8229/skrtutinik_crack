package npi.spay;

import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import spay.sdk.domain.model.request.AuthWithOrderIdRequestBody;
import spay.sdk.domain.model.response.AuthResponseBody;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.ErrorEntity;

/* renamed from: npi.spay.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1827p extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ B0 b;
    public final /* synthetic */ C1779n1 c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1827p(B0 b0, C1779n1 c1779n1, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.b = b0;
        this.c = c1779n1;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1827p(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1827p) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        co c2075yn;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC2073yl interfaceC2073yl = this.b.a;
            C1779n1 c1779n1 = this.c;
            String str = c1779n1.a;
            AuthWithOrderIdRequestBody authWithOrderIdRequestBody = c1779n1.b;
            this.a = 1;
            obj = ((Hm) interfaceC2073yl).a(str, authWithOrderIdRequestBody, this);
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
                B0 b0 = this.b;
                if (((Ec) b0.c).c) {
                    ((Jh) b0.b).a(Hn.a);
                    this.b.d.a.a(new String[]{"X-Sdk-Refresh-Data", "X-Sdk-Id-Key"});
                    ((Ec) this.b.c).c = false;
                    return Unit.INSTANCE;
                }
                c2075yn = new Mn(new K1(failure.getError()));
            } else {
                c2075yn = Intrinsics.areEqual(error, ErrorEntity.NoInternet.INSTANCE) ? new Mn(new C1581f2(new C1802o(this.b, this.c, this.d, null))) : (Intrinsics.areEqual(error, ErrorEntity.NotFound.INSTANCE) || Intrinsics.areEqual(error, ErrorEntity.ServiceUnavailable.INSTANCE)) ? new Mn(new S1("Некорректный формат запроса или ответа")) : Intrinsics.areEqual(error, ErrorEntity.TimeOut.INSTANCE) ? new Mn(new V1()) : Intrinsics.areEqual(error, ErrorEntity.Unknown.INSTANCE) ? new Mn(new S1("Системная или внутренняя ошибка")) : new Mn(new S1("Некорректный формат запроса или ответа"));
            }
        } else {
            if (!(contentResponse instanceof ContentResponse.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            Object data = ((ContentResponse.Success) contentResponse).getData();
            Intrinsics.checkNotNull(data);
            c2075yn = new C2075yn((AuthResponseBody) data);
        }
        ((Jh) this.b.b).a(c2075yn);
        return Unit.INSTANCE;
    }
}
