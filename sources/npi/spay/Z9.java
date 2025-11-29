package npi.spay;

import android.content.Context;
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

/* loaded from: classes4.dex */
public final class Z9 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ Lifecycle.State c;
    public final /* synthetic */ Flow d;
    public final /* synthetic */ C2072yk e;
    public final /* synthetic */ Context f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z9(Fragment fragment, Lifecycle.State state, Flow flow, Continuation continuation, C2072yk c2072yk, Context context) {
        super(2, continuation);
        this.b = fragment;
        this.c = state;
        this.d = flow;
        this.e = c2072yk;
        this.f = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Z9(this.b, this.c, this.d, continuation, this.e, this.f);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((Z9) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Fragment fragment = this.b;
            Lifecycle.State state = this.c;
            Y9 y9 = new Y9(this.d, null, this.e, this.f);
            this.a = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(fragment, state, y9, this) == coroutine_suspended) {
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
