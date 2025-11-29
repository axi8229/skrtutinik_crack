package com.sputnik.data.entities.subscriptions.services;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.data.entities.subscriptions.subscriptions.DataBadge;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataServiceAppearance.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/services/DataServiceAppearance;", "Landroid/os/Parcelable;", "", "description", "finale", "link", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBadge;", "badge", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBadge;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "getFinale", "getLink", "getTitle", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBadge;", "getBadge", "()Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBadge;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataServiceAppearance implements Parcelable {
    public static final Parcelable.Creator<DataServiceAppearance> CREATOR = new Creator();
    private final DataBadge badge;
    private final String description;
    private final String finale;
    private final String link;
    private final String title;

    /* compiled from: DataServiceAppearance.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataServiceAppearance> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataServiceAppearance createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataServiceAppearance(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : DataBadge.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataServiceAppearance[] newArray(int i) {
            return new DataServiceAppearance[i];
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
        if (!(other instanceof DataServiceAppearance)) {
            return false;
        }
        DataServiceAppearance dataServiceAppearance = (DataServiceAppearance) other;
        return Intrinsics.areEqual(this.description, dataServiceAppearance.description) && Intrinsics.areEqual(this.finale, dataServiceAppearance.finale) && Intrinsics.areEqual(this.link, dataServiceAppearance.link) && Intrinsics.areEqual(this.title, dataServiceAppearance.title) && Intrinsics.areEqual(this.badge, dataServiceAppearance.badge);
    }

    public int hashCode() {
        String str = this.description;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.finale;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.link;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        DataBadge dataBadge = this.badge;
        return iHashCode4 + (dataBadge != null ? dataBadge.hashCode() : 0);
    }

    public String toString() {
        return "DataServiceAppearance(description=" + this.description + ", finale=" + this.finale + ", link=" + this.link + ", title=" + this.title + ", badge=" + this.badge + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.description);
        parcel.writeString(this.finale);
        parcel.writeString(this.link);
        parcel.writeString(this.title);
        DataBadge dataBadge = this.badge;
        if (dataBadge == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataBadge.writeToParcel(parcel, flags);
        }
    }

    public DataServiceAppearance(String str, String str2, String str3, String str4, DataBadge dataBadge) {
        this.description = str;
        this.finale = str2;
        this.link = str3;
        this.title = str4;
        this.badge = dataBadge;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFinale() {
        return this.finale;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getTitle() {
        return this.title;
    }

    public final DataBadge getBadge() {
        return this.badge;
    }
}
