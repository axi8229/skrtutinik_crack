package com.sputnik.common.entities.localization.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmAddressLocale.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/login/ConfirmAddressBodyLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/login/ConfirmAddressPopup;", "confirmAddressPopup", "Lcom/sputnik/common/entities/localization/entities/login/BadAddressPopup;", "badAddressPopup", "Lcom/sputnik/common/entities/localization/entities/login/EnterApartmentPopup;", "enterApartmentPopup", "Lcom/sputnik/common/entities/localization/entities/login/WrongApartmentPopup;", "wrongApartmentPopup", "<init>", "(Lcom/sputnik/common/entities/localization/entities/login/ConfirmAddressPopup;Lcom/sputnik/common/entities/localization/entities/login/BadAddressPopup;Lcom/sputnik/common/entities/localization/entities/login/EnterApartmentPopup;Lcom/sputnik/common/entities/localization/entities/login/WrongApartmentPopup;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/login/ConfirmAddressPopup;", "getConfirmAddressPopup", "()Lcom/sputnik/common/entities/localization/entities/login/ConfirmAddressPopup;", "Lcom/sputnik/common/entities/localization/entities/login/BadAddressPopup;", "getBadAddressPopup", "()Lcom/sputnik/common/entities/localization/entities/login/BadAddressPopup;", "Lcom/sputnik/common/entities/localization/entities/login/EnterApartmentPopup;", "getEnterApartmentPopup", "()Lcom/sputnik/common/entities/localization/entities/login/EnterApartmentPopup;", "Lcom/sputnik/common/entities/localization/entities/login/WrongApartmentPopup;", "getWrongApartmentPopup", "()Lcom/sputnik/common/entities/localization/entities/login/WrongApartmentPopup;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConfirmAddressBodyLocale implements Parcelable {
    public static final Parcelable.Creator<ConfirmAddressBodyLocale> CREATOR = new Creator();

    @SerializedName("bad_address_popup")
    private final BadAddressPopup badAddressPopup;

    @SerializedName("confirm_address_popup")
    private final ConfirmAddressPopup confirmAddressPopup;

    @SerializedName("enter_apartment_popup")
    private final EnterApartmentPopup enterApartmentPopup;

    @SerializedName("wrong_apartment_popup")
    private final WrongApartmentPopup wrongApartmentPopup;

    /* compiled from: ConfirmAddressLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ConfirmAddressBodyLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConfirmAddressBodyLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ConfirmAddressBodyLocale(ConfirmAddressPopup.CREATOR.createFromParcel(parcel), BadAddressPopup.CREATOR.createFromParcel(parcel), EnterApartmentPopup.CREATOR.createFromParcel(parcel), WrongApartmentPopup.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConfirmAddressBodyLocale[] newArray(int i) {
            return new ConfirmAddressBodyLocale[i];
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
        if (!(other instanceof ConfirmAddressBodyLocale)) {
            return false;
        }
        ConfirmAddressBodyLocale confirmAddressBodyLocale = (ConfirmAddressBodyLocale) other;
        return Intrinsics.areEqual(this.confirmAddressPopup, confirmAddressBodyLocale.confirmAddressPopup) && Intrinsics.areEqual(this.badAddressPopup, confirmAddressBodyLocale.badAddressPopup) && Intrinsics.areEqual(this.enterApartmentPopup, confirmAddressBodyLocale.enterApartmentPopup) && Intrinsics.areEqual(this.wrongApartmentPopup, confirmAddressBodyLocale.wrongApartmentPopup);
    }

    public int hashCode() {
        return (((((this.confirmAddressPopup.hashCode() * 31) + this.badAddressPopup.hashCode()) * 31) + this.enterApartmentPopup.hashCode()) * 31) + this.wrongApartmentPopup.hashCode();
    }

    public String toString() {
        return "ConfirmAddressBodyLocale(confirmAddressPopup=" + this.confirmAddressPopup + ", badAddressPopup=" + this.badAddressPopup + ", enterApartmentPopup=" + this.enterApartmentPopup + ", wrongApartmentPopup=" + this.wrongApartmentPopup + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.confirmAddressPopup.writeToParcel(parcel, flags);
        this.badAddressPopup.writeToParcel(parcel, flags);
        this.enterApartmentPopup.writeToParcel(parcel, flags);
        this.wrongApartmentPopup.writeToParcel(parcel, flags);
    }

    public ConfirmAddressBodyLocale(ConfirmAddressPopup confirmAddressPopup, BadAddressPopup badAddressPopup, EnterApartmentPopup enterApartmentPopup, WrongApartmentPopup wrongApartmentPopup) {
        Intrinsics.checkNotNullParameter(confirmAddressPopup, "confirmAddressPopup");
        Intrinsics.checkNotNullParameter(badAddressPopup, "badAddressPopup");
        Intrinsics.checkNotNullParameter(enterApartmentPopup, "enterApartmentPopup");
        Intrinsics.checkNotNullParameter(wrongApartmentPopup, "wrongApartmentPopup");
        this.confirmAddressPopup = confirmAddressPopup;
        this.badAddressPopup = badAddressPopup;
        this.enterApartmentPopup = enterApartmentPopup;
        this.wrongApartmentPopup = wrongApartmentPopup;
    }

    public final ConfirmAddressPopup getConfirmAddressPopup() {
        return this.confirmAddressPopup;
    }

    public final BadAddressPopup getBadAddressPopup() {
        return this.badAddressPopup;
    }

    public final EnterApartmentPopup getEnterApartmentPopup() {
        return this.enterApartmentPopup;
    }

    public final WrongApartmentPopup getWrongApartmentPopup() {
        return this.wrongApartmentPopup;
    }
}
