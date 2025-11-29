package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InlineDensity.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0081@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bB\u0011\b\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\u0088\u0001\n\u0092\u0001\u00020\t¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity;", "", "", "density", "fontScale", "constructor-impl", "(FF)J", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)J", "", "packedValue", "(J)J", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "getDensity-impl", "(J)F", "getFontScale-impl", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class InlineDensity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Unspecified = m529constructorimpl(Float.NaN, Float.NaN);

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m530constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m532equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getDensity-impl, reason: not valid java name */
    public static final float m533getDensityimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getFontScale-impl, reason: not valid java name */
    public static final float m534getFontScaleimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m531constructorimpl(Density density) {
        return m529constructorimpl(density.getDensity(), density.getFontScale());
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m535toStringimpl(long j) {
        return "InlineDensity(density=" + m533getDensityimpl(j) + ", fontScale=" + m534getFontScaleimpl(j) + ')';
    }

    /* compiled from: InlineDensity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity$Companion;", "", "()V", "Unspecified", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "getUnspecified-L26CHvs", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-L26CHvs, reason: not valid java name */
        public final long m536getUnspecifiedL26CHvs() {
            return InlineDensity.Unspecified;
        }
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m529constructorimpl(float f, float f2) {
        return m530constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }
}
