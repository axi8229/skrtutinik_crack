package ru.yoomoney.sdk.auth.api.login.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterPassword;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", "account", "Lru/yoomoney/sdk/auth/api/model/Account;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLru/yoomoney/sdk/auth/api/model/Account;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/model/Account;", "getAddToBackStack", "()Z", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoginProcessEnterPassword extends LoginProcess {

    @SerializedName("account")
    private final Account account;

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginProcessEnterPassword(String id, OffsetDateTime expireAt, boolean z, Account account) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.account = account;
    }

    public static /* synthetic */ LoginProcessEnterPassword copy$default(LoginProcessEnterPassword loginProcessEnterPassword, String str, OffsetDateTime offsetDateTime, boolean z, Account account, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginProcessEnterPassword.id;
        }
        if ((i & 2) != 0) {
            offsetDateTime = loginProcessEnterPassword.expireAt;
        }
        if ((i & 4) != 0) {
            z = loginProcessEnterPassword.addToBackStack;
        }
        if ((i & 8) != 0) {
            account = loginProcessEnterPassword.account;
        }
        return loginProcessEnterPassword.copy(str, offsetDateTime, z, account);
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

    /* renamed from: component4, reason: from getter */
    public final Account getAccount() {
        return this.account;
    }

    public final LoginProcessEnterPassword copy(String id, OffsetDateTime expireAt, boolean addToBackStack, Account account) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        return new LoginProcessEnterPassword(id, expireAt, addToBackStack, account);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginProcessEnterPassword)) {
            return false;
        }
        LoginProcessEnterPassword loginProcessEnterPassword = (LoginProcessEnterPassword) other;
        return Intrinsics.areEqual(this.id, loginProcessEnterPassword.id) && Intrinsics.areEqual(this.expireAt, loginProcessEnterPassword.expireAt) && this.addToBackStack == loginProcessEnterPassword.addToBackStack && Intrinsics.areEqual(this.account, loginProcessEnterPassword.account);
    }

    public final Account getAccount() {
        return this.account;
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
        int iA = b.a(this.addToBackStack, ru.yoomoney.sdk.auth.api.account.model.b.a(this.expireAt, this.id.hashCode() * 31, 31), 31);
        Account account = this.account;
        return iA + (account == null ? 0 : account.hashCode());
    }

    public String toString() {
        return "LoginProcessEnterPassword(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", account=" + this.account + ")";
    }
}
