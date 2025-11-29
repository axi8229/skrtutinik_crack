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
import spay.sdk.domain.model.request.PaymentOrderRequestBody;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.ErrorEntity;

/* renamed from: npi.spay.fm, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1601fm extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ r b;
    public final /* synthetic */ D0 c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1601fm(r rVar, D0 d0, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.b = rVar;
        this.c = d0;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1601fm(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1601fm) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        co on;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((Jh) this.b.b).a(new C1900rn(new C1510c6(new C2097zk(R$string.spay_pay_loading_text, CollectionsKt.emptyList()))));
            InterfaceC2073yl interfaceC2073yl = this.b.a;
            D0 d0 = this.c;
            String str = d0.a;
            PaymentOrderRequestBody paymentOrderRequestBody = d0.b;
            this.a = 1;
            obj = ((Hm) interfaceC2073yl).a(str, paymentOrderRequestBody, this);
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
                ((Jh) this.b.b).a(on);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ContentResponse contentResponse = (ContentResponse) obj;
        if (contentResponse instanceof ContentResponse.Failure) {
            ContentResponse.Failure failure = (ContentResponse.Failure) contentResponse;
            ErrorEntity error = failure.getError();
            if (error instanceof ErrorEntity.ApiError) {
                on = new Mn(new K1(failure.getError()));
            } else if (error instanceof ErrorEntity.BadRequest) {
                on = new On(new W6(failure.getError()));
            } else if (Intrinsics.areEqual(error, ErrorEntity.NoInternet.INSTANCE)) {
                on = new Mn(new C1581f2(new C1576em(this.b, this.c, this.d, null)));
            } else if (Intrinsics.areEqual(error, ErrorEntity.UnknownApiResult.INSTANCE) || Intrinsics.areEqual(error, ErrorEntity.TimeOut.INSTANCE)) {
                C1993vg c1993vg = this.b.c;
                EnumC1628h tag = EnumC1628h.RETRIES;
                c1993vg.getClass();
                Intrinsics.checkNotNullParameter(tag, "tag");
                InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
                if (interfaceC2089zc == null || !((Boolean) interfaceC2089zc.a((Pe) null)).booleanValue()) {
                    on = new On(X6.a);
                } else {
                    r rVar = this.b;
                    D0 d02 = this.c;
                    CoroutineDispatcher coroutineDispatcher = this.d;
                    this.a = 2;
                    rVar.getClass();
                    obj = BuildersKt.withContext(coroutineDispatcher, new C1477an(rVar, d02, coroutineDispatcher, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    on = (co) obj;
                }
            } else {
                on = new Mn(new S1("Системная или внутренняя ошибка"));
            }
        } else {
            if (!(contentResponse instanceof ContentResponse.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            on = new On(Y6.a);
        }
        ((Jh) this.b.b).a(on);
        return Unit.INSTANCE;
    }
}
