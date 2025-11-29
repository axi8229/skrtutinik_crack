package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.util.Base64;
import java.net.Socket;
import java.util.HashMap;

/* renamed from: com.yandex.metrica.impl.ob.qh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1201qh extends Ah {
    private final String f;

    /* renamed from: com.yandex.metrica.impl.ob.qh$a */
    class a extends HashMap<String, String> {
        final /* synthetic */ byte[] a;

        a(C1201qh c1201qh, byte[] bArr) {
            this.a = bArr;
            put("Content-Type", "text/plain; charset=utf-8");
            put("Access-Control-Allow-Origin", "*");
            put("Access-Control-Allow-Methods", "GET");
            put("Content-Length", String.valueOf(bArr.length));
        }
    }

    C1201qh(Socket socket, Uri uri, Gh gh, C0879di c0879di, String str, Hh hh) {
        super(socket, uri, gh, c0879di, hh);
        this.f = str;
    }

    @Override // com.yandex.metrica.impl.ob.Ah
    public void a() {
        try {
            byte[] bArrEncode = Base64.encode(new C1397ym().a(this.f.getBytes()), 0);
            a("HTTP/1.1 200 OK", new a(this, bArrEncode), bArrEncode);
        } catch (Throwable unused) {
        }
    }
}
