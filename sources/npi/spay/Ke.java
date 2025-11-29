package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import spay.sdk.domain.model.HelperScenario;
import spay.sdk.domain.model.PayPartsStatus;

/* loaded from: classes4.dex */
public final class Ke extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ C1869qg b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ke(C1869qg c1869qg, Continuation continuation) {
        super(2, continuation);
        this.b = c1869qg;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Ke(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Ke(this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        co c2050xn;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.a = 1;
            if (DelayKt.delay(350L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        C1869qg c1869qg = this.b;
        InterfaceC1495bg interfaceC1495bg = c1869qg.e;
        Di di = (Di) c1869qg.b;
        if (di.y == PayPartsStatus.ONLY_PARTS_PAY) {
            c2050xn = C1950tn.a;
        } else if (di.z == HelperScenario.BNPL) {
            PayPartsStatus status = PayPartsStatus.PARTS_START_PAY;
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(status, "<set-?>");
            di.y = status;
            c2050xn = C1950tn.a;
        } else {
            c2050xn = new C2050xn((InterfaceC1850pm) c1869qg.f.getValue(c1869qg, C1869qg.j[0]), false);
        }
        ((Jh) interfaceC1495bg).a(c2050xn);
        return Unit.INSTANCE;
    }
}
