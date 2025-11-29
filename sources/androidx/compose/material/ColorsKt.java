package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Colors.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0088\u0001\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0014\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001a\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\" \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0015\u0010\u001e\u001a\u00020\u0000*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "Landroidx/compose/material/Colors;", "lightColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "lightColors", "backgroundColor", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "contentColorFor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "primarySurface", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorsKt {
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0<Colors>() { // from class: androidx.compose.material.ColorsKt$LocalColors$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Colors invoke() {
            return ColorsKt.m615lightColors2qZNXz8((4095 & 1) != 0 ? ColorKt.Color(4284612846L) : 0L, (4095 & 2) != 0 ? ColorKt.Color(4281794739L) : 0L, (4095 & 4) != 0 ? ColorKt.Color(4278442694L) : 0L, (4095 & 8) != 0 ? ColorKt.Color(4278290310L) : 0L, (4095 & 16) != 0 ? Color.INSTANCE.m991getWhite0d7_KjU() : 0L, (4095 & 32) != 0 ? Color.INSTANCE.m991getWhite0d7_KjU() : 0L, (4095 & 64) != 0 ? ColorKt.Color(4289724448L) : 0L, (4095 & 128) != 0 ? Color.INSTANCE.m991getWhite0d7_KjU() : 0L, (4095 & 256) != 0 ? Color.INSTANCE.m986getBlack0d7_KjU() : 0L, (4095 & 512) != 0 ? Color.INSTANCE.m986getBlack0d7_KjU() : 0L, (4095 & 1024) != 0 ? Color.INSTANCE.m986getBlack0d7_KjU() : 0L, (4095 & 2048) != 0 ? Color.INSTANCE.m991getWhite0d7_KjU() : 0L);
        }
    });

    /* renamed from: lightColors-2qZNXz8, reason: not valid java name */
    public static final Colors m615lightColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, true, null);
    }

    public static final long getPrimarySurface(Colors colors) {
        return colors.isLight() ? colors.m608getPrimary0d7_KjU() : colors.m612getSurface0d7_KjU();
    }

    /* renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m613contentColorFor4WTKRHQ(Colors colors, long j) {
        if (!Color.m977equalsimpl0(j, colors.m608getPrimary0d7_KjU()) && !Color.m977equalsimpl0(j, colors.m609getPrimaryVariant0d7_KjU())) {
            if (!Color.m977equalsimpl0(j, colors.m610getSecondary0d7_KjU()) && !Color.m977equalsimpl0(j, colors.m611getSecondaryVariant0d7_KjU())) {
                return Color.m977equalsimpl0(j, colors.m601getBackground0d7_KjU()) ? colors.m603getOnBackground0d7_KjU() : Color.m977equalsimpl0(j, colors.m612getSurface0d7_KjU()) ? colors.m607getOnSurface0d7_KjU() : Color.m977equalsimpl0(j, colors.m602getError0d7_KjU()) ? colors.m604getOnError0d7_KjU() : Color.INSTANCE.m990getUnspecified0d7_KjU();
            }
            return colors.m606getOnSecondary0d7_KjU();
        }
        return colors.m605getOnPrimary0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m614contentColorForek8zF_U(long j, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441849991, i, -1, "androidx.compose.material.contentColorFor (Colors.kt:296)");
        }
        long jM613contentColorFor4WTKRHQ = m613contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j);
        if (jM613contentColorFor4WTKRHQ == Color.INSTANCE.m990getUnspecified0d7_KjU()) {
            jM613contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).getValue();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jM613contentColorFor4WTKRHQ;
    }

    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }
}
