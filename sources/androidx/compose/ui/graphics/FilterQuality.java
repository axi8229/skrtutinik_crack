package androidx.compose.ui.graphics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FilterQuality.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/FilterQuality;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(I)I", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "hashCode-impl", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class FilterQuality {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int None = m1005constructorimpl(0);
    private static final int Low = m1005constructorimpl(1);
    private static final int Medium = m1005constructorimpl(2);
    private static final int High = m1005constructorimpl(3);

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1005constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1006equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1007hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* compiled from: FilterQuality.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/FilterQuality$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/graphics/FilterQuality;", "None", "I", "getNone-f-v9h1I", "()I", "Low", "getLow-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNone-f-v9h1I, reason: not valid java name */
        public final int m1010getNonefv9h1I() {
            return FilterQuality.None;
        }

        /* renamed from: getLow-f-v9h1I, reason: not valid java name */
        public final int m1009getLowfv9h1I() {
            return FilterQuality.Low;
        }
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1008toStringimpl(int i) {
        return m1006equalsimpl0(i, None) ? "None" : m1006equalsimpl0(i, Low) ? "Low" : m1006equalsimpl0(i, Medium) ? "Medium" : m1006equalsimpl0(i, High) ? "High" : "Unknown";
    }
}
