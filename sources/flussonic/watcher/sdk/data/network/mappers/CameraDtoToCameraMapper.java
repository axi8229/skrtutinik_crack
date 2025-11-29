package flussonic.watcher.sdk.data.network.mappers;

import android.text.TextUtils;
import flussonic.watcher.sdk.data.network.dto.CameraDto;
import flussonic.watcher.sdk.data.network.dto.PermissionsDto;
import flussonic.watcher.sdk.data.network.dto.PlaybackConfigDto;
import flussonic.watcher.sdk.data.network.dto.StreamStatusDto;
import flussonic.watcher.sdk.domain.mappers.Mapper;
import flussonic.watcher.sdk.domain.pojo.Camera;
import flussonic.watcher.sdk.domain.utils.NonNullUtils;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class CameraDtoToCameraMapper implements Mapper<CameraDto, Camera> {
    @Override // flussonic.watcher.sdk.domain.mappers.Mapper
    public Camera create(CameraDto cameraDto) {
        StreamStatusDto streamStatusDtoStreamStatus = cameraDto.streamStatus();
        PlaybackConfigDto playbackConfigDtoPlaybackConfig = cameraDto.playbackConfig();
        PermissionsDto permissionsDtoPermissions = cameraDto.permissions();
        return Camera.builder().setTitle(cameraDto.title()).setIsAlive(NonNullUtils.booleanValue(streamStatusDtoStreamStatus == null ? null : streamStatusDtoStreamStatus.isAlive())).setRtmpPort(NonNullUtils.intValue(streamStatusDtoStreamStatus == null ? null : streamStatusDtoStreamStatus.rtmpPort())).setHttpPort(NonNullUtils.intValue(streamStatusDtoStreamStatus == null ? null : streamStatusDtoStreamStatus.httpPort())).setHttpsPort(NonNullUtils.intValue(streamStatusDtoStreamStatus == null ? null : streamStatusDtoStreamStatus.httpsPort())).setServer((streamStatusDtoStreamStatus == null || streamStatusDtoStreamStatus.server() == null) ? "null" : streamStatusDtoStreamStatus.server()).setName(cameraDto.name()).setToken(playbackConfigDtoPlaybackConfig == null ? null : playbackConfigDtoPlaybackConfig.token()).setPermissionDvr(NonNullUtils.booleanValue(permissionsDtoPermissions != null ? permissionsDtoPermissions.isDvr() : null)).setHasAnError(hasAnError(streamStatusDtoStreamStatus, playbackConfigDtoPlaybackConfig, cameraDto.name())).build();
    }

    private boolean hasAnError(StreamStatusDto streamStatus, PlaybackConfigDto playbackConfigDto, String name) {
        if (streamStatus == null || playbackConfigDto == null) {
            return true;
        }
        boolean z = streamStatus.server() == null || TextUtils.isEmpty(streamStatus.server());
        if (z) {
            Timber.e("Server is null on camera %s %s", name, streamStatus);
        }
        return streamStatus.sourceError() != null || streamStatus.bitrate() == null || z || !NonNullUtils.booleanValue(streamStatus.isAlive()) || TextUtils.isEmpty(playbackConfigDto.token()) || TextUtils.isEmpty(name);
    }
}
