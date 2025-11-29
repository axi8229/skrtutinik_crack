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
final class AutoValue_StreamRangesDto extends C$AutoValue_StreamRangesDto {
    AutoValue_StreamRangesDto(final String stream, final String warning, final List<StreamRangeDto> ranges, final List<EventDto> events) {
        new StreamRangesDto(stream, warning, ranges, events) { // from class: flussonic.watcher.sdk.data.network.dto.$AutoValue_StreamRangesDto
            private final List<EventDto> events;
            private final List<StreamRangeDto> ranges;
            private final String stream;
            private final String warning;

            {
                this.stream = stream;
                this.warning = warning;
                this.ranges = ranges;
                this.events = events;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamRangesDto
            @SerializedName("stream")
            public String stream() {
                return this.stream;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamRangesDto
            @SerializedName("warning")
            public String warning() {
                return this.warning;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamRangesDto
            @SerializedName("ranges")
            public List<StreamRangeDto> ranges() {
                return this.ranges;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamRangesDto
            @SerializedName("motion_log")
            public List<EventDto> events() {
                return this.events;
            }

            public String toString() {
                return "StreamRangesDto{stream=" + this.stream + ", warning=" + this.warning + ", ranges=" + this.ranges + ", events=" + this.events + "}";
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof StreamRangesDto)) {
                    return false;
                }
                StreamRangesDto streamRangesDto = (StreamRangesDto) o;
                String str = this.stream;
                if (str != null ? str.equals(streamRangesDto.stream()) : streamRangesDto.stream() == null) {
                    String str2 = this.warning;
                    if (str2 != null ? str2.equals(streamRangesDto.warning()) : streamRangesDto.warning() == null) {
                        List<StreamRangeDto> list = this.ranges;
                        if (list != null ? list.equals(streamRangesDto.ranges()) : streamRangesDto.ranges() == null) {
                            List<EventDto> list2 = this.events;
                            if (list2 == null) {
                                if (streamRangesDto.events() == null) {
                                    return true;
                                }
                            } else if (list2.equals(streamRangesDto.events())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                String str = this.stream;
                int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
                String str2 = this.warning;
                int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
                List<StreamRangeDto> list = this.ranges;
                int iHashCode3 = (iHashCode2 ^ (list == null ? 0 : list.hashCode())) * 1000003;
                List<EventDto> list2 = this.events;
                return iHashCode3 ^ (list2 != null ? list2.hashCode() : 0);
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<StreamRangesDto> {
        private final Gson gson;
        private volatile TypeAdapter<List<EventDto>> list__eventDto_adapter;
        private volatile TypeAdapter<List<StreamRangeDto>> list__streamRangeDto_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StreamRangesDto object) throws IOException {
            if (object == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("stream");
            if (object.stream() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, object.stream());
            }
            jsonWriter.name("warning");
            if (object.warning() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, object.warning());
            }
            jsonWriter.name("ranges");
            if (object.ranges() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<StreamRangeDto>> adapter3 = this.list__streamRangeDto_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, StreamRangeDto.class));
                    this.list__streamRangeDto_adapter = adapter3;
                }
                adapter3.write(jsonWriter, object.ranges());
            }
            jsonWriter.name("motion_log");
            if (object.events() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<EventDto>> adapter4 = this.list__eventDto_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, EventDto.class));
                    this.list__eventDto_adapter = adapter4;
                }
                adapter4.write(jsonWriter, object.events());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public StreamRangesDto read2(JsonReader jsonReader) throws IOException {
            String str = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str2 = null;
            List<StreamRangeDto> list = null;
            List<EventDto> list2 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "ranges":
                            TypeAdapter<List<StreamRangeDto>> adapter = this.list__streamRangeDto_adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, StreamRangeDto.class));
                                this.list__streamRangeDto_adapter = adapter;
                            }
                            list = adapter.read2(jsonReader);
                            break;
                        case "stream":
                            TypeAdapter<String> adapter2 = this.string_adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter2;
                            }
                            str = adapter2.read2(jsonReader);
                            break;
                        case "motion_log":
                            TypeAdapter<List<EventDto>> adapter3 = this.list__eventDto_adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, EventDto.class));
                                this.list__eventDto_adapter = adapter3;
                            }
                            list2 = adapter3.read2(jsonReader);
                            break;
                        case "warning":
                            TypeAdapter<String> adapter4 = this.string_adapter;
                            if (adapter4 == null) {
                                adapter4 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter4;
                            }
                            str2 = adapter4.read2(jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_StreamRangesDto(str, str2, list, list2);
        }

        public String toString() {
            return "TypeAdapter(StreamRangesDto)";
        }
    }
}
