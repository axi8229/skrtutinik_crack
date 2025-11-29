package com.sputnik.data.entities.invites;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFamilyInvites.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001:\u0002!\"B!\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/sputnik/data/entities/invites/DataFamilyInvites;", "Landroid/os/Parcelable;", "", "Lcom/sputnik/data/entities/invites/DataFamilyInvite;", "invites", "Lcom/sputnik/data/entities/invites/DataFamilyInvites$DataMeta;", "meta", "<init>", "(Ljava/util/List;Lcom/sputnik/data/entities/invites/DataFamilyInvites$DataMeta;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getInvites", "()Ljava/util/List;", "Lcom/sputnik/data/entities/invites/DataFamilyInvites$DataMeta;", "getMeta", "()Lcom/sputnik/data/entities/invites/DataFamilyInvites$DataMeta;", "DataInviteLimits", "DataMeta", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataFamilyInvites implements Parcelable {
    public static final Parcelable.Creator<DataFamilyInvites> CREATOR = new Creator();
    private final List<DataFamilyInvite> invites;
    private final DataMeta meta;

    /* compiled from: DataFamilyInvites.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataFamilyInvites> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataFamilyInvites createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(DataFamilyInvite.CREATOR.createFromParcel(parcel));
                }
            }
            return new DataFamilyInvites(arrayList, parcel.readInt() != 0 ? DataMeta.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataFamilyInvites[] newArray(int i) {
            return new DataFamilyInvites[i];
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
        if (!(other instanceof DataFamilyInvites)) {
            return false;
        }
        DataFamilyInvites dataFamilyInvites = (DataFamilyInvites) other;
        return Intrinsics.areEqual(this.invites, dataFamilyInvites.invites) && Intrinsics.areEqual(this.meta, dataFamilyInvites.meta);
    }

    public int hashCode() {
        List<DataFamilyInvite> list = this.invites;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        DataMeta dataMeta = this.meta;
        return iHashCode + (dataMeta != null ? dataMeta.hashCode() : 0);
    }

    public String toString() {
        return "DataFamilyInvites(invites=" + this.invites + ", meta=" + this.meta + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<DataFamilyInvite> list = this.invites;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<DataFamilyInvite> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        DataMeta dataMeta = this.meta;
        if (dataMeta == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataMeta.writeToParcel(parcel, flags);
        }
    }

    public DataFamilyInvites(List<DataFamilyInvite> list, DataMeta dataMeta) {
        this.invites = list;
        this.meta = dataMeta;
    }

    public final List<DataFamilyInvite> getInvites() {
        return this.invites;
    }

    public final DataMeta getMeta() {
        return this.meta;
    }

    /* compiled from: DataFamilyInvites.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/sputnik/data/entities/invites/DataFamilyInvites$DataMeta;", "Landroid/os/Parcelable;", "Lcom/sputnik/data/entities/invites/DataFamilyInvites$DataInviteLimits;", "inviteLimits", "<init>", "(Lcom/sputnik/data/entities/invites/DataFamilyInvites$DataInviteLimits;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/data/entities/invites/DataFamilyInvites$DataInviteLimits;", "getInviteLimits", "()Lcom/sputnik/data/entities/invites/DataFamilyInvites$DataInviteLimits;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMeta implements Parcelable {
        public static final Parcelable.Creator<DataMeta> CREATOR = new Creator();

        @SerializedName("invite_limits")
        private final DataInviteLimits inviteLimits;

        /* compiled from: DataFamilyInvites.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DataMeta> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataMeta createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DataMeta(parcel.readInt() == 0 ? null : DataInviteLimits.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataMeta[] newArray(int i) {
                return new DataMeta[i];
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
            return (other instanceof DataMeta) && Intrinsics.areEqual(this.inviteLimits, ((DataMeta) other).inviteLimits);
        }

        public int hashCode() {
            DataInviteLimits dataInviteLimits = this.inviteLimits;
            if (dataInviteLimits == null) {
                return 0;
            }
            return dataInviteLimits.hashCode();
        }

        public String toString() {
            return "DataMeta(inviteLimits=" + this.inviteLimits + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            DataInviteLimits dataInviteLimits = this.inviteLimits;
            if (dataInviteLimits == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                dataInviteLimits.writeToParcel(parcel, flags);
            }
        }

        public DataMeta(DataInviteLimits dataInviteLimits) {
            this.inviteLimits = dataInviteLimits;
        }

        public final DataInviteLimits getInviteLimits() {
            return this.inviteLimits;
        }
    }

    /* compiled from: DataFamilyInvites.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/sputnik/data/entities/invites/DataFamilyInvites$DataInviteLimits;", "Landroid/os/Parcelable;", "", "total", "used", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getTotal", "()Ljava/lang/Integer;", "getUsed", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataInviteLimits implements Parcelable {
        public static final Parcelable.Creator<DataInviteLimits> CREATOR = new Creator();
        private final Integer total;
        private final Integer used;

        /* compiled from: DataFamilyInvites.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DataInviteLimits> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataInviteLimits createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DataInviteLimits(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DataInviteLimits[] newArray(int i) {
                return new DataInviteLimits[i];
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
            if (!(other instanceof DataInviteLimits)) {
                return false;
            }
            DataInviteLimits dataInviteLimits = (DataInviteLimits) other;
            return Intrinsics.areEqual(this.total, dataInviteLimits.total) && Intrinsics.areEqual(this.used, dataInviteLimits.used);
        }

        public int hashCode() {
            Integer num = this.total;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.used;
            return iHashCode + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "DataInviteLimits(total=" + this.total + ", used=" + this.used + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Integer num = this.total;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            Integer num2 = this.used;
            if (num2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num2.intValue());
            }
        }

        public DataInviteLimits(Integer num, Integer num2) {
            this.total = num;
            this.used = num2;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final Integer getUsed() {
            return this.used;
        }
    }
}
