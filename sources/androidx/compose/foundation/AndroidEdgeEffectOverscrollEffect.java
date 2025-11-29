package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* compiled from: AndroidOverscroll.android.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\u001a\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0016J6\u0010$\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0 H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J?\u0010-\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0(\u0012\u0006\u0012\u0004\u0018\u00010)0'H\u0096@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0000ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0015\u00105\u001a\u00020\u000eH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u00020\u000bH\u0000¢\u0006\u0004\b6\u0010\rR\u001e\u00108\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R \u0010>\u001a\b\u0012\u0004\u0012\u00020\u000b0=8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR(\u0010B\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bB\u0010C\u0012\u0004\bG\u0010\r\u001a\u0004\bD\u0010\n\"\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010CR\u001c\u0010I\u001a\u00020.8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bI\u0010JR\u001e\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bL\u0010MR\u001a\u0010O\u001a\u00020N8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "Landroid/content/Context;", "context", "Landroidx/compose/foundation/OverscrollConfiguration;", "overscrollConfig", "<init>", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "", "stopOverscrollAnimation", "()Z", "", "animateToRelease", "()V", "Landroidx/compose/ui/geometry/Offset;", "delta", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "releaseOppositeOverscroll", "scroll", "", "pullTop-k-4lQ0M", "(J)F", "pullTop", "pullBottom-k-4lQ0M", "pullBottom", "pullLeft-k-4lQ0M", "pullLeft", "pullRight-k-4lQ0M", "pullRight", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "source", "Lkotlin/Function1;", "performScroll", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToScroll", "Landroidx/compose/ui/unit/Velocity;", "velocity", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "performFling", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToFling", "Landroidx/compose/ui/geometry/Size;", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "updateSize", "displacement-F1C5BW0$foundation_release", "()J", "displacement", "invalidateOverscroll$foundation_release", "invalidateOverscroll", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/EdgeEffectWrapper;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "Landroidx/compose/runtime/MutableState;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "invalidationEnabled", "Z", "getInvalidationEnabled$foundation_release", "setInvalidationEnabled$foundation_release", "(Z)V", "getInvalidationEnabled$foundation_release$annotations", "scrollCycleInProgress", "containerSize", "J", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "Landroidx/compose/ui/Modifier;", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "isInProgress", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    private long containerSize;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private PointerId pointerId;
    private Offset pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private boolean scrollCycleInProgress;

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfiguration) {
        Modifier drawGlowOverscrollModifier;
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m996toArgb8_81llA(overscrollConfiguration.getGlowColor()));
        this.edgeEffectWrapper = edgeEffectWrapper;
        Unit unit = Unit.INSTANCE;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(unit, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m884getZeroNHjbRc();
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, unit, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null));
        if (Build.VERSION.SDK_INT >= 31) {
            drawGlowOverscrollModifier = new DrawStretchOverscrollModifier(this, edgeEffectWrapper, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("overscroll");
                    inspectorInfo.setValue(this.this$0);
                }
            } : InspectableValueKt.getNoInspectorInfo());
        } else {
            drawGlowOverscrollModifier = new DrawGlowOverscrollModifier(this, edgeEffectWrapper, overscrollConfiguration, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("overscroll");
                    inspectorInfo.setValue(this.this$0);
                }
            } : InspectableValueKt.getNoInspectorInfo());
        }
        this.effectModifier = modifierPointerInput.then(drawGlowOverscrollModifier);
    }

    public final MutableState<Unit> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011b A[ADDED_TO_REGION] */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo162applyToScrollRhakbz0(long r11, int r13, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset> r14) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo162applyToScrollRhakbz0(long, int, kotlin.jvm.functions.Function1):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo161applyToFlingBMRW4eQ(long r11, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity>, ? extends java.lang.Object> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo161applyToFlingBMRW4eQ(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect2) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect3) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        return (edgeEffect4 == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect4) == 0.0f) ? false : true;
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        if (this.edgeEffectWrapper.isLeftStretched()) {
            m157pullLeftk4lQ0M(Offset.INSTANCE.m854getZeroF1C5BW0());
            z = true;
        } else {
            z = false;
        }
        if (this.edgeEffectWrapper.isRightStretched()) {
            m158pullRightk4lQ0M(Offset.INSTANCE.m854getZeroF1C5BW0());
            z = true;
        }
        if (this.edgeEffectWrapper.isTopStretched()) {
            m159pullTopk4lQ0M(Offset.INSTANCE.m854getZeroF1C5BW0());
            z = true;
        }
        if (!this.edgeEffectWrapper.isBottomStretched()) {
            return z;
        }
        m156pullBottomk4lQ0M(Offset.INSTANCE.m854getZeroF1C5BW0());
        return true;
    }

    /* renamed from: updateSize-uvyYCjk$foundation_release, reason: not valid java name */
    public final void m164updateSizeuvyYCjk$foundation_release(long size) {
        boolean zM875equalsimpl0 = Size.m875equalsimpl0(this.containerSize, Size.INSTANCE.m884getZeroNHjbRc());
        boolean zM875equalsimpl02 = Size.m875equalsimpl0(size, this.containerSize);
        this.containerSize = size;
        if (!zM875equalsimpl02) {
            this.edgeEffectWrapper.m181setSizeozmzZPI(IntSizeKt.IntSize(MathKt.roundToInt(Size.m878getWidthimpl(size)), MathKt.roundToInt(Size.m876getHeightimpl(size))));
        }
        if (zM875equalsimpl0 || zM875equalsimpl02) {
            return;
        }
        invalidateOverscroll$foundation_release();
        animateToRelease();
    }

    /* renamed from: displacement-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m163displacementF1C5BW0$foundation_release() {
        Offset offset = this.pointerPosition;
        long packedValue = offset != null ? offset.getPackedValue() : SizeKt.m885getCenteruvyYCjk(this.containerSize);
        return OffsetKt.Offset(Offset.m842getXimpl(packedValue) / Size.m878getWidthimpl(this.containerSize), Offset.m843getYimpl(packedValue) / Size.m876getHeightimpl(this.containerSize));
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    private final void animateToRelease() {
        boolean zIsFinished;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = edgeEffect.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished = edgeEffect2.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished = edgeEffect3.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished = edgeEffect4.isFinished() || zIsFinished;
        }
        if (zIsFinished) {
            invalidateOverscroll$foundation_release();
        }
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m160releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean z;
        boolean z2 = true;
        if (!this.edgeEffectWrapper.isLeftAnimating() || Offset.m842getXimpl(delta) >= 0.0f) {
            z = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Offset.m842getXimpl(delta));
            z = !this.edgeEffectWrapper.isLeftAnimating();
        }
        if (this.edgeEffectWrapper.isRightAnimating() && Offset.m842getXimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Offset.m842getXimpl(delta));
            z = z || !this.edgeEffectWrapper.isRightAnimating();
        }
        if (this.edgeEffectWrapper.isTopAnimating() && Offset.m843getYimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Offset.m843getYimpl(delta));
            z = z || !this.edgeEffectWrapper.isTopAnimating();
        }
        if (!this.edgeEffectWrapper.isBottomAnimating() || Offset.m843getYimpl(delta) <= 0.0f) {
            return z;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Offset.m843getYimpl(delta));
        if (!z && this.edgeEffectWrapper.isBottomAnimating()) {
            z2 = false;
        }
        return z2;
    }

    /* renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m159pullTopk4lQ0M(long scroll) {
        float fM842getXimpl = Offset.m842getXimpl(m163displacementF1C5BW0$foundation_release());
        float fM843getYimpl = Offset.m843getYimpl(scroll) / Size.m876getHeightimpl(this.containerSize);
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateTopEffect) == 0.0f ? edgeEffectCompat.onPullDistanceCompat(orCreateTopEffect, fM843getYimpl, fM842getXimpl) * Size.m876getHeightimpl(this.containerSize) : Offset.m843getYimpl(scroll);
    }

    /* renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m156pullBottomk4lQ0M(long scroll) {
        float fM842getXimpl = Offset.m842getXimpl(m163displacementF1C5BW0$foundation_release());
        float fM843getYimpl = Offset.m843getYimpl(scroll) / Size.m876getHeightimpl(this.containerSize);
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateBottomEffect) == 0.0f ? (-edgeEffectCompat.onPullDistanceCompat(orCreateBottomEffect, -fM843getYimpl, 1 - fM842getXimpl)) * Size.m876getHeightimpl(this.containerSize) : Offset.m843getYimpl(scroll);
    }

    /* renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m157pullLeftk4lQ0M(long scroll) {
        float fM843getYimpl = Offset.m843getYimpl(m163displacementF1C5BW0$foundation_release());
        float fM842getXimpl = Offset.m842getXimpl(scroll) / Size.m878getWidthimpl(this.containerSize);
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateLeftEffect) == 0.0f ? edgeEffectCompat.onPullDistanceCompat(orCreateLeftEffect, fM842getXimpl, 1 - fM843getYimpl) * Size.m878getWidthimpl(this.containerSize) : Offset.m842getXimpl(scroll);
    }

    /* renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m158pullRightk4lQ0M(long scroll) {
        float fM843getYimpl = Offset.m843getYimpl(m163displacementF1C5BW0$foundation_release());
        float fM842getXimpl = Offset.m842getXimpl(scroll) / Size.m878getWidthimpl(this.containerSize);
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateRightEffect) == 0.0f ? (-edgeEffectCompat.onPullDistanceCompat(orCreateRightEffect, -fM842getXimpl, fM843getYimpl)) * Size.m878getWidthimpl(this.containerSize) : Offset.m842getXimpl(scroll);
    }
}
