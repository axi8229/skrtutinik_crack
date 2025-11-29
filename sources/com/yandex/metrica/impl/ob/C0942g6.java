package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* renamed from: com.yandex.metrica.impl.ob.g6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0942g6 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Gf fromModel(Map<String, byte[]> map) {
        Gf gf = new Gf();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            Hf hf = new Hf();
            String key = entry.getKey();
            Charset charset = Charsets.UTF_8;
            if (key == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = key.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            hf.a = bytes;
            hf.b = entry.getValue();
            arrayList.add(hf);
        }
        Object[] array = arrayList.toArray(new Hf[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        gf.a = (Hf[]) array;
        return gf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<String, byte[]> toModel(Gf gf) {
        Hf[] hfArr = gf.a;
        Intrinsics.checkNotNullExpressionValue(hfArr, "input.extras");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(hfArr.length), 16));
        for (Hf hf : hfArr) {
            byte[] bArr = hf.a;
            Intrinsics.checkNotNullExpressionValue(bArr, "it.key");
            Pair pair = TuplesKt.to(new String(bArr, Charsets.UTF_8), hf.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
