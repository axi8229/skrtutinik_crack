package com.yandex.metrica.impl.ob;

import java.net.Socket;
import java.util.Map;

/* loaded from: classes3.dex */
class Ch {
    private final Socket a;
    private final Gh b;
    private final Map<String, Bh> c;
    private final Hh d;

    Ch(Socket socket, Gh gh, Map<String, Bh> map, Hh hh) {
        this.a = socket;
        this.b = gh;
        this.c = map;
        this.d = hh;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f A[Catch: all -> 0x0038, TryCatch #3 {all -> 0x0038, blocks: (B:4:0x0018, B:6:0x0027, B:8:0x002f, B:13:0x003a, B:15:0x004a, B:18:0x005a, B:20:0x006c, B:22:0x0086, B:23:0x008a, B:24:0x0094, B:26:0x009a, B:16:0x004f), top: B:49:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[Catch: all -> 0x0038, TryCatch #3 {all -> 0x0038, blocks: (B:4:0x0018, B:6:0x0027, B:8:0x002f, B:13:0x003a, B:15:0x004a, B:18:0x005a, B:20:0x006c, B:22:0x0086, B:23:0x008a, B:24:0x0094, B:26:0x009a, B:16:0x004f), top: B:49:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            r6 = this;
            r0 = 0
            java.net.Socket r1 = r6.a     // Catch: java.lang.Throwable -> La5
            r2 = 1000(0x3e8, float:1.401E-42)
            r1.setSoTimeout(r2)     // Catch: java.lang.Throwable -> La5
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La5
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> La5
            java.net.Socket r3 = r6.a     // Catch: java.lang.Throwable -> La5
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> La5
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La5
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La5
            com.yandex.metrica.impl.ob.Hh r2 = r6.d     // Catch: java.lang.Throwable -> L38
            r2.a()     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L38
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L38
            if (r3 != 0) goto L4f
            java.lang.String r3 = "GET /"
            boolean r3 = r2.startsWith(r3)     // Catch: java.lang.Throwable -> L38
            if (r3 != 0) goto L3a
            java.lang.String r3 = "POST /"
            boolean r3 = r2.startsWith(r3)     // Catch: java.lang.Throwable -> L38
            if (r3 == 0) goto L4f
            goto L3a
        L38:
            r0 = move-exception
            goto La1
        L3a:
            r3 = 47
            int r3 = r2.indexOf(r3)     // Catch: java.lang.Throwable -> L38
            int r3 = r3 + 1
            r4 = 32
            int r4 = r2.indexOf(r4, r3)     // Catch: java.lang.Throwable -> L38
            if (r4 <= 0) goto L4f
            java.lang.String r0 = r2.substring(r3, r4)     // Catch: java.lang.Throwable -> L38
            goto L58
        L4f:
            com.yandex.metrica.impl.ob.Gh r3 = r6.b     // Catch: java.lang.Throwable -> L38
            com.yandex.metrica.impl.ob.Jh r3 = (com.yandex.metrica.impl.ob.Jh) r3     // Catch: java.lang.Throwable -> L38
            java.lang.String r4 = "invalid_route"
            r3.a(r4, r2)     // Catch: java.lang.Throwable -> L38
        L58:
            if (r0 == 0) goto L9d
            android.net.Uri r2 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = r2.getPath()     // Catch: java.lang.Throwable -> L38
            java.util.Map<java.lang.String, com.yandex.metrica.impl.ob.Bh> r4 = r6.c     // Catch: java.lang.Throwable -> L38
            java.lang.Object r3 = r4.get(r3)     // Catch: java.lang.Throwable -> L38
            com.yandex.metrica.impl.ob.Bh r3 = (com.yandex.metrica.impl.ob.Bh) r3     // Catch: java.lang.Throwable -> L38
            if (r3 == 0) goto L94
            java.net.Socket r0 = r6.a     // Catch: java.lang.Throwable -> L38
            com.yandex.metrica.impl.ob.Hh r4 = r6.d     // Catch: java.lang.Throwable -> L38
            com.yandex.metrica.impl.ob.Ah r0 = r3.a(r0, r2, r4)     // Catch: java.lang.Throwable -> L38
            android.net.Uri r2 = r0.d     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = "t"
            java.lang.String r2 = r2.getQueryParameter(r3)     // Catch: java.lang.Throwable -> L38
            com.yandex.metrica.impl.ob.di r3 = r0.c     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = r3.b     // Catch: java.lang.Throwable -> L38
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Throwable -> L38
            if (r2 == 0) goto L8a
            r0.a()     // Catch: java.lang.Throwable -> L38
            goto L9d
        L8a:
            com.yandex.metrica.impl.ob.Gh r0 = r0.b     // Catch: java.lang.Throwable -> L38
            com.yandex.metrica.impl.ob.Jh r0 = (com.yandex.metrica.impl.ob.Jh) r0     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = "request_with_wrong_token"
            r0.a(r2)     // Catch: java.lang.Throwable -> L38
            goto L9d
        L94:
            com.yandex.metrica.impl.ob.Gh r2 = r6.b     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = "request_to_unknown_path"
            com.yandex.metrica.impl.ob.Jh r2 = (com.yandex.metrica.impl.ob.Jh) r2
            r2.a(r3, r0)     // Catch: java.lang.Throwable -> L38
        L9d:
            r1.close()     // Catch: java.lang.Throwable -> Lb4
            goto Lb4
        La1:
            r5 = r1
            r1 = r0
            r0 = r5
            goto La6
        La5:
            r1 = move-exception
        La6:
            com.yandex.metrica.impl.ob.Gh r2 = r6.b     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = "LocalHttpServer exception"
            com.yandex.metrica.impl.ob.Jh r2 = (com.yandex.metrica.impl.ob.Jh) r2
            r2.a(r3, r1)     // Catch: java.lang.Throwable -> Lb5
            if (r0 == 0) goto Lb4
            r0.close()     // Catch: java.lang.Throwable -> Lb4
        Lb4:
            return
        Lb5:
            r1 = move-exception
            if (r0 == 0) goto Lbb
            r0.close()     // Catch: java.lang.Throwable -> Lbb
        Lbb:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.Ch.a():void");
    }
}
