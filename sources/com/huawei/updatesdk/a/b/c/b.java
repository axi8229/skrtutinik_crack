package com.huawei.updatesdk.a.b.c;

import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.d.g;
import com.huawei.updatesdk.a.b.c.c.c;
import com.huawei.updatesdk.a.b.c.c.d;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b extends AsyncTask<c, Void, d> {
    protected c a;
    private com.huawei.updatesdk.a.b.c.c.a c;
    private d b = null;
    private com.huawei.updatesdk.a.a.b.b d = null;
    private int e = 0;

    public b(c cVar, com.huawei.updatesdk.a.b.c.c.a aVar) {
        this.a = cVar;
        this.c = aVar;
    }

    private d a(String str, d dVar) {
        try {
            dVar.fromJson(new JSONObject(str));
            dVar.b(0);
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("StoreTask", "parse json error", e);
        }
        return dVar;
    }

    private void a(d dVar, int i, d.a aVar, Throwable th) {
        if (dVar != null) {
            dVar.b(i);
            dVar.a(aVar);
            dVar.a(th.toString());
        }
    }

    private void a(d dVar, Throwable th, String str) {
        d.a aVar;
        int i = 1;
        if (th instanceof ConnectException) {
            aVar = d.a.CONNECT_EXCEPTION;
        } else if ((th instanceof SocketTimeoutException) || (th instanceof ConnectTimeoutException)) {
            aVar = d.a.CONNECT_EXCEPTION;
            i = 2;
        } else if (th instanceof IllegalArgumentException) {
            aVar = d.a.PARAM_ERROR;
            i = 5;
        } else if (th instanceof IllegalAccessException) {
            aVar = d.a.UNKNOWN_EXCEPTION;
        } else {
            if (!(th instanceof ArrayIndexOutOfBoundsException)) {
                if ((th instanceof InterruptedException) || (th instanceof InterruptedIOException)) {
                    a(dVar, 0, d.a.NORMAL, th);
                    com.huawei.updatesdk.a.a.a.a("StoreTask", "UpdateSDK task is canceled");
                } else if (th instanceof IOException) {
                    aVar = d.a.IO_EXCEPTION;
                } else if (dVar != null) {
                    dVar.a(th.toString());
                }
                a(str, th);
            }
            aVar = d.a.NO_PROGUARD;
            i = 6;
        }
        a(dVar, i, aVar, th);
        a(str, th);
    }

    private void a(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("invoke store error");
        sb.append(", exceptionType:");
        sb.append(th.getClass().getName());
        sb.append(", url:");
        sb.append(str);
        sb.append(", method:");
        sb.append(this.a.b());
        sb.append(", retryTimes:" + this.e);
        String string = sb.toString();
        com.huawei.updatesdk.a.a.c.a.a.a.a("StoreTask", string, th);
        com.huawei.updatesdk.a.a.a.a("StoreTask", "UpdateSDK call store error: " + string);
    }

    private boolean a(String str) {
        return TextUtils.isEmpty(str) || !g.d(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(com.huawei.updatesdk.a.b.c.c.d r5) {
        /*
            r4 = this;
            java.lang.String r0 = "notifyResult, create response error, method:"
            boolean r1 = r4.isCancelled()
            if (r1 != 0) goto L5e
            com.huawei.updatesdk.a.b.c.c.a r1 = r4.c
            if (r1 == 0) goto L5e
            if (r5 != 0) goto L57
            java.lang.String r1 = "notifyResult, response is null"
            java.lang.String r2 = "StoreTask"
            com.huawei.updatesdk.a.a.c.a.a.a.b(r2, r1)
            com.huawei.updatesdk.a.b.c.c.c r1 = r4.a     // Catch: java.lang.IllegalAccessException -> L20 java.lang.InstantiationException -> L22
            java.lang.String r1 = r1.b()     // Catch: java.lang.IllegalAccessException -> L20 java.lang.InstantiationException -> L22
            com.huawei.updatesdk.a.b.c.c.d r5 = com.huawei.updatesdk.a.b.c.a.a(r1)     // Catch: java.lang.IllegalAccessException -> L20 java.lang.InstantiationException -> L22
            goto L43
        L20:
            r1 = move-exception
            goto L24
        L22:
            r1 = move-exception
            goto L3d
        L24:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L29:
            r3.append(r0)
            com.huawei.updatesdk.a.b.c.c.c r0 = r4.a
            java.lang.String r0 = r0.b()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.updatesdk.a.a.c.a.a.a.a(r2, r0, r1)
            goto L43
        L3d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L29
        L43:
            if (r5 != 0) goto L50
            com.huawei.updatesdk.a.b.c.c.d r5 = new com.huawei.updatesdk.a.b.c.c.d
            r5.<init>()
            com.huawei.updatesdk.a.b.c.c.d$a r0 = com.huawei.updatesdk.a.b.c.c.d.a.PARAM_ERROR
        L4c:
            r5.a(r0)
            goto L53
        L50:
            com.huawei.updatesdk.a.b.c.c.d$a r0 = com.huawei.updatesdk.a.b.c.c.d.a.UNKNOWN_EXCEPTION
            goto L4c
        L53:
            r0 = 1
            r5.b(r0)
        L57:
            com.huawei.updatesdk.a.b.c.c.a r0 = r4.c
            com.huawei.updatesdk.a.b.c.c.c r1 = r4.a
            r0.b(r1, r5)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.a.b.c.b.b(com.huawei.updatesdk.a.b.c.c.d):void");
    }

    private void b(String str) {
        com.huawei.updatesdk.a.a.a.a("StoreTask", TextUtils.isEmpty(str) ? "UpdateSDK response error, resData == null" : "UpdateSDK response error, resData is not json string");
    }

    private boolean c(d dVar) {
        if (isCancelled()) {
            return false;
        }
        if (dVar.d() != 1 && dVar.d() != 2) {
            return false;
        }
        int i = this.e;
        this.e = i + 1;
        if (i >= 3) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("StoreTask", "retry completed total times = " + this.e + ",response.responseCode = " + dVar.d());
            return false;
        }
        com.huawei.updatesdk.a.a.c.a.a.a.a("StoreTask", "retry times = " + this.e + ",response.responseCode = " + dVar.d());
        return true;
    }

    private String d() throws PackageManager.NameNotFoundException {
        String strA = com.huawei.updatesdk.b.g.a.a();
        return TextUtils.isEmpty(strA) ? "Android/1.0" : strA;
    }

    private void e() {
        b(this.b);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.huawei.updatesdk.a.b.c.c.d a() {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.a.b.c.b.a():com.huawei.updatesdk.a.b.c.c.d");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d doInBackground(c... cVarArr) {
        com.huawei.updatesdk.a.a.c.a.a.a.a("StoreTask", "doInBackground, method:" + this.a.b());
        com.huawei.updatesdk.b.g.b.a(this);
        d dVarC = c();
        com.huawei.updatesdk.a.b.c.c.a aVar = this.c;
        if (aVar != null) {
            aVar.a(this.a, dVarC);
        }
        return dVarC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(d dVar) {
        com.huawei.updatesdk.a.a.c.a.a.a.a("StoreTask", "onPostExecute, method:" + this.a.b());
        com.huawei.updatesdk.b.g.b.a().remove(this);
        e();
    }

    public final void a(Executor executor) {
        executeOnExecutor(executor, this.a);
    }

    public void b() {
        com.huawei.updatesdk.a.a.b.b bVar = this.d;
        if (bVar != null) {
            bVar.a();
            this.d = null;
        }
    }

    public final d c() {
        d dVarA = null;
        do {
            if (this.e > 0 && dVarA != null) {
                com.huawei.updatesdk.a.a.c.a.a.a.a("StoreTask", "call store error! responseCode:" + dVarA.d() + ", retryTimes:" + this.e);
            }
            dVarA = a();
        } while (c(dVarA));
        this.b = dVarA;
        return dVarA;
    }
}
