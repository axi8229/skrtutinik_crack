package ru.yoomoney.sdk.kassa.payments.secure;

import android.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.di.module.a0;
import ru.yoomoney.sdk.kassa.payments.di.module.b0;

/* loaded from: classes5.dex */
public final class f extends d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(a0 getKey, b0 getIv) {
        super(2, getKey, getIv, 0);
        Intrinsics.checkNotNullParameter(getKey, "getKey");
        Intrinsics.checkNotNullParameter(getIv, "getIv");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws BadPaddingException, IllegalBlockSizeException {
        String input = (String) obj;
        Intrinsics.checkNotNullParameter(input, "input");
        byte[] input2 = Base64.decode(input, 0);
        Intrinsics.checkNotNullExpressionValue(input2, "decode(...)");
        Intrinsics.checkNotNullParameter(input2, "input");
        Lazy lazy = this.d;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cipher");
            lazy = null;
        }
        byte[] bArrDoFinal = ((Cipher) lazy.getValue()).doFinal(input2);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return new String(bArrDoFinal, e.a);
    }
}
