package npi.spay;

import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Sf implements FlowCollector {
    public final /* synthetic */ FlowCollector a;

    public Sf(FlowCollector flowCollector) {
        this.a = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof npi.spay.Rf
            if (r0 == 0) goto L13
            r0 = r9
            npi.spay.Rf r0 = (npi.spay.Rf) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            npi.spay.Rf r0 = new npi.spay.Rf
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r9)
            goto L67
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.flow.FlowCollector r9 = r7.a
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody r8 = (spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody) r8
            npi.spay.Bf r2 = new npi.spay.Bf
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$MerchantInfo r4 = r8.getMerchantInfo()
            r5 = 0
            if (r4 == 0) goto L46
            java.lang.String r4 = r4.getMerchantName()
            goto L47
        L46:
            r4 = r5
        L47:
            if (r4 != 0) goto L4b
            java.lang.String r4 = ""
        L4b:
            java.lang.String r6 = "text"
            npi.spay.Ak r4 = npi.spay.AbstractC1854q1.a(r4, r6, r4)
            spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$MerchantInfo r8 = r8.getMerchantInfo()
            if (r8 == 0) goto L5b
            java.lang.String r5 = r8.getMerchantLogoUrl()
        L5b:
            r2.<init>(r4, r5)
            r0.b = r3
            java.lang.Object r8 = r9.emit(r2, r0)
            if (r8 != r1) goto L67
            return r1
        L67:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Sf.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
