package ru.yoomoney.sdk.auth.yandexAcquire.webView.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenErrorResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebView;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"transformAcquire", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "result", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenResponse;", "(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireWebViewBusinessLogicKt {
    public static final YandexAcquireWebView.Action transformAcquire(Object obj) {
        Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(obj);
        if (thM2631exceptionOrNullimpl != null) {
            Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
            return new YandexAcquireWebView.Action.AcquireFail((Failure) thM2631exceptionOrNullimpl);
        }
        MigrationSetYandexTokenResponse migrationSetYandexTokenResponse = (MigrationSetYandexTokenResponse) obj;
        if (migrationSetYandexTokenResponse instanceof MigrationSetYandexTokenSuccessResponse) {
            return new YandexAcquireWebView.Action.AcquireSuccess(((MigrationSetYandexTokenSuccessResponse) migrationSetYandexTokenResponse).getProcess());
        }
        if (migrationSetYandexTokenResponse instanceof MigrationSetYandexTokenErrorResponse) {
            return new YandexAcquireWebView.Action.AcquireFail(ProcessErrorExtensionsKt.toFailure(((MigrationSetYandexTokenErrorResponse) migrationSetYandexTokenResponse).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
