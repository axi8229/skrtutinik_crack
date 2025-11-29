package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AnnotatedString.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\u001a'\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a1\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\f\u001a3\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\f\u001a#\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001aK\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00122\u0016\u0010\u0013\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a/\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a/\u0010!\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0000¢\u0006\u0004\b!\u0010\u001c\u001a\u000f\u0010\"\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/ParagraphStyle;", "defaultParagraphStyle", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "normalizedParagraphStyles", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/ParagraphStyle;)Ljava/util/List;", "", "start", "end", "Landroidx/compose/ui/text/SpanStyle;", "getLocalSpanStyles", "(Landroidx/compose/ui/text/AnnotatedString;II)Ljava/util/List;", "getLocalParagraphStyles", "", "getLocalAnnotations", "substringWithoutParagraphStyles", "(Landroidx/compose/ui/text/AnnotatedString;II)Landroidx/compose/ui/text/AnnotatedString;", "T", "ranges", "filterRanges", "(Ljava/util/List;II)Ljava/util/List;", "baseStart", "baseEnd", "targetStart", "targetEnd", "", "contains", "(IIII)Z", "lStart", "lEnd", "rStart", "rEnd", "intersect", "emptyAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "EmptyAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnnotatedStringKt {
    private static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", null, null, 6, null);

    public static final boolean contains(int i, int i2, int i3, int i4) {
        if (i > i3 || i4 > i2) {
            return false;
        }
        if (i2 == i4) {
            if ((i3 == i4) != (i == i2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<AnnotatedString.Range<T>> filterRanges(List<? extends AnnotatedString.Range<? extends T>> list, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException(("start (" + i + ") should be less than or equal to end (" + i2 + ')').toString());
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range<? extends T> range = list.get(i3);
            AnnotatedString.Range<? extends T> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), Math.max(i, range3.getStart()) - i, Math.min(i2, range3.getEnd()) - i, range3.getTag()));
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return arrayList2;
    }

    public static final List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles(AnnotatedString annotatedString, ParagraphStyle paragraphStyle) {
        int length = annotatedString.getText().length();
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release();
        if (paragraphStylesOrNull$ui_text_release == null) {
            paragraphStylesOrNull$ui_text_release = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = paragraphStylesOrNull$ui_text_release.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            AnnotatedString.Range<ParagraphStyle> range = paragraphStylesOrNull$ui_text_release.get(i);
            ParagraphStyle paragraphStyleComponent1 = range.component1();
            int start = range.getStart();
            int end = range.getEnd();
            if (start != i2) {
                arrayList.add(new AnnotatedString.Range(paragraphStyle, i2, start));
            }
            arrayList.add(new AnnotatedString.Range(paragraphStyle.merge(paragraphStyleComponent1), start, end));
            i++;
            i2 = end;
        }
        if (i2 != length) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, i2, length));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, 0, 0));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<SpanStyle>> getLocalSpanStyles(AnnotatedString annotatedString, int i, int i2) {
        List<AnnotatedString.Range<SpanStyle>> spanStylesOrNull$ui_text_release;
        if (i == i2 || (spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return spanStylesOrNull$ui_text_release;
        }
        ArrayList arrayList = new ArrayList(spanStylesOrNull$ui_text_release.size());
        int size = spanStylesOrNull$ui_text_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range<SpanStyle> range = spanStylesOrNull$ui_text_release.get(i3);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), RangesKt.coerceIn(range3.getStart(), i, i2) - i, RangesKt.coerceIn(range3.getEnd(), i, i2) - i));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<ParagraphStyle>> getLocalParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release;
        if (i == i2 || (paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return paragraphStylesOrNull$ui_text_release;
        }
        ArrayList arrayList = new ArrayList(paragraphStylesOrNull$ui_text_release.size());
        int size = paragraphStylesOrNull$ui_text_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range<ParagraphStyle> range = paragraphStylesOrNull$ui_text_release.get(i3);
            AnnotatedString.Range<ParagraphStyle> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), RangesKt.coerceIn(range3.getStart(), i, i2) - i, RangesKt.coerceIn(range3.getEnd(), i, i2) - i));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<? extends Object>> getLocalAnnotations(AnnotatedString annotatedString, int i, int i2) {
        List<AnnotatedString.Range<? extends Object>> annotations$ui_text_release;
        if (i == i2 || (annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release()) == null) {
            return null;
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return annotations$ui_text_release;
        }
        ArrayList arrayList = new ArrayList(annotations$ui_text_release.size());
        int size = annotations$ui_text_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range<? extends Object> range = annotations$ui_text_release.get(i3);
            AnnotatedString.Range<? extends Object> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), RangesKt.coerceIn(range3.getStart(), i, i2) - i, RangesKt.coerceIn(range3.getEnd(), i, i2) - i, range3.getTag()));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        String strSubstring;
        if (i != i2) {
            strSubstring = annotatedString.getText().substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            strSubstring = "";
        }
        return new AnnotatedString(strSubstring, getLocalSpanStyles(annotatedString, i, i2), null, null, 12, null);
    }

    public static final boolean intersect(int i, int i2, int i3, int i4) {
        return Math.max(i, i3) < Math.min(i2, i4) || contains(i, i2, i3, i4) || contains(i3, i4, i, i2);
    }

    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }
}
