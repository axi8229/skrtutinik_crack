package com.huawei.hms.locationSdk;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.log.logwrite.LogWriteApi;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.coordinateconverter.CoordinateUtil;
import com.huawei.location.lite.common.util.coordinateconverter.LatLon;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class j1 extends n0<s, Void> {
    protected k0 b;
    private Location c;
    protected Handler d;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j1.this.a(message);
        }
    }

    public j1(String str, String str2, String str3, k0 k0Var, Looper looper, String str4) throws ApiException {
        super(str, str2, str3, str4);
        this.b = k0Var;
        if (looper == null) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
        a aVar = new a(looper);
        this.d = aVar;
        aVar.sendEmptyMessageDelayed(3, DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
    }

    private void a(s sVar, JSONObject jSONObject) throws ApiException, JSONException, IllegalArgumentException {
        HMSLocationLog.i(a(), ((n0) this).a, "doExecute onLocationResult");
        LocationResult locationResultFromJsonObject = LocationJsonUtil.parseLocationResultFromJsonObject(jSONObject);
        int iG = this.b.g();
        int size = locationResultFromJsonObject.getLocations().size();
        HMSLocationLog.i(a(), ((n0) this).a, "modify numUpdates with callback, numUpdates:" + iG + " , locationSize:" + size);
        d(locationResultFromJsonObject);
        if (iG <= 0 || iG < size) {
            b.b(sVar.getContext(), (w) null).a(this.b.c());
            return;
        }
        if (iG == size) {
            b.b(sVar.getContext(), (w) null).a(this.b.c());
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = locationResultFromJsonObject;
        this.d.sendMessage(messageObtain);
        if (l0.b()) {
            LogWriteApi.printLocationInfo(l0.a(((n0) this).a, locationResultFromJsonObject), l0.b());
        }
        int i = iG - size;
        this.b.a(i);
        j0.b().a(this.b, i);
    }

    private void a(String str) throws JSONException {
        LocationAvailability locationAvailabilityFromString = LocationJsonUtil.parseLocationAvailabilityFromString(str);
        HMSLocationLog.i(a(), ((n0) this).a, "doExecute onLocationAvailability");
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.obj = locationAvailabilityFromString;
        this.d.sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(LocationResult locationResult) {
        x.b().b(locationResult.getLastHWLocation());
    }

    private void d(LocationResult locationResult) {
        HWLocation lastHWLocation;
        Location lastLocation;
        Map<String, Object> extraInfo;
        if (locationResult == null || (lastHWLocation = locationResult.getLastHWLocation()) == null || (lastLocation = locationResult.getLastLocation()) == null || (extraInfo = lastHWLocation.getExtraInfo()) == null) {
            return;
        }
        Location location = this.c;
        float fDistanceTo = location != null ? lastLocation.distanceTo(location) : -1.0f;
        String strA = a();
        String str = ((n0) this).a;
        StringBuilder sb = new StringBuilder();
        sb.append("log location info, SourceType: ");
        sb.append(extraInfo.containsKey("SourceType") ? extraInfo.get("SourceType") : -1);
        sb.append(", provider: ");
        sb.append(lastHWLocation.getProvider());
        sb.append(", acc: ");
        sb.append(lastHWLocation.getAccuracy());
        sb.append(", bearing: ");
        sb.append(lastHWLocation.getBearing());
        sb.append(", speed: ");
        sb.append(lastHWLocation.getSpeed());
        sb.append(", positionType: ");
        sb.append(extraInfo.containsKey("positionType") ? extraInfo.get("positionType") : -1);
        sb.append(", tripId: ");
        sb.append(extraInfo.containsKey("tripId") ? extraInfo.get("tripId") : "");
        sb.append(", requestId: ");
        sb.append(extraInfo.containsKey("session_id") ? extraInfo.get("session_id") : "");
        sb.append(", vendorType: ");
        sb.append(extraInfo.containsKey("vendorType") ? extraInfo.get("vendorType") : "");
        sb.append(",distanceToPrev:");
        sb.append(fDistanceTo);
        HMSLocationLog.i(strA, str, sb.toString());
        this.c = lastLocation;
    }

    protected String a() {
        return "RequestLocationUpdatesTaskApiCall";
    }

    protected void a(Message message) {
        HMSLocationLog.i(a(), ((n0) this).a, "handleOnResultMessage code:" + message.what);
        try {
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                if (obj instanceof LocationResult) {
                    b((LocationResult) obj);
                }
            } else if (i == 2) {
                Object obj2 = message.obj;
                if (obj2 instanceof LocationAvailability) {
                    LocationAvailability locationAvailability = (LocationAvailability) obj2;
                    HMSLocationLog.i(a(), ((n0) this).a, "getLocationStatus:" + locationAvailability.getLocationStatus());
                    this.b.c().onLocationAvailability(locationAvailability);
                }
            } else if (i == 3) {
                LocationRequestHelper.reportRequest(((n0) this).a, 10811, "REQUEST_GET_RESULT_TIME_OUT", LocationRequestHelper.getCpTid(this.b.d()));
            }
        } catch (Exception e) {
            HMSLocationLog.e(a(), ((n0) this).a, "handleOnResultMessage exception:" + e.getCause());
        }
    }

    protected void a(LocationResult locationResult) {
        String strA;
        String str;
        String str2;
        String strA2;
        String str3;
        String str4;
        if (locationResult == null) {
            strA2 = a();
            str3 = ((n0) this).a;
            str4 = "locationResult is null";
        } else {
            LocationRequest locationRequestD = this.b.d();
            if (locationRequestD == null) {
                strA2 = a();
                str3 = ((n0) this).a;
                str4 = "locationRequest is null";
            } else {
                List<HWLocation> hWLocationList = locationResult.getHWLocationList();
                if (!hWLocationList.isEmpty()) {
                    if (1 != locationRequestD.getCoordinateType()) {
                        if (locationRequestD.getCoordinateType() == 0) {
                            LogLocation.d(a(), "ConvertCoord-- current coordinateType is 0 --no conversion");
                            return;
                        } else {
                            HMSLocationLog.i(a(), ((n0) this).a, "ConvertCoord-- current coordinateType is unKnown --return 84");
                            return;
                        }
                    }
                    try {
                        for (HWLocation hWLocation : hWLocationList) {
                            Map<String, Object> extraInfo = hWLocation.getExtraInfo();
                            if (extraInfo != null && extraInfo.containsKey("SourceType") && a(((Integer) extraInfo.get("SourceType")).intValue())) {
                                HMSLocationLog.i(a(), ((n0) this).a, "RTK position, no conversion required");
                            } else {
                                LatLon latLonConvertCoord = CoordinateUtil.convertCoord(hWLocation.getLatitude(), hWLocation.getLongitude(), 1);
                                if (latLonConvertCoord != null) {
                                    hWLocation.setCoordinateType(1);
                                    hWLocation.setLatitude(latLonConvertCoord.getLatitude());
                                    hWLocation.setLongitude(latLonConvertCoord.getLongitude());
                                } else {
                                    hWLocation.setCoordinateType(0);
                                    HMSLocationLog.e(a(), ((n0) this).a, "ConvertCoord-- result is null,reset the coordinateType to 0");
                                }
                            }
                        }
                        return;
                    } catch (ClassCastException unused) {
                        strA = a();
                        str = ((n0) this).a;
                        str2 = "convertCoord ClassCastException:";
                        HMSLocationLog.e(strA, str, str2);
                        return;
                    } catch (Exception unused2) {
                        strA = a();
                        str = ((n0) this).a;
                        str2 = "convertCoord Exception";
                        HMSLocationLog.e(strA, str, str2);
                        return;
                    }
                }
                strA2 = a();
                str3 = ((n0) this).a;
                str4 = "hwLocationList is empty";
            }
        }
        HMSLocationLog.e(strA2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) throws ApiException {
        ApiException e;
        HMSLocationLog.i(a(), ((n0) this).a, "doExecute");
        try {
            a(true);
            if (responseErrorCode == null) {
                j0.b().c(this.b);
                LocationRequestHelper.reportRequest(((n0) this).a, 10000, LocationStatusCode.getStatusCodeString(10000), LocationRequestHelper.getCpTid(this.b.d()));
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getStatusCode() == 0 && responseErrorCode.getErrorCode() == 0) {
                JSONObject jSONObject = new JSONObject(str);
                k0 k0Var = this.b;
                if (k0Var != null && k0Var.d() != null && this.b.c() != null) {
                    if (jSONObject.has("locationResult")) {
                        a(sVar, jSONObject);
                        return;
                    } else if (jSONObject.has("locationAvailability")) {
                        a(str);
                        return;
                    } else {
                        j0.b().d(this.b);
                        LocationRequestHelper.reportRequest(((n0) this).a, responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), LocationRequestHelper.getCpTid(this.b.d()));
                        b(true);
                    }
                }
                LocationRequestHelper.reportRequest(((n0) this).a, 10000, LocationStatusCode.getStatusCodeString(10000), LocationRequestHelper.getCpTid(this.b.d()));
                HMSLocationLog.e(a(), ((n0) this).a, "INTERNAL_ERROR : doExecute requestLocationUpdatesCache is null");
                return;
            }
            j0.b().c(this.b);
            LocationRequestHelper.reportRequest(((n0) this).a, responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), LocationRequestHelper.getCpTid(this.b.d()));
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
        } catch (ApiException e2) {
            e = e2;
            j0.b().c(this.b);
            LocationRequestHelper.reportRequest(((n0) this).a, e.getStatusCode(), e.getStatusMessage(), LocationRequestHelper.getCpTid(this.b.d()));
            b(false);
            HMSLocationLog.e(a(), ((n0) this).a, "request location doExecute exception:" + e.getMessage());
            taskCompletionSource.setException(e);
        } catch (Exception unused) {
            j0.b().c(this.b);
            LocationRequestHelper.reportRequest(((n0) this).a, 10000, LocationStatusCode.getStatusCodeString(10000), LocationRequestHelper.getCpTid(this.b.d()));
            b(false);
            HMSLocationLog.e(a(), ((n0) this).a, "request location doExecute exception");
            e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            taskCompletionSource.setException(e);
        }
    }

    @Override // com.huawei.hms.locationSdk.n0
    public void a(boolean z) {
        super.a(z);
        this.d.removeMessages(3);
    }

    protected void b(final LocationResult locationResult) {
        if (locationResult == null || locationResult.getLastHWLocation() == null) {
            HMSLocationLog.e(a(), ((n0) this).a, "locationResult is null or locationResult.getLastHWLocation is null");
            return;
        }
        ExecutorUtil.getInstance().execute(new Runnable() { // from class: com.huawei.hms.locationSdk.j1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                j1.c(locationResult);
            }
        });
        a(locationResult);
        this.b.c().onLocationResult(locationResult);
    }

    protected void b(boolean z) {
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40000000;
    }
}
