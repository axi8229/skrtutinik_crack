package flussonic.watcher.sdk.data.network.mappers;

import flussonic.watcher.sdk.data.network.dto.StreamAvailableRangeDto;
import flussonic.watcher.sdk.domain.mappers.Mapper;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.utils.NonNullUtils;

/* loaded from: classes3.dex */
public class StreamAvailableRangeDtoToRangeMapper implements Mapper<StreamAvailableRangeDto, Range> {
    @Override // flussonic.watcher.sdk.domain.mappers.Mapper
    public Range create(StreamAvailableRangeDto streamAvailableRangeDto) {
        return Range.createFromTo(NonNullUtils.longValue(streamAvailableRangeDto.from()), NonNullUtils.longValue(streamAvailableRangeDto.to()));
    }
}
