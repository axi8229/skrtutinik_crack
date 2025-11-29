package ru.yoomoney.sdk.kassa.payments.utils.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;

/* loaded from: classes5.dex */
public final class a implements DisposableEffectResult {
    public final /* synthetic */ Lifecycle a;
    public final /* synthetic */ LifecycleEventObserver b;

    public a(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        this.a = lifecycle;
        this.b = lifecycleEventObserver;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public final void dispose() {
        this.a.removeObserver(this.b);
    }
}
