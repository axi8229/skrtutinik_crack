package ru.yoomoney.sdk.two_fa.utils;

import android.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: Base64Utils.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"decodeBase64", "", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Base64UtilsKt {
    public static final String decodeBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArrDecode = Base64.decode(str, 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return new String(bArrDecode, Charsets.UTF_8);
    }
}
