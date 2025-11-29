package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnotatedString.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0007\u0018\u0000 @2\u00020\u0001:\u0003A@BB[\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0005\u0018\u00010\u0004\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0005\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rB=\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004¢\u0006\u0004\b\f\u0010\u0010J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001f\u0010 J)\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011¢\u0006\u0004\b$\u0010%J+\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00050\u00042\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0007¢\u0006\u0004\b'\u0010%J)\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00050\u00042\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011¢\u0006\u0004\b)\u0010%J\u001d\u0010+\u001a\u00020*2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u00020*2\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0011H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0002H\u0016¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u0000¢\u0006\u0004\b3\u00104R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00105\u001a\u0004\b6\u00102R(\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u00107\u001a\u0004\b8\u00109R(\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0005\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b:\u00109R*\u0010\u000b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0005\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u00107\u001a\u0004\b;\u00109R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F¢\u0006\u0006\u001a\u0004\b<\u00109R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00048F¢\u0006\u0006\u001a\u0004\b=\u00109R\u0014\u0010?\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u00100\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString;", "", "", "text", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "spanStylesOrNull", "Landroidx/compose/ui/text/ParagraphStyle;", "paragraphStylesOrNull", "", "annotations", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "spanStyles", "paragraphStyles", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "", "index", "", "get", "(I)C", "startIndex", "endIndex", "subSequence", "(II)Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/TextRange;", "range", "subSequence-5zc-tL8", "(J)Landroidx/compose/ui/text/AnnotatedString;", "other", "plus", "(Landroidx/compose/ui/text/AnnotatedString;)Landroidx/compose/ui/text/AnnotatedString;", "start", "end", "Landroidx/compose/ui/text/TtsAnnotation;", "getTtsAnnotations", "(II)Ljava/util/List;", "Landroidx/compose/ui/text/UrlAnnotation;", "getUrlAnnotations", "Landroidx/compose/ui/text/LinkAnnotation;", "getLinkAnnotations", "", "hasLinkAnnotations", "(II)Z", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "hasEqualAnnotations", "(Landroidx/compose/ui/text/AnnotatedString;)Z", "Ljava/lang/String;", "getText", "Ljava/util/List;", "getSpanStylesOrNull$ui_text_release", "()Ljava/util/List;", "getParagraphStylesOrNull$ui_text_release", "getAnnotations$ui_text_release", "getSpanStyles", "getParagraphStyles", "getLength", "length", "Companion", "Builder", "Range", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnnotatedString implements CharSequence {
    private static final Saver<AnnotatedString, ?> Saver = SaversKt.getAnnotatedStringSaver();
    private final List<Range<? extends Object>> annotations;
    private final List<Range<ParagraphStyle>> paragraphStylesOrNull;
    private final List<Range<SpanStyle>> spanStylesOrNull;
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedString(String str, List<Range<SpanStyle>> list, List<Range<ParagraphStyle>> list2, List<? extends Range<? extends Object>> list3) {
        List listSortedWith;
        this.text = str;
        this.spanStylesOrNull = list;
        this.paragraphStylesOrNull = list2;
        this.annotations = list3;
        if (list2 == null || (listSortedWith = CollectionsKt.sortedWith(list2, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((AnnotatedString.Range) t).getStart()), Integer.valueOf(((AnnotatedString.Range) t2).getStart()));
            }
        })) == null) {
            return;
        }
        int size = listSortedWith.size();
        int end = -1;
        for (int i = 0; i < size; i++) {
            Range range = (Range) listSortedWith.get(i);
            if (range.getStart() < end) {
                throw new IllegalArgumentException("ParagraphStyle should not overlap");
            }
            if (range.getEnd() > this.text.length()) {
                throw new IllegalArgumentException(("ParagraphStyle range [" + range.getStart() + ", " + range.getEnd() + ") is out of boundary").toString());
            }
            end = range.getEnd();
        }
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3);
    }

    public final String getText() {
        return this.text;
    }

    public final List<Range<SpanStyle>> getSpanStylesOrNull$ui_text_release() {
        return this.spanStylesOrNull;
    }

    public final List<Range<ParagraphStyle>> getParagraphStylesOrNull$ui_text_release() {
        return this.paragraphStylesOrNull;
    }

    public final List<Range<? extends Object>> getAnnotations$ui_text_release() {
        return this.annotations;
    }

    public final List<Range<SpanStyle>> getSpanStyles() {
        List<Range<SpanStyle>> list = this.spanStylesOrNull;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<Range<ParagraphStyle>> getParagraphStyles() {
        List<Range<ParagraphStyle>> list = this.paragraphStylesOrNull;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AnnotatedString(String str, List<Range<SpanStyle>> list, List<Range<ParagraphStyle>> list2) {
        List<Range<SpanStyle>> list3 = list;
        List<Range<ParagraphStyle>> list4 = list2;
        this(str, list3.isEmpty() ? null : list3, list4.isEmpty() ? null : list4, null);
    }

    public int getLength() {
        return this.text.length();
    }

    public char get(int index) {
        return this.text.charAt(index);
    }

    @Override // java.lang.CharSequence
    public AnnotatedString subSequence(int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            throw new IllegalArgumentException(("start (" + startIndex + ") should be less or equal to end (" + endIndex + ')').toString());
        }
        if (startIndex == 0 && endIndex == this.text.length()) {
            return this;
        }
        String strSubstring = this.text.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return new AnnotatedString(strSubstring, AnnotatedStringKt.filterRanges(this.spanStylesOrNull, startIndex, endIndex), AnnotatedStringKt.filterRanges(this.paragraphStylesOrNull, startIndex, endIndex), AnnotatedStringKt.filterRanges(this.annotations, startIndex, endIndex));
    }

    /* renamed from: subSequence-5zc-tL8, reason: not valid java name */
    public final AnnotatedString m1698subSequence5zctL8(long range) {
        return subSequence(TextRange.m1790getMinimpl(range), TextRange.m1789getMaximpl(range));
    }

    public final AnnotatedString plus(AnnotatedString other) {
        Builder builder = new Builder(this);
        builder.append(other);
        return builder.toAnnotatedString();
    }

    public final List<Range<TtsAnnotation>> getTtsAnnotations(int start, int end) {
        List listEmptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Object> range = list.get(i);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof TtsAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    listEmptyList.add(range);
                }
            }
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return listEmptyList;
    }

    @Deprecated
    public final List<Range<UrlAnnotation>> getUrlAnnotations(int start, int end) {
        List listEmptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Object> range = list.get(i);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof UrlAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    listEmptyList.add(range);
                }
            }
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return listEmptyList;
    }

    public final List<Range<LinkAnnotation>> getLinkAnnotations(int start, int end) {
        List listEmptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Range<? extends Object> range = list.get(i);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof LinkAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    listEmptyList.add(range);
                }
            }
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return listEmptyList;
    }

    public final boolean hasLinkAnnotations(int start, int end) {
        List<Range<? extends Object>> list = this.annotations;
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Range<? extends Object> range = list.get(i);
            if ((range.getItem() instanceof LinkAnnotation) && AnnotatedStringKt.intersect(start, end, range.getStart(), range.getEnd())) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) other;
        return Intrinsics.areEqual(this.text, annotatedString.text) && Intrinsics.areEqual(this.spanStylesOrNull, annotatedString.spanStylesOrNull) && Intrinsics.areEqual(this.paragraphStylesOrNull, annotatedString.paragraphStylesOrNull) && Intrinsics.areEqual(this.annotations, annotatedString.annotations);
    }

    public int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        List<Range<SpanStyle>> list = this.spanStylesOrNull;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Range<ParagraphStyle>> list2 = this.paragraphStylesOrNull;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Range<? extends Object>> list3 = this.annotations;
        return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text;
    }

    public final boolean hasEqualAnnotations(AnnotatedString other) {
        return Intrinsics.areEqual(this.annotations, other.annotations);
    }

    /* compiled from: AnnotatedString.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u000fJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001c\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0012¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "", "item", "", "start", "end", "", RemoteMessageConst.Notification.TAG, "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "(Ljava/lang/Object;II)V", "component1", "()Ljava/lang/Object;", "component2", "()I", "component3", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getItem", "I", "getStart", "getEnd", "Ljava/lang/String;", "getTag", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Range<T> {
        private final int end;
        private final T item;
        private final int start;
        private final String tag;

        public final T component1() {
            return this.item;
        }

        /* renamed from: component2, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: component3, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Range)) {
                return false;
            }
            Range range = (Range) other;
            return Intrinsics.areEqual(this.item, range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual(this.tag, range.tag);
        }

        public int hashCode() {
            T t = this.item;
            return ((((((t == null ? 0 : t.hashCode()) * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end)) * 31) + this.tag.hashCode();
        }

        public String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
        }

        public Range(T t, int i, int i2, String str) {
            this.item = t;
            this.start = i;
            this.end = i2;
            this.tag = str;
            if (i > i2) {
                throw new IllegalArgumentException("Reversed range is not supported");
            }
        }

        public final int getEnd() {
            return this.end;
        }

        public final T getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        public final String getTag() {
            return this.tag;
        }

        public Range(T t, int i, int i2) {
            this(t, i, i2, "");
        }
    }

    /* compiled from: AnnotatedString.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001(B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000b\u0010\u0012J\u0015\u0010\u000b\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\tJ%\u0010\u000b\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0014J%\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\b\u001a\u00060\u001dj\u0002`\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001fR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\"\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020%0!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010#R\"\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020%0!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010#¨\u0006)"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "capacity", "<init>", "(I)V", "Landroidx/compose/ui/text/AnnotatedString;", "text", "(Landroidx/compose/ui/text/AnnotatedString;)V", "", "append", "(Ljava/lang/CharSequence;)Landroidx/compose/ui/text/AnnotatedString$Builder;", "start", "end", "(Ljava/lang/CharSequence;II)Landroidx/compose/ui/text/AnnotatedString$Builder;", "", "char", "(C)Landroidx/compose/ui/text/AnnotatedString$Builder;", "", "(Landroidx/compose/ui/text/AnnotatedString;II)V", "Landroidx/compose/ui/text/SpanStyle;", "style", "addStyle", "(Landroidx/compose/ui/text/SpanStyle;II)V", "Landroidx/compose/ui/text/ParagraphStyle;", "(Landroidx/compose/ui/text/ParagraphStyle;II)V", "toAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "spanStyles", "Ljava/util/List;", "paragraphStyles", "", "annotations", "styleStack", "MutableRange", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder implements Appendable {
        private final List<MutableRange<? extends Object>> annotations;
        private final List<MutableRange<ParagraphStyle>> paragraphStyles;
        private final List<MutableRange<SpanStyle>> spanStyles;
        private final List<MutableRange<? extends Object>> styleStack;
        private final StringBuilder text;

        public Builder(int i) {
            this.text = new StringBuilder(i);
            this.spanStyles = new ArrayList();
            this.paragraphStyles = new ArrayList();
            this.annotations = new ArrayList();
            this.styleStack = new ArrayList();
        }

        public /* synthetic */ Builder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 16 : i);
        }

        /* compiled from: AnnotatedString.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "T", "", "item", "", "start", "end", "", RemoteMessageConst.Notification.TAG, "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "defaultEnd", "Landroidx/compose/ui/text/AnnotatedString$Range;", "toRange", "(I)Landroidx/compose/ui/text/AnnotatedString$Range;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getItem", "()Ljava/lang/Object;", "I", "getStart", "getEnd", "setEnd", "(I)V", "Ljava/lang/String;", "getTag", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private static final /* data */ class MutableRange<T> {
            private int end;
            private final T item;
            private final int start;
            private final String tag;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) other;
                return Intrinsics.areEqual(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual(this.tag, mutableRange.tag);
            }

            public int hashCode() {
                T t = this.item;
                return ((((((t == null ? 0 : t.hashCode()) * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end)) * 31) + this.tag.hashCode();
            }

            public String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
            }

            public MutableRange(T t, int i, int i2, String str) {
                this.item = t;
                this.start = i;
                this.end = i2;
                this.tag = str;
            }

            public /* synthetic */ MutableRange(Object obj, int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, i, (i3 & 4) != 0 ? Integer.MIN_VALUE : i2, (i3 & 8) != 0 ? "" : str);
            }

            public final Range<T> toRange(int defaultEnd) {
                int i = this.end;
                if (i != Integer.MIN_VALUE) {
                    defaultEnd = i;
                }
                if (defaultEnd == Integer.MIN_VALUE) {
                    throw new IllegalStateException("Item.end should be set first");
                }
                return new Range<>(this.item, this.start, defaultEnd, this.tag);
            }
        }

        public Builder(AnnotatedString annotatedString) {
            this(0, 1, null);
            append(annotatedString);
        }

        @Override // java.lang.Appendable
        public Builder append(CharSequence text) {
            if (text instanceof AnnotatedString) {
                append((AnnotatedString) text);
            } else {
                this.text.append(text);
            }
            return this;
        }

        @Override // java.lang.Appendable
        public Builder append(CharSequence text, int start, int end) {
            if (text instanceof AnnotatedString) {
                append((AnnotatedString) text, start, end);
            } else {
                this.text.append(text, start, end);
            }
            return this;
        }

        @Override // java.lang.Appendable
        public Builder append(char c) {
            this.text.append(c);
            return this;
        }

        public final void append(AnnotatedString text) {
            int length = this.text.length();
            this.text.append(text.getText());
            List<Range<SpanStyle>> spanStylesOrNull$ui_text_release = text.getSpanStylesOrNull$ui_text_release();
            if (spanStylesOrNull$ui_text_release != null) {
                int size = spanStylesOrNull$ui_text_release.size();
                for (int i = 0; i < size; i++) {
                    Range<SpanStyle> range = spanStylesOrNull$ui_text_release.get(i);
                    addStyle(range.getItem(), range.getStart() + length, range.getEnd() + length);
                }
            }
            List<Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release = text.getParagraphStylesOrNull$ui_text_release();
            if (paragraphStylesOrNull$ui_text_release != null) {
                int size2 = paragraphStylesOrNull$ui_text_release.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Range<ParagraphStyle> range2 = paragraphStylesOrNull$ui_text_release.get(i2);
                    addStyle(range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
                }
            }
            List<Range<? extends Object>> annotations$ui_text_release = text.getAnnotations$ui_text_release();
            if (annotations$ui_text_release != null) {
                int size3 = annotations$ui_text_release.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    Range<? extends Object> range3 = annotations$ui_text_release.get(i3);
                    this.annotations.add(new MutableRange<>(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
                }
            }
        }

        public final void append(AnnotatedString text, int start, int end) {
            int length = this.text.length();
            this.text.append((CharSequence) text.getText(), start, end);
            List localSpanStyles = AnnotatedStringKt.getLocalSpanStyles(text, start, end);
            if (localSpanStyles != null) {
                int size = localSpanStyles.size();
                for (int i = 0; i < size; i++) {
                    Range range = (Range) localSpanStyles.get(i);
                    addStyle((SpanStyle) range.getItem(), range.getStart() + length, range.getEnd() + length);
                }
            }
            List localParagraphStyles = AnnotatedStringKt.getLocalParagraphStyles(text, start, end);
            if (localParagraphStyles != null) {
                int size2 = localParagraphStyles.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Range range2 = (Range) localParagraphStyles.get(i2);
                    addStyle((ParagraphStyle) range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
                }
            }
            List localAnnotations = AnnotatedStringKt.getLocalAnnotations(text, start, end);
            if (localAnnotations != null) {
                int size3 = localAnnotations.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    Range range3 = (Range) localAnnotations.get(i3);
                    this.annotations.add(new MutableRange<>(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
                }
            }
        }

        public final void addStyle(SpanStyle style, int start, int end) {
            this.spanStyles.add(new MutableRange<>(style, start, end, null, 8, null));
        }

        public final void addStyle(ParagraphStyle style, int start, int end) {
            this.paragraphStyles.add(new MutableRange<>(style, start, end, null, 8, null));
        }

        public final AnnotatedString toAnnotatedString() {
            String string = this.text.toString();
            List<MutableRange<SpanStyle>> list = this.spanStyles;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(list.get(i).toRange(this.text.length()));
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            List<MutableRange<ParagraphStyle>> list2 = this.paragraphStyles;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                arrayList2.add(list2.get(i2).toRange(this.text.length()));
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            List<MutableRange<? extends Object>> list3 = this.annotations;
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size3 = list3.size();
            for (int i3 = 0; i3 < size3; i3++) {
                arrayList3.add(list3.get(i3).toRange(this.text.length()));
            }
            return new AnnotatedString(string, arrayList, arrayList2, arrayList3.isEmpty() ? null : arrayList3);
        }
    }
}
