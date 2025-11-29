package ru.yoomoney.sdk.auth.api.migration.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationRequest;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/method/MigrationLoginRequest;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationRequest;", "loginProcessId", "", "uid", "(Ljava/lang/String;Ljava/lang/String;)V", "getLoginProcessId", "()Ljava/lang/String;", "getUid", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MigrationLoginRequest extends MigrationRequest {

    @SerializedName("loginProcessId")
    private final String loginProcessId;

    @SerializedName("uid")
    private final String uid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationLoginRequest(String loginProcessId, String uid) {
        super(MigrationRequest.Type.LOGIN, null);
        Intrinsics.checkNotNullParameter(loginProcessId, "loginProcessId");
        Intrinsics.checkNotNullParameter(uid, "uid");
        this.loginProcessId = loginProcessId;
        this.uid = uid;
    }

    public static /* synthetic */ MigrationLoginRequest copy$default(MigrationLoginRequest migrationLoginRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = migrationLoginRequest.loginProcessId;
        }
        if ((i & 2) != 0) {
            str2 = migrationLoginRequest.uid;
        }
        return migrationLoginRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLoginProcessId() {
        return this.loginProcessId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    public final MigrationLoginRequest copy(String loginProcessId, String uid) {
        Intrinsics.checkNotNullParameter(loginProcessId, "loginProcessId");
        Intrinsics.checkNotNullParameter(uid, "uid");
        return new MigrationLoginRequest(loginProcessId, uid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MigrationLoginRequest)) {
            return false;
        }
        MigrationLoginRequest migrationLoginRequest = (MigrationLoginRequest) other;
        return Intrinsics.areEqual(this.loginProcessId, migrationLoginRequest.loginProcessId) && Intrinsics.areEqual(this.uid, migrationLoginRequest.uid);
    }

    public final String getLoginProcessId() {
        return this.loginProcessId;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return this.uid.hashCode() + (this.loginProcessId.hashCode() * 31);
    }

    public String toString() {
        return "MigrationLoginRequest(loginProcessId=" + this.loginProcessId + ", uid=" + this.uid + ")";
    }
}
