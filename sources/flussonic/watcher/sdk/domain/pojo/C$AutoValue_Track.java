package flussonic.watcher.sdk.domain.pojo;

import flussonic.watcher.sdk.domain.pojo.Track;

/* renamed from: flussonic.watcher.sdk.domain.pojo.$AutoValue_Track, reason: invalid class name */
/* loaded from: classes3.dex */
abstract class C$AutoValue_Track extends Track {
    private final int bitrate;
    private final String codec;
    private final String content;
    private final int height;
    private final String level;
    private final int pixelHeight;
    private final int pixelWidth;
    private final String profile;
    private final int sarHeight;
    private final int sarWidth;
    private final String size;
    private final String trackId;
    private final int width;

    C$AutoValue_Track(String level, String profile, int bitrate, String content, String codec, String size, String trackId, int sarHeight, int width, int pixelHeight, int sarWidth, int pixelWidth, int height) {
        if (level == null) {
            throw new NullPointerException("Null level");
        }
        this.level = level;
        if (profile == null) {
            throw new NullPointerException("Null profile");
        }
        this.profile = profile;
        this.bitrate = bitrate;
        if (content == null) {
            throw new NullPointerException("Null content");
        }
        this.content = content;
        if (codec == null) {
            throw new NullPointerException("Null codec");
        }
        this.codec = codec;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.size = size;
        if (trackId == null) {
            throw new NullPointerException("Null trackId");
        }
        this.trackId = trackId;
        this.sarHeight = sarHeight;
        this.width = width;
        this.pixelHeight = pixelHeight;
        this.sarWidth = sarWidth;
        this.pixelWidth = pixelWidth;
        this.height = height;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public String level() {
        return this.level;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public String profile() {
        return this.profile;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public int bitrate() {
        return this.bitrate;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public String content() {
        return this.content;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public String codec() {
        return this.codec;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public String size() {
        return this.size;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public String trackId() {
        return this.trackId;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public int sarHeight() {
        return this.sarHeight;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public int width() {
        return this.width;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public int pixelHeight() {
        return this.pixelHeight;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public int sarWidth() {
        return this.sarWidth;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public int pixelWidth() {
        return this.pixelWidth;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Track
    public int height() {
        return this.height;
    }

    public String toString() {
        return "Track{level=" + this.level + ", profile=" + this.profile + ", bitrate=" + this.bitrate + ", content=" + this.content + ", codec=" + this.codec + ", size=" + this.size + ", trackId=" + this.trackId + ", sarHeight=" + this.sarHeight + ", width=" + this.width + ", pixelHeight=" + this.pixelHeight + ", sarWidth=" + this.sarWidth + ", pixelWidth=" + this.pixelWidth + ", height=" + this.height + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Track)) {
            return false;
        }
        Track track = (Track) o;
        return this.level.equals(track.level()) && this.profile.equals(track.profile()) && this.bitrate == track.bitrate() && this.content.equals(track.content()) && this.codec.equals(track.codec()) && this.size.equals(track.size()) && this.trackId.equals(track.trackId()) && this.sarHeight == track.sarHeight() && this.width == track.width() && this.pixelHeight == track.pixelHeight() && this.sarWidth == track.sarWidth() && this.pixelWidth == track.pixelWidth() && this.height == track.height();
    }

    public int hashCode() {
        return ((((((((((((((((((((((((this.level.hashCode() ^ 1000003) * 1000003) ^ this.profile.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.content.hashCode()) * 1000003) ^ this.codec.hashCode()) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.trackId.hashCode()) * 1000003) ^ this.sarHeight) * 1000003) ^ this.width) * 1000003) ^ this.pixelHeight) * 1000003) ^ this.sarWidth) * 1000003) ^ this.pixelWidth) * 1000003) ^ this.height;
    }

    /* renamed from: flussonic.watcher.sdk.domain.pojo.$AutoValue_Track$Builder */
    static class Builder extends Track.Builder {
        private Integer bitrate;
        private String codec;
        private String content;
        private Integer height;
        private String level;
        private Integer pixelHeight;
        private Integer pixelWidth;
        private String profile;
        private Integer sarHeight;
        private Integer sarWidth;
        private String size;
        private String trackId;
        private Integer width;

        Builder() {
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setLevel(String level) {
            if (level == null) {
                throw new NullPointerException("Null level");
            }
            this.level = level;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setProfile(String profile) {
            if (profile == null) {
                throw new NullPointerException("Null profile");
            }
            this.profile = profile;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setBitrate(int bitrate) {
            this.bitrate = Integer.valueOf(bitrate);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setContent(String content) {
            if (content == null) {
                throw new NullPointerException("Null content");
            }
            this.content = content;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setCodec(String codec) {
            if (codec == null) {
                throw new NullPointerException("Null codec");
            }
            this.codec = codec;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setSize(String size) {
            if (size == null) {
                throw new NullPointerException("Null size");
            }
            this.size = size;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setTrackId(String trackId) {
            if (trackId == null) {
                throw new NullPointerException("Null trackId");
            }
            this.trackId = trackId;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setSarHeight(int sarHeight) {
            this.sarHeight = Integer.valueOf(sarHeight);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setWidth(int width) {
            this.width = Integer.valueOf(width);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setPixelHeight(int pixelHeight) {
            this.pixelHeight = Integer.valueOf(pixelHeight);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setSarWidth(int sarWidth) {
            this.sarWidth = Integer.valueOf(sarWidth);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setPixelWidth(int pixelWidth) {
            this.pixelWidth = Integer.valueOf(pixelWidth);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track.Builder setHeight(int height) {
            this.height = Integer.valueOf(height);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Track.Builder
        public Track build() {
            if (this.level == null || this.profile == null || this.bitrate == null || this.content == null || this.codec == null || this.size == null || this.trackId == null || this.sarHeight == null || this.width == null || this.pixelHeight == null || this.sarWidth == null || this.pixelWidth == null || this.height == null) {
                StringBuilder sb = new StringBuilder();
                if (this.level == null) {
                    sb.append(" level");
                }
                if (this.profile == null) {
                    sb.append(" profile");
                }
                if (this.bitrate == null) {
                    sb.append(" bitrate");
                }
                if (this.content == null) {
                    sb.append(" content");
                }
                if (this.codec == null) {
                    sb.append(" codec");
                }
                if (this.size == null) {
                    sb.append(" size");
                }
                if (this.trackId == null) {
                    sb.append(" trackId");
                }
                if (this.sarHeight == null) {
                    sb.append(" sarHeight");
                }
                if (this.width == null) {
                    sb.append(" width");
                }
                if (this.pixelHeight == null) {
                    sb.append(" pixelHeight");
                }
                if (this.sarWidth == null) {
                    sb.append(" sarWidth");
                }
                if (this.pixelWidth == null) {
                    sb.append(" pixelWidth");
                }
                if (this.height == null) {
                    sb.append(" height");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_Track(this.level, this.profile, this.bitrate.intValue(), this.content, this.codec, this.size, this.trackId, this.sarHeight.intValue(), this.width.intValue(), this.pixelHeight.intValue(), this.sarWidth.intValue(), this.pixelWidth.intValue(), this.height.intValue());
        }
    }
}
