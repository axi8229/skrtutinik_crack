package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.Cf;
import com.yandex.metrica.impl.ob.Ud;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class Wd implements ProtobufConverter {
    private final C0925fe a;
    private final Sd b;

    public Wd() {
        this(new C0925fe(), new Sd());
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        Ud ud = (Ud) obj;
        Cf cf = new Cf();
        cf.a = this.a.fromModel(ud.a);
        cf.b = new Cf.b[ud.b.size()];
        Iterator<Ud.a> it = ud.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            cf.b[i] = this.b.fromModel(it.next());
            i++;
        }
        return cf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        Cf cf = (Cf) obj;
        ArrayList arrayList = new ArrayList(cf.b.length);
        for (Cf.b bVar : cf.b) {
            arrayList.add(this.b.toModel(bVar));
        }
        Cf.a aVar = cf.a;
        return new Ud(aVar == null ? this.a.toModel(new Cf.a()) : this.a.toModel(aVar), arrayList);
    }

    Wd(C0925fe c0925fe, Sd sd) {
        this.a = c0925fe;
        this.b = sd;
    }
}
