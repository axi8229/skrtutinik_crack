package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b#\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b$\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b%\u0010\r¨\u0006&"}, d2 = {"Lcom/sputnik/common/entities/localization/DomofonSettingsBody;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "Lcom/sputnik/common/entities/localization/DomofonSwitch;", "switch", "headerCalls", "headerVideo", "switchWebrtc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/DomofonSwitch;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "Lcom/sputnik/common/entities/localization/DomofonSwitch;", "getSwitch", "()Lcom/sputnik/common/entities/localization/DomofonSwitch;", "getHeaderCalls", "getHeaderVideo", "getSwitchWebrtc", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomofonSettingsBody implements Parcelable {
    public static final Parcelable.Creator<DomofonSettingsBody> CREATOR = new Creator();

    @SerializedName("header_calls")
    private final String headerCalls;

    @SerializedName("header_video")
    private final String headerVideo;
    private final String subtitle;
    private final DomofonSwitch switch;

    @SerializedName("switch_webrtc")
    private final String switchWebrtc;
    private final String title;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DomofonSettingsBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DomofonSettingsBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DomofonSettingsBody(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : DomofonSwitch.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DomofonSettingsBody[] newArray(int i) {
            return new DomofonSettingsBody[i];
        }
    }

    public DomofonSettingsBody() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomofonSettingsBody)) {
            return false;
        }
        DomofonSettingsBody domofonSettingsBody = (DomofonSettingsBody) other;
        return Intrinsics.areEqual(this.title, domofonSettingsBody.title) && Intrinsics.areEqual(this.subtitle, domofonSettingsBody.subtitle) && Intrinsics.areEqual(this.switch, domofonSettingsBody.switch) && Intrinsics.areEqual(this.headerCalls, domofonSettingsBody.headerCalls) && Intrinsics.areEqual(this.headerVideo, domofonSettingsBody.headerVideo) && Intrinsics.areEqual(this.switchWebrtc, domofonSettingsBody.switchWebrtc);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subtitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        DomofonSwitch domofonSwitch = this.switch;
        int iHashCode3 = (iHashCode2 + (domofonSwitch == null ? 0 : domofonSwitch.hashCode())) * 31;
        String str3 = this.headerCalls;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.headerVideo;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.switchWebrtc;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DomofonSettingsBody(title=" + this.title + ", subtitle=" + this.subtitle + ", switch=" + this.switch + ", headerCalls=" + this.headerCalls + ", headerVideo=" + this.headerVideo + ", switchWebrtc=" + this.switchWebrtc + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        DomofonSwitch domofonSwitch = this.switch;
        if (domofonSwitch == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            domofonSwitch.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.headerCalls);
        parcel.writeString(this.headerVideo);
        parcel.writeString(this.switchWebrtc);
    }

    public DomofonSettingsBody(String str, String str2, DomofonSwitch domofonSwitch, String str3, String str4, String str5) {
        this.title = str;
        this.subtitle = str2;
        this.switch = domofonSwitch;
        this.headerCalls = str3;
        this.headerVideo = str4;
        this.switchWebrtc = str5;
    }

    public /* synthetic */ DomofonSettingsBody(String str, String str2, DomofonSwitch domofonSwitch, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : domofonSwitch, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final DomofonSwitch getSwitch() {
        return this.switch;
    }

    public final String getHeaderCalls() {
        return this.headerCalls;
    }

    public final String getHeaderVideo() {
        return this.headerVideo;
    }

    public final String getSwitchWebrtc() {
        return this.switchWebrtc;
    }
}
