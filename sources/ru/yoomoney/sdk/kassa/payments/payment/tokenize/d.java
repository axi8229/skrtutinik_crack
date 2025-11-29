package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.tokens.ProfilingDataResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensResponse;
import ru.yoomoney.sdk.kassa.payments.model.SBP;
import ru.yoomoney.sdk.kassa.payments.model.SberBank;
import ru.yoomoney.sdk.kassa.payments.model.T;
import ru.yoomoney.sdk.kassa.payments.model.X;
import ru.yoomoney.sdk.kassa.payments.model.Y;
import ru.yoomoney.sdk.kassa.payments.model.c0;
import ru.yoomoney.sdk.kassa.payments.model.x0;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.r1;
import ru.yoomoney.sdk.yooprofiler.ProfileEventType;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes5.dex */
public final class d implements o {
    public final ru.yoomoney.sdk.kassa.payments.tmx.a a;
    public final YooProfiler b;
    public final ru.yoomoney.sdk.kassa.payments.api.d c;
    public final String d;
    public final r1 e;

    public d(ru.yoomoney.sdk.kassa.payments.tmx.a profilingSessionIdStorage, YooProfiler profiler, ru.yoomoney.sdk.kassa.payments.api.d paymentsApi, String str, r1 paymentAuthTokenRepository) {
        Intrinsics.checkNotNullParameter(profilingSessionIdStorage, "profilingSessionIdStorage");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        Intrinsics.checkNotNullParameter(paymentAuthTokenRepository, "paymentAuthTokenRepository");
        this.a = profilingSessionIdStorage;
        this.b = profiler;
        this.c = paymentsApi;
        this.d = str;
        this.e = paymentAuthTokenRepository;
    }

    public final String a(T t) {
        ProfileEventType profileEventType;
        String str;
        if (t instanceof x0) {
            str = this.a.a;
            profileEventType = ProfileEventType.LOGIN;
        } else {
            if ((t instanceof SberBank) || (t instanceof SBP)) {
                return "profilingSessionId";
            }
            profileEventType = ProfileEventType.PAYMENT;
            str = null;
        }
        ProfileEventType profileEventType2 = profileEventType;
        if (str != null && str.length() != 0) {
            return str;
        }
        YooProfiler.Result resultProfile$default = YooProfiler.DefaultImpls.profile$default(this.b, profileEventType2, null, null, 6, null);
        if (!(resultProfile$default instanceof YooProfiler.Result.Success)) {
            if (resultProfile$default instanceof YooProfiler.Result.Fail) {
                return ((YooProfiler.Result.Fail) resultProfile$default).getDescription();
            }
            throw new NoWhenBranchMatchedException();
        }
        YooProfiler.Result.Success success = (YooProfiler.Result.Success) resultProfile$default;
        this.a.a = success.getSessionId();
        return success.getSessionId();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0146 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r20, ru.yoomoney.sdk.kassa.payments.model.T r21, ru.yoomoney.sdk.kassa.payments.model.U r22, boolean r23, boolean r24, ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t r25, kotlin.coroutines.Continuation r26) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.tokenize.d.a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, ru.yoomoney.sdk.kassa.payments.model.T, ru.yoomoney.sdk.kassa.payments.model.U, boolean, boolean, ru.yoomoney.sdk.kassa.payments.model.t, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r15, ru.yoomoney.sdk.kassa.payments.model.T r16, boolean r17, ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t r18, java.lang.String r19, java.lang.String r20, kotlin.coroutines.Continuation r21) {
        /*
            r14 = this;
            r0 = r14
            r1 = r21
            boolean r2 = r1 instanceof ru.yoomoney.sdk.kassa.payments.payment.tokenize.b
            if (r2 == 0) goto L16
            r2 = r1
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.b r2 = (ru.yoomoney.sdk.kassa.payments.payment.tokenize.b) r2
            int r3 = r2.d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.d = r3
            goto L1b
        L16:
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.b r2 = new ru.yoomoney.sdk.kassa.payments.payment.tokenize.b
            r2.<init>(r14, r1)
        L1b:
            java.lang.Object r1 = r2.b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.d
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L3d
            if (r4 != r6) goto L35
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.d r2 = r2.a
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r1 = r1.getValue()
            goto L78
        L35:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3d:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r16
            java.lang.String r9 = r14.a(r1)
            ru.yoomoney.sdk.kassa.payments.paymentAuth.r1 r1 = r0.e
            java.lang.String r1 = r1.d()
            ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensRequestPaymentMethodId r4 = new ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensRequestPaymentMethodId
            ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Amount r8 = ru.yoomoney.sdk.kassa.payments.model.mapper.l.a(r15)
            ru.yoomoney.sdk.kassa.payments.api.model.tokens.ConfirmationRequest r10 = ru.yoomoney.sdk.kassa.payments.model.mapper.l.a(r18)
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            r7 = r4
            r12 = r19
            r13 = r20
            r7.<init>(r8, r9, r10, r11, r12, r13)
            ru.yoomoney.sdk.kassa.payments.api.d r7 = r0.c
            if (r1 == 0) goto L6b
            java.lang.String r1 = ru.yoomoney.sdk.kassa.payments.http.c.a(r1)
            goto L6c
        L6b:
            r1 = r5
        L6c:
            r2.a = r0
            r2.d = r6
            java.lang.Object r1 = r7.a(r1, r4, r2)
            if (r1 != r3) goto L77
            return r3
        L77:
            r2 = r0
        L78:
            java.lang.Throwable r3 = kotlin.Result.m2631exceptionOrNullimpl(r1)
            if (r3 != 0) goto L88
            ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensResponse r1 = (ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensResponse) r1
            r2.getClass()
            ru.yoomoney.sdk.kassa.payments.model.c0 r1 = a(r1)
            goto L8d
        L88:
            ru.yoomoney.sdk.kassa.payments.model.b0 r1 = new ru.yoomoney.sdk.kassa.payments.model.b0
            r1.<init>(r3)
        L8d:
            ru.yoomoney.sdk.kassa.payments.tmx.a r2 = r2.a
            r2.a = r5
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.tokenize.d.a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, ru.yoomoney.sdk.kassa.payments.model.T, boolean, ru.yoomoney.sdk.kassa.payments.model.t, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.model.T r15, ru.yoomoney.sdk.kassa.payments.model.Q r16, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r17, boolean r18, java.lang.String r19, ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t r20, kotlin.coroutines.Continuation r21) {
        /*
            r14 = this;
            r0 = r14
            r1 = r21
            boolean r2 = r1 instanceof ru.yoomoney.sdk.kassa.payments.payment.tokenize.c
            if (r2 == 0) goto L16
            r2 = r1
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.c r2 = (ru.yoomoney.sdk.kassa.payments.payment.tokenize.c) r2
            int r3 = r2.d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.d = r3
            goto L1b
        L16:
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.c r2 = new ru.yoomoney.sdk.kassa.payments.payment.tokenize.c
            r2.<init>(r14, r1)
        L1b:
            java.lang.Object r1 = r2.b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.d
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L3d
            if (r4 != r6) goto L35
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.d r2 = r2.a
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r1 = r1.getValue()
            goto L78
        L35:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3d:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.String r9 = r14.a(r15)
            ru.yoomoney.sdk.kassa.payments.paymentAuth.r1 r1 = r0.e
            java.lang.String r1 = r1.d()
            ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensRequestPaymentInstrumentId r4 = new ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensRequestPaymentInstrumentId
            ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Amount r8 = ru.yoomoney.sdk.kassa.payments.model.mapper.l.a(r17)
            ru.yoomoney.sdk.kassa.payments.api.model.tokens.ConfirmationRequest r10 = ru.yoomoney.sdk.kassa.payments.model.mapper.l.a(r20)
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r18)
            r7 = r16
            java.lang.String r12 = r7.a
            r7 = r4
            r13 = r19
            r7.<init>(r8, r9, r10, r11, r12, r13)
            ru.yoomoney.sdk.kassa.payments.api.d r7 = r0.c
            if (r1 == 0) goto L6b
            java.lang.String r1 = ru.yoomoney.sdk.kassa.payments.http.c.a(r1)
            goto L6c
        L6b:
            r1 = r5
        L6c:
            r2.a = r0
            r2.d = r6
            java.lang.Object r1 = r7.a(r1, r4, r2)
            if (r1 != r3) goto L77
            return r3
        L77:
            r2 = r0
        L78:
            java.lang.Throwable r3 = kotlin.Result.m2631exceptionOrNullimpl(r1)
            if (r3 != 0) goto L88
            ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensResponse r1 = (ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensResponse) r1
            r2.getClass()
            ru.yoomoney.sdk.kassa.payments.model.c0 r1 = a(r1)
            goto L8d
        L88:
            ru.yoomoney.sdk.kassa.payments.model.b0 r1 = new ru.yoomoney.sdk.kassa.payments.model.b0
            r1.<init>(r3)
        L8d:
            ru.yoomoney.sdk.kassa.payments.tmx.a r2 = r2.a
            r2.a = r5
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.tokenize.d.a(ru.yoomoney.sdk.kassa.payments.model.T, ru.yoomoney.sdk.kassa.payments.model.Q, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, boolean, java.lang.String, ru.yoomoney.sdk.kassa.payments.model.t, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static c0 a(TokensResponse tokensResponse) {
        Intrinsics.checkNotNullParameter(tokensResponse, "<this>");
        String paymentToken = tokensResponse.getPaymentToken();
        ProfilingDataResponse profilingData = tokensResponse.getProfilingData();
        return new c0(new X(paymentToken, new Y(profilingData != null ? profilingData.getPublicCardId() : null)));
    }
}
