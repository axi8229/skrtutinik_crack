package ru.yoomoney.sdk.auth.api.login.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/model/LoginProcessChooseAccount;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", "accounts", "", "Lru/yoomoney/sdk/auth/api/model/Account;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLjava/util/List;)V", "getAccounts", "()Ljava/util/List;", "getAddToBackStack", "()Z", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoginProcessChooseAccount extends LoginProcess {

    @SerializedName("accounts")
    private final List<Account> accounts;

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginProcessChooseAccount(String id, OffsetDateTime expireAt, boolean z, List<Account> accounts) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(accounts, "accounts");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.accounts = accounts;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoginProcessChooseAccount copy$default(LoginProcessChooseAccount loginProcessChooseAccount, String str, OffsetDateTime offsetDateTime, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginProcessChooseAccount.id;
        }
        if ((i & 2) != 0) {
            offsetDateTime = loginProcessChooseAccount.expireAt;
        }
        if ((i & 4) != 0) {
            z = loginProcessChooseAccount.addToBackStack;
        }
        if ((i & 8) != 0) {
            list = loginProcessChooseAccount.accounts;
        }
        return loginProcessChooseAccount.copy(str, offsetDateTime, z, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final List<Account> component4() {
        return this.accounts;
    }

    public final LoginProcessChooseAccount copy(String id, OffsetDateTime expireAt, boolean addToBackStack, List<Account> accounts) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        Intrinsics.checkNotNullParameter(accounts, "accounts");
        return new LoginProcessChooseAccount(id, expireAt, addToBackStack, accounts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginProcessChooseAccount)) {
            return false;
        }
        LoginProcessChooseAccount loginProcessChooseAccount = (LoginProcessChooseAccount) other;
        return Intrinsics.areEqual(this.id, loginProcessChooseAccount.id) && Intrinsics.areEqual(this.expireAt, loginProcessChooseAccount.expireAt) && this.addToBackStack == loginProcessChooseAccount.addToBackStack && Intrinsics.areEqual(this.accounts, loginProcessChooseAccount.accounts);
    }

    public final List<Account> getAccounts() {
        return this.accounts;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public OffsetDateTime getExpireAt() {
        return this.expireAt;
    }

    @Override // ru.yoomoney.sdk.auth.api.Process
    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.accounts.hashCode() + b.a(this.addToBackStack, ru.yoomoney.sdk.auth.api.account.model.b.a(this.expireAt, this.id.hashCode() * 31, 31), 31);
    }

    public String toString() {
        return "LoginProcessChooseAccount(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", accounts=" + this.accounts + ")";
    }
}
