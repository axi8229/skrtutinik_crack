package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.tokenize.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2528e extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ s b;
    public final /* synthetic */ z c;
    public final /* synthetic */ Out.Builder d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2528e(s sVar, z zVar, Out.Builder builder, Continuation continuation) {
        super(1, continuation);
        this.b = sVar;
        this.c = zVar;
        this.d = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C2528e(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((C2528e) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.b.b;
            B b = new B(((u) this.c).a, ((F) this.d.getState()).a.a());
            this.a = 1;
            if (function2.invoke(b, this) == coroutine_suspended) {
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
