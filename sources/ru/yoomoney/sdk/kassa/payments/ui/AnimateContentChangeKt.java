package ru.yoomoney.sdk.kassa.payments.ui;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¨\u0006\u000b"}, d2 = {"animateHeightChange", "Landroid/animation/ValueAnimator;", "Landroid/view/ViewGroup;", "changeView", "Lkotlin/Function0;", "", "getHeightValueAnimator", "Landroid/view/View;", "heightBefore", "", "heightAfter", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnimateContentChangeKt {
    public static final ValueAnimator animateHeightChange(ViewGroup viewGroup, Function0<Unit> changeView) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(changeView, "changeView");
        int viewHeight = ViewExtensionsKt.getViewHeight(viewGroup);
        changeView.invoke();
        return getHeightValueAnimator(viewGroup, viewHeight, ViewExtensionsKt.getViewHeight(viewGroup));
    }

    public static final ValueAnimator getHeightValueAnimator(final View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.AnimateContentChangeKt$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimateContentChangeKt.getHeightValueAnimator$lambda$6$lambda$1(view, valueAnimator);
            }
        });
        Intrinsics.checkNotNull(valueAnimatorOfInt);
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.AnimateContentChangeKt$getHeightValueAnimator$lambda$6$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View view2 = view;
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams.height = -2;
                view2.setLayoutParams(layoutParams);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.AnimateContentChangeKt$getHeightValueAnimator$lambda$6$$inlined$doOnCancel$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                View view2 = view;
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams.height = -2;
                view2.setLayoutParams(layoutParams);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        valueAnimatorOfInt.setDuration(view.getResources().getInteger(R.integer.config_mediumAnimTime));
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfInt, "apply(...)");
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHeightValueAnimator$lambda$6$lambda$1(View this_getHeightValueAnimator, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this_getHeightValueAnimator, "$this_getHeightValueAnimator");
        Intrinsics.checkNotNullParameter(animation, "animation");
        ViewGroup.LayoutParams layoutParams = this_getHeightValueAnimator.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        this_getHeightValueAnimator.setLayoutParams(layoutParams);
    }
}
