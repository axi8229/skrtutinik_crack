package npi.spay;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* renamed from: npi.spay.bc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1491bc extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ Lifecycle.State c;
    public final /* synthetic */ Flow d;
    public final /* synthetic */ T9 e;
    public final /* synthetic */ C1591fc f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1491bc(Fragment fragment, Lifecycle.State state, Flow flow, Continuation continuation, T9 t9, C1591fc c1591fc) {
        super(2, continuation);
        this.b = fragment;
        this.c = state;
        this.d = flow;
        this.e = t9;
        this.f = c1591fc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1491bc(this.b, this.c, this.d, continuation, this.e, this.f);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1491bc) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Fragment fragment = this.b;
            Lifecycle.State state = this.c;
            C1466ac c1466ac = new C1466ac(this.d, null, this.e, this.f);
            this.a = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(fragment, state, c1466ac, this) == coroutine_suspended) {
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
