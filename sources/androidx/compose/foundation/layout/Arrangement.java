package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Arrangement.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001c\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005DEFGHB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u001d\u0010\u0018J/\u0010 \u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u001f\u0010\u0018J/\u0010\"\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b!\u0010\u0018J/\u0010$\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b#\u0010\u0018R \u0010%\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010\u0003\u001a\u0004\b'\u0010(R \u0010*\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b*\u0010&\u0012\u0004\b,\u0010\u0003\u001a\u0004\b+\u0010(R \u0010.\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b2\u0010\u0003\u001a\u0004\b0\u00101R \u00103\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b3\u0010/\u0012\u0004\b5\u0010\u0003\u001a\u0004\b4\u00101R \u00106\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b6\u00107\u0012\u0004\b:\u0010\u0003\u001a\u0004\b8\u00109R \u0010;\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b;\u00107\u0012\u0004\b=\u0010\u0003\u001a\u0004\b<\u00109R \u0010>\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b>\u00107\u0012\u0004\b@\u0010\u0003\u001a\u0004\b?\u00109R \u0010A\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bA\u00107\u0012\u0004\bC\u0010\u0003\u001a\u0004\bB\u00109\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement;", "", "<init>", "()V", "Landroidx/compose/ui/unit/Dp;", "space", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy", "Landroidx/compose/ui/Alignment$Horizontal;", "alignment", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "totalSize", "", "size", "outPosition", "", "reverseInput", "", "placeRightOrBottom$foundation_layout_release", "(I[I[IZ)V", "placeRightOrBottom", "placeLeftOrTop$foundation_layout_release", "([I[IZ)V", "placeLeftOrTop", "placeCenter$foundation_layout_release", "placeCenter", "placeSpaceEvenly$foundation_layout_release", "placeSpaceEvenly", "placeSpaceBetween$foundation_layout_release", "placeSpaceBetween", "placeSpaceAround$foundation_layout_release", "placeSpaceAround", "Start", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getStart", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getStart$annotations", "End", "getEnd", "getEnd$annotations", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Top", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTop", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTop$annotations", "Bottom", "getBottom", "getBottom$annotations", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "SpaceEvenly", "getSpaceEvenly", "getSpaceEvenly$annotations", "SpaceBetween", "getSpaceBetween", "getSpaceBetween$annotations", "SpaceAround", "getSpaceAround", "getSpaceAround$annotations", "Absolute", "Horizontal", "HorizontalOrVertical", "SpacedAligned", "Vertical", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Arrangement {
    public static final Arrangement INSTANCE = new Arrangement();
    private static final Horizontal Start = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Start$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#Start";
        }
    };
    private static final Horizontal End = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#End";
        }
    };
    private static final Vertical Top = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Top$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Top";
        }
    };
    private static final Vertical Bottom = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Bottom$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Bottom";
        }
    };
    private static final HorizontalOrVertical Center = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$Center$1
        private final float spacing = Dp.m2102constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name and from getter */
        public float getSpacing() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Center";
        }
    };
    private static final HorizontalOrVertical SpaceEvenly = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceEvenly$1
        private final float spacing = Dp.m2102constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM, reason: from getter */
        public float getSpacing() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceEvenly";
        }
    };
    private static final HorizontalOrVertical SpaceBetween = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceBetween$1
        private final float spacing = Dp.m2102constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM, reason: from getter */
        public float getSpacing() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceBetween";
        }
    };
    private static final HorizontalOrVertical SpaceAround = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceAround$1
        private final float spacing = Dp.m2102constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM, reason: from getter */
        public float getSpacing() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceAround";
        }
    };

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface HorizontalOrVertical extends Horizontal, Vertical {
    }

    private Arrangement() {
    }

    public final Horizontal getStart() {
        return Start;
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Horizontal {
        void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);

        /* renamed from: getSpacing-D9Ej5fM */
        default float getSpacing() {
            return Dp.m2102constructorimpl(0);
        }
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Vertical {
        void arrange(Density density, int i, int[] iArr, int[] iArr2);

        /* renamed from: getSpacing-D9Ej5fM */
        default float getSpacing() {
            return Dp.m2102constructorimpl(0);
        }
    }

    public final Vertical getTop() {
        return Top;
    }

    public final Vertical getBottom() {
        return Bottom;
    }

    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    /* renamed from: spacedBy-0680j_4, reason: not valid java name */
    public final HorizontalOrVertical m293spacedBy0680j_4(float space) {
        return new SpacedAligned(space, true, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                return invoke(num.intValue(), layoutDirection);
            }

            public final Integer invoke(int i, LayoutDirection layoutDirection) {
                return Integer.valueOf(Alignment.INSTANCE.getStart().align(0, i, layoutDirection));
            }
        }, null);
    }

    /* renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Horizontal m294spacedByD5KLDUw(float space, final Alignment.Horizontal alignment) {
        return new SpacedAligned(space, true, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                return invoke(num.intValue(), layoutDirection);
            }

            public final Integer invoke(int i, LayoutDirection layoutDirection) {
                return Integer.valueOf(alignment.align(0, i, layoutDirection));
            }
        }, null);
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR \u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\bR \u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\bR \u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\bR \u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Absolute;", "", "<init>", "()V", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Left", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getLeft", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getLeft$annotations", "Center", "getCenter", "getCenter$annotations", "Right", "getRight", "getRight$annotations", "SpaceBetween", "getSpaceBetween", "getSpaceBetween$annotations", "SpaceEvenly", "getSpaceEvenly", "getSpaceEvenly$annotations", "SpaceAround", "getSpaceAround", "getSpaceAround$annotations", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Absolute {
        public static final Absolute INSTANCE = new Absolute();
        private static final Horizontal Left = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Left$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Left";
            }
        };
        private static final Horizontal Center = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Center$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Center";
            }
        };
        private static final Horizontal Right = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Right$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Right";
            }
        };
        private static final Horizontal SpaceBetween = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceBetween$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceBetween";
            }
        };
        private static final Horizontal SpaceEvenly = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceEvenly$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceEvenly";
            }
        };
        private static final Horizontal SpaceAround = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceAround$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceAround";
            }
        };

        private Absolute() {
        }

        public final Horizontal getLeft() {
            return Left;
        }

        public final Horizontal getRight() {
            return Right;
        }
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0013\u001a\u00020\u0012*\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0013\u001a\u00020\u0012*\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R+\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R \u0010(\u001a\u00020\u00028\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/ui/unit/Dp;", "space", "", "rtlMirror", "Lkotlin/Function2;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "alignment", "<init>", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "layoutDirection", "outPositions", "", "arrange", "(Landroidx/compose/ui/unit/Density;I[ILandroidx/compose/ui/unit/LayoutDirection;[I)V", "(Landroidx/compose/ui/unit/Density;I[I[I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "F", "getSpace-D9Ej5fM", "()F", "Z", "getRtlMirror", "()Z", "Lkotlin/jvm/functions/Function2;", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "spacing", "getSpacing-D9Ej5fM", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SpacedAligned implements HorizontalOrVertical {
        private final Function2<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        public /* synthetic */ SpacedAligned(float f, boolean z, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, z, function2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) other;
            return Dp.m2104equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && Intrinsics.areEqual(this.alignment, spacedAligned.alignment);
        }

        public int hashCode() {
            int iM2105hashCodeimpl = ((Dp.m2105hashCodeimpl(this.space) * 31) + Boolean.hashCode(this.rtlMirror)) * 31;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            return iM2105hashCodeimpl + (function2 == null ? 0 : function2.hashCode());
        }

        /* JADX WARN: Multi-variable type inference failed */
        private SpacedAligned(float f, boolean z, Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            this.space = f;
            this.rtlMirror = z;
            this.alignment = function2;
            this.spacing = f;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM, reason: from getter */
        public float getSpacing() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            int i2;
            int i3;
            if (iArr.length == 0) {
                return;
            }
            int iMo248roundToPx0680j_4 = density.mo248roundToPx0680j_4(this.space);
            boolean z = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
            Arrangement arrangement = Arrangement.INSTANCE;
            if (z) {
                int length = iArr.length - 1;
                i2 = 0;
                i3 = 0;
                while (-1 < length) {
                    int i4 = iArr[length];
                    int iMin = Math.min(i2, i - i4);
                    iArr2[length] = iMin;
                    int iMin2 = Math.min(iMo248roundToPx0680j_4, (i - iMin) - i4);
                    int i5 = iArr2[length] + i4 + iMin2;
                    length--;
                    i3 = iMin2;
                    i2 = i5;
                }
            } else {
                int length2 = iArr.length;
                int i6 = 0;
                i2 = 0;
                i3 = 0;
                int i7 = 0;
                while (i6 < length2) {
                    int i8 = iArr[i6];
                    int iMin3 = Math.min(i2, i - i8);
                    iArr2[i7] = iMin3;
                    int iMin4 = Math.min(iMo248roundToPx0680j_4, (i - iMin3) - i8);
                    int i9 = iArr2[i7] + i8 + iMin4;
                    i6++;
                    i7++;
                    i3 = iMin4;
                    i2 = i9;
                }
            }
            int i10 = i2 - i3;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            if (function2 == null || i10 >= i) {
                return;
            }
            int iIntValue = function2.invoke(Integer.valueOf(i - i10), layoutDirection).intValue();
            int length3 = iArr2.length;
            for (int i11 = 0; i11 < length3; i11++) {
                iArr2[i11] = iArr2[i11] + iIntValue;
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            arrange(density, i, iArr, LayoutDirection.Ltr, iArr2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.rtlMirror ? "" : "Absolute");
            sb.append("Arrangement#spacedAligned(");
            sb.append((Object) Dp.m2106toStringimpl(this.space));
            sb.append(", ");
            sb.append(this.alignment);
            sb.append(')');
            return sb.toString();
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        if (size.length == 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 : size) {
            i2 += i3;
        }
        float fMax = (totalSize - i2) / Math.max(ArraysKt.getLastIndex(size), 1);
        float f = (reverseInput && size.length == 1) ? fMax : 0.0f;
        if (reverseInput) {
            for (int length = size.length - 1; -1 < length; length--) {
                int i4 = size[length];
                outPosition[length] = Math.round(f);
                f += i4 + fMax;
            }
            return;
        }
        int length2 = size.length;
        int i5 = 0;
        while (i < length2) {
            int i6 = size[i];
            outPosition[i5] = Math.round(f);
            f += i6 + fMax;
            i++;
            i5++;
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int i = 0;
        int i2 = 0;
        for (int i3 : size) {
            i2 += i3;
        }
        int i4 = totalSize - i2;
        if (reverseInput) {
            int length = size.length;
            while (true) {
                length--;
                if (-1 >= length) {
                    return;
                }
                int i5 = size[length];
                outPosition[length] = i4;
                i4 += i5;
            }
        } else {
            int length2 = size.length;
            int i6 = 0;
            while (i < length2) {
                int i7 = size[i];
                outPosition[i6] = i4;
                i4 += i7;
                i++;
                i6++;
            }
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(int[] size, int[] outPosition, boolean reverseInput) {
        int i = 0;
        if (reverseInput) {
            int length = size.length;
            while (true) {
                length--;
                if (-1 >= length) {
                    return;
                }
                int i2 = size[length];
                outPosition[length] = i;
                i += i2;
            }
        } else {
            int length2 = size.length;
            int i3 = 0;
            int i4 = 0;
            while (i < length2) {
                int i5 = size[i];
                outPosition[i3] = i4;
                i4 += i5;
                i++;
                i3++;
            }
        }
    }

    public final void placeCenter$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int i = 0;
        int i2 = 0;
        for (int i3 : size) {
            i2 += i3;
        }
        float f = (totalSize - i2) / 2;
        if (reverseInput) {
            int length = size.length;
            while (true) {
                length--;
                if (-1 >= length) {
                    return;
                }
                int i4 = size[length];
                outPosition[length] = Math.round(f);
                f += i4;
            }
        } else {
            int length2 = size.length;
            int i5 = 0;
            while (i < length2) {
                int i6 = size[i];
                outPosition[i5] = Math.round(f);
                f += i6;
                i++;
                i5++;
            }
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int i = 0;
        int i2 = 0;
        for (int i3 : size) {
            i2 += i3;
        }
        float length = (totalSize - i2) / (size.length + 1);
        if (reverseInput) {
            float f = length;
            for (int length2 = size.length - 1; -1 < length2; length2--) {
                int i4 = size[length2];
                outPosition[length2] = Math.round(f);
                f += i4 + length;
            }
            return;
        }
        int length3 = size.length;
        float f2 = length;
        int i5 = 0;
        while (i < length3) {
            int i6 = size[i];
            outPosition[i5] = Math.round(f2);
            f2 += i6 + length;
            i++;
            i5++;
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int i = 0;
        int i2 = 0;
        for (int i3 : size) {
            i2 += i3;
        }
        float length = !(size.length == 0) ? (totalSize - i2) / size.length : 0.0f;
        float f = length / 2;
        if (reverseInput) {
            for (int length2 = size.length - 1; -1 < length2; length2--) {
                int i4 = size[length2];
                outPosition[length2] = Math.round(f);
                f += i4 + length;
            }
            return;
        }
        int length3 = size.length;
        int i5 = 0;
        while (i < length3) {
            int i6 = size[i];
            outPosition[i5] = Math.round(f);
            f += i6 + length;
            i++;
            i5++;
        }
    }
}
