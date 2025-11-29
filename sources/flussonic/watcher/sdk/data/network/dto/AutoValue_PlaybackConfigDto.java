package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
final class AutoValue_PlaybackConfigDto extends C$AutoValue_PlaybackConfigDto {
    AutoValue_PlaybackConfigDto(final String token) {
        new PlaybackConfigDto(token) { // from class: flussonic.watcher.sdk.data.network.dto.$AutoValue_PlaybackConfigDto
            private final String token;

            {
                this.token = token;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.PlaybackConfigDto
            @SerializedName("token")
            public String token() {
                return this.token;
            }

            public String toString() {
                return "PlaybackConfigDto{token=" + this.token + "}";
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof PlaybackConfigDto)) {
                    return false;
                }
                String str = this.token;
                String str2 = ((PlaybackConfigDto) o).token();
                return str == null ? str2 == null : str.equals(str2);
            }

            public int hashCode() {
                String str = this.token;
                return (str == null ? 0 : str.hashCode()) ^ 1000003;
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<PlaybackConfigDto> {
        private final Gson gson;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, PlaybackConfigDto object) throws IOException {
            if (object == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("token");
            if (object.token() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, object.token());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public PlaybackConfigDto read2(JsonReader jsonReader) throws IOException {
            String str = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (strNextName.equals("token")) {
                        TypeAdapter<String> adapter = this.string_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter;
                        }
                        str = adapter.read2(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_PlaybackConfigDto(str);
        }

        public String toString() {
            return "TypeAdapter(PlaybackConfigDto)";
        }
    }
}
