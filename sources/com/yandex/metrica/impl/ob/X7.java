package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

/* loaded from: classes3.dex */
public class X7 {
    private final AbstractC1043k8 a;
    private final AbstractC1043k8 b;
    private final SparseArray<AbstractC1043k8> c;
    private final Y7 d;

    public static class b {
        public X7 a(String str, AbstractC1043k8 abstractC1043k8, AbstractC1043k8 abstractC1043k82, SparseArray<AbstractC1043k8> sparseArray, Y7 y7) {
            return new X7(str, abstractC1043k8, abstractC1043k82, sparseArray, y7);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a.a(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        try {
            Y7 y7 = this.d;
            if (y7 == null || ((Z7) y7).a(sQLiteDatabase)) {
                return;
            }
            try {
                this.b.a(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            this.a.a(sQLiteDatabase);
        } catch (Throwable unused2) {
        }
    }

    private X7(String str, AbstractC1043k8 abstractC1043k8, AbstractC1043k8 abstractC1043k82, SparseArray<AbstractC1043k8> sparseArray, Y7 y7) {
        this.a = abstractC1043k8;
        this.b = abstractC1043k82;
        this.c = sparseArray;
        this.d = y7;
    }

    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            try {
                this.b.a(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            try {
                this.a.a(sQLiteDatabase);
            } catch (Throwable unused2) {
            }
        }
    }

    public void b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        boolean z;
        if (i2 > i) {
            for (int i3 = i + 1; i3 <= i2; i3++) {
                try {
                    AbstractC1043k8 abstractC1043k8 = this.c.get(i3);
                    if (abstractC1043k8 != null) {
                        abstractC1043k8.a(sQLiteDatabase);
                    }
                } catch (Throwable unused) {
                }
            }
            z = false;
        } else {
            z = true;
        }
        if (z || (!((Z7) this.d).a(sQLiteDatabase))) {
            try {
                this.b.a(sQLiteDatabase);
            } catch (Throwable unused2) {
            }
            try {
                this.a.a(sQLiteDatabase);
            } catch (Throwable unused3) {
            }
        }
    }
}
