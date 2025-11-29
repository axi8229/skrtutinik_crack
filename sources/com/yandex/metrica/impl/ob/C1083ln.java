package com.yandex.metrica.impl.ob;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.yandex.metrica.impl.ob.ln, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1083ln extends AbstractC0984hn {
    private final C1058kn b;
    private final C1058kn c;
    private Comparator<Map.Entry<String, String>> d;

    /* renamed from: com.yandex.metrica.impl.ob.ln$a */
    class a implements Comparator<Map.Entry<String, String>> {
        a(C1083ln c1083ln) {
        }

        @Override // java.util.Comparator
        public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            String value = entry.getValue();
            String value2 = entry2.getValue();
            int length = C0810b.b(value).length;
            int length2 = C0810b.b(value2).length;
            if (length < length2) {
                return -1;
            }
            return length == length2 ? 0 : 1;
        }
    }

    public C1083ln(int i, int i2, int i3) {
        this(i, new C1058kn(i2), new C1058kn(i3));
    }

    public C1083ln(int i, C1058kn c1058kn, C1058kn c1058kn2) {
        super(i);
        this.d = new a(this);
        this.b = c1058kn;
        this.c = c1058kn2;
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC0984hn
    public C0959gn<Map<String, String>, Xm> a(Map<String, String> map) {
        HashMap map2;
        int iA;
        int i = 0;
        if (map != null) {
            map2 = new HashMap();
            Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
            Map.Entry[] entryArr = (Map.Entry[]) setEntrySet.toArray(new Map.Entry[setEntrySet.size()]);
            Arrays.sort(entryArr, this.d);
            int length = entryArr.length;
            iA = 0;
            int i2 = 0;
            boolean z = false;
            int length2 = 0;
            while (i < length) {
                Map.Entry entry = entryArr[i];
                C0959gn<String, Vm> c0959gnA = this.b.a((String) entry.getKey());
                C0959gn<String, Vm> c0959gnA2 = this.c.a((String) entry.getValue());
                int length3 = C0810b.b((String) entry.getKey()).length + C0810b.b((String) entry.getValue()).length;
                int length4 = C0810b.b(c0959gnA.a).length + C0810b.b(c0959gnA2.a).length;
                if (z || length4 + length2 > a()) {
                    i2++;
                    iA += length3;
                    z = true;
                } else {
                    iA = iA + c0959gnA.b.a() + c0959gnA2.b.a();
                    length2 += C0810b.b(c0959gnA.a).length + C0810b.b(c0959gnA2.a).length;
                    map2.put(c0959gnA.a, c0959gnA2.a);
                }
                i++;
            }
            i = i2;
        } else {
            map2 = null;
            iA = 0;
        }
        return new C0959gn<>(map2, new Xm(i, iA));
    }
}
