package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.watcher.sdk.data.network.dto.AutoValue_StreamAvailableRangeDto;

/* loaded from: classes3.dex */
public abstract class StreamAvailableRangeDto {
    @SerializedName(RemoteMessageConst.FROM)
    public abstract Long from();

    @SerializedName(RemoteMessageConst.TO)
    public abstract Long to();

    public static TypeAdapter<StreamAvailableRangeDto> typeAdapter(Gson gson) {
        return new AutoValue_StreamAvailableRangeDto.GsonTypeAdapter(gson);
    }
}
