package com.sputnik.data.entities.call;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.call.CallState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataCall.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b!\u0010\u000b¨\u0006\""}, d2 = {"Lcom/sputnik/data/entities/call/DataCall;", "Landroid/os/Parcelable;", "", "flatUuid", "acceptedBy", "Lcom/sputnik/domain/entities/call/CallState;", "state", "sipAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/call/CallState;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getFlatUuid", "getAcceptedBy", "Lcom/sputnik/domain/entities/call/CallState;", "getState", "()Lcom/sputnik/domain/entities/call/CallState;", "getSipAddress", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataCall implements Parcelable {
    public static final Parcelable.Creator<DataCall> CREATOR = new Creator();

    @SerializedName("accepted_by")
    private final String acceptedBy;

    @SerializedName("flat_uuid")
    private final String flatUuid;

    @SerializedName("sip_address")
    private final String sipAddress;
    private final CallState state;

    /* compiled from: DataCall.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataCall> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataCall createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataCall(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : CallState.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataCall[] newArray(int i) {
            return new DataCall[i];
        }
    }

    public DataCall() {
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
        if (!(other instanceof DataCall)) {
            return false;
        }
        DataCall dataCall = (DataCall) other;
        return Intrinsics.areEqual(this.flatUuid, dataCall.flatUuid) && Intrinsics.areEqual(this.acceptedBy, dataCall.acceptedBy) && this.state == dataCall.state && Intrinsics.areEqual(this.sipAddress, dataCall.sipAddress);
    }

    public int hashCode() {
        String str = this.flatUuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.acceptedBy;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        CallState callState = this.state;
        int iHashCode3 = (iHashCode2 + (callState == null ? 0 : callState.hashCode())) * 31;
        String str3 = this.sipAddress;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DataCall(flatUuid=" + this.flatUuid + ", acceptedBy=" + this.acceptedBy + ", state=" + this.state + ", sipAddress=" + this.sipAddress + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.flatUuid);
        parcel.writeString(this.acceptedBy);
        CallState callState = this.state;
        if (callState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(callState.name());
        }
        parcel.writeString(this.sipAddress);
    }

    public DataCall(String str, String str2, CallState callState, String str3) {
        this.flatUuid = str;
        this.acceptedBy = str2;
        this.state = callState;
        this.sipAddress = str3;
    }

    public /* synthetic */ DataCall(String str, String str2, CallState callState, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : callState, (i & 8) != 0 ? null : str3);
    }

    public final String getFlatUuid() {
        return this.flatUuid;
    }

    public final String getAcceptedBy() {
        return this.acceptedBy;
    }

    public final CallState getState() {
        return this.state;
    }

    public final String getSipAddress() {
        return this.sipAddress;
    }
}
