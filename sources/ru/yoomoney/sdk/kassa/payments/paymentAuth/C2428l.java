package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2321e;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2428l implements s1, D1 {
    public final ru.yoomoney.sdk.kassa.payments.tmx.a a;
    public final YooProfiler b;
    public final Function2 c;
    public final ru.yoomoney.sdk.kassa.payments.api.e d;
    public String e;
    public String f;
    public EnumC2321e g;

    public C2428l(ru.yoomoney.sdk.kassa.payments.tmx.a profilingSessionIdStorage, YooProfiler profiler, M1 selectAppropriateAuthType, ru.yoomoney.sdk.kassa.payments.api.e paymentsAuthApi) {
        Intrinsics.checkNotNullParameter(profilingSessionIdStorage, "profilingSessionIdStorage");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(selectAppropriateAuthType, "selectAppropriateAuthType");
        Intrinsics.checkNotNullParameter(paymentsAuthApi, "paymentsAuthApi");
        this.a = profilingSessionIdStorage;
        this.b = profiler;
        this.c = selectAppropriateAuthType;
        this.d = paymentsAuthApi;
        this.g = EnumC2321e.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l.b(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.C2413g
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.kassa.payments.paymentAuth.g r0 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.C2413g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.g r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.g
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.c = r3
            java.lang.Object r6 = r4.d(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            ru.yoomoney.sdk.kassa.payments.model.d0 r6 = (ru.yoomoney.sdk.kassa.payments.model.d0) r6
            boolean r5 = r6 instanceof ru.yoomoney.sdk.kassa.payments.model.c0
            if (r5 == 0) goto L55
            ru.yoomoney.sdk.kassa.payments.model.c0 r5 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.paymentAuth.q1 r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.q1
            ru.yoomoney.sdk.kassa.payments.model.c0 r6 = (ru.yoomoney.sdk.kassa.payments.model.c0) r6
            java.lang.Object r6 = r6.a
            java.lang.String r6 = (java.lang.String) r6
            r0.<init>(r6)
            r5.<init>(r0)
            r6 = r5
            goto L59
        L55:
            boolean r5 = r6 instanceof ru.yoomoney.sdk.kassa.payments.model.b0
            if (r5 == 0) goto L5a
        L59:
            return r6
        L5a:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l.c(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.C2422j
            if (r0 == 0) goto L13
            r0 = r10
            ru.yoomoney.sdk.kassa.payments.paymentAuth.j r0 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.C2422j) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.j r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.j
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r9 = r10.getValue()
            goto L4a
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            kotlin.ResultKt.throwOnFailure(r10)
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueExecuteRequest r10 = new ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueExecuteRequest
            r10.<init>(r9)
            ru.yoomoney.sdk.kassa.payments.api.e r9 = r8.d
            r0.c = r3
            java.lang.Object r9 = r9.a(r10, r0)
            if (r9 != r1) goto L4a
            return r1
        L4a:
            java.lang.Throwable r10 = kotlin.Result.m2631exceptionOrNullimpl(r9)
            if (r10 != 0) goto La3
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueExecuteResponse r9 = (ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueExecuteResponse) r9
            java.lang.String r10 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthPaymentState r10 = r9.getStatus()
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthPaymentState r0 = ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthPaymentState.SUCCESS
            if (r10 != r0) goto L73
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueExecuteResultResponse r10 = r9.getResult()
            if (r10 == 0) goto L73
            ru.yoomoney.sdk.kassa.payments.model.c0 r10 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueExecuteResultResponse r9 = r9.getResult()
            java.lang.String r9 = r9.getAccessToken()
            r10.<init>(r9)
            goto La9
        L73:
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.ErrorCodeNetwork r10 = r9.getError()
            if (r10 == 0) goto L96
            ru.yoomoney.sdk.kassa.payments.model.b0 r10 = new ru.yoomoney.sdk.kassa.payments.model.b0
            ru.yoomoney.sdk.kassa.payments.model.c r0 = new ru.yoomoney.sdk.kassa.payments.model.c
            ru.yoomoney.sdk.kassa.payments.model.v r7 = new ru.yoomoney.sdk.kassa.payments.model.v
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.ErrorCodeNetwork r9 = r9.getError()
            ru.yoomoney.sdk.kassa.payments.model.w r2 = ru.yoomoney.sdk.kassa.payments.model.mapper.c.a(r9)
            r4 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r0.<init>(r7)
            r10.<init>(r0)
            goto La9
        L96:
            ru.yoomoney.sdk.kassa.payments.model.b0 r10 = new ru.yoomoney.sdk.kassa.payments.model.b0
            ru.yoomoney.sdk.kassa.payments.model.c r9 = new ru.yoomoney.sdk.kassa.payments.model.c
            ru.yoomoney.sdk.kassa.payments.model.w r0 = ru.yoomoney.sdk.kassa.payments.model.EnumC2338w.a
            r9.<init>()
            r10.<init>(r9)
            goto La9
        La3:
            ru.yoomoney.sdk.kassa.payments.model.b0 r9 = new ru.yoomoney.sdk.kassa.payments.model.b0
            r9.<init>(r10)
            r10 = r9
        La9:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l.d(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation r12, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r13, boolean r14) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.C2425k
            if (r0 == 0) goto L13
            r0 = r12
            ru.yoomoney.sdk.kassa.payments.paymentAuth.k r0 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.C2425k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.k r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.k
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r12 = r12.getValue()
            goto L9b
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L37:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = android.os.Build.MANUFACTURER
            java.lang.String r2 = android.os.Build.MODEL
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r12)
            java.lang.String r12 = ", "
            r4.append(r12)
            r4.append(r2)
            java.lang.String r12 = r4.toString()
            if (r14 != 0) goto L59
            ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Amount r13 = ru.yoomoney.sdk.kassa.payments.model.mapper.l.a(r13)
            goto L5a
        L59:
            r13 = 0
        L5a:
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.PaymentUsageLimit r14 = ru.yoomoney.sdk.kassa.payments.model.mapper.c.a(r14)
            ru.yoomoney.sdk.kassa.payments.tmx.a r2 = r11.a
            java.lang.String r2 = r2.a
            if (r2 == 0) goto L6a
            int r4 = r2.length()
            if (r4 != 0) goto L8b
        L6a:
            ru.yoomoney.sdk.yooprofiler.YooProfiler r5 = r11.b
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r6 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.LOGIN
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result r2 = ru.yoomoney.sdk.yooprofiler.YooProfiler.DefaultImpls.profile$default(r5, r6, r7, r8, r9, r10)
            boolean r4 = r2 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success
            if (r4 == 0) goto L81
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result$Success r2 = (ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success) r2
            java.lang.String r2 = r2.getSessionId()
            goto L8b
        L81:
            boolean r4 = r2 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Fail
            if (r4 == 0) goto Lae
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result$Fail r2 = (ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Fail) r2
            java.lang.String r2 = r2.getDescription()
        L8b:
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueInitRequest r4 = new ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueInitRequest
            r4.<init>(r2, r12, r13, r14)
            ru.yoomoney.sdk.kassa.payments.api.e r12 = r11.d
            r0.c = r3
            java.lang.Object r12 = r12.a(r4, r0)
            if (r12 != r1) goto L9b
            return r1
        L9b:
            java.lang.Throwable r13 = kotlin.Result.m2631exceptionOrNullimpl(r12)
            if (r13 != 0) goto La8
            ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueInitResponse r12 = (ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueInitResponse) r12
            ru.yoomoney.sdk.kassa.payments.model.d0 r12 = ru.yoomoney.sdk.kassa.payments.model.mapper.c.a(r12)
            goto Lad
        La8:
            ru.yoomoney.sdk.kassa.payments.model.b0 r12 = new ru.yoomoney.sdk.kassa.payments.model.b0
            r12.<init>(r13)
        Lad:
            return r12
        Lae:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l.b(kotlin.coroutines.Continuation, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, boolean):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.kassa.payments.paymentAuth.D1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r7 = r9 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.C2410f
            if (r7 == 0) goto L13
            r7 = r9
            ru.yoomoney.sdk.kassa.payments.paymentAuth.f r7 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.C2410f) r7
            int r0 = r7.e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r7.e = r0
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.f r7 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.f
            r7.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r7.c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.e
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3c
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2c
            kotlin.ResultKt.throwOnFailure(r9)
            goto L73
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.String r8 = r7.b
            ru.yoomoney.sdk.kassa.payments.paymentAuth.l r1 = r7.a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5f
        L3c:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = r6.e
            if (r9 != 0) goto L4e
            ru.yoomoney.sdk.kassa.payments.model.b0 r7 = new ru.yoomoney.sdk.kassa.payments.model.b0
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            r7.<init>(r8)
            return r7
        L4e:
            r7.a = r6
            r7.b = r9
            r7.e = r3
            java.lang.Object r8 = r6.a(r8, r7)
            if (r8 != r0) goto L5b
            return r0
        L5b:
            r1 = r6
            r5 = r9
            r9 = r8
            r8 = r5
        L5f:
            ru.yoomoney.sdk.kassa.payments.model.d0 r9 = (ru.yoomoney.sdk.kassa.payments.model.d0) r9
            boolean r4 = r9 instanceof ru.yoomoney.sdk.kassa.payments.model.c0
            if (r4 == 0) goto L76
            r9 = 0
            r7.a = r9
            r7.b = r9
            r7.e = r2
            java.lang.Object r9 = r1.c(r8, r7)
            if (r9 != r0) goto L73
            return r0
        L73:
            ru.yoomoney.sdk.kassa.payments.model.d0 r9 = (ru.yoomoney.sdk.kassa.payments.model.d0) r9
            goto La6
        L76:
            boolean r7 = r9 instanceof ru.yoomoney.sdk.kassa.payments.model.b0
            if (r7 == 0) goto La7
            r7 = r9
            ru.yoomoney.sdk.kassa.payments.model.b0 r7 = (ru.yoomoney.sdk.kassa.payments.model.b0) r7
            java.lang.Throwable r8 = r7.a
            boolean r0 = r8 instanceof ru.yoomoney.sdk.kassa.payments.model.C2320d
            if (r0 == 0) goto La6
            ru.yoomoney.sdk.kassa.payments.model.d r8 = (ru.yoomoney.sdk.kassa.payments.model.C2320d) r8
            ru.yoomoney.sdk.kassa.payments.model.v r8 = r8.b
            ru.yoomoney.sdk.kassa.payments.model.w r8 = r8.a
            int[] r0 = ru.yoomoney.sdk.kassa.payments.paymentAuth.AbstractC2398b.a
            int r8 = r8.ordinal()
            r8 = r0[r8]
            if (r8 != r3) goto La6
            ru.yoomoney.sdk.kassa.payments.model.c0 r9 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.paymentAuth.B1 r8 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.B1
            java.lang.Throwable r7 = r7.a
            ru.yoomoney.sdk.kassa.payments.model.d r7 = (ru.yoomoney.sdk.kassa.payments.model.C2320d) r7
            ru.yoomoney.sdk.kassa.payments.model.n r7 = r7.c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r8.<init>(r7)
            r9.<init>(r8)
        La6:
            return r9
        La7:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l.a(ru.yoomoney.sdk.kassa.payments.model.u, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentAuth.D1
    public final Object a(AbstractC2336u abstractC2336u, Continuation continuation) {
        String str = this.e;
        return str == null ? new ru.yoomoney.sdk.kassa.payments.model.b0(new IllegalStateException()) : c(str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.kassa.payments.paymentAuth.s1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r7, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r8, boolean r9) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.C2416h
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.kassa.payments.paymentAuth.h r0 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.C2416h) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.h r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.h
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3b
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L85
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.l r8 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            r6.e = r5
            r6.f = r5
            ru.yoomoney.sdk.kassa.payments.model.e r7 = ru.yoomoney.sdk.kassa.payments.model.EnumC2321e.h
            r6.g = r7
            r0.a = r6
            r0.d = r4
            java.lang.Object r7 = r6.b(r0, r8, r9)
            if (r7 != r1) goto L51
            return r1
        L51:
            r8 = r6
        L52:
            ru.yoomoney.sdk.kassa.payments.model.d0 r7 = (ru.yoomoney.sdk.kassa.payments.model.d0) r7
            boolean r9 = r7 instanceof ru.yoomoney.sdk.kassa.payments.model.c0
            if (r9 == 0) goto L8c
            ru.yoomoney.sdk.kassa.payments.model.c0 r7 = (ru.yoomoney.sdk.kassa.payments.model.c0) r7
            r0.a = r5
            r0.d = r3
            r8.getClass()
            java.lang.Object r7 = r7.a
            r9 = r7
            ru.yoomoney.sdk.kassa.payments.paymentAuth.p r9 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.AbstractC2438p) r9
            boolean r2 = r9 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.C2436o
            if (r2 == 0) goto L78
            ru.yoomoney.sdk.kassa.payments.paymentAuth.o r7 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.C2436o) r7
            java.lang.String r7 = r7.a
            r8.e = r7
            ru.yoomoney.sdk.kassa.payments.model.c0 r7 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.model.g r8 = ru.yoomoney.sdk.kassa.payments.model.C2323g.a
            r7.<init>(r8)
            goto L82
        L78:
            boolean r9 = r9 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.C2434n
            if (r9 == 0) goto L86
            ru.yoomoney.sdk.kassa.payments.paymentAuth.n r7 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.C2434n) r7
            java.lang.Object r7 = r8.a(r7, r0)
        L82:
            if (r7 != r1) goto L85
            return r1
        L85:
            return r7
        L86:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L8c:
            boolean r8 = r7 instanceof ru.yoomoney.sdk.kassa.payments.model.b0
            if (r8 == 0) goto L91
            return r7
        L91:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l.a(kotlin.coroutines.Continuation, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, boolean):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.paymentAuth.C2434n r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.C2419i
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.kassa.payments.paymentAuth.i r0 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.C2419i) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.i r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.i
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            ru.yoomoney.sdk.kassa.payments.paymentAuth.l r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7d
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.l r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L60
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r6.b
            r5.e = r7
            java.lang.String r6 = r6.a
            r5.f = r6
            if (r6 != 0) goto L54
            ru.yoomoney.sdk.kassa.payments.model.b0 r6 = new ru.yoomoney.sdk.kassa.payments.model.b0
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            r6.<init>(r7)
            return r6
        L54:
            r0.a = r5
            r0.d = r4
            java.lang.Object r7 = r5.b(r6, r0)
            if (r7 != r1) goto L5f
            return r1
        L5f:
            r6 = r5
        L60:
            ru.yoomoney.sdk.kassa.payments.model.d0 r7 = (ru.yoomoney.sdk.kassa.payments.model.d0) r7
            boolean r2 = r7 instanceof ru.yoomoney.sdk.kassa.payments.model.c0
            if (r2 == 0) goto L96
            ru.yoomoney.sdk.kassa.payments.model.c0 r7 = (ru.yoomoney.sdk.kassa.payments.model.c0) r7
            java.lang.Object r7 = r7.a
            ru.yoomoney.sdk.kassa.payments.model.n r7 = (ru.yoomoney.sdk.kassa.payments.model.AbstractC2330n) r7
            ru.yoomoney.sdk.kassa.payments.model.e r7 = r7.a()
            r6.g = r7
            r0.a = r6
            r0.d = r3
            java.lang.Object r7 = r6.a(r0)
            if (r7 != r1) goto L7d
            return r1
        L7d:
            ru.yoomoney.sdk.kassa.payments.model.d0 r7 = (ru.yoomoney.sdk.kassa.payments.model.d0) r7
            boolean r0 = r7 instanceof ru.yoomoney.sdk.kassa.payments.model.c0
            if (r0 == 0) goto L95
            ru.yoomoney.sdk.kassa.payments.model.c0 r7 = (ru.yoomoney.sdk.kassa.payments.model.c0) r7
            java.lang.Object r7 = r7.a
            ru.yoomoney.sdk.kassa.payments.model.n r7 = (ru.yoomoney.sdk.kassa.payments.model.AbstractC2330n) r7
            ru.yoomoney.sdk.kassa.payments.model.e r0 = r7.a()
            r6.g = r0
            ru.yoomoney.sdk.kassa.payments.model.c0 r6 = new ru.yoomoney.sdk.kassa.payments.model.c0
            r6.<init>(r7)
            return r6
        L95:
            return r7
        L96:
            boolean r6 = r7 instanceof ru.yoomoney.sdk.kassa.payments.model.b0
            if (r6 == 0) goto L9b
            return r7
        L9b:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l.a(ru.yoomoney.sdk.kassa.payments.paymentAuth.n, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
