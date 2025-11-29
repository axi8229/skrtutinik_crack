package flussonic.watcher.sdk.data.network.dto;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import flussonic.watcher.sdk.data.network.dto.AutoValue_CameraDto;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class CameraDto {
    @SerializedName("access")
    public abstract String access();

    @SerializedName("agent_status")
    public abstract Object agentStatus();

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT)
    public abstract String comment();

    @SerializedName("coordinates")
    public abstract String coordinates();

    @SerializedName("dvr_depth")
    public abstract Float dvrDepth();

    @SerializedName("dvr_space")
    public abstract Object dvrSpace();

    @SerializedName("groups")
    public abstract List<Object> groups();

    @SerializedName("motion_detector")
    public abstract Boolean hasMotionDetector();

    @SerializedName("dvr_enabled")
    public abstract Boolean isDvrEnabled();

    @SerializedName("dvr_protected")
    public abstract Boolean isDvrProtected();

    @SerializedName("static")
    public abstract Boolean isStatic();

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    public abstract String name();

    @SerializedName("owner")
    public abstract String owner();

    @SerializedName("permissions")
    public abstract PermissionsDto permissions();

    @SerializedName("playback_config")
    public abstract PlaybackConfigDto playbackConfig();

    @SerializedName("postal_address")
    public abstract String postalAddress();

    @SerializedName("stream_status")
    public abstract StreamStatusDto streamStatus();

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    public abstract String title();

    @SerializedName("user_attributes")
    public abstract Map<String, Object> userAttributes();

    public static TypeAdapter<CameraDto> typeAdapter(Gson gson) {
        return new AutoValue_CameraDto.GsonTypeAdapter(gson);
    }
}
