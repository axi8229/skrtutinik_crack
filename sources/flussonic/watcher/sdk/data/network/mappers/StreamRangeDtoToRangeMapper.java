package flussonic.watcher.sdk.data.network.mappers;

import flussonic.watcher.sdk.data.network.dto.StreamRangeDto;
import flussonic.watcher.sdk.domain.mappers.Mapper;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.utils.NonNullUtils;

/* loaded from: classes3.dex */
public class StreamRangeDtoToRangeMapper implements Mapper<StreamRangeDto, Range> {
    @Override // flussonic.watcher.sdk.domain.mappers.Mapper
    public Range create(StreamRangeDto streamRangeDto) {
        long jLongValue = NonNullUtils.longValue(streamRangeDto.from());
        return Range.createFromTo(jLongValue, NonNullUtils.longValue(streamRangeDto.duration()) + jLongValue);
    }
}
