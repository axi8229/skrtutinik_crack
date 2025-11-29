package ru.yoomoney.sdk.kassa.payments.userAuth;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class C extends SuspendLambda implements Function1 {
    public int a;
    public final /* synthetic */ K b;
    public final /* synthetic */ AbstractC2546i c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(K k, AbstractC2546i abstractC2546i, Continuation continuation) {
        super(1, continuation);
        this.b = k;
        this.c = abstractC2546i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new C(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new C(this.b, this.c, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC2538a interfaceC2538a = this.b.g;
            String str = ((C2544g) this.c).a;
            this.a = 1;
            Object objMo3348getDataIoAF18A = ((C2539b) interfaceC2538a).a.mo3348getDataIoAF18A(str);
            obj = Result.m2631exceptionOrNullimpl(objMo3348getDataIoAF18A) == null ? new C2543f((String) objMo3348getDataIoAF18A, null, null, new ru.yoomoney.sdk.kassa.payments.metrics.B()) : C2541d.a;
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
