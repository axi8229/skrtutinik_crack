package ru.yoomoney.sdk.auth.api.migration.hardMigration.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigration;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommand;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationLoginCommand;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.march.Command;
import ru.yoomoney.sdk.march.TripleBuildersKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J8\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J9\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0096\u0002J\u001a\u0010\u0011\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/impl/HardMigrationBusinessLogic;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$BusinessLogic;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "analyticsLogger", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$AnalyticsLogger;)V", "handleContentState", "Lkotlin/Triple;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$State;", "Lru/yoomoney/sdk/march/Command;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Effect;", "state", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$State$Content;", "action", "invoke", "migrationCommand", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action$Confirm;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HardMigrationBusinessLogic implements HardMigration.BusinessLogic {
    private final HardMigration.AnalyticsLogger analyticsLogger;
    private final ServerTimeRepository serverTimeRepository;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.REGISTRATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.LOGIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Result<? extends MigrationResponse>, HardMigration.Action> {
        public static final a a = new a();

        public a() {
            super(1, HardMigrationBusinessLogicKt.class, "migrationTransform", "migrationTransform(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final HardMigration.Action invoke(Result<? extends MigrationResponse> result) {
            return HardMigrationBusinessLogicKt.migrationTransform(result.getValue());
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Result<? extends MigrationResponse>, HardMigration.Action> {
        public static final b a = new b();

        public b() {
            super(1, HardMigrationBusinessLogicKt.class, "migrationTransform", "migrationTransform(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final HardMigration.Action invoke(Result<? extends MigrationResponse> result) {
            return HardMigrationBusinessLogicKt.migrationTransform(result.getValue());
        }
    }

    public HardMigrationBusinessLogic(ServerTimeRepository serverTimeRepository, HardMigration.AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.serverTimeRepository = serverTimeRepository;
        this.analyticsLogger = analyticsLogger;
    }

    private final Triple<HardMigration.State, Command<?, HardMigration.Action>, HardMigration.Effect> handleContentState(HardMigration.State.Content state, HardMigration.Action action) {
        Object obj;
        HardMigration.State.Content content;
        Object showFailure;
        if (!(action instanceof HardMigration.Action.Confirm)) {
            if (action instanceof HardMigration.Action.MigrationSuccess) {
                content = new HardMigration.State.Content(false, 1, null);
                showFailure = new HardMigration.Effect.ShowNextStep(((HardMigration.Action.MigrationSuccess) action).getMigrationProcess());
            } else if (action instanceof HardMigration.Action.ShowFailure) {
                content = new HardMigration.State.Content(false, 1, null);
                showFailure = new HardMigration.Effect.ShowFailure(((HardMigration.Action.ShowFailure) action).getFailure());
            } else {
                if (!Intrinsics.areEqual(action, HardMigration.Action.RestartProcess.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                state = new HardMigration.State.Content(false, 1, null);
                obj = HardMigration.Effect.ResetProcess.INSTANCE;
            }
            return TripleBuildersKt.with(content, showFailure);
        }
        HardMigration.Action.Confirm confirm = (HardMigration.Action.Confirm) action;
        OffsetDateTime expireAt = confirm.getExpireAt();
        if (expireAt == null || !expireAt.isBefore(this.serverTimeRepository.getCurrentDateTime())) {
            return TripleBuildersKt.with(new HardMigration.State.Content(true), (Command) migrationCommand(confirm));
        }
        obj = HardMigration.Effect.ShowExpireDialog.INSTANCE;
        return TripleBuildersKt.with(state, obj);
    }

    private final Command<?, HardMigration.Action> migrationCommand(HardMigration.Action.Confirm action) {
        int i = WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()];
        if (i == 1) {
            return new MigrationEnrollmentCommand(action.getUid(), action.getProcessId(), a.a);
        }
        if (i == 2) {
            return new MigrationLoginCommand(action.getUid(), action.getProcessId(), b.a);
        }
        throw new IllegalArgumentException("no command for process " + this);
    }

    @Override // ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigration.BusinessLogic, kotlin.jvm.functions.Function2
    public Triple<HardMigration.State, Command<?, HardMigration.Action>, HardMigration.Effect> invoke(HardMigration.State state, HardMigration.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        HardMigration.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof HardMigration.State.Content) {
            return handleContentState((HardMigration.State.Content) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
