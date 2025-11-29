package ru.yoomoney.sdk.kassa.payments.di.module;

import java.io.FileNotFoundException;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class c0 extends Lambda implements Function0 {
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.secure.a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(ru.yoomoney.sdk.kassa.payments.secure.a aVar) {
        super(0);
        this.a = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, FileNotFoundException {
        ru.yoomoney.sdk.kassa.payments.secure.a aVar = this.a;
        aVar.getClass();
        Intrinsics.checkNotNullParameter("cipherKey", "key");
        Intrinsics.checkNotNullParameter("cipherKey", "key");
        Key key = aVar.c.getKey("cipherKey", null);
        if (key != null) {
            return key;
        }
        SecretKey secretKeyGenerateKey = KeyGenerator.getInstance("AES").generateKey();
        aVar.c.setKeyEntry("cipherKey", secretKeyGenerateKey, null, null);
        aVar.a();
        Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "also(...)");
        return secretKeyGenerateKey;
    }
}
