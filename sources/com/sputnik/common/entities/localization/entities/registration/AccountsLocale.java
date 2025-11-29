package com.sputnik.common.entities.localization.entities.registration;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountsLocale.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/registration/AccountsLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/registration/AccountsBodyLocale;", "body", "Lcom/sputnik/common/entities/localization/entities/registration/DeleteAccountBodyLocale;", "deleteAccountBottomSheet", "Lcom/sputnik/common/entities/localization/entities/registration/AccountErrors;", "errors", "<init>", "(Lcom/sputnik/common/entities/localization/entities/registration/AccountsBodyLocale;Lcom/sputnik/common/entities/localization/entities/registration/DeleteAccountBodyLocale;Lcom/sputnik/common/entities/localization/entities/registration/AccountErrors;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/registration/AccountsBodyLocale;", "getBody", "()Lcom/sputnik/common/entities/localization/entities/registration/AccountsBodyLocale;", "Lcom/sputnik/common/entities/localization/entities/registration/DeleteAccountBodyLocale;", "getDeleteAccountBottomSheet", "()Lcom/sputnik/common/entities/localization/entities/registration/DeleteAccountBodyLocale;", "Lcom/sputnik/common/entities/localization/entities/registration/AccountErrors;", "getErrors", "()Lcom/sputnik/common/entities/localization/entities/registration/AccountErrors;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AccountsLocale implements Parcelable {
    public static final Parcelable.Creator<AccountsLocale> CREATOR = new Creator();
    private final AccountsBodyLocale body;

    @SerializedName("delete_bottom_sheet")
    private final DeleteAccountBodyLocale deleteAccountBottomSheet;
    private final AccountErrors errors;

    /* compiled from: AccountsLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AccountsLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AccountsLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AccountsLocale(AccountsBodyLocale.CREATOR.createFromParcel(parcel), DeleteAccountBodyLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AccountErrors.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AccountsLocale[] newArray(int i) {
            return new AccountsLocale[i];
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
        if (!(other instanceof AccountsLocale)) {
            return false;
        }
        AccountsLocale accountsLocale = (AccountsLocale) other;
        return Intrinsics.areEqual(this.body, accountsLocale.body) && Intrinsics.areEqual(this.deleteAccountBottomSheet, accountsLocale.deleteAccountBottomSheet) && Intrinsics.areEqual(this.errors, accountsLocale.errors);
    }

    public int hashCode() {
        int iHashCode = ((this.body.hashCode() * 31) + this.deleteAccountBottomSheet.hashCode()) * 31;
        AccountErrors accountErrors = this.errors;
        return iHashCode + (accountErrors == null ? 0 : accountErrors.hashCode());
    }

    public String toString() {
        return "AccountsLocale(body=" + this.body + ", deleteAccountBottomSheet=" + this.deleteAccountBottomSheet + ", errors=" + this.errors + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.body.writeToParcel(parcel, flags);
        this.deleteAccountBottomSheet.writeToParcel(parcel, flags);
        AccountErrors accountErrors = this.errors;
        if (accountErrors == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            accountErrors.writeToParcel(parcel, flags);
        }
    }

    public AccountsLocale(AccountsBodyLocale body, DeleteAccountBodyLocale deleteAccountBottomSheet, AccountErrors accountErrors) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(deleteAccountBottomSheet, "deleteAccountBottomSheet");
        this.body = body;
        this.deleteAccountBottomSheet = deleteAccountBottomSheet;
        this.errors = accountErrors;
    }

    public final AccountsBodyLocale getBody() {
        return this.body;
    }

    public final DeleteAccountBodyLocale getDeleteAccountBottomSheet() {
        return this.deleteAccountBottomSheet;
    }

    public final AccountErrors getErrors() {
        return this.errors;
    }
}
