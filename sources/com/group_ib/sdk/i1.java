package com.group_ib.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* loaded from: classes3.dex */
public final class i1 extends Handler {
    public static final /* synthetic */ boolean r = true;
    public final Context a;
    public String b;
    public final LinkedList c;
    public final LinkedList d;
    public final q e;
    public boolean f;
    public int g;
    public final m1 h;
    public final m1 i;
    public Cipher j;
    public SecureRandom k;
    public final SecretKeySpec l;
    public final boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public long q;

    public i1(Looper looper, Context context, int i) {
        byte[] bArrDecode;
        super(looper);
        this.f = true;
        this.g = 5000;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = 0L;
        this.a = context;
        this.c = new LinkedList();
        this.d = new LinkedList();
        this.e = new q(context, c1.d, i != 6 ? 2 : 1);
        this.h = new m1();
        this.i = new m1();
        String strB = X.b(14);
        if (strB != null && (bArrDecode = Base64.decode(strB, 2)) != null) {
            this.l = new SecretKeySpec(bArrDecode, "AES");
        }
        this.m = AbstractC0604j0.a(context);
    }

    public final void a(String str) {
        if (T.a(this.m)) {
            Log.v("GIBSDK: [LogAgent]", str);
        }
    }

    public final void b(HttpsURLConnection httpsURLConnection) throws IOException {
        try {
            InputStream inputStream = httpsURLConnection.getInputStream();
            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 256);
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        sb.append(line);
                    }
                }
                bufferedReader.close();
                String str = (String) new JSONObject(sb.toString()).get("level");
                if (str != null) {
                    c1.a(Z0.a(str));
                }
            }
        } catch (Exception e) {
            a("failed to read response from server", e);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws JSONException, NoSuchAlgorithmException, InvalidKeyException, IOException, KeyManagementException, InvalidAlgorithmParameterException {
        String str;
        if (message == null) {
            return;
        }
        switch (message.what) {
            case 0:
                Object obj = message.obj;
                if (obj != null) {
                    C0621t c0621t = (C0621t) obj;
                    if (c0621t.a == 1) {
                        try {
                            this.e.d();
                        } catch (Exception e) {
                            a("failed to switch to DIRECT mode", e);
                        }
                    }
                    this.c.add(c0621t);
                    if (c0621t.a == 1 || this.c.size() > 10) {
                        b();
                    }
                    if (c0621t.a != 1 && System.currentTimeMillis() - this.q <= UtilsKt.UPDATE_INTERVAL) {
                        return;
                    }
                    a();
                    return;
                }
                return;
            case 1:
                a("timer fired");
                removeMessages(1);
                a();
                return;
            case 2:
                a("got signal to QUIT");
                b();
                getLooper().quit();
                return;
            case 3:
                if (!this.f) {
                    this.g = 5000;
                }
                this.n = false;
                this.o = false;
                this.f = true;
                a();
                return;
            case 4:
                a("log initialized");
                String strEncodeToString = "";
                try {
                    byte[] bytes = c1.e.getBytes();
                    char[] cArr = AbstractC0604j0.a;
                    strEncodeToString = Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(bytes), 2);
                } catch (Exception unused) {
                }
                this.c.addFirst(new C0621t(3, "LogAgent", "Started with level " + Z0.a(c1.a) + ", hashed AndroidID " + strEncodeToString));
                b();
                a();
                return;
            case 5:
                int i = c1.a;
                try {
                    if (i != 6) {
                        if (i == 1) {
                            this.e.b();
                            return;
                        } else {
                            this.e.d();
                            return;
                        }
                    }
                    q qVar = this.e;
                    synchronized (qVar) {
                        try {
                            if (qVar.q != 1) {
                                qVar.q = 1;
                                FileOutputStream fileOutputStream = qVar.b;
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    qVar.b = null;
                                }
                                qVar.c = null;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Exception e2) {
                    a("failed to setup log level to ".concat(Z0.a(i)), e2);
                    return;
                }
            case 6:
                a("there are no logs for too long period, send service message to update log level");
                this.c.add(new C0621t(3, "LogAgent", "Continue with level ".concat(Z0.a(c1.a))));
                b();
                a();
                return;
            case 7:
                if (this.p) {
                    return;
                }
                this.p = true;
                str = "Log sending resumed";
                a(str);
                a();
                return;
            case 8:
                if (this.p) {
                    this.p = false;
                    a("Log sending paused");
                    return;
                }
                return;
            case 9:
                String strConcat = T.d;
                if (strConcat == null) {
                    URL url = T.b;
                    String string = url != null ? url.toString() : null;
                    if (string != null) {
                        strConcat = string.concat("/logs/");
                        T.d = strConcat;
                    }
                }
                this.b = strConcat;
                if (this.p) {
                    return;
                }
                this.p = true;
                str = "Log sending started";
                a(str);
                a();
                return;
            default:
                return;
        }
    }

    public final void a(String str, Exception exc) {
        if (str != null) {
            if (exc != null) {
                Log.e("LogAgent", str, exc);
            } else {
                Log.e("LogAgent", str);
            }
            this.d.push(new C0621t("LogAgent", str, exc));
            while (this.d.size() > 30) {
                this.d.removeFirst();
            }
        }
    }

    public final void a(LinkedList linkedList, m1 m1Var) throws JSONException, InvalidKeyException, InvalidAlgorithmParameterException {
        String str;
        if (!r && linkedList == null) {
            throw new AssertionError();
        }
        if (this.l == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", "1.0");
            jSONObject.put("sdk", "Android SDK");
            jSONObject.put(HianalyticsBaseData.SDK_VERSION, "2.0.b302271022");
            synchronized (T.class) {
                str = T.g;
            }
            jSONObject.put("app", str != null ? T.e() : "@Test");
            jSONObject.put("app_version", T.f() != null ? T.f() : "N/A");
            jSONObject.put("device_id", c1.e);
            jSONObject.put("session", c1.d);
            JSONArray jSONArray = new JSONArray();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                jSONArray.put(((C0621t) it.next()).a());
            }
            jSONObject.put("messages", jSONArray);
            byte[] bytes = jSONObject.toString().getBytes();
            if (this.j == null) {
                this.j = Cipher.getInstance("AES/GCM/NoPadding");
            }
            if (this.k == null) {
                this.k = new SecureRandom();
            }
            byte[] bArr = new byte[12];
            this.k.nextBytes(bArr);
            this.j.init(1, this.l, new IvParameterSpec(bArr));
            m1Var.a(bytes.length + 28);
            m1Var.a(12);
            System.arraycopy(bArr, 0, m1Var.a, m1Var.b, 12);
            int i = m1Var.b + 12;
            m1Var.b = i;
            m1Var.b += this.j.doFinal(bytes, 0, bytes.length, m1Var.a, i);
        } catch (Exception unused) {
            m1Var.b = 0;
        }
    }

    public final void b() throws JSONException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (this.c.size() == 0) {
            return;
        }
        a("have " + this.c.size() + " messages in memory queue");
        LinkedList linkedList = this.c;
        m1 m1Var = this.i;
        m1Var.b = 0;
        a(linkedList, m1Var);
        if (this.i.a()) {
            return;
        }
        try {
            this.e.b(this.i);
            this.c.clear();
            a("MEMORY messages saved on disk");
        } catch (Exception e) {
            a("Failed to write new logs on disk", e);
        }
    }

    public final void a(HttpsURLConnection httpsURLConnection) throws IOException {
        try {
            InputStream errorStream = httpsURLConnection.getErrorStream();
            if (errorStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream), 256);
                while (bufferedReader.readLine() != null) {
                }
                bufferedReader.close();
            }
        } catch (IOException e) {
            a("failed to read error from server", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.group_ib.sdk.m1 r10) throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.KeyManagementException {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.i1.a(com.group_ib.sdk.m1):boolean");
    }

    public final void a() throws JSONException, NoSuchAlgorithmException, InvalidKeyException, IOException, KeyManagementException, InvalidAlgorithmParameterException {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        boolean z = (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
        this.f = z;
        if (z && this.p) {
            if (this.h.a()) {
                try {
                    q qVar = this.e;
                    m1 m1Var = this.h;
                    synchronized (qVar) {
                        if (m1Var != null) {
                            m1Var.a(205000);
                            int i = 0;
                            while (i < 204800) {
                                int iA = qVar.a(m1Var);
                                if (iA == 0) {
                                    break;
                                } else {
                                    i += iA;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    a("Failed to read logs from disk", e);
                }
            }
            if (this.h.a()) {
                a("no DISK messages, send control message in 30 mins");
                removeMessages(6);
                sendEmptyMessageDelayed(6, 1800000L);
            } else {
                if (a(this.h)) {
                    a("sending logs from DISK over INET OK");
                    this.q = System.currentTimeMillis();
                    try {
                        this.e.a();
                    } catch (Exception e2) {
                        a("Failed to commit read logs", e2);
                    }
                    this.g = this.h.b >= 204800 ? 5000 : 60000;
                    a("retry in " + this.g + " ms");
                    removeMessages(1);
                    sendEmptyMessageDelayed(1, (long) this.g);
                    this.h.b = 0;
                } else {
                    int i2 = this.g * 3;
                    this.g = i2;
                    if (i2 > 60000) {
                        this.g = 60000;
                    }
                    a("sending logs over Internet FAILED, retry in " + this.g + " ms");
                    removeMessages(1);
                    sendEmptyMessageDelayed(1, (long) this.g);
                }
                removeMessages(6);
            }
            if (this.d.size() > 0) {
                if (this.f) {
                    LinkedList linkedList = this.d;
                    m1 m1Var2 = this.i;
                    m1Var2.b = 0;
                    a(linkedList, m1Var2);
                    if (!this.i.a()) {
                        a(this.i);
                    }
                }
                this.d.clear();
            }
        }
    }
}
