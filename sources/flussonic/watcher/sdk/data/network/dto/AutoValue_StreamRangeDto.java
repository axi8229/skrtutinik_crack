package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.io.IOException;

/* loaded from: classes3.dex */
final class AutoValue_StreamRangeDto extends C$AutoValue_StreamRangeDto {
    AutoValue_StreamRangeDto(final Long from, final Long duration) {
        new StreamRangeDto(from, duration) { // from class: flussonic.watcher.sdk.data.network.dto.$AutoValue_StreamRangeDto
            private final Long duration;
            private final Long from;

            {
                this.from = from;
                this.duration = duration;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamRangeDto
            @SerializedName(alternate = {"start"}, value = RemoteMessageConst.FROM)
            public Long from() {
                return this.from;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamRangeDto
            @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION)
            public Long duration() {
                return this.duration;
            }

            public String toString() {
                return "StreamRangeDto{from=" + this.from + ", duration=" + this.duration + "}";
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof StreamRangeDto)) {
                    return false;
                }
                StreamRangeDto streamRangeDto = (StreamRangeDto) o;
                Long l = this.from;
                if (l != null ? l.equals(streamRangeDto.from()) : streamRangeDto.from() == null) {
                    Long l2 = this.duration;
                    if (l2 == null) {
                        if (streamRangeDto.duration() == null) {
                            return true;
                        }
                    } else if (l2.equals(streamRangeDto.duration())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Long l = this.from;
                int iHashCode = ((l == null ? 0 : l.hashCode()) ^ 1000003) * 1000003;
                Long l2 = this.duration;
                return iHashCode ^ (l2 != null ? l2.hashCode() : 0);
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<StreamRangeDto> {
        private final Gson gson;
        private volatile TypeAdapter<Long> long__adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StreamRangeDto object) throws IOException {
            if (object == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(RemoteMessageConst.FROM);
            if (object.from() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Long> adapter = this.long__adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(Long.class);
                    this.long__adapter = adapter;
                }
                adapter.write(jsonWriter, object.from());
            }
            jsonWriter.name(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION);
            if (object.duration() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Long> adapter2 = this.long__adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(Long.class);
                    this.long__adapter = adapter2;
                }
                adapter2.write(jsonWriter, object.duration());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public StreamRangeDto read2(JsonReader jsonReader) throws IOException {
            Long l = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            Long l2 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "duration":
                            TypeAdapter<Long> adapter = this.long__adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(Long.class);
                                this.long__adapter = adapter;
                            }
                            l2 = adapter.read2(jsonReader);
                            break;
                        case "from":
                        case "start":
                            TypeAdapter<Long> adapter2 = this.long__adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(Long.class);
                                this.long__adapter = adapter2;
                            }
                            l = adapter2.read2(jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_StreamRangeDto(l, l2);
        }

        public String toString() {
            return "TypeAdapter(StreamRangeDto)";
        }
    }
}
