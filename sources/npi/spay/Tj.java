package npi.spay;

import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* loaded from: classes4.dex */
public final class Tj extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ Nk b;
    public final /* synthetic */ C1849pl c;
    public final /* synthetic */ CoroutineDispatcher d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tj(Nk nk, C1849pl c1849pl, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.b = nk;
        this.c = c1849pl;
        this.d = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Tj(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((Tj) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Nk nk = this.b;
            int i2 = nk.g;
            if (i2 >= 3) {
                return new On(X6.a);
            }
            nk.g = i2 + 1;
            C1849pl c1849pl = this.c;
            CoroutineDispatcher coroutineDispatcher = this.d;
            this.a = 1;
            if (nk.b(c1849pl, coroutineDispatcher, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                throw new KotlinNothingValueException();
            }
            ResultKt.throwOnFailure(obj);
        }
        this.a = 2;
        if (DelayKt.awaitCancellation(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        throw new KotlinNothingValueException();
    }
}
