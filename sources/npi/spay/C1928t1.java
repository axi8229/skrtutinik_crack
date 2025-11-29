package npi.spay;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;
import spay.sdk.domain.model.response.bnpl.BnplPayment;
import spay.sdk.domain.model.response.bnpl.GraphBnpl;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;
import timber.log.Timber;

/* renamed from: npi.spay.t1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1928t1 {
    public final C1993vg a;
    public final Ih b;
    public final Ei c;
    public final InterfaceC1728l0 d;
    public final MutableStateFlow e;
    public final MutableStateFlow f;
    public final StateFlow g;

    public C1928t1(C1993vg featuresHandler, Ih sPayDataContract, Ei sPayStorage, InterfaceC1728l0 sPaySdkConfigRepository) {
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        this.a = featuresHandler;
        this.b = sPayDataContract;
        this.c = sPayStorage;
        this.d = sPaySdkConfigRepository;
        Di di = (Di) sPayDataContract;
        this.e = di.g();
        this.f = di.c();
        this.g = di.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List a() {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1928t1.a():java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b() {
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo;
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList;
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo2;
        ListOfCardsResponseBody listOfCardsResponseBody = (ListOfCardsResponseBody) this.e.getValue();
        Long l = null;
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList2 = (listOfCardsResponseBody == null || (paymentToolInfo2 = listOfCardsResponseBody.getPaymentToolInfo()) == null) ? null : paymentToolInfo2.getToolList();
        if (toolList2 != null && !toolList2.isEmpty()) {
            ListOfCardsResponseBody listOfCardsResponseBody2 = (ListOfCardsResponseBody) this.e.getValue();
            if (listOfCardsResponseBody2 != null && (paymentToolInfo = listOfCardsResponseBody2.getPaymentToolInfo()) != null && (toolList = paymentToolInfo.getToolList()) != null) {
                Iterator<T> it = toolList.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData = ((ListOfCardsResponseBody.PaymentToolInfo.Tool) it.next()).getAmountData();
                Long lValueOf = Long.valueOf(AbstractC2095zi.a(amountData != null ? Long.valueOf(amountData.getAmount()) : null));
                while (it.hasNext()) {
                    ListOfCardsResponseBody.PaymentToolInfo.Tool.AmountData amountData2 = ((ListOfCardsResponseBody.PaymentToolInfo.Tool) it.next()).getAmountData();
                    Long lValueOf2 = Long.valueOf(AbstractC2095zi.a(amountData2 != null ? Long.valueOf(amountData2.getAmount()) : null));
                    if (lValueOf.compareTo(lValueOf2) < 0) {
                        lValueOf = lValueOf2;
                    }
                }
                l = lValueOf;
            }
            if (AbstractC2095zi.a(l) >= e() && this.f.getValue() != 0) {
                C1993vg c1993vg = this.a;
                EnumC1628h tag = EnumC1628h.BNPL;
                c1993vg.getClass();
                Intrinsics.checkNotNullParameter(tag, "tag");
                InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
                if (interfaceC2089zc != null && ((Boolean) interfaceC2089zc.a(EnumC1908s6.BY_SYSTEM)).booleanValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c() {
        ListOfCardsResponseBody.PaymentToolInfo paymentToolInfo;
        ListOfCardsResponseBody listOfCardsResponseBody = (ListOfCardsResponseBody) this.e.getValue();
        List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toolList = (listOfCardsResponseBody == null || (paymentToolInfo = listOfCardsResponseBody.getPaymentToolInfo()) == null) ? null : paymentToolInfo.getToolList();
        return (toolList == null || toolList.isEmpty() || f() >= d()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long d() {
        ListOfCardsResponseBody.OrderInfo orderInfo;
        ListOfCardsResponseBody.OrderInfo.OrderAmount orderAmount;
        ListOfCardsResponseBody listOfCardsResponseBody = (ListOfCardsResponseBody) this.e.getValue();
        return AbstractC2095zi.a((listOfCardsResponseBody == null || (orderInfo = listOfCardsResponseBody.getOrderInfo()) == null || (orderAmount = orderInfo.getOrderAmount()) == null) ? null : Long.valueOf(orderAmount.getAmount()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long e() {
        GraphBnpl graphBnpl;
        List<BnplPayment> payments;
        BnplPayment bnplPayment;
        PaymentPlanBnplResponseBody paymentPlanBnplResponseBody = (PaymentPlanBnplResponseBody) this.f.getValue();
        return AbstractC2095zi.a((paymentPlanBnplResponseBody == null || (graphBnpl = paymentPlanBnplResponseBody.getGraphBnpl()) == null || (payments = graphBnpl.getPayments()) == null || (bnplPayment = payments.get(0)) == null) ? null : Long.valueOf(bnplPayment.getAmount()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
    
        if (r0 != null) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long f() {
        /*
            r4 = this;
            npi.spay.Ei r0 = r4.c
            npi.spay.oj r0 = (npi.spay.C1822oj) r0
            kotlinx.coroutines.flow.StateFlow r0 = r0.b
            java.lang.Object r0 = r0.getValue()
            npi.spay.g0 r0 = (npi.spay.C1604g0) r0
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r0 = r0.b
            if (r0 == 0) goto L17
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool$AmountData r0 = r0.getAmountData()
            if (r0 == 0) goto L17
            goto L51
        L17:
            kotlinx.coroutines.flow.MutableStateFlow r0 = r4.e
            java.lang.Object r0 = r0.getValue()
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody r0 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody) r0
            r1 = 0
            if (r0 == 0) goto L56
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo r0 = r0.getPaymentToolInfo()
            if (r0 == 0) goto L56
            java.util.List r0 = r0.getToolList()
            if (r0 == 0) goto L56
            java.util.Iterator r0 = r0.iterator()
        L32:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L46
            java.lang.Object r2 = r0.next()
            r3 = r2
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r3 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool) r3
            boolean r3 = r3.getPriorityCard()
            if (r3 == 0) goto L32
            goto L47
        L46:
            r2 = r1
        L47:
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r2 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool) r2
            if (r2 == 0) goto L56
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool$AmountData r0 = r2.getAmountData()
            if (r0 == 0) goto L56
        L51:
            long r0 = r0.getAmount()
            goto L87
        L56:
            kotlinx.coroutines.flow.MutableStateFlow r0 = r4.e
            java.lang.Object r0 = r0.getValue()
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody r0 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody) r0
            if (r0 == 0) goto L83
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo r0 = r0.getPaymentToolInfo()
            if (r0 == 0) goto L83
            java.util.List r0 = r0.getToolList()
            if (r0 == 0) goto L83
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool r0 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool) r0
            if (r0 == 0) goto L83
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool$AmountData r0 = r0.getAmountData()
            if (r0 == 0) goto L83
            long r0 = r0.getAmount()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
        L83:
            long r0 = npi.spay.AbstractC2095zi.a(r1)
        L87:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1928t1.f():long");
    }

    public final boolean g() {
        ListOfCardsResponseBody.MerchantInfo merchantInfo;
        long jD = d();
        Timber.Tree treeTag = Timber.INSTANCE.tag("HelperManager");
        StringBuilder sb = new StringBuilder("isZeroOrderAmount: required amount: ");
        sb.append(jD == 0);
        sb.append(" & is binding needed: ");
        ListOfCardsResponseBody.MerchantInfo merchantInfo2 = (ListOfCardsResponseBody.MerchantInfo) this.g.getValue();
        sb.append(merchantInfo2 != null ? Intrinsics.areEqual(merchantInfo2.getBindingIsNeeded(), Boolean.TRUE) : false);
        treeTag.d(sb.toString(), new Object[0]);
        return jD == 0 && (merchantInfo = (ListOfCardsResponseBody.MerchantInfo) this.g.getValue()) != null && Intrinsics.areEqual(merchantInfo.getBindingIsNeeded(), Boolean.TRUE);
    }
}
