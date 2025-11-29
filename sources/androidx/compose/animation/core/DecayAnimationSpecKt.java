package androidx.compose.animation.core;

import kotlin.Metadata;

/* compiled from: DecayAnimationSpec.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "generateDecayAnimationSpec", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)Landroidx/compose/animation/core/DecayAnimationSpec;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DecayAnimationSpecKt {
    public static final <T> DecayAnimationSpec<T> generateDecayAnimationSpec(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        return new DecayAnimationSpecImpl(floatDecayAnimationSpec);
    }
}
