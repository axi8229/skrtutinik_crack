package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes4.dex */
public final class Qg extends SuspendLambda implements Function2 {
    public final /* synthetic */ spay.sdk.a a;
    public final /* synthetic */ Throwable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Qg(spay.sdk.a aVar, Throwable th, Continuation continuation) {
        super(2, continuation);
        this.a = aVar;
        this.b = th;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Qg(this.a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Qg(this.a, this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        InterfaceC1495bg interfaceC1495bg = this.a.m;
        String message = this.b.getMessage();
        if (message == null) {
            message = "No exception message";
        }
        ((Jh) interfaceC1495bg).a(new Mn(new S1("UNCAUGHT_EXCEPTION : ".concat(message))));
        return Unit.INSTANCE;
    }
}
