package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* compiled from: CornerSize.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u001a\u001a\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0005\u0010\b\" \u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "size", "Landroidx/compose/foundation/shape/CornerSize;", "CornerSize-0680j_4", "(F)Landroidx/compose/foundation/shape/CornerSize;", "CornerSize", "", "percent", "(I)Landroidx/compose/foundation/shape/CornerSize;", "ZeroCornerSize", "Landroidx/compose/foundation/shape/CornerSize;", "getZeroCornerSize", "()Landroidx/compose/foundation/shape/CornerSize;", "getZeroCornerSize$annotations", "()V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CornerSizeKt {
    private static final CornerSize ZeroCornerSize = new CornerSize() { // from class: androidx.compose.foundation.shape.CornerSizeKt$ZeroCornerSize$1
        @Override // androidx.compose.foundation.shape.CornerSize
        /* renamed from: toPx-TmRCtEA */
        public float mo397toPxTmRCtEA(long shapeSize, Density density) {
            return 0.0f;
        }

        public String toString() {
            return "ZeroCornerSize";
        }
    };

    /* renamed from: CornerSize-0680j_4, reason: not valid java name */
    public static final CornerSize m398CornerSize0680j_4(float f) {
        return new CornerSize(f, null);
    }

    public static final CornerSize CornerSize(int i) {
        return new CornerSize(i);
    }
}
