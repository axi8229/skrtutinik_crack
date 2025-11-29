package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() { // from class: com.google.android.exoplayer2.Format.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Format createFromParcel(Parcel in) {
            return new Format(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Format[] newArray(int size) {
            return new Format[size];
        }
    };
    public final int accessibilityChannel;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final Class<? extends ExoMediaCrypto> exoMediaCryptoType;
    public final float frameRate;
    private int hashCode;
    public final int height;
    public final String id;
    public final List<byte[]> initializationData;
    public final String label;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static final class Builder {
        private int accessibilityChannel;
        private int averageBitrate;
        private int channelCount;
        private String codecs;
        private ColorInfo colorInfo;
        private String containerMimeType;
        private DrmInitData drmInitData;
        private int encoderDelay;
        private int encoderPadding;
        private Class<? extends ExoMediaCrypto> exoMediaCryptoType;
        private float frameRate;
        private int height;
        private String id;
        private List<byte[]> initializationData;
        private String label;
        private String language;
        private int maxInputSize;
        private Metadata metadata;
        private int pcmEncoding;
        private int peakBitrate;
        private float pixelWidthHeightRatio;
        private byte[] projectionData;
        private int roleFlags;
        private int rotationDegrees;
        private String sampleMimeType;
        private int sampleRate;
        private int selectionFlags;
        private int stereoMode;
        private long subsampleOffsetUs;
        private int width;

        public Builder() {
            this.averageBitrate = -1;
            this.peakBitrate = -1;
            this.maxInputSize = -1;
            this.subsampleOffsetUs = Long.MAX_VALUE;
            this.width = -1;
            this.height = -1;
            this.frameRate = -1.0f;
            this.pixelWidthHeightRatio = 1.0f;
            this.stereoMode = -1;
            this.channelCount = -1;
            this.sampleRate = -1;
            this.pcmEncoding = -1;
            this.accessibilityChannel = -1;
        }

        private Builder(Format format) {
            this.id = format.id;
            this.label = format.label;
            this.language = format.language;
            this.selectionFlags = format.selectionFlags;
            this.roleFlags = format.roleFlags;
            this.averageBitrate = format.averageBitrate;
            this.peakBitrate = format.peakBitrate;
            this.codecs = format.codecs;
            this.metadata = format.metadata;
            this.containerMimeType = format.containerMimeType;
            this.sampleMimeType = format.sampleMimeType;
            this.maxInputSize = format.maxInputSize;
            this.initializationData = format.initializationData;
            this.drmInitData = format.drmInitData;
            this.subsampleOffsetUs = format.subsampleOffsetUs;
            this.width = format.width;
            this.height = format.height;
            this.frameRate = format.frameRate;
            this.rotationDegrees = format.rotationDegrees;
            this.pixelWidthHeightRatio = format.pixelWidthHeightRatio;
            this.projectionData = format.projectionData;
            this.stereoMode = format.stereoMode;
            this.colorInfo = format.colorInfo;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.pcmEncoding = format.pcmEncoding;
            this.encoderDelay = format.encoderDelay;
            this.encoderPadding = format.encoderPadding;
            this.accessibilityChannel = format.accessibilityChannel;
            this.exoMediaCryptoType = format.exoMediaCryptoType;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setId(int id) {
            this.id = Integer.toString(id);
            return this;
        }

        public Builder setLabel(String label) {
            this.label = label;
            return this;
        }

        public Builder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public Builder setSelectionFlags(int selectionFlags) {
            this.selectionFlags = selectionFlags;
            return this;
        }

        public Builder setRoleFlags(int roleFlags) {
            this.roleFlags = roleFlags;
            return this;
        }

        public Builder setAverageBitrate(int averageBitrate) {
            this.averageBitrate = averageBitrate;
            return this;
        }

        public Builder setPeakBitrate(int peakBitrate) {
            this.peakBitrate = peakBitrate;
            return this;
        }

        public Builder setCodecs(String codecs) {
            this.codecs = codecs;
            return this;
        }

        public Builder setMetadata(Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder setContainerMimeType(String containerMimeType) {
            this.containerMimeType = containerMimeType;
            return this;
        }

        public Builder setSampleMimeType(String sampleMimeType) {
            this.sampleMimeType = sampleMimeType;
            return this;
        }

        public Builder setMaxInputSize(int maxInputSize) {
            this.maxInputSize = maxInputSize;
            return this;
        }

        public Builder setInitializationData(List<byte[]> initializationData) {
            this.initializationData = initializationData;
            return this;
        }

        public Builder setDrmInitData(DrmInitData drmInitData) {
            this.drmInitData = drmInitData;
            return this;
        }

        public Builder setSubsampleOffsetUs(long subsampleOffsetUs) {
            this.subsampleOffsetUs = subsampleOffsetUs;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setFrameRate(float frameRate) {
            this.frameRate = frameRate;
            return this;
        }

        public Builder setRotationDegrees(int rotationDegrees) {
            this.rotationDegrees = rotationDegrees;
            return this;
        }

        public Builder setPixelWidthHeightRatio(float pixelWidthHeightRatio) {
            this.pixelWidthHeightRatio = pixelWidthHeightRatio;
            return this;
        }

        public Builder setProjectionData(byte[] projectionData) {
            this.projectionData = projectionData;
            return this;
        }

        public Builder setStereoMode(int stereoMode) {
            this.stereoMode = stereoMode;
            return this;
        }

        public Builder setColorInfo(ColorInfo colorInfo) {
            this.colorInfo = colorInfo;
            return this;
        }

        public Builder setChannelCount(int channelCount) {
            this.channelCount = channelCount;
            return this;
        }

        public Builder setSampleRate(int sampleRate) {
            this.sampleRate = sampleRate;
            return this;
        }

        public Builder setPcmEncoding(int pcmEncoding) {
            this.pcmEncoding = pcmEncoding;
            return this;
        }

        public Builder setEncoderDelay(int encoderDelay) {
            this.encoderDelay = encoderDelay;
            return this;
        }

        public Builder setEncoderPadding(int encoderPadding) {
            this.encoderPadding = encoderPadding;
            return this;
        }

        public Builder setAccessibilityChannel(int accessibilityChannel) {
            this.accessibilityChannel = accessibilityChannel;
            return this;
        }

        public Builder setExoMediaCryptoType(Class<? extends ExoMediaCrypto> exoMediaCryptoType) {
            this.exoMediaCryptoType = exoMediaCryptoType;
            return this;
        }

        public Format build() {
            return new Format(this.id, this.label, this.language, this.selectionFlags, this.roleFlags, this.averageBitrate, this.peakBitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.accessibilityChannel, this.exoMediaCryptoType);
        }
    }

    Format(String id, String label, String language, int selectionFlags, int roleFlags, int averageBitrate, int peakBitrate, String codecs, Metadata metadata, String containerMimeType, String sampleMimeType, int maxInputSize, List<byte[]> initializationData, DrmInitData drmInitData, long subsampleOffsetUs, int width, int height, float frameRate, int rotationDegrees, float pixelWidthHeightRatio, byte[] projectionData, int stereoMode, ColorInfo colorInfo, int channelCount, int sampleRate, int pcmEncoding, int encoderDelay, int encoderPadding, int accessibilityChannel, Class<? extends ExoMediaCrypto> exoMediaCryptoType) {
        int i = peakBitrate;
        this.id = id;
        this.label = label;
        this.language = Util.normalizeLanguageCode(language);
        this.selectionFlags = selectionFlags;
        this.roleFlags = roleFlags;
        this.averageBitrate = averageBitrate;
        this.peakBitrate = i;
        this.bitrate = i == -1 ? averageBitrate : i;
        this.codecs = codecs;
        this.metadata = metadata;
        this.containerMimeType = containerMimeType;
        this.sampleMimeType = sampleMimeType;
        this.maxInputSize = maxInputSize;
        this.initializationData = initializationData == null ? Collections.emptyList() : initializationData;
        this.drmInitData = drmInitData;
        this.subsampleOffsetUs = subsampleOffsetUs;
        this.width = width;
        this.height = height;
        this.frameRate = frameRate;
        int i2 = rotationDegrees;
        this.rotationDegrees = i2 == -1 ? 0 : i2;
        this.pixelWidthHeightRatio = pixelWidthHeightRatio == -1.0f ? 1.0f : pixelWidthHeightRatio;
        this.projectionData = projectionData;
        this.stereoMode = stereoMode;
        this.colorInfo = colorInfo;
        this.channelCount = channelCount;
        this.sampleRate = sampleRate;
        this.pcmEncoding = pcmEncoding;
        int i3 = encoderDelay;
        this.encoderDelay = i3 == -1 ? 0 : i3;
        this.encoderPadding = encoderPadding != -1 ? encoderPadding : 0;
        this.accessibilityChannel = accessibilityChannel;
        this.exoMediaCryptoType = exoMediaCryptoType;
    }

    Format(Parcel in) {
        this.id = in.readString();
        this.label = in.readString();
        this.language = in.readString();
        this.selectionFlags = in.readInt();
        this.roleFlags = in.readInt();
        int i = in.readInt();
        this.averageBitrate = i;
        int i2 = in.readInt();
        this.peakBitrate = i2;
        this.bitrate = i2 != -1 ? i2 : i;
        this.codecs = in.readString();
        this.metadata = (Metadata) in.readParcelable(Metadata.class.getClassLoader());
        this.containerMimeType = in.readString();
        this.sampleMimeType = in.readString();
        this.maxInputSize = in.readInt();
        int i3 = in.readInt();
        this.initializationData = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            this.initializationData.add(in.createByteArray());
        }
        this.drmInitData = (DrmInitData) in.readParcelable(DrmInitData.class.getClassLoader());
        this.subsampleOffsetUs = in.readLong();
        this.width = in.readInt();
        this.height = in.readInt();
        this.frameRate = in.readFloat();
        this.rotationDegrees = in.readInt();
        this.pixelWidthHeightRatio = in.readFloat();
        this.projectionData = Util.readBoolean(in) ? in.createByteArray() : null;
        this.stereoMode = in.readInt();
        this.colorInfo = (ColorInfo) in.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = in.readInt();
        this.sampleRate = in.readInt();
        this.pcmEncoding = in.readInt();
        this.encoderDelay = in.readInt();
        this.encoderPadding = in.readInt();
        this.accessibilityChannel = in.readInt();
        this.exoMediaCryptoType = null;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public Format withManifestFormatInfo(Format manifestFormat) {
        String str;
        if (this == manifestFormat) {
            return this;
        }
        int trackType = MimeTypes.getTrackType(this.sampleMimeType);
        String str2 = manifestFormat.id;
        String str3 = manifestFormat.label;
        if (str3 == null) {
            str3 = this.label;
        }
        String str4 = this.language;
        if ((trackType == 3 || trackType == 1) && (str = manifestFormat.language) != null) {
            str4 = str;
        }
        int i = this.averageBitrate;
        if (i == -1) {
            i = manifestFormat.averageBitrate;
        }
        int i2 = this.peakBitrate;
        if (i2 == -1) {
            i2 = manifestFormat.peakBitrate;
        }
        String str5 = this.codecs;
        if (str5 == null) {
            String codecsOfType = Util.getCodecsOfType(manifestFormat.codecs, trackType);
            if (Util.splitCodecs(codecsOfType).length == 1) {
                str5 = codecsOfType;
            }
        }
        Metadata metadata = this.metadata;
        Metadata metadataCopyWithAppendedEntriesFrom = metadata == null ? manifestFormat.metadata : metadata.copyWithAppendedEntriesFrom(manifestFormat.metadata);
        float f = this.frameRate;
        if (f == -1.0f && trackType == 2) {
            f = manifestFormat.frameRate;
        }
        return buildUpon().setId(str2).setLabel(str3).setLanguage(str4).setSelectionFlags(this.selectionFlags | manifestFormat.selectionFlags).setRoleFlags(this.roleFlags | manifestFormat.roleFlags).setAverageBitrate(i).setPeakBitrate(i2).setCodecs(str5).setMetadata(metadataCopyWithAppendedEntriesFrom).setDrmInitData(DrmInitData.createSessionCreationData(manifestFormat.drmInitData, this.drmInitData)).setFrameRate(f).build();
    }

    public Format copyWithExoMediaCryptoType(Class<? extends ExoMediaCrypto> exoMediaCryptoType) {
        return buildUpon().setExoMediaCryptoType(exoMediaCryptoType).build();
    }

    public int getPixelCount() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public String toString() {
        return "Format(" + this.id + ", " + this.label + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.codecs + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            String str = this.id;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.label;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.language;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
            String str4 = this.codecs;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.metadata;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.containerMimeType;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.sampleMimeType;
            int iHashCode7 = (((((((((((((((((((((((((((((iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.frameRate)) * 31) + this.rotationDegrees) * 31) + Float.floatToIntBits(this.pixelWidthHeightRatio)) * 31) + this.stereoMode) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31;
            Class<? extends ExoMediaCrypto> cls = this.exoMediaCryptoType;
            this.hashCode = iHashCode7 + (cls != null ? cls.hashCode() : 0);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i2 = this.hashCode;
        if (i2 == 0 || (i = format.hashCode) == 0 || i2 == i) {
            return this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && Util.areEqual(this.exoMediaCryptoType, format.exoMediaCryptoType) && Util.areEqual(this.id, format.id) && Util.areEqual(this.label, format.label) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Util.areEqual(this.drmInitData, format.drmInitData) && initializationDataEquals(format);
        }
        return false;
    }

    public boolean initializationDataEquals(Format other) {
        if (this.initializationData.size() != other.initializationData.size()) {
            return false;
        }
        for (int i = 0; i < this.initializationData.size(); i++) {
            if (!Arrays.equals(this.initializationData.get(i), other.initializationData.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.label);
        dest.writeString(this.language);
        dest.writeInt(this.selectionFlags);
        dest.writeInt(this.roleFlags);
        dest.writeInt(this.averageBitrate);
        dest.writeInt(this.peakBitrate);
        dest.writeString(this.codecs);
        dest.writeParcelable(this.metadata, 0);
        dest.writeString(this.containerMimeType);
        dest.writeString(this.sampleMimeType);
        dest.writeInt(this.maxInputSize);
        int size = this.initializationData.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            dest.writeByteArray(this.initializationData.get(i));
        }
        dest.writeParcelable(this.drmInitData, 0);
        dest.writeLong(this.subsampleOffsetUs);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeFloat(this.frameRate);
        dest.writeInt(this.rotationDegrees);
        dest.writeFloat(this.pixelWidthHeightRatio);
        Util.writeBoolean(dest, this.projectionData != null);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            dest.writeByteArray(bArr);
        }
        dest.writeInt(this.stereoMode);
        dest.writeParcelable(this.colorInfo, flags);
        dest.writeInt(this.channelCount);
        dest.writeInt(this.sampleRate);
        dest.writeInt(this.pcmEncoding);
        dest.writeInt(this.encoderDelay);
        dest.writeInt(this.encoderPadding);
        dest.writeInt(this.accessibilityChannel);
    }
}
