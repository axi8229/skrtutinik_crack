package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
final class AutoValue_PermissionsDto extends C$AutoValue_PermissionsDto {
    AutoValue_PermissionsDto(final Boolean isDvr, final Boolean hasView, final Boolean isPtz) {
        new PermissionsDto(isDvr, hasView, isPtz) { // from class: flussonic.watcher.sdk.data.network.dto.$AutoValue_PermissionsDto
            private final Boolean hasView;
            private final Boolean isDvr;
            private final Boolean isPtz;

            {
                this.isDvr = isDvr;
                this.hasView = hasView;
                this.isPtz = isPtz;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.PermissionsDto
            @SerializedName("dvr")
            public Boolean isDvr() {
                return this.isDvr;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.PermissionsDto
            @SerializedName("view")
            public Boolean hasView() {
                return this.hasView;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.PermissionsDto
            @SerializedName("ptz")
            public Boolean isPtz() {
                return this.isPtz;
            }

            public String toString() {
                return "PermissionsDto{isDvr=" + this.isDvr + ", hasView=" + this.hasView + ", isPtz=" + this.isPtz + "}";
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof PermissionsDto)) {
                    return false;
                }
                PermissionsDto permissionsDto = (PermissionsDto) o;
                Boolean bool = this.isDvr;
                if (bool != null ? bool.equals(permissionsDto.isDvr()) : permissionsDto.isDvr() == null) {
                    Boolean bool2 = this.hasView;
                    if (bool2 != null ? bool2.equals(permissionsDto.hasView()) : permissionsDto.hasView() == null) {
                        Boolean bool3 = this.isPtz;
                        if (bool3 == null) {
                            if (permissionsDto.isPtz() == null) {
                                return true;
                            }
                        } else if (bool3.equals(permissionsDto.isPtz())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Boolean bool = this.isDvr;
                int iHashCode = ((bool == null ? 0 : bool.hashCode()) ^ 1000003) * 1000003;
                Boolean bool2 = this.hasView;
                int iHashCode2 = (iHashCode ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
                Boolean bool3 = this.isPtz;
                return iHashCode2 ^ (bool3 != null ? bool3.hashCode() : 0);
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<PermissionsDto> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private final Gson gson;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, PermissionsDto object) throws IOException {
            if (object == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("dvr");
            if (object.isDvr() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter = this.boolean__adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter;
                }
                adapter.write(jsonWriter, object.isDvr());
            }
            jsonWriter.name("view");
            if (object.hasView() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter2 = this.boolean__adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter2;
                }
                adapter2.write(jsonWriter, object.hasView());
            }
            jsonWriter.name("ptz");
            if (object.isPtz() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter3 = this.boolean__adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter3;
                }
                adapter3.write(jsonWriter, object.isPtz());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public PermissionsDto read2(JsonReader jsonReader) throws IOException {
            Boolean bool = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            Boolean bool2 = null;
            Boolean bool3 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "dvr":
                            TypeAdapter<Boolean> adapter = this.boolean__adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter;
                            }
                            bool = adapter.read2(jsonReader);
                            break;
                        case "ptz":
                            TypeAdapter<Boolean> adapter2 = this.boolean__adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter2;
                            }
                            bool3 = adapter2.read2(jsonReader);
                            break;
                        case "view":
                            TypeAdapter<Boolean> adapter3 = this.boolean__adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter3;
                            }
                            bool2 = adapter3.read2(jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_PermissionsDto(bool, bool2, bool3);
        }

        public String toString() {
            return "TypeAdapter(PermissionsDto)";
        }
    }
}
