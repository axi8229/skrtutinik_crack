package flussonic.watcher.sdk.data.network.dto;

import com.google.android.gms.common.Scopes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import flussonic.watcher.sdk.data.network.dto.AutoValue_TrackDto;

/* loaded from: classes3.dex */
public abstract class TrackDto {
    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)
    public abstract Integer bitrate();

    @SerializedName("codec")
    public abstract String codec();

    @SerializedName("content")
    public abstract String content();

    @SerializedName("height")
    public abstract Integer height();

    @SerializedName("level")
    public abstract String level();

    @SerializedName("pixel_height")
    public abstract Integer pixelHeight();

    @SerializedName("pixel_width")
    public abstract Integer pixelWidth();

    @SerializedName(Scopes.PROFILE)
    public abstract String profile();

    @SerializedName("sar_height")
    public abstract Integer sarHeight();

    @SerializedName("sar_width")
    public abstract Integer sarWidth();

    @SerializedName("size")
    public abstract String size();

    @SerializedName("track_id")
    public abstract String trackId();

    @SerializedName("width")
    public abstract Integer width();

    public static TypeAdapter<TrackDto> typeAdapter(Gson gson) {
        return new AutoValue_TrackDto.GsonTypeAdapter(gson);
    }
}
