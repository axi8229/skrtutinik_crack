package flussonic.watcher.sdk.data.repository;

import flussonic.watcher.sdk.data.network.mappers.CameraDtoToCameraMapper;
import flussonic.watcher.sdk.data.network.mappers.StreamTimelineEventsToRangesMapper;
import flussonic.watcher.sdk.data.network.services.WatcherNetworkService;
import flussonic.watcher.sdk.domain.core.RetryFunction;
import flussonic.watcher.sdk.domain.exceptions.EmptyStreamException;
import flussonic.watcher.sdk.domain.pojo.Camera;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class WatcherRepository {
    private final WatcherConnectionParameters connectionParameters;
    private final WatcherNetworkService watcherNetworkService;
    private final CameraDtoToCameraMapper cameraDtoToCameraMapper = new CameraDtoToCameraMapper();
    private final StreamTimelineEventsToRangesMapper streamTimelineEventsToRangesMapper = new StreamTimelineEventsToRangesMapper();

    public WatcherRepository(WatcherConnectionParameters connectionParameters, WatcherNetworkService watcherNetworkService) {
        this.connectionParameters = connectionParameters;
        this.watcherNetworkService = watcherNetworkService;
    }

    public Single<Camera> findCamera(RetryFunction retryFunction) {
        Single singleOnErrorResumeNext = retryFunction.wrap(this.watcherNetworkService.findCamera(this.connectionParameters.token(), this.connectionParameters.stream())).flatMap(new WatcherRepository$$ExternalSyntheticLambda0()).firstOrError().onErrorResumeNext(Single.error(new EmptyStreamException()));
        final CameraDtoToCameraMapper cameraDtoToCameraMapper = this.cameraDtoToCameraMapper;
        cameraDtoToCameraMapper.getClass();
        return singleOnErrorResumeNext.map(new Function() { // from class: flussonic.watcher.sdk.data.repository.WatcherRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return cameraDtoToCameraMapper.map((CameraDtoToCameraMapper) obj);
            }
        });
    }

    public Single<List<Range>> timelineEvents(Range range, RetryFunction retryFunction) {
        Single singleFirstOrError = retryFunction.wrap(this.watcherNetworkService.timelineEvents(this.connectionParameters.token(), this.connectionParameters.stream(), range.from(), range.to())).firstOrError();
        final StreamTimelineEventsToRangesMapper streamTimelineEventsToRangesMapper = this.streamTimelineEventsToRangesMapper;
        streamTimelineEventsToRangesMapper.getClass();
        return singleFirstOrError.map(new Function() { // from class: flussonic.watcher.sdk.data.repository.WatcherRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return streamTimelineEventsToRangesMapper.map((List) obj);
            }
        }).onErrorReturn(new Function() { // from class: flussonic.watcher.sdk.data.repository.WatcherRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return WatcherRepository.lambda$timelineEvents$0((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$timelineEvents$0(Throwable throwable) throws Exception {
        return Collections.emptyList();
    }
}
