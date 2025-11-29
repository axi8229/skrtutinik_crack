package com.group_ib.sdk;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.i0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0602i0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public long i;
    public final HashSet j;
    public final long k;
    public final long l;
    public String m;
    public String n;
    public String o;
    public final String p;
    public long q;

    public C0602i0(PackageInfo packageInfo, PackageManager packageManager) {
        this.d = null;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = 0L;
        this.j = null;
        this.k = 0L;
        this.l = 0L;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0L;
        this.a = packageInfo.packageName;
        this.b = packageInfo.versionName;
        this.k = packageInfo.firstInstallTime;
        this.l = packageInfo.lastUpdateTime;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        this.c = applicationInfo.sourceDir;
        try {
            String string = applicationInfo.loadLabel(packageManager).toString();
            if (string != null) {
                this.d = Base64.encodeToString(string.getBytes(), 2);
            }
        } catch (Exception e) {
            c1.b("Package", "failed to get package label", e);
        }
        try {
            this.p = packageManager.getInstallerPackageName(this.a);
        } catch (Exception e2) {
            c1.b("Package", "failed to get installer package name", e2);
        }
        if (packageInfo.requestedPermissions != null) {
            this.j = new HashSet();
            for (String str : packageInfo.requestedPermissions) {
                this.j.add(str.replaceFirst("android.permission.", ""));
            }
        }
        if (packageInfo.receivers != null) {
            if (this.j == null) {
                this.j = new HashSet();
            }
            for (ActivityInfo activityInfo : packageInfo.receivers) {
                String str2 = activityInfo.permission;
                if (str2 != null) {
                    this.j.add(str2.replaceFirst("android.permission.", ""));
                }
            }
        }
    }

    public final void a() throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        StringBuilder sb;
        if (this.o != null || this.m != null || this.n != null) {
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(this.c);
                this.q = file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-1");
                    MessageDigest messageDigest3 = MessageDigest.getInstance("SHA-256");
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            this.o = AbstractC0604j0.a(messageDigest.digest());
                            this.m = AbstractC0604j0.a(messageDigest2.digest());
                            this.n = AbstractC0604j0.a(messageDigest3.digest());
                            try {
                                fileInputStream.close();
                                return;
                            } catch (Exception e) {
                                e = e;
                                sb = new StringBuilder("Exception in closing of apk file ");
                                sb.append(this.c);
                                c1.b("Package", sb.toString(), e);
                            }
                        }
                        messageDigest.update(bArr, 0, i);
                        messageDigest2.update(bArr, 0, i);
                        messageDigest3.update(bArr, 0, i);
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    c1.b("Package", "Exception in hashing of apk file " + this.c, e);
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e3) {
                            e = e3;
                            sb = new StringBuilder("Exception in closing of apk file ");
                            sb.append(this.c);
                            c1.b("Package", sb.toString(), e);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            c1.b("Package", "Exception in closing of apk file " + this.c, e4);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                FileInputStream fileInputStream3 = fileInputStream2;
                th = th3;
                fileInputStream = fileInputStream3;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public final JSONObject b() throws Throwable {
        JSONArray jSONArray;
        try {
            JSONObject jSONObjectPut = new JSONObject().put(AppMeasurementSdk.ConditionalUserProperty.NAME, this.a).put("version", this.b).put("label", this.d);
            if (this.o == null) {
                a();
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put("md5", this.o);
            if (this.m == null) {
                a();
            }
            JSONObject jSONObjectPut3 = jSONObjectPut2.put("sha1", this.m);
            if (this.n == null) {
                a();
            }
            JSONObject jSONObjectPut4 = jSONObjectPut3.put("sha256", this.n).put("size", this.q).put("installed", this.k).put("lastUpdated", this.l).put("installer", this.p);
            if (this.f || this.h || this.g) {
                jSONArray = new JSONArray();
                if (this.f) {
                    jSONArray.put("harmful");
                }
                if (this.h) {
                    jSONArray.put("admin_enabled");
                }
                if (this.g) {
                    jSONArray.put("admin_active");
                }
            } else {
                jSONArray = null;
            }
            JSONObject jSONObjectPut5 = jSONObjectPut4.put("flags", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            HashSet hashSet = this.j;
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    jSONArray2.put((String) it.next());
                }
            }
            jSONObjectPut5.put("permissions", jSONArray2);
            return jSONObjectPut5;
        } catch (Exception e) {
            c1.b("Package", "Failed to encode package " + this.a + " into json", e);
            return null;
        }
    }

    public C0602i0(C0602i0 c0602i0) {
        this.d = null;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = 0L;
        this.j = null;
        this.k = 0L;
        this.l = 0L;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0L;
        this.a = c0602i0.a;
        this.d = c0602i0.d;
        this.e = c0602i0.e;
        this.b = c0602i0.b;
        this.j = c0602i0.j != null ? new HashSet(c0602i0.j) : null;
        this.k = c0602i0.k;
        this.l = c0602i0.l;
        this.c = c0602i0.c;
        this.o = c0602i0.o;
        this.m = c0602i0.m;
        this.n = c0602i0.n;
        this.p = c0602i0.p;
        this.f = c0602i0.f;
        this.g = c0602i0.g;
        this.h = c0602i0.h;
        this.q = c0602i0.q;
        this.i = 0L;
    }
}
