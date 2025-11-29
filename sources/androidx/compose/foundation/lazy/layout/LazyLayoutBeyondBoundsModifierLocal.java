package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 12\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0002:\u00011B/\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0012\u001a\u00020\u0007*\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u001b\u001a\u00020\u0007*\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001d\u001a\u00020\u0007*\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0011J8\u0010$\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010%R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010&R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010'R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010(R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010)R\u001c\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "beyondBoundsInfo", "", "reverseLayout", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;)V", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "isForward-4vf7U8o", "(I)Z", "isForward", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "currentInterval", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "addNextInterval", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Z", "hasMoreContent", "isOppositeToOrientation-4vf7U8o", "isOppositeToOrientation", "T", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "block", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "layout", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "Z", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/foundation/gestures/Orientation;", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "key", "getValue", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {
    private static final LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1 emptyBeyondBoundsScope = new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1
        private final boolean hasMoreContent;

        @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
        public boolean getHasMoreContent() {
            return this.hasMoreContent;
        }
    };
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final LayoutDirection layoutDirection;
    private final Orientation orientation;
    private final boolean reverseLayout;
    private final LazyLayoutBeyondBoundsState state;

    /* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public BeyondBoundsLayout getValue() {
        return this;
    }

    public LazyLayoutBeyondBoundsModifierLocal(LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, boolean z, LayoutDirection layoutDirection, Orientation orientation) {
        this.state = lazyLayoutBeyondBoundsState;
        this.beyondBoundsInfo = lazyLayoutBeyondBoundsInfo;
        this.reverseLayout = z;
        this.layoutDirection = layoutDirection;
        this.orientation = orientation;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    @Override // androidx.compose.ui.layout.BeyondBoundsLayout
    /* renamed from: layout-o7g1Pn8, reason: not valid java name */
    public <T> T mo368layouto7g1Pn8(final int direction, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        int firstPlacedIndex;
        if (this.state.getItemCount() <= 0 || !this.state.getHasVisibleItems()) {
            return block.invoke(emptyBeyondBoundsScope);
        }
        if (m366isForward4vf7U8o(direction)) {
            firstPlacedIndex = this.state.getLastPlacedIndex();
        } else {
            firstPlacedIndex = this.state.getFirstPlacedIndex();
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = (T) this.beyondBoundsInfo.addInterval(firstPlacedIndex, firstPlacedIndex);
        T tInvoke = null;
        while (tInvoke == null && m365hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element, direction)) {
            T t = (T) m364addNextIntervalFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element, direction);
            this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element);
            ref$ObjectRef.element = t;
            this.state.remeasure();
            tInvoke = block.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                public boolean getHasMoreContent() {
                    return this.this$0.m365hasMoreContentFR3nfPY(ref$ObjectRef.element, direction);
                }
            });
        }
        this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element);
        this.state.remeasure();
        return tInvoke;
    }

    /* renamed from: isForward-4vf7U8o, reason: not valid java name */
    private final boolean m366isForward4vf7U8o(int i) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.INSTANCE;
        if (BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1406getBeforehoxUOeE())) {
            return false;
        }
        if (!BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1405getAfterhoxUOeE())) {
            if (BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1404getAbovehoxUOeE())) {
                return this.reverseLayout;
            }
            if (BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1407getBelowhoxUOeE())) {
                if (this.reverseLayout) {
                    return false;
                }
            } else if (BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1408getLefthoxUOeE())) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
                if (i2 == 1) {
                    return this.reverseLayout;
                }
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.reverseLayout) {
                    return false;
                }
            } else {
                if (!BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1409getRighthoxUOeE())) {
                    LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
                    throw new KotlinNothingValueException();
                }
                int i3 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        return this.reverseLayout;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (this.reverseLayout) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: addNextInterval-FR3nfPY, reason: not valid java name */
    private final LazyLayoutBeyondBoundsInfo.Interval m364addNextIntervalFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval currentInterval, int direction) {
        int start = currentInterval.getStart();
        int end = currentInterval.getEnd();
        if (m366isForward4vf7U8o(direction)) {
            end++;
        } else {
            start--;
        }
        return this.beyondBoundsInfo.addInterval(start, end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m365hasMoreContentFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval interval, int i) {
        if (m367isOppositeToOrientation4vf7U8o(i)) {
            return false;
        }
        if (m366isForward4vf7U8o(i)) {
            if (interval.getEnd() >= this.state.getItemCount() - 1) {
                return false;
            }
        } else if (interval.getStart() <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: isOppositeToOrientation-4vf7U8o, reason: not valid java name */
    private final boolean m367isOppositeToOrientation4vf7U8o(int i) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.INSTANCE;
        if (!(BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1404getAbovehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1407getBelowhoxUOeE()))) {
            if (!(BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1408getLefthoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1409getRighthoxUOeE()))) {
                if (!(BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1406getBeforehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m1403equalsimpl0(i, companion.m1405getAfterhoxUOeE()))) {
                    LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
                    throw new KotlinNothingValueException();
                }
            } else if (this.orientation == Orientation.Vertical) {
                return true;
            }
        } else if (this.orientation == Orientation.Horizontal) {
            return true;
        }
        return false;
    }
}
