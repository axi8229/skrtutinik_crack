package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ColorModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\u00020\n8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000e\u0010\f\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel;", "", "", "packedValue", "constructor-impl", "(J)J", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "", "hashCode-impl", "(J)I", "hashCode", "getComponentCount-impl", "getComponentCount$annotations", "()V", "componentCount", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ColorModel {
    private static final long Cmyk;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Lab;
    private static final long Rgb;
    private static final long Xyz;

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1111constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1112equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getComponentCount-impl, reason: not valid java name */
    public static final int m1113getComponentCountimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1114hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* compiled from: ColorModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "Rgb", "J", "getRgb-xdoWZVw", "()J", "Xyz", "getXyz-xdoWZVw", "Lab", "getLab-xdoWZVw", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getRgb-xdoWZVw, reason: not valid java name */
        public final long m1117getRgbxdoWZVw() {
            return ColorModel.Rgb;
        }

        /* renamed from: getXyz-xdoWZVw, reason: not valid java name */
        public final long m1118getXyzxdoWZVw() {
            return ColorModel.Xyz;
        }

        /* renamed from: getLab-xdoWZVw, reason: not valid java name */
        public final long m1116getLabxdoWZVw() {
            return ColorModel.Lab;
        }
    }

    static {
        long j = 3;
        long j2 = j << 32;
        Rgb = m1111constructorimpl((0 & 4294967295L) | j2);
        Xyz = m1111constructorimpl((1 & 4294967295L) | j2);
        Lab = m1111constructorimpl(j2 | (2 & 4294967295L));
        Cmyk = m1111constructorimpl((j & 4294967295L) | (4 << 32));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1115toStringimpl(long j) {
        return m1112equalsimpl0(j, Rgb) ? "Rgb" : m1112equalsimpl0(j, Xyz) ? "Xyz" : m1112equalsimpl0(j, Lab) ? "Lab" : m1112equalsimpl0(j, Cmyk) ? "Cmyk" : "Unknown";
    }
}
