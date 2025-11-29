package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001M\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u0011*\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0017\u001a\u00020\u0011*\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u001a\u001a\u00020\u0010*\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u00020\u0010*\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0016J\u001b\u0010&\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0086@ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001b\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020!H\u0086@ø\u0001\u0001¢\u0006\u0004\b(\u0010%J\r\u0010*\u001a\u00020\n¢\u0006\u0004\b*\u0010+J>\u0010\u001e\u001a\u00020#2\b\b\u0002\u0010-\u001a\u00020,2\"\u00101\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020#00\u0012\u0006\u0012\u0004\u0018\u00010\u00010.H\u0086@¢\u0006\u0004\b\u001e\u00102J?\u00103\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\n¢\u0006\u0004\b5\u0010+J\u0016\u0010\u001a\u001a\u00020\u0010*\u00020!H\u0002ø\u0001\u0001¢\u0006\u0004\b6\u0010\u0019J\u0016\u00108\u001a\u00020!*\u00020!H\u0002ø\u0001\u0001¢\u0006\u0004\b7\u0010\u0016J\u001e\u00103\u001a\u00020!*\u00020!2\u0006\u00109\u001a\u00020\u0010H\u0002ø\u0001\u0001¢\u0006\u0004\b:\u0010;J&\u0010B\u001a\u00020\u0011*\u00020<2\u0006\u0010=\u001a\u00020\u00112\u0006\u0010?\u001a\u00020>H\u0002ø\u0001\u0001¢\u0006\u0004\b@\u0010AR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010CR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010DR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010ER\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010FR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010GR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010HR\u001c\u0010I\u001a\u00020>8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR \u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010+\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006U"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "Landroidx/compose/foundation/gestures/ScrollableState;", "scrollableState", "Landroidx/compose/foundation/OverscrollEffect;", "overscrollEffect", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "", "reverseDirection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "nestedScrollDispatcher", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "", "Landroidx/compose/ui/geometry/Offset;", "toOffset-tuRUvjQ", "(F)J", "toOffset", "singleAxisOffset-MK-Hz9U", "(J)J", "singleAxisOffset", "toFloat-k-4lQ0M", "(J)F", "toFloat", "reverseIfNeeded", "(F)F", "reverseIfNeeded-MK-Hz9U", "scroll", "performRawScroll-MK-Hz9U", "performRawScroll", "Landroidx/compose/ui/unit/Velocity;", "initialVelocity", "", "onDragStopped-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "available", "doFlingAnimation-QWom1Mo", "doFlingAnimation", "shouldScrollImmediately", "()Z", "Landroidx/compose/foundation/MutatePriority;", "scrollPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "block", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)Z", "isVertical", "toFloat-TH1AsA0", "singleAxisVelocity-AH228Gc", "singleAxisVelocity", "newValue", "update-QWom1Mo", "(JF)J", "Landroidx/compose/foundation/gestures/ScrollScope;", "delta", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "performScroll", "Landroidx/compose/foundation/gestures/ScrollableState;", "Landroidx/compose/foundation/OverscrollEffect;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "Landroidx/compose/foundation/gestures/Orientation;", "Z", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "latestScrollSource", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "nestedScrollScope", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "Lkotlin/Function1;", "performScrollForOverscroll", "Lkotlin/jvm/functions/Function1;", "getShouldDispatchOverscroll", "shouldDispatchOverscroll", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollingLogic {
    private FlingBehavior flingBehavior;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;
    private int latestScrollSource = NestedScrollSource.INSTANCE.m1313getUserInputWNlRxjI();
    private ScrollScope outerStateScope = ScrollableKt.NoOpScrollScope;
    private final ScrollingLogic$nestedScrollScope$1 nestedScrollScope = new NestedScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1
        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* renamed from: scrollBy-OzD1aCk */
        public long mo246scrollByOzD1aCk(long offset, int source) {
            return this.this$0.m267performScroll3eAAhYA(this.this$0.outerStateScope, offset, source);
        }

        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* renamed from: scrollByWithOverscroll-OzD1aCk */
        public long mo247scrollByWithOverscrollOzD1aCk(long offset, int source) {
            this.this$0.latestScrollSource = source;
            OverscrollEffect overscrollEffect = this.this$0.overscrollEffect;
            if (overscrollEffect == null || !this.this$0.getShouldDispatchOverscroll()) {
                return this.this$0.m267performScroll3eAAhYA(this.this$0.outerStateScope, offset, source);
            }
            return overscrollEffect.mo162applyToScrollRhakbz0(offset, this.this$0.latestScrollSource, this.this$0.performScrollForOverscroll);
        }
    };
    private final Function1<Offset, Offset> performScrollForOverscroll = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$performScrollForOverscroll$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
            return Offset.m833boximpl(m279invokeMKHz9U(offset.getPackedValue()));
        }

        /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
        public final long m279invokeMKHz9U(long j) {
            ScrollScope scrollScope = this.this$0.outerStateScope;
            ScrollingLogic scrollingLogic = this.this$0;
            return scrollingLogic.m267performScroll3eAAhYA(scrollScope, j, scrollingLogic.latestScrollSource);
        }
    };

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1] */
    public ScrollingLogic(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }

    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m277toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.INSTANCE.m854getZeroF1C5BW0();
        }
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    /* renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m275singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m836copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m836copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m276toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m842getXimpl(j) : Offset.m843getYimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m269toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m2192getXimpl(j) : Velocity.m2193getYimpl(j);
    }

    /* renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    private final long m268singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m2189copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m2189copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m270updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m2189copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m2189copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m274reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m848timestuRUvjQ(j, -1.0f) : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performScroll-3eAAhYA, reason: not valid java name */
    public final long m267performScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        long jM1309dispatchPreScrollOzD1aCk = this.nestedScrollDispatcher.m1309dispatchPreScrollOzD1aCk(j, i);
        long jM846minusMKHz9U = Offset.m846minusMKHz9U(j, jM1309dispatchPreScrollOzD1aCk);
        long jM274reverseIfNeededMKHz9U = m274reverseIfNeededMKHz9U(m277toOffsettuRUvjQ(scrollScope.scrollBy(m276toFloatk4lQ0M(m274reverseIfNeededMKHz9U(m275singleAxisOffsetMKHz9U(jM846minusMKHz9U))))));
        return Offset.m847plusMKHz9U(Offset.m847plusMKHz9U(jM1309dispatchPreScrollOzD1aCk, jM274reverseIfNeededMKHz9U), this.nestedScrollDispatcher.m1307dispatchPostScrollDzOQY0M(jM274reverseIfNeededMKHz9U, Offset.m846minusMKHz9U(jM846minusMKHz9U, jM274reverseIfNeededMKHz9U), i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m273performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m854getZeroF1C5BW0();
        }
        return m277toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m276toFloatk4lQ0M(scroll)))));
    }

    /* renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    public final Object m272onDragStoppedsFctU(long j, Continuation<? super Unit> continuation) {
        long jM268singleAxisVelocityAH228Gc = m268singleAxisVelocityAH228Gc(j);
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this, null);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null && getShouldDispatchOverscroll()) {
            Object objMo161applyToFlingBMRW4eQ = overscrollEffect.mo161applyToFlingBMRW4eQ(jM268singleAxisVelocityAH228Gc, scrollingLogic$onDragStopped$performFling$1, continuation);
            return objMo161applyToFlingBMRW4eQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo161applyToFlingBMRW4eQ : Unit.INSTANCE;
        }
        Object objInvoke = scrollingLogic$onDragStopped$performFling$1.invoke(Velocity.m2186boximpl(jM268singleAxisVelocityAH228Gc), continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m271doFlingAnimationQWom1Mo(long r12, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref$LongRef) r12
            kotlin.ResultKt.throwOnFailure(r14)
            goto L57
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r12
            androidx.compose.foundation.MutatePriority r2 = androidx.compose.foundation.MutatePriority.Default
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r10 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r9 = 0
            r4 = r10
            r5 = r11
            r6 = r14
            r7 = r12
            r4.<init>(r5, r6, r7, r9)
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r12 = r11.scroll(r2, r10, r0)
            if (r12 != r1) goto L56
            return r1
        L56:
            r12 = r14
        L57:
            long r12 = r12.element
            androidx.compose.ui.unit.Velocity r12 = androidx.compose.ui.unit.Velocity.m2186boximpl(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m271doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (!(overscrollEffect != null ? overscrollEffect.isInProgress() : false)) {
                return false;
            }
        }
        return true;
    }

    /* compiled from: Scrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$scroll$2", f = "Scrollable.kt", l = {804}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.ScrollingLogic$scroll$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<NestedScrollScope, Continuation<? super Unit>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = ScrollingLogic.this.new AnonymousClass2(this.$block, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScrollingLogic.this.outerStateScope = (ScrollScope) this.L$0;
                Function2<NestedScrollScope, Continuation<? super Unit>, Object> function2 = this.$block;
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = ScrollingLogic.this.nestedScrollScope;
                this.label = 1;
                if (function2.invoke(scrollingLogic$nestedScrollScope$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object scroll(MutatePriority mutatePriority, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, new AnonymousClass2(function2, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    public final boolean update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z;
        boolean z2 = true;
        if (Intrinsics.areEqual(this.scrollableState, scrollableState)) {
            z = false;
        } else {
            this.scrollableState = scrollableState;
            z = true;
        }
        this.overscrollEffect = overscrollEffect;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z = true;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
        } else {
            z2 = z;
        }
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return z2;
    }

    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }
}
