package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2330n;
import ru.yoomoney.sdk.kassa.payments.model.C2323g;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class J1 implements H1 {
    public final s1 a;

    public J1(s1 paymentAuthTypeRepository) {
        Intrinsics.checkNotNullParameter(paymentAuthTypeRepository, "paymentAuthTypeRepository");
        this.a = paymentAuthTypeRepository;
    }

    public static E a(ru.yoomoney.sdk.kassa.payments.model.c0 c0Var, boolean z) {
        E c;
        AbstractC2330n abstractC2330n = (AbstractC2330n) c0Var.a();
        if (Intrinsics.areEqual(abstractC2330n, C2323g.a)) {
            return new C2449v(z);
        }
        if (abstractC2330n instanceof C2326j) {
            c = new D((C2326j) c0Var.a());
        } else {
            c = new C(new IllegalStateException("This type " + c0Var.a() + " not supported"));
        }
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r5, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r6, boolean r7) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.I1
            if (r0 == 0) goto L13
            r0 = r5
            ru.yoomoney.sdk.kassa.payments.paymentAuth.I1 r0 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.I1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.I1 r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.I1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            boolean r7 = r0.b
            ru.yoomoney.sdk.kassa.payments.paymentAuth.J1 r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L48
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            ru.yoomoney.sdk.kassa.payments.paymentAuth.s1 r5 = r4.a
            r0.a = r4
            r0.b = r7
            r0.e = r3
            java.lang.Object r5 = r5.a(r0, r6, r7)
            if (r5 != r1) goto L47
            return r1
        L47:
            r6 = r4
        L48:
            ru.yoomoney.sdk.kassa.payments.model.d0 r5 = (ru.yoomoney.sdk.kassa.payments.model.d0) r5
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.model.c0
            if (r0 == 0) goto L58
            ru.yoomoney.sdk.kassa.payments.model.c0 r5 = (ru.yoomoney.sdk.kassa.payments.model.c0) r5
            r6.getClass()
            ru.yoomoney.sdk.kassa.payments.paymentAuth.E r5 = a(r5, r7)
            goto L66
        L58:
            boolean r6 = r5 instanceof ru.yoomoney.sdk.kassa.payments.model.b0
            if (r6 == 0) goto L67
            ru.yoomoney.sdk.kassa.payments.paymentAuth.C r6 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.C
            ru.yoomoney.sdk.kassa.payments.model.b0 r5 = (ru.yoomoney.sdk.kassa.payments.model.b0) r5
            java.lang.Throwable r5 = r5.a
            r6.<init>(r5)
            r5 = r6
        L66:
            return r5
        L67:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.J1.a(kotlin.coroutines.Continuation, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, boolean):java.lang.Object");
    }
}
