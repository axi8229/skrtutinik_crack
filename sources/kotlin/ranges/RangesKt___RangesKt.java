package kotlin.ranges;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\r\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0010\u001a\u0019\u0010\r\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\f\u001a\u00020\u0011¢\u0006\u0004\b\r\u0010\u0012\u001a\u0019\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u000e\u001a\u0019\u0010\u0014\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0010\u001a\u0019\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0012\u001a\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0015¢\u0006\u0004\b\u0014\u0010\u0016\u001a!\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a!\u0010\u0017\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0019\u001a!\u0010\u0017\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u001a\u001a!\u0010\u0017\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u001b\u001a1\u0010\u0017\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u00028\u00000\u001c*\u00028\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0007¢\u0006\u0004\b\u0017\u0010 \u001a\u001f\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00000!¢\u0006\u0004\b\u0017\u0010\"¨\u0006#"}, d2 = {"", RemoteMessageConst.TO, "Lkotlin/ranges/IntProgression;", "downTo", "(II)Lkotlin/ranges/IntProgression;", "reversed", "(Lkotlin/ranges/IntProgression;)Lkotlin/ranges/IntProgression;", "step", "(Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/IntRange;", "until", "(II)Lkotlin/ranges/IntRange;", "minimumValue", "coerceAtLeast", "(II)I", "", "(JJ)J", "", "(FF)F", "maximumValue", "coerceAtMost", "", "(DD)D", "coerceIn", "(III)I", "(JJJ)J", "(FFF)F", "(DDD)D", "", "T", "Lkotlin/ranges/ClosedFloatingPointRange;", "range", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(ILkotlin/ranges/ClosedRange;)I", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes3.dex */
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static float coerceAtLeast(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static int coerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static double coerceAtMost(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    public static float coerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static int coerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static IntProgression downTo(int i, int i2) {
        return IntProgression.INSTANCE.fromClosedRange(i, i2, -1);
    }

    public static IntProgression reversed(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        return IntProgression.INSTANCE.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    public static IntProgression step(IntProgression intProgression, int i) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.INSTANCE;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static IntRange until(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(i, i2 - 1);
    }

    public static int coerceIn(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static long coerceIn(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    public static float coerceIn(float f, float f2, float f3) {
        if (f2 <= f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static double coerceIn(double d, double d2, double d3) {
        if (d2 <= d3) {
            return d < d2 ? d2 : d > d3 ? d3 : d;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedFloatingPointRange<T> range) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            return (!range.lessThanOrEquals(t, range.getStart()) || range.lessThanOrEquals(range.getStart(), t)) ? (!range.lessThanOrEquals(range.getEndInclusive(), t) || range.lessThanOrEquals(t, range.getEndInclusive())) ? t : range.getEndInclusive() : range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static int coerceIn(int i, ClosedRange<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Integer.valueOf(i), (ClosedFloatingPointRange<Integer>) range)).intValue();
        }
        if (!range.isEmpty()) {
            return i < ((Number) range.getStart()).intValue() ? ((Number) range.getStart()).intValue() : i > ((Number) range.getEndInclusive()).intValue() ? ((Number) range.getEndInclusive()).intValue() : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }
}
