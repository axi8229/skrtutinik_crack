package com.yandex.metrica.impl.ob;

import android.app.Activity;
import com.yandex.metrica.uiaccessor.a;

/* loaded from: classes3.dex */
class Ek {

    class a implements a.InterfaceC0296a {
        final /* synthetic */ InterfaceC1107mm a;

        a(Ek ek, InterfaceC1107mm interfaceC1107mm) {
            this.a = interfaceC1107mm;
        }

        @Override // com.yandex.metrica.uiaccessor.a.InterfaceC0296a
        public void fragmentAttached(Activity activity) {
            this.a.b(activity);
        }
    }

    class b implements com.yandex.metrica.uiaccessor.b {
        b(Ek ek) {
        }

        @Override // com.yandex.metrica.uiaccessor.b
        public void subscribe(Activity activity) throws Throwable {
        }

        @Override // com.yandex.metrica.uiaccessor.b
        public void unsubscribe(Activity activity) throws Throwable {
        }
    }

    Ek() {
    }

    com.yandex.metrica.uiaccessor.b a(InterfaceC1107mm<Activity> interfaceC1107mm) {
        com.yandex.metrica.uiaccessor.a aVar;
        try {
            aVar = new com.yandex.metrica.uiaccessor.a(new a(this, interfaceC1107mm));
        } catch (Throwable unused) {
            aVar = null;
        }
        return aVar == null ? new b(this) : aVar;
    }
}
