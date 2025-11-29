package com.sputnik.data.entities.keys;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPhysicalKey.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000fJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b!\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\"\u0010\f¨\u0006#"}, d2 = {"Lcom/sputnik/data/entities/keys/DataPhysicalKey;", "Landroid/os/Parcelable;", "", "uuid", "hex", "", "blocked", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "createdAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUuid", "getHex", "Ljava/lang/Boolean;", "getBlocked", "()Ljava/lang/Boolean;", "getComment", "getCreatedAt", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPhysicalKey implements Parcelable {
    public static final Parcelable.Creator<DataPhysicalKey> CREATOR = new Creator();
    private final Boolean blocked;
    private final String comment;

    @SerializedName("created_at")
    private final String createdAt;
    private final String hex;
    private final String uuid;

    /* compiled from: DataPhysicalKey.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataPhysicalKey> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPhysicalKey createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DataPhysicalKey(string, string2, boolValueOf, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPhysicalKey[] newArray(int i) {
            return new DataPhysicalKey[i];
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
        if (!(other instanceof DataPhysicalKey)) {
            return false;
        }
        DataPhysicalKey dataPhysicalKey = (DataPhysicalKey) other;
        return Intrinsics.areEqual(this.uuid, dataPhysicalKey.uuid) && Intrinsics.areEqual(this.hex, dataPhysicalKey.hex) && Intrinsics.areEqual(this.blocked, dataPhysicalKey.blocked) && Intrinsics.areEqual(this.comment, dataPhysicalKey.comment) && Intrinsics.areEqual(this.createdAt, dataPhysicalKey.createdAt);
    }

    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hex;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.blocked;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.comment;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.createdAt;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DataPhysicalKey(uuid=" + this.uuid + ", hex=" + this.hex + ", blocked=" + this.blocked + ", comment=" + this.comment + ", createdAt=" + this.createdAt + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iBooleanValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uuid);
        parcel.writeString(this.hex);
        Boolean bool = this.blocked;
        if (bool == null) {
            iBooleanValue = 0;
        } else {
            parcel.writeInt(1);
            iBooleanValue = bool.booleanValue();
        }
        parcel.writeInt(iBooleanValue);
        parcel.writeString(this.comment);
        parcel.writeString(this.createdAt);
    }

    public DataPhysicalKey(String str, String str2, Boolean bool, String str3, String str4) {
        this.uuid = str;
        this.hex = str2;
        this.blocked = bool;
        this.comment = str3;
        this.createdAt = str4;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getHex() {
        return this.hex;
    }

    public final Boolean getBlocked() {
        return this.blocked;
    }

    public final String getComment() {
        return this.comment;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }
}
