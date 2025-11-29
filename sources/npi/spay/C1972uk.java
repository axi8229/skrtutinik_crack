package npi.spay;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody;
import timber.log.Timber;

/* renamed from: npi.spay.uk, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1972uk implements InterfaceC1797nj {
    public static final LinkedHashMap c = new LinkedHashMap();
    public final Context a;
    public final C1898rl b;

    public C1972uk(Context context, C1898rl hashUtility) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hashUtility, "hashUtility");
        this.a = context;
        this.b = hashUtility;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r4, kotlin.coroutines.Continuation r5) {
        /*
            r3 = this;
            boolean r4 = r5 instanceof npi.spay.C1947tk
            if (r4 == 0) goto L13
            r4 = r5
            npi.spay.tk r4 = (npi.spay.C1947tk) r4
            int r0 = r4.d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.d = r0
            goto L18
        L13:
            npi.spay.tk r4 = new npi.spay.tk
            r4.<init>(r3, r5)
        L18:
            java.lang.Object r5 = r4.b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.d
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            npi.spay.uk r4 = r4.a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            r4.a = r3
            r4.d = r2
            r1 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r1, r4)
            if (r4 != r0) goto L43
            return r0
        L43:
            r4 = r3
        L44:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r4.getClass()
            retrofit2.Response r4 = retrofit2.Response.success(r5)
            java.lang.String r5 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r3, spay.sdk.domain.model.request.PaymentBnplPlanRequestBody r4, kotlin.coroutines.Continuation r5) {
        /*
            r2 = this;
            boolean r3 = r5 instanceof npi.spay.C1773mk
            if (r3 == 0) goto L13
            r3 = r5
            npi.spay.mk r3 = (npi.spay.C1773mk) r3
            int r4 = r3.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.d = r4
            goto L18
        L13:
            npi.spay.mk r3 = new npi.spay.mk
            r3.<init>(r2, r5)
        L18:
            java.lang.Object r4 = r3.b
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            npi.spay.uk r3 = r3.a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L44
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.throwOnFailure(r4)
            r3.a = r2
            r3.d = r1
            r0 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r0, r3)
            if (r3 != r5) goto L43
            return r5
        L43:
            r3 = r2
        L44:
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            java.lang.String r5 = "parts_payment_bnpl_plan.json"
            java.lang.String r3 = r3.a(r5)
            java.lang.Class<spay.sdk.data.dto.response.PartsPaymentPlanBnplResponseBodyDto> r5 = spay.sdk.data.dto.response.PartsPaymentPlanBnplResponseBodyDto.class
            java.lang.Object r3 = r4.fromJson(r3, r5)
            spay.sdk.data.dto.response.PartsPaymentPlanBnplResponseBodyDto r3 = (spay.sdk.data.dto.response.PartsPaymentPlanBnplResponseBodyDto) r3
            java.lang.String r4 = "paymentPlanBnplResponseBodyDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            retrofit2.Response r3 = retrofit2.Response.success(r3)
            java.lang.String r4 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.b(java.lang.String, spay.sdk.domain.model.request.PaymentBnplPlanRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r3, spay.sdk.domain.model.request.AuthWithOrderIdRequestBody r4, kotlin.coroutines.Continuation r5) {
        /*
            r2 = this;
            boolean r3 = r5 instanceof npi.spay.C1673ik
            if (r3 == 0) goto L13
            r3 = r5
            npi.spay.ik r3 = (npi.spay.C1673ik) r3
            int r4 = r3.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.d = r4
            goto L18
        L13:
            npi.spay.ik r3 = new npi.spay.ik
            r3.<init>(r2, r5)
        L18:
            java.lang.Object r4 = r3.b
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            npi.spay.uk r3 = r3.a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L44
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.throwOnFailure(r4)
            r3.a = r2
            r3.d = r1
            r0 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r0, r3)
            if (r3 != r5) goto L43
            return r5
        L43:
            r3 = r2
        L44:
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            java.lang.String r5 = "auth_response.json"
            java.lang.String r3 = r3.a(r5)
            java.lang.Class<spay.sdk.data.dto.response.AuthResponseBodyDto> r5 = spay.sdk.data.dto.response.AuthResponseBodyDto.class
            java.lang.Object r3 = r4.fromJson(r3, r5)
            spay.sdk.data.dto.response.AuthResponseBodyDto r3 = (spay.sdk.data.dto.response.AuthResponseBodyDto) r3
            java.lang.String r4 = "authResponseBodyDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            retrofit2.Response r3 = retrofit2.Response.success(r3)
            java.lang.String r4 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.AuthWithOrderIdRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r3, spay.sdk.domain.model.request.AuthWithPurchaseRequestBody r4, kotlin.coroutines.Continuation r5) {
        /*
            r2 = this;
            boolean r3 = r5 instanceof npi.spay.C1698jk
            if (r3 == 0) goto L13
            r3 = r5
            npi.spay.jk r3 = (npi.spay.C1698jk) r3
            int r4 = r3.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.d = r4
            goto L18
        L13:
            npi.spay.jk r3 = new npi.spay.jk
            r3.<init>(r2, r5)
        L18:
            java.lang.Object r4 = r3.b
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            npi.spay.uk r3 = r3.a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L44
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.throwOnFailure(r4)
            r3.a = r2
            r3.d = r1
            r0 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r0, r3)
            if (r3 != r5) goto L43
            return r5
        L43:
            r3 = r2
        L44:
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            java.lang.String r5 = "auth_response.json"
            java.lang.String r3 = r3.a(r5)
            java.lang.Class<spay.sdk.data.dto.response.AuthResponseBodyDto> r5 = spay.sdk.data.dto.response.AuthResponseBodyDto.class
            java.lang.Object r3 = r4.fromJson(r3, r5)
            spay.sdk.data.dto.response.AuthResponseBodyDto r3 = (spay.sdk.data.dto.response.AuthResponseBodyDto) r3
            java.lang.String r4 = "authResponseBodyDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            retrofit2.Response r3 = retrofit2.Response.success(r3)
            java.lang.String r4 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.AuthWithPurchaseRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r6, spay.sdk.domain.model.request.ConfirmOtpRequestBody r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r6 = r8 instanceof npi.spay.C1624gk
            if (r6 == 0) goto L13
            r6 = r8
            npi.spay.gk r6 = (npi.spay.C1624gk) r6
            int r0 = r6.e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r6.e = r0
            goto L18
        L13:
            npi.spay.gk r6 = new npi.spay.gk
            r6.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r6.c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.e
            java.lang.String r2 = "confirmOtp"
            r3 = 1
            if (r1 == 0) goto L37
            if (r1 != r3) goto L2f
            spay.sdk.domain.model.request.ConfirmOtpRequestBody r7 = r6.b
            npi.spay.uk r6 = r6.a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L69
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.LinkedHashMap r8 = npi.spay.C1972uk.c
            java.lang.Object r1 = r8.get(r2)
            if (r1 != 0) goto L44
            r1 = r3
            goto L52
        L44:
            java.lang.Object r1 = r8.get(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            int r1 = r1 + r3
        L52:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r8.put(r2, r1)
            r6.a = r5
            r6.b = r7
            r6.e = r3
            r3 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L68
            return r0
        L68:
            r6 = r5
        L69:
            java.lang.String r7 = r7.getOtpHash()
            npi.spay.rl r8 = r6.b
            r8.getClass()
            java.lang.String r8 = "119950526"
            java.lang.String r8 = npi.spay.C1898rl.a(r8)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            if (r7 == 0) goto L81
            java.lang.String r7 = "confirm_otp_response.json"
            goto L98
        L81:
            java.util.LinkedHashMap r7 = npi.spay.C1972uk.c
            java.lang.Object r7 = r7.get(r2)
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L96
            int r7 = r7.intValue()
            r8 = 4
            if (r7 >= r8) goto L93
            goto L96
        L93:
            java.lang.String r7 = "confirm_otp_response_attempts_exhausted.json"
            goto L98
        L96:
            java.lang.String r7 = "confirm_otp_response_wrong_code.json"
        L98:
            com.google.gson.Gson r8 = new com.google.gson.Gson
            r8.<init>()
            java.lang.String r6 = r6.a(r7)
            java.lang.Class<spay.sdk.data.dto.response.otp.ConfirmOtpResponseBodyDto> r7 = spay.sdk.data.dto.response.otp.ConfirmOtpResponseBodyDto.class
            java.lang.Object r6 = r8.fromJson(r6, r7)
            spay.sdk.data.dto.response.otp.ConfirmOtpResponseBodyDto r6 = (spay.sdk.data.dto.response.otp.ConfirmOtpResponseBodyDto) r6
            java.lang.String r7 = "confirmOtpResponseBodyDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            retrofit2.Response r6 = retrofit2.Response.success(r6)
            java.lang.String r7 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.ConfirmOtpRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r5, spay.sdk.domain.model.request.CreateOtpSdkRequestBody r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r5 = r7 instanceof npi.spay.C1649hk
            if (r5 == 0) goto L13
            r5 = r7
            npi.spay.hk r5 = (npi.spay.C1649hk) r5
            int r6 = r5.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r6 & r0
            if (r1 == 0) goto L13
            int r6 = r6 - r0
            r5.d = r6
            goto L18
        L13:
            npi.spay.hk r5 = new npi.spay.hk
            r5.<init>(r4, r7)
        L18:
            java.lang.Object r6 = r5.b
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.d
            java.lang.String r1 = "createOtpSdk"
            r2 = 1
            if (r0 == 0) goto L35
            if (r0 != r2) goto L2d
            npi.spay.uk r5 = r5.a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L65
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.LinkedHashMap r6 = npi.spay.C1972uk.c
            java.lang.Object r0 = r6.get(r1)
            if (r0 != 0) goto L42
            r0 = r2
            goto L50
        L42:
            java.lang.Object r0 = r6.get(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r0 = r0 + r2
        L50:
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r6.put(r1, r0)
            r5.a = r4
            r5.d = r2
            r2 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r2, r5)
            if (r5 != r7) goto L64
            return r7
        L64:
            r5 = r4
        L65:
            com.google.gson.Gson r6 = new com.google.gson.Gson
            r6.<init>()
            java.util.LinkedHashMap r7 = npi.spay.C1972uk.c
            java.lang.Object r7 = r7.get(r1)
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L7f
            int r7 = r7.intValue()
            r0 = 4
            if (r7 >= r0) goto L7c
            goto L7f
        L7c:
            java.lang.String r7 = "create_otp_response_attempts_exhausted.json"
            goto L81
        L7f:
            java.lang.String r7 = "create_otp_sdk_response.json"
        L81:
            java.lang.String r5 = r5.a(r7)
            java.lang.Class<spay.sdk.data.dto.response.otp.CreateOtpSdkResponseBodyDto> r7 = spay.sdk.data.dto.response.otp.CreateOtpSdkResponseBodyDto.class
            java.lang.Object r5 = r6.fromJson(r5, r7)
            spay.sdk.data.dto.response.otp.CreateOtpSdkResponseBodyDto r5 = (spay.sdk.data.dto.response.otp.CreateOtpSdkResponseBodyDto) r5
            java.lang.String r6 = "createOtpSdkResponseBodyDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            retrofit2.Response r5 = retrofit2.Response.success(r5)
            java.lang.String r6 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.CreateOtpSdkRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r6, spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r6 = r8 instanceof npi.spay.C1723kk
            if (r6 == 0) goto L13
            r6 = r8
            npi.spay.kk r6 = (npi.spay.C1723kk) r6
            int r0 = r6.e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r6.e = r0
            goto L18
        L13:
            npi.spay.kk r6 = new npi.spay.kk
            r6.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r6.c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.e
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody r7 = r6.b
            npi.spay.uk r6 = r6.a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L48
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            r6.a = r5
            r6.b = r7
            r6.e = r2
            r3 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L47
            return r0
        L47:
            r6 = r5
        L48:
            java.lang.Boolean r8 = r7.getPriorityCardOnly()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)
            java.lang.Boolean r8 = r7.getPriorityCardOnly()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)
            if (r8 == 0) goto L64
            java.lang.String r7 = "single_list_cards.json"
            goto L71
        L64:
            java.lang.Boolean r7 = r7.getPriorityCardOnly()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            java.lang.String r7 = "list_cards.json"
        L71:
            com.google.gson.Gson r8 = new com.google.gson.Gson
            r8.<init>()
            java.lang.String r6 = r6.a(r7)
            java.lang.Class<spay.sdk.data.dto.response.listOfCards.ListOfCardsResponseBodyDto> r7 = spay.sdk.data.dto.response.listOfCards.ListOfCardsResponseBodyDto.class
            java.lang.Object r6 = r8.fromJson(r6, r7)
            spay.sdk.data.dto.response.listOfCards.ListOfCardsResponseBodyDto r6 = (spay.sdk.data.dto.response.listOfCards.ListOfCardsResponseBodyDto) r6
            java.lang.String r7 = "listOfCardsResponseBodyDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            retrofit2.Response r6 = retrofit2.Response.success(r6)
            java.lang.String r7 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r6, spay.sdk.domain.model.request.ListOfCardsWithPurchaseRequestBody r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r6 = r8 instanceof npi.spay.C1748lk
            if (r6 == 0) goto L13
            r6 = r8
            npi.spay.lk r6 = (npi.spay.C1748lk) r6
            int r0 = r6.e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r6.e = r0
            goto L18
        L13:
            npi.spay.lk r6 = new npi.spay.lk
            r6.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r6.c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.e
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            spay.sdk.domain.model.request.ListOfCardsWithPurchaseRequestBody r7 = r6.b
            npi.spay.uk r6 = r6.a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L48
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            r6.a = r5
            r6.b = r7
            r6.e = r2
            r3 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L47
            return r0
        L47:
            r6 = r5
        L48:
            java.lang.Boolean r8 = r7.getPriorityCardOnly()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)
            java.lang.Boolean r8 = r7.getPriorityCardOnly()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)
            if (r8 == 0) goto L64
            java.lang.String r7 = "single_list_cards.json"
            goto L71
        L64:
            java.lang.Boolean r7 = r7.getPriorityCardOnly()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            java.lang.String r7 = "list_cards.json"
        L71:
            com.google.gson.Gson r8 = new com.google.gson.Gson
            r8.<init>()
            java.lang.String r6 = r6.a(r7)
            java.lang.Class<spay.sdk.data.dto.response.listOfCards.ListOfCardsResponseBodyDto> r7 = spay.sdk.data.dto.response.listOfCards.ListOfCardsResponseBodyDto.class
            java.lang.Object r6 = r8.fromJson(r6, r7)
            spay.sdk.data.dto.response.listOfCards.ListOfCardsResponseBodyDto r6 = (spay.sdk.data.dto.response.listOfCards.ListOfCardsResponseBodyDto) r6
            java.lang.String r7 = "listOfCardsResponseBodyDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            retrofit2.Response r6 = retrofit2.Response.success(r6)
            java.lang.String r7 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.ListOfCardsWithPurchaseRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r3, spay.sdk.domain.model.request.PayOnlineRequestBody r4, kotlin.coroutines.Continuation r5) {
        /*
            r2 = this;
            boolean r3 = r5 instanceof npi.spay.C1798nk
            if (r3 == 0) goto L13
            r3 = r5
            npi.spay.nk r3 = (npi.spay.C1798nk) r3
            int r4 = r3.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.d = r4
            goto L18
        L13:
            npi.spay.nk r3 = new npi.spay.nk
            r3.<init>(r2, r5)
        L18:
            java.lang.Object r4 = r3.b
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            npi.spay.uk r3 = r3.a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L44
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.throwOnFailure(r4)
            r3.a = r2
            r3.d = r1
            r0 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r0, r3)
            if (r3 != r5) goto L43
            return r5
        L43:
            r3 = r2
        L44:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r3.getClass()
            retrofit2.Response r3 = retrofit2.Response.success(r4)
            java.lang.String r4 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.PayOnlineRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r3, spay.sdk.domain.model.request.PaymentBnplPlanRequestBody r4, kotlin.coroutines.Continuation r5) {
        /*
            r2 = this;
            boolean r3 = r5 instanceof npi.spay.C1848pk
            if (r3 == 0) goto L13
            r3 = r5
            npi.spay.pk r3 = (npi.spay.C1848pk) r3
            int r4 = r3.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.d = r4
            goto L18
        L13:
            npi.spay.pk r3 = new npi.spay.pk
            r3.<init>(r2, r5)
        L18:
            java.lang.Object r4 = r3.b
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            npi.spay.uk r3 = r3.a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L44
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.throwOnFailure(r4)
            r3.a = r2
            r3.d = r1
            r0 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r0, r3)
            if (r3 != r5) goto L43
            return r5
        L43:
            r3 = r2
        L44:
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            java.lang.String r5 = "payment_bnpl_plan.json"
            java.lang.String r3 = r3.a(r5)
            java.lang.Class<spay.sdk.data.dto.response.PaymentPlanBnplResponseBodyDto> r5 = spay.sdk.data.dto.response.PaymentPlanBnplResponseBodyDto.class
            java.lang.Object r3 = r4.fromJson(r3, r5)
            spay.sdk.data.dto.response.PaymentPlanBnplResponseBodyDto r3 = (spay.sdk.data.dto.response.PaymentPlanBnplResponseBodyDto) r3
            java.lang.String r4 = "paymentPlanBnplResponseBodyDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            retrofit2.Response r3 = retrofit2.Response.success(r3)
            java.lang.String r4 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.PaymentBnplPlanRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r3, spay.sdk.domain.model.request.PaymentOrderRequestBody r4, kotlin.coroutines.Continuation r5) {
        /*
            r2 = this;
            boolean r3 = r5 instanceof npi.spay.C1823ok
            if (r3 == 0) goto L13
            r3 = r5
            npi.spay.ok r3 = (npi.spay.C1823ok) r3
            int r4 = r3.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.d = r4
            goto L18
        L13:
            npi.spay.ok r3 = new npi.spay.ok
            r3.<init>(r2, r5)
        L18:
            java.lang.Object r4 = r3.b
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            npi.spay.uk r3 = r3.a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L44
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.throwOnFailure(r4)
            r3.a = r2
            r3.d = r1
            r0 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r0, r3)
            if (r3 != r5) goto L43
            return r5
        L43:
            r3 = r2
        L44:
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            java.lang.String r5 = "payment_order_sdk.json"
            java.lang.String r3 = r3.a(r5)
            java.lang.Class<spay.sdk.data.dto.response.PaymentOrderResponseBodyDto> r5 = spay.sdk.data.dto.response.PaymentOrderResponseBodyDto.class
            java.lang.Object r3 = r4.fromJson(r3, r5)
            spay.sdk.data.dto.response.PaymentOrderResponseBodyDto r3 = (spay.sdk.data.dto.response.PaymentOrderResponseBodyDto) r3
            java.lang.String r4 = "paymentOrderResponseDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            retrofit2.Response r3 = retrofit2.Response.success(r3)
            java.lang.String r4 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.PaymentOrderRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r5, spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r5 = r7 instanceof npi.spay.C1873qk
            if (r5 == 0) goto L13
            r5 = r7
            npi.spay.qk r5 = (npi.spay.C1873qk) r5
            int r6 = r5.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r6 & r0
            if (r1 == 0) goto L13
            int r6 = r6 - r0
            r5.d = r6
            goto L18
        L13:
            npi.spay.qk r5 = new npi.spay.qk
            r5.<init>(r4, r7)
        L18:
            java.lang.Object r6 = r5.b
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            npi.spay.uk r5 = r5.a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r5.a = r4
            r5.d = r1
            r2 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r2, r5)
            if (r5 != r7) goto L43
            return r7
        L43:
            r5 = r4
        L44:
            r5.getClass()
            java.util.LinkedHashMap r6 = npi.spay.C1972uk.c
            java.lang.String r7 = "fraudMon"
            java.lang.Object r0 = r6.get(r7)
            if (r0 != 0) goto L52
            goto L60
        L52:
            java.lang.Object r0 = r6.get(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r1 = r1 + r0
        L60:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r6.put(r7, r0)
            com.google.gson.Gson r6 = new com.google.gson.Gson
            r6.<init>()
            java.lang.String r7 = "payment_token.json"
            java.lang.String r5 = r5.a(r7)
            java.lang.Class<spay.sdk.data.dto.response.PaymentTokenResponseBodyDto> r7 = spay.sdk.data.dto.response.PaymentTokenResponseBodyDto.class
            java.lang.Object r5 = r6.fromJson(r5, r7)
            spay.sdk.data.dto.response.PaymentTokenResponseBodyDto r5 = (spay.sdk.data.dto.response.PaymentTokenResponseBodyDto) r5
            java.lang.String r6 = "paymentTokenDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            retrofit2.Response r5 = retrofit2.Response.success(r5)
            java.lang.String r6 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody, Fm fm) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r3, spay.sdk.domain.model.request.PaymentTokenWithPurchaseRequestBody r4, kotlin.coroutines.Continuation r5) {
        /*
            r2 = this;
            boolean r3 = r5 instanceof npi.spay.C1897rk
            if (r3 == 0) goto L13
            r3 = r5
            npi.spay.rk r3 = (npi.spay.C1897rk) r3
            int r4 = r3.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.d = r4
            goto L18
        L13:
            npi.spay.rk r3 = new npi.spay.rk
            r3.<init>(r2, r5)
        L18:
            java.lang.Object r4 = r3.b
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            npi.spay.uk r3 = r3.a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L44
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.throwOnFailure(r4)
            r3.a = r2
            r3.d = r1
            r0 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r0, r3)
            if (r3 != r5) goto L43
            return r5
        L43:
            r3 = r2
        L44:
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            java.lang.String r5 = "payment_token.json"
            java.lang.String r3 = r3.a(r5)
            java.lang.Class<spay.sdk.data.dto.response.PaymentTokenResponseBodyDto> r5 = spay.sdk.data.dto.response.PaymentTokenResponseBodyDto.class
            java.lang.Object r3 = r4.fromJson(r3, r5)
            spay.sdk.data.dto.response.PaymentTokenResponseBodyDto r3 = (spay.sdk.data.dto.response.PaymentTokenResponseBodyDto) r3
            java.lang.String r4 = "paymentTokenDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            retrofit2.Response r3 = retrofit2.Response.success(r3)
            java.lang.String r4 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.PaymentTokenWithPurchaseRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // npi.spay.InterfaceC1797nj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r3, spay.sdk.domain.model.request.SessionIdWithOrderIdRequestBody r4, kotlin.coroutines.Continuation r5) {
        /*
            r2 = this;
            boolean r3 = r5 instanceof npi.spay.C1922sk
            if (r3 == 0) goto L13
            r3 = r5
            npi.spay.sk r3 = (npi.spay.C1922sk) r3
            int r4 = r3.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.d = r4
            goto L18
        L13:
            npi.spay.sk r3 = new npi.spay.sk
            r3.<init>(r2, r5)
        L18:
            java.lang.Object r4 = r3.b
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.d
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            npi.spay.uk r3 = r3.a
            kotlin.ResultKt.throwOnFailure(r4)
            goto L49
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.throwOnFailure(r4)
            java.util.LinkedHashMap r4 = npi.spay.C1972uk.c
            r4.clear()
            r3.a = r2
            r3.d = r1
            r0 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r0, r3)
            if (r3 != r5) goto L48
            return r5
        L48:
            r3 = r2
        L49:
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            java.lang.String r5 = "session_id_response.json"
            java.lang.String r3 = r3.a(r5)
            java.lang.Class<spay.sdk.data.dto.response.SessionIdResponseBodyDto> r5 = spay.sdk.data.dto.response.SessionIdResponseBodyDto.class
            java.lang.Object r3 = r4.fromJson(r3, r5)
            spay.sdk.data.dto.response.SessionIdResponseBodyDto r3 = (spay.sdk.data.dto.response.SessionIdResponseBodyDto) r3
            java.lang.String r4 = "sessionIdResponseBodyDto"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            retrofit2.Response r3 = retrofit2.Response.success(r3)
            java.lang.String r4 = "success(successfulResponseBody)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1972uk.a(java.lang.String, spay.sdk.domain.model.request.SessionIdWithOrderIdRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String a(String str) throws Throwable {
        String text;
        Throwable th;
        try {
            InputStream inputStreamOpen = this.a.getAssets().open(str);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "context.assets.open(filenamePath)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charsets.UTF_8), 8192);
            try {
                text = TextStreamsKt.readText(bufferedReader);
                try {
                    bufferedReader.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    bufferedReader.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th3, th4);
                }
                th = th3;
                text = null;
            }
        } catch (IOException e) {
            Timber.INSTANCE.tag("MOCK_REP").e(e);
            text = null;
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(text);
        if (text != null) {
            return text;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jsonString");
        return null;
    }
}
