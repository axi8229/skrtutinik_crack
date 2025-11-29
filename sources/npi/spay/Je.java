package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Je extends SuspendLambda implements Function2 {
    public final /* synthetic */ Td a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Je(Td td, Continuation continuation) {
        super(2, continuation);
        this.a = td;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Je(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Je(this.a, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Td td = this.a;
        C1560e6 event = new C1560e6(Ok.TOUCH_CONFIRMED_BY_USER, EnumC1877r0.BNPL_VIEW, C0.TOUCH, null, null, null, null, 120);
        td.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        td.a.a(event);
        C1993vg c1993vg = this.a.e;
        EnumC1628h tag = EnumC1628h.BNPL;
        c1993vg.getClass();
        Intrinsics.checkNotNullParameter(tag, "tag");
        InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
        if (interfaceC2089zc != null) {
            interfaceC2089zc.a(new C1983v6(true));
        }
        ((Jh) this.a.d).a(new C2050xn(C1825om.a, false));
        return Unit.INSTANCE;
    }
}
