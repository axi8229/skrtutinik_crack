package ru.yoomoney.sdk.auth.api.registrationV2;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\bJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\bJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u0010H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0016J4\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "", "acquireAuthorization", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "acquireAuthorization-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "confirmEmail-gIAlu-s", "confirmPhone", "confirmPhone-gIAlu-s", "initRegistration", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationInit;", "request", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration;", "initRegistration-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/Registration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", Scopes.EMAIL, "setEmail-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", AppMeasurementSdk.ConditionalUserProperty.VALUE, "setPassword-0E7RQCE", "setPhone", "phone", "countryCode", "setPhone-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface RegistrationV2Repository {
    /* renamed from: acquireAuthorization-gIAlu-s, reason: not valid java name */
    Object mo3294acquireAuthorizationgIAlus(String str, Continuation<? super Result<? extends RegistrationProcess>> continuation);

    /* renamed from: confirmEmail-gIAlu-s, reason: not valid java name */
    Object mo3295confirmEmailgIAlus(String str, Continuation<? super Result<? extends RegistrationProcess>> continuation);

    /* renamed from: confirmPhone-gIAlu-s, reason: not valid java name */
    Object mo3296confirmPhonegIAlus(String str, Continuation<? super Result<? extends RegistrationProcess>> continuation);

    /* renamed from: initRegistration-gIAlu-s, reason: not valid java name */
    Object mo3297initRegistrationgIAlus(Registration registration, Continuation<? super Result<RegistrationInit>> continuation);

    /* renamed from: setEmail-0E7RQCE, reason: not valid java name */
    Object mo3298setEmail0E7RQCE(String str, String str2, Continuation<? super Result<? extends RegistrationProcess>> continuation);

    /* renamed from: setPassword-0E7RQCE, reason: not valid java name */
    Object mo3299setPassword0E7RQCE(String str, String str2, Continuation<? super Result<? extends RegistrationProcess>> continuation);

    /* renamed from: setPhone-BWLJW6A, reason: not valid java name */
    Object mo3300setPhoneBWLJW6A(String str, String str2, String str3, Continuation<? super Result<? extends RegistrationProcess>> continuation);
}
