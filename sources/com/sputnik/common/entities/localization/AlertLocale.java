package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b!\u0010\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\"\u0010\u001e¨\u0006#"}, d2 = {"Lcom/sputnik/common/entities/localization/AlertLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/AlertData;", "smsCodeExpired", "attemptsExceeded", "noIntercomPopup", "commonError", "buySubscription", "<init>", "(Lcom/sputnik/common/entities/localization/AlertData;Lcom/sputnik/common/entities/localization/AlertData;Lcom/sputnik/common/entities/localization/AlertData;Lcom/sputnik/common/entities/localization/AlertData;Lcom/sputnik/common/entities/localization/AlertData;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/AlertData;", "getSmsCodeExpired", "()Lcom/sputnik/common/entities/localization/AlertData;", "getAttemptsExceeded", "getNoIntercomPopup", "getCommonError", "getBuySubscription", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AlertLocale implements Parcelable {
    public static final Parcelable.Creator<AlertLocale> CREATOR = new Creator();

    @SerializedName("attempts_exceeded")
    private final AlertData attemptsExceeded;

    @SerializedName("buy_subscription")
    private final AlertData buySubscription;

    @SerializedName("common_error")
    private final AlertData commonError;

    @SerializedName("no_domofon_auth")
    private final AlertData noIntercomPopup;

    @SerializedName("sms_code_expired")
    private final AlertData smsCodeExpired;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AlertLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AlertLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AlertLocale(parcel.readInt() == 0 ? null : AlertData.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AlertData.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AlertData.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AlertData.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? AlertData.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AlertLocale[] newArray(int i) {
            return new AlertLocale[i];
        }
    }

    public AlertLocale() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlertLocale)) {
            return false;
        }
        AlertLocale alertLocale = (AlertLocale) other;
        return Intrinsics.areEqual(this.smsCodeExpired, alertLocale.smsCodeExpired) && Intrinsics.areEqual(this.attemptsExceeded, alertLocale.attemptsExceeded) && Intrinsics.areEqual(this.noIntercomPopup, alertLocale.noIntercomPopup) && Intrinsics.areEqual(this.commonError, alertLocale.commonError) && Intrinsics.areEqual(this.buySubscription, alertLocale.buySubscription);
    }

    public int hashCode() {
        AlertData alertData = this.smsCodeExpired;
        int iHashCode = (alertData == null ? 0 : alertData.hashCode()) * 31;
        AlertData alertData2 = this.attemptsExceeded;
        int iHashCode2 = (iHashCode + (alertData2 == null ? 0 : alertData2.hashCode())) * 31;
        AlertData alertData3 = this.noIntercomPopup;
        int iHashCode3 = (iHashCode2 + (alertData3 == null ? 0 : alertData3.hashCode())) * 31;
        AlertData alertData4 = this.commonError;
        int iHashCode4 = (iHashCode3 + (alertData4 == null ? 0 : alertData4.hashCode())) * 31;
        AlertData alertData5 = this.buySubscription;
        return iHashCode4 + (alertData5 != null ? alertData5.hashCode() : 0);
    }

    public String toString() {
        return "AlertLocale(smsCodeExpired=" + this.smsCodeExpired + ", attemptsExceeded=" + this.attemptsExceeded + ", noIntercomPopup=" + this.noIntercomPopup + ", commonError=" + this.commonError + ", buySubscription=" + this.buySubscription + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        AlertData alertData = this.smsCodeExpired;
        if (alertData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            alertData.writeToParcel(parcel, flags);
        }
        AlertData alertData2 = this.attemptsExceeded;
        if (alertData2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            alertData2.writeToParcel(parcel, flags);
        }
        AlertData alertData3 = this.noIntercomPopup;
        if (alertData3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            alertData3.writeToParcel(parcel, flags);
        }
        AlertData alertData4 = this.commonError;
        if (alertData4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            alertData4.writeToParcel(parcel, flags);
        }
        AlertData alertData5 = this.buySubscription;
        if (alertData5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            alertData5.writeToParcel(parcel, flags);
        }
    }

    public AlertLocale(AlertData alertData, AlertData alertData2, AlertData alertData3, AlertData alertData4, AlertData alertData5) {
        this.smsCodeExpired = alertData;
        this.attemptsExceeded = alertData2;
        this.noIntercomPopup = alertData3;
        this.commonError = alertData4;
        this.buySubscription = alertData5;
    }

    public /* synthetic */ AlertLocale(AlertData alertData, AlertData alertData2, AlertData alertData3, AlertData alertData4, AlertData alertData5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : alertData, (i & 2) != 0 ? null : alertData2, (i & 4) != 0 ? null : alertData3, (i & 8) != 0 ? null : alertData4, (i & 16) != 0 ? null : alertData5);
    }

    public final AlertData getAttemptsExceeded() {
        return this.attemptsExceeded;
    }

    public final AlertData getNoIntercomPopup() {
        return this.noIntercomPopup;
    }

    public final AlertData getCommonError() {
        return this.commonError;
    }
}
