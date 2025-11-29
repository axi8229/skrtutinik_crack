package npi.spay;

import java.util.Iterator;
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
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.ErrorEntity;
import spay.sdk.domain.model.response.SPaySdkConfig;
import spay.sdk.domain.model.response.SessionIdResponseBody;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class Gg extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ C1795nh b;
    public final /* synthetic */ CoroutineDispatcher c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Gg(C1795nh c1795nh, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.b = c1795nh;
        this.c = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Gg(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((Gg) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object next;
        co rn;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((Jh) this.b.c).a(new C1900rn(new C1485b6(new C2097zk(R$string.spay_empty_string, CollectionsKt.emptyList()))));
            C1795nh c1795nh = this.b;
            InterfaceC1713ka interfaceC1713ka = c1795nh.b;
            SPaySdkConfig sPaySdkConfig = ((O0) c1795nh.f).c;
            if (sPaySdkConfig == null) {
                throw C1808o5.a;
            }
            Iterator<T> it = sPaySdkConfig.getSchemas().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                SPaySdkConfig.Schema schema = (SPaySdkConfig.Schema) next;
                if (Intrinsics.areEqual(schema != null ? schema.getStand() : null, Fd.a())) {
                    break;
                }
            }
            SPaySdkConfig.Schema schema2 = (SPaySdkConfig.Schema) next;
            String getIpUrl = schema2 != null ? schema2.getGetIpUrl() : null;
            this.a = 1;
            if (((Db) interfaceC1713ka).a(getIpUrl, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ContentResponse contentResponse = (ContentResponse) obj;
                if (contentResponse instanceof ContentResponse.Failure) {
                    ContentResponse.Failure failure = (ContentResponse.Failure) contentResponse;
                    ErrorEntity error = failure.getError();
                    rn = error instanceof ErrorEntity.ApiError ? new Mn(new K1(failure.getError())) : Intrinsics.areEqual(error, ErrorEntity.NoInternet.INSTANCE) ? new Mn(new C1581f2(new Fg(this.b, this.c, null))) : Intrinsics.areEqual(error, ErrorEntity.TimeOut.INSTANCE) ? new Mn(new V1()) : Intrinsics.areEqual(error, ErrorEntity.Unknown.INSTANCE) ? new Mn(new S1("Системная или внутренняя ошибка")) : new Mn(new S1("Некорректный формат запроса или ответа"));
                } else {
                    if (!(contentResponse instanceof ContentResponse.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Object data = ((ContentResponse.Success) contentResponse).getData();
                    Intrinsics.checkNotNull(data);
                    SessionIdResponseBody sessionIdResponseBody = (SessionIdResponseBody) data;
                    Di di = (Di) this.b.d;
                    di.getClass();
                    di.b = new Uj();
                    Timber.INSTANCE.i("B3Header regenerated " + di.b, new Object[0]);
                    C1993vg c1993vg = this.b.e;
                    EnumC1628h tag = EnumC1628h.BNPL;
                    c1993vg.getClass();
                    Intrinsics.checkNotNullParameter(tag, "tag");
                    InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
                    if (interfaceC2089zc != null) {
                        Boolean boolIsBnplEnabled = sessionIdResponseBody.isBnplEnabled();
                        interfaceC2089zc.a(new C1933t6(boolIsBnplEnabled != null ? boolIsBnplEnabled.booleanValue() : false));
                    }
                    rn = new Rn(sessionIdResponseBody);
                }
                ((Jh) this.b.c).a(rn);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        InterfaceC2073yl interfaceC2073yl = this.b.a;
        throw null;
    }
}
