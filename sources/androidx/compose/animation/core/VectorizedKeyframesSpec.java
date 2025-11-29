package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorizedAnimationSpec.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BE\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\"J/\u0010%\u001a\u00028\u00002\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b%\u0010&J/\u0010'\u001a\u00028\u00002\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b'\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R \u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010)R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010\u000b\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b-\u0010,R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010.R\u001a\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000f\u0010*R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00106R\u0016\u00108\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00106R\u0016\u00109\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u00106R\u0016\u0010:\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u00104R\u0016\u0010;\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u00104R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010>\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "Landroidx/collection/IntList;", "timestamps", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "keyframes", "", "durationMillis", "delayMillis", "Landroidx/compose/animation/core/Easing;", "defaultEasing", "Landroidx/compose/animation/core/ArcMode;", "initialArcMode", "<init>", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IILandroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "initialValue", "targetValue", "initialVelocity", "", "init", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "timeMillis", "", "getEasedTime", "(I)F", "index", "", "asFraction", "getEasedTimeFromIndex", "(IIZ)F", "findEntryForTimeMillis", "(I)I", "", "playTimeNanos", "getValueFromNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "Landroidx/collection/IntList;", "Landroidx/collection/IntObjectMap;", "I", "getDurationMillis", "()I", "getDelayMillis", "Landroidx/compose/animation/core/Easing;", "", "modes", "[I", "", "times", "[F", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "lastInitialValue", "lastTargetValue", "posArray", "slopeArray", "Landroidx/compose/animation/core/ArcSpline;", "arcSpline", "Landroidx/compose/animation/core/ArcSpline;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    private ArcSpline arcSpline;
    private final Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final int initialArcMode;
    private final IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private V velocityVector;

    public /* synthetic */ VectorizedKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i, int i2, Easing easing, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(intList, intObjectMap, i, i2, easing, i3);
    }

    private VectorizedKeyframesSpec(IntList intList, IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> intObjectMap, int i, int i2, Easing easing, int i3) {
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i;
        this.delayMillis = i2;
        this.defaultEasing = easing;
        this.initialArcMode = i3;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    private final void init(V initialValue, V targetValue, V initialVelocity) {
        float[] fArr;
        float[] fArr2;
        boolean z = this.arcSpline != null;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(initialValue);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(initialVelocity);
            int i = this.timestamps.get_size();
            float[] fArr3 = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                fArr3[i2] = this.timestamps.get(i2) / 1000;
            }
            this.times = fArr3;
            int i3 = this.timestamps.get_size();
            int[] iArr = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(this.timestamps.get(i4));
                int arcMode = vectorizedKeyframeSpecElementInfo != null ? vectorizedKeyframeSpecElementInfo.getArcMode() : this.initialArcMode;
                if (!ArcMode.m122equalsimpl0(arcMode, ArcMode.INSTANCE.m125getArcLinear9TMq4())) {
                    z = true;
                }
                iArr[i4] = arcMode;
            }
            this.modes = iArr;
        }
        if (z) {
            float[] fArr4 = null;
            if (this.arcSpline != null) {
                V v = this.lastInitialValue;
                if (v == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastInitialValue");
                    v = null;
                }
                if (Intrinsics.areEqual(v, initialValue)) {
                    V v2 = this.lastTargetValue;
                    if (v2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lastTargetValue");
                        v2 = null;
                    }
                    if (Intrinsics.areEqual(v2, targetValue)) {
                        return;
                    }
                }
            }
            this.lastInitialValue = initialValue;
            this.lastTargetValue = targetValue;
            int size = (initialValue.getSize() % 2) + initialValue.getSize();
            this.posArray = new float[size];
            this.slopeArray = new float[size];
            int i5 = this.timestamps.get_size();
            float[][] fArr5 = new float[i5][];
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = this.timestamps.get(i6);
                if (i7 == 0) {
                    if (!this.keyframes.contains(i7)) {
                        fArr2 = new float[size];
                        for (int i8 = 0; i8 < size; i8++) {
                            fArr2[i8] = initialValue.get$animation_core_release(i8);
                        }
                    } else {
                        fArr = new float[size];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i7);
                        Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                        AnimationVector vectorValue = vectorizedKeyframeSpecElementInfo2.getVectorValue();
                        for (int i9 = 0; i9 < size; i9++) {
                            fArr[i9] = vectorValue.get$animation_core_release(i9);
                        }
                        fArr2 = fArr;
                    }
                } else {
                    if (i7 == getDurationMillis()) {
                        if (!this.keyframes.contains(i7)) {
                            fArr2 = new float[size];
                            for (int i10 = 0; i10 < size; i10++) {
                                fArr2[i10] = targetValue.get$animation_core_release(i10);
                            }
                        } else {
                            fArr = new float[size];
                            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i7);
                            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
                            AnimationVector vectorValue2 = vectorizedKeyframeSpecElementInfo3.getVectorValue();
                            for (int i11 = 0; i11 < size; i11++) {
                                fArr[i11] = vectorValue2.get$animation_core_release(i11);
                            }
                        }
                    } else {
                        fArr = new float[size];
                        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo4 = this.keyframes.get(i7);
                        Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo4);
                        AnimationVector vectorValue3 = vectorizedKeyframeSpecElementInfo4.getVectorValue();
                        for (int i12 = 0; i12 < size; i12++) {
                            fArr[i12] = vectorValue3.get$animation_core_release(i12);
                        }
                    }
                    fArr2 = fArr;
                }
                fArr5[i6] = fArr2;
            }
            int[] iArr2 = this.modes;
            if (iArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modes");
                iArr2 = null;
            }
            float[] fArr6 = this.times;
            if (fArr6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("times");
            } else {
                fArr4 = fArr6;
            }
            this.arcSpline = new ArcSpline(iArr2, fArr4, fArr5);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        int iClampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / 1000000);
        if (this.keyframes.contains(iClampPlayTime)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(iClampPlayTime);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo);
            return (V) vectorizedKeyframeSpecElementInfo.getVectorValue();
        }
        if (iClampPlayTime >= getDurationMillis()) {
            return targetValue;
        }
        if (iClampPlayTime <= 0) {
            return initialValue;
        }
        init(initialValue, targetValue, initialVelocity);
        int i = 0;
        if (this.arcSpline != null) {
            float easedTime = getEasedTime(iClampPlayTime);
            ArcSpline arcSpline = this.arcSpline;
            if (arcSpline == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
                arcSpline = null;
            }
            float[] fArr = this.posArray;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("posArray");
                fArr = null;
            }
            arcSpline.getPos(easedTime, fArr);
            float[] fArr2 = this.posArray;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("posArray");
                fArr2 = null;
            }
            int length = fArr2.length;
            while (i < length) {
                V v = this.valueVector;
                if (v == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                    v = null;
                }
                float[] fArr3 = this.posArray;
                if (fArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("posArray");
                    fArr3 = null;
                }
                v.set$animation_core_release(i, fArr3[i]);
                i++;
            }
            V v2 = this.valueVector;
            if (v2 != null) {
                return v2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
        int iFindEntryForTimeMillis = findEntryForTimeMillis(iClampPlayTime);
        float easedTimeFromIndex = getEasedTimeFromIndex(iFindEntryForTimeMillis, iClampPlayTime, true);
        int i2 = this.timestamps.get(iFindEntryForTimeMillis);
        if (this.keyframes.contains(i2)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i2);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
            initialValue = (V) vectorizedKeyframeSpecElementInfo2.getVectorValue();
        }
        int i3 = this.timestamps.get(iFindEntryForTimeMillis + 1);
        if (this.keyframes.contains(i3)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i3);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
            targetValue = (V) vectorizedKeyframeSpecElementInfo3.getVectorValue();
        }
        V v3 = this.valueVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v3 = null;
        }
        int size = v3.getSize();
        while (i < size) {
            V v4 = this.valueVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v4 = null;
            }
            v4.set$animation_core_release(i, VectorConvertersKt.lerp(initialValue.get$animation_core_release(i), targetValue.get$animation_core_release(i), easedTimeFromIndex));
            i++;
        }
        V v5 = this.valueVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        long jClampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / 1000000);
        if (jClampPlayTime < 0) {
            return initialVelocity;
        }
        init(initialValue, targetValue, initialVelocity);
        int i = 0;
        if (this.arcSpline != null) {
            float easedTime = getEasedTime((int) jClampPlayTime);
            ArcSpline arcSpline = this.arcSpline;
            if (arcSpline == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
                arcSpline = null;
            }
            float[] fArr = this.slopeArray;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                fArr = null;
            }
            arcSpline.getSlope(easedTime, fArr);
            float[] fArr2 = this.slopeArray;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                fArr2 = null;
            }
            int length = fArr2.length;
            while (i < length) {
                V v = this.velocityVector;
                if (v == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                    v = null;
                }
                float[] fArr3 = this.slopeArray;
                if (fArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                    fArr3 = null;
                }
                v.set$animation_core_release(i, fArr3[i]);
                i++;
            }
            V v2 = this.velocityVector;
            if (v2 != null) {
                return v2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime - 1, initialValue, targetValue, initialVelocity);
        AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime, initialValue, targetValue, initialVelocity);
        int size = valueFromMillis.getSize();
        while (i < size) {
            V v3 = this.velocityVector;
            if (v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v3 = null;
            }
            v3.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
            i++;
        }
        V v4 = this.velocityVector;
        if (v4 != null) {
            return v4;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    private final float getEasedTime(int timeMillis) {
        return getEasedTimeFromIndex(findEntryForTimeMillis(timeMillis), timeMillis, false);
    }

    private final float getEasedTimeFromIndex(int index, int timeMillis, boolean asFraction) {
        Easing easing;
        float f;
        IntList intList = this.timestamps;
        if (index >= intList._size - 1) {
            f = timeMillis;
        } else {
            int i = intList.get(index);
            int i2 = this.timestamps.get(index + 1);
            if (timeMillis == i) {
                f = i;
            } else {
                int i3 = i2 - i;
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(i);
                if (vectorizedKeyframeSpecElementInfo == null || (easing = vectorizedKeyframeSpecElementInfo.getEasing()) == null) {
                    easing = this.defaultEasing;
                }
                float f2 = i3;
                float fTransform = easing.transform((timeMillis - i) / f2);
                if (asFraction) {
                    return fTransform;
                }
                f = (f2 * fTransform) + i;
            }
        }
        return f / 1000;
    }

    private final int findEntryForTimeMillis(int timeMillis) {
        int iBinarySearch$default = IntListExtensionKt.binarySearch$default(this.timestamps, timeMillis, 0, 0, 6, null);
        return iBinarySearch$default < -1 ? -(iBinarySearch$default + 2) : iBinarySearch$default;
    }
}
