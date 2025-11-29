package flussonic.watcher.sdk.data.network.mappers;

import flussonic.watcher.sdk.data.network.dto.EventDto;
import flussonic.watcher.sdk.domain.mappers.Mapper;
import flussonic.watcher.sdk.domain.pojo.Range;

/* loaded from: classes3.dex */
class EventDtoToRangeMapper implements Mapper<EventDto, Range> {
    private final StreamRangeDtoToRangeMapper streamRangeDtoToRangeMapper;

    EventDtoToRangeMapper(StreamRangeDtoToRangeMapper streamRangeDtoToRangeMapper) {
        this.streamRangeDtoToRangeMapper = streamRangeDtoToRangeMapper;
    }

    @Override // flussonic.watcher.sdk.domain.mappers.Mapper
    public Range create(EventDto eventDto) {
        return this.streamRangeDtoToRangeMapper.map((StreamRangeDtoToRangeMapper) eventDto.range());
    }
}
