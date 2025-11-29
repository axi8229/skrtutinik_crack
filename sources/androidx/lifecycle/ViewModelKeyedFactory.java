package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/ViewModelKeyedFactory;", "Landroidx/lifecycle/YooKassaKeyedFactory;", "", "", "Ljavax/inject/Provider;", "Landroidx/lifecycle/ViewModel;", "creators", "<init>", "(Ljava/util/Map;)V", "T", "key", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Ljava/util/Map;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewModelKeyedFactory extends YooKassaKeyedFactory {
    public static final int $stable = 8;
    private final Map<String, Provider<ViewModel>> creators;

    public ViewModelKeyedFactory(Map<String, Provider<ViewModel>> creators) {
        Intrinsics.checkNotNullParameter(creators, "creators");
        this.creators = creators;
    }

    @Override // androidx.lifecycle.YooKassaKeyedFactory, androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return super.create(cls, creationExtras);
    }

    @Override // androidx.lifecycle.YooKassaKeyedFactory
    public <T extends ViewModel> T create(String key, Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Provider<ViewModel> provider = this.creators.get(key);
        if (provider != null) {
            ViewModel viewModel = provider.get();
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelKeyedFactory.create");
            return (T) viewModel;
        }
        throw new IllegalStateException(("unknown model class " + modelClass).toString());
    }

    @Override // androidx.lifecycle.YooKassaKeyedFactory, androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return super.create(kClass, creationExtras);
    }
}
