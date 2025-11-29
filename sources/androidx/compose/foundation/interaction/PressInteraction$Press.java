package androidx.compose.foundation.interaction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PressInteraction.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"androidx/compose/foundation/interaction/PressInteraction$Press", "", "Landroidx/compose/ui/geometry/Offset;", "pressPosition", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getPressPosition-F1C5BW0", "()J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PressInteraction$Press implements Interaction {
    private final long pressPosition;

    public /* synthetic */ PressInteraction$Press(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    private PressInteraction$Press(long j) {
        this.pressPosition = j;
    }

    /* renamed from: getPressPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPressPosition() {
        return this.pressPosition;
    }
}
