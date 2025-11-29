package androidx.compose.ui.graphics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* compiled from: Float16.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0004\b\u0081@\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b\u0088\u0001\u0007\u0092\u0001\u00020\u0006¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/Float16;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(F)S", "", "halfValue", "(S)S", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Float16 implements Comparable<Float16> {
    private static final short Epsilon = m1012constructorimpl((short) 5120);
    private static final short LowestValue = m1012constructorimpl((short) -1025);
    private static final short MaxValue = m1012constructorimpl((short) 31743);
    private static final short MinNormal = m1012constructorimpl((short) 1024);
    private static final short MinValue = m1012constructorimpl((short) 1);
    private static final short NaN = m1012constructorimpl((short) 32256);
    private static final short NegativeInfinity = m1012constructorimpl((short) -1024);
    private static final short NegativeZero = m1012constructorimpl(Short.MIN_VALUE);
    private static final short PositiveInfinity = m1012constructorimpl((short) 31744);
    private static final short PositiveZero = m1012constructorimpl((short) 0);

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m1012constructorimpl(short s) {
        return s;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m1011constructorimpl(float f) {
        int i;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i2 = iFloatToRawIntBits >>> 31;
        int i3 = (iFloatToRawIntBits >>> 23) & KotlinVersion.MAX_COMPONENT_VALUE;
        int i4 = 8388607 & iFloatToRawIntBits;
        int i5 = 31;
        int i6 = 0;
        if (i3 != 255) {
            int i7 = i3 - 112;
            if (i7 >= 31) {
                i5 = 49;
            } else if (i7 > 0) {
                i6 = i4 >> 13;
                if ((iFloatToRawIntBits & 4096) != 0) {
                    i = (((i7 << 10) | i6) + 1) | (i2 << 15);
                    return m1012constructorimpl((short) i);
                }
                i5 = i7;
            } else if (i7 >= -10) {
                int i8 = (8388608 | i4) >> (1 - i7);
                if ((i8 & 4096) != 0) {
                    i8 += 8192;
                }
                i5 = 0;
                i6 = i8 >> 13;
            } else {
                i5 = 0;
            }
        } else if (i4 != 0) {
            i6 = 512;
        }
        i = (i2 << 15) | (i5 << 10) | i6;
        return m1012constructorimpl((short) i);
    }
}
