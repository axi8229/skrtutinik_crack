package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import flussonic.watcher.sdk.data.network.dto.AutoValue_StreamStatusDto;

/* loaded from: classes3.dex */
public abstract class StreamStatusDto {
    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)
    public abstract Integer bitrate();

    @SerializedName("http_port")
    public abstract Integer httpPort();

    @SerializedName("https_port")
    public abstract Integer httpsPort();

    @SerializedName("alive")
    public abstract Boolean isAlive();

    @SerializedName("lifetime")
    public abstract Long lifetime();

    @SerializedName("rtmp_port")
    public abstract Integer rtmpPort();

    @SerializedName("rtsp_port")
    public abstract Integer rtspPort();

    @SerializedName("server")
    public abstract String server();

    @SerializedName("source_error")
    public abstract Object sourceError();

    public static TypeAdapter<StreamStatusDto> typeAdapter(Gson gson) {
        return new AutoValue_StreamStatusDto.GsonTypeAdapter(gson);
    }
}
