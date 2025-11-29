package ru.yoomoney.sdk.kassa.payments.ui;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0014H\u0002¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/BottomSheetFragmentTransition;", "Landroid/transition/Transition;", "()V", "captureEndValues", "", "transitionValues", "Landroid/transition/TransitionValues;", "captureStartValues", "createAnimator", "Landroid/animation/Animator;", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "endValues", "getTransitionProperties", "", "", "()[Ljava/lang/String;", "prepareFadeInAnimator", "view", "Landroid/view/View;", "prepareHeightAnimator", "Landroid/animation/ValueAnimator;", "startHeight", "", "endHeight", "container", "Companion", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetFragmentTransition extends Transition {
    public static final int $stable = 0;
    private static final String END = "BottomSheetFragmentTransition:end";
    private static final String HEIGHT = "BottomSheetFragmentTransition:height";
    private static final String START = "BottomSheetFragmentTransition:start";
    private static final String STATE = "BottomSheetFragmentTransition:state";

    private final Animator prepareFadeInAnimator(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        return objectAnimatorOfFloat;
    }

    private final ValueAnimator prepareHeightAnimator(int startHeight, int endHeight, final View container) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(startHeight, endHeight);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.BottomSheetFragmentTransition$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BottomSheetFragmentTransition.prepareHeightAnimator$lambda$6$lambda$3(container, valueAnimator);
            }
        });
        Intrinsics.checkNotNull(valueAnimatorOfInt);
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.BottomSheetFragmentTransition$prepareHeightAnimator$lambda$6$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View view = container;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams.height = -2;
                view.setLayoutParams(layoutParams);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfInt, "apply(...)");
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareHeightAnimator$lambda$6$lambda$3(View container, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(container, "$container");
        Intrinsics.checkNotNullParameter(animation, "animation");
        ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        container.setLayoutParams(layoutParams);
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        Object parent = transitionValues.view.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            return;
        }
        Map values = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(values, "values");
        values.put(HEIGHT, Integer.valueOf(ViewExtensionsKt.getViewHeight(view)));
        Map values2 = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(values2, "values");
        values2.put(STATE, END);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        Object parent = transitionValues.view.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            return;
        }
        Map values = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(values, "values");
        values.put(HEIGHT, Integer.valueOf(transitionValues.view.getHeight()));
        Map values2 = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(values2, "values");
        values2.put(STATE, START);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = view.getHeight();
        view.setLayoutParams(layoutParams);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        if (startValues == null || endValues == null) {
            return null;
        }
        Object parent = endValues.view.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            return null;
        }
        Object obj = startValues.values.get(HEIGHT);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        Object obj2 = endValues.values.get(HEIGHT);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        ValueAnimator valueAnimatorPrepareHeightAnimator = prepareHeightAnimator(iIntValue, ((Integer) obj2).intValue(), view);
        View view2 = endValues.view;
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        List listListOf = CollectionsKt.listOf((Object[]) new Animator[]{valueAnimatorPrepareHeightAnimator, prepareFadeInAnimator(view2)});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.setDuration(sceneRoot.getResources().getInteger(R.integer.config_mediumAnimTime));
        animatorSet.playTogether(listListOf);
        return animatorSet;
    }

    @Override // android.transition.Transition
    public String[] getTransitionProperties() {
        return new String[]{HEIGHT, STATE};
    }
}
