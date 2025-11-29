package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
final class AutoValue_MediaInfoDto extends C$AutoValue_MediaInfoDto {
    AutoValue_MediaInfoDto(final List<TrackDto> streams, final List<TrackDto> tracks, final Integer width, final Integer height) {
        new MediaInfoDto(streams, tracks, width, height) { // from class: flussonic.watcher.sdk.data.network.dto.$AutoValue_MediaInfoDto
            private final Integer height;
            private final List<TrackDto> streams;
            private final List<TrackDto> tracks;
            private final Integer width;

            {
                this.streams = streams;
                this.tracks = tracks;
                this.width = width;
                this.height = height;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.MediaInfoDto
            @SerializedName("streams")
            public List<TrackDto> streams() {
                return this.streams;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.MediaInfoDto
            @SerializedName("tracks")
            public List<TrackDto> tracks() {
                return this.tracks;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.MediaInfoDto
            @SerializedName("width")
            public Integer width() {
                return this.width;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.MediaInfoDto
            @SerializedName("height")
            public Integer height() {
                return this.height;
            }

            public String toString() {
                return "MediaInfoDto{streams=" + this.streams + ", tracks=" + this.tracks + ", width=" + this.width + ", height=" + this.height + "}";
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof MediaInfoDto)) {
                    return false;
                }
                MediaInfoDto mediaInfoDto = (MediaInfoDto) o;
                List<TrackDto> list = this.streams;
                if (list != null ? list.equals(mediaInfoDto.streams()) : mediaInfoDto.streams() == null) {
                    List<TrackDto> list2 = this.tracks;
                    if (list2 != null ? list2.equals(mediaInfoDto.tracks()) : mediaInfoDto.tracks() == null) {
                        Integer num = this.width;
                        if (num != null ? num.equals(mediaInfoDto.width()) : mediaInfoDto.width() == null) {
                            Integer num2 = this.height;
                            if (num2 == null) {
                                if (mediaInfoDto.height() == null) {
                                    return true;
                                }
                            } else if (num2.equals(mediaInfoDto.height())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                List<TrackDto> list = this.streams;
                int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
                List<TrackDto> list2 = this.tracks;
                int iHashCode2 = (iHashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
                Integer num = this.width;
                int iHashCode3 = (iHashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
                Integer num2 = this.height;
                return iHashCode3 ^ (num2 != null ? num2.hashCode() : 0);
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<MediaInfoDto> {
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<List<TrackDto>> list__trackDto_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MediaInfoDto object) throws IOException {
            if (object == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("streams");
            if (object.streams() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<TrackDto>> adapter = this.list__trackDto_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, TrackDto.class));
                    this.list__trackDto_adapter = adapter;
                }
                adapter.write(jsonWriter, object.streams());
            }
            jsonWriter.name("tracks");
            if (object.tracks() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<TrackDto>> adapter2 = this.list__trackDto_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, TrackDto.class));
                    this.list__trackDto_adapter = adapter2;
                }
                adapter2.write(jsonWriter, object.tracks());
            }
            jsonWriter.name("width");
            if (object.width() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter3 = this.integer_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter3;
                }
                adapter3.write(jsonWriter, object.width());
            }
            jsonWriter.name("height");
            if (object.height() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter4 = this.integer_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter4;
                }
                adapter4.write(jsonWriter, object.height());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public MediaInfoDto read2(JsonReader jsonReader) throws IOException {
            List<TrackDto> list = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            List<TrackDto> list2 = null;
            Integer num = null;
            Integer num2 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "streams":
                            TypeAdapter<List<TrackDto>> adapter = this.list__trackDto_adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, TrackDto.class));
                                this.list__trackDto_adapter = adapter;
                            }
                            list = adapter.read2(jsonReader);
                            break;
                        case "height":
                            TypeAdapter<Integer> adapter2 = this.integer_adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = adapter2;
                            }
                            num2 = adapter2.read2(jsonReader);
                            break;
                        case "tracks":
                            TypeAdapter<List<TrackDto>> adapter3 = this.list__trackDto_adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, TrackDto.class));
                                this.list__trackDto_adapter = adapter3;
                            }
                            list2 = adapter3.read2(jsonReader);
                            break;
                        case "width":
                            TypeAdapter<Integer> adapter4 = this.integer_adapter;
                            if (adapter4 == null) {
                                adapter4 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = adapter4;
                            }
                            num = adapter4.read2(jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_MediaInfoDto(list, list2, num, num2);
        }

        public String toString() {
            return "TypeAdapter(MediaInfoDto)";
        }
    }
}
