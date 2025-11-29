package ru.yoomoney.sdk.auth.api.cryptogramAuth;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthRequest;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthResponse;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthValidateRequest;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthValidateResponse;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u000bH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/api/cryptogramAuth/CryptogramAuthRepository;", "", "getAuthCryptogram", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthResponse;", "request", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthRequest;", "getAuthCryptogram-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateAuthCryptogram", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateResponse;", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateRequest;", "validateAuthCryptogram-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CryptogramAuthRepository {
    /* renamed from: getAuthCryptogram-gIAlu-s, reason: not valid java name */
    Object mo3246getAuthCryptogramgIAlus(CryptogramAuthRequest cryptogramAuthRequest, Continuation<? super Result<CryptogramAuthResponse>> continuation);

    /* renamed from: validateAuthCryptogram-gIAlu-s, reason: not valid java name */
    Object mo3247validateAuthCryptogramgIAlus(CryptogramAuthValidateRequest cryptogramAuthValidateRequest, Continuation<? super Result<CryptogramAuthValidateResponse>> continuation);
}
