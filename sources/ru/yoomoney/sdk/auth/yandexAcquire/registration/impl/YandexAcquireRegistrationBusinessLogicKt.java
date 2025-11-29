package ru.yoomoney.sdk.auth.yandexAcquire.registration.impl;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistration;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"transformRegistration", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "result", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationInit;", "(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireRegistrationBusinessLogicKt {
    public static final YandexAcquireRegistration.Action transformRegistration(Object obj) {
        Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(obj);
        if (thM2631exceptionOrNullimpl == null) {
            RegistrationInit registrationInit = (RegistrationInit) obj;
            return registrationInit.getRegistrationProcess() instanceof RegistrationProcess.Failure ? new YandexAcquireRegistration.Action.Fail(ProcessErrorExtensionsKt.toFailure(((RegistrationProcess.Failure) registrationInit.getRegistrationProcess()).getError())) : new YandexAcquireRegistration.Action.RegistrationSuccess(registrationInit.getRegistrationProcess());
        }
        Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
        return new YandexAcquireRegistration.Action.Fail((Failure) thM2631exceptionOrNullimpl);
    }
}
