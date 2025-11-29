package com.sputnik.common.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiViewModelFactory.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012 \u0010\u0006\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fR.\u0010\u0006\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "", "Ljava/lang/Class;", "Landroidx/lifecycle/ViewModel;", "Ljavax/inject/Provider;", "viewModelFactories", "<init>", "(Ljava/util/Map;)V", "T", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Ljava/util/Map;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MultiViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelFactories;

    public MultiViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelFactories) {
        Intrinsics.checkNotNullParameter(viewModelFactories, "viewModelFactories");
        this.viewModelFactories = viewModelFactories;
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Object obj = ((Provider) MapsKt.getValue(this.viewModelFactories, modelClass)).get();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.sputnik.common.viewmodels.MultiViewModelFactory.create");
        return (T) obj;
    }
}
