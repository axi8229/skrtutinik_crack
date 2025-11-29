package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b/\u00100R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/sputnik/common/entities/localization/ProfileSettingsLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/ProfileNavigationBody;", "navigation", "Lcom/sputnik/common/entities/localization/ProfileSettingsBody;", "body", "Lcom/sputnik/common/entities/localization/ProfileSubscriptionBody;", "subscription", "Lcom/sputnik/common/entities/localization/ProfileSettingsDeletePopUp;", "deletePopup", "Lcom/sputnik/common/entities/localization/ProfileSettingsCameraPopUp;", "cameraPopup", "", "", "messages", "<init>", "(Lcom/sputnik/common/entities/localization/ProfileNavigationBody;Lcom/sputnik/common/entities/localization/ProfileSettingsBody;Lcom/sputnik/common/entities/localization/ProfileSubscriptionBody;Lcom/sputnik/common/entities/localization/ProfileSettingsDeletePopUp;Lcom/sputnik/common/entities/localization/ProfileSettingsCameraPopUp;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/ProfileNavigationBody;", "getNavigation", "()Lcom/sputnik/common/entities/localization/ProfileNavigationBody;", "Lcom/sputnik/common/entities/localization/ProfileSettingsBody;", "getBody", "()Lcom/sputnik/common/entities/localization/ProfileSettingsBody;", "Lcom/sputnik/common/entities/localization/ProfileSubscriptionBody;", "getSubscription", "()Lcom/sputnik/common/entities/localization/ProfileSubscriptionBody;", "Lcom/sputnik/common/entities/localization/ProfileSettingsDeletePopUp;", "getDeletePopup", "()Lcom/sputnik/common/entities/localization/ProfileSettingsDeletePopUp;", "Lcom/sputnik/common/entities/localization/ProfileSettingsCameraPopUp;", "getCameraPopup", "()Lcom/sputnik/common/entities/localization/ProfileSettingsCameraPopUp;", "Ljava/util/List;", "getMessages", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ProfileSettingsLocale implements Parcelable {
    public static final Parcelable.Creator<ProfileSettingsLocale> CREATOR = new Creator();
    private final ProfileSettingsBody body;

    @SerializedName("camera_popup")
    private final ProfileSettingsCameraPopUp cameraPopup;

    @SerializedName("delete_popup")
    private final ProfileSettingsDeletePopUp deletePopup;
    private final List<String> messages;
    private final ProfileNavigationBody navigation;
    private final ProfileSubscriptionBody subscription;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProfileSettingsLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProfileSettingsLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ProfileSettingsLocale(parcel.readInt() == 0 ? null : ProfileNavigationBody.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ProfileSettingsBody.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ProfileSubscriptionBody.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ProfileSettingsDeletePopUp.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ProfileSettingsCameraPopUp.CREATOR.createFromParcel(parcel) : null, parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProfileSettingsLocale[] newArray(int i) {
            return new ProfileSettingsLocale[i];
        }
    }

    public ProfileSettingsLocale() {
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
        if (!(other instanceof ProfileSettingsLocale)) {
            return false;
        }
        ProfileSettingsLocale profileSettingsLocale = (ProfileSettingsLocale) other;
        return Intrinsics.areEqual(this.navigation, profileSettingsLocale.navigation) && Intrinsics.areEqual(this.body, profileSettingsLocale.body) && Intrinsics.areEqual(this.subscription, profileSettingsLocale.subscription) && Intrinsics.areEqual(this.deletePopup, profileSettingsLocale.deletePopup) && Intrinsics.areEqual(this.cameraPopup, profileSettingsLocale.cameraPopup) && Intrinsics.areEqual(this.messages, profileSettingsLocale.messages);
    }

    public int hashCode() {
        ProfileNavigationBody profileNavigationBody = this.navigation;
        int iHashCode = (profileNavigationBody == null ? 0 : profileNavigationBody.hashCode()) * 31;
        ProfileSettingsBody profileSettingsBody = this.body;
        int iHashCode2 = (iHashCode + (profileSettingsBody == null ? 0 : profileSettingsBody.hashCode())) * 31;
        ProfileSubscriptionBody profileSubscriptionBody = this.subscription;
        int iHashCode3 = (iHashCode2 + (profileSubscriptionBody == null ? 0 : profileSubscriptionBody.hashCode())) * 31;
        ProfileSettingsDeletePopUp profileSettingsDeletePopUp = this.deletePopup;
        int iHashCode4 = (iHashCode3 + (profileSettingsDeletePopUp == null ? 0 : profileSettingsDeletePopUp.hashCode())) * 31;
        ProfileSettingsCameraPopUp profileSettingsCameraPopUp = this.cameraPopup;
        int iHashCode5 = (iHashCode4 + (profileSettingsCameraPopUp == null ? 0 : profileSettingsCameraPopUp.hashCode())) * 31;
        List<String> list = this.messages;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ProfileSettingsLocale(navigation=" + this.navigation + ", body=" + this.body + ", subscription=" + this.subscription + ", deletePopup=" + this.deletePopup + ", cameraPopup=" + this.cameraPopup + ", messages=" + this.messages + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        ProfileNavigationBody profileNavigationBody = this.navigation;
        if (profileNavigationBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            profileNavigationBody.writeToParcel(parcel, flags);
        }
        ProfileSettingsBody profileSettingsBody = this.body;
        if (profileSettingsBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            profileSettingsBody.writeToParcel(parcel, flags);
        }
        ProfileSubscriptionBody profileSubscriptionBody = this.subscription;
        if (profileSubscriptionBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            profileSubscriptionBody.writeToParcel(parcel, flags);
        }
        ProfileSettingsDeletePopUp profileSettingsDeletePopUp = this.deletePopup;
        if (profileSettingsDeletePopUp == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            profileSettingsDeletePopUp.writeToParcel(parcel, flags);
        }
        ProfileSettingsCameraPopUp profileSettingsCameraPopUp = this.cameraPopup;
        if (profileSettingsCameraPopUp == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            profileSettingsCameraPopUp.writeToParcel(parcel, flags);
        }
        parcel.writeStringList(this.messages);
    }

    public ProfileSettingsLocale(ProfileNavigationBody profileNavigationBody, ProfileSettingsBody profileSettingsBody, ProfileSubscriptionBody profileSubscriptionBody, ProfileSettingsDeletePopUp profileSettingsDeletePopUp, ProfileSettingsCameraPopUp profileSettingsCameraPopUp, List<String> list) {
        this.navigation = profileNavigationBody;
        this.body = profileSettingsBody;
        this.subscription = profileSubscriptionBody;
        this.deletePopup = profileSettingsDeletePopUp;
        this.cameraPopup = profileSettingsCameraPopUp;
        this.messages = list;
    }

    public /* synthetic */ ProfileSettingsLocale(ProfileNavigationBody profileNavigationBody, ProfileSettingsBody profileSettingsBody, ProfileSubscriptionBody profileSubscriptionBody, ProfileSettingsDeletePopUp profileSettingsDeletePopUp, ProfileSettingsCameraPopUp profileSettingsCameraPopUp, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : profileNavigationBody, (i & 2) != 0 ? null : profileSettingsBody, (i & 4) != 0 ? null : profileSubscriptionBody, (i & 8) != 0 ? null : profileSettingsDeletePopUp, (i & 16) != 0 ? null : profileSettingsCameraPopUp, (i & 32) != 0 ? null : list);
    }

    public final ProfileNavigationBody getNavigation() {
        return this.navigation;
    }

    public final ProfileSettingsBody getBody() {
        return this.body;
    }

    public final ProfileSubscriptionBody getSubscription() {
        return this.subscription;
    }

    public final ProfileSettingsDeletePopUp getDeletePopup() {
        return this.deletePopup;
    }

    public final List<String> getMessages() {
        return this.messages;
    }
}
