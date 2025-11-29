package com.sputnik.common.entities.localization.entities.registration;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountsLocale.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001f\u0010\n¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/entities/registration/AccountsBodyLocale;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "createButton", "noAccounts", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCreateButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNoAccounts", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AccountsBodyLocale implements Parcelable {
    public static final Parcelable.Creator<AccountsBodyLocale> CREATOR = new Creator();

    @SerializedName("create_button")
    private final TextTitle createButton;

    @SerializedName("no_accounts")
    private final String noAccounts;
    private final String title;

    /* compiled from: AccountsLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AccountsBodyLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AccountsBodyLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AccountsBodyLocale(parcel.readString(), TextTitle.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AccountsBodyLocale[] newArray(int i) {
            return new AccountsBodyLocale[i];
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
        if (!(other instanceof AccountsBodyLocale)) {
            return false;
        }
        AccountsBodyLocale accountsBodyLocale = (AccountsBodyLocale) other;
        return Intrinsics.areEqual(this.title, accountsBodyLocale.title) && Intrinsics.areEqual(this.createButton, accountsBodyLocale.createButton) && Intrinsics.areEqual(this.noAccounts, accountsBodyLocale.noAccounts);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.createButton.hashCode()) * 31;
        String str2 = this.noAccounts;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AccountsBodyLocale(title=" + this.title + ", createButton=" + this.createButton + ", noAccounts=" + this.noAccounts + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        this.createButton.writeToParcel(parcel, flags);
        parcel.writeString(this.noAccounts);
    }

    public AccountsBodyLocale(String str, TextTitle createButton, String str2) {
        Intrinsics.checkNotNullParameter(createButton, "createButton");
        this.title = str;
        this.createButton = createButton;
        this.noAccounts = str2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TextTitle getCreateButton() {
        return this.createButton;
    }

    public final String getNoAccounts() {
        return this.noAccounts;
    }
}
