package ru.yoomoney.sdk.auth.yandexAcquire.login.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ConfigKt;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLogin;
import ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLoginFragment;
import ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommandExecutor;
import ru.yoomoney.sdk.auth.yandexAcquire.login.impl.YandexAcquireLoginBusinessLogic;
import ru.yoomoney.sdk.auth.yandexAcquire.login.impl.YandexAcquireLoginCommandProcessor;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Command;
import ru.yoomoney.sdk.march.TripleBuildersKt;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/login/di/YandexAcquireLoginModule;", "", "()V", "provideYandexAcquireLoginFragment", "Landroidx/fragment/app/Fragment;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireLoginModule {

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function2<Command<?, ? extends YandexAcquireLogin.Action>, Continuation<? super YandexAcquireLogin.Action>, Object> {
        public a(YandexAcquireLoginCommandProcessor yandexAcquireLoginCommandProcessor) {
            super(2, yandexAcquireLoginCommandProcessor, YandexAcquireLoginCommandProcessor.class, "invoke", "invoke(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Command<?, ? extends YandexAcquireLogin.Action> command, Continuation<? super YandexAcquireLogin.Action> continuation) {
            return ((YandexAcquireLoginCommandProcessor) this.receiver).invoke(command, continuation);
        }
    }

    public final Fragment provideYandexAcquireLoginFragment(Lazy<Config> lazyConfig, LoginRepository loginRepository, YooProfiler profiler, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        return new YandexAcquireLoginFragment(CodeKt.RuntimeViewModelFactory("yandexAcquireLogin", TripleBuildersKt.just(YandexAcquireLogin.State.Content.INSTANCE), new YandexAcquireLoginBusinessLogic(), new a(new YandexAcquireLoginCommandProcessor(new LoginCommandExecutor(ConfigKt.toApiOrigin(lazyConfig.getValue().getOrigin()), loginRepository, profiler)))), router, processMapper, resourceMapper);
    }
}
