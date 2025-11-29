package androidx.compose.ui.graphics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PathOperation.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/PathOperation;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "constructor-impl", "(I)I", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class PathOperation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Difference = m1064constructorimpl(0);
    private static final int Intersect = m1064constructorimpl(1);
    private static final int Union = m1064constructorimpl(2);
    private static final int Xor = m1064constructorimpl(3);
    private static final int ReverseDifference = m1064constructorimpl(4);

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1064constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1065equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* compiled from: PathOperation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001d\u0010\r\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/PathOperation$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/graphics/PathOperation;", "Difference", "I", "getDifference-b3I0S0c", "()I", "Intersect", "getIntersect-b3I0S0c", "Union", "getUnion-b3I0S0c", "ReverseDifference", "getReverseDifference-b3I0S0c", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getDifference-b3I0S0c, reason: not valid java name */
        public final int m1066getDifferenceb3I0S0c() {
            return PathOperation.Difference;
        }

        /* renamed from: getIntersect-b3I0S0c, reason: not valid java name */
        public final int m1067getIntersectb3I0S0c() {
            return PathOperation.Intersect;
        }

        /* renamed from: getUnion-b3I0S0c, reason: not valid java name */
        public final int m1069getUnionb3I0S0c() {
            return PathOperation.Union;
        }

        /* renamed from: getReverseDifference-b3I0S0c, reason: not valid java name */
        public final int m1068getReverseDifferenceb3I0S0c() {
            return PathOperation.ReverseDifference;
        }
    }
}
