package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class w0 extends ViewModelProvider.NewInstanceFactory {
    public final ru.yoomoney.sdk.kassa.payments.metrics.F a;
    public final d0 b;
    public final q0 c;

    public w0(ru.yoomoney.sdk.kassa.payments.metrics.F reporter, d0 interactor, q0 bankListParams) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(bankListParams, "bankListParams");
        this.a = reporter;
        this.b = interactor;
        this.c = bankListParams;
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default("BankListViewModel", new u0(this), new v0(this), null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.BankListViewModelFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }
}
