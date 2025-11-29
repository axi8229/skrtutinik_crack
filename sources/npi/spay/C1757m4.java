package npi.spay;

import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.m4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1757m4 implements FlowCollector {
    public final /* synthetic */ FlowCollector a;

    public C1757m4(FlowCollector flowCollector) {
        this.a = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof npi.spay.C1732l4
            if (r0 == 0) goto L13
            r0 = r6
            npi.spay.l4 r0 = (npi.spay.C1732l4) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            npi.spay.l4 r0 = new npi.spay.l4
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4a
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.FlowCollector r6 = r4.a
            npi.spay.g0 r5 = (npi.spay.C1604g0) r5
            npi.spay.q2 r5 = r5.a
            java.lang.String r2 = "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.Loading"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r2)
            npi.spay.d2 r5 = (npi.spay.C1531d2) r5
            r0.b = r3
            java.lang.Object r5 = r6.emit(r5, r0)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1757m4.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
