package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VelocityTracker.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0003R\u001a\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0015\u0010\u0003R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R(\u0010\u001a\u001a\u00020\u00068\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "<init>", "()V", "", "timeMillis", "Landroidx/compose/ui/geometry/Offset;", "position", "", "addPosition-Uv8p0NA", "(JJ)V", "addPosition", "Landroidx/compose/ui/unit/Velocity;", "maximumVelocity", "calculateVelocity-AH228Gc", "(J)J", "calculateVelocity", "resetTracking", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "strategy", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "getStrategy$annotations", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "xVelocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "yVelocityTracker", "currentPointerPositionAccumulator", "J", "getCurrentPointerPositionAccumulator-F1C5BW0$ui_release", "()J", "setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release", "(J)V", "lastMoveEventTimeStamp", "getLastMoveEventTimeStamp$ui_release", "setLastMoveEventTimeStamp$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VelocityTracker {
    private long currentPointerPositionAccumulator;
    private long lastMoveEventTimeStamp;
    private final VelocityTracker1D.Strategy strategy;
    private final VelocityTracker1D xVelocityTracker;
    private final VelocityTracker1D yVelocityTracker;

    public VelocityTracker() {
        VelocityTracker1D.Strategy strategy;
        if (VelocityTrackerKt.getVelocityTrackerStrategyUseImpulse()) {
            strategy = VelocityTracker1D.Strategy.Impulse;
        } else {
            strategy = VelocityTracker1D.Strategy.Lsq2;
        }
        this.strategy = strategy;
        boolean z = false;
        int i = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.xVelocityTracker = new VelocityTracker1D(z, strategy, i, defaultConstructorMarker);
        this.yVelocityTracker = new VelocityTracker1D(z, strategy, i, defaultConstructorMarker);
        this.currentPointerPositionAccumulator = Offset.INSTANCE.m854getZeroF1C5BW0();
    }

    /* renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release, reason: not valid java name and from getter */
    public final long getCurrentPointerPositionAccumulator() {
        return this.currentPointerPositionAccumulator;
    }

    /* renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m1397setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long j) {
        this.currentPointerPositionAccumulator = j;
    }

    /* renamed from: getLastMoveEventTimeStamp$ui_release, reason: from getter */
    public final long getLastMoveEventTimeStamp() {
        return this.lastMoveEventTimeStamp;
    }

    public final void setLastMoveEventTimeStamp$ui_release(long j) {
        this.lastMoveEventTimeStamp = j;
    }

    /* renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m1394addPositionUv8p0NA(long timeMillis, long position) {
        this.xVelocityTracker.addDataPoint(timeMillis, Offset.m842getXimpl(position));
        this.yVelocityTracker.addDataPoint(timeMillis, Offset.m843getYimpl(position));
    }

    /* renamed from: calculateVelocity-AH228Gc, reason: not valid java name */
    public final long m1395calculateVelocityAH228Gc(long maximumVelocity) {
        if (!(Velocity.m2192getXimpl(maximumVelocity) > 0.0f && Velocity.m2193getYimpl(maximumVelocity) > 0.0f)) {
            InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + ((Object) Velocity.m2198toStringimpl(maximumVelocity)));
        }
        return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(Velocity.m2192getXimpl(maximumVelocity)), this.yVelocityTracker.calculateVelocity(Velocity.m2193getYimpl(maximumVelocity)));
    }

    public final void resetTracking() {
        this.xVelocityTracker.resetTracking();
        this.yVelocityTracker.resetTracking();
        this.lastMoveEventTimeStamp = 0L;
    }
}
