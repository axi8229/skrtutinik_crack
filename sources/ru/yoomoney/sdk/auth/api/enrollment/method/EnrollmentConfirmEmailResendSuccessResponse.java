package ru.yoomoney.sdk.auth.api.enrollment.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailResendSuccessResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailResendResponse;", "process", "Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "(Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/enrollment/model/EnrollmentProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnrollmentConfirmEmailResendSuccessResponse extends EnrollmentConfirmEmailResendResponse {

    @SerializedName("process")
    private final EnrollmentProcess process;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnrollmentConfirmEmailResendSuccessResponse(EnrollmentProcess process) {
        super(null);
        Intrinsics.checkNotNullParameter(process, "process");
        this.process = process;
    }

    public static /* synthetic */ EnrollmentConfirmEmailResendSuccessResponse copy$default(EnrollmentConfirmEmailResendSuccessResponse enrollmentConfirmEmailResendSuccessResponse, EnrollmentProcess enrollmentProcess, int i, Object obj) {
        if ((i & 1) != 0) {
            enrollmentProcess = enrollmentConfirmEmailResendSuccessResponse.process;
        }
        return enrollmentConfirmEmailResendSuccessResponse.copy(enrollmentProcess);
    }

    /* renamed from: component1, reason: from getter */
    public final EnrollmentProcess getProcess() {
        return this.process;
    }

    public final EnrollmentConfirmEmailResendSuccessResponse copy(EnrollmentProcess process) {
        Intrinsics.checkNotNullParameter(process, "process");
        return new EnrollmentConfirmEmailResendSuccessResponse(process);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EnrollmentConfirmEmailResendSuccessResponse) && Intrinsics.areEqual(this.process, ((EnrollmentConfirmEmailResendSuccessResponse) other).process);
    }

    public final EnrollmentProcess getProcess() {
        return this.process;
    }

    public int hashCode() {
        return this.process.hashCode();
    }

    public String toString() {
        return "EnrollmentConfirmEmailResendSuccessResponse(process=" + this.process + ")";
    }
}
