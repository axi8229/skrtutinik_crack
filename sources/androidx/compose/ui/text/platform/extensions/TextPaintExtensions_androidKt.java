package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextPaintExtensions.android.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a6\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aP\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042&\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\f\u0010\u001b\u001a\u00020\b*\u00020\u0004H\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"correctBlurRadius", "", "blurRadius", "generateFallbackSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "requiresLetterSpacing", "", "background", "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "applySpanStyle", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "setTextMotion", "", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextPaintExtensions_androidKt {
    public static final float correctBlurRadius(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    public static final SpanStyle applySpanStyle(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4, Density density, boolean z) {
        long jM2168getTypeUIouoOA = TextUnit.m2168getTypeUIouoOA(spanStyle.getFontSize());
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m2179equalsimpl0(jM2168getTypeUIouoOA, companion.m2184getSpUIouoOA())) {
            androidTextPaint.setTextSize(density.mo253toPxR2X_6o(spanStyle.getFontSize()));
        } else if (TextUnitType.m2179equalsimpl0(jM2168getTypeUIouoOA, companion.m2183getEmUIouoOA())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * TextUnit.m2169getValueimpl(spanStyle.getFontSize()));
        }
        if (hasFontAttributes(spanStyle)) {
            FontFamily fontFamily = spanStyle.getFontFamily();
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyle = spanStyle.getFontStyle();
            FontStyle fontStyleM1844boximpl = FontStyle.m1844boximpl(fontStyle != null ? fontStyle.getValue() : FontStyle.INSTANCE.m1852getNormal_LCdwA());
            FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
            androidTextPaint.setTypeface(function4.invoke(fontFamily, fontWeight, fontStyleM1844boximpl, FontSynthesis.m1853boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m1862getAllGVVA2EU())));
        }
        if (spanStyle.getLocaleList() != null && !Intrinsics.areEqual(spanStyle.getLocaleList(), LocaleList.INSTANCE.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales(androidTextPaint, spanStyle.getLocaleList());
        }
        if (spanStyle.getFontFeatureSettings() != null && !Intrinsics.areEqual(spanStyle.getFontFeatureSettings(), "")) {
            androidTextPaint.setFontFeatureSettings(spanStyle.getFontFeatureSettings());
        }
        if (spanStyle.getTextGeometricTransform() != null && !Intrinsics.areEqual(spanStyle.getTextGeometricTransform(), TextGeometricTransform.INSTANCE.getNone$ui_text_release())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * spanStyle.getTextGeometricTransform().getScaleX());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + spanStyle.getTextGeometricTransform().getSkewX());
        }
        androidTextPaint.m1951setColor8_81llA(spanStyle.m1763getColor0d7_KjU());
        androidTextPaint.m1950setBrush12SF9DM(spanStyle.getBrush(), Size.INSTANCE.m883getUnspecifiedNHjbRc(), spanStyle.getAlpha());
        androidTextPaint.setShadow(spanStyle.getShadow());
        androidTextPaint.setTextDecoration(spanStyle.getTextDecoration());
        androidTextPaint.setDrawStyle(spanStyle.getDrawStyle());
        if (TextUnitType.m2179equalsimpl0(TextUnit.m2168getTypeUIouoOA(spanStyle.getLetterSpacing()), companion.m2184getSpUIouoOA()) && TextUnit.m2169getValueimpl(spanStyle.getLetterSpacing()) != 0.0f) {
            float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
            float fMo253toPxR2X_6o = density.mo253toPxR2X_6o(spanStyle.getLetterSpacing());
            if (textSize != 0.0f) {
                androidTextPaint.setLetterSpacing(fMo253toPxR2X_6o / textSize);
            }
        } else if (TextUnitType.m2179equalsimpl0(TextUnit.m2168getTypeUIouoOA(spanStyle.getLetterSpacing()), companion.m2183getEmUIouoOA())) {
            androidTextPaint.setLetterSpacing(TextUnit.m2169getValueimpl(spanStyle.getLetterSpacing()));
        }
        return m1963generateFallbackSpanStyle62GTOB8(spanStyle.getLetterSpacing(), z, spanStyle.getBackground(), spanStyle.getBaselineShift());
    }

    /* renamed from: generateFallbackSpanStyle-62GTOB8, reason: not valid java name */
    private static final SpanStyle m1963generateFallbackSpanStyle62GTOB8(long j, boolean z, long j2, BaselineShift baselineShift) {
        long jM990getUnspecified0d7_KjU = j2;
        boolean z2 = false;
        boolean z3 = z && TextUnitType.m2179equalsimpl0(TextUnit.m2168getTypeUIouoOA(j), TextUnitType.INSTANCE.m2184getSpUIouoOA()) && TextUnit.m2169getValueimpl(j) != 0.0f;
        Color.Companion companion = Color.INSTANCE;
        boolean z4 = (Color.m977equalsimpl0(jM990getUnspecified0d7_KjU, companion.m990getUnspecified0d7_KjU()) || Color.m977equalsimpl0(jM990getUnspecified0d7_KjU, companion.m989getTransparent0d7_KjU())) ? false : true;
        if (baselineShift != null) {
            if (!BaselineShift.m1971equalsimpl0(baselineShift.getMultiplier(), BaselineShift.INSTANCE.m1975getNoney9eOQZs())) {
                z2 = true;
            }
        }
        if (!z3 && !z4 && !z2) {
            return null;
        }
        long jM2173getUnspecifiedXSAIIZE = z3 ? j : TextUnit.INSTANCE.m2173getUnspecifiedXSAIIZE();
        if (!z4) {
            jM990getUnspecified0d7_KjU = companion.m990getUnspecified0d7_KjU();
        }
        return new SpanStyle(0L, 0L, null, null, null, null, null, jM2173getUnspecifiedXSAIIZE, z2 ? baselineShift : null, null, null, jM990getUnspecified0d7_KjU, null, null, null, null, 63103, null);
    }

    public static final void setTextMotion(AndroidTextPaint androidTextPaint, TextMotion textMotion) {
        int flags;
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        if (textMotion.getSubpixelTextPositioning()) {
            flags = androidTextPaint.getFlags() | 128;
        } else {
            flags = androidTextPaint.getFlags() & (-129);
        }
        androidTextPaint.setFlags(flags);
        int linearity = textMotion.getLinearity();
        TextMotion.Linearity.Companion companion = TextMotion.Linearity.INSTANCE;
        if (TextMotion.Linearity.m2060equalsimpl0(linearity, companion.m2063getLinear4e0Vf04())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.m2060equalsimpl0(linearity, companion.m2062getFontHinting4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (TextMotion.Linearity.m2060equalsimpl0(linearity, companion.m2064getNone4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        } else {
            androidTextPaint.getFlags();
        }
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        return (spanStyle.getFontFamily() == null && spanStyle.getFontStyle() == null && spanStyle.getFontWeight() == null) ? false : true;
    }
}
