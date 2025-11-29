package ru.yoomoney.sdk.kassa.payments.extensions;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2321e;

/* loaded from: classes5.dex */
public abstract class c {
    public static final CharSequence a(EnumC2321e enumC2321e, Context context) {
        int i;
        Intrinsics.checkNotNullParameter(enumC2321e, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        int iOrdinal = enumC2321e.ordinal();
        if (iOrdinal == 0) {
            i = R$string.ym_auth_hint_sms;
        } else if (iOrdinal == 1) {
            i = R$string.ym_auth_hint_totp;
        } else if (iOrdinal == 2) {
            i = R$string.ym_auth_hint_password;
        } else {
            if (iOrdinal != 3) {
                throw new IllegalArgumentException("AuthType " + enumC2321e + " can not be used");
            }
            i = R$string.ym_auth_hint_emergency;
        }
        CharSequence text = context.getText(i);
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return text;
    }
}
