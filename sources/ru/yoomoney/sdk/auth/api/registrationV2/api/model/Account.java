package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u001a\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/Account;", "", "uid", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "services", "", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/Service;", "logoUrl", "migrationRequired", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "getLogoUrl", "()Ljava/lang/String;", "getMigrationRequired", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getServices", "()Ljava/util/List;", "getTitle", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)Lru/yoomoney/sdk/auth/api/registrationV2/api/model/Account;", "equals", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Account {
    private final String logoUrl;
    private final Boolean migrationRequired;
    private final List<Service> services;
    private final String title;
    private final String uid;

    public Account(@JsonProperty("uid") String uid, @JsonProperty(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) String title, @JsonProperty("services") List<Service> services, @JsonProperty("logoUrl") String str, @JsonProperty("migrationRequired") Boolean bool) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(services, "services");
        this.uid = uid;
        this.title = title;
        this.services = services;
        this.logoUrl = str;
        this.migrationRequired = bool;
    }

    public static /* synthetic */ Account copy$default(Account account, String str, String str2, List list, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = account.uid;
        }
        if ((i & 2) != 0) {
            str2 = account.title;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            list = account.services;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            str3 = account.logoUrl;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            bool = account.migrationRequired;
        }
        return account.copy(str, str4, list2, str5, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<Service> component3() {
        return this.services;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getMigrationRequired() {
        return this.migrationRequired;
    }

    public final Account copy(@JsonProperty("uid") String uid, @JsonProperty(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) String title, @JsonProperty("services") List<Service> services, @JsonProperty("logoUrl") String logoUrl, @JsonProperty("migrationRequired") Boolean migrationRequired) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(services, "services");
        return new Account(uid, title, services, logoUrl, migrationRequired);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Account)) {
            return false;
        }
        Account account = (Account) other;
        return Intrinsics.areEqual(this.uid, account.uid) && Intrinsics.areEqual(this.title, account.title) && Intrinsics.areEqual(this.services, account.services) && Intrinsics.areEqual(this.logoUrl, account.logoUrl) && Intrinsics.areEqual(this.migrationRequired, account.migrationRequired);
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final Boolean getMigrationRequired() {
        return this.migrationRequired;
    }

    public final List<Service> getServices() {
        return this.services;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        int iHashCode = (this.services.hashCode() + a.a(this.title, this.uid.hashCode() * 31, 31)) * 31;
        String str = this.logoUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.migrationRequired;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "Account(uid=" + this.uid + ", title=" + this.title + ", services=" + this.services + ", logoUrl=" + this.logoUrl + ", migrationRequired=" + this.migrationRequired + ")";
    }

    public /* synthetic */ Account(String str, String str2, List list, String str3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : bool);
    }
}
