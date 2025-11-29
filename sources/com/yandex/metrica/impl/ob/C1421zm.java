package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.RequestBodyEncrypter;
import com.yandex.metrica.networktasks.api.RequestBodyEncryptionMode;

/* renamed from: com.yandex.metrica.impl.ob.zm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1421zm implements RequestBodyEncrypter {
    private C1397ym a;

    public C1421zm() {
        this(new C1397ym());
    }

    @Override // com.yandex.metrica.networktasks.api.RequestBodyEncrypter
    public byte[] encrypt(byte[] bArr) {
        return this.a.a(bArr);
    }

    @Override // com.yandex.metrica.networktasks.api.RequestBodyEncrypter
    public RequestBodyEncryptionMode getEncryptionMode() {
        return RequestBodyEncryptionMode.AES_RSA;
    }

    C1421zm(C1397ym c1397ym) {
        this.a = c1397ym;
    }
}
