package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#BA\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001fR&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010 R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010!R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\"¨\u0006$"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/WrapContentNode;", "Landroidx/compose/foundation/layout/Direction;", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "", "unbounded", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "alignmentCallback", "", "align", "", "inspectorName", "<init>", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;Ljava/lang/Object;Ljava/lang/String;)V", "create", "()Landroidx/compose/foundation/layout/WrapContentNode;", "node", "", "update", "(Landroidx/compose/foundation/layout/WrapContentNode;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroidx/compose/foundation/layout/Direction;", "Z", "Lkotlin/jvm/functions/Function2;", "Ljava/lang/Object;", "Ljava/lang/String;", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class WrapContentElement extends ModifierNodeElement<WrapContentNode> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Object align;
    private final Function2<IntSize, LayoutDirection, IntOffset> alignmentCallback;
    private final Direction direction;
    private final String inspectorName;
    private final boolean unbounded;

    /* JADX WARN: Multi-variable type inference failed */
    public WrapContentElement(Direction direction, boolean z, Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2, Object obj, String str) {
        this.direction = direction;
        this.unbounded = z;
        this.alignmentCallback = function2;
        this.align = obj;
        this.inspectorName = str;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public WrapContentNode getNode() {
        return new WrapContentNode(this.direction, this.unbounded, this.alignmentCallback);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(WrapContentNode node) {
        node.setDirection(this.direction);
        node.setUnbounded(this.unbounded);
        node.setAlignmentCallback(this.alignmentCallback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || WrapContentElement.class != other.getClass()) {
            return false;
        }
        WrapContentElement wrapContentElement = (WrapContentElement) other;
        return this.direction == wrapContentElement.direction && this.unbounded == wrapContentElement.unbounded && Intrinsics.areEqual(this.align, wrapContentElement.align);
    }

    public int hashCode() {
        return (((this.direction.hashCode() * 31) + Boolean.hashCode(this.unbounded)) * 31) + this.align.hashCode();
    }

    /* compiled from: Size.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentElement$Companion;", "", "()V", "height", "Landroidx/compose/foundation/layout/WrapContentElement;", "align", "Landroidx/compose/ui/Alignment$Vertical;", "unbounded", "", "size", "Landroidx/compose/ui/Alignment;", "width", "Landroidx/compose/ui/Alignment$Horizontal;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WrapContentElement width(final Alignment.Horizontal align, boolean unbounded) {
            return new WrapContentElement(Direction.Horizontal, unbounded, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$width$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize, LayoutDirection layoutDirection) {
                    return IntOffset.m2132boximpl(m348invoke5SAbXVA(intSize.getPackedValue(), layoutDirection));
                }

                /* renamed from: invoke-5SAbXVA, reason: not valid java name */
                public final long m348invoke5SAbXVA(long j, LayoutDirection layoutDirection) {
                    return IntOffsetKt.IntOffset(align.align(0, IntSize.m2156getWidthimpl(j), layoutDirection), 0);
                }
            }, align, "wrapContentWidth");
        }

        public final WrapContentElement height(final Alignment.Vertical align, boolean unbounded) {
            return new WrapContentElement(Direction.Vertical, unbounded, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$height$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize, LayoutDirection layoutDirection) {
                    return IntOffset.m2132boximpl(m346invoke5SAbXVA(intSize.getPackedValue(), layoutDirection));
                }

                /* renamed from: invoke-5SAbXVA, reason: not valid java name */
                public final long m346invoke5SAbXVA(long j, LayoutDirection layoutDirection) {
                    return IntOffsetKt.IntOffset(0, align.align(0, IntSize.m2155getHeightimpl(j)));
                }
            }, align, "wrapContentHeight");
        }

        public final WrapContentElement size(final Alignment align, boolean unbounded) {
            return new WrapContentElement(Direction.Both, unbounded, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$size$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize, LayoutDirection layoutDirection) {
                    return IntOffset.m2132boximpl(m347invoke5SAbXVA(intSize.getPackedValue(), layoutDirection));
                }

                /* renamed from: invoke-5SAbXVA, reason: not valid java name */
                public final long m347invoke5SAbXVA(long j, LayoutDirection layoutDirection) {
                    return align.mo752alignKFBX0sM(IntSize.INSTANCE.m2160getZeroYbymL2g(), j, layoutDirection);
                }
            }, align, "wrapContentSize");
        }
    }
}
