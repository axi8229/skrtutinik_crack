package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import flussonic.watcher.sdk.data.network.dto.AutoValue_PlaybackConfigDto;

/* loaded from: classes3.dex */
public abstract class PlaybackConfigDto {
    @SerializedName("token")
    public abstract String token();

    public static TypeAdapter<PlaybackConfigDto> typeAdapter(Gson gson) {
        return new AutoValue_PlaybackConfigDto.GsonTypeAdapter(gson);
    }
}
