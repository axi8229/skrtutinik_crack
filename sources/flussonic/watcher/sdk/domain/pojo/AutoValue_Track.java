package flussonic.watcher.sdk.domain.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
final class AutoValue_Track extends C$AutoValue_Track {
    public static final Parcelable.Creator<AutoValue_Track> CREATOR = new Parcelable.Creator<AutoValue_Track>() { // from class: flussonic.watcher.sdk.domain.pojo.AutoValue_Track.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AutoValue_Track createFromParcel(Parcel in) {
            return new AutoValue_Track(in.readString(), in.readString(), in.readInt(), in.readString(), in.readString(), in.readString(), in.readString(), in.readInt(), in.readInt(), in.readInt(), in.readInt(), in.readInt(), in.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AutoValue_Track[] newArray(int size) {
            return new AutoValue_Track[size];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_Track(String level, String profile, int bitrate, String content, String codec, String size, String trackId, int sarHeight, int width, int pixelHeight, int sarWidth, int pixelWidth, int height) {
        super(level, profile, bitrate, content, codec, size, trackId, sarHeight, width, pixelHeight, sarWidth, pixelWidth, height);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(level());
        dest.writeString(profile());
        dest.writeInt(bitrate());
        dest.writeString(content());
        dest.writeString(codec());
        dest.writeString(size());
        dest.writeString(trackId());
        dest.writeInt(sarHeight());
        dest.writeInt(width());
        dest.writeInt(pixelHeight());
        dest.writeInt(sarWidth());
        dest.writeInt(pixelWidth());
        dest.writeInt(height());
    }
}
