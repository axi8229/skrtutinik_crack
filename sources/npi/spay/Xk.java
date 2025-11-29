package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;
import spay.sdk.data.dto.response.AuthResponseBodyDto;
import spay.sdk.data.dto.response.PartsPaymentPlanBnplResponseBodyDto;
import spay.sdk.data.dto.response.PaymentOrderResponseBodyDto;
import spay.sdk.data.dto.response.PaymentPlanBnplResponseBodyDto;
import spay.sdk.data.dto.response.PaymentTokenResponseBodyDto;
import spay.sdk.data.dto.response.SessionIdResponseBodyDto;
import spay.sdk.data.dto.response.listOfCards.ListOfCardsResponseBodyDto;
import spay.sdk.data.dto.response.otp.ConfirmOtpResponseBodyDto;
import spay.sdk.data.dto.response.otp.CreateOtpSdkResponseBodyDto;
import spay.sdk.domain.model.request.AuthWithOrderIdRequestBody;
import spay.sdk.domain.model.request.AuthWithPurchaseRequestBody;
import spay.sdk.domain.model.request.ConfirmOtpRequestBody;
import spay.sdk.domain.model.request.CreateOtpSdkRequestBody;
import spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody;
import spay.sdk.domain.model.request.ListOfCardsWithPurchaseRequestBody;
import spay.sdk.domain.model.request.PayOnlineRequestBody;
import spay.sdk.domain.model.request.PaymentBnplPlanRequestBody;
import spay.sdk.domain.model.request.PaymentOrderRequestBody;
import spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody;
import spay.sdk.domain.model.request.PaymentTokenWithPurchaseRequestBody;
import spay.sdk.domain.model.request.SessionIdWithOrderIdRequestBody;

/* loaded from: classes4.dex */
public final class Xk implements InterfaceC1797nj {
    public final C1951u a;

    public Xk(C1951u lazyNetworkModule) {
        Intrinsics.checkNotNullParameter(lazyNetworkModule, "lazyNetworkModule");
        this.a = lazyNetworkModule;
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, Continuation continuation) {
        return this.a.a().a(str, "SBERPAY_SDK", (Continuation<? super Response<Unit>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object b(String str, PaymentBnplPlanRequestBody paymentBnplPlanRequestBody, Continuation continuation) {
        return this.a.a().b(str, paymentBnplPlanRequestBody, (Continuation<? super Response<PartsPaymentPlanBnplResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, AuthWithOrderIdRequestBody authWithOrderIdRequestBody, Continuation continuation) {
        return this.a.a().a(str, authWithOrderIdRequestBody, (Continuation<? super Response<AuthResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, AuthWithPurchaseRequestBody authWithPurchaseRequestBody, Continuation continuation) {
        return this.a.a().a(str, authWithPurchaseRequestBody, (Continuation<? super Response<AuthResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, ConfirmOtpRequestBody confirmOtpRequestBody, Continuation continuation) {
        return this.a.a().a(str, confirmOtpRequestBody, (Continuation<? super Response<ConfirmOtpResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, CreateOtpSdkRequestBody createOtpSdkRequestBody, Continuation continuation) {
        return this.a.a().a(str, createOtpSdkRequestBody, (Continuation<? super Response<CreateOtpSdkResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, ListOfCardsWithOrderIdRequestBody listOfCardsWithOrderIdRequestBody, Continuation continuation) {
        return this.a.a().a(str, "SBERPAY_SDK", listOfCardsWithOrderIdRequestBody, (Continuation<? super Response<ListOfCardsResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, ListOfCardsWithPurchaseRequestBody listOfCardsWithPurchaseRequestBody, Continuation continuation) {
        return this.a.a().a(str, "SBERPAY_SDK", listOfCardsWithPurchaseRequestBody, (Continuation<? super Response<ListOfCardsResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, PayOnlineRequestBody payOnlineRequestBody, Continuation continuation) {
        return this.a.a().a(str, "SBERPAY_SDK", payOnlineRequestBody, (Continuation<? super Response<Unit>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, PaymentBnplPlanRequestBody paymentBnplPlanRequestBody, Continuation continuation) {
        return this.a.a().a(str, paymentBnplPlanRequestBody, (Continuation<? super Response<PaymentPlanBnplResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, PaymentOrderRequestBody paymentOrderRequestBody, Continuation continuation) {
        return this.a.a().a(str, paymentOrderRequestBody, (Continuation<? super Response<PaymentOrderResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody, Continuation continuation) {
        return this.a.a().a(str, paymentTokenWithOrderIdRequestBody, (Continuation<? super Response<PaymentTokenResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody, Fm fm) {
        Object objB = this.a.a().b(str, paymentTokenWithOrderIdRequestBody, fm);
        return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Unit.INSTANCE;
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, PaymentTokenWithPurchaseRequestBody paymentTokenWithPurchaseRequestBody, Continuation continuation) {
        return this.a.a().a(str, paymentTokenWithPurchaseRequestBody, (Continuation<? super Response<PaymentTokenResponseBodyDto>>) continuation);
    }

    @Override // npi.spay.InterfaceC1797nj
    public final Object a(String str, SessionIdWithOrderIdRequestBody sessionIdWithOrderIdRequestBody, Continuation continuation) {
        return this.a.a().a(str, sessionIdWithOrderIdRequestBody, (Continuation<? super Response<SessionIdResponseBodyDto>>) continuation);
    }
}
