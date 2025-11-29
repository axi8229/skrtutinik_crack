package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* renamed from: npi.spay.va, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1987va extends AbstractC1489ba {
    public final InterfaceC2073yl a;
    public final InterfaceC1495bg b;

    public C1987va(InterfaceC2073yl sPayRepository, InterfaceC1495bg sPaySdkReducer) {
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        this.a = sPayRepository;
        this.b = sPaySdkReducer;
    }

    @Override // npi.spay.AbstractC1489ba
    public final Object a(Object obj, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(coroutineDispatcher.plus(SupervisorKt.SupervisorJob$default(null, 1, null)), new P8(this, (Rb) obj, coroutineDispatcher, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(npi.spay.C1987va r17, npi.spay.Rb r18, kotlinx.coroutines.CoroutineDispatcher r19, kotlin.coroutines.Continuation r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r20
            r17.getClass()
            boolean r3 = r2 instanceof npi.spay.G9
            if (r3 == 0) goto L1c
            r3 = r2
            npi.spay.G9 r3 = (npi.spay.G9) r3
            int r4 = r3.c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L1c
            int r4 = r4 - r5
            r3.c = r4
            goto L21
        L1c:
            npi.spay.G9 r3 = new npi.spay.G9
            r3.<init>(r0, r2)
        L21:
            java.lang.Object r2 = r3.a
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.c
            r6 = 1
            if (r5 == 0) goto L3a
            if (r5 != r6) goto L32
            kotlin.ResultKt.throwOnFailure(r2)
            goto L73
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            kotlin.ResultKt.throwOnFailure(r2)
            spay.sdk.domain.model.request.PaymentTokenWithPurchaseRequestBody r2 = r1.b
            boolean r2 = r2.isBnplEnabled()
            if (r2 == 0) goto L72
            spay.sdk.domain.model.request.PaymentTokenWithPurchaseRequestBody r7 = r1.b
            r15 = 95
            r16 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            spay.sdk.domain.model.request.PaymentTokenWithPurchaseRequestBody r2 = spay.sdk.domain.model.request.PaymentTokenWithPurchaseRequestBody.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            java.lang.String r1 = r1.a
            java.lang.String r5 = "authorization"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "paymentTokenWithPurchaseRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            npi.spay.Rb r5 = new npi.spay.Rb
            r5.<init>(r1, r2)
            r3.c = r6
            r1 = r19
            java.lang.Object r0 = r0.b(r5, r1, r3)
            if (r0 != r4) goto L73
            goto L77
        L72:
            r6 = 0
        L73:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1987va.a(npi.spay.va, npi.spay.Rb, kotlinx.coroutines.CoroutineDispatcher, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
