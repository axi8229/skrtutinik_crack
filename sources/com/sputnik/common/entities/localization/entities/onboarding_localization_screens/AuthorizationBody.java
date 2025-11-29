package com.sputnik.common.entities.localization.entities.onboarding_localization_screens;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizationBody.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b!\u0010\u001bJ \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b/\u00100R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u00101\u001a\u0004\b2\u00103R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00104\u001a\u0004\b5\u00106R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u00107\u001a\u0004\b8\u0010\u0018R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u000e\u00107\u001a\u0004\b9\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u00107\u001a\u0004\b:\u0010\u0018R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u00107\u001a\u0004\b;\u0010\u0018R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u00107\u001a\u0004\b<\u0010\u0018R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00107\u001a\u0004\b@\u0010\u0018¨\u0006A"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationMain;", "main", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationSms;", "sms", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationPhone;", "phone", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationVoiced;", "voiced", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationTelegram;", "telegram", "", "error", "timer", "codeFromSms", "limitExceeded", "changeMethodButton", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/UserSms;", "userSms", "errorLimitExceeded", "<init>", "(Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationMain;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationSms;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationPhone;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationVoiced;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationTelegram;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/UserSms;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationMain;", "getMain", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationMain;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationSms;", "getSms", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationSms;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationPhone;", "getPhone", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationPhone;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationVoiced;", "getVoiced", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationVoiced;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationTelegram;", "getTelegram", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationTelegram;", "Ljava/lang/String;", "getError", "getTimer", "getCodeFromSms", "getLimitExceeded", "getChangeMethodButton", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/UserSms;", "getUserSms", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/UserSms;", "getErrorLimitExceeded", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AuthorizationBody implements Parcelable {
    public static final Parcelable.Creator<AuthorizationBody> CREATOR = new Creator();

    @SerializedName("change_method_button")
    private final String changeMethodButton;

    @SerializedName("code_from_sms")
    private final String codeFromSms;
    private final String error;

    @SerializedName("error_limit_exceeded")
    private final String errorLimitExceeded;

    @SerializedName("limit_exceeded")
    private final String limitExceeded;
    private final AuthorizationMain main;
    private final AuthorizationPhone phone;
    private final AuthorizationSms sms;
    private final AuthorizationTelegram telegram;
    private final String timer;

    @SerializedName("user_sms")
    private final UserSms userSms;
    private final AuthorizationVoiced voiced;

    /* compiled from: AuthorizationBody.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AuthorizationBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthorizationBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthorizationBody(parcel.readInt() == 0 ? null : AuthorizationMain.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AuthorizationSms.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AuthorizationPhone.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AuthorizationVoiced.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AuthorizationTelegram.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? UserSms.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthorizationBody[] newArray(int i) {
            return new AuthorizationBody[i];
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
        if (!(other instanceof AuthorizationBody)) {
            return false;
        }
        AuthorizationBody authorizationBody = (AuthorizationBody) other;
        return Intrinsics.areEqual(this.main, authorizationBody.main) && Intrinsics.areEqual(this.sms, authorizationBody.sms) && Intrinsics.areEqual(this.phone, authorizationBody.phone) && Intrinsics.areEqual(this.voiced, authorizationBody.voiced) && Intrinsics.areEqual(this.telegram, authorizationBody.telegram) && Intrinsics.areEqual(this.error, authorizationBody.error) && Intrinsics.areEqual(this.timer, authorizationBody.timer) && Intrinsics.areEqual(this.codeFromSms, authorizationBody.codeFromSms) && Intrinsics.areEqual(this.limitExceeded, authorizationBody.limitExceeded) && Intrinsics.areEqual(this.changeMethodButton, authorizationBody.changeMethodButton) && Intrinsics.areEqual(this.userSms, authorizationBody.userSms) && Intrinsics.areEqual(this.errorLimitExceeded, authorizationBody.errorLimitExceeded);
    }

    public int hashCode() {
        AuthorizationMain authorizationMain = this.main;
        int iHashCode = (authorizationMain == null ? 0 : authorizationMain.hashCode()) * 31;
        AuthorizationSms authorizationSms = this.sms;
        int iHashCode2 = (iHashCode + (authorizationSms == null ? 0 : authorizationSms.hashCode())) * 31;
        AuthorizationPhone authorizationPhone = this.phone;
        int iHashCode3 = (iHashCode2 + (authorizationPhone == null ? 0 : authorizationPhone.hashCode())) * 31;
        AuthorizationVoiced authorizationVoiced = this.voiced;
        int iHashCode4 = (iHashCode3 + (authorizationVoiced == null ? 0 : authorizationVoiced.hashCode())) * 31;
        AuthorizationTelegram authorizationTelegram = this.telegram;
        int iHashCode5 = (iHashCode4 + (authorizationTelegram == null ? 0 : authorizationTelegram.hashCode())) * 31;
        String str = this.error;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.timer;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.codeFromSms;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.limitExceeded;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.changeMethodButton;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        UserSms userSms = this.userSms;
        int iHashCode11 = (iHashCode10 + (userSms == null ? 0 : userSms.hashCode())) * 31;
        String str6 = this.errorLimitExceeded;
        return iHashCode11 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "AuthorizationBody(main=" + this.main + ", sms=" + this.sms + ", phone=" + this.phone + ", voiced=" + this.voiced + ", telegram=" + this.telegram + ", error=" + this.error + ", timer=" + this.timer + ", codeFromSms=" + this.codeFromSms + ", limitExceeded=" + this.limitExceeded + ", changeMethodButton=" + this.changeMethodButton + ", userSms=" + this.userSms + ", errorLimitExceeded=" + this.errorLimitExceeded + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        AuthorizationMain authorizationMain = this.main;
        if (authorizationMain == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            authorizationMain.writeToParcel(parcel, flags);
        }
        AuthorizationSms authorizationSms = this.sms;
        if (authorizationSms == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            authorizationSms.writeToParcel(parcel, flags);
        }
        AuthorizationPhone authorizationPhone = this.phone;
        if (authorizationPhone == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            authorizationPhone.writeToParcel(parcel, flags);
        }
        AuthorizationVoiced authorizationVoiced = this.voiced;
        if (authorizationVoiced == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            authorizationVoiced.writeToParcel(parcel, flags);
        }
        AuthorizationTelegram authorizationTelegram = this.telegram;
        if (authorizationTelegram == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            authorizationTelegram.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.error);
        parcel.writeString(this.timer);
        parcel.writeString(this.codeFromSms);
        parcel.writeString(this.limitExceeded);
        parcel.writeString(this.changeMethodButton);
        UserSms userSms = this.userSms;
        if (userSms == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            userSms.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.errorLimitExceeded);
    }

    public AuthorizationBody(AuthorizationMain authorizationMain, AuthorizationSms authorizationSms, AuthorizationPhone authorizationPhone, AuthorizationVoiced authorizationVoiced, AuthorizationTelegram authorizationTelegram, String str, String str2, String str3, String str4, String str5, UserSms userSms, String str6) {
        this.main = authorizationMain;
        this.sms = authorizationSms;
        this.phone = authorizationPhone;
        this.voiced = authorizationVoiced;
        this.telegram = authorizationTelegram;
        this.error = str;
        this.timer = str2;
        this.codeFromSms = str3;
        this.limitExceeded = str4;
        this.changeMethodButton = str5;
        this.userSms = userSms;
        this.errorLimitExceeded = str6;
    }

    public final AuthorizationSms getSms() {
        return this.sms;
    }

    public final AuthorizationPhone getPhone() {
        return this.phone;
    }

    public final AuthorizationVoiced getVoiced() {
        return this.voiced;
    }

    public final AuthorizationTelegram getTelegram() {
        return this.telegram;
    }

    public final String getError() {
        return this.error;
    }

    public final String getTimer() {
        return this.timer;
    }

    public final String getChangeMethodButton() {
        return this.changeMethodButton;
    }

    public final UserSms getUserSms() {
        return this.userSms;
    }
}
