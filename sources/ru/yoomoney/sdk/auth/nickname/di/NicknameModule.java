package ru.yoomoney.sdk.auth.nickname.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.nickname.NicknameFragment;
import ru.yoomoney.sdk.auth.nickname.impl.NicknameAnalyticsLogger;
import ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractor;
import ru.yoomoney.sdk.auth.nickname.impl.NicknameInteractorImpl;
import ru.yoomoney.sdk.auth.nickname.impl.NicknameViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007JH\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/di/NicknameModule;", "", "()V", "nicknameInteractor", "Lru/yoomoney/sdk/auth/nickname/impl/NicknameInteractor;", "accountRepository", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "provideNicknameFragment", "Landroidx/fragment/app/Fragment;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NicknameModule {
    public final NicknameInteractor nicknameInteractor(AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(accountRepository, "accountRepository");
        return new NicknameInteractorImpl(accountRepository);
    }

    public final Fragment provideNicknameFragment(ResultData resultData, Lazy<Config> lazyConfig, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, NicknameInteractor nicknameInteractor, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(nicknameInteractor, "nicknameInteractor");
        return new NicknameFragment(resultData, new NicknameViewModelFactory(nicknameInteractor, analyticsLogger != null ? new NicknameAnalyticsLogger(analyticsLogger) : null), lazyConfig, router, processMapper, resourceMapper);
    }
}
