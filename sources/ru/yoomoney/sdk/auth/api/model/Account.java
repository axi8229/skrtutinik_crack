package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.account.model.Service;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006("}, d2 = {"Lru/yoomoney/sdk/auth/api/model/Account;", "Landroid/os/Parcelable;", "uid", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "logoUrl", "migrationRequired", "", "services", "", "Lru/yoomoney/sdk/auth/api/account/model/Service;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getLogoUrl", "()Ljava/lang/String;", "getMigrationRequired", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getServices", "()Ljava/util/List;", "getTitle", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lru/yoomoney/sdk/auth/api/model/Account;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Account implements Parcelable {
    public static final Parcelable.Creator<Account> CREATOR = new Creator();

    @SerializedName("logoUrl")
    private final String logoUrl;

    @SerializedName("migrationRequired")
    private final Boolean migrationRequired;

    @SerializedName("services")
    private final List<Service> services;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final String title;

    @SerializedName("uid")
    private final String uid;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Account> {
        @Override // android.os.Parcelable.Creator
        public final Account createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Service.CREATOR.createFromParcel(parcel));
            }
            return new Account(string, string2, string3, boolValueOf, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final Account[] newArray(int i) {
            return new Account[i];
        }
    }

    public Account(String uid, String title, String str, Boolean bool, List<Service> services) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(services, "services");
        this.uid = uid;
        this.title = title;
        this.logoUrl = str;
        this.migrationRequired = bool;
        this.services = services;
    }

    public static /* synthetic */ Account copy$default(Account account, String str, String str2, String str3, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = account.uid;
        }
        if ((i & 2) != 0) {
            str2 = account.title;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = account.logoUrl;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            bool = account.migrationRequired;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            list = account.services;
        }
        return account.copy(str, str4, str5, bool2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getMigrationRequired() {
        return this.migrationRequired;
    }

    public final List<Service> component5() {
        return this.services;
    }

    public final Account copy(String uid, String title, String logoUrl, Boolean migrationRequired, List<Service> services) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(services, "services");
        return new Account(uid, title, logoUrl, migrationRequired, services);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Account)) {
            return false;
        }
        Account account = (Account) other;
        return Intrinsics.areEqual(this.uid, account.uid) && Intrinsics.areEqual(this.title, account.title) && Intrinsics.areEqual(this.logoUrl, account.logoUrl) && Intrinsics.areEqual(this.migrationRequired, account.migrationRequired) && Intrinsics.areEqual(this.services, account.services);
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
        int iA = a.a(this.title, this.uid.hashCode() * 31, 31);
        String str = this.logoUrl;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.migrationRequired;
        return this.services.hashCode() + ((iHashCode + (bool != null ? bool.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "Account(uid=" + this.uid + ", title=" + this.title + ", logoUrl=" + this.logoUrl + ", migrationRequired=" + this.migrationRequired + ", services=" + this.services + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iBooleanValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uid);
        parcel.writeString(this.title);
        parcel.writeString(this.logoUrl);
        Boolean bool = this.migrationRequired;
        if (bool == null) {
            iBooleanValue = 0;
        } else {
            parcel.writeInt(1);
            iBooleanValue = bool.booleanValue();
        }
        parcel.writeInt(iBooleanValue);
        List<Service> list = this.services;
        parcel.writeInt(list.size());
        Iterator<Service> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }
}
