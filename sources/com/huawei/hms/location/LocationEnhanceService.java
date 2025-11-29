package com.huawei.hms.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.b;
import com.huawei.hms.locationSdk.i;
import com.huawei.hms.locationSdk.w;
import com.huawei.hms.support.api.entity.location.stationrecognition.CityStationLineResponse;
import com.huawei.hms.support.api.entity.location.stationrecognition.HistoryStationInfoResponse;

/* loaded from: classes3.dex */
public class LocationEnhanceService {
    private static final String TAG = "LocationEnhanceService";
    private i locationEnhanceClient;

    public LocationEnhanceService(Activity activity) {
        this.locationEnhanceClient = b.c(activity, (w) null);
    }

    public LocationEnhanceService(Context context) {
        this.locationEnhanceClient = b.c(context, (w) null);
    }

    private Task<Void> reportLocation(Location location, String str) {
        return this.locationEnhanceClient.a(location, str);
    }

    public Task<HistoryStationInfoResponse> getHistoryStationInfo(String str) {
        return this.locationEnhanceClient.a(str);
    }

    public Task<LocationSceneResponse> getLocationSceneResponse(LocationSceneRequest locationSceneRequest) {
        return this.locationEnhanceClient.a(locationSceneRequest);
    }

    public Task<NavigationResult> getNavigationState(NavigationRequest navigationRequest) {
        return this.locationEnhanceClient.a(navigationRequest);
    }

    public Task<CityStationLineResponse> getStationLines(String str, String str2) {
        return this.locationEnhanceClient.a(str, str2);
    }

    public Task<Void> requestStationRecognition(String str) {
        return this.locationEnhanceClient.b(str);
    }

    public Task<LocationSceneResponse> setLocationSceneMode(LocationSceneRequest locationSceneRequest) {
        return this.locationEnhanceClient.b(locationSceneRequest);
    }

    public Task<RoadDataResult> setRoadData(RoadData roadData) {
        return this.locationEnhanceClient.a(roadData);
    }
}
