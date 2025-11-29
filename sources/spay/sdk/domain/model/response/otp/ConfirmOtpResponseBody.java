package spay.sdk.domain.model.response.otp;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1687j9;
import npi.spay.AbstractC1854q1;
import npi.spay.C1463a9;
import npi.spay.C2097zk;
import npi.spay.Q1;
import npi.spay.V8;
import npi.spay.W8;
import npi.spay.X8;
import npi.spay.Y8;
import npi.spay.Z8;
import ru.yoomoney.sdk.kassa.payments.R$string;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001d"}, d2 = {"Lspay/sdk/domain/model/response/otp/ConfirmOtpResponseBody;", "", "", "phone", "Lnpi/spay/j9;", "toOneTimePasswordStatus", "(Ljava/lang/String;)Lnpi/spay/j9;", "", "component1", "()I", "component2", "()Ljava/lang/String;", "errorCode", CrashHianalyticsData.MESSAGE, "copy", "(ILjava/lang/String;)Lspay/sdk/domain/model/response/otp/ConfirmOtpResponseBody;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getErrorCode", "Ljava/lang/String;", "getMessage", "<init>", "(ILjava/lang/String;)V", "Companion", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final /* data */ class ConfirmOtpResponseBody {
    private static final int ATTEMPTS_EXHAUSTED_CODE = 6;
    private static final int CODE_LIFETIME_EXPIRED = 9;
    private static final int SUCCESS_CODE = 0;
    private static final int VALIDATION_ERROR_CODE = 1;
    private static final int WRONG_CODE = 5;
    private final int errorCode;
    private final String message;

    public ConfirmOtpResponseBody(int i, String str) {
        this.errorCode = i;
        this.message = str;
    }

    public static /* synthetic */ ConfirmOtpResponseBody copy$default(ConfirmOtpResponseBody confirmOtpResponseBody, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = confirmOtpResponseBody.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = confirmOtpResponseBody.message;
        }
        return confirmOtpResponseBody.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ConfirmOtpResponseBody copy(int errorCode, String message) {
        return new ConfirmOtpResponseBody(errorCode, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfirmOtpResponseBody)) {
            return false;
        }
        ConfirmOtpResponseBody confirmOtpResponseBody = (ConfirmOtpResponseBody) other;
        return this.errorCode == confirmOtpResponseBody.errorCode && Intrinsics.areEqual(this.message, confirmOtpResponseBody.message);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.errorCode) * 31;
        String str = this.message;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final AbstractC1687j9 toOneTimePasswordStatus(String phone) {
        AbstractC1687j9 c1463a9;
        Intrinsics.checkNotNullParameter(phone, "phone");
        int i = this.errorCode;
        if (i == 0) {
            return new X8(phone);
        }
        if (i == 1) {
            String str = this.message;
            return new Z8(str != null ? AbstractC1854q1.a(str, "text", str) : new C2097zk(R$string.spay_otp_confirm_validation_error, CollectionsKt.emptyList()));
        }
        if (i == 5) {
            String str2 = this.message;
            c1463a9 = new C1463a9(str2 != null ? AbstractC1854q1.a(str2, "text", str2) : new C2097zk(R$string.spay_otp_confirm_wrong_code_error, CollectionsKt.emptyList()), phone);
        } else if (i == 6) {
            String str3 = this.message;
            c1463a9 = new V8(str3 != null ? AbstractC1854q1.a(str3, "text", str3) : new C2097zk(R$string.spay_otp_confirm_attempts_exhausted_error, CollectionsKt.emptyList()), phone);
        } else {
            if (i != 9) {
                String str4 = this.message;
                return new Y8(str4 != null ? AbstractC1854q1.a(str4, "text", str4) : new C2097zk(R$string.spay_otp_confirm_system_or_internal_error, CollectionsKt.emptyList()));
            }
            String str5 = this.message;
            c1463a9 = new W8(str5 != null ? AbstractC1854q1.a(str5, "text", str5) : new C2097zk(R$string.spay_otp_confirm_code_lifetime_expired_error, CollectionsKt.emptyList()), phone);
        }
        return c1463a9;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConfirmOtpResponseBody(errorCode=");
        sb.append(this.errorCode);
        sb.append(", message=");
        return Q1.a(sb, this.message, ')');
    }
}
