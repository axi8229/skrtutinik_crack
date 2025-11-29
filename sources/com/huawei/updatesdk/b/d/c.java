package com.huawei.updatesdk.b.d;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes3.dex */
public class c extends AsyncTask<Void, Void, Void> {
    private String a;
    private HttpsURLConnection b;
    private com.huawei.updatesdk.b.d.b d;
    private boolean c = false;
    private Handler e = new b(null);

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.b != null) {
                c.this.c = true;
                c.this.b.disconnect();
            }
            com.huawei.updatesdk.a.a.d.d.a(new File(c.e()));
        }
    }

    private static class b extends Handler {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj instanceof com.huawei.updatesdk.b.d.b) {
                com.huawei.updatesdk.b.d.b bVar = (com.huawei.updatesdk.b.d.b) obj;
                Intent intent = new Intent();
                com.huawei.updatesdk.a.b.b.b bVarA = com.huawei.updatesdk.a.b.b.b.a(intent);
                int i = message.what;
                if (i == 2) {
                    intent.putExtra("download_apk_size", bVar.e());
                    intent.putExtra("download_apk_already", bVar.a());
                    com.huawei.updatesdk.b.f.c.b().a(bVarA);
                    return;
                }
                if (i != 3) {
                    if (i == 4) {
                        e.a(com.huawei.updatesdk.a.b.a.a.c().a(), c.e() + "/appmarket.apk", bVar.c());
                    } else if (i != 5) {
                        return;
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putInt("download_status_param", message.what);
                intent.putExtras(bundle);
                com.huawei.updatesdk.b.f.c.b().b(bVarA);
            }
        }
    }

    public c(com.huawei.updatesdk.b.d.b bVar) {
        this.d = bVar;
        if (TextUtils.isEmpty(bVar.c())) {
            return;
        }
        this.a = bVar.c();
    }

    private void a(int i, long j, String str, int i2) {
        com.huawei.updatesdk.b.d.b bVar = new com.huawei.updatesdk.b.d.b();
        bVar.a(i);
        bVar.a(j);
        bVar.a(str);
        Handler handler = this.e;
        if (handler == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(i2, bVar));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:36:0x008f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private void a(com.huawei.updatesdk.b.d.b r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r0 = "Close FileOutputStream failed!"
            java.lang.String r1 = "DownloadMarketTask"
            if (r6 == 0) goto L9d
            java.lang.String r2 = r6.b()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L12
            goto L9d
        L12:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r7 = "/appmarket.apk"
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r7)
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52 java.io.FileNotFoundException -> L54
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52 java.io.FileNotFoundException -> L54
            boolean r6 = r5.a(r6, r4, r7)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44 java.io.FileNotFoundException -> L46
            if (r6 != 0) goto L48
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44 java.io.FileNotFoundException -> L46
            java.lang.String r7 = e()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44 java.io.FileNotFoundException -> L46
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44 java.io.FileNotFoundException -> L46
            com.huawei.updatesdk.a.a.d.d.a(r6)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44 java.io.FileNotFoundException -> L46
            goto L48
        L41:
            r6 = move-exception
            r3 = r4
            goto L93
        L44:
            r6 = move-exception
            goto L4c
        L46:
            r6 = move-exception
            goto L4e
        L48:
            r4.close()     // Catch: java.io.IOException -> L8f
            goto L92
        L4c:
            r3 = r4
            goto L56
        L4e:
            r3 = r4
            goto L74
        L50:
            r6 = move-exception
            goto L93
        L52:
            r6 = move-exception
            goto L56
        L54:
            r6 = move-exception
            goto L74
        L56:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r7.<init>()     // Catch: java.lang.Throwable -> L50
            java.lang.String r2 = "DOWNLOAD market package Exception error:"
            r7.append(r2)     // Catch: java.lang.Throwable -> L50
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L50
            r7.append(r6)     // Catch: java.lang.Throwable -> L50
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Throwable -> L50
            com.huawei.updatesdk.a.a.c.a.a.a.b(r1, r6)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L92
        L70:
            r3.close()     // Catch: java.io.IOException -> L8f
            goto L92
        L74:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r7.<init>()     // Catch: java.lang.Throwable -> L50
            java.lang.String r2 = "DOWNLOAD market package FileNotFoundException error:"
            r7.append(r2)     // Catch: java.lang.Throwable -> L50
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L50
            r7.append(r6)     // Catch: java.lang.Throwable -> L50
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Throwable -> L50
            com.huawei.updatesdk.a.a.c.a.a.a.b(r1, r6)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L92
            goto L70
        L8f:
            com.huawei.updatesdk.a.a.c.a.a.a.b(r1, r0)
        L92:
            return
        L93:
            if (r3 == 0) goto L9c
            r3.close()     // Catch: java.io.IOException -> L99
            goto L9c
        L99:
            com.huawei.updatesdk.a.a.c.a.a.a.b(r1, r0)
        L9c:
            throw r6
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.b.d.c.a(com.huawei.updatesdk.b.d.b, java.lang.String):void");
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                com.huawei.updatesdk.a.a.c.a.a.a.b("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + e.toString());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                com.huawei.updatesdk.a.a.c.a.a.a.b("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + e2.toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.huawei.updatesdk.b.d.b r21, java.io.OutputStream r22, java.lang.String r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.b.d.c.a(com.huawei.updatesdk.b.d.b, java.io.OutputStream, java.lang.String):boolean");
    }

    private void d() {
        HttpsURLConnection httpsURLConnection = this.b;
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e() {
        String strB = com.huawei.updatesdk.a.b.a.a.c().b();
        if (TextUtils.isEmpty(strB)) {
            return "";
        }
        String str = strB + "/updatesdk";
        File file = new File(str);
        return (file.exists() || file.mkdirs()) ? str : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws Throwable {
        com.huawei.updatesdk.b.g.b.a(this);
        a(this.d, e());
        return null;
    }

    public void a() {
        new Thread(new a()).start();
    }

    public void b() {
        this.e = null;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        a();
    }
}
