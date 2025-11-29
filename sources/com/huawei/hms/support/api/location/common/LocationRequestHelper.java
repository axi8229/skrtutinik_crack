package com.huawei.hms.support.api.location.common;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.locationSdk.e1;
import com.huawei.hms.locationSdk.j0;
import com.huawei.hms.locationSdk.k0;
import com.huawei.hms.locationSdk.n0;
import com.huawei.hms.locationSdk.v1;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.updates.RemoveLocationUpdatesRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.lite.common.util.ReflectionUtils;
import com.huawei.location.lite.common.util.TelephonyUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LocationRequestHelper {
    public static final String CP_TRANS_ID = "cpTransId";
    private static final String LOCATION_REQUEST_API_NAME = "Location_requestLocationUpdates_SDK";
    private static final String TAG = "LocationRequestHelper";
    private static final String VDR_ENABLE = "1";
    private static final String VDR_GNSS_OPTION = "vdrEnable";

    public static void assertNoNull(Object obj) throws ApiException {
        if (obj == null) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
    }

    private static void buildRequestEntity(String str, LocationRequest locationRequest, LocationCallback locationCallback, RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        requestLocationUpdatesRequest.setLocationRequest(locationRequest);
        if (!TextUtils.equals(str, "Intent")) {
            requestLocationUpdatesRequest.setUuid(locationCallback.getUuid());
        }
        if (TextUtils.equals(str, "ExCallback")) {
            locationRequest.putExtras("productId", getProductId());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.huawei.hms.locationSdk.n0 buildTaskApiCall(java.lang.String r15, com.huawei.hms.location.LocationCallback r16, android.os.Looper r17, android.app.PendingIntent r18, com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r19, com.huawei.hms.locationSdk.k0 r20, java.lang.String r21) throws com.huawei.hms.common.ApiException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.location.common.LocationRequestHelper.buildTaskApiCall(java.lang.String, com.huawei.hms.location.LocationCallback, android.os.Looper, android.app.PendingIntent, com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest, com.huawei.hms.locationSdk.k0, java.lang.String):com.huawei.hms.locationSdk.n0");
    }

    private static void checkLocationPermission() throws ApiException {
        if (!PermissionUtil.isLocationPermissionAvailable(ContextUtil.getContext())) {
            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
        }
    }

    private static void checkMethodSupport(String str) throws ApiException {
        if (TextUtils.equals(str, "Intent") && !v1.a(ContextUtil.getContext())) {
            throw new ApiException(new Status(LocationStatusCode.NOT_YET_SUPPORTED, LocationStatusCode.getStatusCodeString(LocationStatusCode.NOT_YET_SUPPORTED)));
        }
    }

    private static void checkPriority(String str, LocationRequest locationRequest) throws ApiException {
        str.hashCode();
        switch (str) {
            case "Intent":
            case "NORMAL Callback":
                if (locationRequest.getPriority() == 200 || locationRequest.getPriority() == 300 || locationRequest.getPriority() == 400) {
                    throw new ApiException(new Status(LocationStatusCode.METHOD_INVOKE_ERROR, LocationStatusCode.getStatusCodeString(LocationStatusCode.METHOD_INVOKE_ERROR)));
                }
                return;
            case "ExCallback":
                if (locationRequest.getPriority() == 200) {
                    locationRequest.setNeedAddress(false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void checkRemoveRequestParam(LocationCallback locationCallback, PendingIntent pendingIntent, String str) throws ApiException {
        int iHashCode = str.hashCode();
        if (iHashCode != -2099895620) {
            if (iHashCode == -1598699650) {
                str.equals("NORMAL Callback");
            }
        } else if (str.equals("Intent")) {
            assertNoNull(pendingIntent);
            return;
        }
        assertNoNull(locationCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void checkRequestParam(java.lang.String r2, com.huawei.hms.location.LocationRequest r3, com.huawei.hms.location.LocationCallback r4, android.os.Looper r5, android.app.PendingIntent r6) throws com.huawei.hms.common.ApiException {
        /*
            assertNoNull(r3)
            int r0 = r2.hashCode()
            r1 = -2099895620(0xffffffff82d622bc, float:-3.146441E-37)
            if (r0 == r1) goto L21
            r6 = -1598699650(0xffffffffa0b5c77e, float:-3.0794606E-19)
            if (r0 == r6) goto L1e
            r6 = 1366690360(0x51760a38, float:6.6045837E10)
            if (r0 == r6) goto L17
            goto L2d
        L17:
            java.lang.String r6 = "ExCallback"
        L19:
            boolean r2 = r2.equals(r6)
            goto L2d
        L1e:
            java.lang.String r6 = "NORMAL Callback"
            goto L19
        L21:
            java.lang.String r0 = "Intent"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L2d
            assertNoNull(r6)
            goto L33
        L2d:
            assertNoNull(r4)
            assertNoNull(r5)
        L33:
            int r2 = r3.getNumUpdates()
            r4 = 10802(0x2a32, float:1.5137E-41)
            if (r2 <= 0) goto L59
            int r2 = r3.getCoordinateType()
            if (r2 == 0) goto L58
            int r2 = r3.getCoordinateType()
            r3 = 1
            if (r2 != r3) goto L49
            goto L58
        L49:
            com.huawei.hms.common.ApiException r2 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r3 = new com.huawei.hms.support.api.client.Status
            java.lang.String r5 = com.huawei.hms.support.api.location.common.exception.LocationStatusCode.getStatusCodeString(r4)
            r3.<init>(r4, r5)
            r2.<init>(r3)
            throw r2
        L58:
            return
        L59:
            com.huawei.hms.common.ApiException r2 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r3 = new com.huawei.hms.support.api.client.Status
            java.lang.String r5 = com.huawei.hms.support.api.location.common.exception.LocationStatusCode.getStatusCodeString(r4)
            r3.<init>(r4, r5)
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.location.common.LocationRequestHelper.checkRequestParam(java.lang.String, com.huawei.hms.location.LocationRequest, com.huawei.hms.location.LocationCallback, android.os.Looper, android.app.PendingIntent):void");
    }

    private static k0 createRemoveLocationUpdatesCache(LocationCallback locationCallback, PendingIntent pendingIntent, String str, String str2) throws ApiException {
        checkRemoveRequestParam(locationCallback, pendingIntent, str);
        k0 k0Var = (k0) j0.b().b(new k0(null, pendingIntent, locationCallback, null, str2, str));
        if (k0Var != null) {
            return k0Var;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -2099895620) {
            if (iHashCode == -1598699650) {
                str.equals("NORMAL Callback");
            }
        } else if (str.equals("Intent")) {
            HMSLocationLog.e(TAG, str2, "remove location updates with intent cannot find intent");
            throw new ApiException(new Status(LocationStatusCode.NO_MATCHED_INTENT, LocationStatusCode.getStatusCodeString(LocationStatusCode.NO_MATCHED_INTENT)));
        }
        HMSLocationLog.e(TAG, str2, "remove location updates with callback cannot find callback");
        throw new ApiException(new Status(LocationStatusCode.NO_MATCHED_CALLBACK, LocationStatusCode.getStatusCodeString(LocationStatusCode.NO_MATCHED_CALLBACK)));
    }

    public static n0 createRemoveTaskApiCall(LocationCallback locationCallback, PendingIntent pendingIntent, String str, String str2, RemoveLocationUpdatesRequest removeLocationUpdatesRequest) throws ApiException {
        k0 k0VarCreateRemoveLocationUpdatesCache = createRemoveLocationUpdatesCache(locationCallback, pendingIntent, str, str2);
        String strA = k0VarCreateRemoveLocationUpdatesCache.a();
        removeLocationUpdatesRequest.setTid(strA);
        if (TextUtils.equals(str, "NORMAL Callback")) {
            removeLocationUpdatesRequest.setUuid(locationCallback.getUuid());
        }
        e1 e1Var = new e1("location.removeLocationUpdates", JsonUtil.createJsonString(removeLocationUpdatesRequest), strA, k0VarCreateRemoveLocationUpdatesCache, "");
        if (TextUtils.equals(str, "Intent")) {
            e1Var.setParcelable(pendingIntent);
        }
        HMSLocationLog.i(TAG, strA, str + " removeLocationUpdates tid =" + strA + " Version Code = 61200300");
        return e1Var;
    }

    public static n0 createRequestApiCall(String str, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper, PendingIntent pendingIntent, RequestLocationUpdatesRequest requestLocationUpdatesRequest) throws ApiException {
        checkMethodSupport(str);
        checkRequestParam(str, locationRequest, locationCallback, looper, pendingIntent);
        checkLocationPermission();
        checkPriority(str, locationRequest);
        buildRequestEntity(str, locationRequest, locationCallback, requestLocationUpdatesRequest);
        return buildTaskApiCall(str, locationCallback, looper, pendingIntent, requestLocationUpdatesRequest, new k0(locationRequest, pendingIntent, locationCallback, looper, requestLocationUpdatesRequest.getTid(), str), JsonUtil.createJsonString(requestLocationUpdatesRequest));
    }

    public static String getCpTid(LocationRequest locationRequest) {
        Map<String, String> extras;
        return (locationRequest == null || (extras = locationRequest.getExtras()) == null || extras.isEmpty()) ? "" : extras.get(CP_TRANS_ID);
    }

    private static String getOption(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        Map<String, String> extras = requestLocationUpdatesRequest.getLocationRequest().getExtras();
        String str = extras != null ? extras.get("vdrEnable") : "";
        LogLocation.i(TAG, "vdrEnable is: " + str);
        return str;
    }

    private static String getProductId() {
        try {
            return AGConnectServicesConfig.fromContext(ContextUtil.getContext()).getString("client/product_id");
        } catch (Exception unused) {
            HMSLog.e(TAG, "get agc productId by exception");
            return "";
        }
    }

    private static boolean isVdrEnable(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        String str;
        if (requestLocationUpdatesRequest.getLocationRequest().getPriority() != 200) {
            str = "do not support vdr, priority is: " + requestLocationUpdatesRequest.getLocationRequest().getPriority();
        } else {
            if (ReflectionUtils.isSupportClass("com.huawei.location.vdr.VdrManager")) {
                return TextUtils.equals(getOption(requestLocationUpdatesRequest), VDR_ENABLE);
            }
            str = "no vdr module, do not support vdr";
        }
        LogLocation.i(TAG, str);
        return false;
    }

    private static void logCurrentStatus(LocationRequest locationRequest, String str, Context context) {
        if (context == null || locationRequest == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(context == null ? "context is null, " : "context is not null, ");
            sb.append(locationRequest == null ? "request is null, " : "request is not null, ");
            HMSLocationLog.e(TAG, str, sb.toString());
            return;
        }
        HMSLocationLog.i(TAG, str, "priority: " + locationRequest.getPriority() + ", locationMode: " + LocationUtil.isLocationEnabled(context) + ", netWork available: " + NetworkUtil.isNetworkAvailable(context) + ", model is: " + Build.MODEL + ",WLANScan:" + TelephonyUtil.checkWLANScan(ContextUtil.getContext()));
    }

    public static void reportRequest(String str, int i, String str2, String str3) {
        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.setApiName(LOCATION_REQUEST_API_NAME);
        reportBuilder.setWLANScan();
        reportBuilder.setLocationEnable(LocationUtil.isLocationEnabled(ContextUtil.getContext()));
        reportBuilder.setTransactionID(str);
        reportBuilder.setPackage(ContextUtil.getContext().getPackageName());
        reportBuilder.setCpAppVersion(APKUtil.getPackageVersionName(ContextUtil.getContext().getPackageName()));
        reportBuilder.setErrorCode(i + "");
        reportBuilder.setErrorMessage(str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CP_TRANS_ID, str3);
            reportBuilder.setExt(jSONObject.toString());
        } catch (JSONException unused) {
            HMSLocationLog.i(TAG, str, "reportRequest put ext failed");
        }
        Tracker.getInstance().onMaintEvent(reportBuilder);
        Tracker.getInstance().onReport();
    }
}
