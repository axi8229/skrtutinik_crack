package androidx.compose.ui.unit;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Constraints.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0087@\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0019\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u0012\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u0011\u0010#\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010%\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u001a\u0010(\u001a\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001c\u001a\u0004\b&\u0010\"R\u001a\u0010+\u001a\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u001c\u001a\u0004\b)\u0010\"R\u001a\u0010.\u001a\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001c\u001a\u0004\b,\u0010\"\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/ui/unit/Constraints;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(J)J", "", "minWidth", "maxWidth", "minHeight", "maxHeight", "copy-Zbe2FdA", "(JIIII)J", "copy", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "hashCode-impl", "(J)I", "hashCode", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getValue$annotations", "()V", "getMinWidth-impl", "getMaxWidth-impl", "getMinHeight-impl", "getMaxHeight-impl", "getHasBoundedWidth-impl", "(J)Z", "hasBoundedWidth", "getHasBoundedHeight-impl", "hasBoundedHeight", "getHasFixedWidth-impl", "getHasFixedWidth$annotations", "hasFixedWidth", "getHasFixedHeight-impl", "getHasFixedHeight$annotations", "hasFixedHeight", "isZero-impl", "isZero$annotations", "isZero", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Constraints {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long value;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Constraints m2073boximpl(long j) {
        return new Constraints(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2074constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2077equalsimpl(long j, Object obj) {
        return (obj instanceof Constraints) && j == ((Constraints) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2078equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m2079getHasBoundedHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        return (((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1)) != 0;
    }

    /* renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m2080getHasBoundedWidthimpl(long j) {
        int i = (int) (3 & j);
        return (((int) (j >> 33)) & ((1 << ((((i & 1) << 1) + (((i & 2) >> 1) * 3)) + 13)) - 1)) != 0;
    }

    /* renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m2081getHasFixedHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int i3 = (1 << (18 - i2)) - 1;
        int i4 = ((int) (j >> (i2 + 15))) & i3;
        int i5 = ((int) (j >> (i2 + 46))) & i3;
        return i4 == (i5 == 0 ? Integer.MAX_VALUE : i5 - 1);
    }

    /* renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m2082getHasFixedWidthimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (1 << ((((i & 1) << 1) + (((i & 2) >> 1) * 3)) + 13)) - 1;
        int i3 = ((int) (j >> 2)) & i2;
        int i4 = ((int) (j >> 33)) & i2;
        return i3 == (i4 == 0 ? Integer.MAX_VALUE : i4 - 1);
    }

    /* renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m2083getMaxHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int i3 = ((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1);
        if (i3 == 0) {
            return Integer.MAX_VALUE;
        }
        return i3 - 1;
    }

    /* renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m2084getMaxWidthimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((int) (j >> 33)) & ((1 << ((((i & 1) << 1) + (((i & 2) >> 1) * 3)) + 13)) - 1);
        if (i2 == 0) {
            return Integer.MAX_VALUE;
        }
        return i2 - 1;
    }

    /* renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m2085getMinHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        return ((int) (j >> (i2 + 15))) & ((1 << (18 - i2)) - 1);
    }

    /* renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m2086getMinWidthimpl(long j) {
        int i = (int) (3 & j);
        return ((int) (j >> 2)) & ((1 << ((((i & 1) << 1) + (((i & 2) >> 1) * 3)) + 13)) - 1);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2087hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isZero-impl, reason: not valid java name */
    public static final boolean m2088isZeroimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        return (((int) (j >> 33)) & ((1 << (i2 + 13)) - 1)) - 1 == 0 || (((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1)) - 1 == 0;
    }

    public boolean equals(Object obj) {
        return m2077equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2087hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    private /* synthetic */ Constraints(long j) {
        this.value = j;
    }

    /* renamed from: copy-Zbe2FdA$default, reason: not valid java name */
    public static /* synthetic */ long m2076copyZbe2FdA$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = m2086getMinWidthimpl(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = m2084getMaxWidthimpl(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = m2085getMinHeightimpl(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = m2083getMaxHeightimpl(j);
        }
        return m2075copyZbe2FdA(j, i6, i7, i8, i4);
    }

    /* renamed from: copy-Zbe2FdA, reason: not valid java name */
    public static final long m2075copyZbe2FdA(long j, int i, int i2, int i3, int i4) {
        if (!(i3 >= 0 && i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("minHeight(" + i3 + ") and minWidth(" + i + ") must be >= 0");
        }
        if (!(i2 >= i)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth(" + i2 + ") must be >= minWidth(" + i + ')');
        }
        if (!(i4 >= i3)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxHeight(" + i4 + ") must be >= minHeight(" + i3 + ')');
        }
        return ConstraintsKt.createConstraints(i, i2, i3, i4);
    }

    public String toString() {
        return m2089toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2089toStringimpl(long j) {
        int iM2084getMaxWidthimpl = m2084getMaxWidthimpl(j);
        String strValueOf = "Infinity";
        String strValueOf2 = iM2084getMaxWidthimpl == Integer.MAX_VALUE ? "Infinity" : String.valueOf(iM2084getMaxWidthimpl);
        int iM2083getMaxHeightimpl = m2083getMaxHeightimpl(j);
        if (iM2083getMaxHeightimpl != Integer.MAX_VALUE) {
            strValueOf = String.valueOf(iM2083getMaxHeightimpl);
        }
        return "Constraints(minWidth = " + m2086getMinWidthimpl(j) + ", maxWidth = " + strValueOf2 + ", minHeight = " + m2085getMinHeightimpl(j) + ", maxHeight = " + strValueOf + ')';
    }

    /* compiled from: Constraints.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J5\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", "", "<init>", "()V", "", "width", "height", "Landroidx/compose/ui/unit/Constraints;", "fixed-JhjzzOo", "(II)J", "fixed", "fixedWidth-OenEA2s", "(I)J", "fixedWidth", "minWidth", "maxWidth", "minHeight", "maxHeight", "fitPrioritizingWidth-Zbe2FdA", "(IIII)J", "fitPrioritizingWidth", "fitPrioritizingHeight-Zbe2FdA", "fitPrioritizingHeight", "Infinity", "I", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: fixed-JhjzzOo, reason: not valid java name */
        public final long m2093fixedJhjzzOo(int width, int height) {
            if (!(width >= 0 && height >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("width(" + width + ") and height(" + height + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, height, height);
        }

        /* renamed from: fixedWidth-OenEA2s, reason: not valid java name */
        public final long m2094fixedWidthOenEA2s(int width) {
            if (!(width >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("width(" + width + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, 0, Integer.MAX_VALUE);
        }

        /* renamed from: fitPrioritizingWidth-Zbe2FdA, reason: not valid java name */
        public final long m2092fitPrioritizingWidthZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int iMin = Math.min(minWidth, 262142);
            int iMin2 = maxWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(maxWidth, 262142);
            int iMaxAllowedForSize = ConstraintsKt.maxAllowedForSize(iMin2 == Integer.MAX_VALUE ? iMin : iMin2);
            return ConstraintsKt.Constraints(iMin, iMin2, Math.min(iMaxAllowedForSize, minHeight), maxHeight != Integer.MAX_VALUE ? Math.min(iMaxAllowedForSize, maxHeight) : Integer.MAX_VALUE);
        }

        /* renamed from: fitPrioritizingHeight-Zbe2FdA, reason: not valid java name */
        public final long m2091fitPrioritizingHeightZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int iMin = Math.min(minHeight, 262142);
            int iMin2 = maxHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(maxHeight, 262142);
            int iMaxAllowedForSize = ConstraintsKt.maxAllowedForSize(iMin2 == Integer.MAX_VALUE ? iMin : iMin2);
            return ConstraintsKt.Constraints(Math.min(iMaxAllowedForSize, minWidth), maxWidth != Integer.MAX_VALUE ? Math.min(iMaxAllowedForSize, maxWidth) : Integer.MAX_VALUE, iMin, iMin2);
        }
    }
}
