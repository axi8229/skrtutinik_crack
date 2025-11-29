package com.huawei.location.nlp.network;

import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.location.BuildConfig;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.nlp.constant.yn;
import com.huawei.location.nlp.network.request.OnlineLocationRequest;
import com.huawei.location.nlp.network.response.OnlineLocationResponse;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class OnlineLocationService {
    private static final int FLAG_ACCURACY = 16;
    private static final int FLAG_BEARING = 8;
    private static final int FLAG_SPEED = 4;
    private static final String LOCATION_URL = "/networklocation/v1/onlineLocation";
    public static final String SRC_DEFAULT = "4";
    private static final String TAG = "OnlineLocationService";
    public static final String X_REQ_SRC = "X-Req-src";

    private boolean convertNativeLocation(Location location, OnlineLocationResponse onlineLocationResponse) {
        String str;
        com.huawei.location.nlp.network.response.Location position = onlineLocationResponse.getPosition();
        if (position == null) {
            str = "convertNativeLocation, responseLocation is null.";
        } else {
            short flags = position.getFlags();
            if (flags <= 0) {
                str = "convertNativeLocation, flag is invalid.";
            } else {
                if ((flags & 1) > 0) {
                    location.setLatitude(position.getLatitude());
                    location.setLongitude(position.getLongitude());
                    if ((flags & 4) != 0) {
                        location.setSpeed(position.getSpeed());
                    }
                    if ((flags & 8) != 0) {
                        location.setBearing(position.getBearing());
                    }
                    if ((flags & 16) != 0) {
                        location.setAccuracy(position.getAccuracy());
                    }
                    location.setTime(position.getTime() <= 0 ? System.currentTimeMillis() : position.getTime());
                    location.setProvider("network");
                    Bundle bundle = new Bundle();
                    if (!TextUtils.isEmpty(onlineLocationResponse.getSessionId())) {
                        bundle.putString("session_id", onlineLocationResponse.getSessionId());
                    }
                    bundle.putInt("vendorType", 1);
                    bundle.putString("locateType", onlineLocationResponse.getLocateType());
                    bundle.putString("buildingId", position.getBuildingId());
                    bundle.putInt("floor", position.getFloor());
                    bundle.putInt("floorAcc", position.getFloorAcc());
                    bundle.putLong(CrashHianalyticsData.TIME, position.getTime());
                    bundle.putShort("flags", position.getFlags());
                    location.setExtras(bundle);
                    return true;
                }
                str = "convertNativeLocation, lon&lat is invalid.";
            }
        }
        LogLocation.e(TAG, str);
        return false;
    }

    private OnlineLocationResponse doHttp(OnlineLocationRequest onlineLocationRequest) {
        String string;
        StringBuilder sb;
        String message;
        LogLocation.i(TAG, "doHttp, request is " + onlineLocationRequest.toString());
        OnlineLocationResponse onlineLocationResponse = new OnlineLocationResponse();
        try {
            try {
                RequestJsonBody requestJsonBodyBuild = new RequestJsonBody.Builder().build(new JSONObject(GsonUtil.getInstance().toJson(onlineLocationRequest)));
                String grsHostAddress = LocationNlpGrsHelper.getGrsHostAddress(BuildConfig.LIBRARY_PACKAGE_NAME);
                if (TextUtils.isEmpty(grsHostAddress)) {
                    LogLocation.e(TAG, "grsHostAddress is null");
                    return onlineLocationResponse;
                }
                String packageName = ContextUtil.getContext().getPackageName();
                HashMap<String, String> map = new HashMap<>();
                map.put(X_REQ_SRC, SRC_DEFAULT);
                String string2 = UUID.randomUUID().toString();
                OnlineLocationResponse onlineLocationResponse2 = (OnlineLocationResponse) new HttpClientEx().newSubmit(new BaseRequest.Builder(LOCATION_URL).setBaseUrl(grsHostAddress).setHeads(new HeadBuilder(string2).setPackageName(packageName).addAll(map)).setBody(requestJsonBodyBuild).build()).execute(OnlineLocationResponse.class);
                try {
                    onlineLocationResponse2.setSessionId(string2);
                    LogLocation.i(TAG, "doHttp, response code is " + onlineLocationResponse2.getApiCode());
                    return onlineLocationResponse2;
                } catch (OnErrorException e) {
                    onlineLocationResponse = onlineLocationResponse2;
                    e = e;
                    sb = new StringBuilder();
                    sb.append("doHttp, OnErrorException: code is ");
                    sb.append(e.getApiCode());
                    sb.append(", msg is ");
                    message = e.getApiMsg();
                    sb.append(message);
                    string = sb.toString();
                    LogLocation.e(TAG, string);
                    return onlineLocationResponse;
                } catch (OnFailureException e2) {
                    onlineLocationResponse = onlineLocationResponse2;
                    e = e2;
                    sb = new StringBuilder();
                    sb.append("doHttp, OnFailureException: code is ");
                    sb.append(e.getErrorCode());
                    sb.append(", msg is ");
                    message = e.getMessage();
                    sb.append(message);
                    string = sb.toString();
                    LogLocation.e(TAG, string);
                    return onlineLocationResponse;
                } catch (Exception unused) {
                    onlineLocationResponse = onlineLocationResponse2;
                    string = "unknown exception";
                    LogLocation.e(TAG, string);
                    return onlineLocationResponse;
                }
            } catch (OnErrorException e3) {
                e = e3;
            } catch (OnFailureException e4) {
                e = e4;
            } catch (Exception unused2) {
            }
        } catch (JSONException unused3) {
            LogLocation.e(TAG, "doHttp, transfer to JSONException failed");
            return onlineLocationResponse;
        }
    }

    public HwLocationResult getLocationFromCloud(OnlineLocationRequest onlineLocationRequest) {
        onlineLocationRequest.setBoottime(SystemClock.elapsedRealtimeNanos() / 1000);
        OnlineLocationResponse onlineLocationResponseDoHttp = doHttp(onlineLocationRequest);
        HwLocationResult hwLocationResult = new HwLocationResult();
        Location location = new Location("network");
        if (!onlineLocationResponseDoHttp.isSuccess()) {
            LogLocation.e(TAG, "getLocationFromCloud, response is failed");
            hwLocationResult.setCode(11000);
            hwLocationResult.setMessage(yn.yn(11000));
            return hwLocationResult;
        }
        if (!convertNativeLocation(location, onlineLocationResponseDoHttp)) {
            hwLocationResult.setCode(11000);
            hwLocationResult.setMessage(yn.yn(11000));
            return hwLocationResult;
        }
        if (onlineLocationResponseDoHttp.getIndoor() == 0) {
            String locateType = onlineLocationResponseDoHttp.getLocateType();
            if ("wifi".equalsIgnoreCase(locateType)) {
                location.setElapsedRealtimeNanos(com.huawei.location.nlp.logic.yn.dC().d2());
            }
            if ("cell".equalsIgnoreCase(locateType)) {
                location.setElapsedRealtimeNanos(com.huawei.location.nlp.logic.yn.dC().LW());
            }
        }
        hwLocationResult.setCode(0);
        hwLocationResult.setMessage(yn.yn(0));
        hwLocationResult.setLocation(location);
        return hwLocationResult;
    }
}
