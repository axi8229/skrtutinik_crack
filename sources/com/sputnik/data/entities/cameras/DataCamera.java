package com.sputnik.data.entities.cameras;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataCamera.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001:\u0001EBË\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\"\u0010\u001dJ \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b+\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b,\u0010\u001bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b-\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b.\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b/\u0010\u001bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b1\u00102R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010)\u001a\u0004\b3\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010)\u001a\u0004\b4\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00105\u001a\u0004\b6\u0010\u001dR\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000f\u00105\u001a\u0004\b7\u0010\u001dR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b8\u0010\u001bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u0011\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u00100\u001a\u0004\b<\u00102R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010@\u001a\u0004\bC\u0010BR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010@\u001a\u0004\bD\u0010B¨\u0006F"}, d2 = {"Lcom/sputnik/data/entities/cameras/DataCamera;", "Landroid/os/Parcelable;", "", "uuid", "streamUrl", "embed", "thumb", "previewUrl", "previewMp4", "", "intercom", "intercomUuid", "intercomSerial", "", "width", "height", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "order", "widget", "Lcom/sputnik/data/entities/cameras/DataCamera$DataExtraKeyReader;", "extraKeyReader", "subscriptionRequried", "mainScreen", "canOpen", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;ZLcom/sputnik/data/entities/cameras/DataCamera$DataExtraKeyReader;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUuid", "getStreamUrl", "getEmbed", "getThumb", "getPreviewUrl", "getPreviewMp4", "Z", "getIntercom", "()Z", "getIntercomUuid", "getIntercomSerial", "I", "getWidth", "getHeight", "getTitle", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "getWidget", "Lcom/sputnik/data/entities/cameras/DataCamera$DataExtraKeyReader;", "getExtraKeyReader", "()Lcom/sputnik/data/entities/cameras/DataCamera$DataExtraKeyReader;", "Ljava/lang/Boolean;", "getSubscriptionRequried", "()Ljava/lang/Boolean;", "getMainScreen", "getCanOpen", "DataExtraKeyReader", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataCamera implements Parcelable {
    public static final Parcelable.Creator<DataCamera> CREATOR = new Creator();

    @SerializedName("can_open")
    private final Boolean canOpen;
    private final String embed;

    @SerializedName("extra_key_reader")
    private final DataExtraKeyReader extraKeyReader;
    private final int height;
    private final boolean intercom;

    @SerializedName("device_serial")
    private final String intercomSerial;

    @SerializedName("device_uuid")
    private final String intercomUuid;

    @SerializedName("main_screen")
    private final Boolean mainScreen;
    private final Integer order;

    @SerializedName("preview_mp4")
    private final String previewMp4;

    @SerializedName("preview")
    private final String previewUrl;

    @SerializedName("stream_url")
    private final String streamUrl;

    @SerializedName("subscription_requried")
    private final Boolean subscriptionRequried;
    private final String thumb;
    private final String title;
    private final String uuid;
    private final boolean widget;
    private final int width;

    /* compiled from: DataCamera.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataCamera> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataCamera createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            String string9 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            boolean z2 = parcel.readInt() != 0;
            DataExtraKeyReader dataExtraKeyReaderCreateFromParcel = parcel.readInt() == 0 ? null : DataExtraKeyReader.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf3 = null;
            } else {
                boolValueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DataCamera(string, string2, string3, string4, string5, string6, z, string7, string8, i, i2, string9, numValueOf, z2, dataExtraKeyReaderCreateFromParcel, boolValueOf, boolValueOf2, boolValueOf3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataCamera[] newArray(int i) {
            return new DataCamera[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataCamera)) {
            return false;
        }
        DataCamera dataCamera = (DataCamera) other;
        return Intrinsics.areEqual(this.uuid, dataCamera.uuid) && Intrinsics.areEqual(this.streamUrl, dataCamera.streamUrl) && Intrinsics.areEqual(this.embed, dataCamera.embed) && Intrinsics.areEqual(this.thumb, dataCamera.thumb) && Intrinsics.areEqual(this.previewUrl, dataCamera.previewUrl) && Intrinsics.areEqual(this.previewMp4, dataCamera.previewMp4) && this.intercom == dataCamera.intercom && Intrinsics.areEqual(this.intercomUuid, dataCamera.intercomUuid) && Intrinsics.areEqual(this.intercomSerial, dataCamera.intercomSerial) && this.width == dataCamera.width && this.height == dataCamera.height && Intrinsics.areEqual(this.title, dataCamera.title) && Intrinsics.areEqual(this.order, dataCamera.order) && this.widget == dataCamera.widget && Intrinsics.areEqual(this.extraKeyReader, dataCamera.extraKeyReader) && Intrinsics.areEqual(this.subscriptionRequried, dataCamera.subscriptionRequried) && Intrinsics.areEqual(this.mainScreen, dataCamera.mainScreen) && Intrinsics.areEqual(this.canOpen, dataCamera.canOpen);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.uuid.hashCode() * 31;
        String str = this.streamUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.embed;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumb;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.previewUrl;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.previewMp4;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z = this.intercom;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode6 + i) * 31;
        String str6 = this.intercomUuid;
        int iHashCode7 = (i2 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.intercomSerial;
        int iHashCode8 = (((((((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + this.title.hashCode()) * 31;
        Integer num = this.order;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z2 = this.widget;
        int i3 = (iHashCode9 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        DataExtraKeyReader dataExtraKeyReader = this.extraKeyReader;
        int iHashCode10 = (i3 + (dataExtraKeyReader == null ? 0 : dataExtraKeyReader.hashCode())) * 31;
        Boolean bool = this.subscriptionRequried;
        int iHashCode11 = (iHashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.mainScreen;
        int iHashCode12 = (iHashCode11 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.canOpen;
        return iHashCode12 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "DataCamera(uuid=" + this.uuid + ", streamUrl=" + this.streamUrl + ", embed=" + this.embed + ", thumb=" + this.thumb + ", previewUrl=" + this.previewUrl + ", previewMp4=" + this.previewMp4 + ", intercom=" + this.intercom + ", intercomUuid=" + this.intercomUuid + ", intercomSerial=" + this.intercomSerial + ", width=" + this.width + ", height=" + this.height + ", title=" + this.title + ", order=" + this.order + ", widget=" + this.widget + ", extraKeyReader=" + this.extraKeyReader + ", subscriptionRequried=" + this.subscriptionRequried + ", mainScreen=" + this.mainScreen + ", canOpen=" + this.canOpen + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uuid);
        parcel.writeString(this.streamUrl);
        parcel.writeString(this.embed);
        parcel.writeString(this.thumb);
        parcel.writeString(this.previewUrl);
        parcel.writeString(this.previewMp4);
        parcel.writeInt(this.intercom ? 1 : 0);
        parcel.writeString(this.intercomUuid);
        parcel.writeString(this.intercomSerial);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.title);
        Integer num = this.order;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeInt(this.widget ? 1 : 0);
        DataExtraKeyReader dataExtraKeyReader = this.extraKeyReader;
        if (dataExtraKeyReader == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataExtraKeyReader.writeToParcel(parcel, flags);
        }
        Boolean bool = this.subscriptionRequried;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.mainScreen;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.canOpen;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
    }

    public DataCamera(String uuid, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i, int i2, String title, Integer num, boolean z2, DataExtraKeyReader dataExtraKeyReader, Boolean bool, Boolean bool2, Boolean bool3) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(title, "title");
        this.uuid = uuid;
        this.streamUrl = str;
        this.embed = str2;
        this.thumb = str3;
        this.previewUrl = str4;
        this.previewMp4 = str5;
        this.intercom = z;
        this.intercomUuid = str6;
        this.intercomSerial = str7;
        this.width = i;
        this.height = i2;
        this.title = title;
        this.order = num;
        this.widget = z2;
        this.extraKeyReader = dataExtraKeyReader;
        this.subscriptionRequried = bool;
        this.mainScreen = bool2;
        this.canOpen = bool3;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final String getPreviewMp4() {
        return this.previewMp4;
    }

    public final boolean getIntercom() {
        return this.intercom;
    }

    public final String getIntercomUuid() {
        return this.intercomUuid;
    }

    public final String getIntercomSerial() {
        return this.intercomSerial;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final boolean getWidget() {
        return this.widget;
    }

    public final DataExtraKeyReader getExtraKeyReader() {
        return this.extraKeyReader;
    }

    public final Boolean getSubscriptionRequried() {
        return this.subscriptionRequried;
    }

    public final Boolean getMainScreen() {
        return this.mainScreen;
    }

    public final Boolean getCanOpen() {
        return this.canOpen;
    }

    /* compiled from: DataCamera.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/sputnik/data/entities/cameras/DataCamera$DataExtraKeyReader;", "Landroid/os/Parcelable;", "", "kind", "alias", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getKind", "getAlias", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataExtraKeyReader implements Parcelable {
        public static final Parcelable.Creator<DataExtraKeyReader> CREATOR = new Creator();
        private final String alias;
        private final String kind;

        /* compiled from: DataCamera.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DataExtraKeyReader> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataExtraKeyReader createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DataExtraKeyReader(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataExtraKeyReader[] newArray(int i) {
                return new DataExtraKeyReader[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataExtraKeyReader)) {
                return false;
            }
            DataExtraKeyReader dataExtraKeyReader = (DataExtraKeyReader) other;
            return Intrinsics.areEqual(this.kind, dataExtraKeyReader.kind) && Intrinsics.areEqual(this.alias, dataExtraKeyReader.alias);
        }

        public int hashCode() {
            String str = this.kind;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.alias;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "DataExtraKeyReader(kind=" + this.kind + ", alias=" + this.alias + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.kind);
            parcel.writeString(this.alias);
        }

        public DataExtraKeyReader(String str, String str2) {
            this.kind = str;
            this.alias = str2;
        }

        public final String getKind() {
            return this.kind;
        }

        public final String getAlias() {
            return this.alias;
        }
    }
}
