package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\b\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0012\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a#\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0007\u001a\u00020\t*\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\n\u001a\u0019\u0010\r\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\u0011\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012\u001a#\u0010\u0011\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0013\u001a#\u0010\u0014\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0012\u001a#\u0010\u0014\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0013\u001a#\u0010\u0015\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0012\u001a#\u0010\u0015\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0013\u001a#\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0012\u001a#\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0013\u001a)\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a!\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001f\u001a\u00020\t*\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0019\u0010\"\u001a\u00020\t*\u00020\t2\u0006\u0010!\u001a\u00020\u0000¢\u0006\u0004\b\"\u0010 \u001a!\u0010#\u001a\u00020\t*\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000¢\u0006\u0004\b#\u0010$\u001a\u0019\u0010#\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b#\u0010 \u001a;\u0010*\u001a\u00020(*\u00020\u00002\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(H\u0000¢\u0006\u0004\b*\u0010+\u001a#\u0010-\u001a\u00020(*\u00020\u00002\u0006\u0010,\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b-\u0010.\u001a#\u0010/\u001a\u00020(*\u00020\u00002\u0006\u0010,\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b/\u0010.\u001a#\u0010-\u001a\u00020(*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b-\u00100\u001a#\u0010/\u001a\u00020(*\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b/\u00100\u001a-\u00103\u001a\u00020\u0003*\u00020\u00002\u0006\u00102\u001a\u0002012\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b3\u00104\u001a-\u00105\u001a\u00020\u0003*\u00020\u00002\u0006\u00102\u001a\u0002012\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b5\u00104\u001a=\u00109\u001a\u00020\u0003*\u00020\u00002\u0006\u0010&\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(2\b\b\u0002\u00106\u001a\u00020(H\u0002¢\u0006\u0004\b7\u00108\u001aG\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010<*\u00020\u00002\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0:2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(2\u0006\u00106\u001a\u00020(H\u0002¢\u0006\u0004\b=\u0010>\u001a-\u00109\u001a\u00020\u0003*\u00020\u00002\u0006\u0010,\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b9\u0010@\u001a-\u00109\u001a\u00020\u0003*\u00020\u00002\u0006\u0010A\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b9\u0010B\u001a-\u0010C\u001a\u00020\u0003*\u00020\u00002\u0006\u0010,\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bC\u0010@\u001a-\u0010C\u001a\u00020\u0003*\u00020\u00002\u0006\u0010A\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bC\u0010B\u001a&\u0010D\u001a\u00020(*\u00020\u00002\u0006\u0010&\u001a\u00020\u00002\b\b\u0002\u0010)\u001a\u00020(H\u0086\u0002¢\u0006\u0004\bD\u00100\u001a&\u0010D\u001a\u00020(*\u00020\u00002\u0006\u0010,\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020(H\u0086\u0002¢\u0006\u0004\bD\u0010.\u001a?\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0G*\u00020\u00002\u0006\u0010E\u001a\u0002012\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010F\u001a\u00020\u0003H\u0002¢\u0006\u0004\bH\u0010I\u001aG\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0G*\u00020\u00002\u000e\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0K2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010F\u001a\u00020\u0003H\u0002¢\u0006\u0004\bH\u0010L\u001a\u0017\u0010N\u001a\u00020M2\u0006\u0010F\u001a\u00020\u0003H\u0000¢\u0006\u0004\bN\u0010O\u001a?\u0010P\u001a\b\u0012\u0004\u0012\u00020\t0G*\u00020\u00002\u0012\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0K\"\u00020\t2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010F\u001a\u00020\u0003¢\u0006\u0004\bP\u0010Q\u001a?\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0R*\u00020\u00002\u0012\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0K\"\u00020\t2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010F\u001a\u00020\u0003¢\u0006\u0004\bS\u0010T\u001a7\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0R*\u00020\u00002\n\u0010E\u001a\u000201\"\u00020\u00052\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010F\u001a\u00020\u0003¢\u0006\u0004\bS\u0010U\u001a1\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0R*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010)\u001a\u00020(2\u0006\u0010F\u001a\u00020\u0003H\u0002¢\u0006\u0004\bV\u0010W\u001a\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0G*\u00020\u0000¢\u0006\u0004\bX\u0010Y\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\t0R*\u00020\u0000¢\u0006\u0004\bZ\u0010[\u001a\u0015\u0010\\\u001a\u0004\u0018\u00010(*\u00020\tH\u0007¢\u0006\u0004\b\\\u0010]\"\u0015\u0010`\u001a\u00020\u000b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b^\u0010_\"\u0015\u0010c\u001a\u00020\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006d"}, d2 = {"", "trim", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "", "length", "", "padChar", "padStart", "(Ljava/lang/CharSequence;IC)Ljava/lang/CharSequence;", "", "(Ljava/lang/String;IC)Ljava/lang/String;", "Lkotlin/ranges/IntRange;", "range", "substring", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "delimiter", "missingDelimiterValue", "substringBefore", "(Ljava/lang/String;CLjava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "substringAfter", "substringBeforeLast", "substringAfterLast", "startIndex", "endIndex", "replacement", "replaceRange", "(Ljava/lang/CharSequence;IILjava/lang/CharSequence;)Ljava/lang/CharSequence;", "removeRange", "(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;", "prefix", "removePrefix", "(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;", "suffix", "removeSuffix", "removeSurrounding", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "thisOffset", "other", "otherOffset", "", "ignoreCase", "regionMatchesImpl", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "char", "startsWith", "(Ljava/lang/CharSequence;CZ)Z", "endsWith", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "", "chars", "indexOfAny", "(Ljava/lang/CharSequence;[CIZ)I", "lastIndexOfAny", "last", "indexOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "indexOf", "", "strings", "Lkotlin/Pair;", "findAnyOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "findAnyOf", "(Ljava/lang/CharSequence;CIZ)I", "string", "(Ljava/lang/CharSequence;Ljava/lang/String;IZ)I", "lastIndexOf", "contains", "delimiters", "limit", "Lkotlin/sequences/Sequence;", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/Sequence;", "rangesDelimitedBy", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "", "requireNonNegativeLimit", "(I)V", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "(Ljava/lang/CharSequence;[CZI)Ljava/util/List;", "split$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "lineSequence", "(Ljava/lang/CharSequence;)Lkotlin/sequences/Sequence;", "lines", "(Ljava/lang/CharSequence;)Ljava/util/List;", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes4.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static CharSequence trim(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zIsWhitespace = CharsKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zIsWhitespace) {
                    break;
                }
                length--;
            } else if (zIsWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final CharSequence padStart(CharSequence charSequence, int i, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        ?? Iterator2 = new IntRange(1, i - charSequence.length()).iterator();
        while (Iterator2.hasNext()) {
            Iterator2.nextInt();
            sb.append(c);
        }
        sb.append(charSequence);
        return sb;
    }

    public static String padStart(String str, int i, char c) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return padStart((CharSequence) str, i, c).toString();
    }

    public static IntRange getIndices(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final String substring(CharSequence charSequence, IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c, str2);
    }

    public static final String substringBefore(String str, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    public static final String substringBefore(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfter(str, c, str2);
    }

    public static String substringAfter(String str, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfter(str, str2, str3);
    }

    public static String substringAfter(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iIndexOf$default + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c, str2);
    }

    public static final String substringBeforeLast(String str, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String substringBeforeLast(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfterLast(str, c, str2);
    }

    public static String substringAfterLast(String str, char c, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iLastIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    public static final String substringAfterLast(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iLastIndexOf$default + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence replaceRange(CharSequence charSequence, int i, int i2, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (i2 < i) {
            throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence, 0, i);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(replacement);
        sb.append(charSequence, i2, charSequence.length());
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return sb;
    }

    public static CharSequence removeRange(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i2 < i) {
            throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
        }
        if (i2 == i) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(charSequence.length() - (i2 - i));
        sb.append(charSequence, 0, i);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(charSequence, i2, charSequence.length());
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        return sb;
    }

    public static String removePrefix(String str, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!StringsKt.startsWith$default((CharSequence) str, prefix, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String removeSuffix(String str, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!StringsKt.endsWith$default((CharSequence) str, suffix, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String removeSurrounding(String str, CharSequence prefix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !StringsKt.startsWith$default((CharSequence) str, prefix, false, 2, (Object) null) || !StringsKt.endsWith$default((CharSequence) str, suffix, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length(), str.length() - suffix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String removeSurrounding(String str, CharSequence delimiter) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return removeSurrounding(str, delimiter, delimiter);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence other, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(i + i4), other.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c, z);
    }

    public static final boolean startsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(0), c, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c, z);
    }

    public static final boolean endsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(StringsKt.getLastIndex(charSequence)), c, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, z);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence prefix, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z && (charSequence instanceof String) && (prefix instanceof String)) {
            return StringsKt.startsWith$default((String) charSequence, (String) prefix, false, 2, (Object) null);
        }
        return regionMatchesImpl(charSequence, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, charSequence2, z);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence suffix, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!z && (charSequence instanceof String) && (suffix instanceof String)) {
            return StringsKt.endsWith$default((String) charSequence, (String) suffix, false, 2, (Object) null);
        }
        return regionMatchesImpl(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final int indexOfAny(CharSequence charSequence, char[] chars, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.single(chars), i);
        }
        ?? Iterator2 = new IntRange(RangesKt.coerceAtLeast(i, 0), StringsKt.getLastIndex(charSequence)).iterator();
        while (Iterator2.hasNext()) {
            int iNextInt = Iterator2.nextInt();
            char cCharAt = charSequence.charAt(iNextInt);
            for (char c : chars) {
                if (CharsKt__CharKt.equals(c, cCharAt, z)) {
                    return iNextInt;
                }
            }
        }
        return -1;
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] chars, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.single(chars), i);
        }
        for (int iCoerceAtMost = RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)); -1 < iCoerceAtMost; iCoerceAtMost--) {
            char cCharAt = charSequence.charAt(iCoerceAtMost);
            for (char c : chars) {
                if (CharsKt__CharKt.equals(c, cCharAt, z)) {
                    return iCoerceAtMost;
                }
            }
        }
        return -1;
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, z2);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgressionDownTo;
        if (!z2) {
            intProgressionDownTo = new IntRange(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtMost(i2, charSequence.length()));
        } else {
            intProgressionDownTo = RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), RangesKt.coerceAtLeast(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = intProgressionDownTo.getFirst();
            int last = intProgressionDownTo.getLast();
            int step = intProgressionDownTo.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return -1;
            }
            while (!StringsKt.regionMatches((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = intProgressionDownTo.getFirst();
        int last2 = intProgressionDownTo.getLast();
        int step2 = intProgressionDownTo.getStep();
        if ((step2 <= 0 || first2 > last2) && (step2 >= 0 || last2 > first2)) {
            return -1;
        }
        while (!regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
        return first2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object next;
        Object next2;
        if (!z && collection.size() == 1) {
            String str = (String) CollectionsKt.single(collection);
            int iIndexOf$default = !z2 ? StringsKt.indexOf$default(charSequence, str, i, false, 4, (Object) null) : StringsKt.lastIndexOf$default(charSequence, str, i, false, 4, (Object) null);
            if (iIndexOf$default < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(iIndexOf$default), str);
        }
        IntProgression intRange = !z2 ? new IntRange(RangesKt.coerceAtLeast(i, 0), charSequence.length()) : RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (StringsKt.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += step;
                    } else {
                        return TuplesKt.to(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            int step2 = intRange.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step2;
                    } else {
                        return TuplesKt.to(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, c, i, z);
    }

    public static final int indexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? indexOfAny(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static final int indexOf(CharSequence charSequence, String string, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (z || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt$default(charSequence, string, i, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(string, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c, i, z);
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? lastIndexOfAny(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i, z);
    }

    public static final int lastIndexOf(CharSequence charSequence, String string, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (z || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt(charSequence, string, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(string, i);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, charSequence2, z);
    }

    public static boolean contains(CharSequence charSequence, CharSequence other, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof String) {
            if (StringsKt.indexOf$default(charSequence, (String) other, 0, z, 2, (Object) null) < 0) {
                return false;
            }
        } else if (indexOf$StringsKt__StringsKt$default(charSequence, other, 0, charSequence.length(), z, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c, z);
    }

    public static final boolean contains(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return StringsKt.indexOf$default(charSequence, c, 0, z, 2, (Object) null) >= 0;
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        requireNonNegativeLimit(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence $receiver, int i3) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                int iIndexOfAny = StringsKt__StringsKt.indexOfAny($receiver, cArr, i3, z);
                if (iIndexOfAny < 0) {
                    return null;
                }
                return TuplesKt.to(Integer.valueOf(iIndexOfAny), 1);
            }
        });
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        requireNonNegativeLimit(i2);
        final List listAsList = ArraysKt.asList(strArr);
        return new DelimitedRangesSequence(charSequence, i, i2, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence $receiver, int i3) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                Pair pairFindAnyOf$StringsKt__StringsKt = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, listAsList, i3, z, false);
                if (pairFindAnyOf$StringsKt__StringsKt != null) {
                    return TuplesKt.to(pairFindAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(((String) pairFindAnyOf$StringsKt__StringsKt.getSecond()).length()));
                }
                return null;
            }
        });
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, strArr, z, i);
    }

    public static final Sequence<String> splitToSequence(final CharSequence charSequence, String[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z, i, 2, (Object) null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt.splitToSequence.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(IntRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return StringsKt__StringsKt.substring(charSequence, it);
            }
        });
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z, i);
    }

    public static final List<String> split(CharSequence charSequence, String[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        Iterable iterableAsIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, cArr, z, i);
    }

    public static final List<String> split(CharSequence charSequence, char[] delimiters, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(delimiters[0]), z, i);
        }
        Iterable iterableAsIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        requireNonNegativeLimit(i);
        int length = 0;
        int iIndexOf = indexOf(charSequence, str, 0, z);
        if (iIndexOf == -1 || i == 1) {
            return CollectionsKt.listOf(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? RangesKt.coerceAtMost(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iIndexOf).toString());
            length = str.length() + iIndexOf;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iIndexOf = indexOf(charSequence, str, length, z);
        } while (iIndexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static final Sequence<String> lineSequence(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return splitToSequence$default(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> lines(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return SequencesKt.toList(lineSequence(charSequence));
    }

    public static Boolean toBooleanStrictOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual(str, "true")) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }
}
