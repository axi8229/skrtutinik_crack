package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.U1;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/* renamed from: com.yandex.metrica.impl.ob.n6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1116n6 {
    private final B0 a;
    private final C1091m6 b;
    private final Context c;
    private final C1301um d;

    public C1116n6(Context context) {
        this(context, new B0(), new C1091m6(), C1301um.a(context));
    }

    public void a(U1.f fVar) {
        PrintWriter printWriter;
        File fileA = this.a.a(this.c, "appmetrica_crashes");
        if (!this.b.a(fileA)) {
            return;
        }
        A3 a3A = fVar.a().a();
        String str = a3A.g() + "-" + a3A.h();
        C1253sm c1253smA = this.d.a(str);
        try {
            c1253smA.a();
            this.a.getClass();
            printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(fileA, str))));
            try {
                printWriter.write(new Z6(fVar.b(), fVar.a(), fVar.c()).k());
                A2.a((Closeable) printWriter);
                c1253smA.c();
            } catch (Throwable unused) {
                A2.a((Closeable) printWriter);
                c1253smA.c();
            }
        } catch (Throwable unused2) {
            printWriter = null;
        }
    }

    C1116n6(Context context, B0 b0, C1091m6 c1091m6, C1301um c1301um) {
        this.c = context;
        this.a = b0;
        this.b = c1091m6;
        this.d = c1301um;
    }
}
