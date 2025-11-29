package ru.yoomoney.sdk.kassa.payments.secure;

import android.content.Context;
import android.util.Base64;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
public abstract class h {
    public static String a;

    public static final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (a == null) {
            StringBuilder sb = new StringBuilder(ru.yoomoney.sdk.kassa.payments.extensions.g.a(context));
            String strB = ru.yoomoney.sdk.kassa.payments.extensions.g.b(context);
            if (strB.length() > 0) {
                sb.append(':');
                sb.append(strB);
            }
            String data = sb.toString();
            Intrinsics.checkNotNullExpressionValue(data, "toString(...)");
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] data2 = data.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(data2, "getBytes(...)");
            Intrinsics.checkNotNullParameter(data2, "data");
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(data2);
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
            String strEncodeToString = Base64.encodeToString(bArrDigest, 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            a = strEncodeToString;
        }
        String str = a;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("password");
        return null;
    }
}
