package flussonic.watcher.sdk.data.network.mappers;

import flussonic.watcher.sdk.data.network.dto.EventDto;
import flussonic.watcher.sdk.domain.mappers.Mapper;
import flussonic.watcher.sdk.domain.pojo.Range;

/* loaded from: classes3.dex */
public class StreamTimelineEventsToRangesMapper implements Mapper<EventDto, Range> {
    private final EventDtoToRangeMapper eventDtoToRangeMapper;
    private final StreamRangeDtoToRangeMapper streamRangeDtoToRangeMapper;

    public StreamTimelineEventsToRangesMapper() {
        StreamRangeDtoToRangeMapper streamRangeDtoToRangeMapper = new StreamRangeDtoToRangeMapper();
        this.streamRangeDtoToRangeMapper = streamRangeDtoToRangeMapper;
        this.eventDtoToRangeMapper = new EventDtoToRangeMapper(streamRangeDtoToRangeMapper);
    }

    @Override // flussonic.watcher.sdk.domain.mappers.Mapper
    public Range create(EventDto eventDtos) {
        return this.eventDtoToRangeMapper.map((EventDtoToRangeMapper) eventDtos);
    }
}
