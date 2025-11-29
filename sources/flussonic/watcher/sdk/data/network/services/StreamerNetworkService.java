package flussonic.watcher.sdk.data.network.services;

import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.watcher.sdk.data.network.dto.MediaInfoDto;
import flussonic.watcher.sdk.data.network.dto.StreamAvailableRangeDto;
import flussonic.watcher.sdk.data.network.dto.StreamRangesDto;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface StreamerNetworkService {
    @GET("{stream}/media_info.json")
    Single<MediaInfoDto> mediaInfo(@Path("stream") String stream, @Query("token") String token);

    @GET("{stream}/recording_status.json")
    Single<Map<String, StreamAvailableRangeDto>> recordingStatus(@Path("stream") String stream, @Query("token") String token);

    @GET("{stream}/recording_status.json?request=motion_log,ranges")
    Single<List<StreamRangesDto>> recordingStatusInRange(@Path("stream") String stream, @Query("token") String token, @Query(RemoteMessageConst.FROM) long from, @Query(RemoteMessageConst.TO) long to);
}
