package flussonic.watcher.sdk.data.network.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.io.IOException;

/* loaded from: classes3.dex */
final class AutoValue_StreamStatusDto extends C$AutoValue_StreamStatusDto {
    AutoValue_StreamStatusDto(final String server, final Boolean isAlive, final Long lifetime, final Integer bitrate, final Object sourceError, final Integer httpPort, final Integer httpsPort, final Integer rtspPort, final Integer rtmpPort) {
        new StreamStatusDto(server, isAlive, lifetime, bitrate, sourceError, httpPort, httpsPort, rtspPort, rtmpPort) { // from class: flussonic.watcher.sdk.data.network.dto.$AutoValue_StreamStatusDto
            private final Integer bitrate;
            private final Integer httpPort;
            private final Integer httpsPort;
            private final Boolean isAlive;
            private final Long lifetime;
            private final Integer rtmpPort;
            private final Integer rtspPort;
            private final String server;
            private final Object sourceError;

            {
                this.server = server;
                this.isAlive = isAlive;
                this.lifetime = lifetime;
                this.bitrate = bitrate;
                this.sourceError = sourceError;
                this.httpPort = httpPort;
                this.httpsPort = httpsPort;
                this.rtspPort = rtspPort;
                this.rtmpPort = rtmpPort;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamStatusDto
            @SerializedName("server")
            public String server() {
                return this.server;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamStatusDto
            @SerializedName("alive")
            public Boolean isAlive() {
                return this.isAlive;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamStatusDto
            @SerializedName("lifetime")
            public Long lifetime() {
                return this.lifetime;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamStatusDto
            @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)
            public Integer bitrate() {
                return this.bitrate;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamStatusDto
            @SerializedName("source_error")
            public Object sourceError() {
                return this.sourceError;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamStatusDto
            @SerializedName("http_port")
            public Integer httpPort() {
                return this.httpPort;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamStatusDto
            @SerializedName("https_port")
            public Integer httpsPort() {
                return this.httpsPort;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamStatusDto
            @SerializedName("rtsp_port")
            public Integer rtspPort() {
                return this.rtspPort;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.StreamStatusDto
            @SerializedName("rtmp_port")
            public Integer rtmpPort() {
                return this.rtmpPort;
            }

            public String toString() {
                return "StreamStatusDto{server=" + this.server + ", isAlive=" + this.isAlive + ", lifetime=" + this.lifetime + ", bitrate=" + this.bitrate + ", sourceError=" + this.sourceError + ", httpPort=" + this.httpPort + ", httpsPort=" + this.httpsPort + ", rtspPort=" + this.rtspPort + ", rtmpPort=" + this.rtmpPort + "}";
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof StreamStatusDto)) {
                    return false;
                }
                StreamStatusDto streamStatusDto = (StreamStatusDto) o;
                String str = this.server;
                if (str != null ? str.equals(streamStatusDto.server()) : streamStatusDto.server() == null) {
                    Boolean bool = this.isAlive;
                    if (bool != null ? bool.equals(streamStatusDto.isAlive()) : streamStatusDto.isAlive() == null) {
                        Long l = this.lifetime;
                        if (l != null ? l.equals(streamStatusDto.lifetime()) : streamStatusDto.lifetime() == null) {
                            Integer num = this.bitrate;
                            if (num != null ? num.equals(streamStatusDto.bitrate()) : streamStatusDto.bitrate() == null) {
                                Object obj = this.sourceError;
                                if (obj != null ? obj.equals(streamStatusDto.sourceError()) : streamStatusDto.sourceError() == null) {
                                    Integer num2 = this.httpPort;
                                    if (num2 != null ? num2.equals(streamStatusDto.httpPort()) : streamStatusDto.httpPort() == null) {
                                        Integer num3 = this.httpsPort;
                                        if (num3 != null ? num3.equals(streamStatusDto.httpsPort()) : streamStatusDto.httpsPort() == null) {
                                            Integer num4 = this.rtspPort;
                                            if (num4 != null ? num4.equals(streamStatusDto.rtspPort()) : streamStatusDto.rtspPort() == null) {
                                                Integer num5 = this.rtmpPort;
                                                if (num5 == null) {
                                                    if (streamStatusDto.rtmpPort() == null) {
                                                        return true;
                                                    }
                                                } else if (num5.equals(streamStatusDto.rtmpPort())) {
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
                return false;
            }

            public int hashCode() {
                String str = this.server;
                int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
                Boolean bool = this.isAlive;
                int iHashCode2 = (iHashCode ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
                Long l = this.lifetime;
                int iHashCode3 = (iHashCode2 ^ (l == null ? 0 : l.hashCode())) * 1000003;
                Integer num = this.bitrate;
                int iHashCode4 = (iHashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
                Object obj = this.sourceError;
                int iHashCode5 = (iHashCode4 ^ (obj == null ? 0 : obj.hashCode())) * 1000003;
                Integer num2 = this.httpPort;
                int iHashCode6 = (iHashCode5 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
                Integer num3 = this.httpsPort;
                int iHashCode7 = (iHashCode6 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
                Integer num4 = this.rtspPort;
                int iHashCode8 = (iHashCode7 ^ (num4 == null ? 0 : num4.hashCode())) * 1000003;
                Integer num5 = this.rtmpPort;
                return iHashCode8 ^ (num5 != null ? num5.hashCode() : 0);
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<StreamStatusDto> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<Long> long__adapter;
        private volatile TypeAdapter<Object> object_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StreamStatusDto object) throws IOException {
            if (object == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("server");
            if (object.server() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, object.server());
            }
            jsonWriter.name("alive");
            if (object.isAlive() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter2 = this.boolean__adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter2;
                }
                adapter2.write(jsonWriter, object.isAlive());
            }
            jsonWriter.name("lifetime");
            if (object.lifetime() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Long> adapter3 = this.long__adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(Long.class);
                    this.long__adapter = adapter3;
                }
                adapter3.write(jsonWriter, object.lifetime());
            }
            jsonWriter.name(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
            if (object.bitrate() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter4 = this.integer_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter4;
                }
                adapter4.write(jsonWriter, object.bitrate());
            }
            jsonWriter.name("source_error");
            if (object.sourceError() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Object> adapter5 = this.object_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(Object.class);
                    this.object_adapter = adapter5;
                }
                adapter5.write(jsonWriter, object.sourceError());
            }
            jsonWriter.name("http_port");
            if (object.httpPort() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter6 = this.integer_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter6;
                }
                adapter6.write(jsonWriter, object.httpPort());
            }
            jsonWriter.name("https_port");
            if (object.httpsPort() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter7 = this.integer_adapter;
                if (adapter7 == null) {
                    adapter7 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter7;
                }
                adapter7.write(jsonWriter, object.httpsPort());
            }
            jsonWriter.name("rtsp_port");
            if (object.rtspPort() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter8 = this.integer_adapter;
                if (adapter8 == null) {
                    adapter8 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter8;
                }
                adapter8.write(jsonWriter, object.rtspPort());
            }
            jsonWriter.name("rtmp_port");
            if (object.rtmpPort() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter9 = this.integer_adapter;
                if (adapter9 == null) {
                    adapter9 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter9;
                }
                adapter9.write(jsonWriter, object.rtmpPort());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public StreamStatusDto read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = null;
            Boolean bool = null;
            Long l = null;
            Integer num = null;
            Object obj = null;
            Integer num2 = null;
            Integer num3 = null;
            Integer num4 = null;
            Integer num5 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "rtsp_port":
                            TypeAdapter<Integer> adapter = this.integer_adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = adapter;
                            }
                            num4 = adapter.read2(jsonReader);
                            break;
                        case "server":
                            TypeAdapter<String> adapter2 = this.string_adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter2;
                            }
                            str = adapter2.read2(jsonReader);
                            break;
                        case "bitrate":
                            TypeAdapter<Integer> adapter3 = this.integer_adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = adapter3;
                            }
                            num = adapter3.read2(jsonReader);
                            break;
                        case "alive":
                            TypeAdapter<Boolean> adapter4 = this.boolean__adapter;
                            if (adapter4 == null) {
                                adapter4 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter4;
                            }
                            bool = adapter4.read2(jsonReader);
                            break;
                        case "http_port":
                            TypeAdapter<Integer> adapter5 = this.integer_adapter;
                            if (adapter5 == null) {
                                adapter5 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = adapter5;
                            }
                            num2 = adapter5.read2(jsonReader);
                            break;
                        case "lifetime":
                            TypeAdapter<Long> adapter6 = this.long__adapter;
                            if (adapter6 == null) {
                                adapter6 = this.gson.getAdapter(Long.class);
                                this.long__adapter = adapter6;
                            }
                            l = adapter6.read2(jsonReader);
                            break;
                        case "source_error":
                            TypeAdapter<Object> adapter7 = this.object_adapter;
                            if (adapter7 == null) {
                                adapter7 = this.gson.getAdapter(Object.class);
                                this.object_adapter = adapter7;
                            }
                            obj = adapter7.read2(jsonReader);
                            break;
                        case "rtmp_port":
                            TypeAdapter<Integer> adapter8 = this.integer_adapter;
                            if (adapter8 == null) {
                                adapter8 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = adapter8;
                            }
                            num5 = adapter8.read2(jsonReader);
                            break;
                        case "https_port":
                            TypeAdapter<Integer> adapter9 = this.integer_adapter;
                            if (adapter9 == null) {
                                adapter9 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = adapter9;
                            }
                            num3 = adapter9.read2(jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_StreamStatusDto(str, bool, l, num, obj, num2, num3, num4, num5);
        }

        public String toString() {
            return "TypeAdapter(StreamStatusDto)";
        }
    }
}
