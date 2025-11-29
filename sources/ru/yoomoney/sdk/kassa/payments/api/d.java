package ru.yoomoney.sdk.kassa.payments.api;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDetailsResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentOptionsResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.paymentdetails.PaymentDetailsResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.paymentmethod.PaymentMethodResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensRequestPaymentInstrumentId;
import ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensRequestPaymentMethodData;
import ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensRequestPaymentMethodId;
import ru.yoomoney.sdk.kassa.payments.api.model.tokens.TokensResponse;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001JX\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\b\b\u0001\u0010\r\u001a\u00020\u0002H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0012H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0015J2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0016H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0017J2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0018H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0019J&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\b\b\u0001\u0010\u001a\u001a\u00020\u0002H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u0010J&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\t2\b\b\u0001\u0010\u001d\u001a\u00020\u0002H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0010J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020!0\t2\b\b\u0001\u0010 \u001a\u00020\u0002H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0010\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/d;", "", "", "gatewayId", "amount", "currency", "", "savePaymentMethod", "merchantCustomerId", "Lkotlin/Result;", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentOptionsResponse;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paymentMethodId", "Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/PaymentMethodResponse;", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "walletToken", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensRequestPaymentMethodData;", "tokensRequest", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensResponse;", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensRequestPaymentMethodData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensRequestPaymentInstrumentId;", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensRequestPaymentInstrumentId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensRequestPaymentMethodId;", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/tokens/TokensRequestPaymentMethodId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "instrumentId", "", "d", "confirmationData", "Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDetailsResponse;", "c", "paymentId", "Lru/yoomoney/sdk/kassa/payments/api/model/paymentdetails/PaymentDetailsResponse;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public interface d {
    @GET("/api/frontend/v3/payment_options")
    Object a(@Query("gateway_id") String str, @Query("amount") String str2, @Query("currency") String str3, @Query("save_payment_method") Boolean bool, @Query("merchant_customer_id") String str4, Continuation<? super Result<PaymentOptionsResponse>> continuation);

    @GET("/api/frontend/v3/payments/{payment_id}")
    Object a(@Path("payment_id") String str, Continuation<? super Result<PaymentDetailsResponse>> continuation);

    @POST("/api/frontend/v3/tokens")
    Object a(@Header("Wallet-Authorization") String str, @Body TokensRequestPaymentInstrumentId tokensRequestPaymentInstrumentId, Continuation<? super Result<TokensResponse>> continuation);

    @POST("/api/frontend/v3/tokens")
    Object a(@Header("Wallet-Authorization") String str, @Body TokensRequestPaymentMethodData tokensRequestPaymentMethodData, Continuation<? super Result<TokensResponse>> continuation);

    @POST("/api/frontend/v3/tokens")
    Object a(@Header("Wallet-Authorization") String str, @Body TokensRequestPaymentMethodId tokensRequestPaymentMethodId, Continuation<? super Result<TokensResponse>> continuation);

    @GET("/api/frontend/v3/payment_method")
    Object b(@Query("payment_method_id") String str, Continuation<? super Result<? extends PaymentMethodResponse>> continuation);

    @GET("/api/frontend/v3/confirmation_details")
    Object c(@Query("confirmation_data") String str, Continuation<? super Result<ConfirmationDetailsResponse>> continuation);

    @DELETE("/api/frontend/v3/payment_instruments/{payment_instrument_id}")
    Object d(@Path("payment_instrument_id") String str, Continuation<? super Result<Unit>> continuation);
}
