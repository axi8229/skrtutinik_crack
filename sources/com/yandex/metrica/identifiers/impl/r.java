package com.yandex.metrica.identifiers.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class r implements i {
    private final e a;

    public r() {
        this(new e(s.a, q.a, "huawei"));
    }

    public r(e connectionController) {
        Intrinsics.checkNotNullParameter(connectionController, "connectionController");
        this.a = connectionController;
    }

    @Override // com.yandex.metrica.identifiers.impl.i
    public g a(Context context) {
        g gVar;
        g gVar2;
        e eVar;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            try {
                v vVar = (v) this.a.a(context);
                gVar2 = new g(l.b, new f("huawei", vVar.a(), Boolean.valueOf(vVar.c())), null, 4);
                eVar = this.a;
            } catch (j e) {
                String errorMessage = e.getMessage();
                if (errorMessage == null) {
                    errorMessage = "unknown exception during binding huawei services";
                }
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                gVar = new g(l.c, null, errorMessage);
                gVar2 = gVar;
                eVar = this.a;
                eVar.b(context);
                return gVar2;
            } catch (Throwable th) {
                String errorMessage2 = "exception while fetching hoaid: " + th.getMessage();
                Intrinsics.checkNotNullParameter(errorMessage2, "errorMessage");
                gVar = new g(l.c, null, errorMessage2);
                gVar2 = gVar;
                eVar = this.a;
                eVar.b(context);
                return gVar2;
            }
            eVar.b(context);
            return gVar2;
        } finally {
            try {
                this.a.b(context);
            } catch (Throwable unused) {
            }
        }
    }
}
