package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b\f\u0010#R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/sputnik/common/entities/localization/CommonLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/CommonDates;", "dates", "", "", "daysShort", "Lcom/sputnik/common/entities/localization/NamingSet;", "people", "<init>", "(Lcom/sputnik/common/entities/localization/CommonDates;Ljava/util/List;Lcom/sputnik/common/entities/localization/NamingSet;)V", "Lcom/sputnik/common/entities/localization/CommonDaysShort;", "getDaysShort", "()Lcom/sputnik/common/entities/localization/CommonDaysShort;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/CommonDates;", "getDates", "()Lcom/sputnik/common/entities/localization/CommonDates;", "Ljava/util/List;", "()Ljava/util/List;", "Lcom/sputnik/common/entities/localization/NamingSet;", "getPeople", "()Lcom/sputnik/common/entities/localization/NamingSet;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CommonLocale implements Parcelable {
    public static final Parcelable.Creator<CommonLocale> CREATOR = new Creator();
    private final CommonDates dates;

    @SerializedName("days_short")
    private final List<String> daysShort;
    private final NamingSet people;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommonLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonLocale(parcel.readInt() == 0 ? null : CommonDates.CREATOR.createFromParcel(parcel), parcel.createStringArrayList(), parcel.readInt() != 0 ? NamingSet.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonLocale[] newArray(int i) {
            return new CommonLocale[i];
        }
    }

    public CommonLocale() {
        this(null, null, null, 7, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonLocale)) {
            return false;
        }
        CommonLocale commonLocale = (CommonLocale) other;
        return Intrinsics.areEqual(this.dates, commonLocale.dates) && Intrinsics.areEqual(this.daysShort, commonLocale.daysShort) && Intrinsics.areEqual(this.people, commonLocale.people);
    }

    public int hashCode() {
        CommonDates commonDates = this.dates;
        int iHashCode = (commonDates == null ? 0 : commonDates.hashCode()) * 31;
        List<String> list = this.daysShort;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        NamingSet namingSet = this.people;
        return iHashCode2 + (namingSet != null ? namingSet.hashCode() : 0);
    }

    public String toString() {
        return "CommonLocale(dates=" + this.dates + ", daysShort=" + this.daysShort + ", people=" + this.people + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        CommonDates commonDates = this.dates;
        if (commonDates == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            commonDates.writeToParcel(parcel, flags);
        }
        parcel.writeStringList(this.daysShort);
        NamingSet namingSet = this.people;
        if (namingSet == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            namingSet.writeToParcel(parcel, flags);
        }
    }

    public CommonLocale(CommonDates commonDates, List<String> list, NamingSet namingSet) {
        this.dates = commonDates;
        this.daysShort = list;
        this.people = namingSet;
    }

    public final CommonDates getDates() {
        return this.dates;
    }

    public /* synthetic */ CommonLocale(CommonDates commonDates, List list, NamingSet namingSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : commonDates, (i & 2) != 0 ? CollectionsKt.listOf((Object[]) new String[]{"пн", "вт", "ср", "чт", "пт", "сб", "вс"}) : list, (i & 4) != 0 ? null : namingSet);
    }

    public final NamingSet getPeople() {
        return this.people;
    }

    public final CommonDaysShort getDaysShort() {
        try {
            List<String> list = this.daysShort;
            String strValueOf = String.valueOf(list != null ? list.get(0) : null);
            List<String> list2 = this.daysShort;
            String strValueOf2 = String.valueOf(list2 != null ? list2.get(1) : null);
            List<String> list3 = this.daysShort;
            String strValueOf3 = String.valueOf(list3 != null ? list3.get(2) : null);
            List<String> list4 = this.daysShort;
            String strValueOf4 = String.valueOf(list4 != null ? list4.get(3) : null);
            List<String> list5 = this.daysShort;
            String strValueOf5 = String.valueOf(list5 != null ? list5.get(4) : null);
            List<String> list6 = this.daysShort;
            String strValueOf6 = String.valueOf(list6 != null ? list6.get(5) : null);
            List<String> list7 = this.daysShort;
            return new CommonDaysShort(strValueOf, strValueOf2, strValueOf3, strValueOf4, strValueOf5, strValueOf6, String.valueOf(list7 != null ? list7.get(6) : null));
        } catch (Exception unused) {
            return new CommonDaysShort("пн", "вт", "ср", "чт", "пт", "сб", "вс");
        }
    }
}
