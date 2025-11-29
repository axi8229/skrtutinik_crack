package com.yandex.metrica.identifiers.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class o implements i {
    private final e a;

    public o() {
        this(new e(p.a, n.a, "yandex"));
    }

    public o(e connectionController) {
        Intrinsics.checkNotNullParameter(connectionController, "connectionController");
        this.a = connectionController;
    }

    private final g b(Context context) {
        c cVar = (c) this.a.a(context);
        String strB = cVar.b();
        Intrinsics.checkNotNullExpressionValue(strB, "service.advId");
        return new g(l.b, new f("yandex", strB, Boolean.valueOf(cVar.d())), null, 4);
    }

    @Override // com.yandex.metrica.identifiers.impl.i
    public g a(Context context) {
        g gVar;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            try {
                try {
                    try {
                        g gVarB = b(context);
                        try {
                            return gVarB;
                        } catch (Throwable unused) {
                            return gVarB;
                        }
                    } catch (j e) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = "unknown exception while binding yandex adv_id service";
                        }
                        gVar = new g(l.c, null, message, 2);
                        try {
                            this.a.b(context);
                        } catch (Throwable unused2) {
                        }
                        return gVar;
                    }
                } catch (m e2) {
                    String message2 = e2.getMessage();
                    if (message2 == null) {
                        message2 = "No yandex adv_id service";
                    }
                    gVar = new g(l.c, null, message2, 2);
                    this.a.b(context);
                    return gVar;
                }
            } catch (Throwable th) {
                gVar = new g(l.d, null, "exception while fetching yandex adv_id: " + th.getMessage(), 2);
                this.a.b(context);
                return gVar;
            }
        } finally {
            try {
                this.a.b(context);
            } catch (Throwable unused3) {
            }
        }
    }
}
