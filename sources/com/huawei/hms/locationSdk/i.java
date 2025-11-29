package com.huawei.hms.locationSdk;

import android.location.Location;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.LocationSceneRequest;
import com.huawei.hms.location.LocationSceneResponse;
import com.huawei.hms.location.NavigationRequest;
import com.huawei.hms.location.NavigationResult;
import com.huawei.hms.location.RoadData;
import com.huawei.hms.location.RoadDataResult;
import com.huawei.hms.support.api.entity.location.stationrecognition.CityStationLineResponse;
import com.huawei.hms.support.api.entity.location.stationrecognition.HistoryStationInfoResponse;

/* loaded from: classes3.dex */
public interface i {
    Task<Void> a(Location location, String str);

    Task<LocationSceneResponse> a(LocationSceneRequest locationSceneRequest);

    Task<NavigationResult> a(NavigationRequest navigationRequest);

    Task<RoadDataResult> a(RoadData roadData);

    Task<HistoryStationInfoResponse> a(String str);

    Task<CityStationLineResponse> a(String str, String str2);

    Task<LocationSceneResponse> b(LocationSceneRequest locationSceneRequest);

    Task<Void> b(String str);
}
