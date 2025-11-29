package ru.yoomoney.sdk.auth.passport.impl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.passport.PassportProfile;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/passport/impl/PassportProfileViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "interactor", "Lru/yoomoney/sdk/auth/passport/impl/PassportProfileInteractor;", "analyticsLogger", "Lru/yoomoney/sdk/auth/passport/impl/PassportProfileAnalyticsLogger;", "(Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/passport/impl/PassportProfileInteractor;Lru/yoomoney/sdk/auth/passport/impl/PassportProfileAnalyticsLogger;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PassportProfileViewModelFactory implements ViewModelProvider.Factory {
    private static final String FEATURE_PASSPORT_PROFILE = "PassportProfile";
    private final PassportProfileAnalyticsLogger analyticsLogger;
    private final PassportProfileInteractor interactor;
    private final ResultData resultData;

    public static final class a extends Lambda implements Function1<RuntimeViewModelDependencies<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect>, Out<? extends PassportProfile.State, ? extends PassportProfile.Action>> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Out<? extends PassportProfile.State, ? extends PassportProfile.Action> invoke(RuntimeViewModelDependencies<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return Out.INSTANCE.invoke(PassportProfile.State.Init.INSTANCE, new k0(RuntimeViewModel));
        }
    }

    public static final class b extends Lambda implements Function1<RuntimeViewModelDependencies<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect>, Function2<? super PassportProfile.State, ? super PassportProfile.Action, ? extends Out<? extends PassportProfile.State, ? extends PassportProfile.Action>>> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Function2<? super PassportProfile.State, ? super PassportProfile.Action, ? extends Out<? extends PassportProfile.State, ? extends PassportProfile.Action>> invoke(RuntimeViewModelDependencies<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return new PassportProfileBusinessLogic(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource(), PassportProfileViewModelFactory.this.interactor, PassportProfileViewModelFactory.this.resultData, PassportProfileViewModelFactory.this.analyticsLogger);
        }
    }

    public PassportProfileViewModelFactory(ResultData resultData, PassportProfileInteractor interactor, PassportProfileAnalyticsLogger passportProfileAnalyticsLogger) {
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.resultData = resultData;
        this.interactor = interactor;
        this.analyticsLogger = passportProfileAnalyticsLogger;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default(FEATURE_PASSPORT_PROFILE, a.a, new b(), null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.auth.passport.impl.PassportProfileViewModelFactory.create");
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
