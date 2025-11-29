package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.Tl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Mi {
    private final C1023jd a;

    static final class a extends Lambda implements Function1<Map.Entry<? extends String, ? extends C0974hd>, Object> {
        final /* synthetic */ Tl.a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Tl.a aVar) {
            super(1);
            this.a = aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Map.Entry<? extends String, ? extends C0974hd> entry) {
            return entry.getValue().parse((JSONObject) this.a);
        }
    }

    public Mi() {
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        C1023jd c1023jdJ = f0G.j();
        Intrinsics.checkNotNullExpressionValue(c1023jdJ, "GlobalServiceLocator.get…tance().modulesController");
        this.a = c1023jdJ;
    }

    public final void a(Ui ui, Tl.a aVar) {
        Map<String, C0974hd> mapC = this.a.c();
        a aVar2 = new a(aVar);
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, C0974hd> entry : mapC.entrySet()) {
            Object objInvoke = aVar2.invoke(entry);
            if (objInvoke != null) {
                linkedHashMap.put(entry.getKey(), objInvoke);
            }
        }
        ui.b(linkedHashMap);
    }
}
