package ru.yoomoney.sdk.auth.api.account.method;

import com.google.android.gms.common.Scopes;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.model.AvatarInfo;
import ru.yoomoney.sdk.auth.api.account.model.DisplayNameInfo;
import ru.yoomoney.sdk.auth.api.account.model.EmailInfo;
import ru.yoomoney.sdk.auth.api.account.model.LanguageInfo;
import ru.yoomoney.sdk.auth.api.account.model.PasswordInfo;
import ru.yoomoney.sdk.auth.api.account.model.PhoneInfo;
import ru.yoomoney.sdk.auth.api.account.model.Service;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J_\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00063"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/method/LanguageResponse;", "", "uid", "", Scopes.EMAIL, "Lru/yoomoney/sdk/auth/api/account/model/EmailInfo;", "phone", "Lru/yoomoney/sdk/auth/api/account/model/PhoneInfo;", "displayName", "Lru/yoomoney/sdk/auth/api/account/model/DisplayNameInfo;", "password", "Lru/yoomoney/sdk/auth/api/account/model/PasswordInfo;", "avatar", "Lru/yoomoney/sdk/auth/api/account/model/AvatarInfo;", FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "Lru/yoomoney/sdk/auth/api/account/model/LanguageInfo;", "services", "", "Lru/yoomoney/sdk/auth/api/account/model/Service;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/model/EmailInfo;Lru/yoomoney/sdk/auth/api/account/model/PhoneInfo;Lru/yoomoney/sdk/auth/api/account/model/DisplayNameInfo;Lru/yoomoney/sdk/auth/api/account/model/PasswordInfo;Lru/yoomoney/sdk/auth/api/account/model/AvatarInfo;Lru/yoomoney/sdk/auth/api/account/model/LanguageInfo;Ljava/util/List;)V", "getAvatar", "()Lru/yoomoney/sdk/auth/api/account/model/AvatarInfo;", "getDisplayName", "()Lru/yoomoney/sdk/auth/api/account/model/DisplayNameInfo;", "getEmail", "()Lru/yoomoney/sdk/auth/api/account/model/EmailInfo;", "getLanguage", "()Lru/yoomoney/sdk/auth/api/account/model/LanguageInfo;", "getPassword", "()Lru/yoomoney/sdk/auth/api/account/model/PasswordInfo;", "getPhone", "()Lru/yoomoney/sdk/auth/api/account/model/PhoneInfo;", "getServices", "()Ljava/util/List;", "getUid", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LanguageResponse {

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

    @SerializedName("uid")
    private final String uid;

    public LanguageResponse(String uid, EmailInfo email, PhoneInfo phone, DisplayNameInfo displayName, PasswordInfo password, AvatarInfo avatar, LanguageInfo language, List<Service> services) {
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

    public final LanguageResponse copy(String uid, EmailInfo email, PhoneInfo phone, DisplayNameInfo displayName, PasswordInfo password, AvatarInfo avatar, LanguageInfo language, List<Service> services) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(services, "services");
        return new LanguageResponse(uid, email, phone, displayName, password, avatar, language, services);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguageResponse)) {
            return false;
        }
        LanguageResponse languageResponse = (LanguageResponse) other;
        return Intrinsics.areEqual(this.uid, languageResponse.uid) && Intrinsics.areEqual(this.email, languageResponse.email) && Intrinsics.areEqual(this.phone, languageResponse.phone) && Intrinsics.areEqual(this.displayName, languageResponse.displayName) && Intrinsics.areEqual(this.password, languageResponse.password) && Intrinsics.areEqual(this.avatar, languageResponse.avatar) && Intrinsics.areEqual(this.language, languageResponse.language) && Intrinsics.areEqual(this.services, languageResponse.services);
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

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return this.services.hashCode() + ((this.language.hashCode() + ((this.avatar.hashCode() + ((this.password.hashCode() + ((this.displayName.hashCode() + ((this.phone.hashCode() + ((this.email.hashCode() + (this.uid.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "LanguageResponse(uid=" + this.uid + ", email=" + this.email + ", phone=" + this.phone + ", displayName=" + this.displayName + ", password=" + this.password + ", avatar=" + this.avatar + ", language=" + this.language + ", services=" + this.services + ")";
    }
}
