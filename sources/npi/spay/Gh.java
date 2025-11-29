package npi.spay;

import com.google.android.gms.location.DeviceOrientationRequest;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutKt;

/* loaded from: classes4.dex */
public final class Gh extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ InterfaceC1728l0 b;
    public final /* synthetic */ spay.sdk.a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Gh(Continuation continuation, spay.sdk.a aVar, InterfaceC1728l0 interfaceC1728l0) {
        super(2, continuation);
        this.b = interfaceC1728l0;
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Gh(continuation, this.c, this.b);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Gh((Continuation) obj2, this.c, this.b).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        Unit unit = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Fh fh = new Fh(this.b, null);
            this.a = 1;
            obj = TimeoutKt.withTimeoutOrNull(DeviceOrientationRequest.OUTPUT_PERIOD_FAST, fh, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((Unit) obj) != null) {
            ((Jh) this.c.m).a(C2025wn.a);
            unit = Unit.INSTANCE;
        }
        if (unit != null) {
            return Unit.INSTANCE;
        }
        throw C1885r8.a;
    }
}
