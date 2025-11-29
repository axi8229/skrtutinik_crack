package androidx.compose.ui.unit;

import androidx.compose.ui.unit.TextUnitType;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TextUnit.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00028@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0014\u0010\u0005R\u0017\u0010\u001a\u001a\u00020\u00188Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0011\u0010\u001e\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/ui/unit/TextUnit;", "", "", "packedValue", "constructor-impl", "(J)J", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "", "hashCode-impl", "(J)I", "hashCode", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getRawType-impl", "getRawType$annotations", "()V", "rawType", "Landroidx/compose/ui/unit/TextUnitType;", "getType-UIouoOA", "type", "", "getValue-impl", "(J)F", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class TextUnit {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextUnitType[] TextUnitTypes;
    private static final long Unspecified;
    private final long packedValue;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m2163boximpl(long j) {
        return new TextUnit(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2164constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2165equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2166equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getRawType-impl, reason: not valid java name */
    public static final long m2167getRawTypeimpl(long j) {
        return j & 1095216660480L;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2170hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2165equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2170hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    public static final float m2169getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    private /* synthetic */ TextUnit(long j) {
        this.packedValue = j;
    }

    public String toString() {
        return m2171toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2171toStringimpl(long j) {
        long jM2168getTypeUIouoOA = m2168getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m2179equalsimpl0(jM2168getTypeUIouoOA, companion.m2185getUnspecifiedUIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.m2179equalsimpl0(jM2168getTypeUIouoOA, companion.m2184getSpUIouoOA())) {
            return m2169getValueimpl(j) + ".sp";
        }
        if (!TextUnitType.m2179equalsimpl0(jM2168getTypeUIouoOA, companion.m2183getEmUIouoOA())) {
            return "Invalid";
        }
        return m2169getValueimpl(j) + ".em";
    }

    /* compiled from: TextUnit.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/TextUnit$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/unit/TextUnit;", "Unspecified", "J", "getUnspecified-XSAIIZE", "()J", "getUnspecified-XSAIIZE$annotations", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m2173getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }
    }

    static {
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        TextUnitTypes = new TextUnitType[]{TextUnitType.m2176boximpl(companion.m2185getUnspecifiedUIouoOA()), TextUnitType.m2176boximpl(companion.m2184getSpUIouoOA()), TextUnitType.m2176boximpl(companion.m2183getEmUIouoOA())};
        Unspecified = TextUnitKt.pack(0L, Float.NaN);
    }

    /* renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m2168getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) (m2167getRawTypeimpl(j) >>> 32)].getType();
    }
}
