package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b \u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b!\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\"\u0010\rR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b#\u0010\rR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b$\u0010\r¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/CommonDaysShort;", "Landroid/os/Parcelable;", "", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMonday", "getTuesday", "getWednesday", "getThursday", "getFriday", "getSaturday", "getSunday", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CommonDaysShort implements Parcelable {
    public static final Parcelable.Creator<CommonDaysShort> CREATOR = new Creator();
    private final String friday;
    private final String monday;
    private final String saturday;
    private final String sunday;
    private final String thursday;
    private final String tuesday;
    private final String wednesday;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommonDaysShort> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonDaysShort createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonDaysShort(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonDaysShort[] newArray(int i) {
            return new CommonDaysShort[i];
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
        if (!(other instanceof CommonDaysShort)) {
            return false;
        }
        CommonDaysShort commonDaysShort = (CommonDaysShort) other;
        return Intrinsics.areEqual(this.monday, commonDaysShort.monday) && Intrinsics.areEqual(this.tuesday, commonDaysShort.tuesday) && Intrinsics.areEqual(this.wednesday, commonDaysShort.wednesday) && Intrinsics.areEqual(this.thursday, commonDaysShort.thursday) && Intrinsics.areEqual(this.friday, commonDaysShort.friday) && Intrinsics.areEqual(this.saturday, commonDaysShort.saturday) && Intrinsics.areEqual(this.sunday, commonDaysShort.sunday);
    }

    public int hashCode() {
        return (((((((((((this.monday.hashCode() * 31) + this.tuesday.hashCode()) * 31) + this.wednesday.hashCode()) * 31) + this.thursday.hashCode()) * 31) + this.friday.hashCode()) * 31) + this.saturday.hashCode()) * 31) + this.sunday.hashCode();
    }

    public String toString() {
        return "CommonDaysShort(monday=" + this.monday + ", tuesday=" + this.tuesday + ", wednesday=" + this.wednesday + ", thursday=" + this.thursday + ", friday=" + this.friday + ", saturday=" + this.saturday + ", sunday=" + this.sunday + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.monday);
        parcel.writeString(this.tuesday);
        parcel.writeString(this.wednesday);
        parcel.writeString(this.thursday);
        parcel.writeString(this.friday);
        parcel.writeString(this.saturday);
        parcel.writeString(this.sunday);
    }

    public CommonDaysShort(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        Intrinsics.checkNotNullParameter(monday, "monday");
        Intrinsics.checkNotNullParameter(tuesday, "tuesday");
        Intrinsics.checkNotNullParameter(wednesday, "wednesday");
        Intrinsics.checkNotNullParameter(thursday, "thursday");
        Intrinsics.checkNotNullParameter(friday, "friday");
        Intrinsics.checkNotNullParameter(saturday, "saturday");
        Intrinsics.checkNotNullParameter(sunday, "sunday");
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public final String getMonday() {
        return this.monday;
    }

    public final String getTuesday() {
        return this.tuesday;
    }

    public final String getWednesday() {
        return this.wednesday;
    }

    public final String getThursday() {
        return this.thursday;
    }

    public final String getFriday() {
        return this.friday;
    }

    public final String getSaturday() {
        return this.saturday;
    }

    public final String getSunday() {
        return this.sunday;
    }
}
