package ru.yoomoney.sdk.kassa.payments.confirmation.sbp;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class r extends ViewModelProvider.NewInstanceFactory {
    public final ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.s a;
    public final String b;

    public r(ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.s sbpConfirmationUseCase, String confirmationData) {
        Intrinsics.checkNotNullParameter(sbpConfirmationUseCase, "sbpConfirmationUseCase");
        Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
        this.a = sbpConfirmationUseCase;
        this.b = confirmationData;
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default("PaymentDetails", new p(this), new q(this), null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.kassa.payments.confirmation.sbp.SBPConfirmationVMFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }
}
