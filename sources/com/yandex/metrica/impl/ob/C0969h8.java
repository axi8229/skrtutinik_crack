package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;

/* renamed from: com.yandex.metrica.impl.ob.h8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0969h8 implements InterfaceC0944g8 {
    private final Context a;
    private final String b;
    private final X7 c;
    private final C1277tm d;
    private O7 e;

    public C0969h8(Context context, String str, C1277tm c1277tm, X7 x7) {
        this.a = context;
        this.b = str;
        this.d = c1277tm;
        this.c = x7;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0944g8
    public synchronized SQLiteDatabase a() {
        O7 o7;
        try {
            this.d.a();
            o7 = new O7(this.a, this.b, this.c);
            this.e = o7;
        } catch (Throwable unused) {
            return null;
        }
        return o7.getWritableDatabase();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0944g8
    public synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        A2.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
