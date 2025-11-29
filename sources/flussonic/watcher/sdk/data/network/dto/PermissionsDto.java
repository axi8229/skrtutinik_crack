package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import flussonic.watcher.sdk.data.network.dto.AutoValue_PermissionsDto;

/* loaded from: classes3.dex */
public abstract class PermissionsDto {
    @SerializedName("view")
    public abstract Boolean hasView();

    @SerializedName("dvr")
    public abstract Boolean isDvr();

    @SerializedName("ptz")
    public abstract Boolean isPtz();

    public static TypeAdapter<PermissionsDto> typeAdapter(Gson gson) {
        return new AutoValue_PermissionsDto.GsonTypeAdapter(gson);
    }
}
