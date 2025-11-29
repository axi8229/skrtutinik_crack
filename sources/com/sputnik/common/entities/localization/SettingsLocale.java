package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/SettingsLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/SettingsNavigation;", "navigation", "Lcom/sputnik/common/entities/localization/SettingsBody;", "body", "Lcom/sputnik/common/entities/localization/SettingsExitPopUp;", "exitPopUp", "<init>", "(Lcom/sputnik/common/entities/localization/SettingsNavigation;Lcom/sputnik/common/entities/localization/SettingsBody;Lcom/sputnik/common/entities/localization/SettingsExitPopUp;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/SettingsNavigation;", "getNavigation", "()Lcom/sputnik/common/entities/localization/SettingsNavigation;", "Lcom/sputnik/common/entities/localization/SettingsBody;", "getBody", "()Lcom/sputnik/common/entities/localization/SettingsBody;", "Lcom/sputnik/common/entities/localization/SettingsExitPopUp;", "getExitPopUp", "()Lcom/sputnik/common/entities/localization/SettingsExitPopUp;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SettingsLocale implements Parcelable {
    public static final Parcelable.Creator<SettingsLocale> CREATOR = new Creator();
    private final SettingsBody body;

    @SerializedName("exit_popup")
    private final SettingsExitPopUp exitPopUp;
    private final SettingsNavigation navigation;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SettingsLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SettingsLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SettingsLocale(parcel.readInt() == 0 ? null : SettingsNavigation.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : SettingsBody.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? SettingsExitPopUp.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SettingsLocale[] newArray(int i) {
            return new SettingsLocale[i];
        }
    }

    public SettingsLocale() {
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
        if (!(other instanceof SettingsLocale)) {
            return false;
        }
        SettingsLocale settingsLocale = (SettingsLocale) other;
        return Intrinsics.areEqual(this.navigation, settingsLocale.navigation) && Intrinsics.areEqual(this.body, settingsLocale.body) && Intrinsics.areEqual(this.exitPopUp, settingsLocale.exitPopUp);
    }

    public int hashCode() {
        SettingsNavigation settingsNavigation = this.navigation;
        int iHashCode = (settingsNavigation == null ? 0 : settingsNavigation.hashCode()) * 31;
        SettingsBody settingsBody = this.body;
        int iHashCode2 = (iHashCode + (settingsBody == null ? 0 : settingsBody.hashCode())) * 31;
        SettingsExitPopUp settingsExitPopUp = this.exitPopUp;
        return iHashCode2 + (settingsExitPopUp != null ? settingsExitPopUp.hashCode() : 0);
    }

    public String toString() {
        return "SettingsLocale(navigation=" + this.navigation + ", body=" + this.body + ", exitPopUp=" + this.exitPopUp + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        SettingsNavigation settingsNavigation = this.navigation;
        if (settingsNavigation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            settingsNavigation.writeToParcel(parcel, flags);
        }
        SettingsBody settingsBody = this.body;
        if (settingsBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            settingsBody.writeToParcel(parcel, flags);
        }
        SettingsExitPopUp settingsExitPopUp = this.exitPopUp;
        if (settingsExitPopUp == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            settingsExitPopUp.writeToParcel(parcel, flags);
        }
    }

    public SettingsLocale(SettingsNavigation settingsNavigation, SettingsBody settingsBody, SettingsExitPopUp settingsExitPopUp) {
        this.navigation = settingsNavigation;
        this.body = settingsBody;
        this.exitPopUp = settingsExitPopUp;
    }

    public /* synthetic */ SettingsLocale(SettingsNavigation settingsNavigation, SettingsBody settingsBody, SettingsExitPopUp settingsExitPopUp, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : settingsNavigation, (i & 2) != 0 ? null : settingsBody, (i & 4) != 0 ? null : settingsExitPopUp);
    }

    public final SettingsNavigation getNavigation() {
        return this.navigation;
    }

    public final SettingsBody getBody() {
        return this.body;
    }

    public final SettingsExitPopUp getExitPopUp() {
        return this.exitPopUp;
    }
}
