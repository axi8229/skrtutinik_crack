package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class Df extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ Xf b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Df(Xf xf, Continuation continuation) {
        super(2, continuation);
        this.b = xf;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Df df = new Df(this.b, continuation);
        df.a = obj;
        return df;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Df df = new Df(this.b, (Continuation) obj2);
        df.a = (ListOfCardsResponseBody.PaymentToolInfo.Tool) obj;
        return df.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ListOfCardsResponseBody.PaymentToolInfo.Tool tool = (ListOfCardsResponseBody.PaymentToolInfo.Tool) this.a;
        C1993vg c1993vg = this.b.d;
        EnumC1628h tag = EnumC1628h.S_BONUSES;
        c1993vg.getClass();
        Intrinsics.checkNotNullParameter(tag, "tag");
        InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
        return Boxing.boxInt((interfaceC2089zc == null || !((Boolean) interfaceC2089zc.a((Pe) null)).booleanValue()) ? 0 : AbstractC1946tj.d(tool.getPrecalculateBonuses()));
    }
}
