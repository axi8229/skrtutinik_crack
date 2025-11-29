package androidx.compose.animation.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: VectorizedAnimationSpec.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\f\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\f\u0010\r\u001a3\u0010\u0013\u001a\u00020\u0012\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "", "playTimeMillis", "start", "end", "startVelocity", "getValueFromMillis", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "playTime", "clampPlayTime", "(Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;J)J", "visibilityThreshold", "", "dampingRatio", "stiffness", "Landroidx/compose/animation/core/Animations;", "createSpringAnimations", "(Landroidx/compose/animation/core/AnimationVector;FF)Landroidx/compose/animation/core/Animations;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorizedAnimationSpecKt {
    public static final <V extends AnimationVector> V getValueFromMillis(VectorizedAnimationSpec<V> vectorizedAnimationSpec, long j, V v, V v2, V v3) {
        return (V) vectorizedAnimationSpec.getValueFromNanos(j * 1000000, v, v2, v3);
    }

    public static final long clampPlayTime(VectorizedDurationBasedAnimationSpec<?> vectorizedDurationBasedAnimationSpec, long j) {
        return RangesKt.coerceIn(j - vectorizedDurationBasedAnimationSpec.getDelayMillis(), 0L, vectorizedDurationBasedAnimationSpec.getDurationMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <V extends AnimationVector> Animations createSpringAnimations(V v, float f, float f2) {
        if (v != null) {
            return new Animations(v, f, f2) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt.createSpringAnimations.1
                private final List<FloatSpringSpec> anims;

                /* JADX WARN: Incorrect types in method signature: (TV;FF)V */
                {
                    IntRange intRangeUntil = RangesKt.until(0, v.getSize());
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
                    Iterator<Integer> it = intRangeUntil.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new FloatSpringSpec(f, f2, v.get$animation_core_release(((IntIterator) it).nextInt())));
                    }
                    this.anims = arrayList;
                }

                @Override // androidx.compose.animation.core.Animations
                public FloatSpringSpec get(int index) {
                    return this.anims.get(index);
                }
            };
        }
        return new Animations(f, f2) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt.createSpringAnimations.2
            private final FloatSpringSpec anim;

            {
                this.anim = new FloatSpringSpec(f, f2, 0.0f, 4, null);
            }

            @Override // androidx.compose.animation.core.Animations
            public FloatSpringSpec get(int index) {
                return this.anim;
            }
        };
    }
}
