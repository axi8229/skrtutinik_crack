package ru.yoomoney.sdk.auth.api.migration.softMigration.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ConfigKt;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.migration.softMigration.SoftMigration;
import ru.yoomoney.sdk.auth.api.migration.softMigration.SoftMigrationFragment;
import ru.yoomoney.sdk.auth.api.migration.softMigration.commands.SoftMigrationCommandExecutor;
import ru.yoomoney.sdk.auth.api.migration.softMigration.impl.SoftMigrationAnalyticsLogger;
import ru.yoomoney.sdk.auth.api.migration.softMigration.impl.SoftMigrationBusinessLogic;
import ru.yoomoney.sdk.auth.api.migration.softMigration.impl.SoftMigrationCommandProcessor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Command;
import ru.yoomoney.sdk.march.TripleBuildersKt;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J^\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/softMigration/di/SoftMigrationModule;", "", "()V", "provideSoftMigrationFragment", "Landroidx/fragment/app/Fragment;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "lazyRemoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SoftMigrationModule {

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function2<Command<?, ? extends SoftMigration.Action>, Continuation<? super SoftMigration.Action>, Object> {
        public a(SoftMigrationCommandProcessor softMigrationCommandProcessor) {
            super(2, softMigrationCommandProcessor, SoftMigrationCommandProcessor.class, "invoke", "invoke(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Command<?, ? extends SoftMigration.Action> command, Continuation<? super SoftMigration.Action> continuation) {
            return ((SoftMigrationCommandProcessor) this.receiver).invoke(command, continuation);
        }
    }

    public final Fragment provideSoftMigrationFragment(Lazy<Config> lazyConfig, MigrationRepository migrationRepository, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<RemoteConfig> lazyRemoteConfig, YooProfiler profiler, ResultData resultData, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(lazyRemoteConfig, "lazyRemoteConfig");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        return new SoftMigrationFragment(lazyRemoteConfig.getValue(), CodeKt.RuntimeViewModelFactory("SoftMigration", TripleBuildersKt.just(SoftMigration.State.Content.INSTANCE), new SoftMigrationBusinessLogic(analyticsLogger != null ? new SoftMigrationAnalyticsLogger(analyticsLogger) : null), new a(new SoftMigrationCommandProcessor(new SoftMigrationCommandExecutor(ConfigKt.toApiOrigin(lazyConfig.getValue().getOrigin()), migrationRepository, profiler, resultData)))), router, processMapper, resourceMapper);
    }
}
