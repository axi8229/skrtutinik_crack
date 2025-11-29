package com.sputnik.common.entities.camera;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.common.entities.archive.Flussonic;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Camera.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b1\b\u0087\b\u0018\u00002\u00020\u0001:\u0001]Bï\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0082\u0002\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b)\u0010$J \u0010.\u001a\u00020-2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00100\u001a\u0004\b1\u0010\"R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00100\u001a\u0004\b2\u0010\"R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b3\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b\u0007\u00105R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b6\u0010\"R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b7\u0010\"R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00108\u001a\u0004\b9\u0010$R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u00108\u001a\u0004\b:\u0010$R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00100\u001a\u0004\b;\u0010\"\"\u0004\b<\u0010=R$\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u00104\u001a\u0004\bC\u00105\"\u0004\bD\u0010ER$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00100\u001a\u0004\bF\u0010\"\"\u0004\bG\u0010=R\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u00104\u001a\u0004\b\u0011\u00105\"\u0004\bH\u0010ER\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00104\u001a\u0004\b\u0012\u00105\"\u0004\bI\u0010ER\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\bJ\u0010\"R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010P\u001a\u0004\bQ\u0010RR\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u00104\u001a\u0004\bS\u00105\"\u0004\bT\u0010ER$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010U\u001a\u0004\bZ\u0010WR\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u00104\u001a\u0004\b\u001b\u00105\"\u0004\b[\u0010ER\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00104\u001a\u0004\b\u001c\u00105\"\u0004\b\\\u0010E¨\u0006^"}, d2 = {"Lcom/sputnik/common/entities/camera/Camera;", "Landroid/os/Parcelable;", "", "uuid", "streamUrl", "previewUrl", "", "isIntercom", "intercomUuid", "intercomSerial", "", "width", "height", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "order", "widget", "address", "isLoadPhotoFailed", "isLoadVideoFailed", "transitionName", "Lcom/sputnik/common/entities/archive/Flussonic;", "flussonicData", "Lcom/sputnik/common/entities/camera/Camera$ExtraKeyReader;", "extraKeyReader", "mainScreen", "subscriptionRequried", "canOpen", "isLive", "isSelected", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZZLjava/lang/String;Lcom/sputnik/common/entities/archive/Flussonic;Lcom/sputnik/common/entities/camera/Camera$ExtraKeyReader;ZLjava/lang/Boolean;Ljava/lang/Boolean;ZZ)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZZLjava/lang/String;Lcom/sputnik/common/entities/archive/Flussonic;Lcom/sputnik/common/entities/camera/Camera$ExtraKeyReader;ZLjava/lang/Boolean;Ljava/lang/Boolean;ZZ)Lcom/sputnik/common/entities/camera/Camera;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUuid", "getStreamUrl", "getPreviewUrl", "Z", "()Z", "getIntercomUuid", "getIntercomSerial", "I", "getWidth", "getHeight", "getTitle", "setTitle", "(Ljava/lang/String;)V", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "setOrder", "(Ljava/lang/Integer;)V", "getWidget", "setWidget", "(Z)V", "getAddress", "setAddress", "setLoadPhotoFailed", "setLoadVideoFailed", "getTransitionName", "Lcom/sputnik/common/entities/archive/Flussonic;", "getFlussonicData", "()Lcom/sputnik/common/entities/archive/Flussonic;", "setFlussonicData", "(Lcom/sputnik/common/entities/archive/Flussonic;)V", "Lcom/sputnik/common/entities/camera/Camera$ExtraKeyReader;", "getExtraKeyReader", "()Lcom/sputnik/common/entities/camera/Camera$ExtraKeyReader;", "getMainScreen", "setMainScreen", "Ljava/lang/Boolean;", "getSubscriptionRequried", "()Ljava/lang/Boolean;", "setSubscriptionRequried", "(Ljava/lang/Boolean;)V", "getCanOpen", "setLive", "setSelected", "ExtraKeyReader", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Camera implements Parcelable {
    public static final Parcelable.Creator<Camera> CREATOR = new Creator();
    private String address;
    private final Boolean canOpen;
    private final ExtraKeyReader extraKeyReader;
    private Flussonic flussonicData;
    private final int height;
    private final String intercomSerial;
    private final String intercomUuid;
    private final boolean isIntercom;
    private boolean isLive;
    private boolean isLoadPhotoFailed;
    private boolean isLoadVideoFailed;
    private boolean isSelected;
    private boolean mainScreen;
    private Integer order;
    private final String previewUrl;
    private final String streamUrl;
    private Boolean subscriptionRequried;
    private String title;
    private final String transitionName;
    private final String uuid;
    private boolean widget;
    private final int width;

    /* compiled from: Camera.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Camera> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Camera createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            String string6 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            boolean z2 = parcel.readInt() != 0;
            String string7 = parcel.readString();
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            String string8 = parcel.readString();
            Flussonic flussonicCreateFromParcel = parcel.readInt() == 0 ? null : Flussonic.CREATOR.createFromParcel(parcel);
            ExtraKeyReader extraKeyReaderCreateFromParcel = parcel.readInt() == 0 ? null : ExtraKeyReader.CREATOR.createFromParcel(parcel);
            boolean z5 = parcel.readInt() != 0;
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
            return new Camera(string, string2, string3, z, string4, string5, i, i2, string6, numValueOf, z2, string7, z3, z4, string8, flussonicCreateFromParcel, extraKeyReaderCreateFromParcel, z5, boolValueOf, boolValueOf2, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Camera[] newArray(int i) {
            return new Camera[i];
        }
    }

    public final Camera copy(String uuid, String streamUrl, String previewUrl, boolean isIntercom, String intercomUuid, String intercomSerial, int width, int height, String title, Integer order, boolean widget, String address, boolean isLoadPhotoFailed, boolean isLoadVideoFailed, String transitionName, Flussonic flussonicData, ExtraKeyReader extraKeyReader, boolean mainScreen, Boolean subscriptionRequried, Boolean canOpen, boolean isLive, boolean isSelected) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(title, "title");
        return new Camera(uuid, streamUrl, previewUrl, isIntercom, intercomUuid, intercomSerial, width, height, title, order, widget, address, isLoadPhotoFailed, isLoadVideoFailed, transitionName, flussonicData, extraKeyReader, mainScreen, subscriptionRequried, canOpen, isLive, isSelected);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Camera)) {
            return false;
        }
        Camera camera = (Camera) other;
        return Intrinsics.areEqual(this.uuid, camera.uuid) && Intrinsics.areEqual(this.streamUrl, camera.streamUrl) && Intrinsics.areEqual(this.previewUrl, camera.previewUrl) && this.isIntercom == camera.isIntercom && Intrinsics.areEqual(this.intercomUuid, camera.intercomUuid) && Intrinsics.areEqual(this.intercomSerial, camera.intercomSerial) && this.width == camera.width && this.height == camera.height && Intrinsics.areEqual(this.title, camera.title) && Intrinsics.areEqual(this.order, camera.order) && this.widget == camera.widget && Intrinsics.areEqual(this.address, camera.address) && this.isLoadPhotoFailed == camera.isLoadPhotoFailed && this.isLoadVideoFailed == camera.isLoadVideoFailed && Intrinsics.areEqual(this.transitionName, camera.transitionName) && Intrinsics.areEqual(this.flussonicData, camera.flussonicData) && Intrinsics.areEqual(this.extraKeyReader, camera.extraKeyReader) && this.mainScreen == camera.mainScreen && Intrinsics.areEqual(this.subscriptionRequried, camera.subscriptionRequried) && Intrinsics.areEqual(this.canOpen, camera.canOpen) && this.isLive == camera.isLive && this.isSelected == camera.isSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.uuid.hashCode() * 31;
        String str = this.streamUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.previewUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.isIntercom;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        String str3 = this.intercomUuid;
        int iHashCode4 = (i2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.intercomSerial;
        int iHashCode5 = (((((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + this.title.hashCode()) * 31;
        Integer num = this.order;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z2 = this.widget;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (iHashCode6 + i3) * 31;
        String str5 = this.address;
        int iHashCode7 = (i4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z3 = this.isLoadPhotoFailed;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (iHashCode7 + i5) * 31;
        boolean z4 = this.isLoadVideoFailed;
        int i7 = z4;
        if (z4 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        String str6 = this.transitionName;
        int iHashCode8 = (i8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Flussonic flussonic2 = this.flussonicData;
        int iHashCode9 = (iHashCode8 + (flussonic2 == null ? 0 : flussonic2.hashCode())) * 31;
        ExtraKeyReader extraKeyReader = this.extraKeyReader;
        int iHashCode10 = (iHashCode9 + (extraKeyReader == null ? 0 : extraKeyReader.hashCode())) * 31;
        boolean z5 = this.mainScreen;
        int i9 = z5;
        if (z5 != 0) {
            i9 = 1;
        }
        int i10 = (iHashCode10 + i9) * 31;
        Boolean bool = this.subscriptionRequried;
        int iHashCode11 = (i10 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.canOpen;
        int iHashCode12 = (iHashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        boolean z6 = this.isLive;
        int i11 = z6;
        if (z6 != 0) {
            i11 = 1;
        }
        int i12 = (iHashCode12 + i11) * 31;
        boolean z7 = this.isSelected;
        return i12 + (z7 ? 1 : z7 ? 1 : 0);
    }

    public String toString() {
        return "Camera(uuid=" + this.uuid + ", streamUrl=" + this.streamUrl + ", previewUrl=" + this.previewUrl + ", isIntercom=" + this.isIntercom + ", intercomUuid=" + this.intercomUuid + ", intercomSerial=" + this.intercomSerial + ", width=" + this.width + ", height=" + this.height + ", title=" + this.title + ", order=" + this.order + ", widget=" + this.widget + ", address=" + this.address + ", isLoadPhotoFailed=" + this.isLoadPhotoFailed + ", isLoadVideoFailed=" + this.isLoadVideoFailed + ", transitionName=" + this.transitionName + ", flussonicData=" + this.flussonicData + ", extraKeyReader=" + this.extraKeyReader + ", mainScreen=" + this.mainScreen + ", subscriptionRequried=" + this.subscriptionRequried + ", canOpen=" + this.canOpen + ", isLive=" + this.isLive + ", isSelected=" + this.isSelected + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uuid);
        parcel.writeString(this.streamUrl);
        parcel.writeString(this.previewUrl);
        parcel.writeInt(this.isIntercom ? 1 : 0);
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
        parcel.writeString(this.address);
        parcel.writeInt(this.isLoadPhotoFailed ? 1 : 0);
        parcel.writeInt(this.isLoadVideoFailed ? 1 : 0);
        parcel.writeString(this.transitionName);
        Flussonic flussonic2 = this.flussonicData;
        if (flussonic2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            flussonic2.writeToParcel(parcel, flags);
        }
        ExtraKeyReader extraKeyReader = this.extraKeyReader;
        if (extraKeyReader == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            extraKeyReader.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.mainScreen ? 1 : 0);
        Boolean bool = this.subscriptionRequried;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.canOpen;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        parcel.writeInt(this.isLive ? 1 : 0);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public Camera(String uuid, String str, String str2, boolean z, String str3, String str4, int i, int i2, String title, Integer num, boolean z2, String str5, boolean z3, boolean z4, String str6, Flussonic flussonic2, ExtraKeyReader extraKeyReader, boolean z5, Boolean bool, Boolean bool2, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(title, "title");
        this.uuid = uuid;
        this.streamUrl = str;
        this.previewUrl = str2;
        this.isIntercom = z;
        this.intercomUuid = str3;
        this.intercomSerial = str4;
        this.width = i;
        this.height = i2;
        this.title = title;
        this.order = num;
        this.widget = z2;
        this.address = str5;
        this.isLoadPhotoFailed = z3;
        this.isLoadVideoFailed = z4;
        this.transitionName = str6;
        this.flussonicData = flussonic2;
        this.extraKeyReader = extraKeyReader;
        this.mainScreen = z5;
        this.subscriptionRequried = bool;
        this.canOpen = bool2;
        this.isLive = z6;
        this.isSelected = z7;
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

    /* renamed from: isIntercom, reason: from getter */
    public final boolean getIsIntercom() {
        return this.isIntercom;
    }

    public final String getIntercomUuid() {
        return this.intercomUuid;
    }

    public final String getIntercomSerial() {
        return this.intercomSerial;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public /* synthetic */ Camera(String str, String str2, String str3, boolean z, String str4, String str5, int i, int i2, String str6, Integer num, boolean z2, String str7, boolean z3, boolean z4, String str8, Flussonic flussonic2, ExtraKeyReader extraKeyReader, boolean z5, Boolean bool, Boolean bool2, boolean z6, boolean z7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5, i, i2, str6, (i3 & 512) != 0 ? 0 : num, (i3 & 1024) != 0 ? false : z2, (i3 & 2048) != 0 ? null : str7, (i3 & 4096) != 0 ? false : z3, (i3 & 8192) != 0 ? false : z4, (i3 & 16384) != 0 ? null : str8, (32768 & i3) != 0 ? null : flussonic2, extraKeyReader, (131072 & i3) != 0 ? false : z5, (262144 & i3) != 0 ? Boolean.FALSE : bool, (524288 & i3) != 0 ? Boolean.FALSE : bool2, (1048576 & i3) != 0 ? false : z6, (i3 & 2097152) != 0 ? false : z7);
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final void setOrder(Integer num) {
        this.order = num;
    }

    public final boolean getWidget() {
        return this.widget;
    }

    public final void setWidget(boolean z) {
        this.widget = z;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    /* renamed from: isLoadPhotoFailed, reason: from getter */
    public final boolean getIsLoadPhotoFailed() {
        return this.isLoadPhotoFailed;
    }

    public final void setLoadPhotoFailed(boolean z) {
        this.isLoadPhotoFailed = z;
    }

    /* renamed from: isLoadVideoFailed, reason: from getter */
    public final boolean getIsLoadVideoFailed() {
        return this.isLoadVideoFailed;
    }

    public final void setLoadVideoFailed(boolean z) {
        this.isLoadVideoFailed = z;
    }

    public final String getTransitionName() {
        return this.transitionName;
    }

    public final Flussonic getFlussonicData() {
        return this.flussonicData;
    }

    public final void setFlussonicData(Flussonic flussonic2) {
        this.flussonicData = flussonic2;
    }

    public final ExtraKeyReader getExtraKeyReader() {
        return this.extraKeyReader;
    }

    public final boolean getMainScreen() {
        return this.mainScreen;
    }

    public final void setMainScreen(boolean z) {
        this.mainScreen = z;
    }

    public final Boolean getSubscriptionRequried() {
        return this.subscriptionRequried;
    }

    public final Boolean getCanOpen() {
        return this.canOpen;
    }

    /* renamed from: isLive, reason: from getter */
    public final boolean getIsLive() {
        return this.isLive;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    /* compiled from: Camera.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/camera/Camera$ExtraKeyReader;", "Landroid/os/Parcelable;", "", "kind", "alias", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getKind", "getAlias", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ExtraKeyReader implements Parcelable {
        public static final Parcelable.Creator<ExtraKeyReader> CREATOR = new Creator();
        private final String alias;
        private final String kind;

        /* compiled from: Camera.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ExtraKeyReader> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ExtraKeyReader createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ExtraKeyReader(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ExtraKeyReader[] newArray(int i) {
                return new ExtraKeyReader[i];
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
            if (!(other instanceof ExtraKeyReader)) {
                return false;
            }
            ExtraKeyReader extraKeyReader = (ExtraKeyReader) other;
            return Intrinsics.areEqual(this.kind, extraKeyReader.kind) && Intrinsics.areEqual(this.alias, extraKeyReader.alias);
        }

        public int hashCode() {
            String str = this.kind;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.alias;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ExtraKeyReader(kind=" + this.kind + ", alias=" + this.alias + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.kind);
            parcel.writeString(this.alias);
        }

        public ExtraKeyReader(String str, String str2) {
            this.kind = str;
            this.alias = str2;
        }

        public final String getAlias() {
            return this.alias;
        }
    }
}
