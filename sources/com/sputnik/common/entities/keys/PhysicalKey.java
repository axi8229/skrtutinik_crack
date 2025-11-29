package com.sputnik.common.entities.keys;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PhysicalKey.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0010J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\fR$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001c\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/sputnik/common/entities/keys/PhysicalKey;", "Landroid/os/Parcelable;", "", "uuid", "createdAt", "hex", "", "blocked", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getFormattedHex", "()Ljava/lang/String;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUuid", "getCreatedAt", "getHex", "Ljava/lang/Boolean;", "getBlocked", "()Ljava/lang/Boolean;", "setBlocked", "(Ljava/lang/Boolean;)V", "getComment", "setComment", "(Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PhysicalKey implements Parcelable {
    public static final Parcelable.Creator<PhysicalKey> CREATOR = new Creator();
    private Boolean blocked;
    private String comment;
    private final String createdAt;
    private final String hex;
    private final String uuid;

    /* compiled from: PhysicalKey.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhysicalKey> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhysicalKey createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new PhysicalKey(string, string2, string3, boolValueOf, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhysicalKey[] newArray(int i) {
            return new PhysicalKey[i];
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
        if (!(other instanceof PhysicalKey)) {
            return false;
        }
        PhysicalKey physicalKey = (PhysicalKey) other;
        return Intrinsics.areEqual(this.uuid, physicalKey.uuid) && Intrinsics.areEqual(this.createdAt, physicalKey.createdAt) && Intrinsics.areEqual(this.hex, physicalKey.hex) && Intrinsics.areEqual(this.blocked, physicalKey.blocked) && Intrinsics.areEqual(this.comment, physicalKey.comment);
    }

    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.createdAt;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.hex;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.blocked;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.comment;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "PhysicalKey(uuid=" + this.uuid + ", createdAt=" + this.createdAt + ", hex=" + this.hex + ", blocked=" + this.blocked + ", comment=" + this.comment + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iBooleanValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uuid);
        parcel.writeString(this.createdAt);
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
    }

    public PhysicalKey(String str, String str2, String str3, Boolean bool, String str4) {
        this.uuid = str;
        this.createdAt = str2;
        this.hex = str3;
        this.blocked = bool;
        this.comment = str4;
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

    public final void setBlocked(Boolean bool) {
        this.blocked = bool;
    }

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(String str) {
        this.comment = str;
    }

    public final String getFormattedHex() {
        List<String> listChunked;
        String strJoinToString$default;
        String str = this.hex;
        return (str == null || (listChunked = StringsKt.chunked(str, 4)) == null || (strJoinToString$default = CollectionsKt.joinToString$default(listChunked, " ", null, null, 0, null, null, 62, null)) == null) ? "" : strJoinToString$default;
    }
}
