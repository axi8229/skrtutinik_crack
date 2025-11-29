package com.sputnik.common.entities.archive;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: Flussonic.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b#\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b$\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b%\u0010\u000fR\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010 ¨\u0006'"}, d2 = {"Lcom/sputnik/common/entities/archive/Flussonic;", "Landroid/os/Parcelable;", "", "domain", "sdkUrl", "cameraUUID", "archiveToken", "deviceUUID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", RemoteMessageConst.FROM, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "getDownloadUrl", "(JJ)Ljava/lang/String;", "()Ljava/lang/String;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDomain", "getSdkUrl", "getCameraUUID", "getArchiveToken", "getDeviceUUID", "lastDownloadUrl", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Flussonic implements Parcelable {
    public static final Parcelable.Creator<Flussonic> CREATOR = new Creator();
    private final String archiveToken;
    private final String cameraUUID;
    private final String deviceUUID;
    private final String domain;
    private String lastDownloadUrl;
    private final String sdkUrl;

    /* compiled from: Flussonic.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Flussonic> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Flussonic createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Flussonic(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Flussonic[] newArray(int i) {
            return new Flussonic[i];
        }
    }

    public Flussonic() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Flussonic)) {
            return false;
        }
        Flussonic flussonic2 = (Flussonic) other;
        return Intrinsics.areEqual(this.domain, flussonic2.domain) && Intrinsics.areEqual(this.sdkUrl, flussonic2.sdkUrl) && Intrinsics.areEqual(this.cameraUUID, flussonic2.cameraUUID) && Intrinsics.areEqual(this.archiveToken, flussonic2.archiveToken) && Intrinsics.areEqual(this.deviceUUID, flussonic2.deviceUUID);
    }

    public int hashCode() {
        String str = this.domain;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sdkUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cameraUUID;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.archiveToken;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.deviceUUID;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "Flussonic(domain=" + this.domain + ", sdkUrl=" + this.sdkUrl + ", cameraUUID=" + this.cameraUUID + ", archiveToken=" + this.archiveToken + ", deviceUUID=" + this.deviceUUID + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.domain);
        parcel.writeString(this.sdkUrl);
        parcel.writeString(this.cameraUUID);
        parcel.writeString(this.archiveToken);
        parcel.writeString(this.deviceUUID);
    }

    public Flussonic(String str, String str2, String str3, String str4, String str5) {
        this.domain = str;
        this.sdkUrl = str2;
        this.cameraUUID = str3;
        this.archiveToken = str4;
        this.deviceUUID = str5;
    }

    public /* synthetic */ Flussonic(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getSdkUrl() {
        return this.sdkUrl;
    }

    public final String getDownloadUrl(long from, long duration) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "https://%s/%s/archive-%s-%s.mp4?token=%s", Arrays.copyOf(new Object[]{this.domain, this.cameraUUID, Long.valueOf(from), Long.valueOf(duration), this.archiveToken}, 5));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this.lastDownloadUrl = str;
        Intrinsics.checkNotNull(str);
        return str;
    }

    /* renamed from: getDownloadUrl, reason: from getter */
    public final String getLastDownloadUrl() {
        return this.lastDownloadUrl;
    }
}
