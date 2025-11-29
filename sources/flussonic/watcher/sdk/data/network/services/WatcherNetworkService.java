package flussonic.watcher.sdk.data.network.services;

import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.watcher.sdk.data.network.dto.CameraDto;
import flussonic.watcher.sdk.data.network.dto.EventDto;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface WatcherNetworkService {
    @Headers({"Content-Type: application/json"})
    @GET("cameras")
    Single<List<CameraDto>> findCamera(@Header("X-Vsaas-Session") String token, @Query("search") String stream);

    @Headers({"Content-Type: application/json"})
    @GET("cameras/{cameraName}/timeline-events")
    Single<List<EventDto>> timelineEvents(@Header("X-Vsaas-Session") String session, @Path("cameraName") String stream, @Query(RemoteMessageConst.FROM) long from, @Query(RemoteMessageConst.TO) long to);
}
