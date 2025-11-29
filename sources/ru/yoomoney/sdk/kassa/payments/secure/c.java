package ru.yoomoney.sdk.kassa.payments.secure;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function0 {
    public final /* synthetic */ d a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(0);
        this.a = dVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        d dVar = this.a;
        cipher.init(dVar.a, (Key) dVar.b.invoke(), new IvParameterSpec((byte[]) dVar.c.invoke()));
        return cipher;
    }
}
