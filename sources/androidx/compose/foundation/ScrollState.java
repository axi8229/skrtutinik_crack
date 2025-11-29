package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: Scroll.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J<\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R+\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00028F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0005R+\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00028F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u0005R\u001a\u0010 \u001a\u00020\u001f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0016R\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00102\u001a\u00020*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R$\u00106\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00028F@@X\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u0005R\u0014\u00107\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010.¨\u00069"}, d2 = {"Landroidx/compose/foundation/ScrollState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "", "initial", "<init>", "(I)V", "Landroidx/compose/foundation/MutatePriority;", "scrollPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "", "block", "scroll", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "delta", "dispatchRawDelta", "(F)F", "<set-?>", "value$delegate", "Landroidx/compose/runtime/MutableIntState;", "getValue", "()I", "setValue", AppMeasurementSdk.ConditionalUserProperty.VALUE, "viewportSize$delegate", "getViewportSize", "setViewportSize$foundation_release", "viewportSize", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/runtime/MutableIntState;", "_maxValueState", "accumulator", "F", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "", "canScrollForward$delegate", "Landroidx/compose/runtime/State;", "getCanScrollForward", "()Z", "canScrollForward", "canScrollBackward$delegate", "getCanScrollBackward", "canScrollBackward", "newMax", "getMaxValue", "setMaxValue$foundation_release", "maxValue", "isScrollInProgress", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollState implements ScrollableState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<ScrollState, ?> Saver = SaverKt.Saver(new Function2<SaverScope, ScrollState, Integer>() { // from class: androidx.compose.foundation.ScrollState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final Integer invoke(SaverScope saverScope, ScrollState scrollState) {
            return Integer.valueOf(scrollState.getValue());
        }
    }, new Function1<Integer, ScrollState>() { // from class: androidx.compose.foundation.ScrollState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ScrollState invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final ScrollState invoke(int i) {
            return new ScrollState(i);
        }
    });
    private float accumulator;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableIntState value;

    /* renamed from: viewportSize$delegate, reason: from kotlin metadata */
    private final MutableIntState viewportSize = SnapshotIntStateKt.mutableIntStateOf(0);
    private final MutableInteractionSource internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
    private MutableIntState _maxValueState = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);
    private final ScrollableState scrollableState = ScrollableStateKt.ScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.ScrollState$scrollableState$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float f) {
            return invoke(f.floatValue());
        }

        public final Float invoke(float f) {
            float value = this.this$0.getValue() + f + this.this$0.accumulator;
            float fCoerceIn = RangesKt.coerceIn(value, 0.0f, this.this$0.getMaxValue());
            boolean z = value == fCoerceIn;
            float value2 = fCoerceIn - this.this$0.getValue();
            int iRound = Math.round(value2);
            ScrollState scrollState = this.this$0;
            scrollState.setValue(scrollState.getValue() + iRound);
            this.this$0.accumulator = value2 - iRound;
            if (!z) {
                f = value2;
            }
            return Float.valueOf(f);
        }
    });

    /* renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final State canScrollForward = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.ScrollState$canScrollForward$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(this.this$0.getValue() < this.this$0.getMaxValue());
        }
    });

    /* renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final State canScrollBackward = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.ScrollState$canScrollBackward$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(this.this$0.getValue() > 0);
        }
    });

    public ScrollState(int i) {
        this.value = SnapshotIntStateKt.mutableIntStateOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setValue(int i) {
        this.value.setIntValue(i);
    }

    public final int getValue() {
        return this.value.getIntValue();
    }

    public final int getMaxValue() {
        return this._maxValueState.getIntValue();
    }

    public final void setMaxValue$foundation_release(int i) {
        this._maxValueState.setIntValue(i);
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (getValue() > i) {
                setValue(i);
            }
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final void setViewportSize$foundation_release(int i) {
        this.viewportSize.setIntValue(i);
    }

    /* renamed from: getInternalInteractionSource$foundation_release, reason: from getter */
    public final MutableInteractionSource getInternalInteractionSource() {
        return this.internalInteractionSource;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, function2, continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward.getValue()).booleanValue();
    }

    /* compiled from: Scroll.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/ScrollState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/ScrollState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<ScrollState, ?> getSaver() {
            return ScrollState.Saver;
        }
    }
}
