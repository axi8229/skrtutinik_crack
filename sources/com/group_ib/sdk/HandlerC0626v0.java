package com.group_ib.sdk;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* renamed from: com.group_ib.sdk.v0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class HandlerC0626v0 extends W0 {
    public static final /* synthetic */ int $r8$clinit = 0;
    public C0630x0 b;
    public PackageManager c;
    public C0614o0 d;
    public C0622t0 e;
    public boolean f;
    public boolean g;

    public HandlerC0626v0(MobileSdkService mobileSdkService) {
        super(mobileSdkService.f(), mobileSdkService);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = true;
    }

    public static ArrayList a(MobileSdkService mobileSdkService, Set set, int i) {
        PackageManager packageManager = mobileSdkService.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        char[] cArr = AbstractC0604j0.a;
        if (set.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                arrayList.add(packageManager.getPackageInfo(str, i));
            } catch (Exception e) {
                c1.b("PackageProvider", "Failed to collect info for package " + str, e);
            }
        }
        return arrayList;
    }

    public final List b() {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.a.getSystemService("device_policy");
        ArrayList arrayList = null;
        List<ComponentName> activeAdmins = devicePolicyManager != null ? devicePolicyManager.getActiveAdmins() : null;
        if (activeAdmins == null || activeAdmins.isEmpty()) {
            return activeAdmins;
        }
        for (ComponentName componentName : activeAdmins) {
            if (componentName != null) {
                String packageName = componentName.getPackageName();
                if (packageName == null) {
                    activeAdmins.remove(componentName);
                } else if (!packageName.startsWith("com.google.android.")) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(componentName);
                }
            }
        }
        return arrayList;
    }

    public final List c() {
        ActivityInfo activityInfo;
        String str;
        List<ResolveInfo> listQueryBroadcastReceivers = this.c.queryBroadcastReceivers(new Intent("android.app.action.DEVICE_ADMIN_ENABLED"), 32896);
        if (listQueryBroadcastReceivers == null || listQueryBroadcastReceivers.isEmpty()) {
            return listQueryBroadcastReceivers;
        }
        ArrayList arrayList = null;
        for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
            if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && (str = activityInfo.packageName) != null && !str.startsWith("com.google.android.")) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(resolveInfo);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0238 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fa A[Catch: Exception -> 0x00c7, TryCatch #6 {Exception -> 0x00c7, blocks: (B:51:0x00bd, B:54:0x00c4, B:58:0x00ea, B:60:0x00fa, B:61:0x0102, B:63:0x0108, B:64:0x0122, B:57:0x00c9), top: B:134:0x00bd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.group_ib.sdk.C0630x0 d() throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.HandlerC0626v0.d():com.group_ib.sdk.x0");
    }

    public final void e() {
        String str;
        if (this.g) {
            if (!T.a()) {
                str = "SafetyNet: client library in not linked to the app, harmful apps request disabled";
            } else {
                if (T.b(this.a)) {
                    if (this.f) {
                        return;
                    }
                    this.f = true;
                    c1.b("PackageProvider", "SafetyNet: harmful apps request initiated");
                    SafetyNet.getClient(this.a).listHarmfulApps().addOnCompleteListener(new C0624u0(this));
                    return;
                }
                str = "SafetyNet: Google API is not available, harmful apps request disabled";
            }
            c1.a(str);
            this.g = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0089 A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #1 {all -> 0x0027, blocks: (B:5:0x0006, B:29:0x004d, B:31:0x0059, B:33:0x005e, B:35:0x0066, B:36:0x006e, B:40:0x007d, B:42:0x0081, B:43:0x0089, B:13:0x0016, B:23:0x003c, B:20:0x002b, B:26:0x0043, B:28:0x0047, B:38:0x0074), top: B:48:0x0006, inners: #0 }] */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void handleMessage(android.os.Message r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "PackageProvider"
            r1 = 16384(0x4000, float:2.2959E-41)
            r2 = 0
            int r3 = r8.what     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r4 = 1
            if (r3 == r4) goto L43
            r5 = 2048(0x800, float:2.87E-42)
            if (r3 == r5) goto L2b
            r5 = 4096(0x1000, float:5.74E-42)
            if (r3 == r5) goto L2b
            if (r3 == r1) goto L16
            goto L4d
        L16:
            com.group_ib.sdk.x0 r3 = r7.b     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.util.List r5 = r7.b()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            android.content.pm.PackageManager r6 = r7.c     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            boolean r3 = r3.a(r5, r6)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r3 == 0) goto L40
            java.lang.String r5 = "List of admin active packages has changed"
            goto L3c
        L27:
            r8 = move-exception
            goto L91
        L29:
            r8 = move-exception
            goto L74
        L2b:
            com.group_ib.sdk.x0 r3 = r7.b     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.util.List r5 = r7.c()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            android.content.pm.PackageManager r6 = r7.c     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            boolean r3 = r3.b(r5, r6)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r3 == 0) goto L4d
            java.lang.String r5 = "List of admin enabled packages has changed"
            r3 = r4
        L3c:
            r6 = 3
            com.group_ib.sdk.c1.a(r6, r6, r0, r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
        L40:
            if (r3 == 0) goto L7b
            goto L4d
        L43:
            com.group_ib.sdk.x0 r0 = r7.b     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r0 != 0) goto L4d
            com.group_ib.sdk.x0 r0 = r7.d()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r7.b = r0     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
        L4d:
            com.group_ib.sdk.x0 r0 = r7.b     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.lang.String r3 = com.group_ib.sdk.T.a     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            com.group_ib.sdk.x0 r2 = r0.a()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            int r8 = r8.what     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r8 != r4) goto L5c
            r7.e()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
        L5c:
            if (r2 == 0) goto L7b
            java.util.HashMap r8 = r2.a     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            int r8 = r8.size()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r8 == 0) goto L6e
            java.lang.String r8 = "PackageProvider"
            java.lang.String r0 = "Package data has changed"
            r3 = 4
            com.group_ib.sdk.c1.a(r3, r3, r8, r0)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
        L6e:
            com.group_ib.sdk.MobileSdkService r8 = r7.a     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r8.a(r2)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            goto L7b
        L74:
            java.lang.String r0 = "PackageProvider"
            java.lang.String r3 = "Failed to collect packages info"
            com.group_ib.sdk.c1.b(r0, r3, r8)     // Catch: java.lang.Throwable -> L27
        L7b:
            if (r2 == 0) goto L89
            boolean r8 = r2.e     // Catch: java.lang.Throwable -> L27
            if (r8 != 0) goto L89
            r8 = 1024(0x400, float:1.435E-42)
            r0 = 10000(0x2710, double:4.9407E-320)
            r7.sendEmptyMessageDelayed(r8, r0)     // Catch: java.lang.Throwable -> L27
            goto L8f
        L89:
            r2 = 60000(0xea60, double:2.9644E-319)
            r7.sendEmptyMessageDelayed(r1, r2)     // Catch: java.lang.Throwable -> L27
        L8f:
            monitor-exit(r7)
            return
        L91:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L27
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.HandlerC0626v0.handleMessage(android.os.Message):void");
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void run() {
        this.c = this.a.getPackageManager();
        C0622t0 c0622t0 = new C0622t0();
        c0622t0.a = this;
        this.e = c0622t0;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        this.a.registerReceiver(this.e, intentFilter);
        sendEmptyMessage(1);
    }

    public static HashSet a(MobileSdkService mobileSdkService) {
        HashSet hashSet = new HashSet();
        PackageManager packageManager = mobileSdkService.getPackageManager();
        if (packageManager == null) {
            return hashSet;
        }
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 30 ? packageManager.queryIntentActivities(new Intent("android.intent.action.MAIN", (Uri) null).addCategory("android.intent.category.LAUNCHER"), 0) : null;
        char[] cArr = AbstractC0604j0.a;
        if (installedPackages != null && !installedPackages.isEmpty()) {
            for (PackageInfo packageInfo : installedPackages) {
                if ((packageInfo.applicationInfo.flags & pjsip_transport_type_e.PJSIP_TRANSPORT_UDP6) == 0) {
                    hashSet.add(packageInfo.packageName);
                }
            }
        }
        if (listQueryIntentActivities != null && !listQueryIntentActivities.isEmpty()) {
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if ((activityInfo.applicationInfo.flags & pjsip_transport_type_e.PJSIP_TRANSPORT_UDP6) == 0) {
                    hashSet.add(activityInfo.packageName);
                }
            }
        }
        return hashSet;
    }

    public final synchronized void a(Task task) {
        List<HarmfulAppsData> harmfulAppsList;
        try {
            this.f = false;
            if (task.isSuccessful()) {
                c1.b("PackageProvider", "SafetyNet: harmful apps request finished successfully");
                SafetyNetApi.HarmfulAppsResponse harmfulAppsResponse = (SafetyNetApi.HarmfulAppsResponse) task.getResult();
                if (harmfulAppsResponse != null && (harmfulAppsList = harmfulAppsResponse.getHarmfulAppsList()) != null && !harmfulAppsList.isEmpty()) {
                    for (HarmfulAppsData harmfulAppsData : harmfulAppsList) {
                        c1.a("SafetyNet: '" + harmfulAppsData.apkPackageName + "' considered harmful");
                        this.b.a(harmfulAppsData, this.c);
                    }
                    sendEmptyMessage(8192);
                }
            } else {
                c1.b("PackageProvider", "SafetyNet: harmful apps request finished with failure (may be disabled or unavailable)");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void a(HandlerC0626v0 handlerC0626v0, String str) {
        synchronized (handlerC0626v0) {
            if (str != null) {
                try {
                    if (handlerC0626v0.d != null && handlerC0626v0.b != null) {
                        try {
                            PackageManager packageManager = handlerC0626v0.a.getPackageManager();
                            PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo(str, 4290) : null;
                            if (packageInfo != null) {
                                C0614o0 c0614o0 = handlerC0626v0.d;
                                long j = packageInfo.lastUpdateTime;
                                c0614o0.a(j, str);
                                c1.a(4, 4, "PackageDb", "Package added/updated: " + str + " at " + j);
                                handlerC0626v0.b.a(packageInfo, handlerC0626v0.c);
                                handlerC0626v0.e();
                                handlerC0626v0.sendEmptyMessage(2048);
                            }
                        } catch (Exception e) {
                            c1.b("PackageProvider", "Failed to add package info for newly added package", e);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a() {
        C0622t0 c0622t0 = this.e;
        if (c0622t0 != null) {
            this.a.unregisterReceiver(c0622t0);
            this.e = null;
        }
    }
}
