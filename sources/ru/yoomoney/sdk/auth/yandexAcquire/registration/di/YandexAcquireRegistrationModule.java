package ru.yoomoney.sdk.auth.yandexAcquire.registration.di;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ConfigKt;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistration;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistrationFragment;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommandExecutor;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.impl.YandexAcquireRegistrationBusinessLogic;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.impl.YandexAcquireRegistrationCommandProcessor;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Command;
import ru.yoomoney.sdk.march.TripleBuildersKt;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/di/YandexAcquireRegistrationModule;", "", "()V", "provideYandexAcquireEnrollmentFragment", "Landroidx/fragment/app/Fragment;", "lazyConfig", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireRegistrationModule {

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function2<Command<?, ? extends YandexAcquireRegistration.Action>, Continuation<? super YandexAcquireRegistration.Action>, Object> {
        public a(YandexAcquireRegistrationCommandProcessor yandexAcquireRegistrationCommandProcessor) {
            super(2, yandexAcquireRegistrationCommandProcessor, YandexAcquireRegistrationCommandProcessor.class, "invoke", "invoke(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Command<?, ? extends YandexAcquireRegistration.Action> command, Continuation<? super YandexAcquireRegistration.Action> continuation) {
            return ((YandexAcquireRegistrationCommandProcessor) this.receiver).invoke(command, continuation);
        }
    }

    public final Fragment provideYandexAcquireEnrollmentFragment(Lazy<Config> lazyConfig, RegistrationV2Repository registrationV2Repository, YooProfiler profiler, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(lazyConfig, "lazyConfig");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        return new YandexAcquireRegistrationFragment(CodeKt.RuntimeViewModelFactory("yandexAcquireRegistration", TripleBuildersKt.just(YandexAcquireRegistration.State.Content.INSTANCE), new YandexAcquireRegistrationBusinessLogic(), new a(new YandexAcquireRegistrationCommandProcessor(new RegistrationCommandExecutor(ConfigKt.toApiOrigin(lazyConfig.getValue().getOrigin()), registrationV2Repository, profiler)))), lazyConfig.getValue(), router, processMapper, resourceMapper);
    }
}
