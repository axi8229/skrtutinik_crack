package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import flussonic.watcher.sdk.data.network.dto.AutoValue_StreamRangeDto;

/* loaded from: classes3.dex */
public abstract class StreamRangeDto {
    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION)
    public abstract Long duration();

    @SerializedName(alternate = {"start"}, value = RemoteMessageConst.FROM)
    public abstract Long from();

    public static TypeAdapter<StreamRangeDto> typeAdapter(Gson gson) {
        return new AutoValue_StreamRangeDto.GsonTypeAdapter(gson);
    }
}
