package ru.yoomoney.sdk.kassa.payments.secure;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.f0;
import ru.yoomoney.sdk.kassa.payments.metrics.r;
import ru.yoomoney.sdk.kassa.payments.model.o0;

/* loaded from: classes5.dex */
public abstract class b {
    public static final KeyStore a(Context context, char[] cArr, r rVar) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("BouncyCastle");
        try {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput("bc.keystore");
            try {
                keyStore.load(fileInputStreamOpenFileInput, cArr);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStreamOpenFileInput, null);
            } finally {
            }
        } catch (FileNotFoundException e) {
            ((f0) rVar).a(new o0(e));
            keyStore.load(null);
        }
        Intrinsics.checkNotNullExpressionValue(keyStore, "apply(...)");
        return keyStore;
    }
}
