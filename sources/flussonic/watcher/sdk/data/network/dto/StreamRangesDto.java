package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import flussonic.watcher.sdk.data.network.dto.AutoValue_StreamRangesDto;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class StreamRangesDto {
    @SerializedName("motion_log")
    public abstract List<EventDto> events();

    @SerializedName("ranges")
    public abstract List<StreamRangeDto> ranges();

    @SerializedName("stream")
    public abstract String stream();

    @SerializedName("warning")
    public abstract String warning();

    public static TypeAdapter<StreamRangesDto> typeAdapter(Gson gson) {
        return new AutoValue_StreamRangesDto.GsonTypeAdapter(gson);
    }
}
