package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.reflect.KClass;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
abstract class YooKassaKeyedFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }

    public /* bridge */ /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return super.create(cls, creationExtras);
    }

    public abstract <T extends ViewModel> T create(String str, Class<T> cls);

    public /* bridge */ /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return super.create(kClass, creationExtras);
    }
}
