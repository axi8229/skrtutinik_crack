package androidx.compose.animation.core;

import kotlin.Metadata;

/* compiled from: Easing.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u000b\"\u0017\u0010\u0001\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u0007\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\u0004\"\u0017\u0010\t\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Landroidx/compose/animation/core/Easing;", "FastOutSlowInEasing", "Landroidx/compose/animation/core/Easing;", "getFastOutSlowInEasing", "()Landroidx/compose/animation/core/Easing;", "LinearOutSlowInEasing", "getLinearOutSlowInEasing", "FastOutLinearInEasing", "getFastOutLinearInEasing", "LinearEasing", "getLinearEasing", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EasingKt {
    private static final Easing FastOutSlowInEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    private static final Easing LinearOutSlowInEasing = new CubicBezierEasing(0.0f, 0.0f, 0.2f, 1.0f);
    private static final Easing FastOutLinearInEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final Easing LinearEasing = new Easing() { // from class: androidx.compose.animation.core.EasingKt$$ExternalSyntheticLambda0
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f) {
            return EasingKt.LinearEasing$lambda$0(f);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearEasing$lambda$0(float f) {
        return f;
    }

    public static final Easing getFastOutSlowInEasing() {
        return FastOutSlowInEasing;
    }

    public static final Easing getLinearEasing() {
        return LinearEasing;
    }
}
