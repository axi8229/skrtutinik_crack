package com.sputnik.data.entities.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.auth.StateType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataConfirmResponse.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/sputnik/data/entities/auth/DataConfirmResponse;", "Landroid/os/Parcelable;", "Lcom/sputnik/domain/entities/auth/StateType;", "citizenState", "", "jwt", "<init>", "(Lcom/sputnik/domain/entities/auth/StateType;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/domain/entities/auth/StateType;", "getCitizenState", "()Lcom/sputnik/domain/entities/auth/StateType;", "Ljava/lang/String;", "getJwt", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataConfirmResponse implements Parcelable {
    public static final Parcelable.Creator<DataConfirmResponse> CREATOR = new Creator();

    @SerializedName("citizen_state")
    private final StateType citizenState;
    private final String jwt;

    /* compiled from: DataConfirmResponse.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataConfirmResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataConfirmResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataConfirmResponse(parcel.readInt() == 0 ? null : StateType.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataConfirmResponse[] newArray(int i) {
            return new DataConfirmResponse[i];
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
        if (!(other instanceof DataConfirmResponse)) {
            return false;
        }
        DataConfirmResponse dataConfirmResponse = (DataConfirmResponse) other;
        return this.citizenState == dataConfirmResponse.citizenState && Intrinsics.areEqual(this.jwt, dataConfirmResponse.jwt);
    }

    public int hashCode() {
        StateType stateType = this.citizenState;
        int iHashCode = (stateType == null ? 0 : stateType.hashCode()) * 31;
        String str = this.jwt;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DataConfirmResponse(citizenState=" + this.citizenState + ", jwt=" + this.jwt + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        StateType stateType = this.citizenState;
        if (stateType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(stateType.name());
        }
        parcel.writeString(this.jwt);
    }

    public DataConfirmResponse(StateType stateType, String str) {
        this.citizenState = stateType;
        this.jwt = str;
    }

    public final StateType getCitizenState() {
        return this.citizenState;
    }

    public final String getJwt() {
        return this.jwt;
    }
}
