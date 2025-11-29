package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class X extends ViewModelProvider.NewInstanceFactory {
    public final I a;
    public final Q b;

    public X(I sberPayConfirmationInteractor, Q assistedParams) {
        Intrinsics.checkNotNullParameter(sberPayConfirmationInteractor, "sberPayConfirmationInteractor");
        Intrinsics.checkNotNullParameter(assistedParams, "assistedParams");
        this.a = sberPayConfirmationInteractor;
        this.b = assistedParams;
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default("SberPayConfirmationViewModel", new V(this), new W(this), null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.SberPayConfirmationVmFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }
}
