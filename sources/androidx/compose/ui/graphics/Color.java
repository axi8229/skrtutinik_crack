package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: Color.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001f\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\u000e\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010&\u001a\u0004\b*\u0010(R\u001a\u0010\u000f\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010&\u001a\u0004\b,\u0010(R\u001a\u0010\f\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010&\u001a\u0004\b.\u0010(\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "", "Lkotlin/ULong;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(J)J", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "colorSpace", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "convert", "", "alpha", "red", "green", "blue", "copy-wmQWz5c", "(JFFFF)J", "copy", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "", "hashCode-impl", "(J)I", "hashCode", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getValue-s-VKNKU", "()J", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "()V", "getRed-impl", "(J)F", "getRed$annotations", "getGreen-impl", "getGreen$annotations", "getBlue-impl", "getBlue$annotations", "getAlpha-impl", "getAlpha$annotations", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Color {
    private final long value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Black = ColorKt.Color(4278190080L);
    private static final long DarkGray = ColorKt.Color(4282664004L);
    private static final long Gray = ColorKt.Color(4287137928L);
    private static final long LightGray = ColorKt.Color(4291611852L);
    private static final long White = ColorKt.Color(4294967295L);
    private static final long Red = ColorKt.Color(4294901760L);
    private static final long Green = ColorKt.Color(4278255360L);
    private static final long Blue = ColorKt.Color(4278190335L);
    private static final long Yellow = ColorKt.Color(4294967040L);
    private static final long Cyan = ColorKt.Color(4278255615L);
    private static final long Magenta = ColorKt.Color(4294902015L);
    private static final long Transparent = ColorKt.Color(0);
    private static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Color m971boximpl(long j) {
        return new Color(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m972constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m976equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m977equalsimpl0(long j, long j2) {
        return ULong.m2684equalsimpl0(j, j2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m983hashCodeimpl(long j) {
        return ULong.m2685hashCodeimpl(j);
    }

    public boolean equals(Object obj) {
        return m976equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m983hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    private /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* renamed from: getColorSpace-impl, reason: not valid java name */
    public static final ColorSpace m980getColorSpaceimpl(long j) {
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        return colorSpaces.getColorSpacesArray$ui_graphics_release()[(int) ULong.m2682constructorimpl(j & 63)];
    }

    /* renamed from: convert-vNxB06k, reason: not valid java name */
    public static final long m973convertvNxB06k(long j, ColorSpace colorSpace) {
        return ColorSpaceKt.m1122connectYBCOT_4$default(m980getColorSpaceimpl(j), colorSpace, 0, 2, null).mo1124transformToColorl2rxGTc$ui_graphics_release(j);
    }

    /* renamed from: getRed-impl, reason: not valid java name */
    public static final float m982getRedimpl(long j) {
        int i;
        int i2;
        int i3;
        if (ULong.m2682constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m2682constructorimpl(ULong.m2682constructorimpl(j >>> 48) & 255))) / 255.0f;
        }
        short sM2682constructorimpl = (short) ULong.m2682constructorimpl(ULong.m2682constructorimpl(j >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i4 = Short.MIN_VALUE & sM2682constructorimpl;
        int i5 = ((65535 & sM2682constructorimpl) >>> 10) & 31;
        int i6 = sM2682constructorimpl & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = KotlinVersion.MAX_COMPONENT_VALUE;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* renamed from: getGreen-impl, reason: not valid java name */
    public static final float m981getGreenimpl(long j) {
        int i;
        int i2;
        int i3;
        if (ULong.m2682constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m2682constructorimpl(ULong.m2682constructorimpl(j >>> 40) & 255))) / 255.0f;
        }
        short sM2682constructorimpl = (short) ULong.m2682constructorimpl(ULong.m2682constructorimpl(j >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i4 = Short.MIN_VALUE & sM2682constructorimpl;
        int i5 = ((65535 & sM2682constructorimpl) >>> 10) & 31;
        int i6 = sM2682constructorimpl & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = KotlinVersion.MAX_COMPONENT_VALUE;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* renamed from: getBlue-impl, reason: not valid java name */
    public static final float m979getBlueimpl(long j) {
        int i;
        int i2;
        int i3;
        if (ULong.m2682constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m2682constructorimpl(ULong.m2682constructorimpl(j >>> 32) & 255))) / 255.0f;
        }
        short sM2682constructorimpl = (short) ULong.m2682constructorimpl(ULong.m2682constructorimpl(j >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i4 = Short.MIN_VALUE & sM2682constructorimpl;
        int i5 = ((65535 & sM2682constructorimpl) >>> 10) & 31;
        int i6 = sM2682constructorimpl & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = KotlinVersion.MAX_COMPONENT_VALUE;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* renamed from: getAlpha-impl, reason: not valid java name */
    public static final float m978getAlphaimpl(long j) {
        float fUlongToDouble;
        float f;
        if (ULong.m2682constructorimpl(63 & j) == 0) {
            fUlongToDouble = (float) UnsignedKt.ulongToDouble(ULong.m2682constructorimpl(ULong.m2682constructorimpl(j >>> 56) & 255));
            f = 255.0f;
        } else {
            fUlongToDouble = (float) UnsignedKt.ulongToDouble(ULong.m2682constructorimpl(ULong.m2682constructorimpl(j >>> 6) & 1023));
            f = 1023.0f;
        }
        return fUlongToDouble / f;
    }

    /* renamed from: copy-wmQWz5c$default, reason: not valid java name */
    public static /* synthetic */ long m975copywmQWz5c$default(long j, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m978getAlphaimpl(j);
        }
        float f5 = f;
        if ((i & 2) != 0) {
            f2 = m982getRedimpl(j);
        }
        float f6 = f2;
        if ((i & 4) != 0) {
            f3 = m981getGreenimpl(j);
        }
        float f7 = f3;
        if ((i & 8) != 0) {
            f4 = m979getBlueimpl(j);
        }
        return m974copywmQWz5c(j, f5, f6, f7, f4);
    }

    /* renamed from: copy-wmQWz5c, reason: not valid java name */
    public static final long m974copywmQWz5c(long j, float f, float f2, float f3, float f4) {
        return ColorKt.Color(f2, f3, f4, f, m980getColorSpaceimpl(j));
    }

    public String toString() {
        return m984toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m984toStringimpl(long j) {
        return "Color(" + m982getRedimpl(j) + ", " + m981getGreenimpl(j) + ", " + m979getBlueimpl(j) + ", " + m978getAlphaimpl(j) + ", " + m980getColorSpaceimpl(j).getName() + ')';
    }

    /* compiled from: Color.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR&\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\bR&\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\bR&\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\bR&\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0017\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/graphics/Color;", "Black", "J", "getBlack-0d7_KjU", "()J", "getBlack-0d7_KjU$annotations", "White", "getWhite-0d7_KjU", "getWhite-0d7_KjU$annotations", "Red", "getRed-0d7_KjU", "getRed-0d7_KjU$annotations", "Blue", "getBlue-0d7_KjU", "getBlue-0d7_KjU$annotations", "Transparent", "getTransparent-0d7_KjU", "getTransparent-0d7_KjU$annotations", "Unspecified", "getUnspecified-0d7_KjU", "getUnspecified-0d7_KjU$annotations", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getBlack-0d7_KjU, reason: not valid java name */
        public final long m986getBlack0d7_KjU() {
            return Color.Black;
        }

        /* renamed from: getWhite-0d7_KjU, reason: not valid java name */
        public final long m991getWhite0d7_KjU() {
            return Color.White;
        }

        /* renamed from: getRed-0d7_KjU, reason: not valid java name */
        public final long m988getRed0d7_KjU() {
            return Color.Red;
        }

        /* renamed from: getBlue-0d7_KjU, reason: not valid java name */
        public final long m987getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* renamed from: getTransparent-0d7_KjU, reason: not valid java name */
        public final long m989getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* renamed from: getUnspecified-0d7_KjU, reason: not valid java name */
        public final long m990getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }
    }
}
