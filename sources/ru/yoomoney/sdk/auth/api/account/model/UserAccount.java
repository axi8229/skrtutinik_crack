package ru.yoomoney.sdk.auth.api.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Scopes;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011¢\u0006\u0002\u0010\u0015J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\t\u0010-\u001a\u00020\u000fHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011HÆ\u0003Jq\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011HÆ\u0001J\t\u00101\u001a\u000202HÖ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000202HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000202HÖ\u0001R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006>"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "Landroid/os/Parcelable;", "uid", "", Scopes.EMAIL, "Lru/yoomoney/sdk/auth/api/account/model/EmailInfo;", "phone", "Lru/yoomoney/sdk/auth/api/account/model/PhoneInfo;", "displayName", "Lru/yoomoney/sdk/auth/api/account/model/DisplayNameInfo;", "password", "Lru/yoomoney/sdk/auth/api/account/model/PasswordInfo;", "avatar", "Lru/yoomoney/sdk/auth/api/account/model/AvatarInfo;", FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "Lru/yoomoney/sdk/auth/api/account/model/LanguageInfo;", "services", "", "Lru/yoomoney/sdk/auth/api/account/model/Service;", "socialAccounts", "Lru/yoomoney/sdk/auth/api/account/model/SocialAccount;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/model/EmailInfo;Lru/yoomoney/sdk/auth/api/account/model/PhoneInfo;Lru/yoomoney/sdk/auth/api/account/model/DisplayNameInfo;Lru/yoomoney/sdk/auth/api/account/model/PasswordInfo;Lru/yoomoney/sdk/auth/api/account/model/AvatarInfo;Lru/yoomoney/sdk/auth/api/account/model/LanguageInfo;Ljava/util/List;Ljava/util/List;)V", "getAvatar", "()Lru/yoomoney/sdk/auth/api/account/model/AvatarInfo;", "getDisplayName", "()Lru/yoomoney/sdk/auth/api/account/model/DisplayNameInfo;", "getEmail", "()Lru/yoomoney/sdk/auth/api/account/model/EmailInfo;", "getLanguage", "()Lru/yoomoney/sdk/auth/api/account/model/LanguageInfo;", "getPassword", "()Lru/yoomoney/sdk/auth/api/account/model/PasswordInfo;", "getPhone", "()Lru/yoomoney/sdk/auth/api/account/model/PhoneInfo;", "getServices", "()Ljava/util/List;", "getSocialAccounts", "getUid", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserAccount implements Parcelable {
    public static final Parcelable.Creator<UserAccount> CREATOR = new Creator();

    @SerializedName("avatar")
    private final AvatarInfo avatar;

    @SerializedName("displayName")
    private final DisplayNameInfo displayName;

    @SerializedName(Scopes.EMAIL)
    private final EmailInfo email;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE)
    private final LanguageInfo language;

    @SerializedName("password")
    private final PasswordInfo password;

    @SerializedName("phone")
    private final PhoneInfo phone;

    @SerializedName("services")
    private final List<Service> services;

    @SerializedName("socialAccounts")
    private final List<SocialAccount> socialAccounts;

    @SerializedName("uid")
    private final String uid;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserAccount> {
        @Override // android.os.Parcelable.Creator
        public final UserAccount createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            EmailInfo emailInfoCreateFromParcel = EmailInfo.CREATOR.createFromParcel(parcel);
            PhoneInfo phoneInfoCreateFromParcel = PhoneInfo.CREATOR.createFromParcel(parcel);
            DisplayNameInfo displayNameInfoCreateFromParcel = DisplayNameInfo.CREATOR.createFromParcel(parcel);
            PasswordInfo passwordInfoCreateFromParcel = PasswordInfo.CREATOR.createFromParcel(parcel);
            AvatarInfo avatarInfoCreateFromParcel = AvatarInfo.CREATOR.createFromParcel(parcel);
            LanguageInfo languageInfoCreateFromParcel = LanguageInfo.CREATOR.createFromParcel(parcel);
            int i = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList2.add(Service.CREATOR.createFromParcel(parcel));
            }
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i3 = parcel.readInt();
                arrayList = new ArrayList(i3);
                for (int i4 = 0; i4 != i3; i4++) {
                    arrayList.add(SocialAccount.CREATOR.createFromParcel(parcel));
                }
            }
            return new UserAccount(string, emailInfoCreateFromParcel, phoneInfoCreateFromParcel, displayNameInfoCreateFromParcel, passwordInfoCreateFromParcel, avatarInfoCreateFromParcel, languageInfoCreateFromParcel, arrayList2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final UserAccount[] newArray(int i) {
            return new UserAccount[i];
        }
    }

    public UserAccount(String uid, EmailInfo email, PhoneInfo phone, DisplayNameInfo displayName, PasswordInfo password, AvatarInfo avatar, LanguageInfo language, List<Service> services, List<SocialAccount> list) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(services, "services");
        this.uid = uid;
        this.email = email;
        this.phone = phone;
        this.displayName = displayName;
        this.password = password;
        this.avatar = avatar;
        this.language = language;
        this.services = services;
        this.socialAccounts = list;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component2, reason: from getter */
    public final EmailInfo getEmail() {
        return this.email;
    }

    /* renamed from: component3, reason: from getter */
    public final PhoneInfo getPhone() {
        return this.phone;
    }

    /* renamed from: component4, reason: from getter */
    public final DisplayNameInfo getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component5, reason: from getter */
    public final PasswordInfo getPassword() {
        return this.password;
    }

    /* renamed from: component6, reason: from getter */
    public final AvatarInfo getAvatar() {
        return this.avatar;
    }

    /* renamed from: component7, reason: from getter */
    public final LanguageInfo getLanguage() {
        return this.language;
    }

    public final List<Service> component8() {
        return this.services;
    }

    public final List<SocialAccount> component9() {
        return this.socialAccounts;
    }

    public final UserAccount copy(String uid, EmailInfo email, PhoneInfo phone, DisplayNameInfo displayName, PasswordInfo password, AvatarInfo avatar, LanguageInfo language, List<Service> services, List<SocialAccount> socialAccounts) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(services, "services");
        return new UserAccount(uid, email, phone, displayName, password, avatar, language, services, socialAccounts);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAccount)) {
            return false;
        }
        UserAccount userAccount = (UserAccount) other;
        return Intrinsics.areEqual(this.uid, userAccount.uid) && Intrinsics.areEqual(this.email, userAccount.email) && Intrinsics.areEqual(this.phone, userAccount.phone) && Intrinsics.areEqual(this.displayName, userAccount.displayName) && Intrinsics.areEqual(this.password, userAccount.password) && Intrinsics.areEqual(this.avatar, userAccount.avatar) && Intrinsics.areEqual(this.language, userAccount.language) && Intrinsics.areEqual(this.services, userAccount.services) && Intrinsics.areEqual(this.socialAccounts, userAccount.socialAccounts);
    }

    public final AvatarInfo getAvatar() {
        return this.avatar;
    }

    public final DisplayNameInfo getDisplayName() {
        return this.displayName;
    }

    public final EmailInfo getEmail() {
        return this.email;
    }

    public final LanguageInfo getLanguage() {
        return this.language;
    }

    public final PasswordInfo getPassword() {
        return this.password;
    }

    public final PhoneInfo getPhone() {
        return this.phone;
    }

    public final List<Service> getServices() {
        return this.services;
    }

    public final List<SocialAccount> getSocialAccounts() {
        return this.socialAccounts;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        int iHashCode = (this.services.hashCode() + ((this.language.hashCode() + ((this.avatar.hashCode() + ((this.password.hashCode() + ((this.displayName.hashCode() + ((this.phone.hashCode() + ((this.email.hashCode() + (this.uid.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        List<SocialAccount> list = this.socialAccounts;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "UserAccount(uid=" + this.uid + ", email=" + this.email + ", phone=" + this.phone + ", displayName=" + this.displayName + ", password=" + this.password + ", avatar=" + this.avatar + ", language=" + this.language + ", services=" + this.services + ", socialAccounts=" + this.socialAccounts + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uid);
        this.email.writeToParcel(parcel, flags);
        this.phone.writeToParcel(parcel, flags);
        this.displayName.writeToParcel(parcel, flags);
        this.password.writeToParcel(parcel, flags);
        this.avatar.writeToParcel(parcel, flags);
        this.language.writeToParcel(parcel, flags);
        List<Service> list = this.services;
        parcel.writeInt(list.size());
        Iterator<Service> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        List<SocialAccount> list2 = this.socialAccounts;
        if (list2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list2.size());
        Iterator<SocialAccount> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }
}
