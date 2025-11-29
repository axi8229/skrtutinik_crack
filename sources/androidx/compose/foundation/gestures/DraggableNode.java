package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.pjsip.pjsua2.pjsip_status_code;

/* compiled from: Draggable.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B¡\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012(\u0010\u0014\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e\u0012(\u0010\u0016\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001d\u001a\u00020\u001a*\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u0010*\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ@\u0010\"\u001a\u00020\u00122.\u0010!\u001a*\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001fH\u0096@¢\u0006\u0004\b\"\u0010#J\u001a\u0010\u0014\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010&J\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010)J§\u0001\u0010*\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00062(\u0010\u0014\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e2(\u0010\u0016\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b*\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010+R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010,R\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010-R8\u0010\u0014\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010.R8\u0010\u0016\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010.R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010-\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"Landroidx/compose/foundation/gestures/DraggableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/foundation/gestures/DraggableState;", "state", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "canDrag", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "startDragImmediately", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "onDragStarted", "", "onDragStopped", "reverseDirection", "<init>", "(Landroidx/compose/foundation/gestures/DraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "Landroidx/compose/ui/unit/Velocity;", "reverseIfNeeded-AH228Gc", "(J)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "forEachDelta", "drag", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "velocity", "onDragStopped-TH1AsA0", "()Z", "update", "Landroidx/compose/foundation/gestures/DraggableState;", "Landroidx/compose/foundation/gestures/Orientation;", "Z", "Lkotlin/jvm/functions/Function3;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DraggableNode extends DragGestureNode {
    private Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted;
    private Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped;
    private Orientation orientation;
    private boolean reverseDirection;
    private boolean startDragImmediately;
    private DraggableState state;

    public DraggableNode(DraggableState draggableState, Function1<? super PointerInputChange, Boolean> function1, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z3) {
        super(function1, z, mutableInteractionSource, orientation);
        this.state = draggableState;
        this.orientation = orientation;
        this.startDragImmediately = z2;
        this.onDragStarted = function3;
        this.onDragStopped = function32;
        this.reverseDirection = z3;
    }

    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$drag$2", f = "Draggable.kt", l = {pjsip_status_code.PJSIP_SC_USE_PROXY}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.DraggableNode$drag$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DraggableNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, DraggableNode draggableNode, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$forEachDelta = function2;
            this.this$0 = draggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$forEachDelta, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final DragScope dragScope = (DragScope) this.L$0;
                Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> function2 = this.$forEachDelta;
                final DraggableNode draggableNode = this.this$0;
                Function1<DragEvent.DragDelta, Unit> function1 = new Function1<DragEvent.DragDelta, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableNode.drag.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DragEvent.DragDelta dragDelta) {
                        invoke2(dragDelta);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DragEvent.DragDelta dragDelta) {
                        dragScope.dragBy(DraggableKt.m238toFloat3MmeM6k(draggableNode.m245reverseIfNeededMKHz9U(dragDelta.getDelta()), draggableNode.orientation));
                    }
                };
                this.label = 1;
                if (function2.invoke(function1, this) == coroutine_suspended) {
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

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objDrag = this.state.drag(MutatePriority.UserInput, new AnonymousClass2(function2, this, null), continuation);
        return objDrag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStarted-k-4lQ0M */
    public void mo231onDragStartedk4lQ0M(long startedPosition) {
        if (!getIsAttached() || Intrinsics.areEqual(this.onDragStarted, DraggableKt.NoOpOnDragStarted)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new DraggableNode$onDragStarted$1(this, startedPosition, null), 3, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStopped-TH1AsA0 */
    public void mo232onDragStoppedTH1AsA0(long velocity) {
        if (!getIsAttached() || Intrinsics.areEqual(this.onDragStopped, DraggableKt.NoOpOnDragStopped)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new DraggableNode$onDragStopped$1(this, velocity, null), 3, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: startDragImmediately, reason: from getter */
    public boolean getStartDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(DraggableState state, Function1<? super PointerInputChange, Boolean> canDrag, Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean reverseDirection) {
        boolean z;
        boolean z2;
        Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3;
        if (Intrinsics.areEqual(this.state, state)) {
            z = false;
        } else {
            this.state = state;
            z = true;
        }
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z = true;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
            function3 = onDragStarted;
            z2 = true;
        } else {
            z2 = z;
            function3 = onDragStarted;
        }
        this.onDragStarted = function3;
        this.onDragStopped = onDragStopped;
        this.startDragImmediately = startDragImmediately;
        update(canDrag, enabled, interactionSource, orientation, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    public final long m244reverseIfNeededAH228Gc(long j) {
        return Velocity.m2197timesadjELrA(j, this.reverseDirection ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m245reverseIfNeededMKHz9U(long j) {
        return Offset.m848timestuRUvjQ(j, this.reverseDirection ? -1.0f : 1.0f);
    }
}
