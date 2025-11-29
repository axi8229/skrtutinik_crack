package npi.spay;

import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.l7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1735l7 implements FlowCollector {
    public final /* synthetic */ FlowCollector a;
    public final /* synthetic */ D7 b;

    public C1735l7(FlowCollector flowCollector, D7 d7) {
        this.a = flowCollector;
        this.b = d7;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(java.lang.Object r26, kotlin.coroutines.Continuation r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r27
            boolean r2 = r1 instanceof npi.spay.C1710k7
            if (r2 == 0) goto L17
            r2 = r1
            npi.spay.k7 r2 = (npi.spay.C1710k7) r2
            int r3 = r2.b
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.b = r3
            goto L1c
        L17:
            npi.spay.k7 r2 = new npi.spay.k7
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.a
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.b
            r5 = 1
            if (r4 == 0) goto L36
            if (r4 != r5) goto L2e
            kotlin.ResultKt.throwOnFailure(r1)
            goto Lbe
        L2e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L36:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlinx.coroutines.flow.FlowCollector r1 = r0.a
            r4 = r26
            java.util.List r4 = (java.util.List) r4
            npi.spay.D7 r6 = r0.b
            npi.spay.m r6 = r6.c
            r6.getClass()
            java.lang.String r7 = "eventsList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            npi.spay.Yl r7 = new npi.spay.Yl
            npi.spay.z1 r8 = r6.a
            npi.spay.w r8 = r8.a()
            npi.spay.wl r6 = r6.b
            npi.spay.d3 r9 = r6.b
            npi.spay.W3 r9 = (npi.spay.W3) r9
            java.lang.String r11 = r9.a()
            npi.spay.B2 r9 = r6.c
            java.lang.String r10 = r9.b
            int r10 = r10.length()
            if (r10 != 0) goto L89
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = npi.spay.E2.a()
            r10.append(r12)
            r12 = 32
            r10.append(r12)
            npi.spay.d3 r12 = r9.a
            npi.spay.W3 r12 = (npi.spay.W3) r12
            java.lang.String r12 = r12.a()
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            r9.b = r10
        L89:
            java.lang.String r14 = r9.b
            kotlin.Lazy r9 = r6.d
            java.lang.Object r9 = r9.getValue()
            r12 = r9
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r6 = r6.e
            npi.spay.lj r9 = new npi.spay.lj
            java.lang.String r22 = ""
            java.lang.String r23 = ""
            java.lang.String r13 = ""
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            java.lang.String r17 = ""
            java.lang.String r18 = ""
            java.lang.String r19 = ""
            java.lang.String r20 = ""
            java.lang.String r21 = ""
            r10 = r9
            r24 = r6
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r7.<init>(r8, r9, r4)
            r2.b = r5
            java.lang.Object r1 = r1.emit(r7, r2)
            if (r1 != r3) goto Lbe
            return r3
        Lbe:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1735l7.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
