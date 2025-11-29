package ru.yoomoney.sdk.auth.waitConfirm.impl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.threeten.bp.Duration;
import ru.yoomoney.sdk.auth.waitConfirm.WaitConfirmation;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/waitConfirm/impl/WaitConfirmationViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "Lorg/threeten/bp/Duration;", "(Lorg/threeten/bp/Duration;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WaitConfirmationViewModelFactory implements ViewModelProvider.Factory {
    private static final String FEATURE_NAME = "WaitConfirmation";
    private final Duration duration;

    public static final class a extends Lambda implements Function1<RuntimeViewModelDependencies<WaitConfirmation.State, WaitConfirmation.Action, WaitConfirmation.Effect>, Out<? extends WaitConfirmation.State, ? extends WaitConfirmation.Action>> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Out<? extends WaitConfirmation.State, ? extends WaitConfirmation.Action> invoke(RuntimeViewModelDependencies<WaitConfirmation.State, WaitConfirmation.Action, WaitConfirmation.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<WaitConfirmation.State, WaitConfirmation.Action, WaitConfirmation.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return Out.INSTANCE.invoke(new WaitConfirmation.State.Content(WaitConfirmationViewModelFactory.this.duration), new c(RuntimeViewModel));
        }
    }

    public static final class b extends Lambda implements Function1<RuntimeViewModelDependencies<WaitConfirmation.State, WaitConfirmation.Action, WaitConfirmation.Effect>, Function2<? super WaitConfirmation.State, ? super WaitConfirmation.Action, ? extends Out<? extends WaitConfirmation.State, ? extends WaitConfirmation.Action>>> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Function2<? super WaitConfirmation.State, ? super WaitConfirmation.Action, ? extends Out<? extends WaitConfirmation.State, ? extends WaitConfirmation.Action>> invoke(RuntimeViewModelDependencies<WaitConfirmation.State, WaitConfirmation.Action, WaitConfirmation.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<WaitConfirmation.State, WaitConfirmation.Action, WaitConfirmation.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return new WaitConfirmationBusinessLogic(RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource());
        }
    }

    public WaitConfirmationViewModelFactory(Duration duration) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        this.duration = duration;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default(FEATURE_NAME, new a(), b.a, null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.auth.waitConfirm.impl.WaitConfirmationViewModelFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return super.create(cls, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return super.create(kClass, creationExtras);
    }
}
