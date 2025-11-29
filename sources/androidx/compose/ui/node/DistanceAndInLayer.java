package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* compiled from: HitTestResult.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/DistanceAndInLayer;", "", "", "packedValue", "constructor-impl", "(J)J", "other", "", "compareTo-S_HNhKs", "(JJ)I", "compareTo", "", "getDistance-impl", "(J)F", "distance", "", "isInLayer-impl", "(J)Z", "isInLayer", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
final class DistanceAndInLayer {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1468constructorimpl(long j) {
        return j;
    }

    /* renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m1470isInLayerimpl(long j) {
        return ((int) (j & 4294967295L)) != 0;
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m1469getDistanceimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: compareTo-S_HNhKs, reason: not valid java name */
    public static final int m1467compareToS_HNhKs(long j, long j2) {
        boolean zM1470isInLayerimpl = m1470isInLayerimpl(j);
        if (zM1470isInLayerimpl != m1470isInLayerimpl(j2)) {
            return zM1470isInLayerimpl ? -1 : 1;
        }
        return (int) Math.signum(m1469getDistanceimpl(j) - m1469getDistanceimpl(j2));
    }
}
