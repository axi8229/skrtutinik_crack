package flussonic.watcher.sdk.domain.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
final class AutoValue_Camera extends C$AutoValue_Camera {
    public static final Parcelable.Creator<AutoValue_Camera> CREATOR = new Parcelable.Creator<AutoValue_Camera>() { // from class: flussonic.watcher.sdk.domain.pojo.AutoValue_Camera.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AutoValue_Camera createFromParcel(Parcel in) {
            return new AutoValue_Camera(in.readInt() == 0 ? in.readString() : null, in.readInt() == 1, in.readInt(), in.readInt(), in.readInt(), in.readString(), in.readString(), in.readString(), in.readInt() == 1, in.readInt() == 1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AutoValue_Camera[] newArray(int size) {
            return new AutoValue_Camera[size];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_Camera(String title, boolean isAlive, int rtmpPort, int httpPort, int httpsPort, String server, String name, String token, boolean hasAnError, boolean permissionDvr) {
        super(title, isAlive, rtmpPort, httpPort, httpsPort, server, name, token, hasAnError, permissionDvr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (title() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(title());
        }
        parcel.writeInt(isAlive() ? 1 : 0);
        parcel.writeInt(rtmpPort());
        parcel.writeInt(httpPort());
        parcel.writeInt(httpsPort());
        parcel.writeString(server());
        parcel.writeString(name());
        parcel.writeString(token());
        parcel.writeInt(hasAnError() ? 1 : 0);
        parcel.writeInt(permissionDvr() ? 1 : 0);
    }
}
