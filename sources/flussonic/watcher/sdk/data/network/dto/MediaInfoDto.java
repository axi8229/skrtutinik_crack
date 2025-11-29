package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import flussonic.watcher.sdk.data.network.dto.AutoValue_MediaInfoDto;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class MediaInfoDto {
    @SerializedName("height")
    public abstract Integer height();

    @SerializedName("streams")
    public abstract List<TrackDto> streams();

    @SerializedName("tracks")
    public abstract List<TrackDto> tracks();

    @SerializedName("width")
    public abstract Integer width();

    public static TypeAdapter<MediaInfoDto> typeAdapter(Gson gson) {
        return new AutoValue_MediaInfoDto.GsonTypeAdapter(gson);
    }
}
