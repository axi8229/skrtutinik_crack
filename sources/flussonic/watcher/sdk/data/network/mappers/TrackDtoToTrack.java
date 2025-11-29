package flussonic.watcher.sdk.data.network.mappers;

import flussonic.watcher.sdk.data.network.dto.TrackDto;
import flussonic.watcher.sdk.domain.mappers.Mapper;
import flussonic.watcher.sdk.domain.pojo.Track;
import flussonic.watcher.sdk.domain.utils.NonNullUtils;

/* loaded from: classes3.dex */
public class TrackDtoToTrack implements Mapper<TrackDto, Track> {
    @Override // flussonic.watcher.sdk.domain.mappers.Mapper
    public Track create(TrackDto trackDto) {
        return Track.builder().setBitrate(NonNullUtils.intValue(trackDto.bitrate())).setCodec(NonNullUtils.stringValue(trackDto.codec())).setContent(NonNullUtils.stringValue(trackDto.content())).setHeight(NonNullUtils.intValue(trackDto.height())).setLevel(NonNullUtils.stringValue(trackDto.level())).setPixelHeight(NonNullUtils.intValue(trackDto.pixelHeight())).setPixelWidth(NonNullUtils.intValue(trackDto.pixelWidth())).setProfile(NonNullUtils.stringValue(trackDto.profile())).setSarHeight(NonNullUtils.intValue(trackDto.sarHeight())).setSarWidth(NonNullUtils.intValue(trackDto.sarWidth())).setSize(NonNullUtils.stringValue(trackDto.size())).setTrackId(NonNullUtils.stringValue(trackDto.trackId())).setWidth(NonNullUtils.intValue(trackDto.width())).build();
    }
}
