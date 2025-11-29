package npi.spay;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.Map;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ql implements ViewModelProvider.Factory {
    public final Map a;

    public Ql(Map viewModels) {
        Intrinsics.checkNotNullParameter(viewModels, "viewModels");
        this.a = viewModels;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Provider provider = (Provider) this.a.get(modelClass);
        ViewModel viewModel = provider != null ? (ViewModel) provider.get() : null;
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type T of spay.sdk.di.module.defaultPaymentModule.viewModel.ViewModelFactory.create");
        return viewModel;
    }
}
