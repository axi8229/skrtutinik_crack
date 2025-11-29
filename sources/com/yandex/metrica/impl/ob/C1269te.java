package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1199qf;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* renamed from: com.yandex.metrica.impl.ob.te, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1269te {
    private final D9 a = new D9();

    public C1199qf.d.a.b[] a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return new C1199qf.d.a.b[0];
        }
        Map<String, byte[]> model = this.a.toModel(bArr);
        int size = model.size();
        C1199qf.d.a.b[] bVarArr = new C1199qf.d.a.b[size];
        for (int i2 = 0; i2 < size; i2++) {
            bVarArr[i2] = new C1199qf.d.a.b();
        }
        for (Object obj : ((LinkedHashMap) model).entrySet()) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C1199qf.d.a.b bVar = bVarArr[i];
            String str = (String) entry.getKey();
            Charset charset = Charsets.UTF_8;
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            bVar.a = bytes;
            bVar.b = (byte[]) entry.getValue();
            i = i3;
        }
        return bVarArr;
    }
}
