package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import spay.sdk.domain.model.request.PaymentBnplPlanRequestBody;

/* renamed from: npi.spay.ek, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1574ek extends SuspendLambda implements Function2 {
    public Uk a;
    public C1697jj b;
    public CoroutineDispatcher c;
    public Uk d;
    public Flow e;
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ Uk h;
    public final /* synthetic */ Flow i;
    public final /* synthetic */ C1697jj j;
    public final /* synthetic */ CoroutineDispatcher k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1574ek(Uk uk, Flow flow, C1697jj c1697jj, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.h = uk;
        this.i = flow;
        this.j = c1697jj;
        this.k = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1574ek c1574ek = new C1574ek(this.h, this.i, this.j, this.k, continuation);
        c1574ek.g = obj;
        return c1574ek;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1574ek) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Uk uk;
        Flow flow;
        C1697jj c1697jj;
        CoroutineDispatcher coroutineDispatcher;
        Uk uk2;
        Flow flow2;
        Flow flow3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.g;
            uk = this.h;
            flow = this.i;
            c1697jj = this.j;
            CoroutineDispatcher coroutineDispatcher2 = this.k;
            PaymentBnplPlanRequestBody paymentBnplPlanRequestBody = uk.b;
            if (paymentBnplPlanRequestBody == null) {
                coroutineDispatcher = coroutineDispatcher2;
                uk2 = uk;
                c1697jj.getClass();
                flow2 = flow;
                flow3 = FlowKt.flow(new Ai(null));
                FlowKt.launchIn(FlowKt.onEach(FlowKt.flowOn(FlowKt.zip(flow2, flow3, new C1524ck(c1697jj, uk, coroutineDispatcher, null)), coroutineDispatcher), new C1549dk(c1697jj, null)), coroutineScope);
                return uk2;
            }
            C1731l3 c1731l3 = c1697jj.c;
            C1483b4 c1483b4 = new C1483b4(uk.c, paymentBnplPlanRequestBody);
            this.g = coroutineScope;
            this.a = uk;
            this.b = c1697jj;
            this.c = coroutineDispatcher2;
            this.d = uk;
            this.e = flow;
            this.f = 1;
            Dispatchers.getIO();
            c1731l3.getClass();
            Flow flow4 = FlowKt.flow(new C1829p1(c1731l3, c1483b4, null));
            if (flow4 == coroutine_suspended) {
                return coroutine_suspended;
            }
            flow2 = flow;
            obj = flow4;
            coroutineDispatcher = coroutineDispatcher2;
            uk2 = uk;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flow2 = this.e;
            uk = this.d;
            coroutineDispatcher = this.c;
            c1697jj = this.b;
            uk2 = this.a;
            coroutineScope = (CoroutineScope) this.g;
            ResultKt.throwOnFailure(obj);
        }
        flow3 = (Flow) obj;
        if (flow3 == null) {
            flow = flow2;
            c1697jj.getClass();
            flow2 = flow;
            flow3 = FlowKt.flow(new Ai(null));
        }
        FlowKt.launchIn(FlowKt.onEach(FlowKt.flowOn(FlowKt.zip(flow2, flow3, new C1524ck(c1697jj, uk, coroutineDispatcher, null)), coroutineDispatcher), new C1549dk(c1697jj, null)), coroutineScope);
        return uk2;
    }
}
