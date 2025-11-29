package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.a7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0793a7 implements InterfaceC1132nm<File, Z6>, InterfaceC1107mm<File> {
    @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
    public Z6 a(File file) throws IOException {
        String strA = L0.a(file);
        if (!TextUtils.isEmpty(strA)) {
            try {
                return new Z6(strA);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
    public void b(File file) {
        try {
            file.delete();
        } catch (Throwable unused) {
        }
    }
}
