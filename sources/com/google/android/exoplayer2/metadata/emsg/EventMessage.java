package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class EventMessage implements Metadata.Entry {
    public final long durationMs;
    private int hashCode;
    public final long id;
    public final byte[] messageData;
    public final String schemeIdUri;
    public final String value;
    private static final Format ID3_FORMAT = new Format.Builder().setSampleMimeType("application/id3").build();
    private static final Format SCTE35_FORMAT = new Format.Builder().setSampleMimeType("application/x-scte35").build();
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() { // from class: com.google.android.exoplayer2.metadata.emsg.EventMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventMessage createFromParcel(Parcel in) {
            return new EventMessage(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventMessage[] newArray(int size) {
            return new EventMessage[size];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public EventMessage(String schemeIdUri, String value, long durationMs, long id, byte[] messageData) {
        this.schemeIdUri = schemeIdUri;
        this.value = value;
        this.durationMs = durationMs;
        this.id = id;
        this.messageData = messageData;
    }

    EventMessage(Parcel in) {
        this.schemeIdUri = (String) Util.castNonNull(in.readString());
        this.value = (String) Util.castNonNull(in.readString());
        this.durationMs = in.readLong();
        this.id = in.readLong();
        this.messageData = (byte[]) Util.castNonNull(in.createByteArray());
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public Format getWrappedMetadataFormat() {
        String str = this.schemeIdUri;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return SCTE35_FORMAT;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return ID3_FORMAT;
            default:
                return null;
        }
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public byte[] getWrappedMetadataBytes() {
        if (getWrappedMetadataFormat() != null) {
            return this.messageData;
        }
        return null;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            String str = this.schemeIdUri;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.value;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j = this.durationMs;
            int i = (((iHashCode + iHashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.id;
            this.hashCode = ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.messageData);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.durationMs == eventMessage.durationMs && this.id == eventMessage.id && Util.areEqual(this.schemeIdUri, eventMessage.schemeIdUri) && Util.areEqual(this.value, eventMessage.value) && Arrays.equals(this.messageData, eventMessage.messageData);
    }

    public String toString() {
        return "EMSG: scheme=" + this.schemeIdUri + ", id=" + this.id + ", durationMs=" + this.durationMs + ", value=" + this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.schemeIdUri);
        dest.writeString(this.value);
        dest.writeLong(this.durationMs);
        dest.writeLong(this.id);
        dest.writeByteArray(this.messageData);
    }
}
