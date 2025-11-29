package npi.spay;

import android.util.Base64;
import android.util.Patterns;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* renamed from: npi.spay.tj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1946tj {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return Intrinsics.areEqual(upperCase, "RUB") ? "₽" : "";
    }

    public static final String b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decoded = Base64.decode(str, 0);
        Intrinsics.checkNotNullExpressionValue(decoded, "decoded");
        return new String(decoded, Charsets.UTF_8);
    }

    public static final String c(String str) {
        if (Intrinsics.areEqual(str, "-1")) {
            return null;
        }
        return str;
    }

    public static int d(String str) {
        String strReplace$default;
        Integer intOrNull;
        if (str == null || (strReplace$default = StringsKt.replace$default(str, " ", "", false, 4, (Object) null)) == null || (intOrNull = StringsKt.toIntOrNull(strReplace$default)) == null) {
            return 0;
        }
        return intOrNull.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v12, types: [T, npi.spay.B4] */
    /* JADX WARN: Type inference failed for: r15v5, types: [T, npi.spay.B4] */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, npi.spay.B4] */
    public static final B4 e(String str) {
        IntRange range;
        IntRange range2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new B4("", CollectionsKt.emptyList(), CollectionsKt.emptyList());
        String string = Patterns.WEB_URL.toString();
        Intrinsics.checkNotNullExpressionValue(string, "WEB_URL.toString()");
        String strReplace = new Regex(string).replace(str, new C1921sj(ref$ObjectRef));
        while (StringsKt.contains$default((CharSequence) strReplace, (CharSequence) "<url=>", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) strReplace, (CharSequence) "</url>", false, 2, (Object) null)) {
            MatchResult matchResultFind$default = Regex.find$default(new Regex("<url=>"), strReplace, 0, 2, null);
            Integer numValueOf = (matchResultFind$default == null || (range2 = matchResultFind$default.getRange()) == null) ? null : Integer.valueOf(range2.getFirst());
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            MatchResult matchResultFind$default2 = Regex.find$default(new Regex("</url>"), strReplace, 0, 2, null);
            Integer numValueOf2 = (matchResultFind$default2 == null || (range = matchResultFind$default2.getRange()) == null) ? null : Integer.valueOf(range.getFirst() - 6);
            Intrinsics.checkNotNull(numValueOf2);
            int iIntValue2 = numValueOf2.intValue();
            strReplace = StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(strReplace, "<url=>", "", false, 4, null), "</url>", "", false, 4, null);
            B4 b4 = (B4) ref$ObjectRef.element;
            List mutableList = CollectionsKt.toMutableList((Collection) b4.c);
            mutableList.add(new A4(iIntValue, iIntValue2));
            Unit unit = Unit.INSTANCE;
            ref$ObjectRef.element = B4.a(b4, null, null, mutableList, 3);
        }
        ?? A = B4.a((B4) ref$ObjectRef.element, strReplace, null, null, 6);
        ref$ObjectRef.element = A;
        return A;
    }
}
