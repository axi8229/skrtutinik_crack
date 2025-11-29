package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new Parcelable.Creator<MediaBrowserCompat$MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaBrowserCompat$MediaItem createFromParcel(Parcel in) {
            return new MediaBrowserCompat$MediaItem(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaBrowserCompat$MediaItem[] newArray(int size) {
            return new MediaBrowserCompat$MediaItem[size];
        }
    };
    private final MediaDescriptionCompat mDescription;
    private final int mFlags;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    MediaBrowserCompat$MediaItem(Parcel in) {
        this.mFlags = in.readInt();
        this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(in);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.mFlags);
        this.mDescription.writeToParcel(out, flags);
    }

    public String toString() {
        return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
    }
}
