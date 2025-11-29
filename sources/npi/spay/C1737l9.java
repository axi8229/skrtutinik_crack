package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import spay.sdk.domain.model.Scenarios;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* renamed from: npi.spay.l9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1737l9 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ spay.sdk.a b;
    public final /* synthetic */ ListOfCardsResponseBody.PaymentToolInfo.Tool c;
    public final /* synthetic */ boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1737l9(spay.sdk.a aVar, ListOfCardsResponseBody.PaymentToolInfo.Tool tool, boolean z, Continuation continuation) {
        super(2, continuation);
        this.b = aVar;
        this.c = tool;
        this.d = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1737l9(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1737l9) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((Di) this.b.b).getClass();
            if (Scenarios.OrderIdScenario.INSTANCE != null) {
                spay.sdk.a aVar = this.b;
                ListOfCardsResponseBody.PaymentToolInfo.Tool tool = this.c;
                boolean z = this.d;
                this.a = 2;
                if (spay.sdk.a.a(aVar, tool, z, this) == coroutine_suspended) {
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
