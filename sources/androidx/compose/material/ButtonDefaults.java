package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: Button.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ:\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J0\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\"\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010$R\u001d\u0010%\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010$R\u001d\u0010'\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010$R\u001d\u0010)\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010$R\u001d\u0010+\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010$R\u001a\u0010-\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b-\u0010\u001bR\u0017\u0010.\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Landroidx/compose/material/ButtonDefaults;", "", "<init>", "()V", "Landroidx/compose/ui/unit/Dp;", "defaultElevation", "pressedElevation", "disabledElevation", "hoveredElevation", "focusedElevation", "Landroidx/compose/material/ButtonElevation;", "elevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "elevation", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColor", "disabledBackgroundColor", "disabledContentColor", "Landroidx/compose/material/ButtonColors;", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "buttonColors", "textButtonColors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "textButtonColors", "ButtonHorizontalPadding", "F", "ButtonVerticalPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "MinWidth", "getMinWidth-D9Ej5fM", "()F", "MinHeight", "getMinHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "IconSpacing", "getIconSpacing-D9Ej5fM", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "TextButtonHorizontalPadding", "TextButtonContentPadding", "getTextButtonContentPadding", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final float OutlinedBorderSize;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    private ButtonDefaults() {
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m599getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m598getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m596buttonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long jM994compositeOverOWjLjI;
        composer.startReplaceableGroup(1870371134);
        long jM608getPrimary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m608getPrimary0d7_KjU() : j;
        long jM614contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m614contentColorForek8zF_U(jM608getPrimary0d7_KjU, composer, i & 14) : j2;
        if ((i2 & 4) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM994compositeOverOWjLjI = ColorKt.m994compositeOverOWjLjI(Color.m975copywmQWz5c$default(materialTheme.getColors(composer, 6).m607getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m612getSurface0d7_KjU());
        } else {
            jM994compositeOverOWjLjI = j3;
        }
        long jM975copywmQWz5c$default = (i2 & 8) != 0 ? Color.m975copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m607getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1870371134, i, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:411)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM608getPrimary0d7_KjU, jM614contentColorForek8zF_U, jM994compositeOverOWjLjI, jM975copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* renamed from: textButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m600textButtonColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(182742216);
        long jM989getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m989getTransparent0d7_KjU() : j;
        long jM608getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m608getPrimary0d7_KjU() : j2;
        long jM975copywmQWz5c$default = (i2 & 4) != 0 ? Color.m975copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m607getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(182742216, i, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:453)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM989getTransparent0d7_KjU, jM608getPrimary0d7_KjU, jM989getTransparent0d7_KjU, jM975copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    /* renamed from: elevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m597elevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-737170518);
        float fM2102constructorimpl = (i2 & 1) != 0 ? Dp.m2102constructorimpl(2) : f;
        float fM2102constructorimpl2 = (i2 & 2) != 0 ? Dp.m2102constructorimpl(8) : f2;
        float fM2102constructorimpl3 = (i2 & 4) != 0 ? Dp.m2102constructorimpl(0) : f3;
        float fM2102constructorimpl4 = (i2 & 8) != 0 ? Dp.m2102constructorimpl(4) : f4;
        float fM2102constructorimpl5 = (i2 & 16) != 0 ? Dp.m2102constructorimpl(4) : f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-737170518, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:376)");
        }
        Object[] objArr = {Dp.m2100boximpl(fM2102constructorimpl), Dp.m2100boximpl(fM2102constructorimpl2), Dp.m2100boximpl(fM2102constructorimpl3), Dp.m2100boximpl(fM2102constructorimpl4), Dp.m2100boximpl(fM2102constructorimpl5)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i3 = 0; i3 < 5; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new DefaultButtonElevation(fM2102constructorimpl, fM2102constructorimpl2, fM2102constructorimpl3, fM2102constructorimpl4, fM2102constructorimpl5, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultButtonElevation defaultButtonElevation = (DefaultButtonElevation) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonElevation;
    }

    static {
        float fM2102constructorimpl = Dp.m2102constructorimpl(16);
        ButtonHorizontalPadding = fM2102constructorimpl;
        float f = 8;
        float fM2102constructorimpl2 = Dp.m2102constructorimpl(f);
        ButtonVerticalPadding = fM2102constructorimpl2;
        PaddingValues paddingValuesM307PaddingValuesa9UjIt4 = PaddingKt.m307PaddingValuesa9UjIt4(fM2102constructorimpl, fM2102constructorimpl2, fM2102constructorimpl, fM2102constructorimpl2);
        ContentPadding = paddingValuesM307PaddingValuesa9UjIt4;
        MinWidth = Dp.m2102constructorimpl(64);
        MinHeight = Dp.m2102constructorimpl(36);
        IconSize = Dp.m2102constructorimpl(18);
        IconSpacing = Dp.m2102constructorimpl(f);
        OutlinedBorderSize = Dp.m2102constructorimpl(1);
        float fM2102constructorimpl3 = Dp.m2102constructorimpl(f);
        TextButtonHorizontalPadding = fM2102constructorimpl3;
        TextButtonContentPadding = PaddingKt.m307PaddingValuesa9UjIt4(fM2102constructorimpl3, paddingValuesM307PaddingValuesa9UjIt4.getTop(), fM2102constructorimpl3, paddingValuesM307PaddingValuesa9UjIt4.getBottom());
    }
}
