package ru.yoomoney.sdk.auth.yandexAcquire.webView.commands;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/commands/SetYandexTokenCommandExecutor;", "ACTION", "", "Lru/yoomoney/sdk/auth/yandexAcquire/login/commands/CommandExecutor;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/commands/SetYandexTokenCommand;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "(Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;)V", "execute", "command", "(Lru/yoomoney/sdk/auth/yandexAcquire/webView/commands/SetYandexTokenCommand;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SetYandexTokenCommandExecutor<ACTION> implements ru.yoomoney.sdk.auth.yandexAcquire.login.commands.CommandExecutor<ACTION, SetYandexTokenCommand<ACTION>> {
    private final MigrationRepository migrationRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.yandexAcquire.webView.commands.SetYandexTokenCommandExecutor", f = "YandexAcquireWebViewCommands.kt", l = {30, 37}, m = "execute")
    public static final class a extends ContinuationImpl {
        public SetYandexTokenCommandExecutor a;
        public SetYandexTokenCommand b;
        public int c;
        public /* synthetic */ Object d;
        public final /* synthetic */ SetYandexTokenCommandExecutor<ACTION> e;
        public int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SetYandexTokenCommandExecutor<ACTION> setYandexTokenCommandExecutor, Continuation<? super a> continuation) {
            super(continuation);
            this.e = setYandexTokenCommandExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.execute((SetYandexTokenCommand) null, (Continuation) this);
        }
    }

    public SetYandexTokenCommandExecutor(MigrationRepository migrationRepository) {
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        this.migrationRepository = migrationRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.yandexAcquire.login.commands.CommandExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(ru.yoomoney.sdk.auth.yandexAcquire.webView.commands.SetYandexTokenCommand<ACTION> r12, kotlin.coroutines.Continuation<? super ACTION> r13) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.yandexAcquire.webView.commands.SetYandexTokenCommandExecutor.execute(ru.yoomoney.sdk.auth.yandexAcquire.webView.commands.SetYandexTokenCommand, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
