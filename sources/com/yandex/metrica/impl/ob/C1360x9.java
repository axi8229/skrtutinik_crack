package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C1306v3;
import com.yandex.metrica.impl.ob.C1390yf;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* renamed from: com.yandex.metrica.impl.ob.x9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1360x9 implements ProtobufConverter {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066 A[PHI: r1
  0x0066: PHI (r1v2 int) = (r1v1 int), (r1v3 int) binds: [B:15:0x0060, B:17:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.yandex.metrica.impl.ob.C1390yf.a a(com.yandex.metrica.impl.ob.C1306v3.a r10) {
        /*
            r9 = this;
            com.yandex.metrica.impl.ob.yf$a r0 = new com.yandex.metrica.impl.ob.yf$a
            r0.<init>()
            java.util.Map r1 = r10.b()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L52
            com.yandex.metrica.impl.ob.yf$b r4 = new com.yandex.metrica.impl.ob.yf$b
            r4.<init>()
            int r5 = r1.size()
            com.yandex.metrica.impl.ob.yf$b$a[] r6 = new com.yandex.metrica.impl.ob.C1390yf.b.a[r5]
            r7 = r2
        L19:
            if (r7 >= r5) goto L25
            com.yandex.metrica.impl.ob.yf$b$a r8 = new com.yandex.metrica.impl.ob.yf$b$a
            r8.<init>()
            r6[r7] = r8
            int r7 = r7 + 1
            goto L19
        L25:
            r4.a = r6
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r5 = r2
        L30:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L53
            java.lang.Object r6 = r1.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            com.yandex.metrica.impl.ob.yf$b$a[] r8 = r4.a
            r8 = r8[r5]
            r8.a = r7
            r8.b = r6
            int r5 = r5 + r3
            goto L30
        L52:
            r4 = 0
        L53:
            r0.a = r4
            com.yandex.metrica.impl.ob.u0 r10 = r10.a()
            int r10 = r10.ordinal()
            if (r10 == r3) goto L68
            r1 = 2
            if (r10 == r1) goto L66
            r1 = 3
            if (r10 == r1) goto L66
            goto L69
        L66:
            r2 = r1
            goto L69
        L68:
            r2 = r3
        L69:
            r0.b = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C1360x9.a(com.yandex.metrica.impl.ob.v3$a):com.yandex.metrica.impl.ob.yf$a");
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        C1306v3 c1306v3 = (C1306v3) obj;
        C1390yf c1390yf = new C1390yf();
        c1390yf.a = a(c1306v3.c());
        int size = c1306v3.a().size();
        C1390yf.a[] aVarArr = new C1390yf.a[size];
        for (int i = 0; i < size; i++) {
            aVarArr[i] = a(c1306v3.a().get(i));
        }
        c1390yf.b = aVarArr;
        return c1390yf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        C1390yf c1390yf = (C1390yf) obj;
        C1390yf.a aVar = c1390yf.a;
        if (aVar == null) {
            aVar = new C1390yf.a();
        }
        C1306v3.a aVarA = a(aVar);
        C1390yf.a[] aVarArr = c1390yf.b;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "nano.candidates");
        ArrayList arrayList = new ArrayList(aVarArr.length);
        for (C1390yf.a it : aVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(a(it));
        }
        return new C1306v3(aVarA, arrayList);
    }

    private final C1306v3.a a(C1390yf.a aVar) {
        EnumC1279u0 enumC1279u0;
        C1390yf.b bVar = aVar.a;
        Map<String, String> mapA = bVar != null ? a(bVar) : null;
        int i = aVar.b;
        if (i == 0) {
            enumC1279u0 = EnumC1279u0.UNDEFINED;
        } else if (i == 1) {
            enumC1279u0 = EnumC1279u0.APP;
        } else if (i == 2) {
            enumC1279u0 = EnumC1279u0.SATELLITE;
        } else if (i != 3) {
            enumC1279u0 = EnumC1279u0.UNDEFINED;
        } else {
            enumC1279u0 = EnumC1279u0.RETAIL;
        }
        return new C1306v3.a(mapA, enumC1279u0);
    }

    private final Map<String, String> a(C1390yf.b bVar) {
        C1390yf.b.a[] aVarArr = bVar.a;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "proto.pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(aVarArr.length), 16));
        for (C1390yf.b.a aVar : aVarArr) {
            Pair pair = TuplesKt.to(aVar.a, aVar.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
