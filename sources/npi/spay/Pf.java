package npi.spay;

import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Pf implements FlowCollector {
    public final /* synthetic */ FlowCollector a;

    public Pf(FlowCollector flowCollector) {
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
            boolean r0 = r6 instanceof npi.spay.Of
            if (r0 == 0) goto L13
            r0 = r6
            npi.spay.Of r0 = (npi.spay.Of) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            npi.spay.Of r0 = new npi.spay.Of
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.FlowCollector r6 = r4.a
            npi.spay.Af r5 = (npi.spay.Af) r5
            npi.spay.Af r2 = npi.spay.Af.SEVERAL_CARDS
            if (r5 != r2) goto L3e
            r5 = r3
            goto L3f
        L3e:
            r5 = 0
        L3f:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r0.b = r3
            java.lang.Object r5 = r6.emit(r5, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Pf.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
