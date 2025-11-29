package flussonic.watcher.sdk.data.network.mappers;

import flussonic.watcher.sdk.data.network.dto.MediaInfoDto;
import flussonic.watcher.sdk.data.network.dto.TrackDto;
import flussonic.watcher.sdk.domain.mappers.Mapper;
import flussonic.watcher.sdk.domain.pojo.MediaInfo;
import flussonic.watcher.sdk.domain.pojo.Track;
import flussonic.watcher.sdk.domain.utils.NonNullUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class MediaInfoDtoToMediaInfoMapper implements Mapper<MediaInfoDto, MediaInfo> {
    private final Mapper<TrackDto, Track> streamDtoStreamMapper = new TrackDtoToTrack();

    @Override // flussonic.watcher.sdk.domain.mappers.Mapper
    public MediaInfo create(MediaInfoDto mediaInfoDto) {
        List<TrackDto> listStreams = mediaInfoDto.streams();
        List<TrackDto> listTracks = mediaInfoDto.tracks();
        ArrayList arrayList = new ArrayList();
        if (listStreams == null || listStreams.isEmpty()) {
            listStreams = (listTracks == null || listTracks.isEmpty()) ? arrayList : listTracks;
        }
        ArrayList arrayList2 = new ArrayList(this.streamDtoStreamMapper.map(listStreams));
        Collections.sort(arrayList2, new Comparator() { // from class: flussonic.watcher.sdk.data.network.mappers.MediaInfoDtoToMediaInfoMapper$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaInfoDtoToMediaInfoMapper.lambda$create$0((Track) obj, (Track) obj2);
            }
        });
        return MediaInfo.create(NonNullUtils.intValue(mediaInfoDto.width()), NonNullUtils.intValue(mediaInfoDto.height()), Collections.unmodifiableList(arrayList2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$create$0(Track o1, Track o2) {
        return o2.bitrate() - o1.bitrate();
    }
}
