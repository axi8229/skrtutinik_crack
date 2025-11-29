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
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.ErrorEntity;

/* renamed from: npi.spay.jc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1690jc extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ C2015wd b;
    public final /* synthetic */ Ce c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1690jc(C2015wd c2015wd, Ce ce, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.b = c2015wd;
        this.c = ce;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1690jc(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1690jc) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        co qn;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((Jh) this.b.b).a(new C1900rn(new Y5(new C2097zk(R$string.spay_empty_string, CollectionsKt.emptyList()))));
            InterfaceC2073yl interfaceC2073yl = this.b.a;
            String str = this.c.a;
            this.a = 1;
            obj = ((Hm) interfaceC2073yl).a(str, this);
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
            qn = Intrinsics.areEqual(((ContentResponse.Failure) contentResponse).getError(), ErrorEntity.NoInternet.INSTANCE) ? new Mn(new C1581f2(new C1666ic(this.b, this.c, this.d, null))) : new Qn(new Ia(this.c.b));
        } else {
            if (!(contentResponse instanceof ContentResponse.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            qn = new Qn(new Ja(this.c.b));
        }
        ((Jh) this.b.b).a(qn);
        return Unit.INSTANCE;
    }
}
