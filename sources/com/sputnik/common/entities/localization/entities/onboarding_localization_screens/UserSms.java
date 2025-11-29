package com.sputnik.common.entities.localization.entities.onboarding_localization_screens;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationBody.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/UserSms;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AutoSendSmsScreen;", "autoSendSmsScreen", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ManualSendSmsScreen;", "manualSendSmsScreen", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/WaitingScreen;", "waitingScreen", "<init>", "(Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AutoSendSmsScreen;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ManualSendSmsScreen;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/WaitingScreen;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AutoSendSmsScreen;", "getAutoSendSmsScreen", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AutoSendSmsScreen;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ManualSendSmsScreen;", "getManualSendSmsScreen", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ManualSendSmsScreen;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/WaitingScreen;", "getWaitingScreen", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/WaitingScreen;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserSms implements Parcelable {
    public static final Parcelable.Creator<UserSms> CREATOR = new Creator();

    @SerializedName("auto_send_sms_screen")
    private final AutoSendSmsScreen autoSendSmsScreen;

    @SerializedName("manual_send_sms_screen")
    private final ManualSendSmsScreen manualSendSmsScreen;

    @SerializedName("waiting_screen")
    private final WaitingScreen waitingScreen;

    /* compiled from: AuthorizationBody.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserSms> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserSms createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserSms(parcel.readInt() == 0 ? null : AutoSendSmsScreen.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ManualSendSmsScreen.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? WaitingScreen.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserSms[] newArray(int i) {
            return new UserSms[i];
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
        if (!(other instanceof UserSms)) {
            return false;
        }
        UserSms userSms = (UserSms) other;
        return Intrinsics.areEqual(this.autoSendSmsScreen, userSms.autoSendSmsScreen) && Intrinsics.areEqual(this.manualSendSmsScreen, userSms.manualSendSmsScreen) && Intrinsics.areEqual(this.waitingScreen, userSms.waitingScreen);
    }

    public int hashCode() {
        AutoSendSmsScreen autoSendSmsScreen = this.autoSendSmsScreen;
        int iHashCode = (autoSendSmsScreen == null ? 0 : autoSendSmsScreen.hashCode()) * 31;
        ManualSendSmsScreen manualSendSmsScreen = this.manualSendSmsScreen;
        int iHashCode2 = (iHashCode + (manualSendSmsScreen == null ? 0 : manualSendSmsScreen.hashCode())) * 31;
        WaitingScreen waitingScreen = this.waitingScreen;
        return iHashCode2 + (waitingScreen != null ? waitingScreen.hashCode() : 0);
    }

    public String toString() {
        return "UserSms(autoSendSmsScreen=" + this.autoSendSmsScreen + ", manualSendSmsScreen=" + this.manualSendSmsScreen + ", waitingScreen=" + this.waitingScreen + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        AutoSendSmsScreen autoSendSmsScreen = this.autoSendSmsScreen;
        if (autoSendSmsScreen == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            autoSendSmsScreen.writeToParcel(parcel, flags);
        }
        ManualSendSmsScreen manualSendSmsScreen = this.manualSendSmsScreen;
        if (manualSendSmsScreen == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            manualSendSmsScreen.writeToParcel(parcel, flags);
        }
        WaitingScreen waitingScreen = this.waitingScreen;
        if (waitingScreen == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            waitingScreen.writeToParcel(parcel, flags);
        }
    }

    public UserSms(AutoSendSmsScreen autoSendSmsScreen, ManualSendSmsScreen manualSendSmsScreen, WaitingScreen waitingScreen) {
        this.autoSendSmsScreen = autoSendSmsScreen;
        this.manualSendSmsScreen = manualSendSmsScreen;
        this.waitingScreen = waitingScreen;
    }

    public final AutoSendSmsScreen getAutoSendSmsScreen() {
        return this.autoSendSmsScreen;
    }

    public final ManualSendSmsScreen getManualSendSmsScreen() {
        return this.manualSendSmsScreen;
    }

    public final WaitingScreen getWaitingScreen() {
        return this.waitingScreen;
    }
}
