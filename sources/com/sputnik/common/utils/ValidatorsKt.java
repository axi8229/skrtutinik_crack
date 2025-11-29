package com.sputnik.common.utils;

import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Validators.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"isValidPhone", "", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "countryCode", "", "rawPhone", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ValidatorsKt {
    public static final boolean isValidPhone(PhoneNumberUtil phoneNumberUtil, String countryCode, String str) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(phoneNumberUtil, "<this>");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        if (str == null) {
            return false;
        }
        int i = Integer.parseInt(countryCode);
        int length = String.valueOf(i).length() + str.length();
        if (10 <= length && length < 17) {
            try {
                phoneNumberUtil.parse(str, phoneNumberUtil.getRegionCodeForCountryCode(i));
                return true;
            } catch (NumberParseException unused) {
            }
        }
        return false;
    }
}
