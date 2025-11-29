package ru.yoomoney.sdk.auth.socialAccounts.vkId.impl;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import ru.yoomoney.sdk.auth.OauthParams;
import ru.yoomoney.sdk.auth.api.crypt.oauth.OauthKeyProviderImpl;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.VkId;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.repository.VkIdRepositoryImpl;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/impl/VkIdViewModelFactoryImpl;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "oauthParams", "Lru/yoomoney/sdk/auth/OauthParams;", "(Landroid/app/Application;Lru/yoomoney/sdk/auth/OauthParams;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VkIdViewModelFactoryImpl implements ViewModelProvider.Factory {
    public static final String FEATURE = "VkId";
    private final Application application;
    private final OauthParams oauthParams;

    public static final class a extends Lambda implements Function1<RuntimeViewModelDependencies<VkId.State, VkId.Action, VkId.Effect>, Out<? extends VkId.State, ? extends VkId.Action>> {
        public final /* synthetic */ VkIdInteractor a;
        public final /* synthetic */ VkIdViewModelFactoryImpl b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VkIdInteractorImpl vkIdInteractorImpl, VkIdViewModelFactoryImpl vkIdViewModelFactoryImpl) {
            super(1);
            this.a = vkIdInteractorImpl;
            this.b = vkIdViewModelFactoryImpl;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Out<? extends VkId.State, ? extends VkId.Action> invoke(RuntimeViewModelDependencies<VkId.State, VkId.Action, VkId.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<VkId.State, VkId.Action, VkId.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return Out.INSTANCE.invoke(VkId.State.Progress.INSTANCE, new h(RuntimeViewModel, this.a, this.b));
        }
    }

    public static final class b extends Lambda implements Function1<RuntimeViewModelDependencies<VkId.State, VkId.Action, VkId.Effect>, Function2<? super VkId.State, ? super VkId.Action, ? extends Out<? extends VkId.State, ? extends VkId.Action>>> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Function2<? super VkId.State, ? super VkId.Action, ? extends Out<? extends VkId.State, ? extends VkId.Action>> invoke(RuntimeViewModelDependencies<VkId.State, VkId.Action, VkId.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<VkId.State, VkId.Action, VkId.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return new VkIdBusinessLogic(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource());
        }
    }

    public VkIdViewModelFactoryImpl(Application application, OauthParams oauthParams) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.oauthParams = oauthParams;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default(FEATURE, new a(new VkIdInteractorImpl(new VkIdRepositoryImpl(new OauthKeyProviderImpl(), this.oauthParams)), this), b.a, null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.auth.socialAccounts.vkId.impl.VkIdViewModelFactoryImpl.create");
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
