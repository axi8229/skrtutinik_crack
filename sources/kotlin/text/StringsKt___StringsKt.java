package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.SlidingWindowKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Strings.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0010\r\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0019\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\f\u001a\u0019\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\f\u001a\u0019\u0010\u000f\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\f\u001a\u0011\u0010\u0010\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a5\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0013*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001aO\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u001b*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u001cH\u0007¢\u0006\u0004\b\u0019\u0010\u001e¨\u0006\u001f"}, d2 = {"", "", "first", "(Ljava/lang/CharSequence;)C", "last", "lastOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "single", "", "", "n", "drop", "(Ljava/lang/String;I)Ljava/lang/String;", "dropLast", "take", "takeLast", "reversed", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "size", "", "chunked", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "step", "", "partialWindows", "windowed", "(Ljava/lang/CharSequence;IIZ)Ljava/util/List;", "R", "Lkotlin/Function1;", "transform", "(Ljava/lang/CharSequence;IIZLkotlin/jvm/functions/Function1;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes4.dex */
public class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static char first(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    public static char last(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(StringsKt.getLastIndex(charSequence));
    }

    public static Character lastOrNull(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static char single(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static String drop(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
        }
        String strSubstring = str.substring(RangesKt.coerceAtMost(i, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String dropLast(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
        }
        return StringsKt.take(str, RangesKt.coerceAtLeast(str.length() - i, 0));
    }

    public static String take(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
        }
        String strSubstring = str.substring(0, RangesKt.coerceAtMost(i, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String takeLast(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
        }
        int length = str.length();
        String strSubstring = str.substring(length - RangesKt.coerceAtMost(i, length));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence reversed(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        StringBuilder sbReverse = new StringBuilder(charSequence).reverse();
        Intrinsics.checkNotNullExpressionValue(sbReverse, "reverse(...)");
        return sbReverse;
    }

    public static List<String> chunked(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return windowed(charSequence, i, i, true);
    }

    public static final List<String> windowed(CharSequence charSequence, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return windowed(charSequence, i, i2, z, new Function1<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt.windowed.1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(CharSequence it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.toString();
            }
        });
    }

    public static final <R> List<R> windowed(CharSequence charSequence, int i, int i2, boolean z, Function1<? super CharSequence, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        int length = charSequence.length();
        int i3 = 0;
        ArrayList arrayList = new ArrayList((length / i2) + (length % i2 == 0 ? 0 : 1));
        while (i3 >= 0 && i3 < length) {
            int i4 = i3 + i;
            if (i4 < 0 || i4 > length) {
                if (!z) {
                    break;
                }
                i4 = length;
            }
            arrayList.add(transform.invoke(charSequence.subSequence(i3, i4)));
            i3 += i2;
        }
        return arrayList;
    }
}
