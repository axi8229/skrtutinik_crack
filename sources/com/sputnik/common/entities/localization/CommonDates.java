package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b$\u0010\u001f¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/CommonDates;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/NamingSet;", "years", "months", "days", "hours", "minutes", "seconds", "<init>", "(Lcom/sputnik/common/entities/localization/NamingSet;Lcom/sputnik/common/entities/localization/NamingSet;Lcom/sputnik/common/entities/localization/NamingSet;Lcom/sputnik/common/entities/localization/NamingSet;Lcom/sputnik/common/entities/localization/NamingSet;Lcom/sputnik/common/entities/localization/NamingSet;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/NamingSet;", "getYears", "()Lcom/sputnik/common/entities/localization/NamingSet;", "getMonths", "getDays", "getHours", "getMinutes", "getSeconds", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CommonDates implements Parcelable {
    public static final Parcelable.Creator<CommonDates> CREATOR = new Creator();
    private final NamingSet days;
    private final NamingSet hours;
    private final NamingSet minutes;
    private final NamingSet months;
    private final NamingSet seconds;
    private final NamingSet years;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommonDates> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonDates createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonDates(parcel.readInt() == 0 ? null : NamingSet.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : NamingSet.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : NamingSet.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : NamingSet.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : NamingSet.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? NamingSet.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonDates[] newArray(int i) {
            return new CommonDates[i];
        }
    }

    public CommonDates() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonDates)) {
            return false;
        }
        CommonDates commonDates = (CommonDates) other;
        return Intrinsics.areEqual(this.years, commonDates.years) && Intrinsics.areEqual(this.months, commonDates.months) && Intrinsics.areEqual(this.days, commonDates.days) && Intrinsics.areEqual(this.hours, commonDates.hours) && Intrinsics.areEqual(this.minutes, commonDates.minutes) && Intrinsics.areEqual(this.seconds, commonDates.seconds);
    }

    public int hashCode() {
        NamingSet namingSet = this.years;
        int iHashCode = (namingSet == null ? 0 : namingSet.hashCode()) * 31;
        NamingSet namingSet2 = this.months;
        int iHashCode2 = (iHashCode + (namingSet2 == null ? 0 : namingSet2.hashCode())) * 31;
        NamingSet namingSet3 = this.days;
        int iHashCode3 = (iHashCode2 + (namingSet3 == null ? 0 : namingSet3.hashCode())) * 31;
        NamingSet namingSet4 = this.hours;
        int iHashCode4 = (iHashCode3 + (namingSet4 == null ? 0 : namingSet4.hashCode())) * 31;
        NamingSet namingSet5 = this.minutes;
        int iHashCode5 = (iHashCode4 + (namingSet5 == null ? 0 : namingSet5.hashCode())) * 31;
        NamingSet namingSet6 = this.seconds;
        return iHashCode5 + (namingSet6 != null ? namingSet6.hashCode() : 0);
    }

    public String toString() {
        return "CommonDates(years=" + this.years + ", months=" + this.months + ", days=" + this.days + ", hours=" + this.hours + ", minutes=" + this.minutes + ", seconds=" + this.seconds + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        NamingSet namingSet = this.years;
        if (namingSet == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            namingSet.writeToParcel(parcel, flags);
        }
        NamingSet namingSet2 = this.months;
        if (namingSet2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            namingSet2.writeToParcel(parcel, flags);
        }
        NamingSet namingSet3 = this.days;
        if (namingSet3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            namingSet3.writeToParcel(parcel, flags);
        }
        NamingSet namingSet4 = this.hours;
        if (namingSet4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            namingSet4.writeToParcel(parcel, flags);
        }
        NamingSet namingSet5 = this.minutes;
        if (namingSet5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            namingSet5.writeToParcel(parcel, flags);
        }
        NamingSet namingSet6 = this.seconds;
        if (namingSet6 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            namingSet6.writeToParcel(parcel, flags);
        }
    }

    public CommonDates(NamingSet namingSet, NamingSet namingSet2, NamingSet namingSet3, NamingSet namingSet4, NamingSet namingSet5, NamingSet namingSet6) {
        this.years = namingSet;
        this.months = namingSet2;
        this.days = namingSet3;
        this.hours = namingSet4;
        this.minutes = namingSet5;
        this.seconds = namingSet6;
    }

    public /* synthetic */ CommonDates(NamingSet namingSet, NamingSet namingSet2, NamingSet namingSet3, NamingSet namingSet4, NamingSet namingSet5, NamingSet namingSet6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : namingSet, (i & 2) != 0 ? null : namingSet2, (i & 4) != 0 ? null : namingSet3, (i & 8) != 0 ? null : namingSet4, (i & 16) != 0 ? null : namingSet5, (i & 32) != 0 ? null : namingSet6);
    }

    public final NamingSet getDays() {
        return this.days;
    }

    public final NamingSet getHours() {
        return this.hours;
    }

    public final NamingSet getMinutes() {
        return this.minutes;
    }

    public final NamingSet getSeconds() {
        return this.seconds;
    }
}
