package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.IOException;

/* loaded from: classes3.dex */
final class AutoValue_EventDto extends C$AutoValue_EventDto {
    AutoValue_EventDto(final StreamRangeDto range, final String type, final String color) {
        new EventDto(range, type, color) { // from class: flussonic.watcher.sdk.data.network.dto.$AutoValue_EventDto
            private final String color;
            private final StreamRangeDto range;
            private final String type;

            {
                this.range = range;
                this.type = type;
                this.color = color;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.EventDto
            @SerializedName(RemoteMessageConst.DATA)
            public StreamRangeDto range() {
                return this.range;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.EventDto
            @SerializedName("type")
            public String type() {
                return this.type;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.EventDto
            @SerializedName(RemoteMessageConst.Notification.COLOR)
            public String color() {
                return this.color;
            }

            public String toString() {
                return "EventDto{range=" + this.range + ", type=" + this.type + ", color=" + this.color + "}";
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof EventDto)) {
                    return false;
                }
                EventDto eventDto = (EventDto) o;
                StreamRangeDto streamRangeDto = this.range;
                if (streamRangeDto != null ? streamRangeDto.equals(eventDto.range()) : eventDto.range() == null) {
                    String str = this.type;
                    if (str != null ? str.equals(eventDto.type()) : eventDto.type() == null) {
                        String str2 = this.color;
                        if (str2 == null) {
                            if (eventDto.color() == null) {
                                return true;
                            }
                        } else if (str2.equals(eventDto.color())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                StreamRangeDto streamRangeDto = this.range;
                int iHashCode = ((streamRangeDto == null ? 0 : streamRangeDto.hashCode()) ^ 1000003) * 1000003;
                String str = this.type;
                int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
                String str2 = this.color;
                return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<EventDto> {
        private final Gson gson;
        private volatile TypeAdapter<StreamRangeDto> streamRangeDto_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, EventDto object) throws IOException {
            if (object == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(RemoteMessageConst.DATA);
            if (object.range() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<StreamRangeDto> adapter = this.streamRangeDto_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(StreamRangeDto.class);
                    this.streamRangeDto_adapter = adapter;
                }
                adapter.write(jsonWriter, object.range());
            }
            jsonWriter.name("type");
            if (object.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, object.type());
            }
            jsonWriter.name(RemoteMessageConst.Notification.COLOR);
            if (object.color() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter3 = this.string_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter3;
                }
                adapter3.write(jsonWriter, object.color());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public EventDto read2(JsonReader jsonReader) throws IOException {
            StreamRangeDto streamRangeDto = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "data":
                            TypeAdapter<StreamRangeDto> adapter = this.streamRangeDto_adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(StreamRangeDto.class);
                                this.streamRangeDto_adapter = adapter;
                            }
                            streamRangeDto = adapter.read2(jsonReader);
                            break;
                        case "type":
                            TypeAdapter<String> adapter2 = this.string_adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter2;
                            }
                            str = adapter2.read2(jsonReader);
                            break;
                        case "color":
                            TypeAdapter<String> adapter3 = this.string_adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter3;
                            }
                            str2 = adapter3.read2(jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_EventDto(streamRangeDto, str, str2);
        }

        public String toString() {
            return "TypeAdapter(EventDto)";
        }
    }
}
