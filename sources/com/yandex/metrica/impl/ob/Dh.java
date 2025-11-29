package com.yandex.metrica.impl.ob;

import android.net.Uri;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public class Dh extends Ah {
    Dh(Socket socket, Uri uri, Gh gh, C0879di c0879di, Hh hh) {
        super(socket, uri, gh, c0879di, hh);
    }

    @Override // com.yandex.metrica.impl.ob.Ah
    void a() throws Throwable {
        Set<String> queryParameterNames = this.d.getQueryParameterNames();
        HashMap map = new HashMap();
        for (String str : queryParameterNames) {
            map.put(str, this.d.getQueryParameter(str));
        }
        map.remove("t");
        a("HTTP/1.1 200 OK", new HashMap(), new byte[0]);
        ((Jh) this.b).a(map, this.a.getLocalPort(), this.e);
    }
}
