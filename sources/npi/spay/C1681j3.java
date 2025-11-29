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
import spay.sdk.domain.model.response.AuthResponseBody;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.ErrorEntity;

/* renamed from: npi.spay.j3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1681j3 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ Z3 b;
    public final /* synthetic */ CoroutineDispatcher c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1681j3(Z3 z3, Y4 y4, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.b = z3;
        this.c = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1681j3(this.b, null, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1681j3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        co c2075yn;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC2073yl interfaceC2073yl = this.b.a;
            throw null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ContentResponse contentResponse = (ContentResponse) obj;
        if (contentResponse instanceof ContentResponse.Failure) {
            ContentResponse.Failure failure = (ContentResponse.Failure) contentResponse;
            ErrorEntity error = failure.getError();
            c2075yn = error instanceof ErrorEntity.ApiError ? new Mn(new K1(failure.getError())) : Intrinsics.areEqual(error, ErrorEntity.NoInternet.INSTANCE) ? new Mn(new C1581f2(new C1657i3(this.b, null, this.c, null))) : Intrinsics.areEqual(error, ErrorEntity.TimeOut.INSTANCE) ? new Mn(new V1()) : Intrinsics.areEqual(error, ErrorEntity.Unknown.INSTANCE) ? new Mn(new S1("Системная или внутренняя ошибка")) : new Mn(new S1("Некорректный формат запроса или ответа"));
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
