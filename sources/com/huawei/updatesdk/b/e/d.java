package com.huawei.updatesdk.b.e;

import android.os.AsyncTask;

/* loaded from: classes3.dex */
public class d extends AsyncTask<Void, Void, String> {
    private String a;
    private String b;

    public d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f A[Catch: all -> 0x0058, Exception -> 0x005a, TRY_LEAVE, TryCatch #7 {Exception -> 0x005a, all -> 0x0058, blocks: (B:8:0x002a, B:10:0x0030, B:15:0x005f), top: B:46:0x002a }] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void... r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r11 = "cursor Execption"
            java.lang.String r0 = "GetAccountZoneTask"
            java.lang.String r1 = r10.a
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 == 0) goto Le
            return r2
        Le:
            java.lang.String r1 = r10.a
            android.net.Uri r4 = android.net.Uri.parse(r1)
            com.huawei.updatesdk.a.b.a.a r1 = com.huawei.updatesdk.a.b.a.a.c()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            android.content.Context r1 = r1.a()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            android.content.ContentResolver r3 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            r7 = 0
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            if (r1 == 0) goto L5f
            boolean r3 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r3 == 0) goto L5f
            java.lang.String r3 = "homecountry"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r2 = r1.getString(r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            com.huawei.updatesdk.service.otaupdate.f r3 = com.huawei.updatesdk.service.otaupdate.f.e()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r3.a(r2)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            com.huawei.updatesdk.b.b.a r3 = com.huawei.updatesdk.b.b.a.d()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r4 = r10.b     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r3.a(r4, r5)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            com.huawei.updatesdk.b.b.a r3 = com.huawei.updatesdk.b.b.a.d()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r4 = r10.b     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r3.b(r4, r2)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            goto L64
        L58:
            r2 = move-exception
            goto L96
        L5a:
            r3 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
            goto L71
        L5f:
            java.lang.String r3 = "cursor == null: "
            com.huawei.updatesdk.a.a.a.a(r0, r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
        L64:
            if (r1 == 0) goto L95
            r1.close()     // Catch: java.lang.Exception -> L90
            goto L95
        L6a:
            r1 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
            goto L96
        L6f:
            r3 = move-exception
            r1 = r2
        L71:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r4.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r5 = "close cursor error: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L6a
            r4.append(r3)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L6a
            com.huawei.updatesdk.a.a.a.a(r0, r3)     // Catch: java.lang.Throwable -> L6a
            if (r2 == 0) goto L94
            r2.close()     // Catch: java.lang.Exception -> L8f
            goto L94
        L8f:
            r2 = r1
        L90:
            com.huawei.updatesdk.a.a.c.a.a.a.b(r0, r11)
            goto L95
        L94:
            r2 = r1
        L95:
            return r2
        L96:
            if (r1 == 0) goto L9f
            r1.close()     // Catch: java.lang.Exception -> L9c
            goto L9f
        L9c:
            com.huawei.updatesdk.a.a.c.a.a.a.b(r0, r11)
        L9f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.b.e.d.doInBackground(java.lang.Void[]):java.lang.String");
    }
}
