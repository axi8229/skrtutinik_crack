package ru.yoomoney.sdk.auth.utils;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"phoneUtil", "Lcom/google/i18n/phonenumbers/PhoneNumberUtil;", "getPhoneUtil", "()Lcom/google/i18n/phonenumbers/PhoneNumberUtil;", "formatAndMaskNumber", "", "str", "region", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneUtilsKt {
    private static final PhoneNumberUtil phoneUtil;

    static {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Intrinsics.checkNotNullExpressionValue(phoneNumberUtil, "getInstance(...)");
        phoneUtil = phoneNumberUtil;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String formatAndMaskNumber(String str, String str2) {
        Object objM2628constructorimpl;
        Intrinsics.checkNotNullParameter(str, "str");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM2628constructorimpl = Result.m2628constructorimpl(phoneUtil.parse(str, str2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM2628constructorimpl = Result.m2628constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2634isSuccessimpl(objM2628constructorimpl)) {
            objM2628constructorimpl = phoneUtil.format((Phonenumber$PhoneNumber) objM2628constructorimpl, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
        }
        Object objM2628constructorimpl2 = Result.m2628constructorimpl(objM2628constructorimpl);
        if (!Result.m2633isFailureimpl(objM2628constructorimpl2)) {
            str = objM2628constructorimpl2;
        }
        return str;
    }

    public static /* synthetic */ String formatAndMaskNumber$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return formatAndMaskNumber(str, str2);
    }

    public static final PhoneNumberUtil getPhoneUtil() {
        return phoneUtil;
    }
}
