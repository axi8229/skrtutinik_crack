package com.sputnik.common.entities.localization.entities.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompanyContactsBody.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/entities/help/CompanyContactsBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/help/ViewWorkingHours;", "workHoursView", "Lcom/sputnik/common/entities/localization/entities/help/ViewPhone;", "phoneView", "<init>", "(Lcom/sputnik/common/entities/localization/entities/help/ViewWorkingHours;Lcom/sputnik/common/entities/localization/entities/help/ViewPhone;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/help/ViewWorkingHours;", "getWorkHoursView", "()Lcom/sputnik/common/entities/localization/entities/help/ViewWorkingHours;", "Lcom/sputnik/common/entities/localization/entities/help/ViewPhone;", "getPhoneView", "()Lcom/sputnik/common/entities/localization/entities/help/ViewPhone;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CompanyContactsBody implements Parcelable {
    public static final Parcelable.Creator<CompanyContactsBody> CREATOR = new Creator();

    @SerializedName("phone_view")
    private final ViewPhone phoneView;

    @SerializedName("work_hours_view")
    private final ViewWorkingHours workHoursView;

    /* compiled from: CompanyContactsBody.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CompanyContactsBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CompanyContactsBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CompanyContactsBody(parcel.readInt() == 0 ? null : ViewWorkingHours.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ViewPhone.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CompanyContactsBody[] newArray(int i) {
            return new CompanyContactsBody[i];
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
        if (!(other instanceof CompanyContactsBody)) {
            return false;
        }
        CompanyContactsBody companyContactsBody = (CompanyContactsBody) other;
        return Intrinsics.areEqual(this.workHoursView, companyContactsBody.workHoursView) && Intrinsics.areEqual(this.phoneView, companyContactsBody.phoneView);
    }

    public int hashCode() {
        ViewWorkingHours viewWorkingHours = this.workHoursView;
        int iHashCode = (viewWorkingHours == null ? 0 : viewWorkingHours.hashCode()) * 31;
        ViewPhone viewPhone = this.phoneView;
        return iHashCode + (viewPhone != null ? viewPhone.hashCode() : 0);
    }

    public String toString() {
        return "CompanyContactsBody(workHoursView=" + this.workHoursView + ", phoneView=" + this.phoneView + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        ViewWorkingHours viewWorkingHours = this.workHoursView;
        if (viewWorkingHours == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            viewWorkingHours.writeToParcel(parcel, flags);
        }
        ViewPhone viewPhone = this.phoneView;
        if (viewPhone == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            viewPhone.writeToParcel(parcel, flags);
        }
    }

    public CompanyContactsBody(ViewWorkingHours viewWorkingHours, ViewPhone viewPhone) {
        this.workHoursView = viewWorkingHours;
        this.phoneView = viewPhone;
    }

    public final ViewWorkingHours getWorkHoursView() {
        return this.workHoursView;
    }

    public final ViewPhone getPhoneView() {
        return this.phoneView;
    }
}
