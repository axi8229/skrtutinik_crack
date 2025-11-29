package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnImpl.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000 \u00152\u00020\u0001:\u0006\u0016\u0015\u0017\u0018\u0019\u001aB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H ¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0005\u001b\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment;", "", "<init>", "()V", "", "size", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/layout/Placeable;", "placeable", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "(ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/layout/Placeable;I)I", "align", "calculateAlignmentLinePosition$foundation_layout_release", "(Landroidx/compose/ui/layout/Placeable;)Ljava/lang/Integer;", "calculateAlignmentLinePosition", "", "isRelative$foundation_layout_release", "()Z", "isRelative", "Companion", "CenterCrossAxisAlignment", "EndCrossAxisAlignment", "HorizontalCrossAxisAlignment", "StartCrossAxisAlignment", "VerticalCrossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment$CenterCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$EndCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$HorizontalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$StartCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$VerticalCrossAxisAlignment;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CrossAxisAlignment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CrossAxisAlignment Center = CenterCrossAxisAlignment.INSTANCE;
    private static final CrossAxisAlignment Start = StartCrossAxisAlignment.INSTANCE;
    private static final CrossAxisAlignment End = EndCrossAxisAlignment.INSTANCE;

    public /* synthetic */ CrossAxisAlignment(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine);

    public Integer calculateAlignmentLinePosition$foundation_layout_release(Placeable placeable) {
        return null;
    }

    public boolean isRelative$foundation_layout_release() {
        return false;
    }

    private CrossAxisAlignment() {
    }

    /* compiled from: RowColumnImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$Companion;", "", "<init>", "()V", "Landroidx/compose/ui/Alignment$Vertical;", "vertical", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "vertical$foundation_layout_release", "(Landroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontal", "horizontal$foundation_layout_release", "(Landroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CrossAxisAlignment vertical$foundation_layout_release(Alignment.Vertical vertical) {
            return new VerticalCrossAxisAlignment(vertical);
        }

        public final CrossAxisAlignment horizontal$foundation_layout_release(Alignment.Horizontal horizontal) {
            return new HorizontalCrossAxisAlignment(horizontal);
        }
    }

    /* compiled from: RowColumnImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0010¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$CenterCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "()V", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class CenterCrossAxisAlignment extends CrossAxisAlignment {
        public static final CenterCrossAxisAlignment INSTANCE = new CenterCrossAxisAlignment();

        private CenterCrossAxisAlignment() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            return size / 2;
        }
    }

    /* compiled from: RowColumnImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0010¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$StartCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "()V", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class StartCrossAxisAlignment extends CrossAxisAlignment {
        public static final StartCrossAxisAlignment INSTANCE = new StartCrossAxisAlignment();

        private StartCrossAxisAlignment() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            if (layoutDirection == LayoutDirection.Ltr) {
                return 0;
            }
            return size;
        }
    }

    /* compiled from: RowColumnImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0010¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$EndCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "()V", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class EndCrossAxisAlignment extends CrossAxisAlignment {
        public static final EndCrossAxisAlignment INSTANCE = new EndCrossAxisAlignment();

        private EndCrossAxisAlignment() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            if (layoutDirection == LayoutDirection.Ltr) {
                return size;
            }
            return 0;
        }
    }

    /* compiled from: RowColumnImpl.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$VerticalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Landroidx/compose/ui/Alignment$Vertical;", "vertical", "<init>", "(Landroidx/compose/ui/Alignment$Vertical;)V", "", "size", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/layout/Placeable;", "placeable", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "(ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/layout/Placeable;I)I", "align", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/Alignment$Vertical;", "getVertical", "()Landroidx/compose/ui/Alignment$Vertical;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class VerticalCrossAxisAlignment extends CrossAxisAlignment {
        private final Alignment.Vertical vertical;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof VerticalCrossAxisAlignment) && Intrinsics.areEqual(this.vertical, ((VerticalCrossAxisAlignment) other).vertical);
        }

        public int hashCode() {
            return this.vertical.hashCode();
        }

        public String toString() {
            return "VerticalCrossAxisAlignment(vertical=" + this.vertical + ')';
        }

        public VerticalCrossAxisAlignment(Alignment.Vertical vertical) {
            super(null);
            this.vertical = vertical;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            return this.vertical.align(0, size);
        }
    }

    /* compiled from: RowColumnImpl.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$HorizontalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontal", "<init>", "(Landroidx/compose/ui/Alignment$Horizontal;)V", "", "size", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/layout/Placeable;", "placeable", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "(ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/layout/Placeable;I)I", "align", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/Alignment$Horizontal;", "getHorizontal", "()Landroidx/compose/ui/Alignment$Horizontal;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class HorizontalCrossAxisAlignment extends CrossAxisAlignment {
        private final Alignment.Horizontal horizontal;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof HorizontalCrossAxisAlignment) && Intrinsics.areEqual(this.horizontal, ((HorizontalCrossAxisAlignment) other).horizontal);
        }

        public int hashCode() {
            return this.horizontal.hashCode();
        }

        public String toString() {
            return "HorizontalCrossAxisAlignment(horizontal=" + this.horizontal + ')';
        }

        public HorizontalCrossAxisAlignment(Alignment.Horizontal horizontal) {
            super(null);
            this.horizontal = horizontal;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            return this.horizontal.align(0, size, layoutDirection);
        }
    }
}
