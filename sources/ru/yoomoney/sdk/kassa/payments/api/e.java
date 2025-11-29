package ru.yoomoney.sdk.kassa.payments.api;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthCheckRequest;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthCheckResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthContextGetRequest;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthContextGetResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthSessionGenerateRequest;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthSessionGenerateResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueExecuteRequest;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueExecuteResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueInitRequest;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueInitResponse;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\bH§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\nJ&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bH§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u000eJ&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\b\b\u0001\u0010\f\u001a\u00020\u000fH§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0011J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\b\b\u0001\u0010\f\u001a\u00020\u0012H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0014\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/e;", "", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthCheckRequest;", "authCheckRequest", "Lkotlin/Result;", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthCheckResponse;", "a", "(Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthContextGetRequest;", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthContextGetResponse;", "(Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthContextGetRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthSessionGenerateRequest;", "authSessionGenerateRequest", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthSessionGenerateResponse;", "(Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/AuthSessionGenerateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/TokenIssueExecuteRequest;", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/TokenIssueExecuteResponse;", "(Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/TokenIssueExecuteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/TokenIssueInitRequest;", "Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/TokenIssueInitResponse;", "(Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/TokenIssueInitRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public interface e {
    @POST("/api/wallet-auth/v1/checkout/auth-check")
    Object a(@Body AuthCheckRequest authCheckRequest, Continuation<? super Result<AuthCheckResponse>> continuation);

    @POST("/api/wallet-auth/v1/checkout/auth-context-get")
    Object a(@Body AuthContextGetRequest authContextGetRequest, Continuation<? super Result<AuthContextGetResponse>> continuation);

    @POST("/api/wallet-auth/v1/checkout/auth-session-generate")
    Object a(@Body AuthSessionGenerateRequest authSessionGenerateRequest, Continuation<? super Result<AuthSessionGenerateResponse>> continuation);

    @POST("/api/wallet-auth/v1/checkout/token-issue-execute")
    Object a(@Body TokenIssueExecuteRequest tokenIssueExecuteRequest, Continuation<? super Result<TokenIssueExecuteResponse>> continuation);

    @POST("/api/wallet-auth/v1/checkout/token-issue-init")
    Object a(@Body TokenIssueInitRequest tokenIssueInitRequest, Continuation<? super Result<TokenIssueInitResponse>> continuation);
}
