package ru.yoomoney.sdk.auth.yandexAcquire.webView.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebView;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebViewFragment;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.commands.SetYandexTokenCommandExecutor;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.impl.YandexAcquireWebViewAnalyticsLogger;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.impl.YandexAcquireWebViewBusinessLogic;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.impl.YandexAcquireWebViewCommandProcessor;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Command;
import ru.yoomoney.sdk.march.TripleBuildersKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/di/YandexAcquireWebViewModule;", "", "()V", "provideYandexAcquireWebViewFragment", "Landroidx/fragment/app/Fragment;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireWebViewModule {

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function2<Command<?, ? extends YandexAcquireWebView.Action>, Continuation<? super YandexAcquireWebView.Action>, Object> {
        public a(YandexAcquireWebViewCommandProcessor yandexAcquireWebViewCommandProcessor) {
            super(2, yandexAcquireWebViewCommandProcessor, YandexAcquireWebViewCommandProcessor.class, "invoke", "invoke(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Command<?, ? extends YandexAcquireWebView.Action> command, Continuation<? super YandexAcquireWebView.Action> continuation) {
            return ((YandexAcquireWebViewCommandProcessor) this.receiver).invoke(command, continuation);
        }
    }

    public final Fragment provideYandexAcquireWebViewFragment(MigrationRepository migrationRepository, Router router, ProcessMapper processMapper, Lazy<Config> lazyConfig, ResourceMapper resourceMapper, ServerTimeRepository serverTimeRepository, AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        return new YandexAcquireWebViewFragment(CodeKt.RuntimeViewModelFactory("yandexAcquireWebView", TripleBuildersKt.just(new YandexAcquireWebView.State.Init(lazyConfig.getValue().getYandexClientId())), new YandexAcquireWebViewBusinessLogic(serverTimeRepository, analyticsLogger != null ? new YandexAcquireWebViewAnalyticsLogger(analyticsLogger) : null), new a(new YandexAcquireWebViewCommandProcessor(new SetYandexTokenCommandExecutor(migrationRepository)))), lazyConfig.getValue(), router, processMapper, resourceMapper);
    }
}
