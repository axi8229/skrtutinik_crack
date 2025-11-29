package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes3.dex */
public final class R6 implements Converter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0926ff[] fromModel(Map<String, String> map) {
        int size = map.size();
        C0926ff[] c0926ffArr = new C0926ff[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c0926ffArr[i2] = new C0926ff();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            C0926ff c0926ff = c0926ffArr[i];
            String key = entry.getKey();
            Charset charset = Charsets.UTF_8;
            if (key == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = key.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            c0926ff.a = bytes;
            C0926ff c0926ff2 = c0926ffArr[i];
            String value = entry.getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes2 = value.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
            c0926ff2.b = bytes2;
            i++;
        }
        return c0926ffArr;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }
}
