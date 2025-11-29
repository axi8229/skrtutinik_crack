package ru.yoomoney.sdk.guiCompose.theme;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Colors.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJO\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/ThemeColors;", "", "Landroidx/compose/ui/graphics/Color;", "tint", "tintFade", "tintGhost", "tintBg", "tintCard", "tintSelection", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "copy-tNS2XkQ", "(JJJJJJ)Lru/yoomoney/sdk/guiCompose/theme/ThemeColors;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTint-0d7_KjU", "()J", "getTintFade-0d7_KjU", "getTintGhost-0d7_KjU", "getTintBg-0d7_KjU", "getTintCard-0d7_KjU", "getTintSelection-0d7_KjU", "Companion", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ThemeColors {
    private final long tint;
    private final long tintBg;
    private final long tintCard;
    private final long tintFade;
    private final long tintGhost;
    private final long tintSelection;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ThemeColors defaultColorsLight = new ThemeColors(ColorKt.Color(4287315965L), ColorKt.Color(4289760996L), ColorKt.Color(646660093), ColorKt.Color(4293716208L), ColorKt.Color(4294967295L), ColorKt.Color(4290415871L), null);
    private static final ThemeColors defaultColorsDark = new ThemeColors(ColorKt.Color(4287315965L), ColorKt.Color(4289760996L), ColorKt.Color(646660093), ColorKt.Color(4279703583L), ColorKt.Color(4281348672L), ColorKt.Color(4290415871L), null);

    public /* synthetic */ ThemeColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    /* renamed from: copy-tNS2XkQ, reason: not valid java name */
    public final ThemeColors m3410copytNS2XkQ(long tint, long tintFade, long tintGhost, long tintBg, long tintCard, long tintSelection) {
        return new ThemeColors(tint, tintFade, tintGhost, tintBg, tintCard, tintSelection, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThemeColors)) {
            return false;
        }
        ThemeColors themeColors = (ThemeColors) other;
        return Color.m977equalsimpl0(this.tint, themeColors.tint) && Color.m977equalsimpl0(this.tintFade, themeColors.tintFade) && Color.m977equalsimpl0(this.tintGhost, themeColors.tintGhost) && Color.m977equalsimpl0(this.tintBg, themeColors.tintBg) && Color.m977equalsimpl0(this.tintCard, themeColors.tintCard) && Color.m977equalsimpl0(this.tintSelection, themeColors.tintSelection);
    }

    public int hashCode() {
        return (((((((((Color.m983hashCodeimpl(this.tint) * 31) + Color.m983hashCodeimpl(this.tintFade)) * 31) + Color.m983hashCodeimpl(this.tintGhost)) * 31) + Color.m983hashCodeimpl(this.tintBg)) * 31) + Color.m983hashCodeimpl(this.tintCard)) * 31) + Color.m983hashCodeimpl(this.tintSelection);
    }

    public String toString() {
        return "ThemeColors(tint=" + Color.m984toStringimpl(this.tint) + ", tintFade=" + Color.m984toStringimpl(this.tintFade) + ", tintGhost=" + Color.m984toStringimpl(this.tintGhost) + ", tintBg=" + Color.m984toStringimpl(this.tintBg) + ", tintCard=" + Color.m984toStringimpl(this.tintCard) + ", tintSelection=" + Color.m984toStringimpl(this.tintSelection) + ")";
    }

    private ThemeColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.tint = j;
        this.tintFade = j2;
        this.tintGhost = j3;
        this.tintBg = j4;
        this.tintCard = j5;
        this.tintSelection = j6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ThemeColors(long j, long j2, long j3, long j4, long j5, long j6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long jM990getUnspecified0d7_KjU = (i & 1) != 0 ? Color.INSTANCE.m990getUnspecified0d7_KjU() : j;
        this(jM990getUnspecified0d7_KjU, (i & 2) != 0 ? ColorsKt.m3379getTintFade8_81llA(jM990getUnspecified0d7_KjU) : j2, (i & 4) != 0 ? Color.m975copywmQWz5c$default(jM990getUnspecified0d7_KjU, 0.15f, 0.0f, 0.0f, 0.0f, 14, null) : j3, (i & 8) != 0 ? Color.INSTANCE.m990getUnspecified0d7_KjU() : j4, (i & 16) != 0 ? Color.INSTANCE.m990getUnspecified0d7_KjU() : j5, (i & 32) != 0 ? ColorsKt.m3380getTintSelection8_81llA(jM990getUnspecified0d7_KjU) : j6, null);
    }

    /* renamed from: getTint-0d7_KjU, reason: not valid java name and from getter */
    public final long getTint() {
        return this.tint;
    }

    /* renamed from: getTintFade-0d7_KjU, reason: not valid java name and from getter */
    public final long getTintFade() {
        return this.tintFade;
    }

    /* renamed from: getTintGhost-0d7_KjU, reason: not valid java name and from getter */
    public final long getTintGhost() {
        return this.tintGhost;
    }

    /* renamed from: getTintBg-0d7_KjU, reason: not valid java name and from getter */
    public final long getTintBg() {
        return this.tintBg;
    }

    /* renamed from: getTintCard-0d7_KjU, reason: not valid java name and from getter */
    public final long getTintCard() {
        return this.tintCard;
    }

    /* renamed from: getTintSelection-0d7_KjU, reason: not valid java name and from getter */
    public final long getTintSelection() {
        return this.tintSelection;
    }

    /* compiled from: Colors.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/ThemeColors$Companion;", "", "()V", "defaultColorsDark", "Lru/yoomoney/sdk/guiCompose/theme/ThemeColors;", "getDefaultColorsDark", "()Lru/yoomoney/sdk/guiCompose/theme/ThemeColors;", "defaultColorsLight", "getDefaultColorsLight", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ThemeColors getDefaultColorsLight() {
            return ThemeColors.defaultColorsLight;
        }

        public final ThemeColors getDefaultColorsDark() {
            return ThemeColors.defaultColorsDark;
        }
    }
}
