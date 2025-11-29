package ru.yoomoney.sdk.two_fa.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewModelKeyedFactoryModule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/two_fa/di/ViewModelKeyedFactoryModule;", "", "<init>", "()V", "", "", "Ljavax/inject/Provider;", "Landroidx/lifecycle/ViewModel;", "creators", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelKeyedFactory", "(Ljava/util/Map;)Landroidx/lifecycle/ViewModelProvider$Factory;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewModelKeyedFactoryModule {
    public static final int $stable = 0;

    public final ViewModelProvider.Factory viewModelKeyedFactory(Map<String, Provider<ViewModel>> creators) {
        Intrinsics.checkNotNullParameter(creators, "creators");
        return new ViewModelKeyedFactory(creators);
    }
}
