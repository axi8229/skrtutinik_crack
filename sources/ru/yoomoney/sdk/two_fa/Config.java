package ru.yoomoney.sdk.two_fa;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* compiled from: Config.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/two_fa/Config;", "Landroid/os/Parcelable;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "host", "authToken", "confirmationHelpActionVisible", "", "style", "Lru/yoomoney/sdk/two_fa/Style;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLru/yoomoney/sdk/two_fa/Style;)V", "getAuthToken", "()Ljava/lang/String;", "getConfirmationHelpActionVisible", "()Z", "getHost", "getProcessId", "getStyle", "()Lru/yoomoney/sdk/two_fa/Style;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Config implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<Config> CREATOR = new Creator();
    private final String authToken;
    private final boolean confirmationHelpActionVisible;
    private final String host;
    private final String processId;
    private final Style style;

    /* compiled from: Config.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Config> {
        @Override // android.os.Parcelable.Creator
        public final Config createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Config(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Style.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final Config[] newArray(int i) {
            return new Config[i];
        }
    }

    public static /* synthetic */ Config copy$default(Config config, String str, String str2, String str3, boolean z, Style style, int i, Object obj) {
        if ((i & 1) != 0) {
            str = config.processId;
        }
        if ((i & 2) != 0) {
            str2 = config.host;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = config.authToken;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            z = config.confirmationHelpActionVisible;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            style = config.style;
        }
        return config.copy(str, str4, str5, z2, style);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProcessId() {
        return this.processId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAuthToken() {
        return this.authToken;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getConfirmationHelpActionVisible() {
        return this.confirmationHelpActionVisible;
    }

    /* renamed from: component5, reason: from getter */
    public final Style getStyle() {
        return this.style;
    }

    public final Config copy(String processId, String host, String authToken, boolean confirmationHelpActionVisible, Style style) {
        Intrinsics.checkNotNullParameter(processId, "processId");
        Intrinsics.checkNotNullParameter(host, "host");
        return new Config(processId, host, authToken, confirmationHelpActionVisible, style);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Config)) {
            return false;
        }
        Config config = (Config) other;
        return Intrinsics.areEqual(this.processId, config.processId) && Intrinsics.areEqual(this.host, config.host) && Intrinsics.areEqual(this.authToken, config.authToken) && this.confirmationHelpActionVisible == config.confirmationHelpActionVisible && Intrinsics.areEqual(this.style, config.style);
    }

    public int hashCode() {
        int iHashCode = ((this.processId.hashCode() * 31) + this.host.hashCode()) * 31;
        String str = this.authToken;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.confirmationHelpActionVisible)) * 31;
        Style style = this.style;
        return iHashCode2 + (style != null ? style.hashCode() : 0);
    }

    public String toString() {
        return "Config(processId=" + this.processId + ", host=" + this.host + ", authToken=" + this.authToken + ", confirmationHelpActionVisible=" + this.confirmationHelpActionVisible + ", style=" + this.style + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.processId);
        parcel.writeString(this.host);
        parcel.writeString(this.authToken);
        parcel.writeInt(this.confirmationHelpActionVisible ? 1 : 0);
        Style style = this.style;
        if (style == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            style.writeToParcel(parcel, flags);
        }
    }

    public Config(String processId, String host, String str, boolean z, Style style) {
        Intrinsics.checkNotNullParameter(processId, "processId");
        Intrinsics.checkNotNullParameter(host, "host");
        this.processId = processId;
        this.host = host;
        this.authToken = str;
        this.confirmationHelpActionVisible = z;
        this.style = style;
    }

    public /* synthetic */ Config(String str, String str2, String str3, boolean z, Style style, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? true : z, (i & 16) != 0 ? null : style);
    }

    public final String getProcessId() {
        return this.processId;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final boolean getConfirmationHelpActionVisible() {
        return this.confirmationHelpActionVisible;
    }

    public final Style getStyle() {
        return this.style;
    }
}
