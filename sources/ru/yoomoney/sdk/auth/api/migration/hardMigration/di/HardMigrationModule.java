package ru.yoomoney.sdk.auth.api.migration.hardMigration.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigration;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigrationFragment;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationEnrollmentCommandExecutor;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.commands.MigrationLoginCommandExecutor;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.impl.HardMigrationAnalyticsLogger;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.impl.HardMigrationBusinessLogic;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.impl.HardMigrationCommandProcessor;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Command;
import ru.yoomoney.sdk.march.TripleBuildersKt;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JX\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/hardMigration/di/HardMigrationModule;", "", "()V", "provideHardMigrationFragment", "Landroidx/fragment/app/Fragment;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "lazyRemoteConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/RemoteConfig;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HardMigrationModule {

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function2<Command<?, ? extends HardMigration.Action>, Continuation<? super HardMigration.Action>, Object> {
        public a(HardMigrationCommandProcessor hardMigrationCommandProcessor) {
            super(2, hardMigrationCommandProcessor, HardMigrationCommandProcessor.class, "invoke", "invoke(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Command<?, ? extends HardMigration.Action> command, Continuation<? super HardMigration.Action> continuation) {
            return ((HardMigrationCommandProcessor) this.receiver).invoke(command, continuation);
        }
    }

    public final Fragment provideHardMigrationFragment(MigrationRepository migrationRepository, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<RemoteConfig> lazyRemoteConfig, YooProfiler profiler, ResultData resultData, ServerTimeRepository serverTimeRepository, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(lazyRemoteConfig, "lazyRemoteConfig");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new HardMigrationFragment(CodeKt.RuntimeViewModelFactory("HardMigration", TripleBuildersKt.just(new HardMigration.State.Content(false, 1, null)), new HardMigrationBusinessLogic(serverTimeRepository, analyticsLogger != null ? new HardMigrationAnalyticsLogger(analyticsLogger) : null), new a(new HardMigrationCommandProcessor(new MigrationEnrollmentCommandExecutor(migrationRepository, profiler, resultData), new MigrationLoginCommandExecutor(migrationRepository, profiler, resultData)))), lazyRemoteConfig.getValue(), router, processMapper, resourceMapper);
    }
}
