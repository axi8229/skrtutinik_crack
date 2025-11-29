package ru.yoomoney.sdk.auth.api.migration.softMigration.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse;
import ru.yoomoney.sdk.auth.api.migration.softMigration.SoftMigration;
import ru.yoomoney.sdk.auth.api.migration.softMigration.commands.SoftMigrationCommand;
import ru.yoomoney.sdk.march.Command;
import ru.yoomoney.sdk.march.TripleBuildersKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J9\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00062\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0096\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/softMigration/impl/SoftMigrationBusinessLogic;", "Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$BusinessLogic;", "analyticsLogger", "Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$AnalyticsLogger;)V", "invoke", "Lkotlin/Triple;", "Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$State;", "Lru/yoomoney/sdk/march/Command;", "Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$Action;", "Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$Effect;", "state", "action", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SoftMigrationBusinessLogic implements SoftMigration.BusinessLogic {
    private final SoftMigration.AnalyticsLogger analyticsLogger;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Result<? extends MigrationResponse>, SoftMigration.Action> {
        public static final a a = new a();

        public a() {
            super(1, SoftMigrationBusinessLogicKt.class, "transformSoftMigration", "transformSoftMigration(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$Action;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final SoftMigration.Action invoke(Result<? extends MigrationResponse> result) {
            return SoftMigrationBusinessLogicKt.transformSoftMigration(result.getValue());
        }
    }

    public SoftMigrationBusinessLogic(SoftMigration.AnalyticsLogger analyticsLogger) {
        this.analyticsLogger = analyticsLogger;
    }

    @Override // ru.yoomoney.sdk.auth.api.migration.softMigration.SoftMigration.BusinessLogic, kotlin.jvm.functions.Function2
    public Triple<SoftMigration.State, Command<?, SoftMigration.Action>, SoftMigration.Effect> invoke(SoftMigration.State state, SoftMigration.Action action) {
        SoftMigration.State.Content content;
        Object showFailure;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        SoftMigration.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (!(state instanceof SoftMigration.State.Content)) {
            if (!(state instanceof SoftMigration.State.Progress)) {
                throw new NoWhenBranchMatchedException();
            }
            if (action instanceof SoftMigration.Action.SoftMigrationSuccess) {
                content = SoftMigration.State.Content.INSTANCE;
                showFailure = new SoftMigration.Effect.ShowNextStep(((SoftMigration.Action.SoftMigrationSuccess) action).getProcess());
            } else if (action instanceof SoftMigration.Action.SoftMigrationFailure) {
                content = SoftMigration.State.Content.INSTANCE;
                showFailure = new SoftMigration.Effect.ShowFailure(((SoftMigration.Action.SoftMigrationFailure) action).getFailure());
            }
            return TripleBuildersKt.with(content, showFailure);
        }
        if (action instanceof SoftMigration.Action.StartMigration) {
            return TripleBuildersKt.with(SoftMigration.State.Progress.INSTANCE, (Command) new SoftMigrationCommand(a.a));
        }
        return TripleBuildersKt.just(state);
    }
}
