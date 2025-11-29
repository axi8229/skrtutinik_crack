package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParagraphStyle.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001f\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001af\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u000e*\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\"\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/ParagraphStyle;", "style", "Landroidx/compose/ui/unit/LayoutDirection;", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "resolveParagraphStyleDefaults", "(Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/ParagraphStyle;", "Landroidx/compose/ui/text/style/TextAlign;", "textAlign", "Landroidx/compose/ui/text/style/TextDirection;", "textDirection", "Landroidx/compose/ui/unit/TextUnit;", "lineHeight", "Landroidx/compose/ui/text/style/TextIndent;", "textIndent", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "platformStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineBreak;", "lineBreak", "Landroidx/compose/ui/text/style/Hyphens;", "hyphens", "Landroidx/compose/ui/text/style/TextMotion;", "textMotion", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "fastMerge", "other", "mergePlatformStyle", "(Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformParagraphStyle;)Landroidx/compose/ui/text/PlatformParagraphStyle;", "DefaultLineHeight", "J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.INSTANCE.m2173getUnspecifiedXSAIIZE();

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle paragraphStyle, LayoutDirection layoutDirection) {
        int textAlign = paragraphStyle.getTextAlign();
        TextAlign.Companion companion = TextAlign.INSTANCE;
        int iM2039getStarte0LSkKk = TextAlign.m2030equalsimpl0(textAlign, companion.m2040getUnspecifiede0LSkKk()) ? companion.m2039getStarte0LSkKk() : paragraphStyle.getTextAlign();
        int iM1816resolveTextDirectionIhaHGbI = TextStyleKt.m1816resolveTextDirectionIhaHGbI(layoutDirection, paragraphStyle.getTextDirection());
        long lineHeight = TextUnitKt.m2175isUnspecifiedR2X_6o(paragraphStyle.getLineHeight()) ? DefaultLineHeight : paragraphStyle.getLineHeight();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        int lineBreak = paragraphStyle.getLineBreak();
        LineBreak.Companion companion2 = LineBreak.INSTANCE;
        int iM1991getSimplerAG3T2k = LineBreak.m1985equalsimpl0(lineBreak, companion2.m1992getUnspecifiedrAG3T2k()) ? companion2.m1991getSimplerAG3T2k() : paragraphStyle.getLineBreak();
        int hyphens = paragraphStyle.getHyphens();
        Hyphens.Companion companion3 = Hyphens.INSTANCE;
        int iM1982getNonevmbZdU8 = Hyphens.m1978equalsimpl0(hyphens, companion3.m1983getUnspecifiedvmbZdU8()) ? companion3.m1982getNonevmbZdU8() : paragraphStyle.getHyphens();
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        return new ParagraphStyle(iM2039getStarte0LSkKk, iM1816resolveTextDirectionIhaHGbI, lineHeight, textIndent2, platformStyle, lineHeightStyle, iM1991getSimplerAG3T2k, iM1982getNonevmbZdU8, textMotion, null);
    }

    /* renamed from: fastMerge-j5T8yCg, reason: not valid java name */
    public static final ParagraphStyle m1733fastMergej5T8yCg(ParagraphStyle paragraphStyle, int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        long j2;
        int textAlign = i;
        TextIndent textIndent2 = textIndent;
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m2030equalsimpl0(textAlign, companion.m2040getUnspecifiede0LSkKk()) || TextAlign.m2030equalsimpl0(textAlign, paragraphStyle.getTextAlign())) {
            if (TextUnitKt.m2175isUnspecifiedR2X_6o(j)) {
                j2 = j;
            } else {
                j2 = j;
                if (TextUnit.m2166equalsimpl0(j2, paragraphStyle.getLineHeight())) {
                }
            }
            if ((textIndent2 == null || Intrinsics.areEqual(textIndent2, paragraphStyle.getTextIndent())) && ((TextDirection.m2044equalsimpl0(i2, TextDirection.INSTANCE.m2053getUnspecifieds_7Xco()) || TextDirection.m2044equalsimpl0(i2, paragraphStyle.getTextDirection())) && ((platformParagraphStyle == null || Intrinsics.areEqual(platformParagraphStyle, paragraphStyle.getPlatformStyle())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, paragraphStyle.getLineHeightStyle())) && ((LineBreak.m1985equalsimpl0(i3, LineBreak.INSTANCE.m1992getUnspecifiedrAG3T2k()) || LineBreak.m1985equalsimpl0(i3, paragraphStyle.getLineBreak())) && ((Hyphens.m1978equalsimpl0(i4, Hyphens.INSTANCE.m1983getUnspecifiedvmbZdU8()) || Hyphens.m1978equalsimpl0(i4, paragraphStyle.getHyphens())) && (textMotion == null || Intrinsics.areEqual(textMotion, paragraphStyle.getTextMotion())))))))) {
                return paragraphStyle;
            }
        } else {
            j2 = j;
        }
        long lineHeight = TextUnitKt.m2175isUnspecifiedR2X_6o(j) ? paragraphStyle.getLineHeight() : j2;
        if (textIndent2 == null) {
            textIndent2 = paragraphStyle.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (TextAlign.m2030equalsimpl0(textAlign, companion.m2040getUnspecifiede0LSkKk())) {
            textAlign = paragraphStyle.getTextAlign();
        }
        return new ParagraphStyle(textAlign, !TextDirection.m2044equalsimpl0(i2, TextDirection.INSTANCE.m2053getUnspecifieds_7Xco()) ? i2 : paragraphStyle.getTextDirection(), lineHeight, textIndent3, mergePlatformStyle(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.getLineHeightStyle() : lineHeightStyle, !LineBreak.m1985equalsimpl0(i3, LineBreak.INSTANCE.m1992getUnspecifiedrAG3T2k()) ? i3 : paragraphStyle.getLineBreak(), !Hyphens.m1978equalsimpl0(i4, Hyphens.INSTANCE.m1983getUnspecifiedvmbZdU8()) ? i4 : paragraphStyle.getHyphens(), textMotion == null ? paragraphStyle.getTextMotion() : textMotion, null);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (paragraphStyle.getPlatformStyle() == null) {
            return platformParagraphStyle;
        }
        if (platformParagraphStyle == null) {
            return paragraphStyle.getPlatformStyle();
        }
        return paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }
}
