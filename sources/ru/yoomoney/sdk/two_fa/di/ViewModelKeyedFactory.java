package ru.yoomoney.sdk.two_fa.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ViewModelKeyedFactory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\t*\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/di/ViewModelKeyedFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "", "", "Ljavax/inject/Provider;", "Landroidx/lifecycle/ViewModel;", "creators", "<init>", "(Ljava/util/Map;)V", "T", "Ljava/lang/Class;", "modelClass", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extras", "create", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Ljava/util/Map;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewModelKeyedFactory implements ViewModelProvider.Factory {
    public static final int $stable = 8;
    private final Map<String, Provider<ViewModel>> creators;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(Class cls) {
        return super.create(cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return super.create(kClass, creationExtras);
    }

    public ViewModelKeyedFactory(Map<String, Provider<ViewModel>> creators) {
        Intrinsics.checkNotNullParameter(creators, "creators");
        this.creators = creators;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Provider<ViewModel> provider = this.creators.get(extras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY));
        if (provider == null) {
            throw new IllegalStateException(("unknown model class " + modelClass).toString());
        }
        ViewModel viewModel = provider.get();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type T of ru.yoomoney.sdk.two_fa.di.ViewModelKeyedFactory.create");
        return (T) viewModel;
    }
}
