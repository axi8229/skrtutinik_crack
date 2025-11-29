package ru.yoomoney.sdk.auth.api.migration;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPasswordRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPasswordResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenResponse;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\bJ,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0014H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\bJ$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0006\u0010\u000b\u001a\u00020\u001cH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020!H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J,\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020&H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J,\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020+H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J,\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u000200H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "", "acquireAuthorization", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationAcquireAuthorizationResponse;", "migrationProcessId", "", "acquireAuthorization-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailResponse;", "request", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "confirmPhone", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "migration", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationRequest;", "migration-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/migration/method/MigrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailRequest;", "setEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPasswordResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPasswordRequest;", "setPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneRequest;", "setPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setYandexToken", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenRequest;", "setYandexToken-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface MigrationRepository {
    /* renamed from: acquireAuthorization-gIAlu-s, reason: not valid java name */
    Object mo3271acquireAuthorizationgIAlus(String str, Continuation<? super Result<? extends MigrationAcquireAuthorizationResponse>> continuation);

    /* renamed from: confirmEmail-0E7RQCE, reason: not valid java name */
    Object mo3272confirmEmail0E7RQCE(String str, MigrationConfirmEmailRequest migrationConfirmEmailRequest, Continuation<? super Result<? extends MigrationConfirmEmailResponse>> continuation);

    /* renamed from: confirmEmailResend-gIAlu-s, reason: not valid java name */
    Object mo3273confirmEmailResendgIAlus(String str, Continuation<? super Result<? extends MigrationConfirmEmailResendResponse>> continuation);

    /* renamed from: confirmPhone-0E7RQCE, reason: not valid java name */
    Object mo3274confirmPhone0E7RQCE(String str, MigrationConfirmPhoneRequest migrationConfirmPhoneRequest, Continuation<? super Result<? extends MigrationConfirmPhoneResponse>> continuation);

    /* renamed from: confirmPhoneResend-gIAlu-s, reason: not valid java name */
    Object mo3275confirmPhoneResendgIAlus(String str, Continuation<? super Result<? extends MigrationConfirmPhoneResendResponse>> continuation);

    /* renamed from: migration-gIAlu-s, reason: not valid java name */
    Object mo3276migrationgIAlus(MigrationRequest migrationRequest, Continuation<? super Result<? extends MigrationResponse>> continuation);

    /* renamed from: setEmail-0E7RQCE, reason: not valid java name */
    Object mo3277setEmail0E7RQCE(String str, MigrationSetEmailRequest migrationSetEmailRequest, Continuation<? super Result<? extends MigrationSetEmailResponse>> continuation);

    /* renamed from: setPassword-0E7RQCE, reason: not valid java name */
    Object mo3278setPassword0E7RQCE(String str, MigrationSetPasswordRequest migrationSetPasswordRequest, Continuation<? super Result<? extends MigrationSetPasswordResponse>> continuation);

    /* renamed from: setPhone-0E7RQCE, reason: not valid java name */
    Object mo3279setPhone0E7RQCE(String str, MigrationSetPhoneRequest migrationSetPhoneRequest, Continuation<? super Result<? extends MigrationSetPhoneResponse>> continuation);

    /* renamed from: setYandexToken-0E7RQCE, reason: not valid java name */
    Object mo3280setYandexToken0E7RQCE(String str, MigrationSetYandexTokenRequest migrationSetYandexTokenRequest, Continuation<? super Result<? extends MigrationSetYandexTokenResponse>> continuation);
}
