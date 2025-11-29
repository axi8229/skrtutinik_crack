package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* renamed from: npi.spay.h1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1630h1 extends SuspendLambda implements Function2 {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C1655i1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1630h1(C1655i1 c1655i1, Continuation continuation) {
        super(2, continuation);
        this.c = c1655i1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1630h1 c1630h1 = new C1630h1(this.c, continuation);
        c1630h1.b = obj;
        return c1630h1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C1630h1 c1630h1 = new C1630h1(this.c, (Continuation) obj2);
        c1630h1.b = (ProducerScope) obj;
        return c1630h1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.b;
            C1605g1 c1605g1 = new C1605g1(producerScope);
            C1655i1 c1655i1 = this.c;
            c1655i1.e = c1605g1;
            C1580f1 c1580f1 = new C1580f1(c1655i1);
            this.a = 1;
            if (ProduceKt.awaitClose(producerScope, c1580f1, this) == coroutine_suspended) {
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
