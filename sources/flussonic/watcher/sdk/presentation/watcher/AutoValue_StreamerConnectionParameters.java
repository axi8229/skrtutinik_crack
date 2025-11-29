package flussonic.watcher.sdk.presentation.watcher;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
final class AutoValue_StreamerConnectionParameters extends C$AutoValue_StreamerConnectionParameters {
    public static final Parcelable.Creator<AutoValue_StreamerConnectionParameters> CREATOR = new Parcelable.Creator<AutoValue_StreamerConnectionParameters>() { // from class: flussonic.watcher.sdk.presentation.watcher.AutoValue_StreamerConnectionParameters.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AutoValue_StreamerConnectionParameters createFromParcel(Parcel in) {
            return new AutoValue_StreamerConnectionParameters(in.readInt(), in.readInt(), in.readInt(), in.readString(), in.readString(), in.readString(), in.readInt() == 1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AutoValue_StreamerConnectionParameters[] newArray(int size) {
            return new AutoValue_StreamerConnectionParameters[size];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_StreamerConnectionParameters(int rtmpPort, int httpPort, int httpsPort, String server, String stream, String token, boolean permissionDvr) {
        super(rtmpPort, httpPort, httpsPort, server, stream, token, permissionDvr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(rtmpPort());
        parcel.writeInt(httpPort());
        parcel.writeInt(httpsPort());
        parcel.writeString(server());
        parcel.writeString(stream());
        parcel.writeString(token());
        parcel.writeInt(permissionDvr() ? 1 : 0);
    }
}
