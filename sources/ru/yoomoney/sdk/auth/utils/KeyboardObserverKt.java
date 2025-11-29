package ru.yoomoney.sdk.auth.utils;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a-\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/view/ViewGroup;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function1;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addKeyboardListener", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;)V", "", "heightPercent", "D", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KeyboardObserverKt {
    private static final double heightPercent = 0.2d;

    public static final void addKeyboardListener(final ViewGroup viewGroup, final LifecycleOwner lifecycleOwner, final Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.yoomoney.sdk.auth.utils.KeyboardObserverKt$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                KeyboardObserverKt.addKeyboardListener$lambda$0(viewGroup, lifecycleOwner, listener);
            }
        };
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: ru.yoomoney.sdk.auth.utils.KeyboardObserverKt.addKeyboardListener.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ViewExtensions.removeOnGlobalLayoutListener(viewGroup, onGlobalLayoutListener);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addKeyboardListener$lambda$0(ViewGroup this_addKeyboardListener, LifecycleOwner lifecycleOwner, Function1 listener) {
        Intrinsics.checkNotNullParameter(this_addKeyboardListener, "$this_addKeyboardListener");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "$lifecycleOwner");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Rect rect = new Rect();
        this_addKeyboardListener.getWindowVisibleDisplayFrame(rect);
        int height = this_addKeyboardListener.getRootView().getHeight();
        int i = height - rect.bottom;
        if (lifecycleOwner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
            listener.invoke(Boolean.valueOf(((double) i) > ((double) height) * heightPercent));
        }
    }
}
