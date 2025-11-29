package ru.yoomoney.sdk.auth.api.migration.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.model.ProcessError;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailErrorResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailResponse;", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "(Lru/yoomoney/sdk/auth/api/model/ProcessError;)V", "getError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "setError", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MigrationSetEmailErrorResponse extends MigrationSetEmailResponse {

    @SerializedName("error")
    private ProcessError error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationSetEmailErrorResponse(ProcessError error) {
        super(null);
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ MigrationSetEmailErrorResponse copy$default(MigrationSetEmailErrorResponse migrationSetEmailErrorResponse, ProcessError processError, int i, Object obj) {
        if ((i & 1) != 0) {
            processError = migrationSetEmailErrorResponse.error;
        }
        return migrationSetEmailErrorResponse.copy(processError);
    }

    /* renamed from: component1, reason: from getter */
    public final ProcessError getError() {
        return this.error;
    }

    public final MigrationSetEmailErrorResponse copy(ProcessError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new MigrationSetEmailErrorResponse(error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MigrationSetEmailErrorResponse) && Intrinsics.areEqual(this.error, ((MigrationSetEmailErrorResponse) other).error);
    }

    public final ProcessError getError() {
        return this.error;
    }

    public int hashCode() {
        return this.error.hashCode();
    }

    public final void setError(ProcessError processError) {
        Intrinsics.checkNotNullParameter(processError, "<set-?>");
        this.error = processError;
    }

    public String toString() {
        return "MigrationSetEmailErrorResponse(error=" + this.error + ")";
    }
}
