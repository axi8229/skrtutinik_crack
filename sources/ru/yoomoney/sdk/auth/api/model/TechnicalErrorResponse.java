package ru.yoomoney.sdk.auth.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/TechnicalErrorResponse;", "Lru/yoomoney/sdk/auth/api/model/ErrorResponse;", "retryAfter", "", "(Ljava/lang/Long;)V", "getRetryAfter", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lru/yoomoney/sdk/auth/api/model/TechnicalErrorResponse;", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TechnicalErrorResponse extends ErrorResponse {

    @SerializedName("retryAfter")
    private final Long retryAfter;

    public TechnicalErrorResponse(Long l) {
        super(null);
        this.retryAfter = l;
    }

    public static /* synthetic */ TechnicalErrorResponse copy$default(TechnicalErrorResponse technicalErrorResponse, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = technicalErrorResponse.retryAfter;
        }
        return technicalErrorResponse.copy(l);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getRetryAfter() {
        return this.retryAfter;
    }

    public final TechnicalErrorResponse copy(Long retryAfter) {
        return new TechnicalErrorResponse(retryAfter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TechnicalErrorResponse) && Intrinsics.areEqual(this.retryAfter, ((TechnicalErrorResponse) other).retryAfter);
    }

    public final Long getRetryAfter() {
        return this.retryAfter;
    }

    public int hashCode() {
        Long l = this.retryAfter;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public String toString() {
        return "TechnicalErrorResponse(retryAfter=" + this.retryAfter + ")";
    }
}
