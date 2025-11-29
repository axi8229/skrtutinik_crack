package ru.yoomoney.sdk.auth.acceptTerms.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.acceptTerms.AcceptTermsFragment;
import ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsAnalyticsLogger;
import ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsInteractor;
import ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsInteractorImpl;
import ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsViewModelFactory;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J@\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0007¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/acceptTerms/di/AcceptTermsModule;", "", "()V", "acceptTermsInteractor", "Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsInteractor;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "providesAcceptTermsFragment", "Landroidx/fragment/app/Fragment;", "interactor", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcceptTermsModule {
    public final AcceptTermsInteractor acceptTermsInteractor(EnrollmentRepository enrollmentRepository) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        return new AcceptTermsInteractorImpl(enrollmentRepository);
    }

    public final Fragment providesAcceptTermsFragment(AcceptTermsInteractor interactor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, AnalyticsLogger analyticsLogger, Lazy<Config> lazyConfig) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        return new AcceptTermsFragment(new AcceptTermsViewModelFactory(interactor, analyticsLogger != null ? new AcceptTermsAnalyticsLogger(analyticsLogger) : null), lazyConfig.getValue(), router, processMapper, resourceMapper);
    }
}
