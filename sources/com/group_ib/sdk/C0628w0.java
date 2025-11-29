package com.group_ib.sdk;

import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* renamed from: com.group_ib.sdk.w0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0628w0 implements d1 {
    public final MobileSdkService a;
    public TelephonyManager b = null;
    public CellInfo c = null;
    public long d = 0;

    public C0628w0(MobileSdkService mobileSdkService) {
        this.a = mobileSdkService;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r0.getSystemId() == r3.getSystemId()) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        if (r4 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.telephony.CellInfo r3, android.telephony.CellInfoCdma r4) {
        /*
            android.telephony.CellIdentityCdma r0 = r4.getCellIdentity()
            if (r3 == 0) goto L13
            java.lang.Class r1 = r3.getClass()
            java.lang.Class r4 = r4.getClass()
            if (r1 == r4) goto L11
            goto L13
        L11:
            r4 = 0
            goto L14
        L13:
            r4 = 1
        L14:
            if (r4 != 0) goto L3b
            android.telephony.CellInfoCdma r3 = (android.telephony.CellInfoCdma) r3
            android.telephony.CellIdentityCdma r3 = r3.getCellIdentity()
            int r4 = r0.getBasestationId()
            int r1 = r3.getBasestationId()
            if (r4 != r1) goto L3f
            int r4 = r0.getNetworkId()
            int r1 = r3.getNetworkId()
            if (r4 != r1) goto L3f
            int r4 = r0.getSystemId()
            int r3 = r3.getSystemId()
            if (r4 == r3) goto L3d
            goto L3f
        L3b:
            if (r4 != 0) goto L3f
        L3d:
            r3 = 0
            goto L88
        L3f:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "type"
            java.lang.String r1 = "cdma"
            org.json.JSONObject r3 = r3.put(r4, r1)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = "t"
            org.json.JSONObject r3 = r3.put(r4, r1)
            int r4 = r0.getBasestationId()
            java.lang.String r1 = "bid"
            org.json.JSONObject r3 = r3.put(r1, r4)
            int r4 = r0.getNetworkId()
            java.lang.String r1 = "nid"
            org.json.JSONObject r3 = r3.put(r1, r4)
            int r4 = r0.getSystemId()
            java.lang.String r1 = "sid"
            org.json.JSONObject r3 = r3.put(r1, r4)
            int r4 = r0.getLatitude()
            java.lang.String r1 = "lat"
            org.json.JSONObject r3 = r3.put(r1, r4)
            int r4 = r0.getLongitude()
            java.lang.String r0 = "lon"
            org.json.JSONObject r3 = r3.put(r0, r4)
        L88:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.C0628w0.a(android.telephony.CellInfo, android.telephony.CellInfoCdma):org.json.JSONObject");
    }

    @Override // com.group_ib.sdk.d1
    public final void run() {
        this.b = (TelephonyManager) this.a.getSystemService("phone");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.telephony.CellInfo r5, android.telephony.CellInfoGsm r6) throws org.json.JSONException {
        /*
            android.telephony.CellIdentityGsm r0 = r6.getCellIdentity()
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L15
            java.lang.Class r3 = r5.getClass()
            java.lang.Class r6 = r6.getClass()
            if (r3 == r6) goto L13
            goto L15
        L13:
            r6 = r2
            goto L16
        L15:
            r6 = r1
        L16:
            r3 = 28
            if (r6 != 0) goto L6f
            android.telephony.CellInfoGsm r5 = (android.telephony.CellInfoGsm) r5
            android.telephony.CellIdentityGsm r5 = r5.getCellIdentity()
            int r6 = r0.getCid()
            int r4 = r5.getCid()
            if (r6 != r4) goto L36
            int r6 = r0.getLac()
            int r4 = r5.getLac()
            if (r6 == r4) goto L35
            goto L36
        L35:
            r1 = r2
        L36:
            if (r1 != 0) goto L6e
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r3) goto L59
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline8.m(r0)
            java.lang.String r1 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline8.m(r5)
            boolean r6 = a(r6, r1)
            if (r6 != 0) goto L71
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline9.m(r0)
            java.lang.String r5 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline9.m(r5)
            boolean r5 = a(r6, r5)
            if (r5 == 0) goto Lc2
            goto L71
        L59:
            int r6 = r0.getMcc()
            int r1 = r5.getMcc()
            if (r6 != r1) goto L71
            int r6 = r0.getMnc()
            int r5 = r5.getMnc()
            if (r6 == r5) goto Lc2
            goto L71
        L6e:
            r6 = r1
        L6f:
            if (r6 == 0) goto Lc2
        L71:
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r6 = "type"
            java.lang.String r1 = "gsm"
            org.json.JSONObject r5 = r5.put(r6, r1)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = "t"
            org.json.JSONObject r5 = r5.put(r6, r1)
            int r6 = r0.getCid()
            java.lang.String r1 = "cid"
            org.json.JSONObject r5 = r5.put(r1, r6)
            int r6 = r0.getLac()
            java.lang.String r1 = "lac"
            org.json.JSONObject r5 = r5.put(r1, r6)
            int r6 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "mnc"
            java.lang.String r2 = "mcc"
            if (r6 < r3) goto Lb3
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline8.m(r0)
            r5.put(r2, r6)
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline9.m(r0)
            r5.put(r1, r6)
            goto Lc1
        Lb3:
            int r6 = r0.getMcc()
            r5.put(r2, r6)
            int r6 = r0.getMnc()
            r5.put(r1, r6)
        Lc1:
            return r5
        Lc2:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.C0628w0.a(android.telephony.CellInfo, android.telephony.CellInfoGsm):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.telephony.CellInfo r5, android.telephony.CellInfoLte r6) throws org.json.JSONException {
        /*
            android.telephony.CellIdentityLte r0 = r6.getCellIdentity()
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L15
            java.lang.Class r3 = r5.getClass()
            java.lang.Class r6 = r6.getClass()
            if (r3 == r6) goto L13
            goto L15
        L13:
            r6 = r2
            goto L16
        L15:
            r6 = r1
        L16:
            r3 = 28
            if (r6 != 0) goto L6f
            android.telephony.CellInfoLte r5 = (android.telephony.CellInfoLte) r5
            android.telephony.CellIdentityLte r5 = r5.getCellIdentity()
            int r6 = r0.getCi()
            int r4 = r5.getCi()
            if (r6 != r4) goto L36
            int r6 = r0.getTac()
            int r4 = r5.getTac()
            if (r6 == r4) goto L35
            goto L36
        L35:
            r1 = r2
        L36:
            if (r1 != 0) goto L6e
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r3) goto L59
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline23.m(r0)
            java.lang.String r1 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline23.m(r5)
            boolean r6 = a(r6, r1)
            if (r6 != 0) goto L71
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline24.m(r0)
            java.lang.String r5 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline24.m(r5)
            boolean r5 = a(r6, r5)
            if (r5 == 0) goto Lc2
            goto L71
        L59:
            int r6 = r0.getMcc()
            int r1 = r5.getMcc()
            if (r6 != r1) goto L71
            int r6 = r0.getMnc()
            int r5 = r5.getMnc()
            if (r6 == r5) goto Lc2
            goto L71
        L6e:
            r6 = r1
        L6f:
            if (r6 == 0) goto Lc2
        L71:
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r6 = "type"
            java.lang.String r1 = "lte"
            org.json.JSONObject r5 = r5.put(r6, r1)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = "t"
            org.json.JSONObject r5 = r5.put(r6, r1)
            int r6 = r0.getCi()
            java.lang.String r1 = "ci"
            org.json.JSONObject r5 = r5.put(r1, r6)
            int r6 = r0.getTac()
            java.lang.String r1 = "tac"
            org.json.JSONObject r5 = r5.put(r1, r6)
            int r6 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "mnc"
            java.lang.String r2 = "mcc"
            if (r6 < r3) goto Lb3
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline23.m(r0)
            r5.put(r2, r6)
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline24.m(r0)
            r5.put(r1, r6)
            goto Lc1
        Lb3:
            int r6 = r0.getMcc()
            r5.put(r2, r6)
            int r6 = r0.getMnc()
            r5.put(r1, r6)
        Lc1:
            return r5
        Lc2:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.C0628w0.a(android.telephony.CellInfo, android.telephony.CellInfoLte):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        if (a(r0.getMncString(), r5.getMncString()) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        if (r6 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.telephony.CellInfo r5, android.telephony.CellInfoNr r6) {
        /*
            android.telephony.CellIdentity r0 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline10.m(r6)
            android.telephony.CellIdentityNr r0 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline15.m(r0)
            if (r5 == 0) goto L17
            java.lang.Class r1 = r5.getClass()
            java.lang.Class r6 = r6.getClass()
            if (r1 == r6) goto L15
            goto L17
        L15:
            r6 = 0
            goto L18
        L17:
            r6 = 1
        L18:
            if (r6 != 0) goto L59
            android.telephony.CellInfoNr r5 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline3.m(r5)
            android.telephony.CellIdentity r5 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline10.m(r5)
            android.telephony.CellIdentityNr r5 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline15.m(r5)
            long r1 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline13.m(r0)
            long r3 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline13.m(r5)
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 != 0) goto L5d
            int r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline14.m(r0)
            int r1 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline14.m(r5)
            if (r6 != r1) goto L5d
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline11.m(r0)
            java.lang.String r1 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline11.m(r5)
            boolean r6 = a(r6, r1)
            if (r6 != 0) goto L5d
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline12.m(r0)
            java.lang.String r5 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline12.m(r5)
            boolean r5 = a(r6, r5)
            if (r5 == 0) goto L5b
            goto L5d
        L59:
            if (r6 != 0) goto L5d
        L5b:
            r5 = 0
            goto L9c
        L5d:
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r6 = "type"
            java.lang.String r1 = "nr"
            org.json.JSONObject r5 = r5.put(r6, r1)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = "t"
            org.json.JSONObject r5 = r5.put(r6, r1)
            long r1 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline13.m(r0)
            java.lang.String r6 = "nci"
            org.json.JSONObject r5 = r5.put(r6, r1)
            int r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline14.m(r0)
            java.lang.String r1 = "tac"
            org.json.JSONObject r5 = r5.put(r1, r6)
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline11.m(r0)
            java.lang.String r1 = "mcc"
            org.json.JSONObject r5 = r5.put(r1, r6)
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline12.m(r0)
            java.lang.String r0 = "mnc"
            org.json.JSONObject r5 = r5.put(r0, r6)
        L9c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.C0628w0.a(android.telephony.CellInfo, android.telephony.CellInfoNr):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        if (a(r0.getMncString(), r3.getMncString()) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r4 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.telephony.CellInfo r3, android.telephony.CellInfoTdscdma r4) {
        /*
            android.telephony.CellIdentityTdscdma r0 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline16.m(r4)
            if (r3 == 0) goto L13
            java.lang.Class r1 = r3.getClass()
            java.lang.Class r4 = r4.getClass()
            if (r1 == r4) goto L11
            goto L13
        L11:
            r4 = 0
            goto L14
        L13:
            r4 = 1
        L14:
            if (r4 != 0) goto L4f
            android.telephony.CellInfoTdscdma r3 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline2.m(r3)
            android.telephony.CellIdentityTdscdma r3 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline16.m(r3)
            int r4 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline18.m(r0)
            int r1 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline18.m(r3)
            if (r4 != r1) goto L53
            int r4 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline19.m(r0)
            int r1 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline19.m(r3)
            if (r4 != r1) goto L53
            java.lang.String r4 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline20.m(r0)
            java.lang.String r1 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline20.m(r3)
            boolean r4 = a(r4, r1)
            if (r4 != 0) goto L53
            java.lang.String r4 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline17.m(r0)
            java.lang.String r3 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline17.m(r3)
            boolean r3 = a(r4, r3)
            if (r3 == 0) goto L51
            goto L53
        L4f:
            if (r4 != 0) goto L53
        L51:
            r3 = 0
            goto L92
        L53:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "type"
            java.lang.String r1 = "tdscdma"
            org.json.JSONObject r3 = r3.put(r4, r1)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = "t"
            org.json.JSONObject r3 = r3.put(r4, r1)
            int r4 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline18.m(r0)
            java.lang.String r1 = "cid"
            org.json.JSONObject r3 = r3.put(r1, r4)
            int r4 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline19.m(r0)
            java.lang.String r1 = "lac"
            org.json.JSONObject r3 = r3.put(r1, r4)
            java.lang.String r4 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline20.m(r0)
            java.lang.String r1 = "mcc"
            org.json.JSONObject r3 = r3.put(r1, r4)
            java.lang.String r4 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline17.m(r0)
            java.lang.String r0 = "mnc"
            org.json.JSONObject r3 = r3.put(r0, r4)
        L92:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.C0628w0.a(android.telephony.CellInfo, android.telephony.CellInfoTdscdma):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.telephony.CellInfo r5, android.telephony.CellInfoWcdma r6) throws org.json.JSONException {
        /*
            android.telephony.CellIdentityWcdma r0 = r6.getCellIdentity()
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L15
            java.lang.Class r3 = r5.getClass()
            java.lang.Class r6 = r6.getClass()
            if (r3 == r6) goto L13
            goto L15
        L13:
            r6 = r2
            goto L16
        L15:
            r6 = r1
        L16:
            r3 = 28
            if (r6 != 0) goto L6f
            android.telephony.CellInfoWcdma r5 = (android.telephony.CellInfoWcdma) r5
            android.telephony.CellIdentityWcdma r5 = r5.getCellIdentity()
            int r6 = r0.getCid()
            int r4 = r5.getCid()
            if (r6 != r4) goto L36
            int r6 = r0.getLac()
            int r4 = r5.getLac()
            if (r6 == r4) goto L35
            goto L36
        L35:
            r1 = r2
        L36:
            if (r1 != 0) goto L6e
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r3) goto L59
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline21.m(r0)
            java.lang.String r1 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline21.m(r5)
            boolean r6 = a(r6, r1)
            if (r6 != 0) goto L71
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline22.m(r0)
            java.lang.String r5 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline22.m(r5)
            boolean r5 = a(r6, r5)
            if (r5 == 0) goto Lc2
            goto L71
        L59:
            int r6 = r0.getMcc()
            int r1 = r5.getMcc()
            if (r6 != r1) goto L71
            int r6 = r0.getMnc()
            int r5 = r5.getMnc()
            if (r6 == r5) goto Lc2
            goto L71
        L6e:
            r6 = r1
        L6f:
            if (r6 == 0) goto Lc2
        L71:
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r6 = "type"
            java.lang.String r1 = "wcdma"
            org.json.JSONObject r5 = r5.put(r6, r1)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = "t"
            org.json.JSONObject r5 = r5.put(r6, r1)
            int r6 = r0.getCid()
            java.lang.String r1 = "cid"
            org.json.JSONObject r5 = r5.put(r1, r6)
            int r6 = r0.getLac()
            java.lang.String r1 = "lac"
            org.json.JSONObject r5 = r5.put(r1, r6)
            int r6 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "mnc"
            java.lang.String r2 = "mcc"
            if (r6 < r3) goto Lb3
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline21.m(r0)
            r5.put(r2, r6)
            java.lang.String r6 = com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline22.m(r0)
            r5.put(r1, r6)
            goto Lc1
        Lb3:
            int r6 = r0.getMcc()
            r5.put(r2, r6)
            int r6 = r0.getMnc()
            r5.put(r1, r6)
        Lc1:
            return r5
        Lc2:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.C0628w0.a(android.telephony.CellInfo, android.telephony.CellInfoWcdma):org.json.JSONObject");
    }

    @Override // com.group_ib.sdk.d1
    public final void a(int i) {
        boolean z;
        if (i == 16) {
            this.d = 0L;
        } else if (i == 32) {
            this.d = 9223372036854745807L;
            return;
        } else if (i != 256) {
            return;
        }
        if (this.b == null || this.d + UtilsKt.UPDATE_INTERVAL > System.currentTimeMillis() || !AbstractC0604j0.a(this.a, "android.permission.ACCESS_FINE_LOCATION")) {
            return;
        }
        synchronized (T.class) {
            if (!T.o) {
                Class<?> cls = null;
                if (Build.VERSION.SDK_INT >= 29) {
                    try {
                        cls = Class.forName("android.telephony.TelephonyManager.CellInfoCallback");
                    } catch (ClassNotFoundException unused) {
                    }
                }
                T.p = cls != null;
                T.o = true;
            }
            z = T.p;
        }
        if (z) {
            this.b.requestCellInfoUpdate(this.a.d, new C0620s0(this));
        } else {
            a(this.b.getAllCellInfo());
        }
        this.d = System.currentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.util.List r9) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.C0628w0.a(java.util.List):void");
    }

    public static boolean a(String str, String str2) {
        return ((str == null) ^ (str2 == null)) || !(str == null || str.equals(str2));
    }

    @Override // com.group_ib.sdk.d1
    public final void a() {
        this.b = null;
    }
}
