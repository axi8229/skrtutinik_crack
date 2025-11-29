package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationModifier.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R+\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/compose/animation/SizeAnimationModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SizeAnimationModifierNode;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "animationSpec", "Landroidx/compose/ui/Alignment;", "alignment", "Lkotlin/Function2;", "", "finishedListener", "<init>", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;)V", "create", "()Landroidx/compose/animation/SizeAnimationModifierNode;", "node", "update", "(Landroidx/compose/animation/SizeAnimationModifierNode;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/Alignment;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "Lkotlin/jvm/functions/Function2;", "getFinishedListener", "()Lkotlin/jvm/functions/Function2;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class SizeAnimationModifierElement extends ModifierNodeElement<SizeAnimationModifierNode> {
    private final Alignment alignment;
    private final FiniteAnimationSpec<IntSize> animationSpec;
    private final Function2<IntSize, IntSize, Unit> finishedListener;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SizeAnimationModifierElement)) {
            return false;
        }
        SizeAnimationModifierElement sizeAnimationModifierElement = (SizeAnimationModifierElement) other;
        return Intrinsics.areEqual(this.animationSpec, sizeAnimationModifierElement.animationSpec) && Intrinsics.areEqual(this.alignment, sizeAnimationModifierElement.alignment) && Intrinsics.areEqual(this.finishedListener, sizeAnimationModifierElement.finishedListener);
    }

    public int hashCode() {
        int iHashCode = ((this.animationSpec.hashCode() * 31) + this.alignment.hashCode()) * 31;
        Function2<IntSize, IntSize, Unit> function2 = this.finishedListener;
        return iHashCode + (function2 == null ? 0 : function2.hashCode());
    }

    public String toString() {
        return "SizeAnimationModifierElement(animationSpec=" + this.animationSpec + ", alignment=" + this.alignment + ", finishedListener=" + this.finishedListener + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SizeAnimationModifierElement(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, Function2<? super IntSize, ? super IntSize, Unit> function2) {
        this.animationSpec = finiteAnimationSpec;
        this.alignment = alignment;
        this.finishedListener = function2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public SizeAnimationModifierNode getNode() {
        return new SizeAnimationModifierNode(this.animationSpec, this.alignment, this.finishedListener);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SizeAnimationModifierNode node) {
        node.setAnimationSpec(this.animationSpec);
        node.setListener(this.finishedListener);
        node.setAlignment(this.alignment);
    }
}
