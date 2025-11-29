package ru.yoomoney.sdk.auth.yandexAcquire.webView.commands;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenResponse;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.march.Command;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B/\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR&\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00028\u00000\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/commands/SetYandexTokenCommand;", "ACTION", "", "Lru/yoomoney/sdk/march/Command;", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenResponse;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "token", "transform", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getProcessId", "()Ljava/lang/String;", "getToken", "getTransform", "()Lkotlin/jvm/functions/Function1;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SetYandexTokenCommand<ACTION> implements Command<Result<? extends MigrationSetYandexTokenResponse>, ACTION> {
    private final String processId;
    private final String token;
    private final Function1<Result<? extends MigrationSetYandexTokenResponse>, ACTION> transform;

    /* JADX WARN: Multi-variable type inference failed */
    public SetYandexTokenCommand(String processId, String token, Function1<? super Result<? extends MigrationSetYandexTokenResponse>, ? extends ACTION> transform) {
        Intrinsics.checkNotNullParameter(processId, "processId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.processId = processId;
        this.token = token;
        this.transform = transform;
    }

    public final String getProcessId() {
        return this.processId;
    }

    public final String getToken() {
        return this.token;
    }

    public Function1<Result<? extends MigrationSetYandexTokenResponse>, ACTION> getTransform() {
        return this.transform;
    }
}
