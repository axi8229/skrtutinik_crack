package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.C1414zf;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes3.dex */
public final class D9 implements Converter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] fromModel(Map<String, byte[]> map) {
        C1414zf c1414zf = new C1414zf();
        int size = map.size();
        C1414zf.a[] aVarArr = new C1414zf.a[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            aVarArr[i2] = new C1414zf.a();
        }
        c1414zf.a = aVarArr;
        for (Object obj : map.entrySet()) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            c1414zf.a[i].a = (String) entry.getKey();
            c1414zf.a[i].b = (byte[]) entry.getValue();
            i = i3;
        }
        byte[] byteArray = MessageNano.toByteArray(c1414zf);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(proto)");
        return byteArray;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<String, byte[]> toModel(byte[] bArr) {
        C1414zf.a[] aVarArr = ((C1414zf) MessageNano.mergeFrom(new C1414zf(), bArr)).a;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "EventExtrasProto.EventEx…s.parseFrom(input).extras");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(aVarArr.length), 16));
        for (C1414zf.a aVar : aVarArr) {
            Pair pair = TuplesKt.to(aVar.a, aVar.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
