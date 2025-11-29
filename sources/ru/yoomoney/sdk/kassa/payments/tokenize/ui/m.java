package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class m extends Lambda implements Function0 {
    public final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar) {
        super(0);
        this.a = nVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ViewModelProvider.Factory factory = this.a.a;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }
}
