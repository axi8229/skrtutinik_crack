package com.sputnik.data.entities.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.domain.entities.auth.StateType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataConfirm.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/sputnik/data/entities/auth/DataConfirm;", "Landroid/os/Parcelable;", "Lcom/sputnik/domain/entities/auth/StateType;", "state", "", "jwt", "<init>", "(Lcom/sputnik/domain/entities/auth/StateType;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/domain/entities/auth/StateType;", "getState", "()Lcom/sputnik/domain/entities/auth/StateType;", "Ljava/lang/String;", "getJwt", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataConfirm implements Parcelable {
    public static final Parcelable.Creator<DataConfirm> CREATOR = new Creator();
    private final String jwt;
    private final StateType state;

    /* compiled from: DataConfirm.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataConfirm> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataConfirm createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataConfirm(StateType.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataConfirm[] newArray(int i) {
            return new DataConfirm[i];
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
        if (!(other instanceof DataConfirm)) {
            return false;
        }
        DataConfirm dataConfirm = (DataConfirm) other;
        return this.state == dataConfirm.state && Intrinsics.areEqual(this.jwt, dataConfirm.jwt);
    }

    public int hashCode() {
        int iHashCode = this.state.hashCode() * 31;
        String str = this.jwt;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DataConfirm(state=" + this.state + ", jwt=" + this.jwt + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.state.name());
        parcel.writeString(this.jwt);
    }

    public DataConfirm(StateType state, String str) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.jwt = str;
    }

    public final StateType getState() {
        return this.state;
    }

    public final String getJwt() {
        return this.jwt;
    }
}
