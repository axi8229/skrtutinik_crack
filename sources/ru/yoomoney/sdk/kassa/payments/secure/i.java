package ru.yoomoney.sdk.kassa.payments.secure;

import android.content.SharedPreferences;
import android.util.Base64;
import java.security.SecureRandom;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.extensions.k;

/* loaded from: classes5.dex */
public final class i {
    public final SharedPreferences a;

    public i(SharedPreferences sp) {
        Intrinsics.checkNotNullParameter(sp, "sp");
        this.a = sp;
    }

    public final byte[] a() {
        Intrinsics.checkNotNullParameter("cipherIv", "key");
        String string = this.a.getString("cipherIv", null);
        if (string != null) {
            return Base64.decode(string, 0);
        }
        return null;
    }

    public final byte[] b() {
        Intrinsics.checkNotNullParameter("cipherIv", "key");
        byte[] bArrA = a();
        if (bArrA != null) {
            return bArrA;
        }
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        k.a(this.a, "cipherIv", Base64.encodeToString(bArr, 0));
        return bArr;
    }
}
