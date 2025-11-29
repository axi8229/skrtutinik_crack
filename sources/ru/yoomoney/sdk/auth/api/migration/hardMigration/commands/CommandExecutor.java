package ru.yoomoney.sdk.auth.api.migration.hardMigration.commands;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.march.Command;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0012\b\u0001\u0010\u0003*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0002J\u0016\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H¦@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/commands/CommandExecutor;", "ACTION", "", "COMMAND", "Lru/yoomoney/sdk/march/Command;", "execute", "command", "(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CommandExecutor<ACTION, COMMAND extends Command<?, ? extends ACTION>> {
    Object execute(COMMAND command, Continuation<? super ACTION> continuation);
}
