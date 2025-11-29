package androidx.compose.foundation.interaction;

import kotlin.Metadata;

/* compiled from: PressInteraction.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/compose/foundation/interaction/PressInteraction$Release", "", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "press", "<init>", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "getPress", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PressInteraction$Release implements Interaction {
    private final PressInteraction$Press press;

    public PressInteraction$Release(PressInteraction$Press pressInteraction$Press) {
        this.press = pressInteraction$Press;
    }

    public final PressInteraction$Press getPress() {
        return this.press;
    }
}
