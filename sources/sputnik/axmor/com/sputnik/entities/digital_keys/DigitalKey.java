package sputnik.axmor.com.sputnik.entities.digital_keys;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.domain.entities.digital_keys.TypeDigitalKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalKey.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lsputnik/axmor/com/sputnik/entities/digital_keys/DigitalKey;", "Landroid/os/Parcelable;", "", "uuid", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "expTime", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUuid", "getValue", "Ljava/lang/Long;", "getExpTime", "()Ljava/lang/Long;", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "getType", "()Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DigitalKey implements Parcelable {
    public static final Parcelable.Creator<DigitalKey> CREATOR = new Creator();
    private final Long expTime;
    private final TypeDigitalKey type;
    private final String uuid;
    private final String value;

    /* compiled from: DigitalKey.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DigitalKey> {
        @Override // android.os.Parcelable.Creator
        public final DigitalKey createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DigitalKey(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0 ? TypeDigitalKey.valueOf(parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final DigitalKey[] newArray(int i) {
            return new DigitalKey[i];
        }
    }

    public DigitalKey() {
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
        if (!(other instanceof DigitalKey)) {
            return false;
        }
        DigitalKey digitalKey = (DigitalKey) other;
        return Intrinsics.areEqual(this.uuid, digitalKey.uuid) && Intrinsics.areEqual(this.value, digitalKey.value) && Intrinsics.areEqual(this.expTime, digitalKey.expTime) && this.type == digitalKey.type;
    }

    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.expTime;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        TypeDigitalKey typeDigitalKey = this.type;
        return iHashCode3 + (typeDigitalKey != null ? typeDigitalKey.hashCode() : 0);
    }

    public String toString() {
        return "DigitalKey(uuid=" + this.uuid + ", value=" + this.value + ", expTime=" + this.expTime + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uuid);
        parcel.writeString(this.value);
        Long l = this.expTime;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        TypeDigitalKey typeDigitalKey = this.type;
        if (typeDigitalKey == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(typeDigitalKey.name());
        }
    }

    public DigitalKey(String str, String str2, Long l, TypeDigitalKey typeDigitalKey) {
        this.uuid = str;
        this.value = str2;
        this.expTime = l;
        this.type = typeDigitalKey;
    }

    public /* synthetic */ DigitalKey(String str, String str2, Long l, TypeDigitalKey typeDigitalKey, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : typeDigitalKey);
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getValue() {
        return this.value;
    }

    public final Long getExpTime() {
        return this.expTime;
    }
}
