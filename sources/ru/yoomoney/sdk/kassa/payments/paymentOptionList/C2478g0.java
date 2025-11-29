package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.YooKassaViewModelProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.g0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2478g0 extends Lambda implements Function0 {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ Function0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2478g0(Fragment fragment, C2484i0 c2484i0) {
        super(0);
        this.a = fragment;
        this.b = c2484i0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ViewModelStore viewModelStore = this.a.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "<get-viewModelStore>(...)");
        return new YooKassaViewModelProvider(viewModelStore, (ViewModelProvider.Factory) this.b.invoke()).get("PaymentOptionList", RuntimeViewModel.class);
    }
}
