package flussonic.watcher.sdk.data.repository;

import flussonic.watcher.sdk.data.network.dto.MediaInfoDto;
import flussonic.watcher.sdk.data.network.mappers.MediaInfoDtoToMediaInfoMapper;
import flussonic.watcher.sdk.data.network.services.StreamerNetworkService;
import flussonic.watcher.sdk.domain.core.RetryFunction;
import flussonic.watcher.sdk.domain.pojo.MediaInfo;
import flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters;
import io.reactivex.Single;
import io.reactivex.functions.Function;

/* loaded from: classes3.dex */
public class MediaInfoRepository {
    private final MediaInfoDtoToMediaInfoMapper mediaInfoDtoToMediaInfoMapper = new MediaInfoDtoToMediaInfoMapper();
    private final StreamerConnectionParameters streamerConnectionParameters;
    private final StreamerNetworkService streamerNetworkService;

    public MediaInfoRepository(StreamerConnectionParameters streamerConnectionParameters, StreamerNetworkService streamerNetworkService) {
        this.streamerConnectionParameters = streamerConnectionParameters;
        this.streamerNetworkService = streamerNetworkService;
    }

    public Single<MediaInfo> mediaInfo(RetryFunction retryFunction) {
        Single<MediaInfoDto> singleMediaInfo = this.streamerNetworkService.mediaInfo(this.streamerConnectionParameters.stream(), this.streamerConnectionParameters.token());
        final MediaInfoDtoToMediaInfoMapper mediaInfoDtoToMediaInfoMapper = this.mediaInfoDtoToMediaInfoMapper;
        mediaInfoDtoToMediaInfoMapper.getClass();
        return retryFunction.wrap(singleMediaInfo.map(new Function() { // from class: flussonic.watcher.sdk.data.repository.MediaInfoRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return mediaInfoDtoToMediaInfoMapper.map((MediaInfoDtoToMediaInfoMapper) obj);
            }
        })).firstOrError();
    }
}
