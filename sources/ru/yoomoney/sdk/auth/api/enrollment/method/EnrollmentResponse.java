package ru.yoomoney.sdk.auth.api.enrollment.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentResponse;", "", "process", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", YooMoneyAuth.KEY_TMX_SESSION_ID, "", "(Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;Ljava/lang/String;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "getTmxSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnrollmentResponse {

    @SerializedName("process")
    private final EnrollmentProcess process;

    @SerializedName(YooMoneyAuth.KEY_TMX_SESSION_ID)
    private final String tmxSessionId;

    public EnrollmentResponse(EnrollmentProcess process, String str) {
        Intrinsics.checkNotNullParameter(process, "process");
        this.process = process;
        this.tmxSessionId = str;
    }

    public static /* synthetic */ EnrollmentResponse copy$default(EnrollmentResponse enrollmentResponse, EnrollmentProcess enrollmentProcess, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            enrollmentProcess = enrollmentResponse.process;
        }
        if ((i & 2) != 0) {
            str = enrollmentResponse.tmxSessionId;
        }
        return enrollmentResponse.copy(enrollmentProcess, str);
    }

    /* renamed from: component1, reason: from getter */
    public final EnrollmentProcess getProcess() {
        return this.process;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTmxSessionId() {
        return this.tmxSessionId;
    }

    public final EnrollmentResponse copy(EnrollmentProcess process, String tmxSessionId) {
        Intrinsics.checkNotNullParameter(process, "process");
        return new EnrollmentResponse(process, tmxSessionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnrollmentResponse)) {
            return false;
        }
        EnrollmentResponse enrollmentResponse = (EnrollmentResponse) other;
        return Intrinsics.areEqual(this.process, enrollmentResponse.process) && Intrinsics.areEqual(this.tmxSessionId, enrollmentResponse.tmxSessionId);
    }

    public final EnrollmentProcess getProcess() {
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
        return "EnrollmentResponse(process=" + this.process + ", tmxSessionId=" + this.tmxSessionId + ")";
    }
}
