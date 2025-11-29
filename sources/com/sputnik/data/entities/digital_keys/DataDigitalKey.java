package com.sputnik.data.entities.digital_keys;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.digital_keys.TypeDigitalKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataDigitalKey.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;", "Landroid/os/Parcelable;", "", "uuid", AppMeasurementSdk.ConditionalUserProperty.VALUE, "expTime", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUuid", "getValue", "getExpTime", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "getType", "()Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataDigitalKey implements Parcelable {
    public static final Parcelable.Creator<DataDigitalKey> CREATOR = new Creator();

    @SerializedName("exp_time")
    private final String expTime;

    @SerializedName("type")
    private final TypeDigitalKey type;

    @SerializedName("uuid")
    private final String uuid;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)
    private final String value;

    /* compiled from: DataDigitalKey.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataDigitalKey> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataDigitalKey createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataDigitalKey(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TypeDigitalKey.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataDigitalKey[] newArray(int i) {
            return new DataDigitalKey[i];
        }
    }

    public DataDigitalKey() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataDigitalKey)) {
            return false;
        }
        DataDigitalKey dataDigitalKey = (DataDigitalKey) other;
        return Intrinsics.areEqual(this.uuid, dataDigitalKey.uuid) && Intrinsics.areEqual(this.value, dataDigitalKey.value) && Intrinsics.areEqual(this.expTime, dataDigitalKey.expTime) && this.type == dataDigitalKey.type;
    }

    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.expTime;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        TypeDigitalKey typeDigitalKey = this.type;
        return iHashCode3 + (typeDigitalKey != null ? typeDigitalKey.hashCode() : 0);
    }

    public String toString() {
        return "DataDigitalKey(uuid=" + this.uuid + ", value=" + this.value + ", expTime=" + this.expTime + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uuid);
        parcel.writeString(this.value);
        parcel.writeString(this.expTime);
        TypeDigitalKey typeDigitalKey = this.type;
        if (typeDigitalKey == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(typeDigitalKey.name());
        }
    }

    public DataDigitalKey(String str, String str2, String str3, TypeDigitalKey typeDigitalKey) {
        this.uuid = str;
        this.value = str2;
        this.expTime = str3;
        this.type = typeDigitalKey;
    }

    public /* synthetic */ DataDigitalKey(String str, String str2, String str3, TypeDigitalKey typeDigitalKey, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : typeDigitalKey);
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getExpTime() {
        return this.expTime;
    }

    public final TypeDigitalKey getType() {
        return this.type;
    }
}
