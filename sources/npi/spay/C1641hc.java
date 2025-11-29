package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sberid.sdk.auth.model.SberIDResultModel;
import spay.sdk.domain.model.Scenarios;

/* renamed from: npi.spay.hc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1641hc extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ spay.sdk.a b;
    public final /* synthetic */ SberIDResultModel c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1641hc(spay.sdk.a aVar, SberIDResultModel sberIDResultModel, Continuation continuation) {
        super(2, continuation);
        this.b = aVar;
        this.c = sberIDResultModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1641hc(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C1641hc(this.b, this.c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((Di) this.b.b).getClass();
            Scenarios.OrderIdScenario orderIdScenario = Scenarios.OrderIdScenario.INSTANCE;
            if (Intrinsics.areEqual(orderIdScenario, orderIdScenario)) {
                spay.sdk.a aVar = this.b;
                SberIDResultModel sberIDResultModel = this.c;
                this.a = 1;
                if (spay.sdk.a.a(aVar, sberIDResultModel, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (Intrinsics.areEqual(orderIdScenario, Scenarios.PurchaseScenario.INSTANCE)) {
                spay.sdk.a aVar2 = this.b;
                SberIDResultModel sberIDResultModel2 = this.c;
                this.a = 2;
                if (spay.sdk.a.b(aVar2, sberIDResultModel2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
