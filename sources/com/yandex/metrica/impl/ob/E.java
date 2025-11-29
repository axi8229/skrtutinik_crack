package com.yandex.metrica.impl.ob;

import android.content.Intent;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class E {
    private final ICommonExecutor a;
    private volatile b b;
    private final List<c> c = new ArrayList();
    private final InterfaceC1107mm<Intent> d;

    class a implements InterfaceC1107mm<Intent> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(Intent intent) {
            Intent intent2 = intent;
            b bVar = E.this.b;
            b.a aVar = bVar == null ? null : bVar.b;
            b bVarA = E.this.a(intent2);
            E.this.b = bVarA;
            if (aVar != bVarA.b) {
                E.this.a.execute(new D(this, bVarA));
            }
        }
    }

    public static class b {
        public final Integer a;
        public final a b;

        public enum a {
            UNKNOWN(-1),
            NONE(0),
            USB(1),
            WIRELESS(2),
            AC(3);

            private final int a;

            a(int i) {
                this.a = i;
            }

            public int a() {
                return this.a;
            }

            public static a a(Integer num) {
                if (num != null) {
                    a[] aVarArrValues = values();
                    for (int i = 0; i < 5; i++) {
                        a aVar = aVarArrValues[i];
                        if (aVar.a == num.intValue()) {
                            return aVar;
                        }
                    }
                }
                return UNKNOWN;
            }
        }

        public b(Integer num, a aVar) {
            this.a = num;
            this.b = aVar;
        }
    }

    public interface c {
        void a(b.a aVar);
    }

    public E(ICommonExecutor iCommonExecutor, C c2) {
        a aVar = new a();
        this.d = aVar;
        this.a = iCommonExecutor;
        this.b = a(c2.c(aVar));
    }

    public b.a b() {
        b bVar = this.b;
        return bVar == null ? b.a.UNKNOWN : bVar.b;
    }

    public Integer a() {
        b bVar = this.b;
        if (bVar == null) {
            return null;
        }
        return bVar.a;
    }

    public synchronized void a(c cVar) {
        this.c.add(cVar);
        ((C1196qc) cVar).a(b());
    }

    static void a(E e, b.a aVar) {
        synchronized (e) {
            Iterator<c> it = e.c.iterator();
            while (it.hasNext()) {
                it.next().a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b a(Intent intent) {
        b.a aVar = b.a.UNKNOWN;
        Integer numValueOf = null;
        if (intent != null) {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra > 0 && intExtra2 > 0) {
                numValueOf = Integer.valueOf((intExtra * 100) / intExtra2);
            }
            int intExtra3 = intent.getIntExtra("plugged", -1);
            aVar = b.a.NONE;
            if (intExtra3 == 1) {
                aVar = b.a.AC;
            } else if (intExtra3 == 2) {
                aVar = b.a.USB;
            } else if (intExtra3 == 4) {
                aVar = b.a.WIRELESS;
            }
        }
        return new b(numValueOf, aVar);
    }
}
