package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: TextDelegate.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u0000 N2\u00020\u0001:\u0001NBe\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b \u0010!J,\u0010&\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010-\u001a\u0004\b0\u0010/R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00101\u001a\u0004\b2\u00103R\u001d\u0010\f\u001a\u00020\u000b8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\f\u0010-\u001a\u0004\b4\u0010/R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00105\u001a\u0004\b6\u00107R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u00108\u001a\u0004\b9\u0010:R#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0014\u0010;\u001a\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010!R\u0014\u0010K\u001a\u00020>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010BR\u0011\u0010M\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bL\u0010/\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006O"}, d2 = {"Landroidx/compose/foundation/text/TextDelegate;", "", "Landroidx/compose/ui/text/AnnotatedString;", "text", "Landroidx/compose/ui/text/TextStyle;", "style", "", "maxLines", "minLines", "", "softWrap", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "placeholders", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IIZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/text/MultiParagraph;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "layoutText", "", "layoutIntrinsics", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/text/TextLayoutResult;", "prevResult", "layout-NN6Ew-U", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/ui/text/TextLayoutResult;", "layout", "Landroidx/compose/ui/text/AnnotatedString;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/TextStyle;", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "I", "getMaxLines", "()I", "getMinLines", "Z", "getSoftWrap", "()Z", "getOverflow-gIe3tQ8", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "Ljava/util/List;", "getPlaceholders", "()Ljava/util/List;", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "paragraphIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getParagraphIntrinsics$foundation_release", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "setParagraphIntrinsics$foundation_release", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;)V", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getIntrinsicsLayoutDirection$foundation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setIntrinsicsLayoutDirection$foundation_release", "getNonNullIntrinsics", "nonNullIntrinsics", "getMaxIntrinsicWidth", "maxIntrinsicWidth", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextDelegate {
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private final int maxLines;
    private final int minLines;
    private final int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    public /* synthetic */ TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i, int i2, boolean z, int i3, Density density, FontFamily.Resolver resolver, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, i, i2, z, i3, density, resolver, list);
    }

    private TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i, int i2, boolean z, int i3, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list) {
        this.text = annotatedString;
        this.style = textStyle;
        this.maxLines = i;
        this.minLines = i2;
        this.softWrap = z;
        this.overflow = i3;
        this.density = density;
        this.fontFamilyResolver = resolver;
        this.placeholders = list;
        if (i <= 0) {
            throw new IllegalArgumentException("no maxLines");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("no minLines");
        }
        if (i2 > i) {
            throw new IllegalArgumentException("minLines greater than maxLines");
        }
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getMinLines() {
        return this.minLines;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    public /* synthetic */ TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i, int i2, boolean z, int i3, Density density, FontFamily.Resolver resolver, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (i4 & 4) != 0 ? Integer.MAX_VALUE : i, (i4 & 8) != 0 ? 1 : i2, (i4 & 16) != 0 ? true : z, (i4 & 32) != 0 ? TextOverflow.INSTANCE.m2069getClipgIe3tQ8() : i3, density, resolver, (i4 & 256) != 0 ? CollectionsKt.emptyList() : list, null);
    }

    /* renamed from: getOverflow-gIe3tQ8, reason: not valid java name and from getter */
    public final int getOverflow() {
        return this.overflow;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    private final MultiParagraphIntrinsics getNonNullIntrinsics() {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        if (multiParagraphIntrinsics != null) {
            return multiParagraphIntrinsics;
        }
        throw new IllegalStateException("layoutIntrinsics must be called first");
    }

    public final int getMaxIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(getNonNullIntrinsics().getMaxIntrinsicWidth());
    }

    public final void layoutIntrinsics(LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        if (multiParagraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || multiParagraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            multiParagraphIntrinsics = new MultiParagraphIntrinsics(this.text, TextStyleKt.resolveDefaults(this.style, layoutDirection), this.placeholders, this.density, this.fontFamilyResolver);
        }
        this.paragraphIntrinsics = multiParagraphIntrinsics;
    }

    /* renamed from: layoutText-K40F9xA, reason: not valid java name */
    private final MultiParagraph m455layoutTextK40F9xA(long constraints, LayoutDirection layoutDirection) {
        layoutIntrinsics(layoutDirection);
        int iM2086getMinWidthimpl = Constraints.m2086getMinWidthimpl(constraints);
        int iM2084getMaxWidthimpl = ((this.softWrap || TextOverflow.m2066equalsimpl0(this.overflow, TextOverflow.INSTANCE.m2070getEllipsisgIe3tQ8())) && Constraints.m2080getHasBoundedWidthimpl(constraints)) ? Constraints.m2084getMaxWidthimpl(constraints) : Integer.MAX_VALUE;
        int i = (this.softWrap || !TextOverflow.m2066equalsimpl0(this.overflow, TextOverflow.INSTANCE.m2070getEllipsisgIe3tQ8())) ? this.maxLines : 1;
        if (iM2086getMinWidthimpl != iM2084getMaxWidthimpl) {
            iM2084getMaxWidthimpl = RangesKt.coerceIn(getMaxIntrinsicWidth(), iM2086getMinWidthimpl, iM2084getMaxWidthimpl);
        }
        return new MultiParagraph(getNonNullIntrinsics(), Constraints.INSTANCE.m2092fitPrioritizingWidthZbe2FdA(0, iM2084getMaxWidthimpl, 0, Constraints.m2083getMaxHeightimpl(constraints)), i, TextOverflow.m2066equalsimpl0(this.overflow, TextOverflow.INSTANCE.m2070getEllipsisgIe3tQ8()), null);
    }

    /* renamed from: layout-NN6Ew-U, reason: not valid java name */
    public final TextLayoutResult m457layoutNN6EwU(long constraints, LayoutDirection layoutDirection, TextLayoutResult prevResult) {
        if (prevResult != null && TextLayoutHelperKt.m484canReuse7_7YC6M(prevResult, this.text, this.style, this.placeholders, this.maxLines, this.softWrap, this.overflow, this.density, layoutDirection, this.fontFamilyResolver, constraints)) {
            return prevResult.m1776copyO0kMr_c(new TextLayoutInput(prevResult.getLayoutInput().getText(), this.style, prevResult.getLayoutInput().getPlaceholders(), prevResult.getLayoutInput().getMaxLines(), prevResult.getLayoutInput().getSoftWrap(), prevResult.getLayoutInput().getOverflow(), prevResult.getLayoutInput().getDensity(), prevResult.getLayoutInput().getLayoutDirection(), prevResult.getLayoutInput().getFontFamilyResolver(), constraints, (DefaultConstructorMarker) null), ConstraintsKt.m2095constrain4WqzIAM(constraints, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(prevResult.getMultiParagraph().getWidth()), TextDelegateKt.ceilToIntPx(prevResult.getMultiParagraph().getHeight()))));
        }
        MultiParagraph multiParagraphM455layoutTextK40F9xA = m455layoutTextK40F9xA(constraints, layoutDirection);
        return new TextLayoutResult(new TextLayoutInput(this.text, this.style, this.placeholders, this.maxLines, this.softWrap, this.overflow, this.density, layoutDirection, this.fontFamilyResolver, constraints, (DefaultConstructorMarker) null), multiParagraphM455layoutTextK40F9xA, ConstraintsKt.m2095constrain4WqzIAM(constraints, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(multiParagraphM455layoutTextK40F9xA.getWidth()), TextDelegateKt.ceilToIntPx(multiParagraphM455layoutTextK40F9xA.getHeight()))), null);
    }
}
