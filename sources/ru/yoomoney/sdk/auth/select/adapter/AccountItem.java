package ru.yoomoney.sdk.auth.select.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.model.Account;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/select/adapter/AccountItem;", "Lru/yoomoney/sdk/auth/select/adapter/SelectAccountItem;", "account", "Lru/yoomoney/sdk/auth/api/model/Account;", "showServices", "", "(Lru/yoomoney/sdk/auth/api/model/Account;Z)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/model/Account;", "getShowServices", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AccountItem extends SelectAccountItem {
    private final Account account;
    private final boolean showServices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountItem(Account account, boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(account, "account");
        this.account = account;
        this.showServices = z;
    }

    public static /* synthetic */ AccountItem copy$default(AccountItem accountItem, Account account, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            account = accountItem.account;
        }
        if ((i & 2) != 0) {
            z = accountItem.showServices;
        }
        return accountItem.copy(account, z);
    }

    /* renamed from: component1, reason: from getter */
    public final Account getAccount() {
        return this.account;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getShowServices() {
        return this.showServices;
    }

    public final AccountItem copy(Account account, boolean showServices) {
        Intrinsics.checkNotNullParameter(account, "account");
        return new AccountItem(account, showServices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountItem)) {
            return false;
        }
        AccountItem accountItem = (AccountItem) other;
        return Intrinsics.areEqual(this.account, accountItem.account) && this.showServices == accountItem.showServices;
    }

    public final Account getAccount() {
        return this.account;
    }

    public final boolean getShowServices() {
        return this.showServices;
    }

    public int hashCode() {
        return Boolean.hashCode(this.showServices) + (this.account.hashCode() * 31);
    }

    public String toString() {
        return "AccountItem(account=" + this.account + ", showServices=" + this.showServices + ")";
    }
}
