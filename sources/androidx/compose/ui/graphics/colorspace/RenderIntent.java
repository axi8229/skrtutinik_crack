package androidx.compose.ui.graphics.colorspace;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RenderIntent.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(I)I", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class RenderIntent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Perceptual = m1128constructorimpl(0);
    private static final int Relative = m1128constructorimpl(1);
    private static final int Saturation = m1128constructorimpl(2);
    private static final int Absolute = m1128constructorimpl(3);

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1128constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1129equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* compiled from: RenderIntent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "Perceptual", "I", "getPerceptual-uksYyKA", "()I", "Relative", "getRelative-uksYyKA", "Absolute", "getAbsolute-uksYyKA", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getPerceptual-uksYyKA, reason: not valid java name */
        public final int m1131getPerceptualuksYyKA() {
            return RenderIntent.Perceptual;
        }

        /* renamed from: getRelative-uksYyKA, reason: not valid java name */
        public final int m1132getRelativeuksYyKA() {
            return RenderIntent.Relative;
        }

        /* renamed from: getAbsolute-uksYyKA, reason: not valid java name */
        public final int m1130getAbsoluteuksYyKA() {
            return RenderIntent.Absolute;
        }
    }
}
