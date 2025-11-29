package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.util.SparseArray;
import com.yandex.metrica.YandexMetrica;

/* loaded from: classes3.dex */
public abstract class D1 {

    interface a {
        void a(Context context);
    }

    protected abstract int a(Nd nd);

    abstract SparseArray<a> a();

    public synchronized void a(Context context) {
        try {
            Nd nd = new Nd(context);
            int iA = a(nd);
            int libraryApiLevel = YandexMetrica.getLibraryApiLevel();
            if (iA != libraryApiLevel) {
                if (iA > 0 && iA < libraryApiLevel) {
                    SparseArray<a> sparseArrayA = a();
                    while (true) {
                        iA++;
                        if (iA > libraryApiLevel) {
                            break;
                        }
                        a aVar = sparseArrayA.get(iA);
                        if (aVar != null) {
                            aVar.a(context);
                        }
                    }
                }
                a(nd, libraryApiLevel);
                nd.b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected abstract void a(Nd nd, int i);
}
