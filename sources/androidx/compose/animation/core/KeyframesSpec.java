package androidx.compose.animation.core;

import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationSpec.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002\u0011\u0012B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\"\b\b\u0001\u0010\b*\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "config", "<init>", "(Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;)V", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/TwoWayConverter;", "converter", "Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "vectorize", "(Landroidx/compose/animation/core/TwoWayConverter;)Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "getConfig", "()Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "KeyframeEntity", "KeyframesSpecConfig", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyframesSpec<T> implements DurationBasedAnimationSpec<T> {
    private final KeyframesSpecConfig<T> config;

    public KeyframesSpec(KeyframesSpecConfig<T> keyframesSpecConfig) {
        this.config = keyframesSpecConfig;
    }

    /* compiled from: AnimationSpec.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003*\u00028\u00012\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0096\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "T", "Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "<init>", "()V", "", "timeStamp", "at", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class KeyframesSpecConfig<T> extends KeyframesSpecBaseConfig<T, KeyframeEntity<T>> {
        public KeyframesSpecConfig() {
            super(null);
        }

        public KeyframeEntity<T> at(T t, int i) {
            KeyframeEntity<T> keyframeEntity = new KeyframeEntity<>(t, null, 0, 6, null);
            getKeyframes$animation_core_release().set(i, keyframeEntity);
            return keyframeEntity;
        }
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public <V extends AnimationVector> VectorizedKeyframesSpec<V> vectorize(TwoWayConverter<T, V> converter) {
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i;
        MutableIntList mutableIntList = new MutableIntList(this.config.getKeyframes$animation_core_release().get_size() + 2);
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(this.config.getKeyframes$animation_core_release().get_size());
        MutableIntObjectMap<KeyframeEntity<T>> keyframes$animation_core_release = this.config.getKeyframes$animation_core_release();
        int[] iArr3 = keyframes$animation_core_release.keys;
        Object[] objArr = keyframes$animation_core_release.values;
        long[] jArr3 = keyframes$animation_core_release.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr3[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            int i7 = iArr3[i6];
                            KeyframeEntity keyframeEntity = (KeyframeEntity) objArr[i6];
                            mutableIntList.add(i7);
                            jArr2 = jArr3;
                            iArr2 = iArr3;
                            mutableIntObjectMap.set(i7, new VectorizedKeyframeSpecElementInfo(converter.getConvertToVector().invoke(keyframeEntity.getValue$animation_core_release()), keyframeEntity.getEasing(), keyframeEntity.getArcMode(), null));
                            i = 8;
                        } else {
                            jArr2 = jArr3;
                            iArr2 = iArr3;
                            i = i3;
                        }
                        j >>= i;
                        i5++;
                        i3 = i;
                        jArr3 = jArr2;
                        iArr3 = iArr2;
                    }
                    jArr = jArr3;
                    iArr = iArr3;
                    if (i4 != i3) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                    iArr = iArr3;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                jArr3 = jArr;
                iArr3 = iArr;
            }
        }
        if (!this.config.getKeyframes$animation_core_release().contains(0)) {
            mutableIntList.add(0, 0);
        }
        if (!this.config.getKeyframes$animation_core_release().contains(this.config.getDurationMillis())) {
            mutableIntList.add(this.config.getDurationMillis());
        }
        mutableIntList.sort();
        return new VectorizedKeyframesSpec<>(mutableIntList, mutableIntObjectMap, this.config.getDurationMillis(), this.config.getDelayMillis(), EasingKt.getLinearEasing(), ArcMode.INSTANCE.m125getArcLinear9TMq4(), null);
    }

    /* compiled from: AnimationSpec.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R(\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "T", "Landroidx/compose/animation/core/KeyframeBaseEntity;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroidx/compose/animation/core/Easing;", "easing", "Landroidx/compose/animation/core/ArcMode;", "arcMode", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "I", "getArcMode--9T-Mq4$animation_core_release", "setArcMode-Rur9ykg$animation_core_release", "(I)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class KeyframeEntity<T> extends KeyframeBaseEntity<T> {
        private int arcMode;

        public /* synthetic */ KeyframeEntity(Object obj, Easing easing, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, easing, i);
        }

        public /* synthetic */ KeyframeEntity(Object obj, Easing easing, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i2 & 2) != 0 ? EasingKt.getLinearEasing() : easing, (i2 & 4) != 0 ? ArcMode.INSTANCE.m125getArcLinear9TMq4() : i, null);
        }

        /* renamed from: getArcMode--9T-Mq4$animation_core_release, reason: not valid java name and from getter */
        public final int getArcMode() {
            return this.arcMode;
        }

        private KeyframeEntity(T t, Easing easing, int i) {
            super(t, easing, null);
            this.arcMode = i;
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof KeyframeEntity)) {
                return false;
            }
            KeyframeEntity keyframeEntity = (KeyframeEntity) other;
            return Intrinsics.areEqual(keyframeEntity.getValue$animation_core_release(), getValue$animation_core_release()) && Intrinsics.areEqual(keyframeEntity.getEasing(), getEasing()) && ArcMode.m122equalsimpl0(keyframeEntity.arcMode, this.arcMode);
        }

        public int hashCode() {
            T value$animation_core_release = getValue$animation_core_release();
            return ((((value$animation_core_release != null ? value$animation_core_release.hashCode() : 0) * 31) + ArcMode.m123hashCodeimpl(this.arcMode)) * 31) + getEasing().hashCode();
        }
    }
}
