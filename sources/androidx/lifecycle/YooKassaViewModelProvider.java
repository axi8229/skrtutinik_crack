package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\rH\u0096\u0002¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/YooKassaViewModelProvider;", "Landroidx/lifecycle/ViewModelProvider;", "store", "Landroidx/lifecycle/ViewModelStore;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "get", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class YooKassaViewModelProvider extends ViewModelProvider {
    public static final int $stable = 8;
    private final ViewModelProvider.Factory factory;
    private final ViewModelStore store;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YooKassaViewModelProvider(ViewModelStore store, ViewModelProvider.Factory factory) {
        super(store, factory, null, 4, null);
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.store = store;
        this.factory = factory;
    }

    @Override // androidx.lifecycle.ViewModelProvider
    public <T extends ViewModel> T get(String key, Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        T t = (T) this.store.get(key);
        if (modelClass.isInstance(t) && t != null) {
            Object obj = this.factory;
            ViewModelProvider.OnRequeryFactory onRequeryFactory = obj instanceof ViewModelProvider.OnRequeryFactory ? (ViewModelProvider.OnRequeryFactory) obj : null;
            if (onRequeryFactory != null) {
                onRequeryFactory.onRequery(t);
            }
            return t;
        }
        if (t != null) {
            Log.d(Reflection.getOrCreateKotlinClass(YooKassaViewModelProvider.class).toString(), "ViewModel already exists: " + t + ", but does not conform class: " + modelClass);
        }
        ViewModelProvider.Factory factory = this.factory;
        T t2 = factory instanceof YooKassaKeyedFactory ? (T) ((YooKassaKeyedFactory) factory).create(key, modelClass) : (T) factory.create(modelClass);
        this.store.put(key, t2);
        Intrinsics.checkNotNull(t2);
        return t2;
    }
}
