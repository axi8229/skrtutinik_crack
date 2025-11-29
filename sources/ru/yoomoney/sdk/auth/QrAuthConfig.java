package ru.yoomoney.sdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/QrAuthConfig;", "Landroid/os/Parcelable;", "authQrInfoLogo", "", "authQrInfoTitle", "", "authQrSuccessSubtitle", "(ILjava/lang/String;Ljava/lang/String;)V", "getAuthQrInfoLogo", "()I", "getAuthQrInfoTitle", "()Ljava/lang/String;", "getAuthQrSuccessSubtitle", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QrAuthConfig implements Parcelable {
    public static final Parcelable.Creator<QrAuthConfig> CREATOR = new Creator();
    private final int authQrInfoLogo;
    private final String authQrInfoTitle;
    private final String authQrSuccessSubtitle;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<QrAuthConfig> {
        @Override // android.os.Parcelable.Creator
        public final QrAuthConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QrAuthConfig(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final QrAuthConfig[] newArray(int i) {
            return new QrAuthConfig[i];
        }
    }

    public QrAuthConfig(int i, String authQrInfoTitle, String authQrSuccessSubtitle) {
        Intrinsics.checkNotNullParameter(authQrInfoTitle, "authQrInfoTitle");
        Intrinsics.checkNotNullParameter(authQrSuccessSubtitle, "authQrSuccessSubtitle");
        this.authQrInfoLogo = i;
        this.authQrInfoTitle = authQrInfoTitle;
        this.authQrSuccessSubtitle = authQrSuccessSubtitle;
    }

    public static /* synthetic */ QrAuthConfig copy$default(QrAuthConfig qrAuthConfig, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = qrAuthConfig.authQrInfoLogo;
        }
        if ((i2 & 2) != 0) {
            str = qrAuthConfig.authQrInfoTitle;
        }
        if ((i2 & 4) != 0) {
            str2 = qrAuthConfig.authQrSuccessSubtitle;
        }
        return qrAuthConfig.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAuthQrInfoLogo() {
        return this.authQrInfoLogo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthQrInfoTitle() {
        return this.authQrInfoTitle;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAuthQrSuccessSubtitle() {
        return this.authQrSuccessSubtitle;
    }

    public final QrAuthConfig copy(int authQrInfoLogo, String authQrInfoTitle, String authQrSuccessSubtitle) {
        Intrinsics.checkNotNullParameter(authQrInfoTitle, "authQrInfoTitle");
        Intrinsics.checkNotNullParameter(authQrSuccessSubtitle, "authQrSuccessSubtitle");
        return new QrAuthConfig(authQrInfoLogo, authQrInfoTitle, authQrSuccessSubtitle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrAuthConfig)) {
            return false;
        }
        QrAuthConfig qrAuthConfig = (QrAuthConfig) other;
        return this.authQrInfoLogo == qrAuthConfig.authQrInfoLogo && Intrinsics.areEqual(this.authQrInfoTitle, qrAuthConfig.authQrInfoTitle) && Intrinsics.areEqual(this.authQrSuccessSubtitle, qrAuthConfig.authQrSuccessSubtitle);
    }

    public final int getAuthQrInfoLogo() {
        return this.authQrInfoLogo;
    }

    public final String getAuthQrInfoTitle() {
        return this.authQrInfoTitle;
    }

    public final String getAuthQrSuccessSubtitle() {
        return this.authQrSuccessSubtitle;
    }

    public int hashCode() {
        return this.authQrSuccessSubtitle.hashCode() + a.a(this.authQrInfoTitle, Integer.hashCode(this.authQrInfoLogo) * 31, 31);
    }

    public String toString() {
        return "QrAuthConfig(authQrInfoLogo=" + this.authQrInfoLogo + ", authQrInfoTitle=" + this.authQrInfoTitle + ", authQrSuccessSubtitle=" + this.authQrSuccessSubtitle + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.authQrInfoLogo);
        parcel.writeString(this.authQrInfoTitle);
        parcel.writeString(this.authQrSuccessSubtitle);
    }
}
