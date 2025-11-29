package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: NodeChain.kt */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0012\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0007*\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e*\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/Modifier$Element;", "prev", "next", "", "actionForModifiers", "(Landroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Element;)I", "Landroidx/compose/ui/Modifier$Node;", "T", "Landroidx/compose/ui/node/ModifierNodeElement;", "node", "", "updateUnsafe", "(Landroidx/compose/ui/node/ModifierNodeElement;Landroidx/compose/ui/Modifier$Node;)V", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/collection/MutableVector;", "result", "fillVector", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/collection/MutableVector;)Landroidx/compose/runtime/collection/MutableVector;", "androidx/compose/ui/node/NodeChainKt$SentinelHead$1", "SentinelHead", "Landroidx/compose/ui/node/NodeChainKt$SentinelHead$1;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NodeChainKt {
    private static final NodeChainKt$SentinelHead$1 SentinelHead;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.Modifier$Node, androidx.compose.ui.node.NodeChainKt$SentinelHead$1] */
    static {
        ?? r0 = new Modifier.Node() { // from class: androidx.compose.ui.node.NodeChainKt$SentinelHead$1
            public String toString() {
                return "<Head>";
            }
        };
        r0.setAggregateChildKindSet$ui_release(-1);
        SentinelHead = r0;
    }

    public static final int actionForModifiers(Modifier.Element element, Modifier.Element element2) {
        if (Intrinsics.areEqual(element, element2)) {
            return 2;
        }
        return Actual_jvmKt.areObjectsOfSameType(element, element2) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Modifier.Node> void updateUnsafe(ModifierNodeElement<T> modifierNodeElement, Modifier.Node node) {
        Intrinsics.checkNotNull(node, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        modifierNodeElement.update(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final MutableVector<Modifier.Element> fillVector(Modifier modifier, final MutableVector<Modifier.Element> mutableVector) {
        MutableVector mutableVector2 = new MutableVector(new Modifier[RangesKt.coerceAtLeast(mutableVector.getSize(), 16)], 0);
        mutableVector2.add(modifier);
        Function1<Modifier.Element, Boolean> function1 = null;
        while (mutableVector2.isNotEmpty()) {
            Modifier modifier2 = (Modifier) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if (modifier2 instanceof CombinedModifier) {
                CombinedModifier combinedModifier = (CombinedModifier) modifier2;
                mutableVector2.add(combinedModifier.getInner());
                mutableVector2.add(combinedModifier.getOuter());
            } else if (modifier2 instanceof Modifier.Element) {
                mutableVector.add(modifier2);
            } else {
                if (function1 == null) {
                    function1 = new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.node.NodeChainKt.fillVector.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(Modifier.Element element) {
                            mutableVector.add(element);
                            return Boolean.TRUE;
                        }
                    };
                }
                modifier2.all(function1);
                function1 = function1;
            }
        }
        return mutableVector;
    }
}
