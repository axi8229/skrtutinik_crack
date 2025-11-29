package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.YooKassaViewModelProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class l extends Lambda implements Function0 {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ Function0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Fragment fragment, m mVar) {
        super(0);
        this.a = fragment;
        this.b = mVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ViewModelStore viewModelStore = this.a.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "<get-viewModelStore>(...)");
        return new YooKassaViewModelProvider(viewModelStore, (ViewModelProvider.Factory) this.b.invoke()).get("TOKENIZE", RuntimeViewModel.class);
    }
}
