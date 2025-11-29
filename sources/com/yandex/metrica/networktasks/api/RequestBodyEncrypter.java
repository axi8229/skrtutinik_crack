package com.yandex.metrica.networktasks.api;

/* loaded from: classes3.dex */
public interface RequestBodyEncrypter {
    byte[] encrypt(byte[] bArr);

    RequestBodyEncryptionMode getEncryptionMode();
}
