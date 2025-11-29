package ru.yoomoney.sdk.two_fa.exception;

import androidx.compose.runtime.Composer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposeExtensions.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"viewModel", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelFactory", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Ljava/lang/String;Landroidx/lifecycle/ViewModelStoreOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposeExtensionsKt {
    public static final /* synthetic */ <T extends ViewModel> T viewModel(String key, ViewModelStoreOwner viewModelStoreOwner, Function0<? extends ViewModelProvider.Factory> viewModelFactory, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        composer.startReplaceableGroup(-276432130);
        if ((i2 & 2) != 0 && (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable)) == null) {
            throw new IllegalStateException("CompositionLocal LocalViewModelStoreOwner not present");
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStoreOwner.getViewModelStore(), viewModelFactory.invoke(), null, 4, null);
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) viewModelProvider.get(key, ViewModel.class);
        composer.endReplaceableGroup();
        return t;
    }
}
