package ru.yoomoney.sdk.auth.api.migration.hardMigration.commands;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/commands/MigrationEnrollmentCommandExecutor;", "ACTION", "", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/commands/CommandExecutor;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/commands/MigrationEnrollmentCommand;", "migrationApiRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "(Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;Lru/yoomoney/sdk/yooprofiler/YooProfiler;Lru/yoomoney/sdk/auth/ResultData;)V", "execute", "command", "(Lru/yoomoney/sdk/auth/api/migration/hardMigration/commands/MigrationEnrollmentCommand;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MigrationEnrollmentCommandExecutor<ACTION> implements CommandExecutor<ACTION, MigrationEnrollmentCommand<ACTION>> {
    private final MigrationRepository migrationApiRepository;
    private final YooProfiler profiler;
    private final ResultData resultData;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommandExecutor", f = "HardMigrationCommands.kt", l = {30}, m = "execute")
    public static final class a extends ContinuationImpl {
        public MigrationEnrollmentCommandExecutor a;
        public MigrationEnrollmentCommand b;
        public /* synthetic */ Object c;
        public final /* synthetic */ MigrationEnrollmentCommandExecutor<ACTION> d;
        public int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MigrationEnrollmentCommandExecutor<ACTION> migrationEnrollmentCommandExecutor, Continuation<? super a> continuation) {
            super(continuation);
            this.d = migrationEnrollmentCommandExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.execute((MigrationEnrollmentCommand) null, (Continuation) this);
        }
    }

    public MigrationEnrollmentCommandExecutor(MigrationRepository migrationApiRepository, YooProfiler profiler, ResultData resultData) {
        Intrinsics.checkNotNullParameter(migrationApiRepository, "migrationApiRepository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        this.migrationApiRepository = migrationApiRepository;
        this.profiler = profiler;
        this.resultData = resultData;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.CommandExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommand<ACTION> r10, kotlin.coroutines.Continuation<? super ACTION> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommandExecutor.a
            if (r0 == 0) goto L13
            r0 = r11
            ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommandExecutor$a r0 = (ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommandExecutor.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommandExecutor$a r0 = new ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommandExecutor$a
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommand r10 = r0.b
            ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommandExecutor r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            java.lang.Object r11 = r11.getValue()
            goto L5b
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            kotlin.ResultKt.throwOnFailure(r11)
            ru.yoomoney.sdk.auth.api.migration.method.MigrationEnrollmentRequest r11 = new ru.yoomoney.sdk.auth.api.migration.method.MigrationEnrollmentRequest
            java.lang.String r2 = r10.getProcessId()
            java.lang.String r4 = r10.getUid()
            r11.<init>(r2, r4)
            ru.yoomoney.sdk.auth.api.migration.MigrationRepository r2 = r9.migrationApiRepository
            r0.a = r9
            r0.b = r10
            r0.e = r3
            java.lang.Object r11 = r2.mo3276migrationgIAlus(r11, r0)
            if (r11 != r1) goto L5a
            return r1
        L5a:
            r0 = r9
        L5b:
            boolean r1 = kotlin.Result.m2634isSuccessimpl(r11)
            if (r1 == 0) goto L9c
            r1 = r11
            ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse r1 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse) r1
            boolean r2 = r1 instanceof ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse
            if (r2 == 0) goto L9c
            ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse r1 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse) r1
            java.lang.String r1 = r1.getTmxSessionId()
            if (r1 == 0) goto L9c
            ru.yoomoney.sdk.yooprofiler.YooProfiler r2 = r0.profiler
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r4 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.DETAILS_CHANGE
            java.lang.String r5 = r10.getUid()
            r7 = 8
            r8 = 0
            r6 = 0
            r3 = r1
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result r2 = ru.yoomoney.sdk.yooprofiler.YooProfiler.DefaultImpls.profileWithSessionId$default(r2, r3, r4, r5, r6, r7, r8)
            ru.yoomoney.sdk.auth.ResultData r0 = r0.resultData
            boolean r3 = r2 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success
            if (r3 == 0) goto L8e
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result$Success r2 = (ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success) r2
            java.lang.String r1 = r2.getSessionId()
            goto L92
        L8e:
            boolean r2 = r2 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Fail
            if (r2 == 0) goto L96
        L92:
            r0.setTmxSessionId(r1)
            goto L9c
        L96:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L9c:
            kotlin.jvm.functions.Function1 r10 = r10.getTransform()
            kotlin.Result r11 = kotlin.Result.m2627boximpl(r11)
            java.lang.Object r10 = r10.invoke(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommandExecutor.execute(ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommand, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
