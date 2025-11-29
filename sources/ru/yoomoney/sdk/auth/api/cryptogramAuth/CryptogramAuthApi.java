package ru.yoomoney.sdk.auth.api.cryptogramAuth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthRequest;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthResponse;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthValidateRequest;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthValidateResponse;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\fH§@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/api/cryptogramAuth/CryptogramAuthApi;", "", "cryptogramAuth", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthResponse;", "token", "", "request", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cryptogramAuthValidate", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateResponse;", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CryptogramAuthApi {
    @POST("cryptogram-auth")
    Object cryptogramAuth(@Header("Authorization") String str, @Body CryptogramAuthRequest cryptogramAuthRequest, Continuation<? super Response<CryptogramAuthResponse>> continuation);

    @POST("cryptogram-auth/validate")
    Object cryptogramAuthValidate(@Header("Authorization") String str, @Body CryptogramAuthValidateRequest cryptogramAuthValidateRequest, Continuation<? super Response<CryptogramAuthValidateResponse>> continuation);
}
