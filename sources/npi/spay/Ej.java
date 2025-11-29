package npi.spay;

import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class Ej extends SuspendLambda implements Function2 {
    public final /* synthetic */ Jj a;
    public final /* synthetic */ Ih b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ej(Jj jj, Ih ih, Continuation continuation) {
        super(2, continuation);
        this.a = jj;
        this.b = ih;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Ej(this.a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Ej(this.a, this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo;
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList;
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo2;
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList2;
        Object next;
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo3;
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList3;
        Object next2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ListOfCardsResponseBody.PaymentToolInfo.Tool incomeSelectedCard = ((C1604g0) ((C1822oj) this.a.d).b.getValue()).b;
        if (incomeSelectedCard == null) {
            ListOfCardsResponseBody listOfCardsResponseBody = (ListOfCardsResponseBody) this.a.l.getValue();
            if (listOfCardsResponseBody == null || (paymentToolInfo3 = listOfCardsResponseBody.getPaymentToolInfo()) == null || (toolList3 = paymentToolInfo3.getToolList()) == null) {
                incomeSelectedCard = null;
            } else {
                Ih ih = this.b;
                Iterator<T> it = toolList3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    ListOfCardsResponseBody.PaymentToolInfo.Tool tool = (ListOfCardsResponseBody.PaymentToolInfo.Tool) next2;
                    if (tool.getPriorityCard()) {
                        ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData = tool.getAmountData();
                        if (AbstractC2095zi.a(amountData != null ? Boxing.boxLong(amountData.getAmount()) : null) >= ((Di) ih).m()) {
                            break;
                        }
                    }
                }
                incomeSelectedCard = (ListOfCardsResponseBody.PaymentToolInfo.Tool) next2;
            }
            if (incomeSelectedCard == null) {
                ListOfCardsResponseBody listOfCardsResponseBody2 = (ListOfCardsResponseBody) this.a.l.getValue();
                if (listOfCardsResponseBody2 == null || (paymentToolInfo2 = listOfCardsResponseBody2.getPaymentToolInfo()) == null || (toolList2 = paymentToolInfo2.getToolList()) == null) {
                    incomeSelectedCard = null;
                } else {
                    Ih ih2 = this.b;
                    Iterator<T> it2 = toolList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData2 = ((ListOfCardsResponseBody.PaymentToolInfo.Tool) next).getAmountData();
                        if (AbstractC2095zi.a(amountData2 != null ? Boxing.boxLong(amountData2.getAmount()) : null) >= ((Di) ih2).m()) {
                            break;
                        }
                    }
                    incomeSelectedCard = (ListOfCardsResponseBody.PaymentToolInfo.Tool) next;
                }
                if (incomeSelectedCard == null) {
                    ListOfCardsResponseBody listOfCardsResponseBody3 = (ListOfCardsResponseBody) this.a.l.getValue();
                    incomeSelectedCard = (listOfCardsResponseBody3 == null || (paymentToolInfo = listOfCardsResponseBody3.getPaymentToolInfo()) == null || (toolList = paymentToolInfo.getToolList()) == null) ? null : toolList.get(0);
                }
            }
        }
        if (incomeSelectedCard != null) {
            C1822oj c1822oj = (C1822oj) this.a.d;
            c1822oj.getClass();
            Intrinsics.checkNotNullParameter(incomeSelectedCard, "incomeSelectedCard");
            MutableStateFlow mutableStateFlow = c1822oj.a;
            mutableStateFlow.setValue(C1604g0.a((C1604g0) mutableStateFlow.getValue(), null, incomeSelectedCard, false, 5));
        }
        return incomeSelectedCard;
    }
}
