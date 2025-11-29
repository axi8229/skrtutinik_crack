package androidx.compose.animation.core;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AnimationSpec.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0087@\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\f\u0088\u0001\t\u0092\u0001\u00020\b¨\u0006\u000e"}, d2 = {"Landroidx/compose/animation/core/StartOffset;", "", "", "offsetMillis", "Landroidx/compose/animation/core/StartOffsetType;", "offsetType", "constructor-impl", "(II)J", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(J)J", "hashCode-impl", "(J)I", "hashCode", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class StartOffset {
    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m132constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m134equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m135hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m131constructorimpl(int i, int i2) {
        return m132constructorimpl(i * i2);
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ long m133constructorimpl$default(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != 0) {
            i2 = StartOffsetType.INSTANCE.m137getDelayEo1U57Q();
        }
        return m131constructorimpl(i, i2);
    }
}
