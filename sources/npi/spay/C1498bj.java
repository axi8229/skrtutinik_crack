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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.request.PayOnlineRequestBody;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.ErrorEntity;
import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;

/* renamed from: npi.spay.bj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1498bj extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ Nk b;
    public final /* synthetic */ C1849pl c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1498bj(Nk nk, C1849pl c1849pl, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.b = nk;
        this.c = c1849pl;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1498bj(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1498bj) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        co on;
        co nn;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((Jh) this.b.d).a(new C1900rn(new C1510c6(new C2097zk(R$string.spay_pay_loading_text, CollectionsKt.emptyList()))));
            if (((Di) this.b.b).C.length() == 0) {
                on = new On(new W6(ErrorEntity.Unknown.INSTANCE));
                ((Jh) this.b.d).a(on);
                return Unit.INSTANCE;
            }
            InterfaceC2073yl interfaceC2073yl = this.b.a;
            C1849pl c1849pl = this.c;
            String str = c1849pl.a;
            PayOnlineRequestBody payOnlineRequestBody = c1849pl.b;
            this.a = 1;
            obj = ((Hm) interfaceC2073yl).a(str, payOnlineRequestBody, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                on = (co) obj;
                ((Jh) this.b.d).a(on);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ContentResponse contentResponse = (ContentResponse) obj;
        if (contentResponse instanceof ContentResponse.Failure) {
            ContentResponse.Failure failure = (ContentResponse.Failure) contentResponse;
            ErrorEntity error = failure.getError();
            if (error instanceof ErrorEntity.PayBnplPartsFail) {
                on = new Mn(C1755m2.a);
            } else {
                if (error instanceof ErrorEntity.ApiError) {
                    nn = new Mn(new K1(failure.getError()));
                } else if (error instanceof ErrorEntity.BadRequest) {
                    C1612g8 c1612g8 = this.b.f;
                    FraudMonCheckResult fraudMonCheckResult = ((ErrorEntity.BadRequest) failure.getError()).getFraudMonCheckResult();
                    c1612g8.getClass();
                    Zi ziA = C1612g8.a(fraudMonCheckResult);
                    if ((ziA instanceof Ui) || (ziA instanceof Vi) || (ziA instanceof Xi) || (ziA instanceof Yi)) {
                        nn = new Nn(ziA);
                    } else {
                        if (!Intrinsics.areEqual(ziA, Wi.a)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        on = new Mn(new S1("Системная или внутренняя ошибка"));
                    }
                } else if (Intrinsics.areEqual(error, ErrorEntity.NoInternet.INSTANCE)) {
                    on = new Mn(new C1581f2(new C1473aj(this.b, this.c, this.d, null)));
                } else if ((error instanceof ErrorEntity.UnknownApiResult) || Intrinsics.areEqual(error, ErrorEntity.TimeOut.INSTANCE)) {
                    Nk nk = this.b;
                    C1849pl c1849pl2 = this.c;
                    CoroutineDispatcher coroutineDispatcher = this.d;
                    this.a = 2;
                    nk.getClass();
                    obj = BuildersKt.withContext(coroutineDispatcher, new Tj(nk, c1849pl2, coroutineDispatcher, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    on = (co) obj;
                } else {
                    on = new Mn(new S1("Системная или внутренняя ошибка"));
                }
                on = nn;
            }
        } else {
            if (!(contentResponse instanceof ContentResponse.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            on = new On(Y6.a);
        }
        ((Jh) this.b.d).a(on);
        return Unit.INSTANCE;
    }
}
