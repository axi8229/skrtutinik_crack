package com.huawei.appgallery.serviceverifykit.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit;
import com.huawei.appgallery.serviceverifykit.d.c;
import com.huawei.appgallery.serviceverifykit.d.d.b;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int h;
    private String l;
    private String m;
    private Intent n;
    private ServiceVerifyKit.Builder.ComponentType o;
    private Context t;
    private String u;
    private Map<String, String[]> f = new HashMap();
    private Map<String, Integer> g = new HashMap();
    private List<String> i = new ArrayList();
    private List<ServiceVerifyKit.b> j = new ArrayList();
    private int k = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;

    public a(Context context) {
        this.t = context;
    }

    private int a(Bundle bundle, int i) {
        if (!bundle.containsKey("ag.application.base_priority")) {
            return i + 1000;
        }
        try {
            return i + bundle.getInt("ag.application.base_priority");
        } catch (Exception unused) {
            b.b.a("MatchAppFinder", "skip package " + bundle.getString("ag.application.base_priority") + " is not number");
            return i + 1000;
        }
    }

    private int a(Bundle bundle, int i, List<ServiceVerifyKit.b> list) {
        int i2 = 0;
        for (ServiceVerifyKit.b bVar : list) {
            if (i == 1) {
                if (!bundle.containsKey(bVar.a()) || !bundle.get(bVar.a()).toString().equals(bVar.b())) {
                    return 0;
                }
                i2 = 1;
            } else if (i != 2) {
                b.b.a("MatchAppFinder", "error input preferred package name");
            } else if (bundle.containsKey(bVar.a()) && bundle.get(bVar.a()).toString().equals(bVar.b())) {
                i2++;
            }
        }
        return i2;
    }

    private int a(Bundle bundle, String str) {
        if (bundle.containsKey(this.l)) {
            return bundle.getString(this.l).equalsIgnoreCase(str) ? 1 : -1;
        }
        return 0;
    }

    private int a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                i = 1;
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.appgallery.serviceverifykit.a.a a(android.content.pm.PackageInfo r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r10 = this;
            android.content.pm.ApplicationInfo r11 = r11.applicationInfo
            android.os.Bundle r11 = r11.metaData
            r0 = 0
            java.lang.String r1 = "MatchAppFinder"
            if (r11 != 0) goto L25
            com.huawei.appgallery.serviceverifykit.d.d.b r11 = com.huawei.appgallery.serviceverifykit.d.d.b.b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "skip package "
            r12.append(r14)
            r12.append(r13)
            java.lang.String r13 = " for metadata is null"
        L1a:
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.a(r1, r12)
            return r0
        L25:
            java.lang.String r2 = r10.u
            int r7 = r10.a(r11, r2)
            java.lang.String r2 = r10.d
            boolean r2 = r11.containsKey(r2)
            if (r2 != 0) goto L61
            java.lang.String r2 = r10.e
            boolean r2 = r11.containsKey(r2)
            if (r2 == 0) goto L3c
            goto L61
        L3c:
            boolean r12 = r10.a(r13, r12)
            if (r12 == 0) goto L54
            r12 = 1
            r10.q = r12
            java.util.Map<java.lang.String, java.lang.Integer> r12 = r10.g
            java.lang.Object r12 = r12.get(r13)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r10.p = r12
            goto L73
        L54:
            com.huawei.appgallery.serviceverifykit.d.d.b r11 = com.huawei.appgallery.serviceverifykit.d.d.b.b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "Legacy is false, packageName is "
        L5d:
            r12.append(r14)
            goto L1a
        L61:
            boolean r12 = r10.a(r11, r13, r12)
            if (r12 != 0) goto L71
            com.huawei.appgallery.serviceverifykit.d.d.b r11 = com.huawei.appgallery.serviceverifykit.d.d.b.b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "checkSinger failed, packageName is "
            goto L5d
        L71:
            r10.p = r14
        L73:
            java.util.List<java.lang.String> r12 = r10.i
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L83
            java.util.List<java.lang.String> r12 = r10.i
            int r12 = r10.a(r13, r12)
            r10.r = r12
        L83:
            java.util.List<com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$b> r12 = r10.j
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L95
            int r12 = r10.k
            java.util.List<com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$b> r14 = r10.j
            int r12 = r10.a(r11, r12, r14)
            r10.s = r12
        L95:
            int r12 = r10.p
            int r5 = r10.a(r11, r12)
            com.huawei.appgallery.serviceverifykit.a.a r11 = new com.huawei.appgallery.serviceverifykit.a.a
            int r6 = r10.q
            int r8 = r10.r
            int r9 = r10.s
            r3 = r11
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appgallery.serviceverifykit.c.a.a(android.content.pm.PackageInfo, java.lang.String, java.lang.String, int):com.huawei.appgallery.serviceverifykit.a.a");
    }

    private String a(ResolveInfo resolveInfo) {
        ServiceVerifyKit.Builder.ComponentType componentType = this.o;
        return ((componentType == ServiceVerifyKit.Builder.ComponentType.ACTIVITY || componentType == ServiceVerifyKit.Builder.ComponentType.BROADCAST) ? resolveInfo.activityInfo.applicationInfo : resolveInfo.serviceInfo.applicationInfo).packageName;
    }

    private static String a(String str) {
        b bVar;
        String str2;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (ClassNotFoundException unused) {
            bVar = b.b;
            str2 = "getSystemProperties ClassNotFoundException";
            bVar.a("MatchAppFinder", str2);
            return "";
        } catch (Exception unused2) {
            bVar = b.b;
            str2 = "getSystemProperties Exception while getting system property";
            bVar.a("MatchAppFinder", str2);
            return "";
        }
    }

    private List<ResolveInfo> a(PackageManager packageManager) {
        Intent intent;
        ServiceVerifyKit.Builder.ComponentType componentType = this.o;
        if (componentType == null) {
            intent = new Intent(this.a);
        } else {
            if (componentType == ServiceVerifyKit.Builder.ComponentType.ACTIVITY) {
                return packageManager.queryIntentActivities(this.n, this.h);
            }
            if (componentType == ServiceVerifyKit.Builder.ComponentType.BROADCAST) {
                return packageManager.queryBroadcastReceivers(this.n, this.h);
            }
            intent = this.n;
        }
        return packageManager.queryIntentServices(intent, this.h);
    }

    private List<com.huawei.appgallery.serviceverifykit.a.a> a(List<ResolveInfo> list, PackageManager packageManager, int i) throws PackageManager.NameNotFoundException {
        b bVar;
        StringBuilder sb;
        String str;
        PackageInfo packageInfo;
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            String strA = a(resolveInfo);
            try {
                packageInfo = packageManager.getPackageInfo(strA, i);
            } catch (PackageManager.NameNotFoundException unused) {
                bVar = b.b;
                sb = new StringBuilder();
                sb.append("skip package ");
                sb.append(strA);
                str = " for PackageInfo is null";
            }
            if (packageInfo.applicationInfo == null) {
                bVar = b.b;
                sb = new StringBuilder();
                sb.append("skip package ");
                sb.append(strA);
                str = " for ApplicationInfo is null";
            } else {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr == null || signatureArr.length <= 0) {
                    bVar = b.b;
                    sb = new StringBuilder();
                    sb.append("skip package ");
                    sb.append(strA);
                    str = " for no sign";
                } else {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    if (byteArray.length == 0) {
                        bVar = b.b;
                        sb = new StringBuilder();
                        sb.append("skip package ");
                        sb.append(strA);
                        str = " for sign is empty";
                    } else {
                        try {
                            com.huawei.appgallery.serviceverifykit.a.a aVarA = a(packageInfo, com.huawei.appgallery.serviceverifykit.d.b.b(MessageDigest.getInstance("SHA-256").digest(byteArray), true), strA, resolveInfo.priority);
                            if (aVarA != null) {
                                arrayList.add(aVarA);
                            }
                        } catch (NoSuchAlgorithmException unused2) {
                            bVar = b.b;
                            sb = new StringBuilder();
                            sb.append("skip package ");
                            sb.append(strA);
                            str = " for AlgorithmException";
                        }
                    }
                }
            }
            sb.append(str);
            bVar.a("MatchAppFinder", sb.toString());
        }
        return arrayList;
    }

    private boolean a(Bundle bundle, String str, String str2) {
        b bVar;
        String str3;
        if (bundle.containsKey(this.d) && bundle.containsKey(this.e)) {
            if (a(str + ContainerUtils.FIELD_DELIMITER + str2, bundle.getString(this.d), bundle.getString(this.e))) {
                return true;
            }
            bVar = b.b;
            str3 = "checkSinger failed";
        } else {
            bVar = b.b;
            str3 = "skip package " + str + " for no signer or no certChain";
        }
        bVar.a("MatchAppFinder", str3);
        return false;
    }

    private boolean a(String str, String str2) {
        String[] strArr;
        if (this.f.containsKey(str) && (strArr = this.f.get(str)) != null) {
            for (String str3 : strArr) {
                if (str2.equals(str3)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(String str, String str2, String str3) throws UnsupportedEncodingException {
        b bVar;
        String str4;
        byte[] bytes;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            bVar = b.b;
            str4 = "args is invalid";
        } else {
            List<X509Certificate> listB = c.b(str3);
            if (listB.size() == 0) {
                bVar = b.b;
                str4 = "certChain is empty";
            } else if (c.a(c.a(this.t), listB)) {
                X509Certificate x509Certificate = listB.get(0);
                if (!c.a(x509Certificate, this.b)) {
                    bVar = b.b;
                    str4 = "CN is invalid";
                } else if (c.b(x509Certificate, this.c)) {
                    try {
                        bytes = str.getBytes("UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        b.b.a("MatchAppFinder", "checkCertChain UnsupportedEncodingException:", e);
                        bytes = null;
                    }
                    if (c.a(x509Certificate, bytes, com.huawei.appgallery.serviceverifykit.d.a.a(str2))) {
                        return true;
                    }
                    bVar = b.b;
                    str4 = "signature is invalid";
                } else {
                    bVar = b.b;
                    str4 = "OU is invalid";
                }
            } else {
                bVar = b.b;
                str4 = "failed to verify cert chain";
            }
        }
        bVar.a("MatchAppFinder", str4);
        return false;
    }

    public List<com.huawei.appgallery.serviceverifykit.a.a> a() {
        PackageManager packageManager = this.t.getPackageManager();
        List<ResolveInfo> listA = a(packageManager);
        if (listA.size() == 0) {
            return null;
        }
        this.u = TextUtils.isEmpty(this.m) ? Build.MANUFACTURER : a(this.m);
        return a(listA, packageManager, this.h | 192);
    }

    public void a(String str, String str2, String str3, String str4, String str5, Map<String, String[]> map, Map<String, Integer> map2, int i, List<String> list, List<ServiceVerifyKit.b> list2, int i2, String str6, String str7, Intent intent, ServiceVerifyKit.Builder.ComponentType componentType) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = map;
        this.g = map2;
        this.h = i;
        this.i = list;
        this.j = list2;
        this.k = i2;
        this.l = str6;
        this.m = str7;
        this.n = intent;
        this.o = componentType;
    }
}
