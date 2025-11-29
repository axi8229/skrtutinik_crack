package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* renamed from: npi.spay.od, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1816od extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ Flow b;
    public final /* synthetic */ C1790nc c;
    public final /* synthetic */ C1940td d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1816od(Continuation continuation, Flow flow, C1790nc c1790nc, C1940td c1940td) {
        super(2, continuation);
        this.b = flow;
        this.c = c1790nc;
        this.d = c1940td;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1816od(continuation, this.b, this.c, this.d);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1816od) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flow = this.b;
            C1791nd c1791nd = new C1791nd(this.c, this.d);
            this.a = 1;
            if (flow.collect(c1791nd, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
