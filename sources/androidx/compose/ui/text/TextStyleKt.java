package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.LayoutDirection;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: TextStyle.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "style", "Landroidx/compose/ui/unit/LayoutDirection;", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "resolveDefaults", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/TextStyle;", "layoutDirection", "Landroidx/compose/ui/text/style/TextDirection;", "textDirection", "resolveTextDirection-IhaHGbI", "(Landroidx/compose/ui/unit/LayoutDirection;I)I", "resolveTextDirection", "Landroidx/compose/ui/text/PlatformSpanStyle;", "platformSpanStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "platformParagraphStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "createPlatformTextStyleInternal", "(Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/text/PlatformParagraphStyle;)Landroidx/compose/ui/text/PlatformTextStyle;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextStyleKt {

    /* compiled from: TextStyle.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final TextStyle resolveDefaults(TextStyle textStyle, LayoutDirection layoutDirection) {
        return new TextStyle(SpanStyleKt.resolveSpanStyleDefaults(textStyle.getSpanStyle()), ParagraphStyleKt.resolveParagraphStyleDefaults(textStyle.getParagraphStyle(), layoutDirection), textStyle.getPlatformStyle());
    }

    /* renamed from: resolveTextDirection-IhaHGbI, reason: not valid java name */
    public static final int m1816resolveTextDirectionIhaHGbI(LayoutDirection layoutDirection, int i) {
        TextDirection.Companion companion = TextDirection.INSTANCE;
        if (TextDirection.m2044equalsimpl0(i, companion.m2048getContents_7Xco())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                return companion.m2049getContentOrLtrs_7Xco();
            }
            if (i2 == 2) {
                return companion.m2050getContentOrRtls_7Xco();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!TextDirection.m2044equalsimpl0(i, companion.m2053getUnspecifieds_7Xco())) {
            return i;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i3 == 1) {
            return companion.m2051getLtrs_7Xco();
        }
        if (i3 == 2) {
            return companion.m2052getRtls_7Xco();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlatformTextStyle createPlatformTextStyleInternal(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (platformParagraphStyle == null) {
            return null;
        }
        return AndroidTextStyle_androidKt.createPlatformTextStyle(platformSpanStyle, platformParagraphStyle);
    }
}
