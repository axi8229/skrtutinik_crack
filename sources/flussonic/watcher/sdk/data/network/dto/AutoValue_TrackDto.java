package flussonic.watcher.sdk.data.network.dto;

import com.google.android.gms.common.Scopes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonWriter;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.io.IOException;

/* loaded from: classes3.dex */
final class AutoValue_TrackDto extends C$AutoValue_TrackDto {
    AutoValue_TrackDto(final String level, final String profile, final Integer bitrate, final String content, final String codec, final String size, final String trackId, final Integer sarHeight, final Integer width, final Integer pixelHeight, final Integer sarWidth, final Integer pixelWidth, final Integer height) {
        new TrackDto(level, profile, bitrate, content, codec, size, trackId, sarHeight, width, pixelHeight, sarWidth, pixelWidth, height) { // from class: flussonic.watcher.sdk.data.network.dto.$AutoValue_TrackDto
            private final Integer bitrate;
            private final String codec;
            private final String content;
            private final Integer height;
            private final String level;
            private final Integer pixelHeight;
            private final Integer pixelWidth;
            private final String profile;
            private final Integer sarHeight;
            private final Integer sarWidth;
            private final String size;
            private final String trackId;
            private final Integer width;

            {
                this.level = level;
                this.profile = profile;
                this.bitrate = bitrate;
                this.content = content;
                this.codec = codec;
                this.size = size;
                this.trackId = trackId;
                this.sarHeight = sarHeight;
                this.width = width;
                this.pixelHeight = pixelHeight;
                this.sarWidth = sarWidth;
                this.pixelWidth = pixelWidth;
                this.height = height;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("level")
            public String level() {
                return this.level;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName(Scopes.PROFILE)
            public String profile() {
                return this.profile;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)
            public Integer bitrate() {
                return this.bitrate;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("content")
            public String content() {
                return this.content;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("codec")
            public String codec() {
                return this.codec;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("size")
            public String size() {
                return this.size;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("track_id")
            public String trackId() {
                return this.trackId;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("sar_height")
            public Integer sarHeight() {
                return this.sarHeight;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("width")
            public Integer width() {
                return this.width;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("pixel_height")
            public Integer pixelHeight() {
                return this.pixelHeight;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("sar_width")
            public Integer sarWidth() {
                return this.sarWidth;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("pixel_width")
            public Integer pixelWidth() {
                return this.pixelWidth;
            }

            @Override // flussonic.watcher.sdk.data.network.dto.TrackDto
            @SerializedName("height")
            public Integer height() {
                return this.height;
            }

            public String toString() {
                return "TrackDto{level=" + this.level + ", profile=" + this.profile + ", bitrate=" + this.bitrate + ", content=" + this.content + ", codec=" + this.codec + ", size=" + this.size + ", trackId=" + this.trackId + ", sarHeight=" + this.sarHeight + ", width=" + this.width + ", pixelHeight=" + this.pixelHeight + ", sarWidth=" + this.sarWidth + ", pixelWidth=" + this.pixelWidth + ", height=" + this.height + "}";
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof TrackDto)) {
                    return false;
                }
                TrackDto trackDto = (TrackDto) o;
                String str = this.level;
                if (str != null ? str.equals(trackDto.level()) : trackDto.level() == null) {
                    String str2 = this.profile;
                    if (str2 != null ? str2.equals(trackDto.profile()) : trackDto.profile() == null) {
                        Integer num = this.bitrate;
                        if (num != null ? num.equals(trackDto.bitrate()) : trackDto.bitrate() == null) {
                            String str3 = this.content;
                            if (str3 != null ? str3.equals(trackDto.content()) : trackDto.content() == null) {
                                String str4 = this.codec;
                                if (str4 != null ? str4.equals(trackDto.codec()) : trackDto.codec() == null) {
                                    String str5 = this.size;
                                    if (str5 != null ? str5.equals(trackDto.size()) : trackDto.size() == null) {
                                        String str6 = this.trackId;
                                        if (str6 != null ? str6.equals(trackDto.trackId()) : trackDto.trackId() == null) {
                                            Integer num2 = this.sarHeight;
                                            if (num2 != null ? num2.equals(trackDto.sarHeight()) : trackDto.sarHeight() == null) {
                                                Integer num3 = this.width;
                                                if (num3 != null ? num3.equals(trackDto.width()) : trackDto.width() == null) {
                                                    Integer num4 = this.pixelHeight;
                                                    if (num4 != null ? num4.equals(trackDto.pixelHeight()) : trackDto.pixelHeight() == null) {
                                                        Integer num5 = this.sarWidth;
                                                        if (num5 != null ? num5.equals(trackDto.sarWidth()) : trackDto.sarWidth() == null) {
                                                            Integer num6 = this.pixelWidth;
                                                            if (num6 != null ? num6.equals(trackDto.pixelWidth()) : trackDto.pixelWidth() == null) {
                                                                Integer num7 = this.height;
                                                                if (num7 == null) {
                                                                    if (trackDto.height() == null) {
                                                                        return true;
                                                                    }
                                                                } else if (num7.equals(trackDto.height())) {
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
                return false;
            }

            public int hashCode() {
                String str = this.level;
                int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
                String str2 = this.profile;
                int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
                Integer num = this.bitrate;
                int iHashCode3 = (iHashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
                String str3 = this.content;
                int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
                String str4 = this.codec;
                int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
                String str5 = this.size;
                int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
                String str6 = this.trackId;
                int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
                Integer num2 = this.sarHeight;
                int iHashCode8 = (iHashCode7 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
                Integer num3 = this.width;
                int iHashCode9 = (iHashCode8 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
                Integer num4 = this.pixelHeight;
                int iHashCode10 = (iHashCode9 ^ (num4 == null ? 0 : num4.hashCode())) * 1000003;
                Integer num5 = this.sarWidth;
                int iHashCode11 = (iHashCode10 ^ (num5 == null ? 0 : num5.hashCode())) * 1000003;
                Integer num6 = this.pixelWidth;
                int iHashCode12 = (iHashCode11 ^ (num6 == null ? 0 : num6.hashCode())) * 1000003;
                Integer num7 = this.height;
                return iHashCode12 ^ (num7 != null ? num7.hashCode() : 0);
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<TrackDto> {
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, TrackDto object) throws IOException {
            if (object == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("level");
            if (object.level() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, object.level());
            }
            jsonWriter.name(Scopes.PROFILE);
            if (object.profile() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, object.profile());
            }
            jsonWriter.name(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
            if (object.bitrate() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter3 = this.integer_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter3;
                }
                adapter3.write(jsonWriter, object.bitrate());
            }
            jsonWriter.name("content");
            if (object.content() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter4 = this.string_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter4;
                }
                adapter4.write(jsonWriter, object.content());
            }
            jsonWriter.name("codec");
            if (object.codec() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter5 = this.string_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter5;
                }
                adapter5.write(jsonWriter, object.codec());
            }
            jsonWriter.name("size");
            if (object.size() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter6 = this.string_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter6;
                }
                adapter6.write(jsonWriter, object.size());
            }
            jsonWriter.name("track_id");
            if (object.trackId() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter7 = this.string_adapter;
                if (adapter7 == null) {
                    adapter7 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter7;
                }
                adapter7.write(jsonWriter, object.trackId());
            }
            jsonWriter.name("sar_height");
            if (object.sarHeight() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter8 = this.integer_adapter;
                if (adapter8 == null) {
                    adapter8 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter8;
                }
                adapter8.write(jsonWriter, object.sarHeight());
            }
            jsonWriter.name("width");
            if (object.width() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter9 = this.integer_adapter;
                if (adapter9 == null) {
                    adapter9 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter9;
                }
                adapter9.write(jsonWriter, object.width());
            }
            jsonWriter.name("pixel_height");
            if (object.pixelHeight() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter10 = this.integer_adapter;
                if (adapter10 == null) {
                    adapter10 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter10;
                }
                adapter10.write(jsonWriter, object.pixelHeight());
            }
            jsonWriter.name("sar_width");
            if (object.sarWidth() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter11 = this.integer_adapter;
                if (adapter11 == null) {
                    adapter11 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter11;
                }
                adapter11.write(jsonWriter, object.sarWidth());
            }
            jsonWriter.name("pixel_width");
            if (object.pixelWidth() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter12 = this.integer_adapter;
                if (adapter12 == null) {
                    adapter12 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter12;
                }
                adapter12.write(jsonWriter, object.pixelWidth());
            }
            jsonWriter.name("height");
            if (object.height() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter13 = this.integer_adapter;
                if (adapter13 == null) {
                    adapter13 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter13;
                }
                adapter13.write(jsonWriter, object.height());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public flussonic.watcher.sdk.data.network.dto.TrackDto read2(com.google.gson.stream.JsonReader r21) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 608
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: flussonic.watcher.sdk.data.network.dto.AutoValue_TrackDto.GsonTypeAdapter.read2(com.google.gson.stream.JsonReader):flussonic.watcher.sdk.data.network.dto.TrackDto");
        }

        public String toString() {
            return "TypeAdapter(TrackDto)";
        }
    }
}
