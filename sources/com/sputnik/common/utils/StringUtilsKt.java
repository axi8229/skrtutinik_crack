package com.sputnik.common.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: StringUtils.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0011\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000b\u001a\f\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\u001a\u0013\u0010\f\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000b\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0001¨\u0006\u000f"}, d2 = {"formatSafe", "", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "addSpaces", "length", "", "orEmpty", "(Ljava/lang/Integer;)Ljava/lang/String;", "orNull", "removeSpaces", "toPhoneHash", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StringUtilsKt {
    public static final String formatSafe(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str = String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return format;
        }
    }

    public static final String toPhoneHash(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.replace$default(StringsKt.replace$default(new Regex("[^A-Za-z0-9 ]").replace(str, ""), " ", "", false, 4, (Object) null), "+", "", false, 4, (Object) null);
    }

    public static final String orEmpty(String str) {
        return str == null ? "" : str;
    }

    public static final String orEmpty(Integer num) {
        Object obj = num;
        if (num == null) {
            obj = "";
        }
        return obj.toString();
    }

    public static final String orNull(Integer num) {
        if (num == null) {
            return null;
        }
        return num.toString();
    }

    public static /* synthetic */ String addSpaces$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 4;
        }
        return addSpaces(str, i);
    }

    public static final String addSpaces(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return CollectionsKt.joinToString$default(StringsKt.chunked(removeSpaces(str), i), " ", null, null, 0, null, null, 62, null);
    }

    public static final String removeSpaces(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.replace$default(str, " ", "", false, 4, (Object) null);
    }
}
