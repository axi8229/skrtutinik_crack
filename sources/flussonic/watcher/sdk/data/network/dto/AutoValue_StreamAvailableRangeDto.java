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
final class AutoValue_StreamAvailableRangeDto extends C$AutoValue_StreamAvailableRangeDto {
    AutoValue_StreamAvailableRangeDto(final Long from, final Long to) {
        new StreamAvailableRangeDto(from, to) { // from class: flussonic.watcher.sdk.data.network.dto.$AutoValue_StreamAvailableRangeDto
            private final Long from;
            private final Long to;

            {
                this.from = from;
                this.to = to;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamAvailableRangeDto
            @SerializedName(RemoteMessageConst.FROM)
            public Long from() {
                return this.from;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamAvailableRangeDto
            @SerializedName(RemoteMessageConst.TO)
            public Long to() {
                return this.to;
            }

            public String toString() {
                return "StreamAvailableRangeDto{from=" + this.from + ", to=" + this.to + "}";
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof StreamAvailableRangeDto)) {
                    return false;
                }
                StreamAvailableRangeDto streamAvailableRangeDto = (StreamAvailableRangeDto) o;
                Long l = this.from;
                if (l != null ? l.equals(streamAvailableRangeDto.from()) : streamAvailableRangeDto.from() == null) {
                    Long l2 = this.to;
                    if (l2 == null) {
                        if (streamAvailableRangeDto.to() == null) {
                            return true;
                        }
                    } else if (l2.equals(streamAvailableRangeDto.to())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Long l = this.from;
                int iHashCode = ((l == null ? 0 : l.hashCode()) ^ 1000003) * 1000003;
                Long l2 = this.to;
                return iHashCode ^ (l2 != null ? l2.hashCode() : 0);
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<StreamAvailableRangeDto> {
        private final Gson gson;
        private volatile TypeAdapter<Long> long__adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StreamAvailableRangeDto object) throws IOException {
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
            jsonWriter.name(RemoteMessageConst.TO);
            if (object.to() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Long> adapter2 = this.long__adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(Long.class);
                    this.long__adapter = adapter2;
                }
                adapter2.write(jsonWriter, object.to());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public StreamAvailableRangeDto read2(JsonReader jsonReader) throws IOException {
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
                    if (strNextName.equals(RemoteMessageConst.TO)) {
                        TypeAdapter<Long> adapter = this.long__adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(Long.class);
                            this.long__adapter = adapter;
                        }
                        l2 = adapter.read2(jsonReader);
                    } else if (strNextName.equals(RemoteMessageConst.FROM)) {
                        TypeAdapter<Long> adapter2 = this.long__adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(Long.class);
                            this.long__adapter = adapter2;
                        }
                        l = adapter2.read2(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_StreamAvailableRangeDto(l, l2);
        }

        public String toString() {
            return "TypeAdapter(StreamAvailableRangeDto)";
        }
    }
}
