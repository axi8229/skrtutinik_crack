package npi.spay;

import java.util.LinkedHashSet;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import spay.sdk.data.dto.MerchantDataWithOrderId;
import spay.sdk.domain.model.FraudMonInfo;
import spay.sdk.domain.model.HelperScenario;
import spay.sdk.domain.model.PayPartsStatus;
import spay.sdk.domain.model.Scenarios;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.OrderScreenDataResponse;
import spay.sdk.domain.model.response.PartsPaymentPlanBnplResponseBody;
import spay.sdk.domain.model.response.PartsPaymentPlanBnplResponseBodyKt;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;
import spay.sdk.domain.model.response.SessionIdResponseBody;
import spay.sdk.domain.model.response.bnpl.BnplPayment;
import spay.sdk.domain.model.response.bnpl.GraphBnpl;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class Di implements Ih {
    public final LinkedHashSet A;
    public final MutableStateFlow B;
    public String C;
    public Boolean a;
    public Uj b;
    public ContentResponse.Success c;
    public ContentResponse.Success d;
    public ContentResponse.Success e;
    public final MutableStateFlow f;
    public final MutableStateFlow g;
    public final StateFlow h;
    public MerchantDataWithOrderId i;
    public final MutableStateFlow j;
    public final StateFlow k;
    public final MutableStateFlow l;
    public String m;
    public String n;
    public final MutableStateFlow o;
    public boolean p;
    public FraudMonInfo q;
    public final MutableStateFlow r;
    public final MutableStateFlow s;
    public final MutableStateFlow t;
    public final MutableStateFlow u;
    public final StateFlow v;
    public final String w;
    public int x;
    public PayPartsStatus y;
    public HelperScenario z;

    public Di(CoroutineScope contractScope) {
        Intrinsics.checkNotNullParameter(contractScope, "contractScope");
        this.b = new Uj();
        this.f = StateFlowKt.MutableStateFlow(null);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this.g = MutableStateFlow;
        this.h = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this.j = MutableStateFlow2;
        this.k = FlowKt.asStateFlow(MutableStateFlow2);
        this.l = StateFlowKt.MutableStateFlow(null);
        this.o = StateFlowKt.MutableStateFlow(null);
        ContentResponse.Success success = this.e;
        success = success == null ? null : success;
        this.r = StateFlowKt.MutableStateFlow(success != null ? (PaymentPlanBnplResponseBody) success.getData() : null);
        ContentResponse.Success success2 = this.d;
        success2 = success2 == null ? null : success2;
        this.s = StateFlowKt.MutableStateFlow(success2 != null ? (ListOfCardsResponseBody) success2.getData() : null);
        this.t = StateFlowKt.MutableStateFlow(null);
        MutableStateFlow MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this.u = MutableStateFlow3;
        this.v = FlowKt.asStateFlow(MutableStateFlow3);
        this.w = "";
        this.y = PayPartsStatus.BASE_PAY;
        this.A = new LinkedHashSet();
        this.B = StateFlowKt.MutableStateFlow("-1");
        this.C = "";
    }

    public final StateFlow a() {
        return FlowKt.asStateFlow(this.l);
    }

    public final List b() {
        ListOfCardsResponseBody listOfCardsResponseBody;
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo;
        ContentResponse.Success success = this.d;
        if (success == null) {
            success = null;
        }
        if (success == null || (listOfCardsResponseBody = (ListOfCardsResponseBody) success.getData()) == null || (paymentToolInfo = listOfCardsResponseBody.getPaymentToolInfo()) == null) {
            return null;
        }
        return paymentToolInfo.getToolList();
    }

    public final MutableStateFlow c() {
        return this.r;
    }

    public final StateFlow d() {
        return this.v;
    }

    public final String e() {
        SessionIdResponseBody sessionIdResponseBody;
        String sessionId;
        ContentResponse.Success success = this.c;
        if (success == null) {
            success = null;
        }
        return (success == null || (sessionIdResponseBody = (SessionIdResponseBody) success.getData()) == null || (sessionId = sessionIdResponseBody.getSessionId()) == null) ? "-1" : sessionId;
    }

    public final StateFlow f() {
        return FlowKt.asStateFlow(this.o);
    }

    public final MutableStateFlow g() {
        return this.s;
    }

    public final StateFlow h() {
        return FlowKt.asStateFlow(this.f);
    }

    public final StateFlow i() {
        return this.k;
    }

    public final boolean j() {
        List listB = b();
        return !(listB == null || listB.isEmpty());
    }

    public final StateFlow k() {
        return this.h;
    }

    public final int l() {
        return this.x;
    }

    public final long m() {
        PaymentPlanBnplResponseBody paymentPlanBnplResponseBody;
        GraphBnpl graphBnpl;
        List<BnplPayment> payments;
        BnplPayment bnplPayment;
        OrderScreenDataResponse orderScreenDataResponse = (OrderScreenDataResponse) this.k.getValue();
        return AbstractC2095zi.a((orderScreenDataResponse == null || (paymentPlanBnplResponseBody = orderScreenDataResponse.getPaymentPlanBnplResponseBody()) == null || (graphBnpl = paymentPlanBnplResponseBody.getGraphBnpl()) == null || (payments = graphBnpl.getPayments()) == null || (bnplPayment = (BnplPayment) CollectionsKt.firstOrNull((List) payments)) == null) ? null : Long.valueOf(bnplPayment.getAmount()));
    }

    public final StateFlow n() {
        return FlowKt.asStateFlow(this.B);
    }

    public final PayPartsStatus o() {
        return this.y;
    }

    public final String p() {
        if (Scenarios.OrderIdScenario.INSTANCE == null) {
            throw new NoWhenBranchMatchedException();
        }
        MerchantDataWithOrderId merchantDataWithOrderId = this.i;
        String authorization = merchantDataWithOrderId != null ? merchantDataWithOrderId.getAuthorization() : null;
        return authorization == null ? "" : authorization;
    }

    public final ContentResponse.Success a(Boolean bool) {
        ContentResponse.Success success;
        if (!Intrinsics.areEqual(this.a, bool) || (success = this.d) == null) {
            return null;
        }
        return success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [spay.sdk.domain.model.response.OrderScreenDataResponse] */
    public final void a(ContentResponse.Success response, Boolean bool) {
        ContentResponse.Success success;
        ListOfCardsResponseBody listOfCardsResponseBody;
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList;
        ListOfCardsResponseBody.PromoInfo promoInfo;
        Intrinsics.checkNotNullParameter(response, "response");
        boolean zBooleanValue = false;
        Timber.INSTANCE.d("cacheListOfCardsResponse: " + response + ", priorityCardOnly: " + bool, new Object[0]);
        this.d = response;
        this.a = bool;
        MutableStateFlow mutableStateFlow = this.t;
        ListOfCardsResponseBody listOfCardsResponseBody2 = (ListOfCardsResponseBody) response.getData();
        mutableStateFlow.setValue((listOfCardsResponseBody2 == null || (promoInfo = listOfCardsResponseBody2.getPromoInfo()) == null) ? null : promoInfo.getBannerList());
        MutableStateFlow mutableStateFlow2 = this.u;
        ListOfCardsResponseBody listOfCardsResponseBody3 = (ListOfCardsResponseBody) response.getData();
        mutableStateFlow2.setValue(listOfCardsResponseBody3 != null ? listOfCardsResponseBody3.getMerchantInfo() : null);
        MutableStateFlow mutableStateFlow3 = this.s;
        ContentResponse.Success success2 = this.d;
        Intrinsics.checkNotNull(success2, "null cannot be cast to non-null type spay.sdk.domain.model.response.ContentResponse.Success<spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody>");
        mutableStateFlow3.tryEmit(success2.getData());
        MutableStateFlow mutableStateFlow4 = this.j;
        if (!Intrinsics.areEqual(this.a, bool) || (success = this.d) == null) {
            success = null;
        }
        if (success != null && (listOfCardsResponseBody = (ListOfCardsResponseBody) success.getData()) != null) {
            ContentResponse.Success success3 = this.e;
            if (success3 == null) {
                success3 = null;
            }
            orderScreenDataResponse = success3 != null ? (PaymentPlanBnplResponseBody) success3.getData() : null;
            OrderScreenDataResponse orderScreenDataResponse = (OrderScreenDataResponse) this.k.getValue();
            if (orderScreenDataResponse != null && orderScreenDataResponse.getMoreThanOneCard()) {
                zBooleanValue = true;
            } else if (Intrinsics.areEqual(listOfCardsResponseBody.getPaymentToolInfo().getAdditionalCards(), Boolean.TRUE) || ((toolList = listOfCardsResponseBody.getPaymentToolInfo().getToolList()) != null && AbstractC2095zi.a(Integer.valueOf(toolList.size()), 1))) {
                Boolean additionalCards = listOfCardsResponseBody.getPaymentToolInfo().getAdditionalCards();
                Intrinsics.checkNotNull(additionalCards);
                zBooleanValue = additionalCards.booleanValue();
            }
            orderScreenDataResponse = new OrderScreenDataResponse(listOfCardsResponseBody, orderScreenDataResponse, zBooleanValue);
        }
        mutableStateFlow4.setValue(orderScreenDataResponse);
    }

    public final void a(OrderScreenDataResponse orderScreenDataResponse) {
        Unit unit;
        OrderScreenDataResponse orderScreenDataResponseCopy;
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList;
        if (orderScreenDataResponse != null) {
            MutableStateFlow mutableStateFlow = this.j;
            OrderScreenDataResponse orderScreenDataResponse2 = (OrderScreenDataResponse) this.k.getValue();
            if (orderScreenDataResponse2 != null) {
                ListOfCardsResponseBody listOfCardsResponseBody = orderScreenDataResponse.getListOfCardsResponseBody();
                PaymentPlanBnplResponseBody paymentPlanBnplResponseBody = orderScreenDataResponse.getPaymentPlanBnplResponseBody();
                boolean z = true;
                if (!Intrinsics.areEqual(orderScreenDataResponse.getListOfCardsResponseBody().getPaymentToolInfo().getAdditionalCards(), Boolean.TRUE) && ((toolList = orderScreenDataResponse.getListOfCardsResponseBody().getPaymentToolInfo().getToolList()) == null || !AbstractC2095zi.a(Integer.valueOf(toolList.size()), 1))) {
                    z = false;
                }
                orderScreenDataResponseCopy = orderScreenDataResponse2.copy(listOfCardsResponseBody, paymentPlanBnplResponseBody, z);
            } else {
                orderScreenDataResponseCopy = null;
            }
            mutableStateFlow.setValue(orderScreenDataResponseCopy);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.j.setValue(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [spay.sdk.domain.model.response.OrderScreenDataResponse] */
    public final void a(PartsPaymentPlanBnplResponseBody data) {
        ContentResponse.Success success;
        ListOfCardsResponseBody listOfCardsResponseBody;
        Intrinsics.checkNotNullParameter(data, "data");
        ContentResponse.Success success2 = new ContentResponse.Success(PartsPaymentPlanBnplResponseBodyKt.mapToPaymentPlanBnplResponseBody(data));
        this.e = success2;
        this.r.tryEmit((PaymentPlanBnplResponseBody) success2.getData());
        MutableStateFlow mutableStateFlow = this.j;
        if (!Intrinsics.areEqual(this.a, Boolean.FALSE) || (success = this.d) == null) {
            success = null;
        }
        if (success != null && (listOfCardsResponseBody = (ListOfCardsResponseBody) success.getData()) != null) {
            ContentResponse.Success success3 = this.e;
            if (success3 == null) {
                success3 = null;
            }
            orderScreenDataResponse = new OrderScreenDataResponse(listOfCardsResponseBody, success3 != null ? (PaymentPlanBnplResponseBody) success3.getData() : null, false, 4, null);
        }
        mutableStateFlow.setValue(orderScreenDataResponse);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [spay.sdk.domain.model.response.OrderScreenDataResponse] */
    public final void a(ContentResponse.Success paymentPlanBnplResponseBodyContentResponse) {
        ContentResponse.Success success;
        ListOfCardsResponseBody listOfCardsResponseBody;
        Intrinsics.checkNotNullParameter(paymentPlanBnplResponseBodyContentResponse, "paymentPlanBnplResponseBodyContentResponse");
        this.e = paymentPlanBnplResponseBodyContentResponse;
        this.r.tryEmit((PaymentPlanBnplResponseBody) paymentPlanBnplResponseBodyContentResponse.getData());
        MutableStateFlow mutableStateFlow = this.j;
        if (!Intrinsics.areEqual(this.a, Boolean.FALSE) || (success = this.d) == null) {
            success = null;
        }
        if (success != null && (listOfCardsResponseBody = (ListOfCardsResponseBody) success.getData()) != null) {
            ContentResponse.Success success2 = this.e;
            if (success2 == null) {
                success2 = null;
            }
            orderScreenDataResponse = new OrderScreenDataResponse(listOfCardsResponseBody, success2 != null ? (PaymentPlanBnplResponseBody) success2.getData() : null, false, 4, null);
        }
        mutableStateFlow.setValue(orderScreenDataResponse);
    }
}
