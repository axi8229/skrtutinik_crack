package flussonic.watcher.sdk.data.network.mappers;

import android.text.TextUtils;
import flussonic.watcher.sdk.data.network.dto.StreamRangesDto;
import flussonic.watcher.sdk.domain.mappers.Mapper;
import flussonic.watcher.sdk.domain.pojo.RangesResponse;
import java.util.List;

/* loaded from: classes3.dex */
public class StreamRangesDtoToRangesMapper implements Mapper<StreamRangesDto, RangesResponse> {
    private final EventDtoToRangeMapper eventDtoToRangeMapper;
    private final StreamRangeDtoToRangeMapper streamRangeDtoToRangeMapper;

    public StreamRangesDtoToRangesMapper() {
        StreamRangeDtoToRangeMapper streamRangeDtoToRangeMapper = new StreamRangeDtoToRangeMapper();
        this.streamRangeDtoToRangeMapper = streamRangeDtoToRangeMapper;
        this.eventDtoToRangeMapper = new EventDtoToRangeMapper(streamRangeDtoToRangeMapper);
    }

    @Override // flussonic.watcher.sdk.domain.mappers.Mapper
    public RangesResponse create(StreamRangesDto dto) {
        return RangesResponse.createSucceeded(TextUtils.equals(dto.warning(), "too_big_range"), this.streamRangeDtoToRangeMapper.map((List) dto.ranges()), this.eventDtoToRangeMapper.map((List) dto.events()));
    }
}
