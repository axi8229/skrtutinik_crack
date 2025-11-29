package spay.sdk.domain.model.response.otp;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1687j9;
import npi.spay.AbstractC1854q1;
import npi.spay.C1488b9;
import npi.spay.C1513c9;
import npi.spay.C1538d9;
import npi.spay.C1563e9;
import npi.spay.C1588f9;
import npi.spay.C1613g9;
import npi.spay.C1638h9;
import npi.spay.C1663i9;
import npi.spay.C2097zk;
import npi.spay.Q1;
import ru.yoomoney.sdk.kassa.payments.R$string;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ0\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001b\u0010\n¨\u0006\u001f"}, d2 = {"Lspay/sdk/domain/model/response/otp/CreateOtpSdkResponseBody;", "", "Lnpi/spay/j9;", "toOneTimePasswordStatus", "()Lnpi/spay/j9;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "errorCode", "errorMessage", "mobilePhone", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lspay/sdk/domain/model/response/otp/CreateOtpSdkResponseBody;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getErrorCode", "Ljava/lang/String;", "getErrorMessage", "getMobilePhone", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "Companion", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final /* data */ class CreateOtpSdkResponseBody {
    private static final int ATTEMPTS_EXHAUSTED_CODE = 3;
    private static final int BUNDLE_NOT_FOUND_CODE = 127;
    private static final int ORDER_NOT_FOUND_CODE = 107;
    private static final int SUCCESS_CODE = 0;
    private static final int TIMEOUT_CODE = 4;
    private static final int VALIDATION_ERROR_CODE = 1;
    private static final int WRONG_BUNDLE_STATE_CODE = 8;
    private final int errorCode;
    private final String errorMessage;
    private final String mobilePhone;

    public CreateOtpSdkResponseBody(int i, String str, String mobilePhone) {
        Intrinsics.checkNotNullParameter(mobilePhone, "mobilePhone");
        this.errorCode = i;
        this.errorMessage = str;
        this.mobilePhone = mobilePhone;
    }

    public static /* synthetic */ CreateOtpSdkResponseBody copy$default(CreateOtpSdkResponseBody createOtpSdkResponseBody, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = createOtpSdkResponseBody.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = createOtpSdkResponseBody.errorMessage;
        }
        if ((i2 & 4) != 0) {
            str2 = createOtpSdkResponseBody.mobilePhone;
        }
        return createOtpSdkResponseBody.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMobilePhone() {
        return this.mobilePhone;
    }

    public final CreateOtpSdkResponseBody copy(int errorCode, String errorMessage, String mobilePhone) {
        Intrinsics.checkNotNullParameter(mobilePhone, "mobilePhone");
        return new CreateOtpSdkResponseBody(errorCode, errorMessage, mobilePhone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateOtpSdkResponseBody)) {
            return false;
        }
        CreateOtpSdkResponseBody createOtpSdkResponseBody = (CreateOtpSdkResponseBody) other;
        return this.errorCode == createOtpSdkResponseBody.errorCode && Intrinsics.areEqual(this.errorMessage, createOtpSdkResponseBody.errorMessage) && Intrinsics.areEqual(this.mobilePhone, createOtpSdkResponseBody.mobilePhone);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getMobilePhone() {
        return this.mobilePhone;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.errorCode) * 31;
        String str = this.errorMessage;
        return this.mobilePhone.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final AbstractC1687j9 toOneTimePasswordStatus() {
        int i = this.errorCode;
        if (i == 0) {
            return new C1563e9(this.mobilePhone);
        }
        if (i == 1) {
            String str = this.errorMessage;
            return new C1638h9(str != null ? AbstractC1854q1.a(str, "text", str) : new C2097zk(R$string.spay_create_otp_validation_error, CollectionsKt.emptyList()), this.mobilePhone);
        }
        if (i == 3) {
            String str2 = this.errorMessage;
            return new C1488b9(str2 != null ? AbstractC1854q1.a(str2, "text", str2) : new C2097zk(R$string.spay_create_otp_attempts_exhausted_error, CollectionsKt.emptyList()), this.mobilePhone);
        }
        if (i == 4) {
            String str3 = this.errorMessage;
            return new C1613g9(str3 != null ? AbstractC1854q1.a(str3, "text", str3) : new C2097zk(R$string.spay_create_otp_timeout_error, CollectionsKt.emptyList()), this.mobilePhone);
        }
        if (i == 8) {
            String str4 = this.errorMessage;
            return new C1663i9(str4 != null ? AbstractC1854q1.a(str4, "text", str4) : new C2097zk(R$string.spay_create_otp_wrong_bundle_state_error, CollectionsKt.emptyList()), this.mobilePhone);
        }
        if (i == 107) {
            String str5 = this.errorMessage;
            return new C1538d9(str5 != null ? AbstractC1854q1.a(str5, "text", str5) : new C2097zk(R$string.spay_create_otp_order_not_found_error, CollectionsKt.emptyList()), this.mobilePhone);
        }
        if (i != 127) {
            String str6 = this.errorMessage;
            return new C1588f9(str6 != null ? AbstractC1854q1.a(str6, "text", str6) : new C2097zk(R$string.spay_create_otp_system_or_internal_error, CollectionsKt.emptyList()), this.mobilePhone);
        }
        String str7 = this.errorMessage;
        return new C1513c9(str7 != null ? AbstractC1854q1.a(str7, "text", str7) : new C2097zk(R$string.spay_create_otp_bundle_not_found_error, CollectionsKt.emptyList()), this.mobilePhone);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateOtpSdkResponseBody(errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", mobilePhone=");
        return Q1.a(sb, this.mobilePhone, ')');
    }
}
