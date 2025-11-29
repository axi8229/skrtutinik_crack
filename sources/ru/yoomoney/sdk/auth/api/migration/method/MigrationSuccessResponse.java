package ru.yoomoney.sdk.auth.api.migration.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcess;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/method/MigrationSuccessResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationResponse;", "process", "Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", YooMoneyAuth.KEY_TMX_SESSION_ID, "", "(Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;Ljava/lang/String;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/migration/model/MigrationProcess;", "getTmxSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MigrationSuccessResponse extends MigrationResponse {

    @SerializedName("process")
    private final MigrationProcess process;

    @SerializedName(YooMoneyAuth.KEY_TMX_SESSION_ID)
    private final String tmxSessionId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationSuccessResponse(MigrationProcess process, String str) {
        super(null);
        Intrinsics.checkNotNullParameter(process, "process");
        this.process = process;
        this.tmxSessionId = str;
    }

    public static /* synthetic */ MigrationSuccessResponse copy$default(MigrationSuccessResponse migrationSuccessResponse, MigrationProcess migrationProcess, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            migrationProcess = migrationSuccessResponse.process;
        }
        if ((i & 2) != 0) {
            str = migrationSuccessResponse.tmxSessionId;
        }
        return migrationSuccessResponse.copy(migrationProcess, str);
    }

    /* renamed from: component1, reason: from getter */
    public final MigrationProcess getProcess() {
        return this.process;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public final MigrationSuccessResponse copy(MigrationProcess process, String tmxSessionId) {
        Intrinsics.checkNotNullParameter(process, "process");
        return new MigrationSuccessResponse(process, tmxSessionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MigrationSuccessResponse)) {
            return false;
        }
        MigrationSuccessResponse migrationSuccessResponse = (MigrationSuccessResponse) other;
        return Intrinsics.areEqual(this.process, migrationSuccessResponse.process) && Intrinsics.areEqual(this.tmxSessionId, migrationSuccessResponse.tmxSessionId);
    }

    public final MigrationProcess getProcess() {
        return this.process;
    }

    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public int hashCode() {
        int iHashCode = this.process.hashCode() * 31;
        String str = this.tmxSessionId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "MigrationSuccessResponse(process=" + this.process + ", tmxSessionId=" + this.tmxSessionId + ")";
    }
}
