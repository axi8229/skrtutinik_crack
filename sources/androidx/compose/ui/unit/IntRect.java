package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IntRect.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0001/B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0018\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\u0013R \u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\u0018\u0012\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R \u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u0012\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001e\u0010\u0013R \u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010\u0018\u0012\u0004\b!\u0010\u001b\u001a\u0004\b \u0010\u0013R\u001a\u0010$\u001a\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001b\u001a\u0004\b\"\u0010\u0013R\u001a\u0010'\u001a\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u001b\u001a\u0004\b%\u0010\u0013R\u001a\u0010(\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u001b\u001a\u0004\b(\u0010)R\u0017\u0010.\u001a\u00020+8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b,\u0010-\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Landroidx/compose/ui/unit/IntRect;", "", "", "left", "top", "right", "bottom", "<init>", "(IIII)V", "translateX", "translateY", "translate", "(II)Landroidx/compose/ui/unit/IntRect;", "", "toString", "()Ljava/lang/String;", "copy", "(IIII)Landroidx/compose/ui/unit/IntRect;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getLeft", "getLeft$annotations", "()V", "getTop", "getTop$annotations", "getRight", "getRight$annotations", "getBottom", "getBottom$annotations", "getWidth", "getWidth$annotations", "width", "getHeight", "getHeight$annotations", "height", "isEmpty", "()Z", "isEmpty$annotations", "Landroidx/compose/ui/unit/IntOffset;", "getTopLeft-nOcc-ac", "()J", "topLeft", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class IntRect {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final IntRect Zero = new IntRect(0, 0, 0, 0);
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public static /* synthetic */ IntRect copy$default(IntRect intRect, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = intRect.left;
        }
        if ((i5 & 2) != 0) {
            i2 = intRect.top;
        }
        if ((i5 & 4) != 0) {
            i3 = intRect.right;
        }
        if ((i5 & 8) != 0) {
            i4 = intRect.bottom;
        }
        return intRect.copy(i, i2, i3, i4);
    }

    public final IntRect copy(int left, int top, int right, int bottom) {
        return new IntRect(left, top, right, bottom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntRect)) {
            return false;
        }
        IntRect intRect = (IntRect) other;
        return this.left == intRect.left && this.top == intRect.top && this.right == intRect.right && this.bottom == intRect.bottom;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.left) * 31) + Integer.hashCode(this.top)) * 31) + Integer.hashCode(this.right)) * 31) + Integer.hashCode(this.bottom);
    }

    public IntRect(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getBottom() {
        return this.bottom;
    }

    /* compiled from: IntRect.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/IntRect$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/unit/IntRect;", "Zero", "Landroidx/compose/ui/unit/IntRect;", "getZero", "()Landroidx/compose/ui/unit/IntRect;", "getZero$annotations", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IntRect getZero() {
            return IntRect.Zero;
        }
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final boolean isEmpty() {
        return this.left >= this.right || this.top >= this.bottom;
    }

    public final IntRect translate(int translateX, int translateY) {
        return new IntRect(this.left + translateX, this.top + translateY, this.right + translateX, this.bottom + translateY);
    }

    /* renamed from: getTopLeft-nOcc-ac, reason: not valid java name */
    public final long m2149getTopLeftnOccac() {
        return IntOffsetKt.IntOffset(this.left, this.top);
    }

    public String toString() {
        return "IntRect.fromLTRB(" + this.left + ", " + this.top + ", " + this.right + ", " + this.bottom + ')';
    }
}
