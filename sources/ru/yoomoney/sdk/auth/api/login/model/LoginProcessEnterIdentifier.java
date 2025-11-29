package ru.yoomoney.sdk.auth.api.login.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterIdentifier;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "id", "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "addToBackStack", "", "migrationInfo", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;ZLjava/lang/String;)V", "getAddToBackStack", "()Z", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getId", "()Ljava/lang/String;", "getMigrationInfo", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoginProcessEnterIdentifier extends LoginProcess {

    @SerializedName("addToBackStack")
    private final boolean addToBackStack;

    @SerializedName("expireAt")
    private final OffsetDateTime expireAt;

    @SerializedName("id")
    private final String id;

    @SerializedName("migrationInfo")
    private final String migrationInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginProcessEnterIdentifier(String id, OffsetDateTime expireAt, boolean z, String str) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        this.id = id;
        this.expireAt = expireAt;
        this.addToBackStack = z;
        this.migrationInfo = str;
    }

    public static /* synthetic */ LoginProcessEnterIdentifier copy$default(LoginProcessEnterIdentifier loginProcessEnterIdentifier, String str, OffsetDateTime offsetDateTime, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginProcessEnterIdentifier.id;
        }
        if ((i & 2) != 0) {
            offsetDateTime = loginProcessEnterIdentifier.expireAt;
        }
        if ((i & 4) != 0) {
            z = loginProcessEnterIdentifier.addToBackStack;
        }
        if ((i & 8) != 0) {
            str2 = loginProcessEnterIdentifier.migrationInfo;
        }
        return loginProcessEnterIdentifier.copy(str, offsetDateTime, z, str2);
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
    public final String getMigrationInfo() {
        return this.migrationInfo;
    }

    public final LoginProcessEnterIdentifier copy(String id, OffsetDateTime expireAt, boolean addToBackStack, String migrationInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(expireAt, "expireAt");
        return new LoginProcessEnterIdentifier(id, expireAt, addToBackStack, migrationInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginProcessEnterIdentifier)) {
            return false;
        }
        LoginProcessEnterIdentifier loginProcessEnterIdentifier = (LoginProcessEnterIdentifier) other;
        return Intrinsics.areEqual(this.id, loginProcessEnterIdentifier.id) && Intrinsics.areEqual(this.expireAt, loginProcessEnterIdentifier.expireAt) && this.addToBackStack == loginProcessEnterIdentifier.addToBackStack && Intrinsics.areEqual(this.migrationInfo, loginProcessEnterIdentifier.migrationInfo);
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

    public final String getMigrationInfo() {
        return this.migrationInfo;
    }

    public int hashCode() {
        int iA = b.a(this.addToBackStack, ru.yoomoney.sdk.auth.api.account.model.b.a(this.expireAt, this.id.hashCode() * 31, 31), 31);
        String str = this.migrationInfo;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LoginProcessEnterIdentifier(id=" + this.id + ", expireAt=" + this.expireAt + ", addToBackStack=" + this.addToBackStack + ", migrationInfo=" + this.migrationInfo + ")";
    }
}
