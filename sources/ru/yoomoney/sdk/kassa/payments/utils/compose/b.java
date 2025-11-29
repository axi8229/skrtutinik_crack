package ru.yoomoney.sdk.kassa.payments.utils.compose;

import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1 {
    public final /* synthetic */ State a;
    public final /* synthetic */ State b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(State state, State state2) {
        super(1);
        this.a = state;
        this.b = state2;
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final a invoke(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        Lifecycle lifecycle = ((LifecycleOwner) this.a.getValue()).getLifecycle();
        final State state = this.b;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: ru.yoomoney.sdk.kassa.payments.utils.compose.b$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                b.a(state, lifecycleOwner, event);
            }
        };
        lifecycle.addObserver(lifecycleEventObserver);
        return new a(lifecycle, lifecycleEventObserver);
    }

    public static final void a(State eventHandler, LifecycleOwner owner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(eventHandler, "$eventHandler");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(event, "event");
        ((Function2) eventHandler.getValue()).invoke(owner, event);
    }
}
