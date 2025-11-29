package flussonic.watcher.sdk.data.repository;

import android.text.TextUtils;
import flussonic.watcher.sdk.data.network.dto.StreamAvailableRangeDto;
import flussonic.watcher.sdk.data.network.dto.StreamRangesDto;
import flussonic.watcher.sdk.data.network.mappers.StreamAvailableRangeDtoToRangeMapper;
import flussonic.watcher.sdk.data.network.mappers.StreamRangesDtoToRangesMapper;
import flussonic.watcher.sdk.data.network.mappers.StreamTimelineEventsToRangesMapper;
import flussonic.watcher.sdk.data.network.services.StreamerNetworkService;
import flussonic.watcher.sdk.domain.core.RetryFunction;
import flussonic.watcher.sdk.domain.exceptions.EmptyStreamException;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.pojo.RangesResponse;
import flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class RecordingStatusRepository {
    private final StreamerConnectionParameters connectionParameters;
    private final StreamAvailableRangeDtoToRangeMapper streamAvailableRangeDtoToRangeMapper = new StreamAvailableRangeDtoToRangeMapper();
    private final StreamRangesDtoToRangesMapper streamRangesDtoToRangesMapper = new StreamRangesDtoToRangesMapper();
    private final StreamTimelineEventsToRangesMapper streamTimelineEventsToRangesMapper = new StreamTimelineEventsToRangesMapper();
    private final StreamerNetworkService streamerNetworkService;

    public RecordingStatusRepository(StreamerConnectionParameters connectionParameters, StreamerNetworkService streamerNetworkService) {
        this.connectionParameters = connectionParameters;
        this.streamerNetworkService = streamerNetworkService;
    }

    public Single<Range> availableRange(RetryFunction retryFunction) {
        Single map = retryFunction.wrap(this.streamerNetworkService.recordingStatus(this.connectionParameters.stream(), this.connectionParameters.token())).firstOrError().map(new Function() { // from class: flussonic.watcher.sdk.data.repository.RecordingStatusRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.extractRange((Map) obj);
            }
        });
        final StreamAvailableRangeDtoToRangeMapper streamAvailableRangeDtoToRangeMapper = this.streamAvailableRangeDtoToRangeMapper;
        streamAvailableRangeDtoToRangeMapper.getClass();
        return map.map(new Function() { // from class: flussonic.watcher.sdk.data.repository.RecordingStatusRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return streamAvailableRangeDtoToRangeMapper.map((StreamAvailableRangeDtoToRangeMapper) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StreamAvailableRangeDto extractRange(Map<String, StreamAvailableRangeDto> map) {
        StreamAvailableRangeDto streamAvailableRangeDto = map.get(this.connectionParameters.stream());
        if (!this.connectionParameters.permissionDvr() || streamAvailableRangeDto == null || (streamAvailableRangeDto.from() == null && streamAvailableRangeDto.to() == null)) {
            throw new EmptyStreamException();
        }
        return streamAvailableRangeDto;
    }

    public Single<RangesResponse> ranges(Range range, RetryFunction retryFunction) {
        Single singleFlatMap = retryFunction.wrap(this.streamerNetworkService.recordingStatusInRange(this.connectionParameters.stream(), this.connectionParameters.token(), range.from(), range.to())).firstOrError().flatMap(new Function() { // from class: flussonic.watcher.sdk.data.repository.RecordingStatusRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$ranges$1((List) obj);
            }
        });
        final StreamRangesDtoToRangesMapper streamRangesDtoToRangesMapper = this.streamRangesDtoToRangesMapper;
        streamRangesDtoToRangesMapper.getClass();
        return singleFlatMap.map(new Function() { // from class: flussonic.watcher.sdk.data.repository.RecordingStatusRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return streamRangesDtoToRangesMapper.map((StreamRangesDtoToRangesMapper) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$ranges$1(List list) throws Exception {
        return Observable.fromIterable(list).filter(new Predicate() { // from class: flussonic.watcher.sdk.data.repository.RecordingStatusRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$null$0((StreamRangesDto) obj);
            }
        }).firstOrError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$null$0(StreamRangesDto dto) throws Exception {
        return TextUtils.equals(dto.stream(), this.connectionParameters.stream());
    }
}
