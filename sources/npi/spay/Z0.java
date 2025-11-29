package npi.spay;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;

/* loaded from: classes4.dex */
public final class Z0 extends Transition {
    public static final String[] b = {"heightTransition:height", "heightTransition:viewType"};
    public final long a;

    public Z0(long j) {
        this.a = j;
    }

    public final ValueAnimator a(int i, int i2, View view) {
        ValueAnimator prepareHeightAnimator$lambda$10 = ValueAnimator.ofInt(i, i2);
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view2 = (View) parent;
        prepareHeightAnimator$lambda$10.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: npi.spay.Z0$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Z0.a(view2, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(prepareHeightAnimator$lambda$10, "prepareHeightAnimator$lambda$10");
        prepareHeightAnimator$lambda$10.addListener(new Y0(view2));
        prepareHeightAnimator$lambda$10.setStartDelay(this.a / 3);
        prepareHeightAnimator$lambda$10.setDuration(this.a / 2);
        prepareHeightAnimator$lambda$10.setInterpolator(new AccelerateInterpolator());
        return prepareHeightAnimator$lambda$10;
    }

    @Override // android.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        Map map = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map, "transitionValues.values");
        Object parent = transitionValues.view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        View view = (View) parent;
        Point point = new Point();
        Object systemService = view.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getSize(point);
        int dimensionPixelSize = 0;
        view.measure(View.MeasureSpec.makeMeasureSpec(point.x, pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = view.getMeasuredHeight();
        Point point2 = new Point();
        Object systemService2 = view.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService2).getDefaultDisplay().getSize(point2);
        int i = point2.y;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        Integer numValueOf = Integer.valueOf(identifier);
        if (identifier <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(numValueOf.intValue());
        }
        map.put("heightTransition:height", Integer.valueOf(RangesKt.coerceAtMost(measuredHeight, i - dimensionPixelSize)));
        Map map2 = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map2, "transitionValues.values");
        map2.put("heightTransition:viewType", "end");
    }

    @Override // android.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        Map map = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map, "transitionValues.values");
        map.put("heightTransition:height", Integer.valueOf(transitionValues.view.getHeight()));
        Map map2 = transitionValues.values;
        Intrinsics.checkNotNullExpressionValue(map2, "transitionValues.values");
        map2.put("heightTransition:viewType", "start");
        Object parent = transitionValues.view.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = view.getHeight();
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // android.transition.Transition
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        View view = transitionValues2.view;
        Intrinsics.checkNotNullExpressionValue(view, "endValues.view");
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(this.a);
        objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(view, View.ALPHA…eInterpolator()\n        }");
        Object obj = transitionValues.values.get("heightTransition:height");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        Object obj2 = transitionValues2.values.get("heightTransition:height");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue2 = ((Integer) obj2).intValue();
        View view2 = transitionValues2.view;
        Intrinsics.checkNotNullExpressionValue(view2, "endValues.view");
        ValueAnimator valueAnimatorA = a(iIntValue, iIntValue2, view2);
        Intrinsics.checkNotNullExpressionValue(valueAnimatorA, "prepareHeightAnimator(\n …Values.view\n            )");
        List listListOf = CollectionsKt.listOf((Object[]) new Animator[]{objectAnimatorOfFloat, valueAnimatorA});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(listListOf);
        return animatorSet;
    }

    @Override // android.transition.Transition
    public final String[] getTransitionProperties() {
        return b;
    }

    public static final void a(View container, ValueAnimator animation) {
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
}
