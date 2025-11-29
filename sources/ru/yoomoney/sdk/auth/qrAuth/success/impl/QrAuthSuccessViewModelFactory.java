package ru.yoomoney.sdk.auth.qrAuth.success.impl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import ru.yoomoney.sdk.auth.qrAuth.success.QrAuthSuccess;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/success/impl/QrAuthSuccessViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthSuccessViewModelFactory implements ViewModelProvider.Factory {
    private static final String FEATURE_NAME = "QrAuthSuccess";

    public static final class a extends Lambda implements Function1<RuntimeViewModelDependencies<QrAuthSuccess.State, QrAuthSuccess.Action, QrAuthSuccess.Effect>, Out<? extends QrAuthSuccess.State, ? extends QrAuthSuccess.Action>> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Out<? extends QrAuthSuccess.State, ? extends QrAuthSuccess.Action> invoke(RuntimeViewModelDependencies<QrAuthSuccess.State, QrAuthSuccess.Action, QrAuthSuccess.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<QrAuthSuccess.State, QrAuthSuccess.Action, QrAuthSuccess.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return Out.INSTANCE.invoke(QrAuthSuccess.State.Content.INSTANCE, new c(RuntimeViewModel));
        }
    }

    public static final class b extends Lambda implements Function1<RuntimeViewModelDependencies<QrAuthSuccess.State, QrAuthSuccess.Action, QrAuthSuccess.Effect>, Function2<? super QrAuthSuccess.State, ? super QrAuthSuccess.Action, ? extends Out<? extends QrAuthSuccess.State, ? extends QrAuthSuccess.Action>>> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Function2<? super QrAuthSuccess.State, ? super QrAuthSuccess.Action, ? extends Out<? extends QrAuthSuccess.State, ? extends QrAuthSuccess.Action>> invoke(RuntimeViewModelDependencies<QrAuthSuccess.State, QrAuthSuccess.Action, QrAuthSuccess.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<QrAuthSuccess.State, QrAuthSuccess.Action, QrAuthSuccess.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return new QrAuthSuccessBusinessLogic(RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource());
        }
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default(FEATURE_NAME, a.a, b.a, null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.auth.qrAuth.success.impl.QrAuthSuccessViewModelFactory.create");
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
