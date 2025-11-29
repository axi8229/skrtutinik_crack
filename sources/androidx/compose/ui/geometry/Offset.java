package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Offset.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087@\u0018\u0000 42\u00020\u0001:\u00014B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0011J\u0016\u0010\u0016\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u001b\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u001e\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\"\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010&\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0010\u0010*\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010-\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010.R\u001a\u0010\u0007\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b/\u0010\u0011R\u001a\u0010\b\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u00101\u001a\u0004\b2\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", "", "", "packedValue", "constructor-impl", "(J)J", "", "x", "y", "copy-dBAh8RU", "(JFF)J", "copy", "", "isValid-impl", "(J)Z", "isValid", "getDistance-impl", "(J)F", "getDistance", "getDistanceSquared-impl", "getDistanceSquared", "unaryMinus-F1C5BW0", "unaryMinus", "other", "minus-MK-Hz9U", "(JJ)J", "minus", "plus-MK-Hz9U", "plus", "operand", "times-tuRUvjQ", "(JF)J", "times", "div-tuRUvjQ", "div", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "", "hashCode-impl", "(J)I", "hashCode", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getX-impl", "getX$annotations", "()V", "getY-impl", "getY$annotations", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Offset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m834constructorimpl(0);
    private static final long Infinite = m834constructorimpl(9187343241974906880L);
    private static final long Unspecified = m834constructorimpl(9205357640488583168L);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m833boximpl(long j) {
        return new Offset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m834constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m838equalsimpl(long j, Object obj) {
        return (obj instanceof Offset) && j == ((Offset) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m839equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m844hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m845isValidimpl(long j) {
        long j2 = j & 9223372034707292159L;
        return (((~j2) & (j2 - 9187343246269874177L)) & (-9223372034707292160L)) == -9223372034707292160L;
    }

    public boolean equals(Object obj) {
        return m838equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m844hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m836copydBAh8RU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m835copydBAh8RU(j, f, f2);
    }

    /* renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m837divtuRUvjQ(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) / f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) / f;
        return m834constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m840getDistanceimpl(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return (float) Math.sqrt((fIntBitsToFloat * fIntBitsToFloat) + (fIntBitsToFloat2 * fIntBitsToFloat2));
    }

    /* renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m841getDistanceSquaredimpl(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return (fIntBitsToFloat * fIntBitsToFloat) + (fIntBitsToFloat2 * fIntBitsToFloat2);
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m842getXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m843getYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m846minusMKHz9U(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L));
        return m834constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m847plusMKHz9U(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) + Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) + Float.intBitsToFloat((int) (j2 & 4294967295L));
        return m834constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m848timestuRUvjQ(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) * f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) * f;
        return m834constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    private /* synthetic */ Offset(long j) {
        this.packedValue = j;
    }

    /* renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m835copydBAh8RU(long j, float f, float f2) {
        return m834constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }

    /* compiled from: Offset.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR&\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/geometry/Offset$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/geometry/Offset;", "Zero", "J", "getZero-F1C5BW0", "()J", "getZero-F1C5BW0$annotations", "Infinite", "getInfinite-F1C5BW0", "getInfinite-F1C5BW0$annotations", "Unspecified", "getUnspecified-F1C5BW0", "getUnspecified-F1C5BW0$annotations", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-F1C5BW0, reason: not valid java name */
        public final long m854getZeroF1C5BW0() {
            return Offset.Zero;
        }

        /* renamed from: getInfinite-F1C5BW0, reason: not valid java name */
        public final long m852getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* renamed from: getUnspecified-F1C5BW0, reason: not valid java name */
        public final long m853getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }
    }

    /* renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m850unaryMinusF1C5BW0(long j) {
        return m834constructorimpl(j ^ (-9223372034707292160L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m849toStringimpl(long j) {
        if (OffsetKt.m856isSpecifiedk4lQ0M(j)) {
            return "Offset(" + GeometryUtilsKt.toStringAsFixed(m842getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m843getYimpl(j), 1) + ')';
        }
        return "Offset.Unspecified";
    }

    public String toString() {
        return m849toStringimpl(this.packedValue);
    }
}
