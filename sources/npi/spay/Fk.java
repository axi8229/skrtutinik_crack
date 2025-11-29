package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Fk extends SuspendLambda implements Function2 {
    public final /* synthetic */ Jj a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fk(Jj jj, Continuation continuation) {
        super(2, continuation);
        this.a = jj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Fk(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Fk(this.a, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Jj jj = this.a;
        C1560e6 event = new C1560e6(Sl.TOUCH_CANCEL, EnumC1877r0.BNPL_PARTS_VIEW, C0.TOUCH, null, null, null, null, 120);
        jj.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        jj.a.a(event);
        ((Jh) this.a.c).a(C1975un.a);
        return Unit.INSTANCE;
    }
}
