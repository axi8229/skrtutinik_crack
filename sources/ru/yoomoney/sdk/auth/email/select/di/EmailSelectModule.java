package ru.yoomoney.sdk.auth.email.select.di;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.select.EmailSelectFragment;
import ru.yoomoney.sdk.auth.email.select.impl.EmailSelectAnalyticsLogger;
import ru.yoomoney.sdk.auth.email.select.impl.EmailSelectInteractor;
import ru.yoomoney.sdk.auth.email.select.impl.EmailSelectInteractorImpl;
import ru.yoomoney.sdk.auth.email.select.impl.EmailSelectViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J:\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/di/EmailSelectModule;", "", "()V", "provideEmailSelectInteractor", "Lru/yoomoney/sdk/auth/email/select/impl/EmailSelectInteractor;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "provideEnterEmailFragment", "Landroidx/fragment/app/Fragment;", "interactor", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailSelectModule {
    public final EmailSelectInteractor provideEmailSelectInteractor(MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new EmailSelectInteractorImpl(migrationRepository, serverTimeRepository);
    }

    public final Fragment provideEnterEmailFragment(EmailSelectInteractor interactor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        return new EmailSelectFragment(new EmailSelectViewModelFactory(interactor, analyticsLogger != null ? new EmailSelectAnalyticsLogger(analyticsLogger) : null), resultData, router, processMapper, resourceMapper);
    }
}
