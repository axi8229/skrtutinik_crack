package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.yandex.metrica.impl.ob.i8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0994i8 implements InterfaceC0944g8 {
    private final O7 a;

    public C0994i8(O7 o7) {
        this.a = o7;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0944g8
    public SQLiteDatabase a() {
        try {
            return this.a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0944g8
    public void a(SQLiteDatabase sQLiteDatabase) {
    }
}
