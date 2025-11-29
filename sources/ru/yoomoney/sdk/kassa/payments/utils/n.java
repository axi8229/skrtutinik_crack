package ru.yoomoney.sdk.kassa.payments.utils;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class n implements TextWatcher {
    public String a;

    public static String a(String str) {
        int length = str.length();
        if (length <= 2) {
            return str;
        }
        String strSubstring = str.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = str.substring(2, length);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return strSubstring + "/" + strSubstring2;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
        String string = s.toString();
        if (Intrinsics.areEqual(string, this.a)) {
            return;
        }
        this.a = string;
        StringBuilder sb = new StringBuilder();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = string.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        int length2 = string2.length();
        if (length2 > 0) {
            char cCharAt2 = string2.charAt(0);
            if (cCharAt2 == '0') {
                if (length2 > 1 && string2.charAt(1) == '0') {
                    string2 = string2.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
                }
            } else if (cCharAt2 == '1') {
                if (length2 > 1) {
                    char cCharAt3 = string2.charAt(1);
                    if (cCharAt3 != '0' && cCharAt3 != '1' && cCharAt3 != '2') {
                        string2 = string2.substring(0, 1);
                        Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
                    }
                }
            } else if (length2 == 1) {
                string2 = "0" + string2;
            } else {
                string2 = "";
            }
            string2 = a(string2);
        }
        s.replace(0, s.length(), string2);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(s, "s");
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence s, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(s, "s");
    }
}
