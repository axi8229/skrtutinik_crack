package ru.yoomoney.sdk.auth.password.enter.impl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnter;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/password/enter/impl/PasswordEnterViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "interactor", "Lru/yoomoney/sdk/auth/password/enter/impl/BasePasswordEnterInteractor;", "analyticsLogger", "Lru/yoomoney/sdk/auth/password/enter/impl/PasswordEnterAnalyticsLogger;", "(Lru/yoomoney/sdk/auth/password/enter/impl/BasePasswordEnterInteractor;Lru/yoomoney/sdk/auth/password/enter/impl/PasswordEnterAnalyticsLogger;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordEnterViewModelFactory implements ViewModelProvider.Factory {
    private static final String FEATURE_PASSWORD_ENTER = "PasswordEnter";
    private final PasswordEnterAnalyticsLogger analyticsLogger;
    private final BasePasswordEnterInteractor interactor;

    public static final class a extends Lambda implements Function1<RuntimeViewModelDependencies<PasswordEnter.State, PasswordEnter.Action, PasswordEnter.Effect>, Out<? extends PasswordEnter.State, ? extends PasswordEnter.Action>> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Out<? extends PasswordEnter.State, ? extends PasswordEnter.Action> invoke(RuntimeViewModelDependencies<PasswordEnter.State, PasswordEnter.Action, PasswordEnter.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<PasswordEnter.State, PasswordEnter.Action, PasswordEnter.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return Out.INSTANCE.invoke(new PasswordEnter.State.Content(null, null, 3, null), new u(RuntimeViewModel));
        }
    }

    public static final class b extends Lambda implements Function1<RuntimeViewModelDependencies<PasswordEnter.State, PasswordEnter.Action, PasswordEnter.Effect>, Function2<? super PasswordEnter.State, ? super PasswordEnter.Action, ? extends Out<? extends PasswordEnter.State, ? extends PasswordEnter.Action>>> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Function2<? super PasswordEnter.State, ? super PasswordEnter.Action, ? extends Out<? extends PasswordEnter.State, ? extends PasswordEnter.Action>> invoke(RuntimeViewModelDependencies<PasswordEnter.State, PasswordEnter.Action, PasswordEnter.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<PasswordEnter.State, PasswordEnter.Action, PasswordEnter.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return new PasswordEnterBusinessLogic(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource(), PasswordEnterViewModelFactory.this.interactor, PasswordEnterViewModelFactory.this.analyticsLogger);
        }
    }

    public PasswordEnterViewModelFactory(BasePasswordEnterInteractor interactor, PasswordEnterAnalyticsLogger passwordEnterAnalyticsLogger) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.interactor = interactor;
        this.analyticsLogger = passwordEnterAnalyticsLogger;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default(FEATURE_PASSWORD_ENTER, a.a, new b(), null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.auth.password.enter.impl.PasswordEnterViewModelFactory.create");
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
