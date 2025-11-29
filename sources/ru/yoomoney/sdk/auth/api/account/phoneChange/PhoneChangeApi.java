package ru.yoomoney.sdk.auth.api.account.phoneChange;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneForgotResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneSuccessResponse;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0012J<\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeApi;", "", "confirmPhone", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneResponse;", "authorizationHeader", "", "changePhoneProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneForgotResponse;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneResendResponse;", "phone", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneSuccessResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneResponse;", "geolocationHeader", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PhoneChangeApi {
    @POST("account/phone/{changePhoneProcessId}/confirm-phone")
    Object confirmPhone(@Header("Authorization") String str, @Path("changePhoneProcessId") String str2, @Body PhoneChangeConfirmPhoneRequest phoneChangeConfirmPhoneRequest, Continuation<? super Response<PhoneChangeConfirmPhoneResponse>> continuation);

    @POST("account/phone/{changePhoneProcessId}/confirm-phone/forgot")
    Object confirmPhoneForgot(@Header("Authorization") String str, @Path("changePhoneProcessId") String str2, Continuation<? super Response<PhoneChangeConfirmPhoneForgotResponse>> continuation);

    @POST("account/phone/{changePhoneProcessId}/confirm-phone/resend")
    Object confirmPhoneResend(@Header("Authorization") String str, @Path("changePhoneProcessId") String str2, Continuation<? super Response<PhoneChangeConfirmPhoneResendResponse>> continuation);

    @POST("account/phone")
    Object phone(@Header("Authorization") String str, Continuation<? super Response<PhoneSuccessResponse>> continuation);

    @POST("account/phone/{changePhoneProcessId}/set-phone")
    Object setPhone(@Header("Authorization") String str, @Header("X-Geolocation") String str2, @Path("changePhoneProcessId") String str3, @Body PhoneChangeSetPhoneRequest phoneChangeSetPhoneRequest, Continuation<? super Response<PhoneChangeSetPhoneResponse>> continuation);
}
