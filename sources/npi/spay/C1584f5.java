package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;

/* renamed from: npi.spay.f5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1584f5 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ C2081z4 b;
    public final /* synthetic */ C1674il c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1584f5(C2081z4 c2081z4, C1674il c1674il, Continuation continuation) {
        super(2, continuation);
        this.b = c2081z4;
        this.c = c1674il;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1584f5(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C1584f5(this.b, this.c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Hk hk = this.b.f;
            C1674il c1674il = this.c;
            this.a = 1;
            if (hk.a(c1674il, Dispatchers.getIO(), this) == coroutine_suspended) {
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
