package npi.spay;

import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.xh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2044xh implements FlowCollector {
    public final /* synthetic */ FlowCollector a;
    public final /* synthetic */ C2094zh b;

    public C2044xh(FlowCollector flowCollector, C2094zh c2094zh) {
        this.a = flowCollector;
        this.b = c2094zh;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof npi.spay.C2019wh
            if (r0 == 0) goto L13
            r0 = r11
            npi.spay.wh r0 = (npi.spay.C2019wh) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            npi.spay.wh r0 = new npi.spay.wh
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lab
        L2a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L32:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.flow.FlowCollector r11 = r9.a
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody r10 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody) r10
            npi.spay.gc r2 = new npi.spay.gc
            int r4 = ru.yoomoney.sdk.kassa.payments.R$string.spay_currency_pattern
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$OrderInfo r5 = r10.getOrderInfo()
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$OrderInfo$OrderAmount r5 = r5.getOrderAmount()
            r6 = 0
            if (r5 == 0) goto L52
            int r5 = r5.getAmount()
            long r7 = (long) r5
            java.lang.String r5 = npi.spay.AbstractC2095zi.a(r7)
            goto L53
        L52:
            r5 = r6
        L53:
            java.lang.String r7 = ""
            if (r5 != 0) goto L58
            r5 = r7
        L58:
            npi.spay.zh r8 = r9.b
            kotlinx.coroutines.flow.StateFlow r8 = r8.h
            java.lang.Object r8 = r8.getValue()
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody r8 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody) r8
            if (r8 == 0) goto L75
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$OrderInfo r8 = r8.getOrderInfo()
            if (r8 == 0) goto L75
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$OrderInfo$OrderAmount r8 = r8.getOrderAmount()
            if (r8 == 0) goto L75
            java.lang.String r8 = r8.getCurrency()
            goto L76
        L75:
            r8 = r6
        L76:
            if (r8 != 0) goto L79
            r8 = r7
        L79:
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r8}
            java.lang.String r8 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r8)
            npi.spay.zk r8 = new npi.spay.zk
            java.util.List r5 = kotlin.collections.ArraysKt.toList(r5)
            r8.<init>(r4, r5)
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$MerchantInfo r10 = r10.getMerchantInfo()
            if (r10 == 0) goto L95
            java.lang.String r6 = r10.getMerchantName()
        L95:
            if (r6 != 0) goto L98
            goto L99
        L98:
            r7 = r6
        L99:
            java.lang.String r10 = "text"
            npi.spay.Ak r10 = npi.spay.AbstractC1854q1.a(r7, r10, r7)
            r2.<init>(r8, r10)
            r0.b = r3
            java.lang.Object r10 = r11.emit(r2, r0)
            if (r10 != r1) goto Lab
            return r1
        Lab:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C2044xh.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
