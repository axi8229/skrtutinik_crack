package ru.yoomoney.sdk.auth.phone.enter.utils;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/utils/PhoneNumberInputFilter;", "Landroid/text/InputFilter;", "prefix", "", "(Ljava/lang/String;)V", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneNumberInputFilter implements InputFilter {
    private final String prefix;

    public PhoneNumberInputFilter(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.prefix = prefix;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (dend >= this.prefix.length() || !StringsKt.startsWith$default(dest.toString(), this.prefix, false, 2, (Object) null)) {
            return new Regex("[^\\d+()\\- ]").replace(source.subSequence(start, end).toString(), "");
        }
        if (!Intrinsics.areEqual(source, "")) {
            return "";
        }
        String strSubstring = this.prefix.substring(0, dend);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }
}
