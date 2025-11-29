package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import android.text.Html;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.ui.SpannedToHtmlConverter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class SpannedToHtmlConverter {
    private static final Pattern NEWLINE_PATTERN = Pattern.compile("(&#13;)?&#10;");

    public static String convert(CharSequence text) {
        if (text == null) {
            return "";
        }
        if (!(text instanceof Spanned)) {
            return escapeHtml(text);
        }
        Spanned spanned = (Spanned) text;
        SparseArray<Transition> sparseArrayFindSpanTransitions = findSpanTransitions(spanned);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i = 0;
        int i2 = 0;
        while (i < sparseArrayFindSpanTransitions.size()) {
            int iKeyAt = sparseArrayFindSpanTransitions.keyAt(i);
            sb.append(escapeHtml(spanned.subSequence(i2, iKeyAt)));
            Transition transition = sparseArrayFindSpanTransitions.get(iKeyAt);
            Collections.sort(transition.spansRemoved, SpanInfo.FOR_CLOSING_TAGS);
            Iterator it = transition.spansRemoved.iterator();
            while (it.hasNext()) {
                sb.append(((SpanInfo) it.next()).closingTag);
            }
            Collections.sort(transition.spansAdded, SpanInfo.FOR_OPENING_TAGS);
            Iterator it2 = transition.spansAdded.iterator();
            while (it2.hasNext()) {
                sb.append(((SpanInfo) it2.next()).openingTag);
            }
            i++;
            i2 = iKeyAt;
        }
        sb.append(escapeHtml(spanned.subSequence(i2, spanned.length())));
        return sb.toString();
    }

    private static SparseArray<Transition> findSpanTransitions(Spanned spanned) {
        SparseArray<Transition> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String openingTag = getOpeningTag(obj);
            String closingTag = getClosingTag(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (openingTag != null) {
                Assertions.checkNotNull(closingTag);
                SpanInfo spanInfo = new SpanInfo(spanStart, spanEnd, openingTag, closingTag);
                getOrCreate(sparseArray, spanStart).spansAdded.add(spanInfo);
                getOrCreate(sparseArray, spanEnd).spansRemoved.add(spanInfo);
            }
        }
        return sparseArray;
    }

    private static String getOpeningTag(Object span) {
        if (span instanceof ForegroundColorSpan) {
            return Util.formatInvariant("<span style='color:%s;'>", toCssColor(((ForegroundColorSpan) span).getForegroundColor()));
        }
        if (span instanceof HorizontalTextInVerticalContextSpan) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (span instanceof StyleSpan) {
            int style = ((StyleSpan) span).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (span instanceof RubySpan) {
            int i = ((RubySpan) span).position;
            if (i == -1) {
                return "<ruby style='ruby-position:unset;'>";
            }
            if (i == 1) {
                return "<ruby style='ruby-position:over;'>";
            }
            if (i != 2) {
                return null;
            }
            return "<ruby style='ruby-position:under;'>";
        }
        if (span instanceof UnderlineSpan) {
            return "<u>";
        }
        return null;
    }

    private static String getClosingTag(Object span) {
        if ((span instanceof ForegroundColorSpan) || (span instanceof HorizontalTextInVerticalContextSpan)) {
            return "</span>";
        }
        if (span instanceof StyleSpan) {
            int style = ((StyleSpan) span).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style != 3) {
                return null;
            }
            return "</i></b>";
        }
        if (span instanceof RubySpan) {
            return "<rt>" + escapeHtml(((RubySpan) span).rubyText) + "</rt></ruby>";
        }
        if (span instanceof UnderlineSpan) {
            return "</u>";
        }
        return null;
    }

    private static String toCssColor(int color) {
        return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(color)), Integer.valueOf(Color.green(color)), Integer.valueOf(Color.blue(color)), Double.valueOf(Color.alpha(color) / 255.0d));
    }

    private static Transition getOrCreate(SparseArray<Transition> transitions, int key) {
        Transition transition = transitions.get(key);
        if (transition != null) {
            return transition;
        }
        Transition transition2 = new Transition();
        transitions.put(key, transition2);
        return transition2;
    }

    private static String escapeHtml(CharSequence text) {
        return NEWLINE_PATTERN.matcher(Html.escapeHtml(text)).replaceAll("<br>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class SpanInfo {
        public final String closingTag;
        public final int end;
        public final String openingTag;
        public final int start;
        private static final Comparator<SpanInfo> FOR_OPENING_TAGS = new Comparator() { // from class: com.google.android.exoplayer2.ui.SpannedToHtmlConverter$SpanInfo$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SpannedToHtmlConverter.SpanInfo.lambda$static$0((SpannedToHtmlConverter.SpanInfo) obj, (SpannedToHtmlConverter.SpanInfo) obj2);
            }
        };
        private static final Comparator<SpanInfo> FOR_CLOSING_TAGS = new Comparator() { // from class: com.google.android.exoplayer2.ui.SpannedToHtmlConverter$SpanInfo$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SpannedToHtmlConverter.SpanInfo.lambda$static$1((SpannedToHtmlConverter.SpanInfo) obj, (SpannedToHtmlConverter.SpanInfo) obj2);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$static$0(SpanInfo info1, SpanInfo info2) {
            int iCompare = Integer.compare(info2.end, info1.end);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = info1.openingTag.compareTo(info2.openingTag);
            return iCompareTo != 0 ? iCompareTo : info1.closingTag.compareTo(info2.closingTag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$static$1(SpanInfo info1, SpanInfo info2) {
            int iCompare = Integer.compare(info2.start, info1.start);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = info2.openingTag.compareTo(info1.openingTag);
            return iCompareTo != 0 ? iCompareTo : info2.closingTag.compareTo(info1.closingTag);
        }

        private SpanInfo(int start, int end, String openingTag, String closingTag) {
            this.start = start;
            this.end = end;
            this.openingTag = openingTag;
            this.closingTag = closingTag;
        }
    }

    private static final class Transition {
        private final List<SpanInfo> spansAdded = new ArrayList();
        private final List<SpanInfo> spansRemoved = new ArrayList();
    }
}
