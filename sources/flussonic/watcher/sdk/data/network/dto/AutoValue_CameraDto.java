package flussonic.watcher.sdk.data.network.dto;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class AutoValue_CameraDto extends C$AutoValue_CameraDto {
    AutoValue_CameraDto(final String postalAddress, final String owner, final String access, final Boolean isStatic, final Boolean hasMotionDetector, final String coordinates, final StreamStatusDto streamStatus, final List<Object> groups, final Boolean isDvrEnabled, final String title, final Boolean isDvrProtected, final Object dvrSpace, final PlaybackConfigDto playbackConfig, final PermissionsDto permissions, final Object agentStatus, final String name, final String comment, final Float dvrDepth, final Map<String, Object> userAttributes) {
        new CameraDto(postalAddress, owner, access, isStatic, hasMotionDetector, coordinates, streamStatus, groups, isDvrEnabled, title, isDvrProtected, dvrSpace, playbackConfig, permissions, agentStatus, name, comment, dvrDepth, userAttributes) { // from class: flussonic.watcher.sdk.data.network.dto.$AutoValue_CameraDto
            private final String access;
            private final Object agentStatus;
            private final String comment;
            private final String coordinates;
            private final Float dvrDepth;
            private final Object dvrSpace;
            private final List<Object> groups;
            private final Boolean hasMotionDetector;
            private final Boolean isDvrEnabled;
            private final Boolean isDvrProtected;
            private final Boolean isStatic;
            private final String name;
            private final String owner;
            private final PermissionsDto permissions;
            private final PlaybackConfigDto playbackConfig;
            private final String postalAddress;
            private final StreamStatusDto streamStatus;
            private final String title;
            private final Map<String, Object> userAttributes;

            {
                this.postalAddress = postalAddress;
                this.owner = owner;
                this.access = access;
                this.isStatic = isStatic;
                this.hasMotionDetector = hasMotionDetector;
                this.coordinates = coordinates;
                this.streamStatus = streamStatus;
                this.groups = groups;
                this.isDvrEnabled = isDvrEnabled;
                this.title = title;
                this.isDvrProtected = isDvrProtected;
                this.dvrSpace = dvrSpace;
                this.playbackConfig = playbackConfig;
                this.permissions = permissions;
                this.agentStatus = agentStatus;
                this.name = name;
                this.comment = comment;
                this.dvrDepth = dvrDepth;
                this.userAttributes = userAttributes;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("postal_address")
            public String postalAddress() {
                return this.postalAddress;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("owner")
            public String owner() {
                return this.owner;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("access")
            public String access() {
                return this.access;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("static")
            public Boolean isStatic() {
                return this.isStatic;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("motion_detector")
            public Boolean hasMotionDetector() {
                return this.hasMotionDetector;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("coordinates")
            public String coordinates() {
                return this.coordinates;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("stream_status")
            public StreamStatusDto streamStatus() {
                return this.streamStatus;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("groups")
            public List<Object> groups() {
                return this.groups;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("dvr_enabled")
            public Boolean isDvrEnabled() {
                return this.isDvrEnabled;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
            public String title() {
                return this.title;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("dvr_protected")
            public Boolean isDvrProtected() {
                return this.isDvrProtected;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("dvr_space")
            public Object dvrSpace() {
                return this.dvrSpace;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("playback_config")
            public PlaybackConfigDto playbackConfig() {
                return this.playbackConfig;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("permissions")
            public PermissionsDto permissions() {
                return this.permissions;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("agent_status")
            public Object agentStatus() {
                return this.agentStatus;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
            public String name() {
                return this.name;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT)
            public String comment() {
                return this.comment;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("dvr_depth")
            public Float dvrDepth() {
                return this.dvrDepth;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.CameraDto
            @SerializedName("user_attributes")
            public Map<String, Object> userAttributes() {
                return this.userAttributes;
            }

            public String toString() {
                return "CameraDto{postalAddress=" + this.postalAddress + ", owner=" + this.owner + ", access=" + this.access + ", isStatic=" + this.isStatic + ", hasMotionDetector=" + this.hasMotionDetector + ", coordinates=" + this.coordinates + ", streamStatus=" + this.streamStatus + ", groups=" + this.groups + ", isDvrEnabled=" + this.isDvrEnabled + ", title=" + this.title + ", isDvrProtected=" + this.isDvrProtected + ", dvrSpace=" + this.dvrSpace + ", playbackConfig=" + this.playbackConfig + ", permissions=" + this.permissions + ", agentStatus=" + this.agentStatus + ", name=" + this.name + ", comment=" + this.comment + ", dvrDepth=" + this.dvrDepth + ", userAttributes=" + this.userAttributes + "}";
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof CameraDto)) {
                    return false;
                }
                CameraDto cameraDto = (CameraDto) o;
                String str = this.postalAddress;
                if (str != null ? str.equals(cameraDto.postalAddress()) : cameraDto.postalAddress() == null) {
                    String str2 = this.owner;
                    if (str2 != null ? str2.equals(cameraDto.owner()) : cameraDto.owner() == null) {
                        String str3 = this.access;
                        if (str3 != null ? str3.equals(cameraDto.access()) : cameraDto.access() == null) {
                            Boolean bool = this.isStatic;
                            if (bool != null ? bool.equals(cameraDto.isStatic()) : cameraDto.isStatic() == null) {
                                Boolean bool2 = this.hasMotionDetector;
                                if (bool2 != null ? bool2.equals(cameraDto.hasMotionDetector()) : cameraDto.hasMotionDetector() == null) {
                                    String str4 = this.coordinates;
                                    if (str4 != null ? str4.equals(cameraDto.coordinates()) : cameraDto.coordinates() == null) {
                                        StreamStatusDto streamStatusDto = this.streamStatus;
                                        if (streamStatusDto != null ? streamStatusDto.equals(cameraDto.streamStatus()) : cameraDto.streamStatus() == null) {
                                            List<Object> list = this.groups;
                                            if (list != null ? list.equals(cameraDto.groups()) : cameraDto.groups() == null) {
                                                Boolean bool3 = this.isDvrEnabled;
                                                if (bool3 != null ? bool3.equals(cameraDto.isDvrEnabled()) : cameraDto.isDvrEnabled() == null) {
                                                    String str5 = this.title;
                                                    if (str5 != null ? str5.equals(cameraDto.title()) : cameraDto.title() == null) {
                                                        Boolean bool4 = this.isDvrProtected;
                                                        if (bool4 != null ? bool4.equals(cameraDto.isDvrProtected()) : cameraDto.isDvrProtected() == null) {
                                                            Object obj = this.dvrSpace;
                                                            if (obj != null ? obj.equals(cameraDto.dvrSpace()) : cameraDto.dvrSpace() == null) {
                                                                PlaybackConfigDto playbackConfigDto = this.playbackConfig;
                                                                if (playbackConfigDto != null ? playbackConfigDto.equals(cameraDto.playbackConfig()) : cameraDto.playbackConfig() == null) {
                                                                    PermissionsDto permissionsDto = this.permissions;
                                                                    if (permissionsDto != null ? permissionsDto.equals(cameraDto.permissions()) : cameraDto.permissions() == null) {
                                                                        Object obj2 = this.agentStatus;
                                                                        if (obj2 != null ? obj2.equals(cameraDto.agentStatus()) : cameraDto.agentStatus() == null) {
                                                                            String str6 = this.name;
                                                                            if (str6 != null ? str6.equals(cameraDto.name()) : cameraDto.name() == null) {
                                                                                String str7 = this.comment;
                                                                                if (str7 != null ? str7.equals(cameraDto.comment()) : cameraDto.comment() == null) {
                                                                                    Float f = this.dvrDepth;
                                                                                    if (f != null ? f.equals(cameraDto.dvrDepth()) : cameraDto.dvrDepth() == null) {
                                                                                        Map<String, Object> map = this.userAttributes;
                                                                                        if (map == null) {
                                                                                            if (cameraDto.userAttributes() == null) {
                                                                                                return true;
                                                                                            }
                                                                                        } else if (map.equals(cameraDto.userAttributes())) {
                                                                                            return true;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                String str = this.postalAddress;
                int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
                String str2 = this.owner;
                int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
                String str3 = this.access;
                int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
                Boolean bool = this.isStatic;
                int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
                Boolean bool2 = this.hasMotionDetector;
                int iHashCode5 = (iHashCode4 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
                String str4 = this.coordinates;
                int iHashCode6 = (iHashCode5 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
                StreamStatusDto streamStatusDto = this.streamStatus;
                int iHashCode7 = (iHashCode6 ^ (streamStatusDto == null ? 0 : streamStatusDto.hashCode())) * 1000003;
                List<Object> list = this.groups;
                int iHashCode8 = (iHashCode7 ^ (list == null ? 0 : list.hashCode())) * 1000003;
                Boolean bool3 = this.isDvrEnabled;
                int iHashCode9 = (iHashCode8 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
                String str5 = this.title;
                int iHashCode10 = (iHashCode9 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
                Boolean bool4 = this.isDvrProtected;
                int iHashCode11 = (iHashCode10 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003;
                Object obj = this.dvrSpace;
                int iHashCode12 = (iHashCode11 ^ (obj == null ? 0 : obj.hashCode())) * 1000003;
                PlaybackConfigDto playbackConfigDto = this.playbackConfig;
                int iHashCode13 = (iHashCode12 ^ (playbackConfigDto == null ? 0 : playbackConfigDto.hashCode())) * 1000003;
                PermissionsDto permissionsDto = this.permissions;
                int iHashCode14 = (iHashCode13 ^ (permissionsDto == null ? 0 : permissionsDto.hashCode())) * 1000003;
                Object obj2 = this.agentStatus;
                int iHashCode15 = (iHashCode14 ^ (obj2 == null ? 0 : obj2.hashCode())) * 1000003;
                String str6 = this.name;
                int iHashCode16 = (iHashCode15 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
                String str7 = this.comment;
                int iHashCode17 = (iHashCode16 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
                Float f = this.dvrDepth;
                int iHashCode18 = (iHashCode17 ^ (f == null ? 0 : f.hashCode())) * 1000003;
                Map<String, Object> map = this.userAttributes;
                return iHashCode18 ^ (map != null ? map.hashCode() : 0);
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<CameraDto> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private volatile TypeAdapter<Float> float__adapter;
        private final Gson gson;
        private volatile TypeAdapter<List<Object>> list__object_adapter;
        private volatile TypeAdapter<Map<String, Object>> map__string_object_adapter;
        private volatile TypeAdapter<Object> object_adapter;
        private volatile TypeAdapter<PermissionsDto> permissionsDto_adapter;
        private volatile TypeAdapter<PlaybackConfigDto> playbackConfigDto_adapter;
        private volatile TypeAdapter<StreamStatusDto> streamStatusDto_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, CameraDto object) throws IOException {
            if (object == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("postal_address");
            if (object.postalAddress() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, object.postalAddress());
            }
            jsonWriter.name("owner");
            if (object.owner() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, object.owner());
            }
            jsonWriter.name("access");
            if (object.access() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter3 = this.string_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter3;
                }
                adapter3.write(jsonWriter, object.access());
            }
            jsonWriter.name("static");
            if (object.isStatic() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter4 = this.boolean__adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter4;
                }
                adapter4.write(jsonWriter, object.isStatic());
            }
            jsonWriter.name("motion_detector");
            if (object.hasMotionDetector() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter5 = this.boolean__adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter5;
                }
                adapter5.write(jsonWriter, object.hasMotionDetector());
            }
            jsonWriter.name("coordinates");
            if (object.coordinates() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter6 = this.string_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter6;
                }
                adapter6.write(jsonWriter, object.coordinates());
            }
            jsonWriter.name("stream_status");
            if (object.streamStatus() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<StreamStatusDto> adapter7 = this.streamStatusDto_adapter;
                if (adapter7 == null) {
                    adapter7 = this.gson.getAdapter(StreamStatusDto.class);
                    this.streamStatusDto_adapter = adapter7;
                }
                adapter7.write(jsonWriter, object.streamStatus());
            }
            jsonWriter.name("groups");
            if (object.groups() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Object>> adapter8 = this.list__object_adapter;
                if (adapter8 == null) {
                    adapter8 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Object.class));
                    this.list__object_adapter = adapter8;
                }
                adapter8.write(jsonWriter, object.groups());
            }
            jsonWriter.name("dvr_enabled");
            if (object.isDvrEnabled() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter9 = this.boolean__adapter;
                if (adapter9 == null) {
                    adapter9 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter9;
                }
                adapter9.write(jsonWriter, object.isDvrEnabled());
            }
            jsonWriter.name(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE);
            if (object.title() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter10 = this.string_adapter;
                if (adapter10 == null) {
                    adapter10 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter10;
                }
                adapter10.write(jsonWriter, object.title());
            }
            jsonWriter.name("dvr_protected");
            if (object.isDvrProtected() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter11 = this.boolean__adapter;
                if (adapter11 == null) {
                    adapter11 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter11;
                }
                adapter11.write(jsonWriter, object.isDvrProtected());
            }
            jsonWriter.name("dvr_space");
            if (object.dvrSpace() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Object> adapter12 = this.object_adapter;
                if (adapter12 == null) {
                    adapter12 = this.gson.getAdapter(Object.class);
                    this.object_adapter = adapter12;
                }
                adapter12.write(jsonWriter, object.dvrSpace());
            }
            jsonWriter.name("playback_config");
            if (object.playbackConfig() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<PlaybackConfigDto> adapter13 = this.playbackConfigDto_adapter;
                if (adapter13 == null) {
                    adapter13 = this.gson.getAdapter(PlaybackConfigDto.class);
                    this.playbackConfigDto_adapter = adapter13;
                }
                adapter13.write(jsonWriter, object.playbackConfig());
            }
            jsonWriter.name("permissions");
            if (object.permissions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<PermissionsDto> adapter14 = this.permissionsDto_adapter;
                if (adapter14 == null) {
                    adapter14 = this.gson.getAdapter(PermissionsDto.class);
                    this.permissionsDto_adapter = adapter14;
                }
                adapter14.write(jsonWriter, object.permissions());
            }
            jsonWriter.name("agent_status");
            if (object.agentStatus() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Object> adapter15 = this.object_adapter;
                if (adapter15 == null) {
                    adapter15 = this.gson.getAdapter(Object.class);
                    this.object_adapter = adapter15;
                }
                adapter15.write(jsonWriter, object.agentStatus());
            }
            jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.NAME);
            if (object.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter16 = this.string_adapter;
                if (adapter16 == null) {
                    adapter16 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter16;
                }
                adapter16.write(jsonWriter, object.name());
            }
            jsonWriter.name(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT);
            if (object.comment() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter17 = this.string_adapter;
                if (adapter17 == null) {
                    adapter17 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter17;
                }
                adapter17.write(jsonWriter, object.comment());
            }
            jsonWriter.name("dvr_depth");
            if (object.dvrDepth() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Float> adapter18 = this.float__adapter;
                if (adapter18 == null) {
                    adapter18 = this.gson.getAdapter(Float.class);
                    this.float__adapter = adapter18;
                }
                adapter18.write(jsonWriter, object.dvrDepth());
            }
            jsonWriter.name("user_attributes");
            if (object.userAttributes() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Map<String, Object>> adapter19 = this.map__string_object_adapter;
                if (adapter19 == null) {
                    adapter19 = this.gson.getAdapter(TypeToken.getParameterized(Map.class, String.class, Object.class));
                    this.map__string_object_adapter = adapter19;
                }
                adapter19.write(jsonWriter, object.userAttributes());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public CameraDto read2(JsonReader jsonReader) throws IOException {
            boolean z;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            Boolean bool = null;
            Boolean bool2 = null;
            String str4 = null;
            StreamStatusDto streamStatusDto = null;
            List<Object> list = null;
            Boolean bool3 = null;
            String str5 = null;
            Boolean bool4 = null;
            Object obj = null;
            PlaybackConfigDto playbackConfigDto = null;
            PermissionsDto permissionsDto = null;
            Object obj2 = null;
            String str6 = null;
            String str7 = null;
            Float f = null;
            Map<String, Object> map = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "dvr_protected":
                            TypeAdapter<Boolean> adapter = this.boolean__adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter;
                            }
                            bool4 = adapter.read2(jsonReader);
                            break;
                        case "postal_address":
                            z = true;
                            TypeAdapter<String> adapter2 = this.string_adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter2;
                            }
                            str = adapter2.read2(jsonReader);
                            break;
                        case "access":
                            z = true;
                            TypeAdapter<String> adapter3 = this.string_adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter3;
                            }
                            str3 = adapter3.read2(jsonReader);
                            break;
                        case "groups":
                            TypeAdapter<List<Object>> adapter4 = this.list__object_adapter;
                            if (adapter4 == null) {
                                z = true;
                                adapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Object.class));
                                this.list__object_adapter = adapter4;
                            } else {
                                z = true;
                            }
                            list = adapter4.read2(jsonReader);
                            break;
                        case "static":
                            TypeAdapter<Boolean> adapter5 = this.boolean__adapter;
                            if (adapter5 == null) {
                                adapter5 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter5;
                            }
                            bool = adapter5.read2(jsonReader);
                            break;
                        case "dvr_enabled":
                            TypeAdapter<Boolean> adapter6 = this.boolean__adapter;
                            if (adapter6 == null) {
                                adapter6 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter6;
                            }
                            bool3 = adapter6.read2(jsonReader);
                            break;
                        case "name":
                            TypeAdapter<String> adapter7 = this.string_adapter;
                            if (adapter7 == null) {
                                adapter7 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter7;
                            }
                            str6 = adapter7.read2(jsonReader);
                            break;
                        case "dvr_depth":
                            TypeAdapter<Float> adapter8 = this.float__adapter;
                            if (adapter8 == null) {
                                adapter8 = this.gson.getAdapter(Float.class);
                                this.float__adapter = adapter8;
                            }
                            f = adapter8.read2(jsonReader);
                            break;
                        case "dvr_space":
                            TypeAdapter<Object> adapter9 = this.object_adapter;
                            if (adapter9 == null) {
                                adapter9 = this.gson.getAdapter(Object.class);
                                this.object_adapter = adapter9;
                            }
                            obj = adapter9.read2(jsonReader);
                            break;
                        case "owner":
                            TypeAdapter<String> adapter10 = this.string_adapter;
                            if (adapter10 == null) {
                                adapter10 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter10;
                            }
                            str2 = adapter10.read2(jsonReader);
                            break;
                        case "title":
                            TypeAdapter<String> adapter11 = this.string_adapter;
                            if (adapter11 == null) {
                                adapter11 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter11;
                            }
                            str5 = adapter11.read2(jsonReader);
                            break;
                        case "stream_status":
                            TypeAdapter<StreamStatusDto> adapter12 = this.streamStatusDto_adapter;
                            if (adapter12 == null) {
                                adapter12 = this.gson.getAdapter(StreamStatusDto.class);
                                this.streamStatusDto_adapter = adapter12;
                            }
                            streamStatusDto = adapter12.read2(jsonReader);
                            break;
                        case "motion_detector":
                            TypeAdapter<Boolean> adapter13 = this.boolean__adapter;
                            if (adapter13 == null) {
                                adapter13 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter13;
                            }
                            bool2 = adapter13.read2(jsonReader);
                            break;
                        case "comment":
                            TypeAdapter<String> adapter14 = this.string_adapter;
                            if (adapter14 == null) {
                                adapter14 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter14;
                            }
                            str7 = adapter14.read2(jsonReader);
                            break;
                        case "playback_config":
                            TypeAdapter<PlaybackConfigDto> adapter15 = this.playbackConfigDto_adapter;
                            if (adapter15 == null) {
                                adapter15 = this.gson.getAdapter(PlaybackConfigDto.class);
                                this.playbackConfigDto_adapter = adapter15;
                            }
                            playbackConfigDto = adapter15.read2(jsonReader);
                            break;
                        case "permissions":
                            TypeAdapter<PermissionsDto> adapter16 = this.permissionsDto_adapter;
                            if (adapter16 == null) {
                                adapter16 = this.gson.getAdapter(PermissionsDto.class);
                                this.permissionsDto_adapter = adapter16;
                            }
                            permissionsDto = adapter16.read2(jsonReader);
                            break;
                        case "agent_status":
                            TypeAdapter<Object> adapter17 = this.object_adapter;
                            if (adapter17 == null) {
                                adapter17 = this.gson.getAdapter(Object.class);
                                this.object_adapter = adapter17;
                            }
                            obj2 = adapter17.read2(jsonReader);
                            break;
                        case "user_attributes":
                            TypeAdapter<Map<String, Object>> adapter18 = this.map__string_object_adapter;
                            if (adapter18 == null) {
                                adapter18 = this.gson.getAdapter(TypeToken.getParameterized(Map.class, String.class, Object.class));
                                this.map__string_object_adapter = adapter18;
                            }
                            map = adapter18.read2(jsonReader);
                            break;
                        case "coordinates":
                            TypeAdapter<String> adapter19 = this.string_adapter;
                            if (adapter19 == null) {
                                adapter19 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter19;
                            }
                            str4 = adapter19.read2(jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_CameraDto(str, str2, str3, bool, bool2, str4, streamStatusDto, list, bool3, str5, bool4, obj, playbackConfigDto, permissionsDto, obj2, str6, str7, f, map);
        }

        public String toString() {
            return "TypeAdapter(CameraDto)";
        }
    }
}
