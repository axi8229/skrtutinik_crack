package ru.yoomoney.sdk.auth.api.migration.hardMigration.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigration;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.CommandExecutor;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommand;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationLoginCommand;
import ru.yoomoney.sdk.march.Command;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0003¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\u00042\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\u000bH\u0096B¢\u0006\u0002\u0010\fR \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/impl/HardMigrationCommandProcessor;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$CommandProcessor;", "migrationEnrollmentCommandExecutor", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/commands/CommandExecutor;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/commands/MigrationEnrollmentCommand;", "migrationLoginCommandExecutor", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/commands/MigrationLoginCommand;", "(Lru/yoomoney/sdk/auth/api/migration/hardMigration/commands/CommandExecutor;Lru/yoomoney/sdk/auth/api/migration/hardMigration/commands/CommandExecutor;)V", "invoke", "command", "Lru/yoomoney/sdk/march/Command;", "(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HardMigrationCommandProcessor implements HardMigration.CommandProcessor {
    private final CommandExecutor<HardMigration.Action, MigrationEnrollmentCommand<HardMigration.Action>> migrationEnrollmentCommandExecutor;
    private final CommandExecutor<HardMigration.Action, MigrationLoginCommand<HardMigration.Action>> migrationLoginCommandExecutor;

    public HardMigrationCommandProcessor(CommandExecutor<HardMigration.Action, MigrationEnrollmentCommand<HardMigration.Action>> migrationEnrollmentCommandExecutor, CommandExecutor<HardMigration.Action, MigrationLoginCommand<HardMigration.Action>> migrationLoginCommandExecutor) {
        Intrinsics.checkNotNullParameter(migrationEnrollmentCommandExecutor, "migrationEnrollmentCommandExecutor");
        Intrinsics.checkNotNullParameter(migrationLoginCommandExecutor, "migrationLoginCommandExecutor");
        this.migrationEnrollmentCommandExecutor = migrationEnrollmentCommandExecutor;
        this.migrationLoginCommandExecutor = migrationLoginCommandExecutor;
    }

    @Override // ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigration.CommandProcessor
    public Object invoke(Command<?, ? extends HardMigration.Action> command, Continuation<? super HardMigration.Action> continuation) {
        CommandExecutor commandExecutor;
        if (command instanceof MigrationEnrollmentCommand) {
            commandExecutor = this.migrationEnrollmentCommandExecutor;
        } else {
            if (!(command instanceof MigrationLoginCommand)) {
                throw new IllegalStateException(("can't execute command " + command).toString());
            }
            commandExecutor = this.migrationLoginCommandExecutor;
        }
        return commandExecutor.execute(command, continuation);
    }
}
