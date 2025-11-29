package com.group_ib.sdk;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Message;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.a0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class HandlerC0586a0 extends W0 {
    public Z b;
    public final LinkedHashMap c;
    public final LinkedHashMap d;
    public final b1[] e;
    public boolean f;
    public boolean g;
    public boolean h;

    public HandlerC0586a0(MobileSdkService mobileSdkService) {
        super(mobileSdkService);
        this.b = null;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.c = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.d = linkedHashMap2;
        this.e = new b1[]{new b1(), new b1()};
        this.f = false;
        this.g = false;
        this.h = false;
        int i = Build.VERSION.SDK_INT;
        linkedHashMap2.put("IMEI", i < 26 ? "getDeviceId" : "getImei");
        linkedHashMap2.put("DeviceSoftVersion", "getDeviceSoftwareVersion");
        linkedHashMap2.put("HasICCCard", "hasIccCard");
        linkedHashMap2.put("NetworkCounty", "getNetworkCountryIso");
        linkedHashMap.put("NetworkOperatorID", "getNetworkOperator");
        linkedHashMap.put("SubscriberID", "getSubscriberId");
        linkedHashMap.put("SIMSerialNumber", "getSimSerialNumber");
        linkedHashMap.put("SIMOperatorID", "getSimOperator");
        linkedHashMap.put("PhoneType", "getCurrentPhoneType");
        linkedHashMap.put("GroupIDLevel", "getGroupIdLevel1");
        if (i >= 26) {
            linkedHashMap2.put("MobileEquipID", "getMeid");
            linkedHashMap.put("DataEnabled", "isDataEnabled");
        }
        linkedHashMap.put("MMSUserAgentURL", "getMmsUAProfUrl");
        linkedHashMap.put("MMSUserAgent", "getMmsUserAgent");
        if (i >= 29) {
            linkedHashMap2.put("TypeAllocationCode", "getTypeAllocationCode");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050 A[Catch: Exception -> 0x0083, TryCatch #3 {Exception -> 0x0083, blocks: (B:3:0x0006, B:15:0x004b, B:18:0x0050, B:21:0x0070, B:14:0x0045), top: B:38:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.group_ib.sdk.b1 a(android.telephony.TelephonyManager r18, int r19, int r20) throws java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "TelephonyProvider"
            r3 = 0
            r4 = 1
            com.group_ib.sdk.Y r0 = com.group_ib.sdk.Y.Unknown     // Catch: java.lang.Exception -> L83
            java.lang.Class r5 = r18.getClass()     // Catch: java.lang.Exception -> L83
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Exception -> L83
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Exception -> L83
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L83
            java.lang.Class[] r12 = new java.lang.Class[]{r6}     // Catch: java.lang.Exception -> L83
            java.lang.Object[] r13 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L83
            java.lang.Integer r6 = java.lang.Integer.valueOf(r19)     // Catch: java.lang.Exception -> L83
            r14 = 0
            r13[r14] = r6     // Catch: java.lang.Exception -> L83
            java.lang.String r6 = "getSimState"
            java.lang.reflect.Method r6 = r5.getMethod(r6, r12)     // Catch: java.lang.Exception -> L43
            r15 = r18
            java.lang.Object r6 = r6.invoke(r15, r13)     // Catch: java.lang.Exception -> L45
            if (r6 == 0) goto L4b
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L45
            com.group_ib.sdk.Y[] r7 = com.group_ib.sdk.Y.values()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L40 java.lang.Exception -> L45
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L40 java.lang.Exception -> L45
            r0 = r7[r6]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L40 java.lang.Exception -> L45
            goto L4b
        L40:
            com.group_ib.sdk.Y r0 = com.group_ib.sdk.Y.Unknown     // Catch: java.lang.Exception -> L45
            goto L4b
        L43:
            r15 = r18
        L45:
            java.lang.String r6 = "failed to invoke method SIMState"
            r7 = 4
            com.group_ib.sdk.c1.a(r7, r7, r2, r6)     // Catch: java.lang.Exception -> L83
        L4b:
            com.group_ib.sdk.Y r6 = com.group_ib.sdk.Y.Unknown     // Catch: java.lang.Exception -> L83
            if (r0 != r6) goto L50
            return r3
        L50:
            com.group_ib.sdk.b1 r11 = new com.group_ib.sdk.b1     // Catch: java.lang.Exception -> L83
            r11.<init>()     // Catch: java.lang.Exception -> L83
            java.lang.String r6 = "SIMState"
            java.lang.String r7 = r0.name()     // Catch: java.lang.Exception -> L83
            r11.put(r6, r7)     // Catch: java.lang.Exception -> L83
            java.util.LinkedHashMap r10 = r1.d     // Catch: java.lang.Exception -> L83
            r6 = r18
            r7 = r5
            r8 = r12
            r9 = r13
            r16 = r11
            a(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L83
            com.group_ib.sdk.Y r6 = com.group_ib.sdk.Y.Ready     // Catch: java.lang.Exception -> L83
            if (r0 != r6) goto L85
            if (r20 <= 0) goto L85
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)     // Catch: java.lang.Exception -> L83
            r13[r14] = r0     // Catch: java.lang.Exception -> L83
            java.util.LinkedHashMap r10 = r1.c     // Catch: java.lang.Exception -> L83
            r6 = r18
            r7 = r5
            r8 = r12
            r9 = r13
            r11 = r16
            a(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L83
            goto L85
        L83:
            r0 = move-exception
            goto L88
        L85:
            r3 = r16
            goto La9
        L88:
            boolean r5 = r1.f
            if (r5 != 0) goto L94
            java.lang.String r5 = "failed to collect telephony parameters"
            com.group_ib.sdk.c1.b(r2, r5, r0)
            r1.f = r4
            goto La9
        L94:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "failed to collect telephony parameters: "
            r5.<init>(r6)
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.group_ib.sdk.c1.a(r4, r4, r2, r0)
        La9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.HandlerC0586a0.a(android.telephony.TelephonyManager, int, int):com.group_ib.sdk.b1");
    }

    @Override // android.os.Handler
    public final synchronized void handleMessage(Message message) {
        try {
            if (message.what == 1024) {
                if (this.g) {
                    this.h = false;
                } else {
                    boolean zA = AbstractC0604j0.a(this.a, "android.permission.READ_PHONE_STATE");
                    this.h = zA;
                    this.g = zA;
                }
            }
            if (!this.g) {
                c1.a(4, 4, "TelephonyProvider", "READ_PHONE_STATE permission NOT granted");
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
            if (telephonyManager == null) {
                return;
            }
            SubscriptionManager subscriptionManager = (SubscriptionManager) this.a.getSystemService("telephony_subscription_service");
            JSONObject jSONObjectA = a(0, a(telephonyManager, subscriptionManager, 0));
            JSONObject jSONObjectA2 = a(1, a(telephonyManager, subscriptionManager, 1));
            if (jSONObjectA != null || jSONObjectA2 != null) {
                if (c1.b(5)) {
                    if (jSONObjectA != null) {
                        a("Sim 1 parameters changed:", jSONObjectA);
                    }
                    if (jSONObjectA2 != null) {
                        a("Sim 2 parameters changed:", jSONObjectA2);
                    }
                }
                JSONArray jSONArray = new JSONArray();
                if (jSONObjectA != null) {
                    jSONArray.put(jSONObjectA);
                }
                if (jSONObjectA2 != null) {
                    jSONArray.put(jSONObjectA2);
                }
                this.a.b(jSONArray);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void run() {
        sendEmptyMessage(1);
        this.b = new Z(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
        this.a.registerReceiver(this.b, intentFilter);
    }

    public final b1 a(TelephonyManager telephonyManager, SubscriptionManager subscriptionManager, int i) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex = subscriptionManager != null ? subscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(i) : null;
        b1 b1VarA = a(telephonyManager, i, activeSubscriptionInfoForSimSlotIndex != null ? activeSubscriptionInfoForSimSlotIndex.getSubscriptionId() : -1);
        if (b1VarA != null && activeSubscriptionInfoForSimSlotIndex != null) {
            b1VarA.put("SubscriptionID", Integer.valueOf(activeSubscriptionInfoForSimSlotIndex.getSubscriptionId()));
            b1VarA.put("InRoaming", Boolean.valueOf(subscriptionManager.isNetworkRoaming(activeSubscriptionInfoForSimSlotIndex.getSubscriptionId())));
            b1VarA.put("SIMOperatorName", activeSubscriptionInfoForSimSlotIndex.getDisplayName());
            b1VarA.put("SIMCountry", activeSubscriptionInfoForSimSlotIndex.getCountryIso());
            b1VarA.put("NetworkOperatorName", activeSubscriptionInfoForSimSlotIndex.getCarrierName());
            if (Build.VERSION.SDK_INT >= 28) {
                b1VarA.put("SIMEmbedded", Boolean.valueOf(activeSubscriptionInfoForSimSlotIndex.isEmbedded()));
            }
        }
        return b1VarA;
    }

    public final JSONObject a(int i, b1 b1Var) {
        b1 b1VarA;
        if (b1Var == null || (b1VarA = this.e[i].a(b1Var)) == null) {
            return null;
        }
        this.e[i].putAll(b1VarA);
        return b1VarA.a(3);
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a(int i) {
        if (this.g) {
            this.h = false;
        } else {
            boolean zA = AbstractC0604j0.a(this.a, "android.permission.READ_PHONE_STATE");
            this.h = zA;
            this.g = zA;
        }
        if (this.h) {
            sendEmptyMessage(2048);
        }
    }

    public static void a(TelephonyManager telephonyManager, Class cls, Class[] clsArr, Object[] objArr, LinkedHashMap linkedHashMap, b1 b1Var) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            try {
                Object objInvoke = cls.getMethod((String) entry.getValue(), clsArr).invoke(telephonyManager, objArr);
                if (objInvoke != null) {
                    b1Var.put(entry.getKey(), objInvoke.toString());
                }
            } catch (Exception unused) {
                c1.a(4, 4, "TelephonyProvider", "failed to invoke method " + ((String) entry.getKey()));
            }
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('\n');
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                sb.append('\t');
                sb.append(next);
                sb.append(": ");
                sb.append(jSONObject.get(next));
                sb.append('\n');
            }
            c1.a(4, 4, "TelephonyProvider", sb.toString());
        } catch (Exception unused) {
        }
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a() {
        Z z = this.b;
        if (z != null) {
            this.a.unregisterReceiver(z);
        }
        removeMessages(1024);
    }
}
