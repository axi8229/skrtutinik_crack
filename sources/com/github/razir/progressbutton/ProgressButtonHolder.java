package com.github.razir.progressbutton;

import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressButtonHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/github/razir/progressbutton/ProgressButtonHolder;", "Landroidx/lifecycle/LifecycleEventObserver;", "textView", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "(Ljava/lang/ref/WeakReference;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class ProgressButtonHolder implements LifecycleEventObserver {
    private final WeakReference<TextView> textView;

    public ProgressButtonHolder(WeakReference<TextView> textView) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        this.textView = textView;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        TextView it;
        Intrinsics.checkParameterIsNotNull(source, "source");
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event != Lifecycle.Event.ON_DESTROY || (it = this.textView.get()) == null) {
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(it, "it");
        ButtonTextAnimatorExtensionsKt.cancelAnimations(it);
        ProgressButtonHolderKt.cleanUpDrawable(it);
        ProgressButtonHolderKt.removeTextAnimationAttachViewListener(it);
        ProgressButtonHolderKt.removeDrawableAttachViewListener(it);
        ProgressButtonHolderKt.getAttachedViews().remove(it);
    }
}
