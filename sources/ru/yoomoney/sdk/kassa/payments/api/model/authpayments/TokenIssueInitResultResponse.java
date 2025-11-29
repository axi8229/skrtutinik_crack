package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/TokenIssueInitResultResponse;", "", "authContextId", "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthContextId", "()Ljava/lang/String;", "getProcessId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TokenIssueInitResultResponse {
    public static final int $stable = 0;
    private final String authContextId;
    private final String processId;

    public TokenIssueInitResultResponse(@JsonProperty("authContextId") String str, @JsonProperty(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) String processId) {
        Intrinsics.checkNotNullParameter(processId, "processId");
        this.authContextId = str;
        this.processId = processId;
    }

    public static /* synthetic */ TokenIssueInitResultResponse copy$default(TokenIssueInitResultResponse tokenIssueInitResultResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tokenIssueInitResultResponse.authContextId;
        }
        if ((i & 2) != 0) {
            str2 = tokenIssueInitResultResponse.processId;
        }
        return tokenIssueInitResultResponse.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAuthContextId() {
        return this.authContextId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProcessId() {
        return this.processId;
    }

    public final TokenIssueInitResultResponse copy(@JsonProperty("authContextId") String authContextId, @JsonProperty(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) String processId) {
        Intrinsics.checkNotNullParameter(processId, "processId");
        return new TokenIssueInitResultResponse(authContextId, processId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokenIssueInitResultResponse)) {
            return false;
        }
        TokenIssueInitResultResponse tokenIssueInitResultResponse = (TokenIssueInitResultResponse) other;
        return Intrinsics.areEqual(this.authContextId, tokenIssueInitResultResponse.authContextId) && Intrinsics.areEqual(this.processId, tokenIssueInitResultResponse.processId);
    }

    public final String getAuthContextId() {
        return this.authContextId;
    }

    public final String getProcessId() {
        return this.processId;
    }

    public int hashCode() {
        String str = this.authContextId;
        return this.processId.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public String toString() {
        return "TokenIssueInitResultResponse(authContextId=" + this.authContextId + ", processId=" + this.processId + ")";
    }
}
