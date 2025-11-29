package com.group_ib.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes3.dex */
public final class O0 extends Handler {
    public final MobileSdkService a;
    public String b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final boolean g;

    public O0(Looper looper, MobileSdkService mobileSdkService) {
        super(looper);
        this.b = null;
        this.c = 4000;
        this.d = true;
        this.e = false;
        this.f = false;
        this.a = mobileSdkService;
        this.g = AbstractC0604j0.a((Context) mobileSdkService);
    }

    public final String a() {
        String str;
        MobileSdkService mobileSdkService = this.a;
        ArrayList arrayListA = HandlerC0626v0.a(mobileSdkService, T.a(mobileSdkService), 8);
        char[] cArr = AbstractC0604j0.a;
        if (arrayListA == null || arrayListA.isEmpty()) {
            return null;
        }
        TreeMap treeMap = new TreeMap();
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            PackageInfo packageInfo = (PackageInfo) it.next();
            if (packageInfo.providers != null) {
                String str2 = packageInfo.packageName;
                synchronized (T.class) {
                    str = T.g;
                }
                if (!str2.equals(str)) {
                    ProviderInfo[] providerInfoArr = packageInfo.providers;
                    int length = providerInfoArr.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            ProviderInfo providerInfo = providerInfoArr[i];
                            String str3 = providerInfo.authority;
                            if (str3 != null && str3.endsWith(".gib") && providerInfo.exported) {
                                treeMap.put(Long.valueOf(packageInfo.firstInstallTime), providerInfo.packageName);
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        Iterator it2 = treeMap.entrySet().iterator();
        while (it2.hasNext()) {
            String strA = a((String) ((Map.Entry) it2.next()).getValue());
            if (strA != null) {
                return strA;
            }
        }
        return null;
    }

    public final void b(String str) {
        String str2;
        this.a.a(str);
        synchronized (T.class) {
            str2 = T.g;
        }
        if (str2 != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", "1");
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
                this.a.getContentResolver().insert(Uri.parse("content://" + str2 + ".gib/group_ib"), contentValues);
            } catch (Exception e) {
                c1.b("GlobalIdProvider", "Update Global Id failed", e);
            }
        }
        getLooper().quit();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws IOException {
        HttpsURLConnection httpsURLConnection;
        String str;
        int i = message.what;
        if (i == 4) {
            this.c = 4000;
        } else {
            if (i != 16) {
                if (i == 32) {
                    this.d = false;
                    return;
                }
                if (i == 1024) {
                    synchronized (T.class) {
                        str = T.g;
                    }
                    String strA = str != null ? a(str) : null;
                    this.b = strA;
                    if (strA == null) {
                        this.b = a();
                    }
                } else if (i != 2048) {
                    return;
                }
            }
            this.d = true;
            this.c = 4000;
        }
        if (this.d) {
            String str2 = this.b;
            URL urlH = T.h();
            try {
                httpsURLConnection = (HttpsURLConnection) urlH.openConnection();
                C0.a(httpsURLConnection, this.g);
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setRequestProperty("Content-length", "0");
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setAllowUserInteraction(false);
                httpsURLConnection.setConnectTimeout(20000);
                httpsURLConnection.setReadTimeout(20000);
                if (str2 != null) {
                    httpsURLConnection.setRequestProperty("Cookie", "gcfids=".concat(str2));
                }
                httpsURLConnection.connect();
            } catch (Exception e) {
                if (this.e) {
                    c1.a(1, 1, "GlobalIdProvider", "Failed to connect to " + urlH + ": " + e.getMessage());
                } else {
                    c1.b("GlobalIdProvider", "Failed to connect to " + urlH, e);
                    this.e = true;
                }
                b();
                httpsURLConnection = null;
            }
            try {
                if (httpsURLConnection != null) {
                    try {
                        String str3 = T.a;
                        C0.b(httpsURLConnection);
                        int responseCode = httpsURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            Map<String, List<String>> headerFields = httpsURLConnection.getHeaderFields();
                            List<String> list = headerFields != null ? headerFields.get("Set-Cookie") : null;
                            if (list != null) {
                                Iterator<String> it = list.iterator();
                                while (it.hasNext()) {
                                    String[] strArrSplit = it.next().split(";");
                                    int length = strArrSplit.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            String[] strArrSplit2 = strArrSplit[i2].split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
                                            if (strArrSplit2.length == 2 && strArrSplit2[0].trim().equals("gcfids")) {
                                                String strTrim = strArrSplit2[1].trim();
                                                c1.a(4, 4, "GlobalIdProvider", "Global Id refreshed: " + strTrim);
                                                b(strTrim);
                                                break;
                                            }
                                            i2++;
                                        }
                                    }
                                }
                            }
                            httpsURLConnection.getInputStream().close();
                        } else if (responseCode < 500 || responseCode > 505) {
                            c1.a(4, 4, "GlobalIdProvider", "Server response code for " + urlH + ": " + responseCode + ", skip update Global Id");
                            C0.a(httpsURLConnection);
                            this.a.a((String) null);
                            getLooper().quit();
                        } else {
                            c1.a(4, 4, "GlobalIdProvider", "Server response code for " + urlH + ": " + responseCode + ", retry later");
                            C0.a(httpsURLConnection);
                            b();
                        }
                        httpsURLConnection.disconnect();
                    } catch (Exception e2) {
                        if (this.f) {
                            c1.a(1, 1, "GlobalIdProvider", "Failed to get Global Id from " + urlH + ": " + e2.getMessage());
                        } else {
                            c1.b("GlobalIdProvider", "Failed to get Global Id from " + urlH, e2);
                            this.f = true;
                        }
                        b();
                        httpsURLConnection.disconnect();
                    }
                }
            } catch (Throwable th) {
                httpsURLConnection.disconnect();
                throw th;
            }
        }
    }

    public final String a(String str) {
        c1.a(4, 4, "GlobalIdProvider", "Calling content provider '" + str + ".gib'");
        String string = null;
        try {
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://" + str + ".gib/group_ib"), null, null, null, null);
            if (cursorQuery != null) {
                int columnIndex = cursorQuery.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
                if (columnIndex >= 0 && cursorQuery.moveToFirst()) {
                    string = cursorQuery.getString(columnIndex);
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            c1.a(4, 4, "GlobalIdProvider", "failed to get " + str + " provider global id, " + e.getMessage());
        }
        return string;
    }

    public final void b() {
        if (this.d) {
            sendEmptyMessageDelayed(2048, this.c);
            int i = this.c << 1;
            this.c = i;
            if (i > 60000) {
                this.c = 60000;
            }
        }
    }
}
