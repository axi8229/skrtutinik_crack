package ru.yoomoney.sdk.auth.passport.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.passport.PassportProfileFragment;
import ru.yoomoney.sdk.auth.passport.impl.PassportProfileAnalyticsLogger;
import ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor;
import ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl;
import ru.yoomoney.sdk.auth.passport.impl.PassportProfileViewModelFactory;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.EsiaUtilsKt;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J^\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007JV\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0012H\u0007¨\u0006)"}, d2 = {"Lru/yoomoney/sdk/auth/passport/di/PassportProfileModule;", "", "()V", "passportProfileInteractor", "Lru/yoomoney/sdk/auth/passport/impl/PassportProfileInteractor;", "accountRepository", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "emailChangeRepository", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "phoneChangeRepository", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;", "passwordChangeRepository", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "socialAccountRepository", "Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "clientAppParams", "Lru/yoomoney/sdk/auth/api/ClientAppParams;", "context", "Landroid/content/Context;", "provideProfileFragment", "Landroidx/fragment/app/Fragment;", "interactor", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "lazyRemoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PassportProfileModule {
    public final PassportProfileInteractor passportProfileInteractor(AccountRepository accountRepository, EmailChangeRepository emailChangeRepository, PhoneChangeRepository phoneChangeRepository, PasswordChangeRepository passwordChangeRepository, SocialAccountRepository socialAccountRepository, ServerTimeRepository serverTimeRepository, Lazy<Config> lazyConfig, YooProfiler profiler, ClientAppParams clientAppParams, Context context) {
        Intrinsics.checkNotNullParameter(accountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(emailChangeRepository, "emailChangeRepository");
        Intrinsics.checkNotNullParameter(phoneChangeRepository, "phoneChangeRepository");
        Intrinsics.checkNotNullParameter(passwordChangeRepository, "passwordChangeRepository");
        Intrinsics.checkNotNullParameter(socialAccountRepository, "socialAccountRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(clientAppParams, "clientAppParams");
        Intrinsics.checkNotNullParameter(context, "context");
        return new PassportProfileInteractorImpl(accountRepository, emailChangeRepository, phoneChangeRepository, passwordChangeRepository, socialAccountRepository, serverTimeRepository, lazyConfig.getValue(), profiler, clientAppParams, EsiaUtilsKt.getEsiaReturnUrl(context));
    }

    public final Fragment provideProfileFragment(PassportProfileInteractor interactor, ResultData resultData, Lazy<Config> lazyConfig, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, AnalyticsLogger analyticsLogger, Lazy<RemoteConfig> lazyRemoteConfig) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(lazyRemoteConfig, "lazyRemoteConfig");
        return new PassportProfileFragment(new PassportProfileViewModelFactory(resultData, interactor, analyticsLogger != null ? new PassportProfileAnalyticsLogger(analyticsLogger, resultData) : null), lazyConfig.getValue(), router, processMapper, resourceMapper, resultData, lazyRemoteConfig.getValue());
    }
}
