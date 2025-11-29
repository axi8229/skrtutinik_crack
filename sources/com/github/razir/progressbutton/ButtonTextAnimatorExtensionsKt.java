package com.github.razir.progressbutton;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ButtonTextAnimatorExtensions.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u0007\u0010\n\u001a\u001b\u0010\r\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u000f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\u0006*\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u00020\u0006*\u00020\u0000H\u0000¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroid/widget/TextView;", "", "isAnimatorAttached", "(Landroid/widget/TextView;)Z", "", "newText", "", "animateTextChange", "(Landroid/widget/TextView;Ljava/lang/String;)V", "Landroid/text/SpannableString;", "(Landroid/widget/TextView;Landroid/text/SpannableString;)V", "Landroid/animation/Animator;", "animator", "addAnimator", "(Landroid/widget/TextView;Landroid/animation/Animator;)V", "cleaAnimator", "resetColor", "(Landroid/widget/TextView;)V", "cancelAnimations", "", "getAnimateTextColor", "(Landroid/widget/TextView;)I", "progressbutton_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class ButtonTextAnimatorExtensionsKt {
    public static final boolean isAnimatorAttached(TextView isAnimatorAttached) {
        Intrinsics.checkParameterIsNotNull(isAnimatorAttached, "$this$isAnimatorAttached");
        return ProgressButtonHolderKt.getAttachedViews().containsKey(isAnimatorAttached);
    }

    public static final void animateTextChange(TextView animateTextChange, String str) {
        Intrinsics.checkParameterIsNotNull(animateTextChange, "$this$animateTextChange");
        animateTextChange(animateTextChange, str != null ? new SpannableString(str) : null);
    }

    public static final void animateTextChange(final TextView animateTextChange, final SpannableString spannableString) {
        Intrinsics.checkParameterIsNotNull(animateTextChange, "$this$animateTextChange");
        cancelAnimations(animateTextChange);
        TextChangeAnimatorParams textChangeAnimatorParams = ProgressButtonHolderKt.getAttachedViews().get(animateTextChange);
        if (textChangeAnimatorParams == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(textChangeAnimatorParams, "attachedViews[this]!!");
        final TextChangeAnimatorParams textChangeAnimatorParams2 = textChangeAnimatorParams;
        int animateTextColor = getAnimateTextColor(animateTextChange);
        final ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animateTextChange, "textColor", ColorUtils.setAlphaComponent(animateTextColor, 0), animateTextColor);
        objectAnimatorOfInt.setDuration(textChangeAnimatorParams2.getFadeInMills());
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        objectAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.github.razir.progressbutton.ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                ButtonTextAnimatorExtensionsKt.cleaAnimator(animateTextChange, animation);
                ButtonTextAnimatorExtensionsKt.resetColor(animateTextChange);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                ButtonTextAnimatorExtensionsKt.resetColor(animateTextChange);
                ButtonTextAnimatorExtensionsKt.cleaAnimator(animateTextChange, animation);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                ButtonTextAnimatorExtensionsKt.addAnimator(animateTextChange, animation);
            }
        });
        objectAnimatorOfInt.start();
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(animateTextChange, "textColor", animateTextColor, ColorUtils.setAlphaComponent(animateTextColor, 0));
        objectAnimatorOfInt2.setDuration(textChangeAnimatorParams2.getFadeOutMills());
        objectAnimatorOfInt2.setEvaluator(new ArgbEvaluator());
        objectAnimatorOfInt2.addListener(new Animator.AnimatorListener() { // from class: com.github.razir.progressbutton.ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                animateTextChange.setText(spannableString);
                objectAnimatorOfInt.start();
                ButtonTextAnimatorExtensionsKt.cleaAnimator(animateTextChange, animation);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                animateTextChange.setText(spannableString);
                ButtonTextAnimatorExtensionsKt.resetColor(animateTextChange);
                ButtonTextAnimatorExtensionsKt.cleaAnimator(animateTextChange, animation);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                ButtonTextAnimatorExtensionsKt.addAnimator(animateTextChange, animation);
            }
        });
        objectAnimatorOfInt2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addAnimator(TextView textView, Animator animator) {
        if (ProgressButtonHolderKt.getActiveAnimations().containsKey(textView)) {
            List<Animator> list = ProgressButtonHolderKt.getActiveAnimations().get(textView);
            if (list != null) {
                list.add(animator);
                return;
            }
            return;
        }
        ProgressButtonHolderKt.getActiveAnimations().put(textView, CollectionsKt.mutableListOf(animator));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cleaAnimator(TextView textView, Animator animator) {
        if (ProgressButtonHolderKt.getActiveAnimations().containsKey(textView)) {
            List<Animator> list = ProgressButtonHolderKt.getActiveAnimations().get(textView);
            if (list == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(list, "activeAnimations[this]!!");
            List<Animator> list2 = list;
            list2.remove(animator);
            if (list2.isEmpty()) {
                ProgressButtonHolderKt.getActiveAnimations().remove(textView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetColor(TextView textView) {
        if (isAnimatorAttached(textView)) {
            TextChangeAnimatorParams textChangeAnimatorParams = ProgressButtonHolderKt.getAttachedViews().get(textView);
            if (textChangeAnimatorParams == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(textChangeAnimatorParams, "attachedViews[this]!!");
            TextChangeAnimatorParams textChangeAnimatorParams2 = textChangeAnimatorParams;
            ColorStateList textColorList = textChangeAnimatorParams2.getTextColorList();
            if (textColorList != null) {
                textView.setTextColor(textColorList);
            } else {
                textView.setTextColor(textChangeAnimatorParams2.getTextColor());
            }
        }
    }

    public static final void cancelAnimations(TextView cancelAnimations) {
        Intrinsics.checkParameterIsNotNull(cancelAnimations, "$this$cancelAnimations");
        if (ProgressButtonHolderKt.getActiveAnimations().containsKey(cancelAnimations)) {
            List<Animator> list = ProgressButtonHolderKt.getActiveAnimations().get(cancelAnimations);
            if (list == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(list, "activeAnimations[this]!!");
            Iterator it = new ArrayList(list).iterator();
            while (it.hasNext()) {
                ((Animator) it.next()).cancel();
            }
            ProgressButtonHolderKt.getActiveAnimations().remove(cancelAnimations);
        }
    }

    private static final int getAnimateTextColor(TextView textView) {
        TextChangeAnimatorParams textChangeAnimatorParams = ProgressButtonHolderKt.getAttachedViews().get(textView);
        if (textChangeAnimatorParams == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(textChangeAnimatorParams, "attachedViews[this]!!");
        TextChangeAnimatorParams textChangeAnimatorParams2 = textChangeAnimatorParams;
        if (textChangeAnimatorParams2.getTextColorList() != null) {
            int[] drawableState = textView.getDrawableState();
            ColorStateList textColorList = textChangeAnimatorParams2.getTextColorList();
            if (textColorList == null) {
                Intrinsics.throwNpe();
            }
            return textColorList.getColorForState(drawableState, -16777216);
        }
        return textChangeAnimatorParams2.getTextColor();
    }
}
