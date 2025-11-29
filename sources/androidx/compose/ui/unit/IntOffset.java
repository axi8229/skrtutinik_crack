package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IntOffset.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087@\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\u0012H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001c\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u0012\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001f\u001a\u0004\b \u0010\u0017R\u001a\u0010\b\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001f\u001a\u0004\b\"\u0010\u0017\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "", "packedValue", "constructor-impl", "(J)J", "", "x", "y", "copy-iSbpLlY", "(JII)J", "copy", "other", "minus-qkQi6aY", "(JJ)J", "minus", "plus-qkQi6aY", "plus", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "hashCode-impl", "(J)I", "hashCode", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getPackedValue$annotations", "()V", "getX-impl", "getX$annotations", "getY-impl", "getY$annotations", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class IntOffset {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m2133constructorimpl(0);
    private final long packedValue;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m2132boximpl(long j) {
        return new IntOffset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2133constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2136equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2137equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final int m2138getXimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final int m2139getYimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2140hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2136equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2140hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    /* renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m2135copyiSbpLlY$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = (int) (j >> 32);
        }
        if ((i3 & 2) != 0) {
            i2 = (int) (4294967295L & j);
        }
        return m2134copyiSbpLlY(j, i, i2);
    }

    /* renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m2134copyiSbpLlY(long j, int i, int i2) {
        return m2133constructorimpl((i << 32) | (i2 & 4294967295L));
    }

    /* renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m2141minusqkQi6aY(long j, long j2) {
        return m2133constructorimpl(((((int) (j >> 32)) - ((int) (j2 >> 32))) << 32) | ((((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L))) & 4294967295L));
    }

    /* renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m2142plusqkQi6aY(long j, long j2) {
        return m2133constructorimpl(((((int) (j >> 32)) + ((int) (j2 >> 32))) << 32) | ((((int) (j & 4294967295L)) + ((int) (j2 & 4294967295L))) & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2143toStringimpl(long j) {
        return '(' + m2138getXimpl(j) + ", " + m2139getYimpl(j) + ')';
    }

    public String toString() {
        return m2143toStringimpl(this.packedValue);
    }

    /* compiled from: IntOffset.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m2145getZeronOccac() {
            return IntOffset.Zero;
        }
    }
}
