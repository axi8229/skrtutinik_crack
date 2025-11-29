package com.group_ib.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class G extends Handler {
    public final MobileSdkService a;
    public URL b;
    public boolean c;
    public int d;
    public final LinkedList e;
    public JSONObject f;
    public boolean g;
    public boolean h;

    public G(Looper looper, MobileSdkService mobileSdkService) {
        super(looper);
        this.b = null;
        this.c = false;
        this.d = 4000;
        this.e = new LinkedList();
        this.f = null;
        this.g = false;
        this.h = true;
        this.a = mobileSdkService;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f5 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final javax.net.ssl.HttpsURLConnection a(int r9, java.lang.String r10) throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.KeyManagementException {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.G.a(int, java.lang.String):javax.net.ssl.HttpsURLConnection");
    }

    public final boolean b(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            InputStream inputStream = httpsURLConnection.getInputStream();
            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 256);
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                bufferedReader.close();
                JSONObject jSONObject3 = new JSONObject(sb.toString());
                String string = jSONObject3.getString(UpdateKey.STATUS);
                if (string != null && string.matches("success") && (jSONObject = jSONObject3.getJSONObject(RemoteMessageConst.DATA)) != null && (jSONObject2 = jSONObject.getJSONObject("cs")) != null) {
                    String string2 = jSONObject2.has("cfids") ? jSONObject2.getString("cfids") : null;
                    String string3 = jSONObject2.has("gssc") ? jSONObject2.getString("gssc") : null;
                    if (string2 != null) {
                        this.a.a(string2, string3);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            c1.b("NetworkAgent", "failed to read response from server", e);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler
    public final synchronized void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 1:
                    this.g = false;
                    removeMessages(2);
                    a();
                    break;
                case 2:
                    a();
                    break;
                case 3:
                    c1.a(4, 4, "NetworkAgent", "got signal to QUIT");
                    getLooper().quit();
                    break;
                case 4:
                    Object obj = message.obj;
                    if (!(obj instanceof JSONObject)) {
                        break;
                    } else {
                        this.e.add((JSONObject) obj);
                        while (this.e.size() > 20) {
                            this.e.removeFirst();
                        }
                        this.f = null;
                        c1.a(4, 4, "NetworkAgent", "packet id " + message.obj.hashCode() + " added, queue size: " + this.e.size());
                        if (this.e.size() == 1) {
                            a();
                            break;
                        }
                    }
                    break;
                case 5:
                    if ((message.obj instanceof JSONObject) && this.e.isEmpty() && this.f == null) {
                        c1.a(4, 4, "NetworkAgent", "keep-alive packet id " + message.obj.hashCode() + " added, queue size: 1");
                        this.f = (JSONObject) message.obj;
                        a();
                        break;
                    }
                    break;
                case 6:
                    this.h = true;
                    a();
                    break;
                case 7:
                    this.h = false;
                    break;
            }
        } catch (Exception e) {
            c1.b("NetworkAgent", "handleMessage: ", e);
        } finally {
        }
    }

    public final void b(JSONObject jSONObject) {
        sendMessage(obtainMessage(4, jSONObject));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean b() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.LinkedList r0 = r1.e     // Catch: java.lang.Throwable -> Lf
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto L11
            org.json.JSONObject r0 = r1.f     // Catch: java.lang.Throwable -> Lf
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        Lf:
            r0 = move-exception
            goto L14
        L11:
            r0 = 0
        L12:
            monitor-exit(r1)
            return r0
        L14:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lf
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.G.b():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.G.a():void");
    }

    public final void a(String str) {
        String str2;
        StringBuilder sb;
        String string;
        String str3 = str + "?as=2.0.b302271022";
        synchronized (T.class) {
            str2 = T.g;
        }
        if (str2 != null) {
            String strA = AbstractC0604j0.a(T.e() + '-' + T.f());
            if (strA != null) {
                string = str3 + "&p=" + strA;
                this.b = new URL(string);
                this.c = AbstractC0604j0.a((Context) this.a);
            }
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
        }
        sb.append(str3);
        sb.append("&p=NA-NA");
        string = sb.toString();
        this.b = new URL(string);
        this.c = AbstractC0604j0.a((Context) this.a);
    }

    public static void a(HttpsURLConnection httpsURLConnection) throws IOException {
        try {
            InputStream errorStream = httpsURLConnection.getErrorStream();
            if (errorStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream), 256);
                while (bufferedReader.readLine() != null) {
                }
                bufferedReader.close();
            }
        } catch (IOException e) {
            c1.a(1, 1, "NetworkAgent", "failed to read error from " + httpsURLConnection.getURL() + ": " + e.getMessage());
        }
    }

    public final void a(JSONObject jSONObject) {
        sendMessage(obtainMessage(5, jSONObject));
    }
}
