package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;

/* compiled from: Transition.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0010¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0010¢\u0006\u0004\b\f\u0010\rR+\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0005R+\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00008V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0005¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/core/MutableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "<init>", "(Ljava/lang/Object;)V", "Landroidx/compose/animation/core/Transition;", "transition", "", "transitionConfigured$animation_core_release", "(Landroidx/compose/animation/core/Transition;)V", "transitionConfigured", "transitionRemoved$animation_core_release", "()V", "transitionRemoved", "<set-?>", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core_release", "currentState", "targetState$delegate", "getTargetState", "setTargetState", "targetState", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableTransitionState<S> extends TransitionState<S> {

    /* renamed from: currentState$delegate, reason: from kotlin metadata */
    private final MutableState currentState;

    /* renamed from: targetState$delegate, reason: from kotlin metadata */
    private final MutableState targetState;

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionConfigured$animation_core_release(Transition<S> transition) {
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionRemoved$animation_core_release() {
    }

    public MutableTransitionState(S s) {
        super(null);
        this.currentState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, null, 2, null);
        this.targetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, null, 2, null);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getCurrentState() {
        return (S) this.currentState.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setCurrentState$animation_core_release(S s) {
        this.currentState.setValue(s);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getTargetState() {
        return (S) this.targetState.getValue();
    }
}
