package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d {
    private static final String o = "d";
    private Map<String, List<String>> a;
    private byte[] b;
    private int c;
    private long d;
    private long e;
    private long f;
    private String g;
    private int h;
    private int i;
    private String j;
    private long k;
    private String l;
    private Exception m;
    private String n;

    public d(int i, Map<String, List<String>> map, byte[] bArr, long j) throws NumberFormatException {
        this.h = 2;
        this.i = ConnectionResult.RESOLUTION_REQUIRED;
        this.j = "";
        this.k = 0L;
        this.l = "";
        this.c = i;
        this.a = map;
        this.b = ByteBuffer.wrap(bArr).array();
        this.d = j;
        s();
    }

    public d(Exception exc, long j) {
        this.c = 0;
        this.h = 2;
        this.i = ConnectionResult.RESOLUTION_REQUIRED;
        this.j = "";
        this.k = 0L;
        this.l = "";
        this.m = exc;
        this.d = j;
    }

    private void a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey("ETag")) {
            String str3 = map.get("ETag");
            if (!TextUtils.isEmpty(str3)) {
                Logger.i(o, "success get Etag from server");
                a(str3);
                return;
            } else {
                str = o;
                str2 = "The Response Heads Etag is Empty";
            }
        } else {
            str = o;
            str2 = "Response Heads has not Etag";
        }
        Logger.i(str, str2);
    }

    private void b(int i) {
        this.i = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.util.Map<java.lang.String, java.lang.String> r9) throws java.lang.NumberFormatException {
        /*
            r8 = this;
            java.lang.String r0 = "Cache-Control"
            boolean r1 = r9.containsKey(r0)
            r2 = 1000(0x3e8, double:4.94E-321)
            r4 = 0
            if (r1 == 0) goto L4b
            java.lang.Object r9 = r9.get(r0)
            java.lang.String r9 = (java.lang.String) r9
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto Lad
            java.lang.String r0 = "max-age="
            boolean r1 = r9.contains(r0)
            if (r1 == 0) goto Lad
            int r0 = r9.indexOf(r0)     // Catch: java.lang.NumberFormatException -> L41
            int r0 = r0 + 8
            java.lang.String r9 = r9.substring(r0)     // Catch: java.lang.NumberFormatException -> L41
            long r0 = java.lang.Long.parseLong(r9)     // Catch: java.lang.NumberFormatException -> L41
            java.lang.String r9 = com.huawei.hms.framework.network.grs.g.d.o     // Catch: java.lang.NumberFormatException -> L3f
            java.lang.String r6 = "Cache-Control value{%s}"
            java.lang.Long r7 = java.lang.Long.valueOf(r0)     // Catch: java.lang.NumberFormatException -> L3f
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch: java.lang.NumberFormatException -> L3f
            com.huawei.hms.framework.common.Logger.v(r9, r6, r7)     // Catch: java.lang.NumberFormatException -> L3f
            goto Lae
        L3f:
            r9 = move-exception
            goto L43
        L41:
            r9 = move-exception
            r0 = r4
        L43:
            java.lang.String r6 = com.huawei.hms.framework.network.grs.g.d.o
            java.lang.String r7 = "getExpireTime addHeadersToResult NumberFormatException"
            com.huawei.hms.framework.common.Logger.w(r6, r7, r9)
            goto Lae
        L4b:
            java.lang.String r0 = "Expires"
            boolean r1 = r9.containsKey(r0)
            if (r1 == 0) goto La6
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = com.huawei.hms.framework.network.grs.g.d.o
            java.lang.Object[] r6 = new java.lang.Object[]{r0}
            java.lang.String r7 = "expires is{%s}"
            com.huawei.hms.framework.common.Logger.v(r1, r7, r6)
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r7 = "EEE, d MMM yyyy HH:mm:ss 'GMT'"
            r1.<init>(r7, r6)
            java.lang.String r6 = "Date"
            boolean r7 = r9.containsKey(r6)
            if (r7 == 0) goto L7c
            java.lang.Object r9 = r9.get(r6)
            java.lang.String r9 = (java.lang.String) r9
            goto L7d
        L7c:
            r9 = 0
        L7d:
            java.util.Date r0 = r1.parse(r0)     // Catch: java.text.ParseException -> L8d
            boolean r6 = android.text.TextUtils.isEmpty(r9)     // Catch: java.text.ParseException -> L8d
            if (r6 == 0) goto L8f
            java.util.Date r9 = new java.util.Date     // Catch: java.text.ParseException -> L8d
            r9.<init>()     // Catch: java.text.ParseException -> L8d
            goto L93
        L8d:
            r9 = move-exception
            goto L9e
        L8f:
            java.util.Date r9 = r1.parse(r9)     // Catch: java.text.ParseException -> L8d
        L93:
            long r0 = r0.getTime()     // Catch: java.text.ParseException -> L8d
            long r6 = r9.getTime()     // Catch: java.text.ParseException -> L8d
            long r0 = r0 - r6
            long r0 = r0 / r2
            goto Lae
        L9e:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.d.o
            java.lang.String r1 = "getExpireTime ParseException."
            com.huawei.hms.framework.common.Logger.w(r0, r1, r9)
            goto Lad
        La6:
            java.lang.String r9 = com.huawei.hms.framework.network.grs.g.d.o
            java.lang.String r0 = "response headers neither contains Cache-Control nor Expires."
            com.huawei.hms.framework.common.Logger.i(r9, r0)
        Lad:
            r0 = r4
        Lae:
            int r9 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r9 <= 0) goto Lb9
            r4 = 2592000(0x278d00, double:1.280618E-317)
            int r9 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r9 <= 0) goto Lbc
        Lb9:
            r0 = 86400(0x15180, double:4.26873E-319)
        Lbc:
            long r0 = r0 * r2
            java.lang.String r9 = com.huawei.hms.framework.network.grs.g.d.o
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r3 = "convert expireTime{%s}"
            com.huawei.hms.framework.common.Logger.i(r9, r3, r2)
            long r2 = java.lang.System.currentTimeMillis()
            long r0 = r0 + r2
            java.lang.String r9 = java.lang.String.valueOf(r0)
            r8.c(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.d.b(java.util.Map):void");
    }

    private void c(int i) {
        this.h = i;
    }

    private void c(long j) {
        this.k = j;
    }

    private void c(String str) {
        this.j = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.util.Map<java.lang.String, java.lang.String> r5) throws java.lang.NumberFormatException {
        /*
            r4 = this;
            java.lang.String r0 = "Retry-After"
            boolean r1 = r5.containsKey(r0)
            if (r1 == 0) goto L21
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L21
            long r0 = java.lang.Long.parseLong(r5)     // Catch: java.lang.NumberFormatException -> L19
            goto L23
        L19:
            r5 = move-exception
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.d.o
            java.lang.String r1 = "getRetryAfter addHeadersToResult NumberFormatException"
            com.huawei.hms.framework.common.Logger.w(r0, r1, r5)
        L21:
            r0 = 0
        L23:
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            java.lang.String r5 = com.huawei.hms.framework.network.grs.g.d.o
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r3 = "convert retry-afterTime{%s}"
            com.huawei.hms.framework.common.Logger.v(r5, r3, r2)
            r4.c(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.d.c(java.util.Map):void");
    }

    private void d(String str) {
    }

    private void e(String str) {
    }

    private void f(String str) {
        this.g = str;
    }

    private void p() {
        int i;
        if (m()) {
            Logger.i(o, "GRSSDK get httpcode{304} not any changed.");
            c(1);
            return;
        }
        if (!o()) {
            Logger.i(o, "GRSSDK parse server body all failed.");
            c(2);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(StringUtils.byte2Str(this.b));
            if (jSONObject.has("isSuccess")) {
                if (jSONObject.getInt("isSuccess") == 1) {
                }
            } else if (jSONObject.has("resultCode")) {
                i = jSONObject.getInt("resultCode") == 0 ? 1 : 2;
            } else {
                Logger.e(o, "sth. wrong because server errorcode's key.");
                i = -1;
            }
            if (i != 1 && jSONObject.has("services")) {
                i = 0;
            }
            c(i);
            if (i == 1 || i == 0) {
                f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : "");
                e(jSONObject.has("errorList") ? jSONObject.getJSONObject("errorList").toString() : "");
            } else {
                b(jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : ConnectionResult.RESOLUTION_REQUIRED);
                d(jSONObject.has("errorDesc") ? jSONObject.getString("errorDesc") : "");
            }
        } catch (JSONException e) {
            Logger.w(o, "GrsResponse GrsResponse(String result) JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            c(2);
        }
    }

    private void q() throws NumberFormatException {
        if (o() || n() || m()) {
            Map<String, String> mapR = r();
            if (mapR.size() <= 0) {
                Logger.w(o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (o() || m()) {
                    b(mapR);
                    a(mapR);
                }
                if (n()) {
                    c(mapR);
                }
            } catch (JSONException e) {
                Logger.w(o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            }
        }
    }

    private Map<String, String> r() {
        HashMap map = new HashMap(16);
        Map<String, List<String>> map2 = this.a;
        if (map2 == null || map2.size() <= 0) {
            Logger.v(o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return map;
        }
        for (Map.Entry<String, List<String>> entry : this.a.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                map.put(key, it.next());
            }
        }
        return map;
    }

    private void s() throws NumberFormatException {
        q();
        p();
    }

    public String a() {
        return this.j;
    }

    public void a(int i) {
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(String str) {
        this.l = str;
    }

    public int b() {
        return this.c;
    }

    public void b(long j) {
        this.e = j;
    }

    public void b(String str) {
        this.n = str;
    }

    public int c() {
        return this.i;
    }

    public Exception d() {
        return this.m;
    }

    public String e() {
        return this.l;
    }

    public int f() {
        return this.h;
    }

    public long g() {
        return this.f;
    }

    public long h() {
        return this.e;
    }

    public long i() {
        return this.d;
    }

    public String j() {
        return this.g;
    }

    public long k() {
        return this.k;
    }

    public String l() {
        return this.n;
    }

    public boolean m() {
        return this.c == 304;
    }

    public boolean n() {
        return this.c == 503;
    }

    public boolean o() {
        return this.c == 200;
    }
}
