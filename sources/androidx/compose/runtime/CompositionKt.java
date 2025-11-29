package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Composition.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0005\u001a\u00020\u00042\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\b\u001a\u00020\u00072\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0010\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0013\"\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\" \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/CompositionContext;", "parent", "Landroidx/compose/runtime/Composition;", "Composition", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;)Landroidx/compose/runtime/Composition;", "Landroidx/compose/runtime/ReusableComposition;", "ReusableComposition", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;)Landroidx/compose/runtime/ReusableComposition;", "T", "", "", "a", "b", "", "swap", "(Ljava/util/List;II)V", "Landroidx/collection/MutableIntList;", "(Landroidx/collection/MutableIntList;II)V", "", "PendingApplyNoModifications", "Ljava/lang/Object;", "Landroidx/compose/runtime/CompositionServiceKey;", "Landroidx/compose/runtime/CompositionImpl;", "CompositionImplServiceKey", "Landroidx/compose/runtime/CompositionServiceKey;", "getCompositionImplServiceKey", "()Landroidx/compose/runtime/CompositionServiceKey;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionKt {
    private static final Object PendingApplyNoModifications = new Object();
    private static final CompositionServiceKey<CompositionImpl> CompositionImplServiceKey = new CompositionServiceKey<CompositionImpl>() { // from class: androidx.compose.runtime.CompositionKt$CompositionImplServiceKey$1
    };

    public static final Composition Composition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier, null, 4, null);
    }

    public static final ReusableComposition ReusableComposition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> void swap(List<T> list, int i, int i2) {
        T t = list.get(i);
        list.set(i, list.get(i2));
        list.set(i2, t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void swap(MutableIntList mutableIntList, int i, int i2) {
        int i3 = mutableIntList.get(i);
        mutableIntList.set(i, mutableIntList.get(i2));
        mutableIntList.set(i2, i3);
    }
}
