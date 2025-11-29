package ru.yoomoney.sdk.kassa.payments.secure;

import android.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.di.module.c0;
import ru.yoomoney.sdk.kassa.payments.di.module.d0;

/* loaded from: classes5.dex */
public final class g extends d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c0 getKey, d0 getIv) {
        super(1, getKey, getIv, 0);
        Intrinsics.checkNotNullParameter(getKey, "getKey");
        Intrinsics.checkNotNullParameter(getIv, "getIv");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws BadPaddingException, IllegalBlockSizeException {
        String input = (String) obj;
        Intrinsics.checkNotNullParameter(input, "input");
        byte[] input2 = input.getBytes(e.a);
        Intrinsics.checkNotNullExpressionValue(input2, "getBytes(...)");
        Intrinsics.checkNotNullParameter(input2, "input");
        Lazy lazy = this.d;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cipher");
            lazy = null;
        }
        byte[] bArrDoFinal = ((Cipher) lazy.getValue()).doFinal(input2);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        String strEncodeToString = Base64.encodeToString(bArrDoFinal, 0);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
