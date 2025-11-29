package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.yandex.metrica.impl.ob.wm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1349wm {
    private final String a;
    private final byte[] b;
    private final byte[] c;

    public C1349wm(String str, byte[] bArr, byte[] bArr2) {
        this.a = str;
        this.b = bArr;
        this.c = bArr2;
    }

    @SuppressLint({"TrulyRandom"})
    public byte[] a(byte[] bArr) throws Throwable {
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.b, "AES");
        Cipher cipher = Cipher.getInstance(this.a);
        cipher.init(1, secretKeySpec, new IvParameterSpec(this.c));
        return cipher.doFinal(bArr);
    }

    public byte[] a(byte[] bArr, int i, int i2) throws Throwable {
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.b, "AES");
        Cipher cipher = Cipher.getInstance(this.a);
        cipher.init(2, secretKeySpec, new IvParameterSpec(this.c));
        return cipher.doFinal(bArr, i, i2);
    }
}
