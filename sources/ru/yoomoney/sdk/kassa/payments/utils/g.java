package ru.yoomoney.sdk.kassa.payments.utils;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* loaded from: classes5.dex */
public final class g implements InputFilter {
    public g() {
        Intrinsics.checkNotNullParameter("[^\\d ]*", "pattern");
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence source, int i, int i2, Spanned dest, int i3, int i4) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        String strReplace = new Regex("[^\\d ]*").replace(source.subSequence(i, i2).toString(), "");
        int length = strReplace.length() - 1;
        int i5 = 0;
        boolean z = false;
        while (i5 <= length) {
            boolean z2 = Intrinsics.compare((int) strReplace.charAt(!z ? i5 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i5++;
            } else {
                z = true;
            }
        }
        return strReplace.subSequence(i5, length + 1).toString();
    }
}
