package npi.spay;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
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

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ7\u0010\b\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000eJ7\u0010\b\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0011J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0012H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0015J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0018J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u0019H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u001cJ7\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u001dH§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010 J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020#0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\"\u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010$J-\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\"\u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0004\b&\u0010$J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020)0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010(\u001a\u00020'H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010*J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020)0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020+H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010-J-\u0010\b\u001a\b\u0012\u0004\u0012\u0002000\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010/\u001a\u00020.H§@ø\u0001\u0000¢\u0006\u0004\b\b\u00101J-\u0010\b\u001a\b\u0012\u0004\u0012\u0002040\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u000202H§@ø\u0001\u0000¢\u0006\u0004\b\b\u00105J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\b\u00106J'\u0010&\u001a\u00020\u001f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0012H§@ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lnpi/spay/k9;", "", "", "authorization", "Lspay/sdk/domain/model/request/SessionIdWithOrderIdRequestBody;", "sessionIdWithOrderIdRequestBody", "Lretrofit2/Response;", "Lspay/sdk/data/dto/response/SessionIdResponseBodyDto;", "a", "(Ljava/lang/String;Lspay/sdk/domain/model/request/SessionIdWithOrderIdRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "systemId", "Lspay/sdk/domain/model/request/ListOfCardsWithOrderIdRequestBody;", "listOfCardsWithOrderIdRequestBody", "Lspay/sdk/data/dto/response/listOfCards/ListOfCardsResponseBodyDto;", "(Ljava/lang/String;Ljava/lang/String;Lspay/sdk/domain/model/request/ListOfCardsWithOrderIdRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lspay/sdk/domain/model/request/ListOfCardsWithPurchaseRequestBody;", "listOfCardsWithPurchaseRequestBody", "(Ljava/lang/String;Ljava/lang/String;Lspay/sdk/domain/model/request/ListOfCardsWithPurchaseRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lspay/sdk/domain/model/request/PaymentTokenWithOrderIdRequestBody;", "paymentTokenWithOrderIdRequestBody", "Lspay/sdk/data/dto/response/PaymentTokenResponseBodyDto;", "(Ljava/lang/String;Lspay/sdk/domain/model/request/PaymentTokenWithOrderIdRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lspay/sdk/domain/model/request/PaymentTokenWithPurchaseRequestBody;", "paymentTokenWithPurchaseRequestBody", "(Ljava/lang/String;Lspay/sdk/domain/model/request/PaymentTokenWithPurchaseRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lspay/sdk/domain/model/request/PaymentOrderRequestBody;", "paymentOrderRequestBody", "Lspay/sdk/data/dto/response/PaymentOrderResponseBodyDto;", "(Ljava/lang/String;Lspay/sdk/domain/model/request/PaymentOrderRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lspay/sdk/domain/model/request/PayOnlineRequestBody;", "payOnlineRequestBody", "", "(Ljava/lang/String;Ljava/lang/String;Lspay/sdk/domain/model/request/PayOnlineRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lspay/sdk/domain/model/request/PaymentBnplPlanRequestBody;", "paymentBnplPlanRequestBody", "Lspay/sdk/data/dto/response/PaymentPlanBnplResponseBodyDto;", "(Ljava/lang/String;Lspay/sdk/domain/model/request/PaymentBnplPlanRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lspay/sdk/data/dto/response/PartsPaymentPlanBnplResponseBodyDto;", "b", "Lspay/sdk/domain/model/request/AuthWithOrderIdRequestBody;", "authWithOrderIdRequestBody", "Lspay/sdk/data/dto/response/AuthResponseBodyDto;", "(Ljava/lang/String;Lspay/sdk/domain/model/request/AuthWithOrderIdRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lspay/sdk/domain/model/request/AuthWithPurchaseRequestBody;", "authWithPurchaseRequestBody", "(Ljava/lang/String;Lspay/sdk/domain/model/request/AuthWithPurchaseRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lspay/sdk/domain/model/request/ConfirmOtpRequestBody;", "confirmOtpRequestBody", "Lspay/sdk/data/dto/response/otp/ConfirmOtpResponseBodyDto;", "(Ljava/lang/String;Lspay/sdk/domain/model/request/ConfirmOtpRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lspay/sdk/domain/model/request/CreateOtpSdkRequestBody;", "createOtpSdkRequestBody", "Lspay/sdk/data/dto/response/otp/CreateOtpSdkResponseBodyDto;", "(Ljava/lang/String;Lspay/sdk/domain/model/request/CreateOtpSdkRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.k9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC1712k9 {
    @POST("sdk-gateway/v1/revokeTokenSdk")
    Object a(@Header("Authorization") String str, @Header("X-System-id") String str2, Continuation<? super Response<Unit>> continuation);

    @POST("sdk-gateway/v3/listCards")
    Object a(@Header("Authorization") String str, @Header("x-system-id") String str2, @Body ListOfCardsWithOrderIdRequestBody listOfCardsWithOrderIdRequestBody, Continuation<? super Response<ListOfCardsResponseBodyDto>> continuation);

    @POST("sdk-gateway/v3/listCards")
    Object a(@Header("Authorization") String str, @Header("x-system-id") String str2, @Body ListOfCardsWithPurchaseRequestBody listOfCardsWithPurchaseRequestBody, Continuation<? super Response<ListOfCardsResponseBodyDto>> continuation);

    @POST("sdk-gateway/v1/payOnline")
    Object a(@Header("Authorization") String str, @Header("x-system-id") String str2, @Body PayOnlineRequestBody payOnlineRequestBody, Continuation<? super Response<Unit>> continuation);

    @POST("sberpay-auth/v2/sdkAuth")
    Object a(@Header("Authorization") String str, @Body AuthWithOrderIdRequestBody authWithOrderIdRequestBody, Continuation<? super Response<AuthResponseBodyDto>> continuation);

    @POST("sberpay-auth/v2/sdkAuth")
    Object a(@Header("Authorization") String str, @Body AuthWithPurchaseRequestBody authWithPurchaseRequestBody, Continuation<? super Response<AuthResponseBodyDto>> continuation);

    @POST("sdk-gateway/v1/confirmOtp")
    Object a(@Header("Authorization") String str, @Body ConfirmOtpRequestBody confirmOtpRequestBody, Continuation<? super Response<ConfirmOtpResponseBodyDto>> continuation);

    @POST("sdk-gateway/v1/createOtp")
    Object a(@Header("Authorization") String str, @Body CreateOtpSdkRequestBody createOtpSdkRequestBody, Continuation<? super Response<CreateOtpSdkResponseBodyDto>> continuation);

    @POST("sdk-gateway/v2/paymentPlanBnpl")
    Object a(@Header("Authorization") String str, @Body PaymentBnplPlanRequestBody paymentBnplPlanRequestBody, Continuation<? super Response<PaymentPlanBnplResponseBodyDto>> continuation);

    @POST("sdk-gateway/v1/paymentOrder")
    Object a(@Header("Authorization") String str, @Body PaymentOrderRequestBody paymentOrderRequestBody, Continuation<? super Response<PaymentOrderResponseBodyDto>> continuation);

    @POST("sdk-gateway/v1/paymentToken")
    Object a(@Header("Authorization") String str, @Body PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody, Continuation<? super Response<PaymentTokenResponseBodyDto>> continuation);

    @POST("sdk-gateway/v1/paymentToken")
    Object a(@Header("Authorization") String str, @Body PaymentTokenWithPurchaseRequestBody paymentTokenWithPurchaseRequestBody, Continuation<? super Response<PaymentTokenResponseBodyDto>> continuation);

    @POST("sdk-gateway/v1/sessionId")
    Object a(@Header("Authorization") String str, @Body SessionIdWithOrderIdRequestBody sessionIdWithOrderIdRequestBody, Continuation<? super Response<SessionIdResponseBodyDto>> continuation);

    @POST("sdk-gateway/v1/createPaymentPlan")
    Object b(@Header("Authorization") String str, @Body PaymentBnplPlanRequestBody paymentBnplPlanRequestBody, Continuation<? super Response<PartsPaymentPlanBnplResponseBodyDto>> continuation);

    @POST("sdk-gateway/v1/paymentToken")
    Object b(@Header("Authorization") String str, @Body PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody, Continuation<? super Unit> continuation);
}
