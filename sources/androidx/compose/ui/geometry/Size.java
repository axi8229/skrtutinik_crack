package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\f\b\u0087@\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010#\u001a\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0018\u001a\u0004\b!\u0010\u001b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006%"}, d2 = {"Landroidx/compose/ui/geometry/Size;", "", "", "packedValue", "constructor-impl", "(J)J", "", "isEmpty-impl", "(J)Z", "isEmpty", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "", "hashCode-impl", "(J)I", "hashCode", "other", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getPackedValue$annotations", "()V", "", "getWidth-impl", "(J)F", "getWidth$annotations", "width", "getHeight-impl", "getHeight$annotations", "height", "getMinDimension-impl", "getMinDimension$annotations", "minDimension", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Size {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m873constructorimpl(0);
    private static final long Unspecified = m873constructorimpl(9205357640488583168L);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Size m872boximpl(long j) {
        return new Size(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m873constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m874equalsimpl(long j, Object obj) {
        return (obj instanceof Size) && j == ((Size) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m875equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m879hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m874equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m879hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ Size(long j) {
        this.packedValue = j;
    }

    /* renamed from: getWidth-impl, reason: not valid java name */
    public static final float m878getWidthimpl(long j) {
        if (j == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final float m876getHeightimpl(long j) {
        if (j == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* compiled from: Size.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/geometry/Size$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/geometry/Size;", "Zero", "J", "getZero-NH-jbRc", "()J", "getZero-NH-jbRc$annotations", "Unspecified", "getUnspecified-NH-jbRc", "getUnspecified-NH-jbRc$annotations", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-NH-jbRc, reason: not valid java name */
        public final long m884getZeroNHjbRc() {
            return Size.Zero;
        }

        /* renamed from: getUnspecified-NH-jbRc, reason: not valid java name */
        public final long m883getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m880isEmptyimpl(long j) {
        if (j == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        long j2 = j & (~((((-9223372034707292160L) & j) >>> 31) * (-1)));
        return ((j2 & 4294967295L) & (j2 >>> 32)) == 0;
    }

    /* renamed from: getMinDimension-impl, reason: not valid java name */
    public static final float m877getMinDimensionimpl(long j) {
        if (j == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return Math.min(Float.intBitsToFloat((int) ((j >> 32) & 2147483647L)), Float.intBitsToFloat((int) (j & 2147483647L)));
    }

    public String toString() {
        return m881toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m881toStringimpl(long j) {
        if (j != 9205357640488583168L) {
            return "Size(" + GeometryUtilsKt.toStringAsFixed(m878getWidthimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m876getHeightimpl(j), 1) + ')';
        }
        return "Size.Unspecified";
    }
}
