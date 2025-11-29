package npi.spay;

import androidx.appcompat.app.AppCompatActivity;
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
import spay.sdk.RedirectActivity;

/* loaded from: classes4.dex */
public final class E4 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ AppCompatActivity b;
    public final /* synthetic */ Lifecycle.State c;
    public final /* synthetic */ Flow d;
    public final /* synthetic */ RedirectActivity e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E4(AppCompatActivity appCompatActivity, Lifecycle.State state, Flow flow, Continuation continuation, RedirectActivity redirectActivity) {
        super(2, continuation);
        this.b = appCompatActivity;
        this.c = state;
        this.d = flow;
        this.e = redirectActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new E4(this.b, this.c, this.d, continuation, this.e);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((E4) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AppCompatActivity appCompatActivity = this.b;
            Lifecycle.State state = this.c;
            D4 d4 = new D4(this.d, null, this.e);
            this.a = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(appCompatActivity, state, d4, this) == coroutine_suspended) {
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
