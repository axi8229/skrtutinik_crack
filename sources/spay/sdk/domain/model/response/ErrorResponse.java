package spay.sdk.domain.model.response;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lspay/sdk/domain/model/response/ErrorResponse;", "", "code", "", CrashHianalyticsData.MESSAGE, "", "errorData", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getErrorData", "()Ljava/lang/String;", "getMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ErrorResponse {
    private final int code;
    private final String errorData;
    private final String message;

    public ErrorResponse() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ ErrorResponse copy$default(ErrorResponse errorResponse, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = errorResponse.code;
        }
        if ((i2 & 2) != 0) {
            str = errorResponse.message;
        }
        if ((i2 & 4) != 0) {
            str2 = errorResponse.errorData;
        }
        return errorResponse.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorData() {
        return this.errorData;
    }

    public final ErrorResponse copy(int code, String message, String errorData) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new ErrorResponse(code, message, errorData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorResponse)) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) other;
        return this.code == errorResponse.code && Intrinsics.areEqual(this.message, errorResponse.message) && Intrinsics.areEqual(this.errorData, errorResponse.errorData);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorData() {
        return this.errorData;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iA = AbstractC1553e.a(this.message, Integer.hashCode(this.code) * 31, 31);
        String str = this.errorData;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ErrorResponse(code=");
        sb.append(this.code);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", errorData=");
        return Q1.a(sb, this.errorData, ')');
    }

    public ErrorResponse(int i, String message, String str) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = i;
        this.message = message;
        this.errorData = str;
    }

    public /* synthetic */ ErrorResponse(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : str2);
    }
}
