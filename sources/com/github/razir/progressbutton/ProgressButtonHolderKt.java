package com.github.razir.progressbutton;

import android.animation.Animator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressButtonHolder.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004*\u0002\u0018\u001b\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0001H\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\u0003*\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\u0003*\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u0007\"&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\",\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/LifecycleOwner;", "Landroid/widget/TextView;", "button", "", "bindProgressButton", "(Landroidx/lifecycle/LifecycleOwner;Landroid/widget/TextView;)V", "cleanUpDrawable", "(Landroid/widget/TextView;)V", "removeTextAnimationAttachViewListener", "addDrawableAttachViewListener", "removeDrawableAttachViewListener", "Ljava/util/WeakHashMap;", "Lcom/github/razir/progressbutton/TextChangeAnimatorParams;", "attachedViews", "Ljava/util/WeakHashMap;", "getAttachedViews", "()Ljava/util/WeakHashMap;", "", "Landroid/animation/Animator;", "activeAnimations", "getActiveAnimations", "Lcom/github/razir/progressbutton/DrawableViewData;", "activeViews", "getActiveViews", "com/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1", "textAnimationsAttachListener", "Lcom/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1;", "com/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1", "drawablesAttachListener", "Lcom/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1;", "progressbutton_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class ProgressButtonHolderKt {
    private static final WeakHashMap<TextView, TextChangeAnimatorParams> attachedViews = new WeakHashMap<>();
    private static final WeakHashMap<TextView, List<Animator>> activeAnimations = new WeakHashMap<>();
    private static final WeakHashMap<TextView, DrawableViewData> activeViews = new WeakHashMap<>();
    private static final ProgressButtonHolderKt$textAnimationsAttachListener$1 textAnimationsAttachListener = new View.OnAttachStateChangeListener() { // from class: com.github.razir.progressbutton.ProgressButtonHolderKt$textAnimationsAttachListener$1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Intrinsics.checkParameterIsNotNull(v, "v");
            WeakHashMap<TextView, TextChangeAnimatorParams> attachedViews2 = ProgressButtonHolderKt.getAttachedViews();
            if (attachedViews2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
            if (attachedViews2.containsKey(v)) {
                ButtonTextAnimatorExtensionsKt.cancelAnimations((TextView) v);
            }
        }
    };
    private static final ProgressButtonHolderKt$drawablesAttachListener$1 drawablesAttachListener = new View.OnAttachStateChangeListener() { // from class: com.github.razir.progressbutton.ProgressButtonHolderKt$drawablesAttachListener$1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            DrawableViewData drawableViewData;
            Object drawable;
            WeakHashMap<TextView, DrawableViewData> activeViews2 = ProgressButtonHolderKt.getActiveViews();
            if (activeViews2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
            if (!activeViews2.containsKey(v) || (drawableViewData = ProgressButtonHolderKt.getActiveViews().get(v)) == null || (drawable = drawableViewData.getDrawable()) == null || !(drawable instanceof Animatable)) {
                return;
            }
            ((Animatable) drawable).stop();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            DrawableViewData drawableViewData;
            Object drawable;
            WeakHashMap<TextView, DrawableViewData> activeViews2 = ProgressButtonHolderKt.getActiveViews();
            if (activeViews2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
            if (!activeViews2.containsKey(v) || (drawableViewData = ProgressButtonHolderKt.getActiveViews().get(v)) == null || (drawable = drawableViewData.getDrawable()) == null || !(drawable instanceof Animatable)) {
                return;
            }
            ((Animatable) drawable).start();
        }
    };

    public static final WeakHashMap<TextView, TextChangeAnimatorParams> getAttachedViews() {
        return attachedViews;
    }

    public static final WeakHashMap<TextView, List<Animator>> getActiveAnimations() {
        return activeAnimations;
    }

    public static final WeakHashMap<TextView, DrawableViewData> getActiveViews() {
        return activeViews;
    }

    public static final void bindProgressButton(LifecycleOwner bindProgressButton, TextView button) {
        Intrinsics.checkParameterIsNotNull(bindProgressButton, "$this$bindProgressButton");
        Intrinsics.checkParameterIsNotNull(button, "button");
        bindProgressButton.getLifecycle().addObserver(new ProgressButtonHolder(new WeakReference(button)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void cleanUpDrawable(TextView cleanUpDrawable) {
        Drawable drawable;
        Intrinsics.checkParameterIsNotNull(cleanUpDrawable, "$this$cleanUpDrawable");
        WeakHashMap<TextView, DrawableViewData> weakHashMap = activeViews;
        if (weakHashMap.containsKey(cleanUpDrawable)) {
            DrawableViewData drawableViewData = weakHashMap.get(cleanUpDrawable);
            if (drawableViewData != null && (drawable = drawableViewData.getDrawable()) != 0) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                drawable.setCallback(null);
            }
            weakHashMap.remove(cleanUpDrawable);
        }
    }

    public static final void removeTextAnimationAttachViewListener(TextView removeTextAnimationAttachViewListener) {
        Intrinsics.checkParameterIsNotNull(removeTextAnimationAttachViewListener, "$this$removeTextAnimationAttachViewListener");
        removeTextAnimationAttachViewListener.removeOnAttachStateChangeListener(textAnimationsAttachListener);
    }

    public static final void addDrawableAttachViewListener(TextView addDrawableAttachViewListener) {
        Intrinsics.checkParameterIsNotNull(addDrawableAttachViewListener, "$this$addDrawableAttachViewListener");
        addDrawableAttachViewListener.addOnAttachStateChangeListener(drawablesAttachListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeDrawableAttachViewListener(TextView textView) {
        textView.removeOnAttachStateChangeListener(drawablesAttachListener);
    }
}
