package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.helper.Compiler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FormatSanitizer.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/redmadrobot/inputmask/helper/FormatSanitizer;", "", "()V", "checkOpenBraces", "", "string", "", "divideBlocksWithMixedCharacters", "", "blocks", "getFormatBlocks", "formatString", "sanitize", "sortFormatBlocks", "input-mask-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FormatSanitizer {
    public final String sanitize(String formatString) throws Compiler.FormatError {
        Intrinsics.checkNotNullParameter(formatString, "formatString");
        checkOpenBraces(formatString);
        return CollectionsKt.joinToString$default(sortFormatBlocks(divideBlocksWithMixedCharacters(getFormatBlocks(formatString))), "", null, null, 0, null, null, 62, null);
    }

    private final List<String> getFormatBlocks(String formatString) {
        ArrayList arrayList = new ArrayList();
        if (formatString != null) {
            char[] charArray = formatString.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
            int length = charArray.length;
            String strStringPlus = "";
            int i = 0;
            boolean z = false;
            while (i < length) {
                char c = charArray[i];
                i++;
                if ('\\' == c && !z) {
                    strStringPlus = Intrinsics.stringPlus(strStringPlus, Character.valueOf(c));
                    z = true;
                } else {
                    if (('[' == c || '{' == c) && !z) {
                        if (strStringPlus.length() > 0) {
                            arrayList.add(strStringPlus);
                        }
                        strStringPlus = "";
                    }
                    strStringPlus = Intrinsics.stringPlus(strStringPlus, Character.valueOf(c));
                    if ((']' == c || '}' == c) && !z) {
                        arrayList.add(strStringPlus);
                        strStringPlus = "";
                    }
                    z = false;
                }
            }
            if (strStringPlus.length() != 0) {
                arrayList.add(strStringPlus);
            }
            return arrayList;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<java.lang.String> divideBlocksWithMixedCharacters(java.util.List<java.lang.String> r19) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.redmadrobot.inputmask.helper.FormatSanitizer.divideBlocksWithMixedCharacters(java.util.List):java.util.List");
    }

    private final List<String> sortFormatBlocks(List<String> blocks) {
        ArrayList arrayList = new ArrayList();
        for (String string : blocks) {
            if (StringsKt.startsWith$default(string, "[", false, 2, (Object) null)) {
                if (StringsKt.contains$default((CharSequence) string, (CharSequence) "0", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) string, (CharSequence) "9", false, 2, (Object) null)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('[');
                    String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(string, "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
                    if (strReplace$default == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    char[] charArray = strReplace$default.toCharArray();
                    Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
                    sb.append(CollectionsKt.joinToString$default(ArraysKt.sorted(charArray), "", null, null, 0, null, null, 62, null));
                    sb.append(']');
                    string = sb.toString();
                } else if (StringsKt.contains$default((CharSequence) string, (CharSequence) "a", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) string, (CharSequence) "A", false, 2, (Object) null)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('[');
                    String strReplace$default2 = StringsKt.replace$default(StringsKt.replace$default(string, "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
                    if (strReplace$default2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    char[] charArray2 = strReplace$default2.toCharArray();
                    Intrinsics.checkNotNullExpressionValue(charArray2, "(this as java.lang.String).toCharArray()");
                    sb2.append(CollectionsKt.joinToString$default(ArraysKt.sorted(charArray2), "", null, null, 0, null, null, 62, null));
                    sb2.append(']');
                    string = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append('[');
                    String strReplace$default3 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(string, "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null), "_", "A", false, 4, (Object) null), "-", "a", false, 4, (Object) null);
                    if (strReplace$default3 != null) {
                        char[] charArray3 = strReplace$default3.toCharArray();
                        Intrinsics.checkNotNullExpressionValue(charArray3, "(this as java.lang.String).toCharArray()");
                        sb3.append(CollectionsKt.joinToString$default(ArraysKt.sorted(charArray3), "", null, null, 0, null, null, 62, null));
                        sb3.append(']');
                        string = StringsKt.replace$default(StringsKt.replace$default(sb3.toString(), "A", "_", false, 4, (Object) null), "a", "-", false, 4, (Object) null);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
            arrayList.add(string);
        }
        return arrayList;
    }

    private final void checkOpenBraces(String string) throws Compiler.FormatError {
        if (string != null) {
            char[] charArray = string.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
            int length = charArray.length;
            int i = 0;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            while (i < length) {
                char c = charArray[i];
                i++;
                if ('\\' == c) {
                    z = !z;
                } else {
                    if ('[' == c) {
                        if (z2) {
                            throw new Compiler.FormatError();
                        }
                        z2 = !z;
                    }
                    if (']' == c && !z) {
                        z2 = false;
                    }
                    if ('{' == c) {
                        if (z3) {
                            throw new Compiler.FormatError();
                        }
                        z3 = !z;
                    }
                    if ('}' == c && !z) {
                        z3 = false;
                    }
                    z = false;
                }
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
