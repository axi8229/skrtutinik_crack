package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C1297ui;
import com.yandex.metrica.impl.ob.If;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.aa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0796aa implements ProtobufConverter {
    private static final EnumMap<C1297ui.b, String> a;
    private static final Map<String, C1297ui.b> b;

    static {
        EnumMap<C1297ui.b, String> enumMap = new EnumMap<>(C1297ui.b.class);
        a = enumMap;
        HashMap map = new HashMap();
        b = map;
        C1297ui.b bVar = C1297ui.b.WIFI;
        enumMap.put((EnumMap<C1297ui.b, String>) bVar, (C1297ui.b) "wifi");
        C1297ui.b bVar2 = C1297ui.b.CELL;
        enumMap.put((EnumMap<C1297ui.b, String>) bVar2, (C1297ui.b) "cell");
        map.put("wifi", bVar);
        map.put("cell", bVar2);
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.t fromModel(C1297ui c1297ui) {
        If.t tVar = new If.t();
        if (c1297ui.a != null) {
            If.u uVar = new If.u();
            tVar.a = uVar;
            C1297ui.a aVar = c1297ui.a;
            uVar.a = aVar.a;
            uVar.b = aVar.b;
        }
        if (c1297ui.b != null) {
            If.u uVar2 = new If.u();
            tVar.b = uVar2;
            C1297ui.a aVar2 = c1297ui.b;
            uVar2.a = aVar2.a;
            uVar2.b = aVar2.b;
        }
        return tVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1297ui toModel(If.t tVar) {
        If.u uVar = tVar.a;
        C1297ui.a aVar = uVar != null ? new C1297ui.a(uVar.a, uVar.b) : null;
        If.u uVar2 = tVar.b;
        return new C1297ui(aVar, uVar2 != null ? new C1297ui.a(uVar2.a, uVar2.b) : null);
    }
}
