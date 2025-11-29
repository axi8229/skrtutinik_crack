package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class MediaItem {
    public final ClippingProperties clippingProperties;
    public final String mediaId;
    public final MediaMetadata mediaMetadata;
    public final PlaybackProperties playbackProperties;

    public static MediaItem fromUri(String sourceUri) {
        return new Builder().setSourceUri(sourceUri).build();
    }

    public static MediaItem fromUri(Uri sourceUri) {
        return new Builder().setSourceUri(sourceUri).build();
    }

    public static final class Builder {
        private boolean clipRelativeToDefaultPosition;
        private boolean clipRelativeToLiveWindow;
        private long clipStartPositionMs;
        private boolean clipStartsAtKeyFrame;
        private String customCacheKey;
        private Uri drmLicenseUri;
        private boolean drmMultiSession;
        private boolean drmPlayClearContentWithoutKey;
        private UUID drmUuid;
        private String mediaId;
        private MediaMetadata mediaMetadata;
        private String mimeType;
        private Uri sourceUri;
        private Object tag;
        private long clipEndPositionMs = Long.MIN_VALUE;
        private List<Integer> drmSessionForClearTypes = Collections.emptyList();
        private Map<String, String> drmLicenseRequestHeaders = Collections.emptyMap();
        private List<StreamKey> streamKeys = Collections.emptyList();
        private List<Subtitle> subtitles = Collections.emptyList();

        public Builder setSourceUri(String sourceUri) {
            return setSourceUri(sourceUri == null ? null : Uri.parse(sourceUri));
        }

        public Builder setSourceUri(Uri sourceUri) {
            this.sourceUri = sourceUri;
            return this;
        }

        public MediaItem build() {
            PlaybackProperties playbackProperties;
            Assertions.checkState(this.drmLicenseUri == null || this.drmUuid != null);
            Uri uri = this.sourceUri;
            if (uri != null) {
                String str = this.mimeType;
                UUID uuid = this.drmUuid;
                PlaybackProperties playbackProperties2 = new PlaybackProperties(uri, str, uuid != null ? new DrmConfiguration(uuid, this.drmLicenseUri, this.drmLicenseRequestHeaders, this.drmMultiSession, this.drmPlayClearContentWithoutKey, this.drmSessionForClearTypes) : null, this.streamKeys, this.customCacheKey, this.subtitles, this.tag);
                String string = this.mediaId;
                if (string == null) {
                    string = this.sourceUri.toString();
                }
                this.mediaId = string;
                playbackProperties = playbackProperties2;
            } else {
                playbackProperties = null;
            }
            String str2 = (String) Assertions.checkNotNull(this.mediaId);
            ClippingProperties clippingProperties = new ClippingProperties(this.clipStartPositionMs, this.clipEndPositionMs, this.clipRelativeToLiveWindow, this.clipRelativeToDefaultPosition, this.clipStartsAtKeyFrame);
            MediaMetadata mediaMetadataBuild = this.mediaMetadata;
            if (mediaMetadataBuild == null) {
                mediaMetadataBuild = new MediaMetadata.Builder().build();
            }
            return new MediaItem(str2, clippingProperties, playbackProperties, mediaMetadataBuild);
        }
    }

    public static final class DrmConfiguration {
        public final Uri licenseUri;
        public final boolean multiSession;
        public final boolean playClearContentWithoutKey;
        public final Map<String, String> requestHeaders;
        public final List<Integer> sessionForClearTypes;
        public final UUID uuid;

        private DrmConfiguration(UUID uuid, Uri licenseUri, Map<String, String> requestHeaders, boolean multiSession, boolean playClearContentWithoutKey, List<Integer> drmSessionForClearTypes) {
            this.uuid = uuid;
            this.licenseUri = licenseUri;
            this.requestHeaders = requestHeaders;
            this.multiSession = multiSession;
            this.playClearContentWithoutKey = playClearContentWithoutKey;
            this.sessionForClearTypes = drmSessionForClearTypes;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            return this.uuid.equals(drmConfiguration.uuid) && Util.areEqual(this.licenseUri, drmConfiguration.licenseUri) && Util.areEqual(this.requestHeaders, drmConfiguration.requestHeaders) && this.multiSession == drmConfiguration.multiSession && this.playClearContentWithoutKey == drmConfiguration.playClearContentWithoutKey && this.sessionForClearTypes.equals(drmConfiguration.sessionForClearTypes);
        }

        public int hashCode() {
            int iHashCode = this.uuid.hashCode() * 31;
            Uri uri = this.licenseUri;
            return ((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.requestHeaders.hashCode()) * 31) + (this.multiSession ? 1 : 0)) * 31) + (this.playClearContentWithoutKey ? 1 : 0)) * 31) + this.sessionForClearTypes.hashCode();
        }
    }

    public static final class PlaybackProperties {
        public final String customCacheKey;
        public final DrmConfiguration drmConfiguration;
        public final String mimeType;
        public final Uri sourceUri;
        public final List<StreamKey> streamKeys;
        public final List<Subtitle> subtitles;
        public final Object tag;

        private PlaybackProperties(Uri sourceUri, String mimeType, DrmConfiguration drmConfiguration, List<StreamKey> streamKeys, String customCacheKey, List<Subtitle> subtitles, Object tag) {
            this.sourceUri = sourceUri;
            this.mimeType = mimeType;
            this.drmConfiguration = drmConfiguration;
            this.streamKeys = streamKeys;
            this.customCacheKey = customCacheKey;
            this.subtitles = subtitles;
            this.tag = tag;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaybackProperties)) {
                return false;
            }
            PlaybackProperties playbackProperties = (PlaybackProperties) obj;
            return this.sourceUri.equals(playbackProperties.sourceUri) && Util.areEqual(this.mimeType, playbackProperties.mimeType) && Util.areEqual(this.drmConfiguration, playbackProperties.drmConfiguration) && this.streamKeys.equals(playbackProperties.streamKeys) && Util.areEqual(this.customCacheKey, playbackProperties.customCacheKey) && this.subtitles.equals(playbackProperties.subtitles) && Util.areEqual(this.tag, playbackProperties.tag);
        }

        public int hashCode() {
            int iHashCode = this.sourceUri.hashCode() * 31;
            String str = this.mimeType;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            DrmConfiguration drmConfiguration = this.drmConfiguration;
            int iHashCode3 = (((iHashCode2 + (drmConfiguration == null ? 0 : drmConfiguration.hashCode())) * 31) + this.streamKeys.hashCode()) * 31;
            String str2 = this.customCacheKey;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.subtitles.hashCode()) * 31;
            Object obj = this.tag;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }
    }

    public static final class Subtitle {
        public final String language;
        public final String mimeType;
        public final int selectionFlags;
        public final Uri uri;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) obj;
            return this.uri.equals(subtitle.uri) && this.mimeType.equals(subtitle.mimeType) && Util.areEqual(this.language, subtitle.language) && this.selectionFlags == subtitle.selectionFlags;
        }

        public int hashCode() {
            int iHashCode = ((this.uri.hashCode() * 31) + this.mimeType.hashCode()) * 31;
            String str = this.language;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.selectionFlags;
        }
    }

    public static final class ClippingProperties {
        public final long endPositionMs;
        public final boolean relativeToDefaultPosition;
        public final boolean relativeToLiveWindow;
        public final long startPositionMs;
        public final boolean startsAtKeyFrame;

        private ClippingProperties(long startPositionMs, long endPositionMs, boolean relativeToLiveWindow, boolean relativeToDefaultPosition, boolean startsAtKeyFrame) {
            this.startPositionMs = startPositionMs;
            this.endPositionMs = endPositionMs;
            this.relativeToLiveWindow = relativeToLiveWindow;
            this.relativeToDefaultPosition = relativeToDefaultPosition;
            this.startsAtKeyFrame = startsAtKeyFrame;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingProperties)) {
                return false;
            }
            ClippingProperties clippingProperties = (ClippingProperties) obj;
            return this.startPositionMs == clippingProperties.startPositionMs && this.endPositionMs == clippingProperties.endPositionMs && this.relativeToLiveWindow == clippingProperties.relativeToLiveWindow && this.relativeToDefaultPosition == clippingProperties.relativeToDefaultPosition && this.startsAtKeyFrame == clippingProperties.startsAtKeyFrame;
        }

        public int hashCode() {
            return (((((((Long.valueOf(this.startPositionMs).hashCode() * 31) + Long.valueOf(this.endPositionMs).hashCode()) * 31) + (this.relativeToLiveWindow ? 1 : 0)) * 31) + (this.relativeToDefaultPosition ? 1 : 0)) * 31) + (this.startsAtKeyFrame ? 1 : 0);
        }
    }

    private MediaItem(String mediaId, ClippingProperties clippingProperties, PlaybackProperties playbackProperties, MediaMetadata mediaMetadata) {
        this.mediaId = mediaId;
        this.playbackProperties = playbackProperties;
        this.mediaMetadata = mediaMetadata;
        this.clippingProperties = clippingProperties;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        return Util.areEqual(this.mediaId, mediaItem.mediaId) && this.clippingProperties.equals(mediaItem.clippingProperties) && Util.areEqual(this.playbackProperties, mediaItem.playbackProperties) && Util.areEqual(this.mediaMetadata, mediaItem.mediaMetadata);
    }

    public int hashCode() {
        int iHashCode = this.mediaId.hashCode() * 31;
        PlaybackProperties playbackProperties = this.playbackProperties;
        return ((((iHashCode + (playbackProperties != null ? playbackProperties.hashCode() : 0)) * 31) + this.clippingProperties.hashCode()) * 31) + this.mediaMetadata.hashCode();
    }
}
