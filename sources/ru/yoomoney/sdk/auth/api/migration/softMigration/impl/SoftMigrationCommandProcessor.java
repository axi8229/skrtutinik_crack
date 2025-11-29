package ru.yoomoney.sdk.auth.api.migration.softMigration.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.migration.softMigration.SoftMigration;
import ru.yoomoney.sdk.auth.api.migration.softMigration.commands.CommandExecutor;
import ru.yoomoney.sdk.auth.api.migration.softMigration.commands.SoftMigrationCommand;
import ru.yoomoney.sdk.march.Command;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\tH\u0096B¢\u0006\u0002\u0010\nR \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/softMigration/impl/SoftMigrationCommandProcessor;", "Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$CommandProcessor;", "softMigrationCommandExecutor", "Lru/yoomoney/sdk/auth/api/migration/softMigration/commands/CommandExecutor;", "Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$Action;", "Lru/yoomoney/sdk/auth/api/migration/softMigration/commands/SoftMigrationCommand;", "(Lru/yoomoney/sdk/auth/api/migration/softMigration/commands/CommandExecutor;)V", "invoke", "command", "Lru/yoomoney/sdk/march/Command;", "(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SoftMigrationCommandProcessor implements SoftMigration.CommandProcessor {
    private final CommandExecutor<SoftMigration.Action, SoftMigrationCommand<SoftMigration.Action>> softMigrationCommandExecutor;

    public SoftMigrationCommandProcessor(CommandExecutor<SoftMigration.Action, SoftMigrationCommand<SoftMigration.Action>> softMigrationCommandExecutor) {
        Intrinsics.checkNotNullParameter(softMigrationCommandExecutor, "softMigrationCommandExecutor");
        this.softMigrationCommandExecutor = softMigrationCommandExecutor;
    }

    @Override // ru.yoomoney.sdk.auth.api.migration.softMigration.SoftMigration.CommandProcessor
    public Object invoke(Command<?, ? extends SoftMigration.Action> command, Continuation<? super SoftMigration.Action> continuation) {
        if (command instanceof SoftMigrationCommand) {
            return this.softMigrationCommandExecutor.execute(command, continuation);
        }
        throw new IllegalStateException(("can't execute command " + command).toString());
    }
}
