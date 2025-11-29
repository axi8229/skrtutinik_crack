package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.watcher.sdk.data.network.dto.AutoValue_EventDto;

/* loaded from: classes3.dex */
public abstract class EventDto {
    @SerializedName(RemoteMessageConst.Notification.COLOR)
    public abstract String color();

    @SerializedName(RemoteMessageConst.DATA)
    public abstract StreamRangeDto range();

    @SerializedName("type")
    public abstract String type();

    public static TypeAdapter<EventDto> typeAdapter(Gson gson) {
        return new AutoValue_EventDto.GsonTypeAdapter(gson);
    }
}
