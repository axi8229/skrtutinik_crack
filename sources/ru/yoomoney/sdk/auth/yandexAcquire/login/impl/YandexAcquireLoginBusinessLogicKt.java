package ru.yoomoney.sdk.auth.yandexAcquire.login.impl;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.login.method.LoginResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginSuccessResponse;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcess;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessFailure;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLogin;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"transformLogin", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$Action;", "result", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/login/method/LoginResponse;", "(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$Action;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireLoginBusinessLogicKt {
    public static final YandexAcquireLogin.Action transformLogin(Object obj) {
        Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(obj);
        if (thM2631exceptionOrNullimpl != null) {
            Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
            return new YandexAcquireLogin.Action.Fail((Failure) thM2631exceptionOrNullimpl);
        }
        LoginResponse loginResponse = (LoginResponse) obj;
        Intrinsics.checkNotNull(loginResponse, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.login.method.LoginSuccessResponse");
        LoginProcess process = ((LoginSuccessResponse) loginResponse).getProcess();
        return process instanceof LoginProcessFailure ? new YandexAcquireLogin.Action.Fail(ProcessErrorExtensionsKt.toFailure(((LoginProcessFailure) process).getError())) : new YandexAcquireLogin.Action.LoginSuccess(process);
    }
}
